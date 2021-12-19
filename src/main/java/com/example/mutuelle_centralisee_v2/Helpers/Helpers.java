package com.example.mutuelle_centralisee_v2.Helpers;

import javafx.scene.control.Alert;

public class Helpers {

    public static void Error(String title,String headerText,String contentText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();

    }


    public static void Vide(String title,String headerText,String contentText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }



    public static void Success(String title,String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(contentText);
        alert.showAndWait();

    }


    // Valider la taille :
    public static boolean VideValidation(String value,int length){return value.length()<length;}

    // Valider la taille :
    public static boolean LengthValidation(String value,int length){
        return value.length()<=length;
    }

    // Valider CIN:
    public static boolean CinValidation(String value){
        return value.matches("^[a-zA-Z]{2}[0-9]{3}$");
    }

    // Valider Passport :
    public static boolean PassValidation(String value){
        return value.matches("^[a-zA-Z]{2}[0-9]{5}$");
    }

    // Valider Phone :
    public static boolean PhoneValidation(String value){
        return value.matches("^(6|7)[0-9]{4}$");
    }

    // Valider Email :
    public static boolean EmailValidation(String value){
        return value.matches("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z][a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$");
    }
}
