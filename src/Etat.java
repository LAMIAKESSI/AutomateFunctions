import java.io.Serializable;

public class Etat implements Comparable, Serializable {
    private String nm;
    private int nb_trans;
    private boolean fin;
public Etat(String n){
    this.nm=n;
    this.fin=false;
};

    public void setFin(boolean fin) {
        this.fin = fin;
    }

    public void setNb_trans(int nb_trans) {
        this.nb_trans = nb_trans;
    }

    public int getNb_trans() {
        return nb_trans;
    }

    public boolean isFin() {
        return fin;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }


    @Override
    public int compareTo(Object o) {
        Etat et =(Etat)o;
        if(this.getNm().compareTo(et.getNm())>0)
        {
return 1;
        }
        else
        {
            if(this.getNm().compareTo(et.getNm())==0)
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }
    }

}
