package client.Objects;

import java.util.Arrays;
import java.util.Date;

public class Result {
    private Date beginDate;
    private Date endDate;
    private Double[] assets;
    private Double[] liabilities;
    private Double[] relation;
    private String coefficient;
    private int term;
    private Double[] functionValues;

    public Result() {
    }



    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public Double[] getFunctionValues() {
        return functionValues;
    }

    public void setFunctionValues(Double[] functionValues) {
        this.functionValues = functionValues;
    }



    public String getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(String coefficient) {
        this.coefficient = coefficient;
    }



    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Result{" +
                "beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", assets=" + Arrays.toString(assets) +
                ", liabilities=" + Arrays.toString(liabilities) +
                ", relation=" + Arrays.toString(relation) +
                ", coefficient='" + coefficient + '\'' +
                ", term=" + term +
                ", functionValues=" + Arrays.toString(functionValues) +
                '}';
    }

    public Double[] getAssets() {
        return assets;
    }

    public void setAssets(Double[] assets) {
        this.assets = assets;
    }

    public Double[] getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(Double[] liabilities) {
        this.liabilities = liabilities;
    }

    public Double[] getRelation() {
        return relation;
    }

    public void setRelation(Double[] relation) {
        this.relation = relation;
    }

    public Result(Date beginDate, Date endDate, Double[] assets, Double[] liabilities, Double[] relation, String coefficient, int term, Double[] functionValues) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.assets = assets;
        this.liabilities = liabilities;
        this.relation = relation;
        this.coefficient = coefficient;
        this.term = term;
        this.functionValues = functionValues;
    }
}

