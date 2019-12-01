package client.Objects;

import java.util.Date;

public class Record { //для пересылки данных и вывода в таблицу
    //FUND
    private Date date;
    private double cash;
    private double paymentAccount;
    private double currencyAccount;
    //SourcesOfEquity
    private double authorizedCapital;
    private double undesterbutedProfits;
    private double reserves;
    private double sinkingFund;
    //LiquidParameters
    private double accountsReceivable;
    private double securites;
    //LoanSources
    private double shorttermDebt;
    private double longtermDebt;
    //BusinessActivityParam
    private double netBalanceCurrency;
    private double fixedAssets;
    private double otherInvestments;

    public Record(Date date, double cash, double paymentAccount, double currencyAccount, double authorizedCapital, double undesterbutedProfits, double reserves, double sinkingFund, double accountsReceivable, double securites, double shorttermDebt, double longtermDebt, double netBalanceCurrency, double fixedAssets, double otherInvestments) {
        this.date = date;
        this.cash = cash;
        this.paymentAccount = paymentAccount;
        this.currencyAccount = currencyAccount;
        this.authorizedCapital = authorizedCapital;
        this.undesterbutedProfits = undesterbutedProfits;
        this.reserves = reserves;
        this.sinkingFund = sinkingFund;
        this.accountsReceivable = accountsReceivable;
        this.securites = securites;
        this.shorttermDebt = shorttermDebt;
        this.longtermDebt = longtermDebt;
        this.netBalanceCurrency = netBalanceCurrency;
        this.fixedAssets = fixedAssets;
        this.otherInvestments = otherInvestments;
    }

    public Record(){}

    public Record(Record record){
        this.date = record.date;
        this.cash = record.cash;
        this.paymentAccount = record.paymentAccount;
        this.currencyAccount = record.currencyAccount;
        this.authorizedCapital = record.authorizedCapital;
        this.undesterbutedProfits = record.undesterbutedProfits;
        this.reserves = record.reserves;
        this.sinkingFund = record.sinkingFund;
        this.accountsReceivable = record.accountsReceivable;
        this.securites = record.securites;
        this.shorttermDebt = record.shorttermDebt;
        this.longtermDebt = record.longtermDebt;
        this.netBalanceCurrency = record.netBalanceCurrency;
        this.fixedAssets = record.fixedAssets;
        this.otherInvestments = record.otherInvestments;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Record{" +
                "date=" + date +
                ", cash=" + cash +
                ", paymentAccount=" + paymentAccount +
                ", currencyAccount=" + currencyAccount +
                ", authorizedCapital=" + authorizedCapital +
                ", undesterbutedProfits=" + undesterbutedProfits +
                ", reserves=" + reserves +
                ", sinkingFund=" + sinkingFund +
                ", accountsReceivable=" + accountsReceivable +
                ", securites=" + securites +
                ", shorttermDebt=" + shorttermDebt +
                ", longtermDebt=" + longtermDebt +
                ", netBalanceCurrency=" + netBalanceCurrency +
                ", fixedAssets=" + fixedAssets +
                ", otherInvestments=" + otherInvestments +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(double paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public double getCurrencyAccount() {
        return currencyAccount;
    }

    public void setCurrencyAccount(double currencyAccount) {
        this.currencyAccount = currencyAccount;
    }

    public double getAuthorizedCapital() {
        return authorizedCapital;
    }

    public void setAuthorizedCapital(double authorizedCapital) {
        this.authorizedCapital = authorizedCapital;
    }

    public double getUndesterbutedProfits() {
        return undesterbutedProfits;
    }

    public void setUndesterbutedProfits(double undesterbutedProfits) {
        this.undesterbutedProfits = undesterbutedProfits;
    }

    public double getReserves() {
        return reserves;
    }

    public void setReserves(double reserves) {
        this.reserves = reserves;
    }

    public double getSinkingFund() {
        return sinkingFund;
    }

    public void setSinkingFund(double sinkingFund) {
        this.sinkingFund = sinkingFund;
    }

    public double getAccountsReceivable() {
        return accountsReceivable;
    }

    public void setAccountsReceivable(double accountsReceivable) {
        this.accountsReceivable = accountsReceivable;
    }

    public double getSecurites() {
        return securites;
    }

    public void setSecurites(double securites) {
        this.securites = securites;
    }

    public double getShorttermDebt() {
        return shorttermDebt;
    }

    public void setShorttermDebt(double shorttermDebt) {
        this.shorttermDebt = shorttermDebt;
    }

    public double getLongtermDebt() {
        return longtermDebt;
    }

    public void setLongtermDebt(double longtermDebt) {
        this.longtermDebt = longtermDebt;
    }

    public double getNetBalanceCurrency() {
        return netBalanceCurrency;
    }

    public void setNetBalanceCurrency(double netBalanceCurrency) {
        this.netBalanceCurrency = netBalanceCurrency;
    }

    public double getFixedAssets() {
        return fixedAssets;
    }

    public void setFixedAssets(double fixedAssets) {
        this.fixedAssets = fixedAssets;
    }

    public double getOtherInvestments() {
        return otherInvestments;
    }

    public void setOtherInvestments(double otherInvestments) {
        this.otherInvestments = otherInvestments;
    }
}
