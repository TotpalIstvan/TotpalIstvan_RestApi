package hu.petrik.totpalistvan_restapi;

public class Varos {
    private int id;
    private String orszag;
    private String nev;
    private int lakossag;

    public Varos(int id, String orszag, String nev, int lakossag) {
        this.id = id;
        this.orszag = orszag;
        this.nev = nev;
        this.lakossag = lakossag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrszag() {
        return orszag;
    }

    public void setOrszag(String orszag) {
        this.orszag = orszag;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getLakossag() {
        return lakossag;
    }

    public void setLakossag(int lakossag) {
        this.lakossag = lakossag;
    }

    @Override
    public String toString() {
        return String.format(" %s, %s, %d", this.orszag, this.nev, this.lakossag);
    }
}
