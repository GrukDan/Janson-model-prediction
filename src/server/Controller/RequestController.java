package server.Controller;

import client.Objects.User;
import com.google.gson.Gson;
import server.database.DatabaseHandler;
import server.database.entities.Record;
import server.database.entities.Result;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class RequestController {

    BufferedWriter bw;
    BufferedReader br;
    Gson gson;
    DatabaseHandler dbHandler;


    public RequestController(BufferedWriter bufferedWriter, BufferedReader bufferedReader) {
        this.bw = bufferedWriter;
        this.br = bufferedReader;
        this.dbHandler = new DatabaseHandler();
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
                        System.out.println(user.toString());
                        User userResponse = dbHandler.getUserByLoginAndPassword(user.getLogin(), user.getPassword());
                        if (userResponse == null) {
                            System.out.println("Ошибка авторизации пользователя");
                            bw.write("500"); //пользователь с таким логином и паролем не найден
                            bw.newLine();
                            bw.flush();
                        } else {
                            System.out.println("Пользователь " + user.getLogin() + " авторизовался");
                            bw.write("200"); //пользователь с таким логином и паролем авторизовался
                            bw.newLine();
                            bw.flush();
                        }
                        break;
                    }
                    case "регистрация": {
                        String line = br.readLine();
                        User user = gson.fromJson(line, User.class);
                        if (dbHandler.registrationUser(user)) {
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
                    case "сохранение": {
                        String line = br.readLine();
                        List<Record> records = Arrays.asList(gson.fromJson(line, Record[].class));
                        dbHandler.saveData(records);
                        break;
                    }
                    case "получение": {
                        List<Record> records = dbHandler.getAll();
                        Record[] recordsArray = new Record[records.size()];
                        records.toArray(recordsArray);
                        String gsonRecords = gson.toJson(recordsArray);
                        bw.write(gsonRecords);
                        bw.newLine();
                        bw.flush();
                        break;
                    }
                    case "получение дат": {
                        List<Record> records = dbHandler.getAllDate();
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

                        List<Record> records = dbHandler.getAllInBetween(result.getBeginDate(),result.getEndDate());
                        Record[] recordsArray = new Record[records.size()];
                        records.toArray(recordsArray);
                        for(Record record:recordsArray){
                            System.out.println();
                            System.out.println(record);
                        }
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            dbHandler.closeConnection();
        }
    }
}
