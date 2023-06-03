package com.example.applicationgestionsyndic.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
    private double x = 0;
    private double y = 0;
    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    public void loginAdmin() throws IOException {

            Alert alert;

            if(username.getText().isEmpty() || password.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                if(password.getText().equals("admin")  && username.getText().equals("admin")){
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login");
                    alert.showAndWait();
                    loginBtn.getScene().getWindow().hide();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    // Ajouter le chemin d'accès relatif au fichier CSS à la liste des feuilles de style de la scène
                    //scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
                    Stage stage = new Stage();
                    stage.setTitle("Gestion du Syndic");
                    stage.setScene(scene);
                    stage.show();

                }else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username/Password");
                    alert.showAndWait();
                }
            }
        }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
