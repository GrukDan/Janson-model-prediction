/**
 * Sample Skeleton for 'AccountManagement.fxml' Controller Class
 */

package client.GUI.accountManagement;

import client.GUI.Account;
import client.Objects.Transfer;
import client.Objects.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccountManagement implements Initializable {

    @FXML // fx:id="loginField"
    private TextField loginField; // Value injected by FXMLLoader


    @FXML // fx:id="saveButton"
    private Button saveButton; // Value injected by FXMLLoader

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

    @FXML // fx:id="infoLabel"
    private Label infoLabel; // Value injected by FXMLLoader

    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    @FXML // fx:id="deleteButton"
    private Button deleteButton; // Value injected by FXMLLoader


    public AccountManagement() {
    }

    public void saveAction(ActionEvent actionEvent) {

        if(isVoidField()) {
            User newUser = new User();
            newUser.setId(Account.getAccount().getId());
            newUser.setName(nameField.getText().trim());
            newUser.setSurname(surnameField.getText().trim());
            newUser.setLogin(loginField.getText().trim());

            try {
                Transfer.getBw().write("редактирование аккаунта");
                Transfer.getBw().newLine();
                Transfer.getBw().flush();

                Transfer.getBw().write(Transfer.getGson().toJson(newUser));
                Transfer.getBw().newLine();
                Transfer.getBw().flush();

                String response = Transfer.getBr().readLine();
                String user = Transfer.getBr().readLine();
                if (response.equals("200")) {
                    Account.setAccount(Transfer.getGson().fromJson(user, User.class));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Аккаунт изменен!");
                    alert.setContentText("Ваши персональные данные изменены!");
                    alert.showAndWait();

                    saveButton.getScene().getWindow().hide();
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("../homeWindow/HomeWindow.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Прогнозирование устойчивости предприятия");
                    stage.setScene(scene);
                    stage.show();

                } else {
                    infoLabel.setText("Редактирование невозможно!");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public boolean isVoidField() {
        if (!nameField.getText().trim().equalsIgnoreCase("")) {
            nameLabel.setText("");
            if (!surnameField.getText().trim().equalsIgnoreCase("")) {
                surnameLabel.setText("");
                if (!loginField.getText().trim().equalsIgnoreCase("")) {
                    loginLabel.setText("");
                    if (isValidField()) return true;
                } else loginLabel.setText("Введите логин!");
            } else surnameLabel.setText("Введите фамилию!");
        } else {
            nameLabel.setText("Введите имя!");
        }
        return false;
    }

    public boolean isValidField() {
        if (nameField.getText().matches("^[a-zA-Z[а-яА-Я]]*$")) {
            if (surnameField.getText().matches("^[a-zA-Z[а-яА-Я]]*$")) {
                if (loginField.getText().matches("^[A-Za-z]([.A-Za-z0-9-]{1,18})([A-Za-z0-9])$")) {
                    return true;
                } else {
                    loginLabel.setText("Введенный логин не корректен");
                }
            } else {
                surnameLabel.setText("Введенная фамилия не корректна");
            }
        } else {
            nameLabel.setText("Введенное имя не корректно");
        }
        return false;
    }

    public void backAction(ActionEvent actionEvent) {
        backButton.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../homeWindow/HomeWindow.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Прогнозирование устойчивости предприятия");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteAction(ActionEvent actionEvent) {
        try {

            Transfer.getBw().write("удаление аккаунта");
            Transfer.getBw().newLine();
            Transfer.getBw().flush();

            Transfer.getBw().write(Transfer.getGson().toJson(Account.getAccount()));
            Transfer.getBw().newLine();
            Transfer.getBw().flush();

            deleteButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../logIn/logIn.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Прогнозирование устойчивости предприятия");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameField.setText(Account.getAccount().getName());
        surnameField.setText(Account.getAccount().getSurname());
        loginField.setText(Account.getAccount().getLogin());
    }
}
