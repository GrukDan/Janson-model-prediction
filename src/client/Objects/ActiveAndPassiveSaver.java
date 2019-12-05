package client.Objects;

public class ActiveAndPassiveSaver {
    private Double active;
    private Double passive;
    private Double relation;

    @Override
    public String toString() {
        return "ActiveAndPassiveSaver{" +
                "active=" + active +
                ", passive=" + passive +
                ", relation=" + relation +
                '}';
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

    public ActiveAndPassiveSaver(Double active, Double passive, Double relation) {
        this.active = active;
        this.passive = passive;
        this.relation = relation;
    }
}
