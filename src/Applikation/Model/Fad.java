package Applikation.Model;

public class Fad {

    private String fadtype;
    private int fadnummer;
    private boolean erFadFyldt;

    //Linkattribut

    private Plads plads;

    public Fad(String fadtype, int fadnummer, boolean erFadFyldt) {
        this.fadtype = fadtype;
        this.fadnummer = fadnummer;
        this.erFadFyldt = erFadFyldt;
    }

    public String getFadtype() {
        return fadtype;
    }

    public void setFadtype(String fadtype) {
        this.fadtype = fadetype;
    }

    public int getFadnummer() {
        return fadnummer;
    }

    public void setFadnummer(int fadnummer) {
        this.fadnummer = fadnummer;
    }

    public boolean isErFadFyldt() {
        return erFadFyldt;
    }

    public void setErFadFyldt(boolean erFadFyldt) {
        this.erFadFyldt = erFadFyldt;
    }

    //Metoder til at vedligeholde forbindelsen til linkattribut

    public Plads getPlads() {
        return plads;
    }

    public void setPlads(Plads plads) {
        if(this.plads != plads) {
            Plads oldPlads = this.plads;
            if(oldPlads != null) {
                oldPlads.removeFad(this); // ???
            }
            this.plads = plads;
            if(plads != null) {
                plads.addFad(this);  // ???
            }
        }

    }
}
