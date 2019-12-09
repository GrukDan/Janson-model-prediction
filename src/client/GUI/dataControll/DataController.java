package client.GUI.dataControll;

import client.GUI.Account;
import client.Objects.Record;
import client.Objects.Transfer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.*;
import java.util.regex.Pattern;

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

            table.setItems(list);
            table.setEditable(true);

            if(!Account.getAccount().getRole().equalsIgnoreCase("admin")){
                table.setEditable(false);
                saveButton.setVisible(false);
                saveButton.setDisable(false);
                deleteButton.setVisible(false);
                deleteButton.setDisable(false);
                addButton.setVisible(false);
                addButton.setDisable(false);
            }

        } catch (Exception e) {
            infoLabel.setText("Ошибка!");
        }
    }

    public boolean addControl() {
        Record record = new Record();
        boolean flag = true;
        Pattern pattern = Pattern.compile("\\-?\\d+(\\.\\d{0,})?"); //correct pattern for both float and integer.
        infoLabel.setText("");
            if (date.getValue()!=null) {
                record.setDate(Date.from(date.getValue().atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()));
            } else {
                infoLabel.setText("Введите дату");
                flag = false;
                            }
            if (!kacca.getText().trim().equals("")) {
                if (pattern.matcher(kacca.getText().trim()).matches()) {
                    record.setCash(Double.valueOf(kacca.getText()));

                }else {
                    flag = false;
                    infoLabel.setText("Касса введена неверно!");
                }
            } else {
                flag = false;
                infoLabel.setText("Введите кассу!");
            }
            if (!raschetShet.getText().trim().equals("")) {
                if (pattern.matcher(raschetShet.getText().trim()).matches()) {
                record.setPaymentAccount(Double.valueOf(raschetShet.getText()));

                }else {
                    flag = false;
                    infoLabel.setText("Расчетный счет введен неверно!");
                }
            } else {
                flag = false;
                infoLabel.setText("Введите рассч.счет!");
            }
            if (!valytnyShet.getText().trim().equals("")) {
                if (pattern.matcher(valytnyShet.getText().trim()).matches()) {
                record.setCurrencyAccount(Double.valueOf(valytnyShet.getText()));

                }else {
                    flag = false;
                    infoLabel.setText("Валютный счет введен неверно!");
                }

            } else {
                flag = false;
                infoLabel.setText("Введите валютный счет!");
            }
            if (!ustavCapital.getText().trim().equals("")) {
                if (pattern.matcher(ustavCapital.getText().trim()).matches()) {
                record.setAuthorizedCapital(Double.valueOf(ustavCapital.getText()));

                }else {
                    flag = false;
                    infoLabel.setText("Уставной капитал введен неверно!");
                }

            } else {
                flag = false;
                infoLabel.setText("Введите уставной капитал!");
            }
            if (!neraspredPrib.getText().trim().equals("")) {
                if (pattern.matcher(neraspredPrib.getText().trim()).matches()) {
                record.setUndesterbutedProfits(Double.valueOf(neraspredPrib.getText()));

                }else {
                    flag = false;
                    infoLabel.setText("Нераспределенная прибыль введена неверно!");
                }

            } else {
                flag = false;
                infoLabel.setText("Введите нераспределенную прибыль!");
            }
            if (!reservy.getText().trim().equals("")) {
                if (pattern.matcher(reservy.getText().trim()).matches()) {
                record.setReserves(Double.valueOf(reservy.getText()));

                }else {
                    flag = false;
                    infoLabel.setText("Резервы введены неверно!");
                }

            } else {
                flag = false;
                infoLabel.setText("Введите резервы!");
            }
            if (!ammortFond.getText().trim().equals("")) {
                if (pattern.matcher(ammortFond.getText().trim()).matches()) {
                record.setSinkingFund(Double.valueOf(ammortFond.getText()));

                }else {
                    flag = false;
                    infoLabel.setText("Амморт. фонд введен неверно!");
                }

            } else {
                flag = false;
                infoLabel.setText("Введите амморт.фонд!");
            }
            if (!debit.getText().trim().equals("")) {
                if (pattern.matcher(debit.getText().trim()).matches()) {
                record.setAccountsReceivable(Double.valueOf(debit.getText()));

                }else {
                    flag = false;
                    infoLabel.setText("Дебит введен неверно!");
                }

            } else {
                flag = false;
                infoLabel.setText("Введите дебит!");
            }
            if (!zennyiBumagi.getText().trim().equals("")) {
                if (pattern.matcher(zennyiBumagi.getText().trim()).matches()) {
                record.setSecurites(Double.valueOf(zennyiBumagi.getText()));

                }else {
                    flag = false;
                    infoLabel.setText("Ценные бумаги введены неверно!");
                }

            } else {
                flag = false;
                infoLabel.setText("Введите ценные бумаги!");
            }
            if (!kratkDolgi.getText().trim().equals("")) {
                if (pattern.matcher(kratkDolgi.getText().trim()).matches()) {
                record.setShorttermDebt(Double.valueOf(kratkDolgi.getText()));

                }else {
                    flag = false;
                    infoLabel.setText("Краткосрочн. плтежи введены неверно!");
                }

            } else {
                flag = false;
                infoLabel.setText("Введите краткосрочные платежи!");
            }
            if (!dolgDolgi.getText().trim().equals("")) {
                if (pattern.matcher(dolgDolgi.getText().trim()).matches()) {
                record.setLongtermDebt(Double.valueOf(dolgDolgi.getText()));

                }else {
                    flag = false;
                    infoLabel.setText("Долгоср. платежи введены неверно!");
                }

            } else {
                flag = false;
                infoLabel.setText("Введите долгосрочные платежи!");
            }
            if (!valytBalansNetto.getText().trim().equals("")) {
                if (pattern.matcher(valytBalansNetto.getText().trim()).matches()) {
                record.setNetBalanceCurrency(Double.valueOf(valytBalansNetto.getText()));

                }else {
                    flag = false;
                    infoLabel.setText("Баланс-нетто введен неверно!");
                }

            } else {
                flag = false;
                infoLabel.setText("Введите баланс-нетто!");
            }
            if (!osnovSredstva.getText().trim().equals("")) {
                if (pattern.matcher(osnovSredstva.getText().trim()).matches()) {
                record.setFixedAssets(Double.valueOf(osnovSredstva.getText()));

                }else {
                    flag = false;
                    infoLabel.setText("Основные средства введены неверно!");
                }

            } else {
                flag = false;
                infoLabel.setText("Введите основные средства!");
            }
            if (!drugiyeInvest.getText().trim().equals("")) {
                if (pattern.matcher(drugiyeInvest.getText().trim()).matches()) {
                record.setOtherInvestments(Double.valueOf(drugiyeInvest.getText()));

                }else {
                    flag = false;
                    infoLabel.setText("Инвестиции введены неверно!");
                }

            } else {
                flag = false;
                infoLabel.setText("Введите инвестиции!");
            }

        if (flag) {
            table.getItems().add(record);
            infoLabel.setText("");
            kacca.clear();
            raschetShet.clear();
            valytnyShet.clear();
            ustavCapital.clear();
            neraspredPrib.clear();
            reservy.clear();
            ammortFond.clear();
            debit.clear();
            zennyiBumagi.clear();
            kratkDolgi.clear();
            dolgDolgi.clear();
            valytBalansNetto.clear();
            osnovSredstva.clear();
            drugiyeInvest.clear();
        }
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
