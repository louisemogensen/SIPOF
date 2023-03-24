package Applikation.Model;

import java.util.ArrayList;

public class Lager {

    private String lokation;  //Et lager hos SWD og ét hos landmand

    private ArrayList<Integer> ledigePladser = new ArrayList();

    private int antalFade;

    //Linkattrbiutter
    private ArrayList<Fad> fade = new ArrayList<>();

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

    //Metoder til at vedligeholde forbindelsen til linkattributter
    public ArrayList<Fad> getFade() {
        return new ArrayList<>(fade);
    }

    public void addFad(Fad fad) {
        if(!fade.contains(fad)) {
            fade.add(fad);
            fad.addLager(this);
        }
    }

    public void removeFad(Fad fad) {
        if(fade.contains(fad)) {
            fade.remove(fad);
            fad.removeLager(this);
        }
    }


}
