package Applikation.Model;

import java.util.ArrayList;

public class Lager {

    private String lokation;  //Et lager hos SWD og ét hos landmand

    private ArrayList<Integer> ledigePladser = new ArrayList();

    private int antalFade;

    public Lager(String lokation, ArrayList ledigePladser, int antalFade) {
        this.lokation = lokation;
        this.ledigePladser = ledigePladser;
        this.antalFade = antalFade;
    }

    public String getLokation() {
        return lokation;
    }

    public void setLokation(String lokation) {
        this.lokation = lokation;
    }


    public ArrayList<Integer> getLedigePladser() {
        return ledigePladser;
    }

    public void setLedigePladser(ArrayList<Integer> ledigePladser) {
        this.ledigePladser = ledigePladser;
    }

    public int getAntalFade() {
        return antalFade;
    }

    public void setAntalFade(int antalFade) {
        this.antalFade = antalFade;
    }
}
