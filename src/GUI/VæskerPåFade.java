package GUI;

import Applikation.Controller.Controller;
import Applikation.Model.Destillering;
import Applikation.Model.Fad;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class VæskerPåFade extends GridPane {

    private ListView<Destillering> lvwDestillering;
    private ListView<Fad> lvwFade;
    private TextField txfAngivMængde;
    private Button btnFordel;

    public VæskerPåFade() {
        // show or hide grid lines
        this.setGridLinesVisible(false);
        // set padding of the this
        this.setPadding(new Insets(20));
        // set horizontal gap between components
        this.setHgap(10);
        // set vertical gap between components
        this.setVgap(10);

        Label lblDestillering = new Label("Vælg destillering");
        this.add(lblDestillering, 0, 1);

        lvwDestillering = new ListView<>();
        lvwDestillering.getItems().setAll(Controller.getDestilleringer());  //Det her virker ikke
        this.add(lvwDestillering, 0, 2, 1, 1);

        Label lblFade = new Label("Vælg fad");
        this.add(lblFade, 3, 1);

        lvwFade = new ListView<>();
        lvwFade.getItems().setAll(Controller.getFade());  //Det her virker ikke
        this.add(lvwFade, 3, 2, 1, 1);

        Label lblAngivMængde = new Label("Angiv mængde");
        this.add(lblAngivMængde, 0, 4);
        txfAngivMængde = new TextField();
        this.add(txfAngivMængde, 1, 4);

        btnFordel = new Button("Fordel");
        this.add(btnFordel, 5, 5);

        btnFordel.setOnAction(event -> this.);

    }

    public void updateControls() {
        lvwFade.getItems().setAll(Controller.getFade());
        lvwDestillering.getItems().setAll(Controller.getDestilleringer());
    }

    private void registrerVæskefordeling(Gridpane pane) {
        if(lvwDestillering.getSelectionModel().getSelectedItems() != null && lvwFade.getSelectionModel().getSelectedItems() != null && !txfAngivMængde.getText().isEmpty()) {
            //Der er ikk noget at oprette i controlleren
        }

    }


}
