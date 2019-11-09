package client.Objects;

import java.util.Date;

public class LoanSources {

    private Date date;
    private double shorttermDebt;
    private double longtermDebt;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "LoanSources{" +
                "date=" + date +
                ", shorttermDebt=" + shorttermDebt +
                ", longtermDebt=" + longtermDebt +
                '}';
    }

    public LoanSources(){}

    public LoanSources(Date date, double shorttermDebt, double longtermDebt) {
        this.date = date;
        this.shorttermDebt = shorttermDebt;
        this.longtermDebt = longtermDebt;
    }
}
