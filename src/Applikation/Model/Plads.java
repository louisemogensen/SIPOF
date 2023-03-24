package Applikation.Model;

public class Plads {

    private int hyldenummer;
    private int pladsnummer;

    //Linkattributter
    private Lager lager;
    private Fad fad;

    public Plads(int hyldenummer, int pladsnummer, Lager lager) {
        this.hyldenummer = hyldenummer;
        this.pladsnummer = pladsnummer;
        this.lager = lager;
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
        if(this.fad != fad) {
            Fad oldFad = this.fad;
            if(oldFad != null) {
                oldFad.removePlads(this);
            }
            this.fad = fad;
            if(fad != null) {
                fad.addPlads(this);
            }
        }

    }
}
