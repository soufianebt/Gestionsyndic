package com.example.applicationgestionsyndic.Controllers;

import com.example.applicationgestionsyndic.DAL.CotisationDal;
import com.example.applicationgestionsyndic.Metier.Cotisation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AjouterCotisation implements Initializable {

    @FXML
    private Button unregister_btn;
    private BorderPane borderPane;
    private Cotisation cotisation;
    private CotisationDal cotisationDal = new CotisationDal();

    @FXML
    void enregistrer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cotisation.fxml"));
        Parent addCotisation = null;
        try {
            addCotisation = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cotisaController cotisaController = loader.getController();
        cotisaController.setBorderPane(borderPane);
        borderPane.setCenter(addCotisation);
    }
    public void initCotisation(Cotisation cotisation){
        System.out.println(cotisation.toString());
        this.cotisation = cotisation;
    }
    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
