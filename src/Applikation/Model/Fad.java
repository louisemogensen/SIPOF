package Applikation.Model;

import java.util.ArrayList;

public class Fad {

    private String fadtype;
    private int fadnummer;
    private String fadleverandør;

    private double maxVolume;

    private double nuværendeVolume;

    // Linkattributter

    private Destillering destillering;
    private Plads plads;
    private ArrayList<Whiskey> whiskeyArrayList = new ArrayList<>();

    public Fad(String fadtype, int fadnummer,  String fadleverandør, double maxVolume) {
        this.fadtype = fadtype;
        this.fadnummer = fadnummer;
        this.fadleverandør = fadleverandør;
        this.maxVolume = maxVolume;
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

    public String getFadleverandør() {
        return fadleverandør;
    }

    public void setFadleverandør(String fadleverandør) {
        this.fadleverandør = fadleverandør;
    }

    public double getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(double maxVolume) {
        this.maxVolume = maxVolume;
    }

    public double getNuværendeVolume() {
        return nuværendeVolume;
    }

    public void setNuværendeVolume(double nuværendeVolume) {
        this.nuværendeVolume = nuværendeVolume;
    }

    // Metoder til at vedligeholde forbindelsen til linkattributter


    public Destillering getDestillering() {
        return destillering;
    }

    public void setDestillering(Destillering destillering) {
        this.destillering = destillering;
    }

    public Plads getPlads() {
        return plads;
    }

    public void setPlads(Plads plads) {
        if(this.plads != plads) {
            this.plads = plads;
        }
    }

    public ArrayList<Whiskey> getWhiskeyArrayList() {
        return whiskeyArrayList;
    }

    public void setWhiskeyArrayList(ArrayList<Whiskey> whiskeyArrayList) {
        this.whiskeyArrayList = whiskeyArrayList;
    }

    public void addWhiskey(Whiskey whiskey) {
        if(!whiskeyArrayList.contains(whiskey)) {
            whiskeyArrayList.add(whiskey);
            whiskey.setFad(this);
        }
    }

    public void removeWhiskey(Whiskey whiskey) {
        if(whiskeyArrayList.contains(whiskey)) {
            whiskeyArrayList.remove(whiskey);
            whiskey.setFad(null);
        }
    }
}