package server.Controller;

import client.Objects.User;
import com.google.gson.Gson;
import server.database.DatabaseHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.ResultSet;

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
                        String line=br.readLine();
                        User user = gson.fromJson(line, User.class);
                        System.out.println(user.toString());
                        ResultSet resultSet = dbHandler.getUserByLoginAndPassword(user.getLogin(),user.getPassword());
                        if(resultSet == null){
                            System.out.println("Ошибка авторизации пользователя");
                            bw.write("500"); //пользователь с таким логином и паролем не найден
                            bw.newLine();bw.flush();
                        }
                        else{
                            System.out.println("Пользователь " + user.getLogin() + " авторизовался");
                            bw.write("200"); //пользователь с таким логином и паролем авторизовался
                            bw.newLine();bw.flush();
                        }
                        break;
                    }
                    case "регистрация": {
                        String line=br.readLine();
                        User user = gson.fromJson(line, User.class);
                        System.out.println(user.toString());
                        dbHandler.registrationUser(user);
                        break;
                    }
                    case "добавление":{

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            dbHandler.closeConnection();
        }
    }
}
