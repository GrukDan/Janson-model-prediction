package client.Objects;

import java.util.Date;

public class BusinessActivityParam {
    private Date date;
    private double netBalanceCurrency;
    private double fixedAssets;
    private double otherInvestments;

    public BusinessActivityParam(){}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "BusinessActivityParam{" +
                "date=" + date +
                ", netBalanceCurrency=" + netBalanceCurrency +
                ", fixedAssets=" + fixedAssets +
                ", otherInvestments=" + otherInvestments +
                '}';
    }

    public BusinessActivityParam(Date date, double netBalanceCurrency, double fixedAssets, double otherInvestments) {
        this.date = date;
        this.netBalanceCurrency = netBalanceCurrency;
        this.fixedAssets = fixedAssets;
        this.otherInvestments = otherInvestments;
    }
}
