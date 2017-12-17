package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.text.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    ComboBox cmbOrdenar;

    @FXML
    Button btnBuscar, btnInsert;

    @FXML
    TextField txtxSearch, textInsert;

    @FXML
    Label lblMinimium , lblMaximium , lblSize;

    @FXML
    ListView listViewMostrar;

    @FXML
    VBox vbox;

    ArbolBinario arbolBinario = new ArbolBinario();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vbox.setAlignment(javafx.geometry.Pos.TOP_CENTER);

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "PreOrden",
                        "InOrden",
                        "PostOrden"
                );

        this.cmbOrdenar.setItems(options);


        this.btnInsert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                arbolBinario.insertarNod(Integer.parseInt(textInsert.getText()));
                textInsert.clear();
                vbox.getChildren().clear();

                vbox.getChildren().add(arbolBinario.printTree());

                lblMaximium.setText("Máximo " + String.valueOf(arbolBinario.maxs()));
                lblMinimium.setText("Mínimo " + String.valueOf(arbolBinario.mins()));
                lblSize.setText("Tamaño " + String.valueOf(arbolBinario.Size()));
            }
        });

        this.cmbOrdenar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String select = cmbOrdenar.getValue().toString();

                switch (select) {
                    case "PreOrden":
                        listViewMostrar.getItems().clear();
                        arbolBinario.preOrdens(listViewMostrar);
                        arbolBinario.mins();
                        break;

                    case "InOrden":
                        listViewMostrar.getItems().clear();
                        arbolBinario.inOrdens(listViewMostrar);
                        break;

                    case "PostOrden":
                        listViewMostrar.getItems().clear();
                        arbolBinario.postOrdens(listViewMostrar);
                        break;
                    default:

                }
            }
        });

        this.btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                arbolBinario.search(Integer.parseInt(txtxSearch.getText()));

            }
        });


    }



}
