package Applikation.Model;

import java.util.ArrayList;

public class Lager {

    private String lokation;
    private int maxAntalPladser;

    //Linkattribut
    private ArrayList<Plads> pladser = new ArrayList<>();

    public Lager(String lokation, int maxAntalFade) {
        this.lokation = lokation;
        this.maxAntalPladser = maxAntalFade;
    }

    public String getLokation() {
        return lokation;
    }

    public void setLokation(String lokation) {
        this.lokation = lokation;
    }

    public int getMaxAntalPladser() {
        return maxAntalPladser;
    }

    public void setMaxAntalPladser(int maxAntalPladser) {
        this.maxAntalPladser = maxAntalPladser;
    }

    //Metoder til at vedligeholde forbindelsen til linkattribut

    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public Plads createPlads(int hyldenummer, int pladsnummer) {
        Plads plads = new Plads(hyldenummer, pladsnummer);
        plads.setLager(this);
        pladser.add(plads);
        return plads;
    }

    public void deletePlads(Plads plads) {
        if(pladser.contains(plads)) {
            pladser.remove(plads);
        }
    }

    //------------------------------------
}
