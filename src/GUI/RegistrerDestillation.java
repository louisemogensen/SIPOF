package GUI;

import Applikation.Controller.Controller;
import Applikation.Model.Destillering;
import Applikation.Model.Fad;
import Applikation.Model.Plads;
import Storage.Storage;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistrerDestillation extends GridPane{

    private TextField txfDestillat;
    private TextField txfMaltbatch;
    private TextField txfKornsort;
    private TextField txfMedarbejder;
    private TextField txfVæskemængde;
    private TextField txfAlkoholprocent;
    private TextField txfRygemateriale;

    private TextArea txaKommentar;

    private DatePicker dtpStartDato;
    private DatePicker dtpSlutDato;

    private ComboBox<Fad> lstFad = new ComboBox<Fad>();

    private Button btnRegistrer = new Button("Registrer");

    //this
    public RegistrerDestillation() {
        // show or hide grid lines
        this.setGridLinesVisible(false);
        // set padding of the this
        this.setPadding(new Insets(20));
        // set horizontal gap between components
        this.setHgap(10);
        // set vertical gap between components
        this.setVgap(10);

        Label lblDestillat = new Label("Navn på destillat:");
        this.add(lblDestillat, 1, 0);
        txfDestillat = new TextField();
        this.add(txfDestillat, 2,0);

        Label lblStartDato = new Label("Startdato:");
        this.add(lblStartDato, 1, 2);
        dtpStartDato = new DatePicker();
        this.add(dtpStartDato, 2, 2);

        Label lblSlutDato = new Label("Slutdato:");
        this.add(lblSlutDato, 1, 3);
        dtpSlutDato = new DatePicker();
        this.add(dtpSlutDato, 2, 3);

        Label lblMaltbatch = new Label("Maltbatch:");
        this.add(lblMaltbatch, 1, 6);
        txfMaltbatch = new TextField();
        this.add(txfMaltbatch, 2, 6);

        Label lblKornsort = new Label("Kornsort:");
        this.add(lblKornsort, 1, 8);
        txfKornsort = new TextField();
        this.add(txfKornsort, 2, 8);

        Label lblMedarbejder = new Label("Medarbejder:");
        this.add(lblMedarbejder, 1, 10);
        txfMedarbejder = new TextField();
        this.add(txfMedarbejder, 2, 10);

        Label lblVæskemængde = new Label("Væskemængde:");
        this.add(lblVæskemængde, 1, 12);
        txfVæskemængde = new TextField();
        this.add(txfVæskemængde, 2, 12);

        Label lblAlkoholprocent = new Label("Alkoholprocent:");
        this.add(lblAlkoholprocent, 1, 14);
        txfAlkoholprocent = new TextField();
        this.add(txfAlkoholprocent, 2, 14);

        Label lblRygemateriale = new Label("Rygemateriale:");
        this.add(lblRygemateriale, 1, 16);
        txfRygemateriale = new TextField();
        this.add(txfRygemateriale, 2, 16);

        Label lblKommentar = new Label("Kommentar:");
        this.add(lblKommentar, 1, 18);
        txaKommentar = new TextArea();
        this.add(txaKommentar, 2, 18);
        txaKommentar.setEditable(true);

        this.add(btnRegistrer, 4,20);
        //Tilslutter metode til button
        btnRegistrer.setOnAction(event -> this.registrerDestillationAction(this));
    }


    public void updateControls() {
    }

    private void registrerDestillationAction(GridPane pane) {

        if (!txfDestillat.getText().isEmpty() && dtpStartDato.getValue() != null && dtpSlutDato.getValue() != null && (!dtpStartDato.getValue().isAfter(dtpSlutDato.getValue())) && !txfMaltbatch.getText().isEmpty() && !txfKornsort.getText().isEmpty() && !txfMedarbejder.getText().isEmpty() && !txfVæskemængde.getText().isEmpty() && !txfAlkoholprocent.getText().isEmpty()) {
            Controller.createDestillering(txfDestillat.getText().trim(), dtpStartDato.getValue(), dtpSlutDato.getValue(), txfMaltbatch.getText().trim(), txfKornsort.getText().trim(), txfMedarbejder.getText().trim(), Double.parseDouble(txfVæskemængde.getText().trim()), Double.parseDouble(txfAlkoholprocent.getText().trim()), txfRygemateriale.getText().trim(), txaKommentar.getText().trim());

            clearFields();

            Label lblFadRegistreret = new Label("Destillat registreret");
            pane.add(lblFadRegistreret, 1, 20);

        } else {
            Label lblUdfyldAlleFelter = new Label("Alle felter skal udfyldes");
            pane.add(lblUdfyldAlleFelter, 1, 20);

        }
    }

    private void clearFields() {
        txfVæskemængde.clear();
        txfMaltbatch.clear();
        txfMedarbejder.clear();
        txfKornsort.clear();
        txfDestillat.clear();
        txfAlkoholprocent.clear();
        txfRygemateriale.clear();
        dtpStartDato.setValue(null);
        dtpSlutDato.setValue(null);
        txaKommentar.clear();
    }


}
