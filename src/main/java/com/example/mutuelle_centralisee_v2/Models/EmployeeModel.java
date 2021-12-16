package com.example.mutuelle_centralisee_v2.Models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class EmployeeModel {


    private String email;
    private String password;


    public EmployeeModel(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}



    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}


}
