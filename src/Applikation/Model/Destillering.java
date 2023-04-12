package Applikation.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Destillering {

    private LocalDate startdato;
    private LocalDate slutdato;
    private String maltbatch;
    private String kornsort;
    private String medarbejder;
    private double mængdevæske;
    private double alkoholprocent;
    private String rygemateriale;
    private String kommentar;

    // Linkattribut
    private ArrayList<Fad> fade = new ArrayList<>();

    public Destillering(LocalDate startdato, LocalDate slutdato, String maltbatch, String kornsort, String medarbejder, double mængdevæske, double alkoholprocent, String rygemateriale, String kommentar) {
        this.startdato = startdato;
        this.slutdato = slutdato;
        this.maltbatch = maltbatch;
        this.kornsort = kornsort;
        this.medarbejder = medarbejder;
        this.mængdevæske = mængdevæske;
        this.alkoholprocent = alkoholprocent;
        this.rygemateriale = rygemateriale;
        this.kommentar = kommentar;
    }

    public LocalDate getStartdato() {
        return startdato;
    }

    public void setStartdato(LocalDate startdato) {
        this.startdato = startdato;
    }

    public LocalDate getSlutdato() {
        return slutdato;
    }

    public void setSlutdato(LocalDate slutdato) {
        this.slutdato = slutdato;
    }

    public String getMaltbatch() {
        return maltbatch;
    }

    public void setMaltbatch(String maltbatch) {
        this.maltbatch = maltbatch;
    }

    public String getKornsort() {
        return kornsort;
    }

    public void setKornsort(String kornsort) {
        this.kornsort = kornsort;
    }

    public String getMedarbejder() {
        return medarbejder;
    }

    public void setMedarbejder(String medarbejder) {
        this.medarbejder = medarbejder;
    }

    public double getMængdevæske() {
        return mængdevæske;
    }

    public void setMængdevæske(double mængdevæske) {
        this.mængdevæske = mængdevæske;
    }

    public double getAlkoholprocent() {
        return alkoholprocent;
    }

    public void setAlkoholprocent(double alkoholprocent) {
        this.alkoholprocent = alkoholprocent;
    }

    public String getRygemateriale() {
        return rygemateriale;
    }

    public void setRygemateriale(String rygemateriale) {
        this.rygemateriale = rygemateriale;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    // Metoder til at vedligeholde forbindelsen til linkattribut

    public ArrayList<Fad> getFade() {
        return new ArrayList<>(fade);
    }

    public void setFade(ArrayList<Fad> fade) {
        this.fade = fade;
    }

    public void addFad(Fad fad) {
        if(!fade.contains(fad)) {
            fade.add(fad);
            fad.setDestillering(this);
        }
    }

    public void removeFad(Fad fad) {
        if(fade.contains(fad)) {
            fade.remove(fad);
            fad.setDestillering(null);
        }
    }

    public void fordelVæske() {

        double volumeFyldtPå = 0;

        for (Fad fad : fade) {

            if (volumeFyldtPå < (mængdevæske - fad.getMaxVolume())) {
                volumeFyldtPå += fad.getMaxVolume();
                fad.setNuværendeVolume(fad.getMaxVolume());

            } else if (mængdevæske != volumeFyldtPå) {
                double sidstePåfyldning = mængdevæske - volumeFyldtPå;
                volumeFyldtPå += sidstePåfyldning;
                fad.setNuværendeVolume(sidstePåfyldning);
            }
        }

    }

    

}