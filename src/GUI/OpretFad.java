package GUI;

import Applikation.Controller.Controller;
import Applikation.Model.Fad;
import Applikation.Model.Plads;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class OpretFad extends Application {

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
    private ComboBox<Plads> lstHylde = new ComboBox<Plads>();

    //Buttons
    private Button btnOpretFad = new Button("Opret fad");
    private Button btnAnnuller = new Button("Annuller");

    //Text area
    private final TextArea txAInf = new TextArea();

    private Fad fade = null;
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

        Label lblLeverandør = new Label("Leverandør:");
        pane.add(lblLeverandør, 0, 0);
        pane.add(txfLeverandør, 1, 0, 1, 2);

        Label lblFadtype = new Label("Fadtype:");
        pane.add(lblFadtype, 0, 2);
        pane.add(txfFadtype, 1, 2, 1, 2);

        Label lblOpretFadnummer = new Label("Opret fadnummer:");
        pane.add(lblOpretFadnummer, 0, 4);
        pane.add(txfOpretFadnummer, 1, 4, 1, 1);


        lstHylde.getItems().setAll(controller.getPladser());
        lstHylde.setOnAction(event -> {Plads valgtPlads = lstHylde.getValue();
        fade.setPlads(valgtPlads);});
        Label lblHylde = new Label("Placer på hylde nr.:");
        pane.add(lblHylde, 2, 2);
        pane.add(lstHylde, 3, 2);


        pane.add(btnAnnuller, 3, 5);
        pane.add(btnOpretFad, 4, 5);

        // connect a method to the button
        btnOpretFad.setOnAction(event -> this.saveAction());
    }

    private void saveAction() {
        if (fade != null) {
            fade.setFadtype(txfFadtype.getText().trim());
            btnOpretFad.setDisable(true);
            clearFields();
        }
    }

    private void clearFields() {
        txfFadtype.clear();
        txfLeverandør.clear();
        txfOpretFadnummer.clear();
    }
}
