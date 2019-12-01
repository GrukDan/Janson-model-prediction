package client.GUI.dataControll;

import client.GUI.homeWindow.HomeWindowController;
import client.Objects.Record;
import client.Objects.Transfer;
import client.Objects.User;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.*;

public class DataController implements Initializable {

    // private ObservableList<Record> list = FXCollections.observableArrayList();

    @FXML // fx:id="table"
    private TableView<Record> table; // Value injected by FXMLLoader

    @FXML // fx:id="colDate"
    private TableColumn<Record, Date> colDate; // Value injected by FXMLLoader

    @FXML // fx:id="colKacca"
    private TableColumn<Record, Double> colKacca; // Value injected by FXMLLoader

    @FXML // fx:id="colRaschChet"
    private TableColumn<Record, Double> colRaschChet; // Value injected by FXMLLoader

    @FXML // fx:id="colValChet"
    private TableColumn<Record, Double> colValChet; // Value injected by FXMLLoader

    @FXML // fx:id="colUstavCapital"
    private TableColumn<Record, Double> colUstavCapital; // Value injected by FXMLLoader

    @FXML // fx:id="colNeraspPrib"
    private TableColumn<Record, Double> colNeraspPrib; // Value injected by FXMLLoader

    @FXML // fx:id="colReserv"
    private TableColumn<Record, Double> colReserv; // Value injected by FXMLLoader

    @FXML // fx:id="colAmmortFond"
    private TableColumn<Record, Double> colAmmortFond; // Value injected by FXMLLoader

    @FXML // fx:id="colDebit"
    private TableColumn<Record, Double> colDebit; // Value injected by FXMLLoader

    @FXML // fx:id="colZennyiBumagi"
    private TableColumn<Record, Double> colZennyiBumagi; // Value injected by FXMLLoader

    @FXML // fx:id="colKratkDolg"
    private TableColumn<Record, Double> colKratkDolg; // Value injected by FXMLLoader

    @FXML // fx:id="colDolgDolg"
    private TableColumn<Record, Double> colDolgDolg; // Value injected by FXMLLoader

    @FXML // fx:id="colValutaNetto"
    private TableColumn<Record, Double> colValutaNetto; // Value injected by FXMLLoader

    @FXML // fx:id="colOsnSredstva"
    private TableColumn<Record, Double> colOsnSredstva; // Value injected by FXMLLoader

    @FXML // fx:id="colDrugieInvest"
    private TableColumn<Record, Double> colDrugieInvest; // Value injected by FXMLLoader

    @FXML // fx:id="kacca"
    private TextField kacca; // Value injected by FXMLLoader

    @FXML // fx:id="date"
    private DatePicker date; // Value injected by FXMLLoader

    @FXML // fx:id="valytnyShet"
    private TextField valytnyShet; // Value injected by FXMLLoader

    @FXML // fx:id="raschetShet"
    private TextField raschetShet; // Value injected by FXMLLoader

    @FXML // fx:id="ustavCapital"
    private TextField ustavCapital; // Value injected by FXMLLoader

    @FXML // fx:id="neraspredPrib"
    private TextField neraspredPrib; // Value injected by FXMLLoader

    @FXML // fx:id="reservy"
    private TextField reservy; // Value injected by FXMLLoader

    @FXML // fx:id="ammortFond"
    private TextField ammortFond; // Value injected by FXMLLoader

    @FXML // fx:id="debit"
    private TextField debit; // Value injected by FXMLLoader

    @FXML // fx:id="zennyiBumagi"
    private TextField zennyiBumagi; // Value injected by FXMLLoader

    @FXML // fx:id="kratkDolgi"
    private TextField kratkDolgi; // Value injected by FXMLLoader

    @FXML // fx:id="dolgDolgi"
    private TextField dolgDolgi; // Value injected by FXMLLoader

    @FXML // fx:id="valytBalansNetto"
    private TextField valytBalansNetto; // Value injected by FXMLLoader

