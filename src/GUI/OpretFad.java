package GUI;

import Applikation.Controller.Controller;
import Applikation.Model.Fad;
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
        System.out.println("Test1");
        this.initContent(pane);
        System.out.println("Test2");
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        System.out.println("Test3");
        stage.show();
    }


    //Text fields
    private TextField txfLeverandør = new TextField();
    private TextField txfFadtype = new TextField();
    private TextField txfOpretFadnummer = new TextField();

    //Drop down comboBox
    private ComboBox<Plads> lstReol = new ComboBox<Plads>();

    //Buttons
    private Button btnOpretFad = new Button("Opret fad");
    private Button btnAnnuller = new Button("Annuller");

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

        Controller.initContent();

        Label lblLeverandør = new Label("Leverandør:");
        pane.add(lblLeverandør, 0, 0);
        pane.add(txfLeverandør, 1, 0, 1, 2);

        Label lblFadtype = new Label("Fadtype:");
        pane.add(lblFadtype, 0, 2);
        pane.add(txfFadtype, 1, 2, 1, 2);

        Label lblOpretFadnummer = new Label("Opret fadnummer:");
        pane.add(lblOpretFadnummer, 0, 4);
        pane.add(txfOpretFadnummer, 1, 4, 1, 1);

        lstReol.getItems().setAll(controller.getPladser());
        //lstReol.setOnAction(event -> {Plads valgtPlads = lstReol.getValue();
        //fade.setPlads(valgtPlads);});
        Label lblReol = new Label("Placer på reol nr.:");
        pane.add(lblReol, 2, 2);
        pane.add(lstReol, 3, 2);

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
