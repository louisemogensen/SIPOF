package GUI;

import Applikation.Controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Start extends Application {

    @Override
    public void init() {
        Controller.initContent();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("SIPOF");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

        private void initTabPane(TabPane tabPane) {
            tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

            Tab tabFad = new Tab("Opret fad");
            tabPane.getTabs().add(tabFad);

            OpretFad opretFad = new OpretFad();
            tabFad.setContent(opretFad);

            Tab tabDestillation = new Tab("Registrer destillation");
            tabPane.getTabs().add(tabDestillation);

            RegistrerDestillation registrerDestillation = new RegistrerDestillation();
            tabDestillation.setContent(registrerDestillation);
            tabDestillation.setOnSelectionChanged(event -> registrerDestillation.updateControls());

            Tab tabWhisky = new Tab("Registrer Whisky");
            tabPane.getTabs().add(tabWhisky);
            tabWhisky.setClosable(false);
            Tab tabVæsker = new Tab("Væsker på fade");
            tabPane.getTabs().add(tabVæsker);
            tabVæsker.setClosable(false);

            RegistrerWhisky registrerWhisky = new RegistrerWhisky();
            tabWhisky.setContent(registrerWhisky);
            VæskerPåFade væskerPåFade = new VæskerPåFade();
            tabVæsker.setContent(væskerPåFade);
        }
    }
