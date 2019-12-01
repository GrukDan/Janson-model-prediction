package client.Objects;

import java.util.Date;

public class Result {
    private Date beginDate;
    private Date endDate;
    private Double active;
    private Double passive;
    private Double relation;
private String coefficient;
    public Result(){}

    @Override
    public String toString() {
        return "Result{" +
                "beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", active=" + active +
                ", passive=" + passive +
                ", relation=" + relation +
                ", coefficient='" + coefficient + '\'' +
                '}';
    }

    public String getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(String coefficient) {
        this.coefficient = coefficient;
    }

    public Result(Date beginDate, Date endDate, Double active, Double passive, Double relation, String coefficient) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.active = active;
        this.passive = passive;
        this.relation = relation;
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

    public Double getActive() {
        return active;
    }

    public void setActive(Double active) {
        this.active = active;
    }

    public Double getPassive() {
        return passive;
    }

    public void setPassive(Double passive) {
        this.passive = passive;
    }

    public Double getRelation() {
        return relation;
    }

    public void setRelation(Double relation) {
        this.relation = relation;
    }


}
