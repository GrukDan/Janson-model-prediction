/**
 * Sample Skeleton for 'homeWindow.fxml' Controller Class
 */

package client.GUI.homeWindow;

import client.GUI.dataControll.DataController;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class HomeWindowController {

    @FXML // fx:id="accControlButton"
    private Button accControlButton; // Value injected by FXMLLoader

    @FXML // fx:id="dbControlButton"
    private Button dbControlButton; // Value injected by FXMLLoader

    @FXML // fx:id="liquidButton"
    private Button liquidButton; // Value injected by FXMLLoader

    @FXML // fx:id="activityButton"
    private Button activityButton; // Value injected by FXMLLoader

    @FXML // fx:id="exitButton"
    private Button exitButton; // Value injected by FXMLLoader

    BufferedWriter bw;
    BufferedReader br;
    Gson gson;

    public HomeWindowController(BufferedWriter bufferedWriter, BufferedReader bufferedReader){
        this.bw = bufferedWriter;
        this.br = bufferedReader;
        this.gson = new Gson();
    }


    public void dbControl(javafx.event.ActionEvent actionEvent) {
       // dbControlButton.getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(DataController.class.getResource("data.fxml"));

        DataController dataController = new DataController(bw,br);
        fxmlLoader.setController(dataController);

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
}

