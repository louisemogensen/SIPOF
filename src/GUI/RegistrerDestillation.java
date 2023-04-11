package GUI;

import Applikation.Controller.Controller;
import Applikation.Model.Fad;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistrerDestillation extends GridPane{

    private ComboBox<Fad> lstFad = new ComboBox<Fad>();

    private Button btnRegistrer = new Button("Registrer");

    private Controller controller;

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

        Controller.initContent();

        Label lblDestillat = new Label("Navn på destillat:");
        this.add(lblDestillat, 1, 0);
        TextField txfDestillat = new TextField();
        this.add(txfDestillat, 2,0);

        Label lblStartDato = new Label("Startdato:");
        this.add(lblStartDato, 1, 2);
        TextField txfStartDato = new TextField();
        this.add(txfStartDato, 2, 2);

        Label lblAngivDato = new Label("Dato angives som dd-mm-åååå");
        this.add(lblAngivDato, 4, 2);

        Label lblSlutDato = new Label("Slutdato:");
        this.add(lblSlutDato, 1, 4);
        TextField txfSlutDato = new TextField();
        this.add(txfSlutDato, 2, 4);

        Label lblMaltbatch = new Label("Maltbatch:");
        this.add(lblMaltbatch, 1, 6);
        TextField txfMaltbatch = new TextField();
        this.add(txfMaltbatch, 2, 6);

        Label lblKornsort = new Label("Kornsort:");
        this.add(lblKornsort, 1, 8);
        TextField txfKornsort = new TextField();
        this.add(txfKornsort, 2, 8);

        Label lblMedarbejder = new Label("Medarbejder:");
        this.add(lblMedarbejder, 1, 10);
        TextField txfMedarbejder = new TextField();
        this.add(txfMedarbejder, 2, 10);

        Label lblVæskemængde = new Label("Væskemængde:");
        this.add(lblVæskemængde, 1, 12);
        TextField txfVæskemængde = new TextField();
        this.add(txfVæskemængde, 2, 12);

        Label lblAlkoholprocent = new Label("Alkoholprocent:");
        this.add(lblAlkoholprocent, 1, 14);
        TextField txfAlkoholprocent = new TextField();
        this.add(txfAlkoholprocent, 2, 14);

        Label lblRygemateriale = new Label("Rygemateriale:");
        this.add(lblRygemateriale, 1, 16);
        TextField txfRygemateriale = new TextField();
        this.add(txfRygemateriale, 2, 16);

        Label lblKommentar = new Label("Kommentar:");
        this.add(lblKommentar, 1, 18);
        TextArea txaKommentar = new TextArea();
        this.add(txaKommentar, 2, 18);
        txaKommentar.setEditable(true);

        this.add(btnRegistrer, 4,18);
    }

    public void updateControls() {
    }
}
