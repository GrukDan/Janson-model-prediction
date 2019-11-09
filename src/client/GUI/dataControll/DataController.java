package client.GUI.dataControll;

import client.Objects.Record;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class DataController implements Initializable {

    private ObservableList<Record> list = FXCollections.observableArrayList();

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

        list.add(new Record(new Date(), 22.0, 22.0, 22.0, 22.0, 22.0, 22.0, 22.0, 22.0, 22.0, 22.0, 22.0, 22.0, 22.0, 22.0));
        list.add(new Record(new Date(), 33.0, 2222.0, 22.0, 22.0, 22.0, 22.0, 22.0, 22.0, 22.0, 22.0, 22.0, 22.0, 22.0, 22.0));


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

        table.setItems(list);
    }

    public boolean addControl(){
        Record record = new Record();
        if(!date.equals(null)) {
            record.setDate(Date.from(date.getValue().atStartOfDay()
                    .atZone(ZoneId.systemDefault())
                    .toInstant()));
        }
        if(!kacca.getText().trim().equals("")){
            record.setCash(Double.valueOf(kacca.getText()));
            kacca.clear();
        }
        if(!raschetShet.getText().trim().equals("")){
            record.setPaymentAccount(Double.valueOf(raschetShet.getText()));
            raschetShet.clear();
        }
        if(!valytnyShet.getText().trim().equals("")){
            record.setCurrencyAccount(Double.valueOf(valytnyShet.getText()));
            valytnyShet.clear();
        }
        if(!ustavCapital.getText().trim().equals("")){
            record.setAuthorizedCapital(Double.valueOf(ustavCapital.getText()));
            ustavCapital.clear();
        }
        if(!neraspredPrib.getText().trim().equals("")){
            record.setUndesterbutedProfits(Double.valueOf(neraspredPrib.getText()));
            neraspredPrib.clear();
        }
        if(!reservy.getText().trim().equals("")){
            record.setReserves(Double.valueOf(reservy.getText()));
            reservy.clear();
        }
        if(!ammortFond.getText().trim().equals("")){
            record.setSinkingFund(Double.valueOf(ammortFond.getText()));
            ammortFond.clear();
        }
        if(!debit.getText().trim().equals("")){
            record.setAccountsReceivable(Double.valueOf(debit.getText()));
            debit.clear();
        }
        if(!zennyiBumagi.getText().trim().equals("")){
            record.setSecurites(Double.valueOf(zennyiBumagi.getText()));
            zennyiBumagi.clear();
        }
        if(!kratkDolgi.getText().trim().equals("")){
            record.setShorttermDebt(Double.valueOf(kratkDolgi.getText()));
            kratkDolgi.clear();
        }
        if(!dolgDolgi.getText().trim().equals("")){
            record.setLongtermDebt(Double.valueOf(dolgDolgi.getText()));
            dolgDolgi.clear();
        }
        if(!valytBalansNetto.getText().trim().equals("")){
            record.setNetBalanceCurrency(Double.valueOf(valytBalansNetto.getText()));
            valytBalansNetto.clear();
        }
        if(!osnovSredstva.getText().trim().equals("")){
            record.setFixedAssets(Double.valueOf(osnovSredstva.getText()));
            osnovSredstva.clear();
        }
        if(!drugiyeInvest.getText().trim().equals("")){
            record.setOtherInvestments(Double.valueOf(drugiyeInvest.getText()));
            drugiyeInvest.clear();
        }

        table.getItems().add(record);
        return true;
    }


    BufferedWriter bw;
    BufferedReader br;
    Gson gson;
    boolean flag = true;

    public DataController(BufferedWriter bufferedWriter, BufferedReader bufferedReader){
        this.bw = bufferedWriter;
        this.br = bufferedReader;
        this.gson = new Gson();
    }

}
