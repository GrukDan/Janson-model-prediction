package server.Controller;

import server.database.entities.User;
import com.google.gson.Gson;
import server.database.DatabaseHandler;
import server.database.entities.Record;
import server.database.entities.Result;
import server.yansonModel.CoefficientCalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class RequestController {

    BufferedWriter bw;
    BufferedReader br;
    Gson gson;

    public RequestController(BufferedWriter bufferedWriter, BufferedReader bufferedReader) {
        this.bw = bufferedWriter;
        this.br = bufferedReader;
        this.gson = new Gson();
    }


    public void requestHandler() throws RuntimeException {
        try {
            while (true) {
                String request = br.readLine();
                switch (request) {
                    case "авторизация": {
                        String line = br.readLine();
                        User user = gson.fromJson(line, User.class);
                        User userResponse = DatabaseHandler.getDbHandler().getUserByLoginAndPassword(user.getLogin(), user.getPassword());
                        if (userResponse == null) {
                            System.out.println("Ошибка авторизации пользователя");
                        } else {
                            System.out.println("Пользователь " + user.getName() + " " + user.getSurname() + " авторизовался");
                        }
                        bw.write(gson.toJson(userResponse));
                        bw.newLine();
                        bw.flush();
                        break;
                    }
                    case "регистрация": {
                        String line = br.readLine();
                        User user = gson.fromJson(line, User.class);
                        if (DatabaseHandler.getDbHandler().registrationUser(user)) {
                            System.out.println("Пользователь добавлен:" + user.toString());
                            bw.write("200");
                            bw.newLine();
                            bw.flush();
                        } else {
                            System.out.println("Ошибка добавления:" + user.toString());
                            bw.write("500");
                            bw.newLine();
                            bw.flush();
                        }
                        break;
                    }
                    case "редактирование аккаунта": {
                        String line = br.readLine();
                        User user = gson.fromJson(line, User.class);
                        user = DatabaseHandler.getDbHandler().updateUserByIdAndLogin(user);

                        if(user == null){
                            bw.write("404");
                            bw.newLine();
                            bw.flush();

                            bw.write(gson.toJson(user));
                            bw.newLine();
                            bw.flush();
                        }
                        else{
                            bw.write("200");
                            bw.newLine();
                            bw.flush();

                            bw.write(gson.toJson(user));
                            bw.newLine();
                            bw.flush();
                        }
                        break;
                    }
                    case "удаление аккаунта": {
                        String line = br.readLine();
                        User user = gson.fromJson(line, User.class);
                        DatabaseHandler.getDbHandler().deleteUserById(user.getId().intValue());
                        break;
                    }
                    case "сохранение": {
                        String line = br.readLine();
                        List<Record> records = Arrays.asList(gson.fromJson(line, Record[].class));
                        DatabaseHandler.getDbHandler().saveData(records);
                        break;
                    }
                    case "получение": {
                        List<Record> records = DatabaseHandler.getDbHandler().getAll();
                        Record[] recordsArray = new Record[records.size()];
                        records.toArray(recordsArray);
                        String gsonRecords = gson.toJson(recordsArray);
                        bw.write(gsonRecords);
                        bw.newLine();
                        bw.flush();
                        break;
                    }
                    case "получение дат": {
                        List<Record> records = DatabaseHandler.getDbHandler().getAllDate();
                        Record[] recordsArray = new Record[records.size()];
                        records.toArray(recordsArray);
                        String gsonRecords = gson.toJson(recordsArray);
                        bw.write(gsonRecords);
                        bw.newLine();
                        bw.flush();
                        break;
                    }
                    case "получение данных по выборке": {
                        String resultRequest = br.readLine();
                        Result result = gson.fromJson(resultRequest,Result.class);

                        List<Record> records = DatabaseHandler.getDbHandler().getAllInBetween(result.getBeginDate(),result.getEndDate());
                        Record[] recordsArray = new Record[records.size()];
                        records.toArray(recordsArray);
                        CoefficientCalculator coefficientCalculator = new CoefficientCalculator();
                        Result newResult = coefficientCalculator.findValues(recordsArray,result);
                        System.out.println(newResult);

                        String gsonResult = gson.toJson(newResult);
                        bw.write(gsonResult);
                        bw.newLine();
                        bw.flush();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DatabaseHandler.getDbHandler().closeConnection();
        }
    }
}
