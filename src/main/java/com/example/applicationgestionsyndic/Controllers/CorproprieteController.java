package com.example.applicationgestionsyndic.Controllers;

import com.example.applicationgestionsyndic.DAL.CorproprieteDal;
import com.example.applicationgestionsyndic.Metier.Corpropriete;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

    public class CorproprieteController implements Initializable {

        CorproprieteDal corproprieteDal = new CorproprieteDal();
        Corpropriete selectedCorpropriete;
        Random random = new Random();
        List<Corpropriete> corproprieteList;
        @FXML
        private TableColumn<Corpropriete, String> adrColumn;

        @FXML
        private Button ajouter;

        @FXML
        private TableColumn<Corpropriete, Double> cotisationColumn;

        @FXML
        private Pane gestion;

        @FXML
        private Button go;

        @FXML
        private TableColumn<Corpropriete, Integer> idColumn;

        @FXML
        private Label lb_adresse;

        @FXML
        private Label lb_cotisation;

        @FXML
        private Label lb_disponible;


        @FXML
        private Label lb_immeuble;

        @FXML
        private Label lb_unité;

        @FXML
        private Label lb_ville;

        @FXML
        private Button modifier;

        @FXML
        private TableColumn<Corpropriete, String> nameColumn;

        @FXML
        private TableColumn<Corpropriete, Integer> nbrUnitéColumn;

        @FXML
        private Button supprimer;

        @FXML
        private TableView<Corpropriete> tableView;

        @FXML
        private TextField txt_Ville;

        @FXML
        private TextField txt_adresse;

        @FXML
        private TextField txt_cotisation;

        @FXML
        private TextField txt_disponible;


        @FXML
        private TextField txt_immeuble;

        @FXML
        private TextField txt_unité;

        @FXML
        private TableColumn<Corpropriete, String> villeColumn;

        @FXML
        void SupprimerClicked(ActionEvent event) {
            corproprieteDal.deleteCorpropriete(selectedCorpropriete.getId());
            refreshTable();
        }

        @FXML
        void ajouterCliked(ActionEvent event) {
        Corpropriete corpropriete = new Corpropriete();
        corpropriete.setId(random.nextInt(0,700));
        corpropriete.setSyndicId(1);
        corpropriete.setNom(txt_immeuble.getText());
        corpropriete.setNbrUnite(Integer.parseInt(txt_unité.getText()));
        corpropriete.setVille(txt_Ville.getText());
        corpropriete.setAdresse(txt_adresse.getText());
        corpropriete.setMontantCotis(Float.valueOf(txt_cotisation.getText()));
        corpropriete.setMontantDispo(Float.valueOf(txt_disponible.getText()));
        corpropriete.setTypeCorproprieteId(1);
        corproprieteDal.addCorpropriete(corpropriete);
            refreshTable();
        }

        @FXML
        void clickGo(ActionEvent event) {

        }

        @FXML
        void modifierClicked(ActionEvent event) {
            selectedCorpropriete.setNom(txt_immeuble.getText());
            selectedCorpropriete.setNbrUnite(Integer.parseInt(txt_unité.getText()));
            selectedCorpropriete.setVille(txt_Ville.getText());
            selectedCorpropriete.setAdresse(txt_adresse.getText());
            selectedCorpropriete.setMontantCotis(Float.valueOf(txt_cotisation.getText()));
            selectedCorpropriete.setMontantDispo(Float.valueOf(txt_disponible.getText()));
            corproprieteDal.updateCorpropriete(selectedCorpropriete);
            refreshTable();
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                if (newSelection != null) {
                    handleRowSelection((Corpropriete) newSelection);
                }
            });
            initTbale();
        }
        public void initTbale(){

            corproprieteList = corproprieteDal.getCorproprietesBySyndicId(1);
            idColumn.setCellValueFactory(new PropertyValueFactory<Corpropriete,Integer>("id"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<Corpropriete,String>("nom"));
            villeColumn.setCellValueFactory(new PropertyValueFactory<Corpropriete,String>("ville"));
            adrColumn.setCellValueFactory(new PropertyValueFactory<Corpropriete,String>("adresse"));
            cotisationColumn.setCellValueFactory(new PropertyValueFactory<Corpropriete,Double>("montantCotis"));
            nbrUnitéColumn.setCellValueFactory(new PropertyValueFactory<Corpropriete,Integer>("nbrUnite"));
            tableView.setItems(FXCollections.observableArrayList(corproprieteList));
        }

        private void handleRowSelection(Corpropriete newSelection) {
            txt_immeuble.setText(newSelection.getNom());
            txt_unité.setText(String.valueOf(newSelection.getNbrUnite()));
            txt_Ville.setText(newSelection.getVille());
            txt_adresse.setText(newSelection.getAdresse());
            txt_cotisation.setText(String.valueOf(newSelection.getMontantCotis()));
            txt_disponible.setText(String.valueOf(newSelection.getMontantDispo()));
            selectedCorpropriete = newSelection;
        }

        private void refreshTable(){
            corproprieteList = corproprieteDal.getCorproprietesBySyndicId(1);
            tableView.setItems(FXCollections.observableArrayList(corproprieteList));
            tableView.refresh();
        }
    }