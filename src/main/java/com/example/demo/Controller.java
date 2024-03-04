package com.example.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button btnAsignarEstilo;

    @FXML
    private Button btnLimpiarEstilo;

    @FXML
    private ImageView imgCiudades;

    @FXML
    private ListView<String> listView;
    private String rutaAbsoluta = new File("src\\main\\resources").getAbsolutePath();

   // private ArrayList<Ciudad> ciudades = new ArrayList<>();
    private ObservableList<Ciudad> ciudades;

    String ciudad;




    @FXML
    void AsignarEstilo(ActionEvent event) {

        Scene scene=anchorPane.getScene();
        try{
            scene.getStylesheets().clear();
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/style.css")).toExternalForm());
        }catch (Exception e){
            System.out.println("no lo encuentro");
        }


    }

    @FXML
    void LimpiarEstilo(ActionEvent event) {
        Scene scene=anchorPane.getScene();
        try{
            scene.getStylesheets().clear();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //ConArrayList();
        ConObservableArrayList();

        for (Ciudad c: ciudades) {
            listView.getItems().add(c.getNombre());
        }
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String ciudadAntigua, String ciudadNueva) {
                ciudad=ciudadNueva;//listView.getSelectionModel().getSelectedItem();
                for (Ciudad c:ciudades) {
                    if(c.getNombre().equals(ciudad)){
                        imgCiudades.setImage(new Image(c.getUrl()));
                    }
                }
            }
        });
    }

    private void ConObservableArrayList() {
        //comentar esta metodo cuando no se utilice, sino da error
        ciudades = FXCollections.observableArrayList(
                (new Ciudad("Madrid", rutaAbsoluta + "\\imagenes\\Madrid.jpg")),
                (new Ciudad("Barcelona", rutaAbsoluta + "\\imagenes\\Barcelona.jpg")),
                (new Ciudad("Sevilla", rutaAbsoluta + "\\imagenes\\Sevilla.jpg")),
                (new Ciudad("Malaga", rutaAbsoluta + "\\imagenes\\Malaga.jpg")),
                (new Ciudad("Valencia", rutaAbsoluta + "\\imagenes\\Valencia.jpg")),
                (new Ciudad("Oporto", rutaAbsoluta + "\\imagenes\\Oporto.jpg"))
        );


    }

    private void ConArrayList() {
        ciudades.add(new Ciudad("Madrid", rutaAbsoluta + "\\imagenes\\Madrid.jpg"));
        ciudades.add(new Ciudad("Barcelona", rutaAbsoluta + "\\imagenes\\Barcelona.jpg"));
        ciudades.add(new Ciudad("Sevilla", rutaAbsoluta + "\\imagenes\\Sevilla.jpg"));
        ciudades.add(new Ciudad("Malaga", rutaAbsoluta + "\\imagenes\\Malaga.jpg"));
        ciudades.add(new Ciudad("Valencia", rutaAbsoluta + "\\imagenes\\Valencia.jpg"));
        ciudades.add(new Ciudad("Oporto", rutaAbsoluta + "\\imagenes\\Oporto.jpg"));

    }
}
