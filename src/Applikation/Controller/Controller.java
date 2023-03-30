package Applikation.Controller;

import Applikation.Model.*;
import Storage.Storage;

import java.time.LocalDate;
import java.util.List;

public class Controller {

    public static Fad createFad(String fadtype, int fadnummer, boolean erFadFyldt, String fadleverandør, Destillering destillering) {
        Fad fad = new Fad(fadtype, fadnummer, erFadFyldt, fadleverandør, destillering);
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

    //------------------------------------------------------------------------------

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

    //------------------------------------------------------------------------------

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

    }




}