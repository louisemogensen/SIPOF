package Applikation.Model;

import java.util.ArrayList;

public class Lager {

    private String lokation;
    private int maxAntalPladser;

    //Linkattribut
    private final ArrayList<Plads> pladser = new ArrayList<>();

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

    public Plads createPlads(int reolnummer, int pladsnummer) {
        Plads plads = new Plads(reolnummer, pladsnummer, this);
        pladser.add(plads);
        return plads;
    }

    public void removePlads(Plads plads) {
        pladser.remove(plads); //remove indeholder selv en contains-tjekker
    }

    //------------------------------------

    @Override
    public String toString() {
        return "Lager " + lokation;
    }

}
