package Applikation.Model;

public class Fad {

    private String fadtype;  //Tidligere indhold på fad

    private int fadnummer;

    private int fadplads;

    private boolean erFadFyldt;  //Er den nødvenidg? Står tomme fade på en palds på lageret?

    public Fad(String fadtype, int fadnummer, int fadplads, boolean erFadFyldt) {
        this.fadtype = fadtype;
        this.fadnummer = fadnummer;
        this.fadplads = fadplads;
        this.erFadFyldt = erFadFyldt;
    }

    public String getFadtype() {
        return fadtype;
    }

    public void setFadtype(String fadtype) {
        this.fadtype = fadtype;
    }

    public int getFadnummer() {
        return fadnummer;
    }

    public void setFadnummer(int fadnummer) {
        this.fadnummer = fadnummer;
    }

    public int getFadplads() {
        return fadplads;
    }

    public void setFadplads(int fadplads) {
        this.fadplads = fadplads;
    }

    public boolean isErFadFyldt() {
        return erFadFyldt;
    }

    public void setErFadFyldt(boolean erFadFyldt) {
        this.erFadFyldt = erFadFyldt;
    }

    //Metoder til at vedligeholde forbindelsen til linkattributter


}
