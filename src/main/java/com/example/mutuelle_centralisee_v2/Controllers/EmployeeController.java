package com.example.mutuelle_centralisee_v2.Controllers;

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

public class EmployeeController {

    //Login Attributes
    @FXML private TextField email;
    @FXML private PasswordField password;
    @FXML private Label message;





    public void userLogIn(ActionEvent event) throws IOException {
        validateLogin();
    }



    public void validateLogin() {

        MutualApp m = new MutualApp();
        DB_connection connect = new DB_connection();
        Connection connectDB = connect.getConnection();


        String verifyLogin = "SELECT count(1) FROM fonctionnaires WHERE email ='" + email.getText() + "' AND password ='" + password.getText()+"';";
        System.out.println(verifyLogin);
        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            System.out.println(queryResult);
            while (queryResult.next()){


                if ((this.email.getText().isEmpty() || this.password.getText().isEmpty())) {
                    message.setText("Please fill all the fields");
                    //m.changeScene("client-view.fxml");
                    break;
                } else if (queryResult.getInt(1) == 1) {
                    m.changeScene("client-view.fxml");
                } else {
                    message.setText("Invalid email or password!!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}
