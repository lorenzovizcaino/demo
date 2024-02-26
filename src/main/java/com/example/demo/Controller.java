package com.example.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
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

    private ArrayList<Ciudad> ciudades = new ArrayList<>();

    String ciudad;




    @FXML
    void AsignarEstilo(ActionEvent event) {

    }

    @FXML
    void LimpiarEstilo(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ciudades.add(new Ciudad("Madrid", rutaAbsoluta + "\\imagenes\\Madrid.jpg"));
        ciudades.add(new Ciudad("Barcelona", rutaAbsoluta + "\\imagenes\\Barcelona.jpg"));
        ciudades.add(new Ciudad("Sevilla", rutaAbsoluta + "\\imagenes\\Sevilla.jpg"));
        ciudades.add(new Ciudad("Malaga", rutaAbsoluta + "\\imagenes\\Malaga.jpg"));
        ciudades.add(new Ciudad("Valencia", rutaAbsoluta + "\\imagenes\\Valencia.jpg"));
        ciudades.add(new Ciudad("Oporto", rutaAbsoluta + "\\imagenes\\Oporto.jpg"));
        for (Ciudad c: ciudades) {
            listView.getItems().add(c.getNombre());
        }


        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                ciudad=listView.getSelectionModel().getSelectedItem();
                for (Ciudad c:ciudades) {
                    if(c.getNombre().equals(ciudad)){
                        imgCiudades.setImage(new Image(c.getUrl()));
                    }
                }

            }
        });

    }
}