    @FXML // fx:id="osnovSredstva"
    private TextField osnovSredstva; // Value injected by FXMLLoader

    @FXML // fx:id="drugiyeInvest"
    private TextField drugiyeInvest; // Value injected by FXMLLoader

    @FXML // fx:id="infoLabel"
    private Label infoLabel; // Value injected by FXMLLoader

    @FXML // fx:id="addButton"
    private Button addButton; // Value injected by FXMLLoader

    @FXML // fx:id="saveButton"
    private Button saveButton; // Value injected by FXMLLoader

    @FXML // fx:id="deleteButton"
    private Button deleteButton; // Value injected by FXMLLoader

    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            colDate.setCellValueFactory(new PropertyValueFactory<Record, Date>("date"));
            colKacca.setCellValueFactory(new PropertyValueFactory<Record, Double>("cash"));
            colRaschChet.setCellValueFactory(new PropertyValueFactory<Record, Double>("paymentAccount"));
            colValChet.setCellValueFactory(new PropertyValueFactory<Record, Double>("currencyAccount"));
            colUstavCapital.setCellValueFactory(new PropertyValueFactory<Record, Double>("authorizedCapital"));
            colNeraspPrib.setCellValueFactory(new PropertyValueFactory<Record, Double>("undesterbutedProfits"));
            colReserv.setCellValueFactory(new PropertyValueFactory<Record, Double>("reserves"));
            colAmmortFond.setCellValueFactory(new PropertyValueFactory<Record, Double>("sinkingFund"));
            colDebit.setCellValueFactory(new PropertyValueFactory<Record, Double>("accountsReceivable"));
            colZennyiBumagi.setCellValueFactory(new PropertyValueFactory<Record, Double>("securites"));
            colKratkDolg.setCellValueFactory(new PropertyValueFactory<Record, Double>("shorttermDebt"));
            colDolgDolg.setCellValueFactory(new PropertyValueFactory<Record, Double>("longtermDebt"));
            colValutaNetto.setCellValueFactory(new PropertyValueFactory<Record, Double>("netBalanceCurrency"));
            colOsnSredstva.setCellValueFactory(new PropertyValueFactory<Record, Double>("fixedAssets"));
            colDrugieInvest.setCellValueFactory(new PropertyValueFactory<Record, Double>("otherInvestments"));

            Transfer.getBw().write("получение");
            Transfer.getBw().newLine();
            Transfer.getBw().flush();
            String gsonRecords = Transfer.getBr().readLine();
            Record[] recordsArray = Transfer.getGson().fromJson(gsonRecords, Record[].class);
            ObservableList<Record> list = FXCollections.observableArrayList();
            for(Record record : recordsArray){
                list.add(new Record(record));
            }

            table.setItems(list);
            table.setEditable(true);

