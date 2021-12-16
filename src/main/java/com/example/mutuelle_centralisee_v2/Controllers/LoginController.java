package com.example.mutuelle_centralisee_v2.Controllers;
import com.example.mutuelle_centralisee_v2.DAO.DAOFactory;
import com.example.mutuelle_centralisee_v2.DataBase.DB_connection;
import com.example.mutuelle_centralisee_v2.MutualApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginController {

    //Login Attributes
    @FXML private TextField email;
    @FXML private PasswordField password;
    @FXML private Label message;



    public void userLogIn(ActionEvent event) throws IOException {
        validateLogin();
    }

    public void validateLogin() {

        MutualApp m = new MutualApp();

        try {

                if ((this.email.getText().isEmpty() || password.getText().isEmpty())) {
                    m.changeScene("client-view.fxml");
                    message.setText("Please fill all the fields");
                } else if (DAOFactory.login(email.getText(),password.getText())) {
                    m.changeScene("client-view.fxml");
                } else {
                    message.setText("Invalid email or password!!");
                }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


}
