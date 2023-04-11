package GUI;

import Applikation.Model.Fad;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrerDestillation extends GridPane{

    private TextField txfDestillat = new TextField();
    private TextField txfLiter = new TextField();
    private TextField txfAlkoholprocent = new TextField();
    private TextField txfNewMake = new TextField();

    private ComboBox<Fad> lstFad = new ComboBox<Fad>();

    private Button btnRegistrer = new Button("Registrer");


    //Stage
    public void start(Stage stage) {
        stage.setTitle("SIPOF");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

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

        Label lblDestillat = new Label("Destillat:");
        pane.add(lblDestillat, 0, 0);
        pane.add(txfDestillat, 1,0,1,2);

        Label lblLiter = new Label("Antal liter:");
        pane.add(lblLiter, 0, 2);
        pane.add(txfLiter, 1,2,1,2);

        Label lblAlkoholprocent = new Label("Alkoholprocent:");
        pane.add(lblAlkoholprocent, 0, 4);
        pane.add(txfAlkoholprocent,1,4,1,1);

        Label lblNewMake = new Label("New Make nummer:");
        pane.add(lblNewMake, 0, 6);
        pane.add(txfNewMake,1,6,1,1);

        Label lblFad = new Label("Fad:");
        pane.add(lblFad, 3,2);
        pane.add(lstFad, 4,2);

        pane.add(btnRegistrer, 4,7);
    }

    public void updateControls() {
    }
}
