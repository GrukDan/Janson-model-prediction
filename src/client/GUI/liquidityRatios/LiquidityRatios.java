/**
 * Sample Skeleton for 'LiquidityRatios.fxml' Controller Class
 */

package client.GUI.liquidityRatios;

import client.GUI.homeWindow.HomeWindowController;
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

public class LiquidityRatios {

    @FXML // fx:id="utoshnKoeffLikvidnostiButton"
    private Button utoshnKoeffLikvidnostiButton; // Value injected by FXMLLoader

    @FXML // fx:id="obshiKoeffLikvidnostiButton"
    private Button obshiKoeffLikvidnostiButton; // Value injected by FXMLLoader

    @FXML // fx:id="koeffAbsolytnyLikvidnostiButton"
    private Button koeffAbsolytnyLikvidnostiButton; // Value injected by FXMLLoader

    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    public LiquidityRatios() {
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

    public void koeffAbsolytnyLikvidnosti(ActionEvent actionEvent) {
    }

    public void obshiKoeffLikvidnosti(ActionEvent actionEvent) {
    }

    public void utoshnKoeffLikvidnosti(ActionEvent actionEvent) {
    }
}
