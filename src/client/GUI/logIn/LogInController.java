package client.GUI.logIn;

/**
 * Sample Skeleton for 'logIn.fxml' Controller Class
 */

import client.GUI.homeWindow.HomeWindowController;
import client.GUI.registration.RegistrationController;
import client.Objects.User;
import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class LogInController {

    @FXML // fx:id="loginField"
    private TextField loginField; // Value injected by FXMLLoader

    @FXML // fx:id="passwordField"
    private PasswordField passwordField; // Value injected by FXMLLoader

    @FXML // fx:id="logInButton"
    private Button logInButton; // Value injected by FXMLLoader

    @FXML // fx:id="registrButton"
    private Button registrButton; // Value injected by FXMLLoader

    @FXML // fx:id="passLabel"
    private Label passLabel; // Value injected by FXMLLoader

    @FXML // fx:id="finalLabel"
    private Label finalLabel; // Value injected by FXMLLoader

    @FXML // fx:id="loginLabel"
    private Label loginLabel; // Value injected by FXMLLoader

    @FXML
    private void logIn(ActionEvent event) {
        int flag = 0;
        if ("".equals(loginField.getText())) {
            loginLabel.setText("Введите логин");
            flag++;
        } else loginLabel.setText("");
        if ("".equals(passwordField.getText())) {
            passLabel.setText("Введите пароль");
            flag++;
        } else passLabel.setText("");
        if (flag == 0) {
            try {
                bw.write("авторизация");
                bw.newLine();
                bw.flush();

                User user = new User();
                user.setLogin(loginField.getText().trim().toLowerCase());
                user.setPassword(passwordField.getText().trim().toLowerCase());

                Gson gson = new Gson();
                String gsonString = gson.toJson(user);

                bw.write(gsonString);
                bw.newLine();
                bw.flush();

                String response = br.readLine();
                if(response.equals("200")){
                    System.out.println("status 200 ok");
                    logInButton.getScene().getWindow().hide();

                    FXMLLoader fxmlLoader = new FXMLLoader(HomeWindowController.class.getResource("homeWindow.fxml"));

                    HomeWindowController homeWindowController = new HomeWindowController(bw,br);
                    fxmlLoader.setController(homeWindowController);

                    fxmlLoader.load();
                    Parent root = fxmlLoader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Прогнозирование устойчивости предприятия");
                    stage.showAndWait();
                }
                else if(response.equals("500")){
                    finalLabel.setText("Логин или пароль введены неверно");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void registration(ActionEvent event) {
        registrButton.getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(RegistrationController.class.getResource("registration.fxml"));

        RegistrationController registrationController = new RegistrationController(bw,br);
        fxmlLoader.setController(registrationController);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = fxmlLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Прогнозирование устойчивости предприятия");
        stage.showAndWait();
    }

    Socket socket;
    BufferedWriter bw;
    BufferedReader br;

    public LogInController() {
        try {
            socket = new Socket("localhost", 8080);
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

