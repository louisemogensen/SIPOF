package Applikation.Model;

import java.util.ArrayList;

public class Lager {

    private String lokation;
    private int ledigepladser;
    private int antalFade;
    private int maxAntalFade;

    //Linkattribut
    private ArrayList<Plads> pladser = new ArrayList<>();

    public Lager(String lokation, int ledigepladser, int antalFade, int maxAntalFade) {
        this.lokation = lokation;
        this.ledigepladser = ledigepladser;
        this.antalFade = antalFade;
        this.maxAntalFade = maxAntalFade;
    }

    public String getLokation() {
        return lokation;
    }

    public void setLokation(String lokation) {
        this.lokation = lokation;
    }

    public int getLedigepladser() {
        return ledigepladser;
    }

    public void setLedigepladser(int ledigepladser) {
        this.ledigepladser = ledigepladser;
    }

    public int getAntalFade() {
        return antalFade;
    }

    public void setAntalFade(int antalFade) {
        this.antalFade = antalFade;
    }

    public int getMaxAntalFade() {
        return maxAntalFade;
    }

    public void setMaxAntalFade(int maxAntalFade) {
        this.maxAntalFade = maxAntalFade;
    }

    //Metoder til at vedligeholde forbindelsen til linkattribut

    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public Plads createPlads(int hyldenummer, int pladsnummer, Lager lager) {
        Plads plads = new Plads(hyldenummer, pladsnummer, lager);
        pladser.add(plads);
        return plads;
    }

    public void deletePlads(Plads plads) {
        if(pladser.contains(plads)) {
            pladser.remove(plads);
        }
    }
}
