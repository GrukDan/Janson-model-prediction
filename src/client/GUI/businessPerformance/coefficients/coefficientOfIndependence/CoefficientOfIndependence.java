package client.GUI.businessPerformance.coefficients.coefficientOfIndependence;


import client.Objects.Record;
import client.Objects.Result;
import client.Objects.Transfer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class CoefficientOfIndependence implements Initializable {

    @FXML // fx:id="lineChart"
    private LineChart<Double, Double> lineChart; // Value injected by FXMLLoader

    @FXML // fx:id="activeAndPassiveTable"
    private TableView<Double> activeAndPassiveTable; // Value injected by FXMLLoader

    @FXML // fx:id="dateBegin"
    private ListView<Date> dateBegin; // Value injected by FXMLLoader

    @FXML // fx:id="dateEnd"
    private ListView<Date> dateEnd; // Value injected by FXMLLoader

    @FXML // fx:id="activeCol"
    private TableColumn<Result, Double> activeCol; // Value injected by FXMLLoader

    @FXML // fx:id="passiveCol"
    private TableColumn<Result, Double> passiveCol; // Value injected by FXMLLoader

    @FXML // fx:id="relativeCol"
    private TableColumn<Result, Double> relativeCol; // Value injected by FXMLLoader

    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    @FXML // fx:id="prognosisButton"
    private Button prognosisButton; // Value injected by FXMLLoader

    @FXML // fx:id="periodField"
    private TextField periodField; // Value injected by FXMLLoader

    @FXML // fx:id="resultViewList"
    private ListView<?> resultViewList; // Value injected by FXMLLoader

    @FXML // fx:id="infoLabel"
    private Label infoLabel; // Value injected by FXMLLoader

    @FXML
    void back(ActionEvent event) {
        backButton.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../../BusinessPerformance.fxml"));
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
    void prognosisAction(ActionEvent event) {

        Date startDate = dateBegin.getSelectionModel().getSelectedItem();
        Date finishDate = dateEnd.getSelectionModel().getSelectedItem();

        if (startDate == null) {
            infoLabel.setText("Дата начала выборки не выбрана!");
        } else {
            infoLabel.setText("");
            if (finishDate == null) {
                infoLabel.setText("Дата окончания выборки не выбрана!");
            } else {
                infoLabel.setText("");

                if (finishDate.getTime() < startDate.getTime()) {
                    infoLabel.setText("Дата окночания выбрана не верно!");
                } else {
                    infoLabel.setText("");

                    Result result = new Result();
                    result.setBeginDate(startDate);
                    result.setEndDate(finishDate);
                    result.setCoefficient("Коэффицент независимости");
                    try {

                        Transfer.getBw().write("получение данных по выборке");
                        Transfer.getBw().newLine();
                        Transfer.getBw().flush();

                        Transfer.getBw().write(Transfer.getGson().toJson(result));
                        Transfer.getBw().newLine();
                        Transfer.getBw().flush();

                        //String gsonResponse = Transfer.getBr().readLine();
                        //records = Transfer.getGson().fromJson(gsonResponse, Record[].class);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }


    Record[] records;
    ObservableList<Date> startOfSamplingList;
    ObservableList<Date> endOfSamplingList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        activeCol.setCellValueFactory(new PropertyValueFactory<Result, Double>("active"));
        passiveCol.setCellValueFactory(new PropertyValueFactory<Result, Double>("passive"));
        relativeCol.setCellValueFactory(new PropertyValueFactory<Result, Double>("relation"));

        try {
            Transfer.getBw().write("получение дат");
            Transfer.getBw().newLine();
            Transfer.getBw().flush();

            String gsonResponse = Transfer.getBr().readLine();
            Record[] records = Transfer.getGson().fromJson(gsonResponse, Record[].class);

            if (records.length == 0) {
                infoLabel.setText("Отсутствуют данные!");
            } else {
                startOfSamplingList = FXCollections.observableArrayList();
                endOfSamplingList = FXCollections.observableArrayList();

                for (Record record : records) {
                    startOfSamplingList.add(record.getDate());
                    endOfSamplingList.add(record.getDate());
                }
                dateBegin.setItems(startOfSamplingList);
                dateEnd.setItems(endOfSamplingList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
