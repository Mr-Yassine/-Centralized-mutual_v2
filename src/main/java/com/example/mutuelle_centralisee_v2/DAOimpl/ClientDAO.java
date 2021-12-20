package com.example.mutuelle_centralisee_v2.DAOimpl;
import com.example.mutuelle_centralisee_v2.DAO.DAO;
import com.example.mutuelle_centralisee_v2.DataBase.DB_connection;
import com.example.mutuelle_centralisee_v2.Models.ClientModel;
import com.example.mutuelle_centralisee_v2.Models.EmployeeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public class ClientDAO extends DAO<ClientModel> {


    ObservableList<ClientModel> clients = FXCollections.observableArrayList();


    @Override
    public ObservableList<ClientModel> show() {
        ResultSet resultSet = null;


        try {
            String statement = "SELECT * FROM clients";
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                ClientModel c =new ClientModel();

                c.setBadge(resultSet.getString("badge"));
                c.setId(resultSet.getString("identity"));
                c.setPrenom(resultSet.getString("fname"));
                c.setNom(resultSet.getString("lname"));
                c.setEmail(resultSet.getString("email"));
                c.setTel(resultSet.getString("phone"));
                c.setAdresse(resultSet.getString("address"));
                c.setEntreprise(resultSet.getString("company"));
                c.setDate(LocalDate.parse(resultSet.getDate("start_date").toString())) ;

                clients.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }





    @Override
    public ClientModel add(ClientModel c) {

        try{

            String query = "INSERT INTO clients (`badge`," +
                    "`identity`," +
                    "`lname`," +
                    "`fname`," +
                    "`email`," +
                    "`phone`," +
                    "`address`," +
                    "`company`," +
                    "`start_date`) VALUES (?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(query);

            preparedStatement.setString(1,c.getBadge());
            preparedStatement.setString(2,c.getId());
            preparedStatement.setString(3, c.getNom());
            preparedStatement.setString(4,c.getPrenom());
            preparedStatement.setString(5,c.getEmail());
            preparedStatement.setString(6, c.getTel());
            preparedStatement.setString(7, c.getAdresse());
            preparedStatement.setString(8, c.getEntreprise());
            preparedStatement.setDate(9, Date.valueOf(c.getDate().toString()));


            preparedStatement.execute();

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }




    public HashMap<String, Integer> stats() {

        ResultSet resultSet = null;
        HashMap<String,Integer> clients = new HashMap<>();

        try {
            String query = "SELECT monthname(mutual_date),count(badge) from clients group by monthname(mutual_date)";
            PreparedStatement preparedStatement = DB_connection.getConnection().prepareStatement(query);
            resultSet =  preparedStatement.executeQuery();

            while (resultSet.next()) {
                clients.put(resultSet.getString(1) , resultSet.getInt(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clients;
    }






    public ArrayList<String> getAllCompanies(){

        ArrayList<String> companies = new ArrayList<>();

        try {
            String query = "SELECT DISTINCT company FROM clients";
            PreparedStatement preparedStatement = DB_connection.getConnection().prepareStatement(query);
            ResultSet resultSet =  preparedStatement.executeQuery();

            while (resultSet.next()) {
                companies.add(resultSet.getString("company"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }




    public ArrayList<ClientModel> searchByCompany(String company) {

        ArrayList<ClientModel> companies = new ArrayList<>();
        ResultSet resultSet = null;


        try {
            String statement = "SELECT * FROM clients WHERE company = '"+company +"'";
            PreparedStatement preparedStatement = DB_connection.getConnection().prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                ClientModel c =new ClientModel();

                c.setBadge(resultSet.getString("badge"));
                c.setId(resultSet.getString("identity"));
                c.setPrenom(resultSet.getString("fname"));
                c.setNom(resultSet.getString("lname"));
                c.setEmail(resultSet.getString("email"));
                c.setTel(resultSet.getString("phone"));
                c.setAdresse(resultSet.getString("address"));
                c.setEntreprise(resultSet.getString("company"));
                c.setDate(LocalDate.parse(resultSet.getDate("start_date").toString())) ;

                companies.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }





    public ObservableList<ClientModel> search(String item){

        ResultSet resultSet = null;

        try {
            String statement = "SELECT * FROM clients WHERE fname LIKE '%"+item+"%' OR lname LIKE '%"+item+"%' OR phone LIKE '%"+item+"%' OR email LIKE '%"+item+"%' OR address LIKE '%"+item+"%'";
            PreparedStatement preparedStatement = DB_connection.getConnection().prepareStatement(statement);
            resultSet =  preparedStatement.executeQuery();

            while (resultSet.next()) {

                ClientModel c =new ClientModel();

                c.setBadge(resultSet.getString("badge"));
                c.setId(resultSet.getString("identity"));
                c.setPrenom(resultSet.getString("fname"));
                c.setNom(resultSet.getString("lname"));
                c.setEmail(resultSet.getString("email"));
                c.setTel(resultSet.getString("phone"));
                c.setAdresse(resultSet.getString("address"));
                c.setEntreprise(resultSet.getString("company"));
                c.setDate(LocalDate.parse(resultSet.getDate("start_date").toString())) ;


                clients.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clients;
    }



}
