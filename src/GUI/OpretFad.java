package GUI;

import Applikation.Controller.Controller;
import Applikation.Model.Fad;
import Applikation.Model.Lager;
import Applikation.Model.Plads;
import Storage.Storage;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpretFad extends GridPane {

    //Text fields
    private TextField txfLeverandør = new TextField();
    private TextField txfTidligereIndhold = new TextField();
    private TextField txfFadnummer = new TextField();

    //Drop down comboBox
    private ComboBox<Plads> lstReol = new ComboBox<Plads>();

    private ComboBox<Lager> lstLagre = new ComboBox<Lager>();

    //Buttons
    private Button btnOpretFad = new Button("Opret fad");


    //Pane
    public OpretFad() {
        // show or hide grid lines
        this.setGridLinesVisible(false);
        // set padding of the pane
        this.setPadding(new Insets(20));
        // set horizontal gap between components
        this.setHgap(10);
        // set vertical gap between components
        this.setVgap(10);


        Label lblLeverandør = new Label("Leverandør:");
        this.add(lblLeverandør, 0, 1);
        this.add(txfLeverandør, 1, 1, 1, 2);

        Label lblTidligereIndhold = new Label("Tidligere indhold:");
        this.add(lblTidligereIndhold, 0, 3);
        this.add(txfTidligereIndhold, 1, 3, 1, 2);

        Label lblFadnummer = new Label("Fadnummer:");
        this.add(lblFadnummer, 0, 5);
        this.add(txfFadnummer, 1, 5, 1, 1);

        lstLagre.getItems().setAll(Controller.getLagre());
        Label lblLager = new Label("Angiv lager:");
        this.add(lblLager, 0, 7);
        this.add(lstLagre, 1, 7);


        lstReol.getItems().setAll(Controller.getPladser());
        Label lblReol = new Label("Angiv plads:");
        this.add(lblReol, 0, 9);
        this.add(lstReol, 1, 9);

        this.add(btnOpretFad, 5, 9);

        //Tilslutter metode til button
        btnOpretFad.setOnAction(event -> this.opretFadAction(this));
    }

    private void clearFields() {
        txfTidligereIndhold.clear();
        txfLeverandør.clear();
        txfFadnummer.clear();
    }

    private void opretFadAction(GridPane pane) {

        if (!txfTidligereIndhold.getText().isEmpty() && !txfLeverandør.getText().isEmpty() && !txfFadnummer.getText().isEmpty() && lstReol.getValue() != null) {
            Fad nytFad = new Fad(txfTidligereIndhold.getText().trim(), Integer.parseInt(txfFadnummer.getText().trim()), txfLeverandør.getText().trim());

                //Fjerner den valgte plads fra ComboBox
                Plads valgtPlads = lstReol.getValue();
                lstReol.getItems().remove(valgtPlads);

                Storage.addFad(nytFad);
                clearFields();
                lstReol.getSelectionModel().clearSelection();

                Label lblFadRegistreret = new Label("Fad registreret");
                pane.add(lblFadRegistreret, 1, 11);

            } else {
                Label lblUdfyldAlleFelter = new Label("Alle felter skal udfyldes");
                pane.add(lblUdfyldAlleFelter, 1, 11);

            }
        }
    }
