package com.example.mutuelle_centralisee_v2.DAOimpl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmplDAOTest {

    EmplDAO emplDAO = new EmplDAO();


    @Test
    void login() {
        assertTrue(emplDAO.login("yassine@gmail.com","134"));
    }
}