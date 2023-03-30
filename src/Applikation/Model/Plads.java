package Applikation.Model;

public class Plads {

    private int hyldenummer;
    private int pladsnummer;

    //Linkattributter
    private Lager lager;
    private Fad fad;

    public Plads(int hyldenummer, int pladsnummer) {
        this.hyldenummer = hyldenummer;
        this.pladsnummer = pladsnummer;
    }

    public int getHyldenummer() {
        return hyldenummer;
    }

    public void setHyldenummer(int hyldenummer) {
        this.hyldenummer = hyldenummer;
    }

    public int getPladsnummer() {
        return pladsnummer;
    }

    public void setPladsnummer(int pladsnummer) {
        this.pladsnummer = pladsnummer;
    }

    //Metoder til at vedligeholde forbindelsen til linkattributter
    public Lager getLager() {
        return lager;
    }

    public void setLager(Lager lager) {
        this.lager = lager;
    }

    public Fad getFad() {
        return fad;
    }

    public void setFad(Fad fad) {
        if (this.fad != fad) {
            this.fad = fad;
        }
    }

    public void removeFad(Fad fad) {
    }

    public void addFad(Fad fad) {
    }
}
