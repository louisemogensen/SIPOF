package Applikation.Model;

public class Plads {

    private int reolnummer;
    private int pladsnummer;

    //Linkattributter
    private Lager lager;
    private Fad fad;

    //constructoren er protected, da klassesammenhængen til Lager er en komposition.
    // Det er derfor kun Lager, der må oprette pladser.
    protected Plads(int reolnummer, int pladsnummer, Lager lager) {
        this.reolnummer = reolnummer;
        this.pladsnummer = pladsnummer;
        this.lager = lager;
        // Plads har ikke Lager med i constructoren, da Lager har metoden createPlads
    }

    public int getReolnummer() {
        return reolnummer;
    }

    public void setReolnummer(int reolnummer) {
        this.reolnummer = reolnummer;
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

}
