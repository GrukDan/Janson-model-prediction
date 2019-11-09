/**
 * Sample Skeleton for 'registration.fxml' Controller Class
 */

package client.GUI.registration;

import client.Objects.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class RegistrationController  {

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


    BufferedWriter bw;
    BufferedReader br;
    Gson gson;

    public RegistrationController(BufferedWriter bufferedWriter, BufferedReader bufferedReader){
        this.bw = bufferedWriter;
        this.br = bufferedReader;
        this.gson = new Gson();
    }

   public void registration(ActionEvent event){
        int flag = 0;
        if(nameField.getText().trim().equalsIgnoreCase("")){
            nameLabel.setText("Введите имя");
            flag++;
        }else nameLabel.setText("");
       if(surnameField.getText().trim().equalsIgnoreCase("")){
           nameLabel.setText("Введите фамилию");
           flag++;
       }else surnameLabel.setText("");
       if(loginField.getText().trim().equalsIgnoreCase("")){
           loginLabel.setText("Введите логин");
           flag++;
       }else loginLabel.setText("");
       if(passwordField.getText().trim().equalsIgnoreCase("")){
           passwordLabel.setText("Введите пароль");
           flag++;
       }else passwordLabel.setText("");

        if(flag==0) {
            try {
                bw.write("регистрация");
                bw.newLine();
                bw.flush();

                String gsonUser = gson.toJson(
                        new User(nameField.getText(),
                        surnameField.getText(),"user",
                        loginField.getText(),passwordField.getText()));

                bw.write(gsonUser);
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
   }

}

