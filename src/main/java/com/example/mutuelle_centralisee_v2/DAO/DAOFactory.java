package com.example.mutuelle_centralisee_v2.DAO;

import com.example.mutuelle_centralisee_v2.DAOimpl.EmplDAO;

public class DAOFactory {

    public static boolean login(String email, String password){
        return new EmplDAO().login(email,password);
    }

}
