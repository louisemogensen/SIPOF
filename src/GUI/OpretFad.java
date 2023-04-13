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
    private TextField txfMaxVolume = new TextField();

    //Drop down comboBox
    private ComboBox<Plads> lstReol = new ComboBox<Plads>();

    private ComboBox<Lager> lstLagre = new ComboBox<Lager>();

    private ListView<Fad> lvwFade = new ListView<>();

    //Buttons
    private Button btnOpretFad = new Button("Opret fad");

    private Label lblError = new Label();


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

        Label lblMaxVolume = new Label("Angiv maxvolume");
        this.add(lblMaxVolume, 0, 7);
        this.add(txfMaxVolume, 1, 7);

        lstLagre.getItems().setAll(Controller.getLagre());
        Label lblLager = new Label("Angiv lager:");
        this.add(lblLager, 0, 9);
        this.add(lstLagre, 1, 9);

        lstReol.getItems().setAll(Controller.getPladser());
        Label lblReol = new Label("Angiv plads:");
        this.add(lblReol, 0, 11);
        this.add(lstReol, 1, 11);

        lvwFade.getItems().setAll(Controller.getFade());
        this.add(lvwFade, 5, 1, 1, 12);

        this.add(btnOpretFad, 6, 12);

        //Tilslutter metode til button
        btnOpretFad.setOnAction(event -> this.opretFadAction(this));
        this.add(lblError, 1, 13);
        System.out.println(Storage.getFade());

    }

    private void clearFields() {
        txfTidligereIndhold.clear();
        txfLeverandør.clear();
        txfFadnummer.clear();
        txfMaxVolume.clear();
    }

    private void opretFadAction(GridPane pane) {

        System.out.println("Fade: " + Storage.getFade());

        if (!txfTidligereIndhold.getText().isEmpty() && !txfLeverandør.getText().isEmpty() && !txfFadnummer.getText().isEmpty() && lstReol.getValue() != null) {

            try {
                Controller.createFad(txfTidligereIndhold.getText().trim(), Integer.parseInt(txfFadnummer.getText().trim()), txfLeverandør.getText().trim(), Double.parseDouble(txfMaxVolume.getText().trim()));

                //Fjerner den valgte plads fra ComboBox
                Plads valgtPlads = lstReol.getValue();
                lstReol.getItems().remove(valgtPlads);
                clearFields();
                lstReol.getSelectionModel().clearSelection();
                updateControls();

                lblError.setText("Fad registreret");

            } catch(IllegalArgumentException i) {
                lblError.setText(i.getMessage());
            }

        } else {
            lblError.setText("Alle felter skal udfyldes");
        }
    }

    public void updateControls() {
        lvwFade.getItems().setAll(Controller.getFade());
    }

}
