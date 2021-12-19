package com.example.mutuelle_centralisee_v2.Controllers;
import com.example.mutuelle_centralisee_v2.DAOimpl.ClientDAO;
import com.example.mutuelle_centralisee_v2.Models.ClientModel;
import com.example.mutuelle_centralisee_v2.MutualApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.*;



public class ClientController implements Initializable {


    //Interface Attributes
    @FXML private TextField identity;
    @FXML private TextField lname;
    @FXML private TextField fname;
    @FXML private TextField email;
    @FXML private ChoiceBox<String> country_list = new ChoiceBox<String>();
    @FXML private TextField phone;
    @FXML private TextField company;
    @FXML private TextArea address;
    @FXML private DatePicker date;
    @FXML private LineChart<String,Number> chart;
    @FXML private ComboBox<String> company_box;



    //Table Attributes
    @FXML private TableView<ClientModel> dataGrid;

    @FXML private TableColumn<ClientModel, String> col_badge;
    @FXML private TableColumn<ClientModel, String>  col_id;
    @FXML private TableColumn<ClientModel, String>  col_nom;
    @FXML private TableColumn<ClientModel, String>  col_prenom;
    @FXML private TableColumn<ClientModel, String>  col_telephone;
    @FXML private TableColumn<ClientModel, String>  col_email;
    @FXML private TableColumn<ClientModel, String>  col_adresse;
    @FXML private TableColumn<ClientModel, String> col_entreprise;
    @FXML private TableColumn<ClientModel, String>  col_date;



    @FXML
    ClientDAO clients = new ClientDAO();





    @FXML
    public void addClient(ActionEvent event) {

        ClientModel client = new ClientModel();

        client.setBadge("AB939A");
        client.setId(this.identity.getText());
        client.setNom(this.lname.getText());
        client.setPrenom(this.fname.getText());
        client.setAdresse(this.address.getText());
        client.setEmail(this.email.getText());
        client.setEntreprise(this.company.getText());
        client.setTel("(" + this.country_list.getSelectionModel().getSelectedItem() + ") " + this.phone.getText());
        client.setDate(this.date.getValue());


        new ClientDAO().add(client);

        dataGrid.setItems(clients.show());
        ClearTable();
    }






    @FXML
    public void showClient() {

        col_badge.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("badge"));
        col_id.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("prenom"));
        col_email.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("email"));
        col_telephone.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("tel"));
        col_adresse.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("adresse"));
        col_entreprise.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("entreprise"));
        col_date.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("date"));

        ClientDAO client = new ClientDAO();
        dataGrid.setItems(client.show());
    }








    //get companies
    public ArrayList<String> getCompanies(){
        return clients.getAllCompanies();
    }


    public void handleCountry(){
        /*
         System.out.println(company_box.getValue());
         System.out.println(getByCompany(company_box.getValue()));
        */
        dataGrid.getItems().clear();
        dataGrid.setItems(getByCompany(company_box.getValue()));
    }

    public ObservableList<ClientModel> getByCompany(String company){
        ObservableList<ClientModel> byCompany = FXCollections.observableArrayList(clients.searchByCompany(company));
        return byCompany;
    }













    @FXML
    public void stats(){
        chart.getData().clear();
        XYChart.Series<String,Number> series = new XYChart.Series<>();
        series.setName("Clients stats per month");

        for (String key: clients.stats().keySet()) {
            series.getData().add(new XYChart.Data<>(key,clients.stats().get(key)));
        }
        chart.getData().add(series);
    }





    //get the dial_code from json file and import the clients data
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("D:\\Java Project\\Mutuelle centralisee\\src\\main\\resources\\JSON\\Code Pays.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray country = (JSONArray) obj;

            for (Object o : country) {
                JSONObject country_obj = (JSONObject) o;
                String country_code = (String) country_obj.get("dial_code");
                //System.out.println(country_code);
                country_list.getItems().add(country_code);
            }


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        //show client method
        showClient();


        //get all companies
        ObservableList<String> companiesList = FXCollections.observableArrayList(getCompanies());
        company_box.setItems(companiesList);

    }





    public void ClearTable() {
        this.identity.setText("");
        this.lname.setText("");
        this.fname.setText("");
        this.country_list.setValue(null);
        this.phone.setText("");
        this.email.setText("");
        this.address.setText("");
        this.company.setText("");
        this.date.setValue(null);
    }

    public void userLogout(ActionEvent event) {

        MutualApp m = new MutualApp();

        try {
            m.changeScene("login-view.fxml");
        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
