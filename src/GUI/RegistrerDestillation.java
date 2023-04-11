package GUI;

import Applikation.Controller.Controller;
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

        Label lblDestillat = new Label("Destillat:");
        this.add(lblDestillat, 0, 0);
        this.add(txfDestillat, 1,0,1,2);

        Label lblLiter = new Label("Antal liter:");
        this.add(lblLiter, 0, 2);
        this.add(txfLiter, 1,2,1,2);

        Label lblAlkoholprocent = new Label("Alkoholprocent:");
        this.add(lblAlkoholprocent, 0, 4);
        this.add(txfAlkoholprocent,1,4,1,1);

        Label lblNewMake = new Label("New Make nummer:");
        this.add(lblNewMake, 0, 6);
        this.add(txfNewMake,1,6,1,1);

        Label lblFad = new Label("Fad:");
        this.add(lblFad, 3,2);
        this.add(lstFad, 4,2);

        this.add(btnRegistrer, 4,7);
    }

    public void updateControls() {
    }
}
