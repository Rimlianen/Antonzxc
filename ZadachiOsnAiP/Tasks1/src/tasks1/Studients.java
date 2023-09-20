package tasks1;

public class Studients {
    private String Familie;
       private String Imya;
       private String Otchestvo;
       private String Pol;
       private int Rost;

    public String getFamilie() {
        return Familie;
    }

    public Studients(String Familie, String Imya, String Otchestvo, String Pol, int Rost) {
        this.Familie = Familie;
        this.Imya = Imya;
        this.Otchestvo = Otchestvo;
        this.Pol = Pol;
        this.Rost = Rost;
    }

    public void setFamilie(String Familie) {
        this.Familie = Familie;
    }

    public String getImya() {
        return Imya;
    }

    public void setImya(String Imya) {
        this.Imya = Imya;
    }

    public String getOtchestvo() {
        return Otchestvo;
    }

    public void setOtchestvo(String Otchestvo) {
        this.Otchestvo = Otchestvo;
    }

    public String getPol() {
        return Pol;
    }

    public void setPol(String Pol) {
        this.Pol = Pol;
    }

    public int getRost() {
        return Rost;
    }

    public void setRost(int Rost) {
        this.Rost = Rost;
    }

    
}
