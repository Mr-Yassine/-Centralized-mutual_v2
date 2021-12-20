package com.example.mutuelle_centralisee_v2.DAOimpl;
import com.example.mutuelle_centralisee_v2.DAO.DAO;
import com.example.mutuelle_centralisee_v2.DataBase.DB_connection;
import com.example.mutuelle_centralisee_v2.Models.EmployeeModel;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class EmplDAO extends DAO<EmployeeModel> {


    DB_connection connection = new DB_connection();




    public boolean login(String email,String password) {

        String verifyLogin = "SELECT count(1) FROM fonctionnaires WHERE email ='" + email + "' AND password ='" + password+"';";

        try {

            Statement statement = connection.getConnection().createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            System.out.println(queryResult);
            while (queryResult.next()){
                //System.out.println(queryResult.getInt(1));

                if (queryResult.getInt(1)== 1) {
                  return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return false;
    }


    @Override
    public ObservableList<EmployeeModel> show() {return null;}

    @Override
    public EmployeeModel add(EmployeeModel obj) {
        return null;
    }

}
