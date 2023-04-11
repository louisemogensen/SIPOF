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
    private TextField txfTidligereIndhold = new TextField();
    private TextField txfFadnummer = new TextField();

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

        //Tabs
        TabPane tabPane = new TabPane();

        //Opretter tabs
        Tab tabFad = new Tab("Opret fad");
        tabPane.getTabs().add(tabFad);
        tabFad.setClosable(false);
        Tab tabDestillation = new Tab("Registrer destillation");
        tabPane.getTabs().add(tabDestillation);
        tabDestillation.setClosable(false);
        Tab tabWhisky = new Tab("Registrer Whisky");
        tabPane.getTabs().add(tabWhisky);
        tabWhisky.setClosable(false);
        Tab tabVæsker = new Tab("Væsker på fade");
        tabPane.getTabs().add(tabVæsker);
        tabVæsker.setClosable(false);

        //Tilføjes til gridPane
        pane.add(tabPane, 0, 0, 5, 1);

        //Registrer destillation tab
        RegistrerDestillation registrerDestillation = new RegistrerDestillation();
        tabDestillation.setContent(registrerDestillation);
        tabDestillation.setOnSelectionChanged(event -> {
            if (tabDestillation.isSelected()) {
                tabDestillation.setContent(registrerDestillation);
            }
        });

        //Registrer whisky tab
        RegistrerWhisky registrerWhisky = new RegistrerWhisky();
        tabWhisky.setContent(registrerWhisky);
        VæskerPåFade væskerPåFade = new VæskerPåFade();
        tabVæsker.setContent(væskerPåFade);

        //Opdaterer når tabs er valgt
        tabDestillation.setOnSelectionChanged(event -> registrerDestillation.updateControls());
        tabWhisky.setOnSelectionChanged(event -> registrerWhisky.updateControls());
        tabVæsker.setOnSelectionChanged(event -> væskerPåFade.updateControls());


        Label lblLeverandør = new Label("Leverandør:");
        pane.add(lblLeverandør, 0, 1);
        pane.add(txfLeverandør, 1, 1, 1, 2);

        Label lblTidligereIndhold = new Label("Tidligere indhold:");
        pane.add(lblTidligereIndhold, 0, 3);
        pane.add(txfTidligereIndhold, 1, 3, 1, 2);

        Label lblFadnummer = new Label("Fadnummer:");
        pane.add(lblFadnummer, 0, 5);
        pane.add(txfFadnummer, 1, 5, 1, 1);

        lstLagre.getItems().setAll(controller.getLagre());
        Label lblLager = new Label("Angiv lager:");
        pane.add(lblLager, 0, 7);
        pane.add(lstLagre, 1, 7);

        lstReol.getItems().setAll(controller.getPladser());
        Label lblReol = new Label("Angiv plads:");
        pane.add(lblReol, 0, 9);
        pane.add(lstReol, 1, 9);

        pane.add(btnOpretFad, 5, 9);

        //Tilslutter metode til button
        btnOpretFad.setOnAction(event -> this.opretFadAction(pane));
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
