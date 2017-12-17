package sample;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


import java.io.File;


public class ArbolBinario {
    private NodoArbol raiz;
    private int index;

    private void insertarNodo(int b , NodoArbol raiz){
        if (b < raiz.getDato()) {
            if (raiz.getIzq() == null) {
                raiz.setIzq(new NodoArbol(b));
            } else {
                insertarNodo(b , raiz.getIzq());
            }
        } else if (b > raiz.getDato()){
                if (raiz.getDer() == null) {
                    raiz.setDer(new NodoArbol(b));
                } else {
                    insertarNodo(b , raiz.getDer());
                }
        }
    }
    public void insertarNod(int b){
        if (raiz == null){
            raiz = new NodoArbol(b);
        }else{
            insertarNodo(b , raiz);
        }
    }

    private VBox createTree(NodoArbol raiz) {

        VBox vBox = new VBox();

       Label root= new Label(raiz.getDato() + "");
     root.setStyle("-fx-text-fill:Black; -fx-font-family: \"Comic Sans MS\"; -fx-font-size:14; -fx-font-style: italic; ");


        HBox hBox = new HBox();

        vBox.setSpacing(7);
        vBox.setAlignment(Pos.TOP_CENTER);
        hBox.setSpacing(7);
        hBox.setAlignment(Pos.TOP_CENTER);

        boolean hojas = false;

        if (raiz.getIzq() != null) {
            hBox.getChildren().add(createTree(raiz.getIzq()));
            hojas = true;
        }
        if (raiz.getDer() != null) {
            hBox.getChildren().add(createTree(raiz.getDer()));
            hojas = true;
        }

        Circle circle = createCircle();

        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);

        stackPane.getChildren().addAll(circle, root);
        vBox.getChildren().addAll(stackPane, insertArrow());

        if ( hojas) {
            vBox.getChildren().add(hBox);
        }
        return vBox;
    }



    private Circle createCircle() {
         Circle circle = new Circle();
         circle.setRadius(20);//Radio
         circle.setStroke(Color.FORESTGREEN);//Border del círulo
         circle.setFill(Color.AZURE);//Fondo del cículo

        return circle;
    }

    private VBox insertArrow(){
        VBox vBox = new VBox();
        ImageView flecha = null;
        try {
            //Obtenemos la imagen
            File archivo = new File("src/sample/image/flecha.png");
            Image image = new Image(archivo.toURI().toURL().toString());
            flecha = new ImageView(image);
            flecha.setFitHeight(40);
            flecha.setFitWidth(40);
        } catch (Exception e) {

        }
        vBox.setAlignment(Pos.CENTER);
        if (flecha != null) {
            //Agregamos la imagen al vbox
            vBox.getChildren().add(flecha);
        }
        return vBox;//Devolvemos un vbox
    }

    public VBox printTree(){
        return createTree(raiz);
    }
    private int size(NodoArbol raiz) {

        if (raiz != null) {
            index = 1;
            if (raiz.getIzq() != null) {
                index += size(raiz.getIzq());
            }
            if (raiz.getDer() != null) {
                index += size(raiz.getDer());
            }
        }
        return index;
    }

    public int Size(){
        return size(raiz);
    }

    private   void preOrden(NodoArbol raiz, ListView list) {
        if (raiz != null) {
            list.getItems().addAll(raiz.getDato());
           //System.out.print(raiz.getDato() + " ");
            preOrden(raiz.getIzq(), list);
            preOrden(raiz.getDer() , list);
        }
    }

    public void preOrdens(ListView listView){
        preOrden(raiz, listView);
    }

    private static void inOrden(NodoArbol raiz, ListView list) {
        if (raiz != null) {
            inOrden(raiz.getIzq(), list);
            list.getItems().addAll(raiz.getDato());
            inOrden(raiz.getDer(), list);
        }
    }

    public void inOrdens(ListView listView){
        inOrden(raiz, listView);
    }

    private static void postOrden(NodoArbol raiz, ListView list) {
        if (raiz != null) {
            postOrden(raiz.getIzq(), list);
            postOrden(raiz.getDer(), list);
            list.getItems().addAll(raiz.getDato());
            System.out.print(raiz.getDato() + " ");
        }
    }

    public void postOrdens(ListView listView){
        postOrden(raiz, listView);
    }

    private int max(NodoArbol raiz){
        while (raiz.getDer() !=null){
            raiz = raiz.getDer();
        }
        return raiz.getDato();
    }

    public int maxs(){
        return max(raiz);
    }

    private int min(NodoArbol raiz){
     while (raiz.getIzq() !=null){
         raiz = raiz.getIzq();
     }
     return raiz.getDato();
    }

    public int mins(){
        return min(raiz);
    }

    public void search(int b){
        while (raiz != null && b!= raiz.getDato()){
            if (b < raiz.getDato()){
                raiz = raiz.getIzq();
            }
            else {
                raiz = raiz.getIzq();
            }
        }
        Alert n = new Alert(Alert.AlertType.INFORMATION );
        n.setTitle("¡Encontrado!");
        n.setHeaderText(null);
        n.setContentText("El valor " + b + " fue encontrado");
        n.showAndWait();
    }



}
