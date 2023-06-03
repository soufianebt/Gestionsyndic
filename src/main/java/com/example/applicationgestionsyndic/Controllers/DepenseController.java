package com.example.applicationgestionsyndic.Controllers;

import com.example.applicationgestionsyndic.DAL.CorproprieteDal;
import com.example.applicationgestionsyndic.DAL.DepenseDal;
import com.example.applicationgestionsyndic.Metier.Corpropriete;
import com.example.applicationgestionsyndic.Metier.Depense;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class DepenseController implements Initializable {
    CorproprieteDal corproprieteDal = new CorproprieteDal();
    DepenseDal depenseDal = new DepenseDal();
    List<Corpropriete> corproprietes;
    @FXML
    private AnchorPane AddDepenseIn;

    @FXML
    private AnchorPane DepensesIn;

    @FXML
    private TextField Mois_DLab;

    @FXML
    private TextField Montant_DLab;

    @FXML
    private ChoiceBox<?> TypeDepense;

    @FXML
    private Button ajouterD_btn;

    @FXML
    private ChoiceBox<String> choicBoxCopro;

    @FXML
    private ChoiceBox<?> coproId;

    @FXML
    private TableView<?> depenseTable;

    @FXML
    private Button enrgistrer_btn;

    @FXML
    private Button gobtn;

    @FXML
    private TextArea info_DLab;

    @FXML
    private TableColumn<?, ?> infosColonne;

    @FXML
    private TextField moisDep;

    @FXML
    private TableColumn<?, ?> montantColonne;

    @FXML
    private Label name_Copro;

    @FXML
    private TableColumn<?, ?> titreColonne;

    @FXML
    private TextField titreDlabel;

    @FXML
    private TextField total;

    @FXML
    void DeleteDepense(ActionEvent event) {

    }

    @FXML
    void addDepense(ActionEvent event) {
        Depense depense = new Depense();
        depense.setTitre(titreDlabel.getText());
        depense.setMois(Integer.parseInt(Mois_DLab.getText()));
        depense.setMontant(Float.parseFloat(Montant_DLab.getText()));
        depense.setInfos(info_DLab.getText());
        depenseDal.createDepense(depense);
    }

    @FXML
    void addDepensehowListData(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadIdCopro();
    }
    private void loadIdCopro() {
        corproprietes = corproprieteDal.getCorproprietesBySyndicId(1);
        List<String> idList = corproprietes.stream()
                .map(t->{
                    return t.getId()+"_"+t.getNom();
                })
                .collect(Collectors.toList());
        choicBoxCopro.setItems(FXCollections.observableArrayList(idList));
    }
}
