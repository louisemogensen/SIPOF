package Applikation.Controller;

import Applikation.Model.Fad;
import Applikation.Model.Lager;
import Applikation.Model.Plads;
import Storage.Storage;

import java.util.List;

public class Controller {

    public static Fad createFad(String fadtype, String fadleverandør, int fadnummer, boolean erFadFyldt) {
        Fad fad = new Fad(fadtype, fadleverandør, fadnummer, erFadFyldt);
        Storage.addFad(fad);
        return fad;
    }

    public static void deleteFad(Fad fad) {
        Storage.removeFad(fad);
    }

    public static void updateFad(Fad fad, String fadtype, int fadnummer, boolean erFadFyldt) {
        fad.setFadtype(fadtype);
        fad.setFadnummer(fadnummer);
        fad.setErFadFyldt(erFadFyldt);
    }

    //------

    public static Lager createLager(String lokation, int ledigepladser, int antalFade, int maxAntalFade) {
        Lager lager = new Lager(lokation, ledigepladser, antalFade, maxAntalFade);
        Storage.addLager(lager);
        return lager;
    }

    public static void deleteLager(Lager lager) {Storage.removeLager(lager);}

    public static void updateLager(Lager lager, String lokation, int ledigepladser, int antalFade, int maxAntalFade) {
        lager.setLokation(lokation);
        lager.setLedigepladser(ledigepladser);
        lager.setAntalFade(antalFade);
        lager.setMaxAntalFade(maxAntalFade);
    }

    //-----

    public static Plads createPlads(int hyldenummer, int pladsnummer, Lager lager) {
        Plads plads = new Plads(hyldenummer,pladsnummer,lager);
        Storage.addPlads(plads);
        return plads;
    }

    public static void deletePlads(Plads plads) {Storage.removePlads(plads);}

    public static void updatePlads(Plads plads, int hyldenummer, int pladsnummer, Lager lager) {
        plads.setHyldenummer(hyldenummer);
        plads.setPladsnummer(pladsnummer);
        plads.setLager(lager);
    }

    public List<Plads> getPladser() { return Storage.getPlads(); }
/*
    public static void initContent() {
        Fad fad = new Fad("Cherry", 1, true);
        Lager lager1 = new Lager("Sall Whiskey Distellery", 60, 40, 100);
        Plads plads = new Plads(1, 1, lager1);
        fad.setPlads(plads);


    }
*/

}