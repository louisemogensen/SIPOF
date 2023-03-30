package Applikation.Model;

import java.time.LocalDate;

public class Whiskey {

    private double alkoholprocent;
    private LocalDate påfyldningsdato;

    // Linkattribut
    private Fad fad;

    public Whiskey(double alkoholprocent, LocalDate påfyldningsdato, Fad fad) {
        this.alkoholprocent = alkoholprocent;
        this.påfyldningsdato = påfyldningsdato;
        this.fad = fad;
    }

    public double getAlkoholprocent() {
        return alkoholprocent;
    }

    public void setAlkoholprocent(double alkoholprocent) {
        this.alkoholprocent = alkoholprocent;
    }

    public LocalDate getPåfyldningsdato() {
        return påfyldningsdato;
    }

    public void setPåfyldningsdato(LocalDate påfyldningsdato) {
        this.påfyldningsdato = påfyldningsdato;
    }

    // Metoder til at vedligeholde forbindelsen til linkattribut


    public Fad getFad() {
        return fad;
    }

    public void setFad(Fad fad) {
        this.fad = fad;
    }
}
