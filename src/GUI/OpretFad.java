package GUI;

import Applikation.Controller.Controller;
import Applikation.Model.Fad;
import Applikation.Model.Lager;
import Applikation.Model.Plads;
import Storage.Storage;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class OpretFad extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("SIPOF");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    //Text fields
    private TextField txfLeverandør = new TextField();
    private TextField txfFadtype = new TextField();
    private TextField txfOpretFadnummer = new TextField();

    //Drop down comboBox
    private ComboBox<Plads> lstReol = new ComboBox<Plads>();

    private ComboBox<Lager> lstLagre = new ComboBox<Lager>();

    //Buttons
    private Button btnOpretFad = new Button("Opret fad");

    private Controller controller;


    //Pane
    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Controller.initContent();

        Label lblLeverandør = new Label("Leverandør:");
        pane.add(lblLeverandør, 0, 0);
        pane.add(txfLeverandør, 1, 0, 1, 2);

        Label lblFadtype = new Label("Tidligere indhold:");
        pane.add(lblFadtype, 0, 2);
        pane.add(txfFadtype, 1, 2, 1, 2);

        Label lblOpretFadnummer = new Label("Fadnummer:");
        pane.add(lblOpretFadnummer, 0, 4);
        pane.add(txfOpretFadnummer, 1, 4, 1, 1);

        lstLagre.getItems().setAll(controller.getLagre());
        Label lblLager = new Label("Angiv lager:");
        pane.add(lblLager, 0, 5);
        pane.add(lstLagre, 1, 5);

        lstReol.getItems().setAll(controller.getPladser());
        Label lblReol = new Label("Placer på reol nr.:");
        pane.add(lblReol, 0, 7);
        pane.add(lstReol, 1, 7);

        pane.add(btnOpretFad, 4, 7);

        // connect a method to the button
        btnOpretFad.setOnAction(event -> this.opretFadAction());
    }

    private void clearFields() {
        txfFadtype.clear();
        txfLeverandør.clear();
        txfOpretFadnummer.clear();
    }

    private void opretFadAction() {
        if (!txfFadtype.getText().isEmpty() && !txfLeverandør.getText().isEmpty() && !txfOpretFadnummer.getText().isEmpty() && lstReol.getValue() != null) {
            Fad nytFad = new Fad(txfFadtype.getText().trim(), Integer.valueOf(txfOpretFadnummer.getText().trim()), txfLeverandør.getText().trim());
            Storage.addFad(nytFad);
            clearFields();
            lstReol.getSelectionModel().clearSelection();
            System.out.println("Fad registreret");  //Denne besked kommer i konsollen og ikke i appen
        } else {
            System.out.println("Alle felter skal udfyldes."); //Denne besked kommer i konsollen og ikke i appen
        }
    }
}
