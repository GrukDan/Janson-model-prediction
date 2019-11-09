package client.Objects;

import java.util.Date;

public class Fund {
    private Date date;
    private double cash;
    private double paymentAccount;
    private double currencyAccount;

    public Fund(Date date, double cash, double paymentAccount, double currencyAccount) {
        this.date = date;
        this.cash = cash;
        this.paymentAccount = paymentAccount;
        this.currencyAccount = currencyAccount;
    }

    public Fund(){}

    @Override
    public String toString() {
        return "Fund{" +
                "date=" + date +
                ", cash=" + cash +
                ", paymentAccount=" + paymentAccount +
                ", currencyAccount=" + currencyAccount +
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
}
