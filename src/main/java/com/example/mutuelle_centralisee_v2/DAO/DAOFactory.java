package com.example.mutuelle_centralisee_v2.DAO;

public class DAOFactory {

    public static boolean login(String email, String password){
        return new EmplDAO().login(email,password);
    }

}
