/**
 * Sample Skeleton for 'homeWindow.fxml' Controller Class
 */

package client.GUI.homeWindow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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


    public HomeWindowController() {
    }

    @FXML
    public void dbControl(javafx.event.ActionEvent actionEvent) {
        dbControlButton.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../dataControll/data.fxml"));
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

    @FXML
    public void exit(ActionEvent actionEvent) {
        exitButton.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../logIn/logIn.fxml"));
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

    @FXML
    public void businessPerformance(ActionEvent actionEvent) {
        liquidButton.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../businessPerformance/BusinessPerformance.fxml"));
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


    @FXML
    public void liquidityRatios(ActionEvent actionEvent) {
        liquidButton.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../liquidityRatios/LiquidityRatios.fxml"));
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

    public void accountManagment(ActionEvent actionEvent) {

        accControlButton.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../accountManagement/AccountManagement.fxml"));
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
}

