package com.example.mutuelle_centralisee_v2.DAO;

import com.example.mutuelle_centralisee_v2.DataBase.DB_connection;
import com.example.mutuelle_centralisee_v2.Models.ClientModel;
import javafx.collections.ObservableList;

import java.sql.Connection;


public abstract class DAO <T> {

    public DB_connection connection = new DB_connection();
    public abstract ObservableList<T> show();
    public abstract T add(T obj);

}
