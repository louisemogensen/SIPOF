package Applikation.Controller;

import Applikation.Model.*;
import Storage.Storage;

import javax.swing.plaf.synth.ColorType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public static Plads createPlads(int reolnummer, int pladsnummer, Lager lager) {
        Plads plads = lager.createPlads(reolnummer, pladsnummer);
        Storage.addPlads(plads);
        return plads;
    }

    public static void deletePlads(Plads plads) {Storage.removePlads(plads);}

    public static void updatePlads(Plads plads, int reolnummer, int pladsnummer, Lager lager) {
        plads.setReolnummer(reolnummer);
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
    public static Destillering createDestillering(LocalDateTime startdato, LocalDateTime slutdato, String maltbatch, String kornsort, String medarbejder, double mængdevæske, double alkoholprocent, String rygemateriale, String kommentar) {
        Destillering destillering = new Destillering(startdato, slutdato, maltbatch, kornsort,medarbejder,mængdevæske, alkoholprocent, rygemateriale, kommentar);
        Storage.addDestillering(destillering);
        return destillering;
    }

    public static void deleteDestillering(Destillering destillering) {Storage.removeDestillering(destillering);}

    public static void updateDestillering(Destillering destillering, LocalDateTime startdato, LocalDateTime slutdato, String maltbatch, String kornsort, String medarbejder, double mængdevæske, double alkoholprocent, String rygemateriale, String kommentar) {
        destillering.setStartdato(startdato);
        destillering.setSlutdato(slutdato);
        destillering.setMaltbatch(maltbatch);
        destillering.setKornsort(kornsort);
        destillering.setMedarbejder(medarbejder);
        destillering.setMængdevæske(mængdevæske);
        destillering.setAlkoholprocent(alkoholprocent);
        destillering.setRygemateriale(rygemateriale);
        destillering.setKommentar(kommentar);
    }

    //------------------------------------------------------------------------------

    public static List<Plads> getPladser() { return Storage.getPlads(); }

    public static void initContent() {

        // Version 1.0 start

        Lager lager1 = createLager("SWD",20);
        Lager lager2 = createLager("Hos landmand", 100);

        Plads plads1 = Controller.createPlads(1, 1, lager1);
        Plads plads2 = Controller.createPlads(1, 2, lager1);
        Plads plads3 = Controller.createPlads(1, 3, lager2);
        Plads plads4 = Controller.createPlads(1, 4, lager2);

        Fad fad = new Fad("Cherry", 1, "Himmeriggården");

        fad.setPlads(plads1);

        System.out.println(Storage.getPlads());

        // Version 1.0 slut
    }




}