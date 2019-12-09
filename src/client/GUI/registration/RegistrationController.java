/**
 * Sample Skeleton for 'registration.fxml' Controller Class
 */

package client.GUI.registration;

import client.GUI.Account;
import client.Objects.Transfer;

import client.Objects.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {

    @FXML // fx:id="loginField"
    private TextField loginField; // Value injected by FXMLLoader

    @FXML // fx:id="passwordField"
    private PasswordField passwordField; // Value injected by FXMLLoader

    @FXML // fx:id="logInButton"
    private Button logInButton; // Value injected by FXMLLoader

    @FXML // fx:id="surnameField"
    private TextField surnameField; // Value injected by FXMLLoader

    @FXML // fx:id="nameField"
    private TextField nameField; // Value injected by FXMLLoader

    @FXML // fx:id="nameLabel"
    private Label nameLabel; // Value injected by FXMLLoader

    @FXML // fx:id="loginLabel"
    private Label loginLabel; // Value injected by FXMLLoader

    @FXML // fx:id="surnameLabel"
    private Label surnameLabel; // Value injected by FXMLLoader

    @FXML // fx:id="passwordLabel"
    private Label passwordLabel; // Value injected by FXMLLoader


    public RegistrationController(){}

    public void registration(ActionEvent event) {
        int flag = 0;
        if (nameField.getText().trim().equalsIgnoreCase("")) {
            nameLabel.setText("Введите имя");
        } else {
            if(nameField.getText().trim().matches("^[a-zA-Z[а-яА-Я]]*$")){
                nameLabel.setText("");
               }
           else {
                flag++;
               nameLabel.setText("Имя введено некорректно");
            }
        }
        if (surnameField.getText().trim().equalsIgnoreCase("")) {
            surnameLabel.setText("Введите фамилию");
        } else {
            if(surnameField.getText().trim().matches("^[a-zA-Z[а-яА-Я]]*$")){
                surnameLabel.setText("");
                }
            else {
                flag++;
                surnameLabel.setText("Фамилия введена некорректно");
            }
        }
        if (loginField.getText().trim().equals("")) {
            loginLabel.setText("Введите логин");
        } else {
            if(loginField.getText().trim().matches("^[A-Za-z]([.A-Za-z0-9-]{1,18})([A-Za-z0-9])$")){
                loginLabel.setText("");
                }
            else {
                flag++;
                loginLabel.setText("Логин введен некорректно");
            }
        }
        if (passwordField.getText().trim().equalsIgnoreCase("")) {
            passwordLabel.setText("Введите пароль");
        } else {
            if(passwordField.getText().trim().matches("^[A-Za-z]([.A-Za-z0-9-]{1,18})([A-Za-z0-9])$")){
                passwordLabel.setText("");
                }
            else {
                flag++;
                passwordLabel.setText("Пароль введен некорректно");
            }
        }

        if (flag == 0) {
            try {
                Transfer.getBw().write("регистрация");
                Transfer.getBw().newLine();
                Transfer.getBw().flush();

                User user = new User();
                user.setName(nameField.getText());
                user.setSurname(surnameField.getText());
                user.setRole("user");
                user.setLogin(loginField.getText());
                user.setPassword(passwordField.getText());

                String gsonUser = Transfer.getGson().toJson(user);

                Transfer.getBw().write(gsonUser);
                Transfer.getBw().newLine();
                Transfer.getBw().flush();

                String response = Transfer.getBr().readLine();
                if (response.trim().equalsIgnoreCase("200")) {
                    Account.setAccount(user);
                    logInButton.getScene().getWindow().hide();
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("../homeWindow/homeWindow.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Прогнозирование устойчивости предприятия");
                    stage.setScene(scene);
                    stage.show();
                } else {
                    passwordLabel.setText("Измените логин или пароль!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

