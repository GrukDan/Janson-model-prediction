/**
 * Sample Skeleton for 'BusinessPerformance.fxml' Controller Class
 */

package client.GUI.businessPerformance;

import client.GUI.homeWindow.HomeWindowController;
import client.Objects.Transfer;
import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class BusinessPerformance {

    @FXML // fx:id="koeffNezavisimostiButton"
    private Button koeffNezavisimostiButton; // Value injected by FXMLLoader

    @FXML // fx:id="koeffFinansButton"
    private Button koeffFinansButton; // Value injected by FXMLLoader

    @FXML // fx:id="koeffFinUstoishButton"
    private Button koeffFinUstoishButton; // Value injected by FXMLLoader

    @FXML // fx:id="koeffInvestirovButton"
    private Button koeffInvestirovButton; // Value injected by FXMLLoader

    @FXML // fx:id="koeffInvestSobstvInvestButton"
    private Button koeffInvestSobstvInvestButton; // Value injected by FXMLLoader

    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    public void koeffNezavisimosti(ActionEvent actionEvent) {
        koeffNezavisimostiButton.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("coefficients/coefficientOfIndependence/CoefficientOfIndependence.fxml"));
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

    public void koeffFinans(ActionEvent actionEvent) {
    }

    public void koeffFinUstoish(ActionEvent actionEvent) {
    }

    public void koeffInvestirov(ActionEvent actionEvent) {
    }

    public void koeffInvestSobstvInvest(ActionEvent actionEvent) {
    }

    public void back(ActionEvent actionEvent) {
        backButton.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../homeWindow/homeWindow.fxml"));
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

    public BusinessPerformance() {
    }


}
