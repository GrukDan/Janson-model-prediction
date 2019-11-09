package client.Objects;

import java.util.Date;

public class SourcesOfEquity {
    private Date date;
    private double authorizedCapital;
    private double undesterbutedProfits;
    private double reserves;
    private double sinkingFund;

    public SourcesOfEquity(Date date, double authorizedCapital, double undesterbutedProfits, double reserves, double sinkingFund) {
        this.date = date;
        this.authorizedCapital = authorizedCapital;
        this.undesterbutedProfits = undesterbutedProfits;
        this.reserves = reserves;
        this.sinkingFund = sinkingFund;
    }

    public SourcesOfEquity(){}

    @Override
    public String toString() {
        return "SourcesOfEquity{" +
                "date=" + date +
                ", authorizedCapital=" + authorizedCapital +
                ", undesterbutedProfits=" + undesterbutedProfits +
                ", reserves=" + reserves +
                ", sinkingFund=" + sinkingFund +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
