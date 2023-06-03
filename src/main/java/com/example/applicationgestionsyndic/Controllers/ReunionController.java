package com.example.applicationgestionsyndic.Controllers;

import com.example.applicationgestionsyndic.DAL.CorproprieteDal;
import com.example.applicationgestionsyndic.DAL.PDFProvider;
import com.example.applicationgestionsyndic.DAL.ReunionDal;
import com.example.applicationgestionsyndic.DAL.SyndicDal;
import com.example.applicationgestionsyndic.Metier.Corpropriete;
import com.example.applicationgestionsyndic.Metier.Reunion;
import com.example.applicationgestionsyndic.Metier.Syndic;
import com.itextpdf.text.DocumentException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ReunionController implements Initializable {
    public Syndic currentUser;
    public Reunion currentReunion;
    public ReunionDal reunionDal = new ReunionDal();
    public List<Reunion> reunionList;
    SyndicDal syndicDal = new SyndicDal();
    Random random = new Random();
    List<Corpropriete> corproprietes ;
    CorproprieteDal corproprieteDal = new CorproprieteDal();




    @FXML
    private ChoiceBox<Integer> Corpropriete;

    @FXML
    private DatePicker DateReunion;

    @FXML
    private TextArea ReunionAgenda;

    @FXML
    private TableColumn<?, ?> ReunionDateColumn;

    @FXML
    private TableColumn<?, ?> ReunionFinalDecisionColumn;

    @FXML
    private TableColumn<?, ?> ReunionIdColumn;

    @FXML
    private TableColumn<?, ?> ReunionReportColumn;

    @FXML
    private TextField ReunionTitle;

    @FXML
    private TableColumn<?, ?> ReunionTitleColumn;

    @FXML
    private TextField Reunion_search;

    @FXML
    private Button addReunion_addBtn;

    @FXML
    private Button addReunion_clearBtn;

    @FXML
    private Button addReunion_deleteBtn;

    @FXML
    private Button addReunion_updateBtn;

    @FXML
    private Button imprimer_invitation;

    @FXML
    private TableView<Reunion> reunion_tableView;

    @FXML
    void AddReunion(ActionEvent event) {
        Reunion reunion = new Reunion();
        reunion.setSyndic_id(this.currentUser.id);
        LocalDate localDate = DateReunion.getValue();
        reunion.setId(random.nextInt(0, 700));
        reunion.setDate(localDate);
        reunion.setTitre(ReunionTitle.getText());
        reunion.setOrdre(ReunionAgenda.getText());
        reunion.setCorpropriete_id(1);
        reunionList.add(reunion);
        reunionDal.createReunion(reunion);
        ClearInputs(null);
        refreshTable();
    }
    @FXML
    void Exite(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    void ClearInputs(ActionEvent event) {
        ReunionAgenda.setText(null);
        ReunionTitle.setText(null);
        // TODO: Set DateReunion to empty
    }

    @FXML
    void DeleteReunion(ActionEvent event) {
        if (currentReunion != null){
            reunionDal.deleteReunion(currentReunion.id);
            ClearInputs(null);
            refreshTable();
        }
    }

    @FXML
    void UpdateReunion(ActionEvent event) {
        if (currentReunion != null){
            LocalDate localDate = DateReunion.getValue();
            currentReunion.setDate(localDate);
            currentReunion.setTitre(ReunionTitle.getText());
            currentReunion.setOrdre(ReunionAgenda.getText());
            currentReunion.setCorpropriete_id(1);
            reunionDal.updateReunion(currentReunion);
            ClearInputs(null);
            refreshTable();
        }

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Initialized table meeting");
        reunion_tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                handleRowSelection(newSelection);
            }
        });
        InitUser();
    }

    private void handleRowSelection(Reunion newSelection) {
        currentReunion = newSelection;
        Corpropriete.setValue(newSelection.getCorpropriete_id());
        DateReunion.setValue(newSelection.date);
        ReunionAgenda.setText(newSelection.ordre);
        ReunionTitle.setText(newSelection.titre);
    }

    public void InitUser() {
        this.currentUser = syndicDal.getSyndic();
        initListMeuble(currentUser);
        initTable(currentUser);

    }
    private void refreshTable(){
        reunionList = reunionDal.selectReunionsBySyndicId(currentUser.id);
        reunion_tableView.setItems(FXCollections.observableArrayList(reunionList));
        reunion_tableView.refresh();
    }
    private void initTable(Syndic syndic) {
        reunionList = reunionDal.selectReunionsBySyndicId(1);
        reunion_tableView.setItems(FXCollections.observableArrayList(reunionList));

        ReunionIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        ReunionDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        ReunionTitleColumn.setCellValueFactory(new PropertyValueFactory<>("titre"));
        ReunionReportColumn.setCellValueFactory(new PropertyValueFactory<>("ordre"));
        ReunionFinalDecisionColumn.setCellValueFactory(new PropertyValueFactory<>("decission_final"));
    }

    private void initListMeuble(Syndic syndic) {
        corproprietes = corproprieteDal.getCorproprietesBySyndicId(1);
        List<Integer> idList = corproprietes.stream()
                .map(t->{
                    return t.getId();
                })
                .collect(Collectors.toList());
        Corpropriete.setItems(FXCollections.observableArrayList(idList));
    }

    @FXML
    void print(ActionEvent event) throws DocumentException {
        PDFProvider pdfProvider = new PDFProvider();
        if(currentReunion != null) pdfProvider.generate(currentReunion);
    }

}

