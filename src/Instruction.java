import java.io.Serializable;

public class Instruction implements Serializable {
    private Etat arrive;
    private Etat depart;
    private String alph;
    public Instruction(){}

    public Etat getArrive() {
        return arrive;
    }

    public Etat getDepart() {
        return depart;
    }

    public void setArrive(Etat arrive) {
        this.arrive = arrive;
    }

    public void setDepart(Etat depart) {
        this.depart = depart;
    }

    public String getAlph() {
        return alph;
    }

    public void setAlph(String alph) {
        this.alph = alph;
    }
}
