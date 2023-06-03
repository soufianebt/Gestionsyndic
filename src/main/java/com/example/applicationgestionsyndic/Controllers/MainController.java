package com.example.applicationgestionsyndic.Controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController extends Application {
    @FXML
    private Button copro_btn;

    @FXML
    private Button cotisation_btn;

    @FXML
    private Button dec_btn;

    @FXML
    private Button depenses_btn;

    @FXML
    private Button reunions_btn;

    @FXML
    private Button tabBord_btn;

    @FXML
    private Button unite_btn;
    @FXML
    private AnchorPane principale;
    @FXML
    private BorderPane mainContainer;
    public void SwitchPage(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String fxmlPath = "";
        String buttonId = clickedButton.getId();
        switch (buttonId){
            case "tabBord_btn":
                fxmlPath = "Home.fxml";
                break;
            case "reunions_btn":
                fxmlPath = "reunion.fxml";
                break;
            case "copro_btn":
                fxmlPath = "Immeuble.fxml";
                break;
            case "unite_btn":
                fxmlPath = "Unite.fxml";
                break;
            case "cotisations_btn":
                fxmlPath = "cotisation.fxml";
                break;
            case "depenses_btn":
                fxmlPath = "depense.fxml";
                break;
            case "dec_btn":
                break;

        }
        try {
            if(fxmlPath == "") return;
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent content = loader.load();
            switch (buttonId){
                case "cotisations_btn":
                        cotisaController cotisationController = loader.getController();
                        cotisationController.setBorderPane(mainContainer);
                    break;
            }

            mainContainer.setCenter(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}