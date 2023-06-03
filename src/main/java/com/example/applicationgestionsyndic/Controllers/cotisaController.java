package com.example.applicationgestionsyndic.Controllers;


import com.example.applicationgestionsyndic.DAL.CorproprieteDal;
import com.example.applicationgestionsyndic.DAL.CotisationDal;
import com.example.applicationgestionsyndic.Metier.Corpropriete;
import com.example.applicationgestionsyndic.Metier.Cotisation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class cotisaController implements Initializable {

    CorproprieteDal corproprieteDal = new CorproprieteDal();
    CotisationDal cotisationDal = new CotisationDal();
    Cotisation selectedCotitation;
    List<Cotisation> cotisations ;
    private ObservableList<Cotisation> addCotisationList;

    @FXML
    private AnchorPane AddCotisationIn;

    @FXML
    private AnchorPane CotisationsIn;

    @FXML
    private TableColumn<?, ?> DRMcotisation;

    @FXML
    private DatePicker DateCotisation;

    @FXML
    private TextField DerMCotisatin;

    @FXML
    private Button EnregCotisation;

    @FXML
    private TextField MontantCotisation;

    @FXML
    private Button ajouterC_btn;
    private BorderPane borderPane;

    @FXML
    private ChoiceBox<String> coproId2;

    @FXML
    private ChoiceBox<?> corpoChoichbox;

    @FXML
    private TableColumn<?, ?> cotisationID;

    @FXML
    private TableColumn<?, ?> datePayCot;

    @FXML
    private Button gobtn2;

    @FXML
    private Label immeublename;

    @FXML
    private TableColumn<?, ?> montantCotisation;

    @FXML
    private TextField nbrCotisation;

    @FXML
    private TableColumn<?, ?> nbrmoisCotisation;

    @FXML
    private TableView<Cotisation> tableCotisation;

    @FXML
    private TextField total2;

    @FXML
    private ChoiceBox<?> uniteChoicbox;

    @FXML
    private TableColumn<?, ?> uniteID;

    @FXML
    void DeleteCotisation(ActionEvent event) {
        if(selectedCotitation != null) cotisationDal.deleteCotisation(selectedCotitation.getId());
        refrechTable();
    }

    private void refrechTable() {
        cotisations = cotisationDal.getCotisationByCorproprieteId(1);
        tableCotisation.setItems(FXCollections.observableArrayList(cotisations));
        tableCotisation.refresh();
    }

    @FXML
    void addCanonisation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterCotisation.fxml"));
        Parent addCotisation = loader.load();
        AjouterCotisation ajouterCotisation = loader.getController();
        ajouterCotisation.setBorderPane(borderPane);
        borderPane.setCenter(addCotisation);
    }

    @FXML
    void addCotisationhowListData(ActionEvent event) {

        List<Cotisation> addCotisationList = cotisationDal.getCotisationByCorproprieteId(1);
        cotisationID.setCellValueFactory(new PropertyValueFactory<>("id"));
        uniteID.setCellValueFactory(new PropertyValueFactory<>("Unite_id"));
        datePayCot.setCellValueFactory(new PropertyValueFactory<>("date_pai"));
        DRMcotisation.setCellValueFactory(new PropertyValueFactory<>("dern_mois_pai"));
        nbrmoisCotisation.setCellValueFactory(new PropertyValueFactory<>("nbr_mois"));
        montantCotisation.setCellValueFactory(new PropertyValueFactory<>("montant_paye"));
        tableCotisation.setItems(FXCollections.observableArrayList(addCotisationList));
    }

    @FXML
    void modifier(ActionEvent event) throws IOException {
    if(selectedCotitation != null){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterCotisation.fxml"));
        Parent addCotisation = loader.load();
        AjouterCotisation ajouterCotisation = loader.getController();
        ajouterCotisation.setBorderPane(borderPane);
        ajouterCotisation.initCotisation(selectedCotitation);
        borderPane.setCenter(addCotisation);
    }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        ajouterC_btn.setOnAction(e -> {
            try {
                addCanonisation(null);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        tableCotisation.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedCotitation = newSelection;
            }
        });
        loadIdCopro();
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }
    private void loadIdCopro() {

        List<Corpropriete> corproprietes = corproprieteDal.getCorproprietesBySyndicId(1);
        List<String> idList = corproprietes.stream()
                .map(t->{
                    return t.getId()+"_"+t.getNom();
                })
                .collect(Collectors.toList());
        coproId2.setItems(FXCollections.observableArrayList(idList));
    }


}
