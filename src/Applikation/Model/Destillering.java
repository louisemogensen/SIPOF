package Applikation.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Destillering {

    private LocalDate startdato;
    private LocalDate slutdato;
    private String maltbatch;
    private String kornsort;
    private String medarbejdeR;
    private double mængdevæske;
    private double alkoholprocent;
    private String rygemateriale;
    private String kommentar;

    // Linkattribut
    private ArrayList<Fad> fade = new ArrayList<>();

    public Destillering(LocalDate startdato, LocalDate slutdato, String maltbatch, String kornsort, String medarbejdeR, double mængdevæske, double alkoholprocent, String rygemateriale, String kommentar) {
        this.startdato = startdato;
        this.slutdato = slutdato;
        this.maltbatch = maltbatch;
        this.kornsort = kornsort;
        this.medarbejdeR = medarbejdeR;
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

    public String getMedarbejdeR() {
        return medarbejdeR;
    }

    public void setMedarbejdeR(String medarbejdeR) {
        this.medarbejdeR = medarbejdeR;
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
}