package com.example.mutuelle_centralisee_v2.DAO;

import com.example.mutuelle_centralisee_v2.DAOimpl.ClientDAO;
import com.example.mutuelle_centralisee_v2.DAOimpl.EmplDAO;
import com.example.mutuelle_centralisee_v2.Models.ClientModel;
import javafx.collections.ObservableList;

public class DAOFactory {

    public static boolean login(String email, String password){
        return new EmplDAO().login(email,password);
    }

    public static ObservableList<ClientModel> show(){
        return new ClientDAO().show();
    }

    public static ClientModel add(ClientModel c){
        return new ClientDAO().add(c);
    }

}