            colKacca.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
            colRaschChet.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
            colValChet.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
            colUstavCapital.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
            colNeraspPrib.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
            colReserv.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
            colAmmortFond.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
            colDebit.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
            colZennyiBumagi.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
            colKratkDolg.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
            colDolgDolg.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
            colValutaNetto.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
            colOsnSredstva.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
            colDrugieInvest.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));

        } catch (Exception e) {
            infoLabel.setText("Ошибка!");
        }
    }

    public boolean addControl() {
        Record record = new Record();
        boolean flag = true;
        do {
            if (!date.getValue().equals("")) {
                record.setDate(Date.from(date.getValue().atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()));
            } else {
                flag = !flag;
                break;
            }
            if (!kacca.getText().trim().equals("")) {
                record.setCash(Double.valueOf(kacca.getText()));
                kacca.clear();
                infoLabel.setText("");
            } else {
                flag = !flag;
                break;
            }
            if (!raschetShet.getText().trim().equals("")) {
                record.setPaymentAccount(Double.valueOf(raschetShet.getText()));
                raschetShet.clear();
                infoLabel.setText("");
            } else {
                flag = !flag;
                break;
            }
            if (!valytnyShet.getText().trim().equals("")) {
                record.setCurrencyAccount(Double.valueOf(valytnyShet.getText()));
                valytnyShet.clear();
                infoLabel.setText("");
            } else {
                flag = !flag;
                break;
            }
            if (!ustavCapital.getText().trim().equals("")) {
                record.setAuthorizedCapital(Double.valueOf(ustavCapital.getText()));
                ustavCapital.clear();
                infoLabel.setText("");
            } else {
                flag = !flag;
                break;
            }
            if (!neraspredPrib.getText().trim().equals("")) {
                record.setUndesterbutedProfits(Double.valueOf(neraspredPrib.getText()));
                neraspredPrib.clear();
                infoLabel.setText("");
            } else {
                flag = !flag;
                break;
            }
            if (!reservy.getText().trim().equals("")) {
                record.setReserves(Double.valueOf(reservy.getText()));
                reservy.clear();
                infoLabel.setText("");
            } else {
                flag = !flag;
                break;
            }
            if (!ammortFond.getText().trim().equals("")) {
                record.setSinkingFund(Double.valueOf(ammortFond.getText()));
                ammortFond.clear();
                infoLabel.setText("");
            } else {
                flag = !flag;
                break;
            }
            if (!debit.getText().trim().equals("")) {
                record.setAccountsReceivable(Double.valueOf(debit.getText()));
                debit.clear();
                infoLabel.setText("");
            } else {
                flag = !flag;
                break;
            }
            if (!zennyiBumagi.getText().trim().equals("")) {
                record.setSecurites(Double.valueOf(zennyiBumagi.getText()));
                zennyiBumagi.clear();
                infoLabel.setText("");
            } else {
                flag = !flag;
                break;
            }
            if (!kratkDolgi.getText().trim().equals("")) {
                record.setShorttermDebt(Double.valueOf(kratkDolgi.getText()));
                kratkDolgi.clear();
                infoLabel.setText("");
            } else {
                flag = !flag;
                break;
            }
            if (!dolgDolgi.getText().trim().equals("")) {
                record.setLongtermDebt(Double.valueOf(dolgDolgi.getText()));
                dolgDolgi.clear();
                infoLabel.setText("");
            } else {
                flag = !flag;
                break;
            }
            if (!valytBalansNetto.getText().trim().equals("")) {
                record.setNetBalanceCurrency(Double.valueOf(valytBalansNetto.getText()));
                valytBalansNetto.clear();
                infoLabel.setText("");
            } else {
                flag = !flag;
                break;
            }
            if (!osnovSredstva.getText().trim().equals("")) {
                record.setFixedAssets(Double.valueOf(osnovSredstva.getText()));
                osnovSredstva.clear();
                infoLabel.setText("");
            } else {
                flag = !flag;
                break;
            }
            if (!drugiyeInvest.getText().trim().equals("")) {
                record.setOtherInvestments(Double.valueOf(drugiyeInvest.getText()));
                drugiyeInvest.clear();
                infoLabel.setText("");
            } else {
                flag = !flag;
                break;
            }
        } while (false);
        if (flag) {
            table.getItems().add(record);
        } else
            infoLabel.setText("Введены не все данные!");
        return true;
    }



    boolean flag = true;

    public DataController(){}

    public void deleteControl(ActionEvent actionEvent) {
        ObservableList<Record> selectedItem, allItem;
        allItem = table.getItems();
        selectedItem = table.getSelectionModel().getSelectedItems();
        selectedItem.forEach(allItem::remove);

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

    public void save(ActionEvent actionEvent) {
        try {
            Transfer.getBw().write("сохранение");
            Transfer.getBw().newLine();
            Transfer.getBw().flush();

            String gsonRecords = Transfer.getGson().toJson(
                    table.getItems().toArray());

            Transfer.getBw().write(gsonRecords);
            Transfer.getBw().newLine();
            Transfer.getBw().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void dateChanged(TableColumn.CellEditEvent<Record, Date> recordDateCellEditEvent) {
        table.getSelectionModel().getSelectedItem().setDate(recordDateCellEditEvent.getNewValue());
    }

    public void kaccaChanged(TableColumn.CellEditEvent<Record, Double> recordDoubleCellEditEvent) {
        try {
            table.getSelectionModel().getSelectedItem().setCash(recordDoubleCellEditEvent.getNewValue());
        } catch (NumberFormatException e) {
            infoLabel.setText("Ошибка!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void raschetChanged(TableColumn.CellEditEvent<Record, Double> recordDoubleCellEditEvent) {
        table.getSelectionModel().getSelectedItem().setPaymentAccount(recordDoubleCellEditEvent.getNewValue());
    }

    public void valChetChanged(TableColumn.CellEditEvent<Record, Double> recordDoubleCellEditEvent) {
        table.getSelectionModel().getSelectedItem().setCurrencyAccount(recordDoubleCellEditEvent.getNewValue());
    }

    public void ustavCapitalChanged(TableColumn.CellEditEvent<Record, Double> recordDoubleCellEditEvent) {
        table.getSelectionModel().getSelectedItem().setAuthorizedCapital(recordDoubleCellEditEvent.getNewValue());
    }

    public void neraspredPribylChanged(TableColumn.CellEditEvent<Record, Double> recordDoubleCellEditEvent) {
        table.getSelectionModel().getSelectedItem().setUndesterbutedProfits(recordDoubleCellEditEvent.getNewValue());
    }

    public void reservChanged(TableColumn.CellEditEvent<Record, Double> recordDoubleCellEditEvent) {
        table.getSelectionModel().getSelectedItem().setReserves(recordDoubleCellEditEvent.getNewValue());
    }

    public void ammortFondChanged(TableColumn.CellEditEvent<Record, Double> recordDoubleCellEditEvent) {
        table.getSelectionModel().getSelectedItem().setSinkingFund(recordDoubleCellEditEvent.getNewValue());
    }

    public void debitChanged(TableColumn.CellEditEvent<Record, Double> recordDoubleCellEditEvent) {
        table.getSelectionModel().getSelectedItem().setAccountsReceivable(recordDoubleCellEditEvent.getNewValue());

    }

    public void zennyiBumagiChanged(TableColumn.CellEditEvent<Record, Double> recordDoubleCellEditEvent) {
        table.getSelectionModel().getSelectedItem().setSecurites(recordDoubleCellEditEvent.getNewValue());

    }

    public void kratkDolgChanged(TableColumn.CellEditEvent<Record, Double> recordDoubleCellEditEvent) {
        table.getSelectionModel().getSelectedItem().setShorttermDebt(recordDoubleCellEditEvent.getNewValue());
    }

    public void dolgDolgChanged(TableColumn.CellEditEvent<Record, Double> recordDoubleCellEditEvent) {
        table.getSelectionModel().getSelectedItem().setLongtermDebt(recordDoubleCellEditEvent.getNewValue());

    }

    public void valutaNettoChanged(TableColumn.CellEditEvent<Record, Double> recordDoubleCellEditEvent) {
        table.getSelectionModel().getSelectedItem().setNetBalanceCurrency(recordDoubleCellEditEvent.getNewValue());

    }

    public void OsnSredstvaChanged(TableColumn.CellEditEvent<Record, Double> recordDoubleCellEditEvent) {
        table.getSelectionModel().getSelectedItem().setFixedAssets(recordDoubleCellEditEvent.getNewValue());

    }

    public void drugieInvestChanged(TableColumn.CellEditEvent<Record, Double> recordDoubleCellEditEvent) {
        table.getSelectionModel().getSelectedItem().setOtherInvestments(recordDoubleCellEditEvent.getNewValue());

    }
}
