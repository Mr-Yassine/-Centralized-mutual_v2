package com.example.mutuelle_centralisee_v2.Models;
import com.example.mutuelle_centralisee_v2.MutualApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;



public class ClientModel {

    private String badge;
    private String id;
    private String nom;
    private String prenom;
    private String country_list;
    private String tel;
    private String entreprise;
    private String Adresse;
    private LocalDate date;
    private String email;




    public ClientModel(){}
    public ClientModel(String badge, String id, String nom, String prenom, String country_list, String tel, String entreprise, String adresse, LocalDate date, String email) {
        this.badge = badge;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.country_list = country_list;
        this.tel = tel;
        this.entreprise = entreprise;
        Adresse = adresse;
        this.date = date;
        this.email = email;
    }




    public String getBadge() {return badge;}
    public void setBadge(String badge) {this.badge = badge;}


    public String getId() {return id;}
    public void setId(String id) {this.id = id;}


    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}


    public String getPrenom() {return prenom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}


    public String getCountry_list() {return country_list;}
    public void setCountry_list(String country_list) {this.country_list = country_list;}


    public String getTel() {return tel;}
    public void setTel(String tel) {this.tel = tel;}


    public String getEntreprise() {return entreprise;}
    public void setEntreprise(String entreprise) {this.entreprise = entreprise;}


    public String getAdresse() {return Adresse;}
    public void setAdresse(String adresse) {Adresse = adresse;}


    public LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {this.date = date;}


    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

}
