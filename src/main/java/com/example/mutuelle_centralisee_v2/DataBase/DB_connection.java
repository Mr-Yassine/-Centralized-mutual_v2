package com.example.mutuelle_centralisee_v2.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;


public class DB_connection {

    public static Connection databaseLink;


    public static Connection getConnection() {
        String databaseName = "client_database";
        String databaseUser = "root";
        String databasePassword = "1234";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }


}
