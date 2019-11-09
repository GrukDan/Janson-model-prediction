package client.Objects;

import java.util.Date;

public class LiquidParameters {
    private Date date;
    private double accountsReceivable;
    private double securites;

    public LiquidParameters(Date date, double accountsReceivable, double securites) {
        this.date = date;
        this.accountsReceivable = accountsReceivable;
        this.securites = securites;
    }

    public LiquidParameters(){}


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "LiquidParameters{" +
                "date=" + date +
                ", accountsReceivable=" + accountsReceivable +
                ", securites=" + securites +
                '}';
    }
}
