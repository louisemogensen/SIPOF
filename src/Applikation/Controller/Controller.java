package Applikation.Controller;

import Applikation.Model.Fad;
import Storage.Storage;

public class Controller {

    public static Fad createFad(String fadtype, int fadnummer, boolean erFadFyldt) {
        Fad fad = new Fad(fadtype, fadnummer, erFadFyldt);
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



}