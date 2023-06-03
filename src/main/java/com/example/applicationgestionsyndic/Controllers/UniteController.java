package com.example.applicationgestionsyndic.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class UniteController implements Initializable {

    @FXML
    private Button Supprimer;

    @FXML
    private Button ajouter;

    @FXML
    private TableColumn<?, ?> column_copr;

    @FXML
    private TableColumn<?, ?> column_port;

    @FXML
    private TableColumn<?, ?> column_type;

    @FXML
    private TableColumn<?, ?> column_unité;

    @FXML
    private Label lab_unité;

    @FXML
    private Label lb1;

    @FXML
    private Label lb_coproprité;

    @FXML
    private Label lb_post;

    @FXML
    private Label lb_type;

    @FXML
    private Button modifier;

    @FXML
    private TableView<?> table_view;

    @FXML
    private TextField txt_coproprité;

    @FXML
    private TextField txt_port;

    @FXML
    private ComboBox<?> txt_type;

    @FXML
    private TextField txt_unité;

    @FXML
    private Label unité;

    @FXML
    void cklic_modifier(ActionEvent event) {

    }

    @FXML
    void clickSupprimer(ActionEvent event) {

    }

    @FXML
    void clikAjouter(ActionEvent event) {

    }

    @FXML
    void select(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

