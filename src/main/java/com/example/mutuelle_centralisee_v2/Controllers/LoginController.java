package com.example.mutuelle_centralisee_v2.Controllers;
import com.example.mutuelle_centralisee_v2.DAO.DAOFactory;
import com.example.mutuelle_centralisee_v2.Helpers.Helpers;
import com.example.mutuelle_centralisee_v2.MutualApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;



public class LoginController {

    //Login Attributes
    @FXML private TextField email;
    @FXML private PasswordField password;



    MutualApp m = new MutualApp();



    @FXML
    public void validateLogin(ActionEvent event) throws IOException {


        try {

                if ((this.email.getText().isEmpty() || password.getText().isEmpty())) {
                    //m.changeScene("client-view.fxml");
                    Helpers.Vide("Erreur de validation", "Champ vide.", "Merci de remplir tout les champs.");
                } else if (DAOFactory.login(email.getText(),password.getText())) {
                    m.changeScene("client-view.fxml");
                } else {
                    Helpers.Error("Erreur de validation", "Informations non valide.", "Email ou password non valide!!.");
                }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }







}
