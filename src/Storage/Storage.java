package Storage;

import Applikation.Model.*;

import java.util.ArrayList;

public class Storage {

    public static ArrayList<Fad> fade = new ArrayList<Fad>();
    public static ArrayList<Lager> lagre = new ArrayList<Lager>();
    public static ArrayList<Plads> pladser = new ArrayList<Plads>();
    public static ArrayList<Whiskey> whiskeyArrayList = new ArrayList<Whiskey>();
    public static ArrayList<Destillering> destilleringArrayList = new ArrayList<Destillering>();

    //------------------------------------------------------------------------------

    public static ArrayList<Fad> getFade() {return new ArrayList<Fad>(fade);}

    public static void addFad(Fad fad) {fade.add(fad);}

    public static void removeFad(Fad fad) {fade.remove(fad);}

    //------------------------------------------------------------------------------

    public static ArrayList<Lager> getLagre() {return new ArrayList<Lager>(lagre);}

    public static void addLager(Lager lager) {lagre.add(lager);}

    public static void removeLager(Lager lager) {lagre.remove(lager);}

    //------------------------------------------------------------------------------

    public static ArrayList<Plads> getPlads() {return new ArrayList<Plads>(pladser);}

    public static void addPlads(Plads plads) {pladser.add(plads);}

    public static void removePlads(Plads plads) {pladser.remove(plads);}

    //------------------------------------------------------------------------------

    public static ArrayList<Whiskey> getWhiskey() {return new ArrayList<Whiskey>(whiskeyArrayList);}

    public static void addWhiskey(Whiskey whiskey) {whiskeyArrayList.add(whiskey);}

    public static void removeWhiskey(Whiskey whiskey) {whiskeyArrayList.remove(whiskey);}

    //------------------------------------------------------------------------------

    public static ArrayList<Destillering> getDestillering() {return new ArrayList<Destillering>(destilleringArrayList);}

    public static void addDestillering(Destillering destillering) {destilleringArrayList.add(destillering);}

    public static void removeDestillering(Destillering destillering) {destilleringArrayList.remove(destillering);}
}
