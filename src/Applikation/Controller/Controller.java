package Applikation.Controller;

import Applikation.Model.*;
import Storage.Storage;

import java.time.LocalDate;
import java.util.List;

public class Controller {

    public static Fad createFad(String fadtype, int fadnummer, boolean erFadFyldt, String fadleverandør, Plads plads) {
        Fad fad = new Fad(fadtype, fadnummer, fadleverandør);
        Storage.addFad(fad);
        fad.setPlads(plads);
        return fad;
    }

    public static void deleteFad(Fad fad) {
        Storage.removeFad(fad);
    }

    public static void updateFad(Fad fad, String fadtype, int fadnummer) {
        fad.setFadtype(fadtype);
        fad.setFadnummer(fadnummer);
    }

    //------------------------------------------------------------------------------

    public static Lager createLager(String lokation, int maxAntalFade) {
        Lager lager = new Lager(lokation, maxAntalFade);
        Storage.addLager(lager);
        return lager;
    }

    public static void deleteLager(Lager lager) {Storage.removeLager(lager);}

    public static void updateLager(Lager lager, String lokation, int maxAntalPladser) {
        lager.setLokation(lokation);
        lager.setMaxAntalPladser(maxAntalPladser);
    }

    //------------------------------------------------------------------------------

    public static Plads createPlads(int hyldenummer, int pladsnummer, Lager lager) {
        Plads plads = new Plads(hyldenummer,pladsnummer);
        Storage.addPlads(plads);
        return plads;
    }

    public static void deletePlads(Plads plads) {Storage.removePlads(plads);}

    public static void updatePlads(Plads plads, int hyldenummer, int pladsnummer, Lager lager) {
        plads.setHyldenummer(hyldenummer);
        plads.setPladsnummer(pladsnummer);
        plads.setLager(lager);
    }

    //------------------------------------------------------------------------------
    public static Whiskey createWhiskey(double alkoholprocent, LocalDate påfyldningsdato, Fad fad) {
        Whiskey whiskey = new Whiskey(alkoholprocent, påfyldningsdato, fad);
        Storage.addWhiskey(whiskey);
        return whiskey;
    }

    public static void deleteWhiskey(Whiskey whiskey) {Storage.removeWhiskey(whiskey);}

    public static void updateWhiskey(Whiskey whiskey, double alkoholprocent, LocalDate påfyldningsdato, Fad fad) {
        whiskey.setAlkoholprocent(alkoholprocent);
        whiskey.setPåfyldningsdato(påfyldningsdato);
        whiskey.setFad(fad);
    }

    //------------------------------------------------------------------------------

    public List<Plads> getPladser() { return Storage.getPlads(); }

    public void initContent() {
        Lager lager1 = createLager("SWD",20);
        Lager lager2 = createLager("Hos landmand", 100);

        Plads plads1 = lager1.createPlads(1, 1);
        Plads plads2 = lager1.createPlads(1, 2);
        Plads plads3 = lager1.createPlads(1, 3);
        Plads plads4 = lager1.createPlads(1, 4);

        Fad fad = new Fad("Cherry", 1, "Himmeriggården");

        fad.setPlads(plads1);
    }




}