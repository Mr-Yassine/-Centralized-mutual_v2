package com.example.mutuelle_centralisee_v2.DAOimpl;

import com.example.mutuelle_centralisee_v2.Models.ClientModel;
import com.mysql.cj.xdevapi.Client;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientDAOTest {

    ClientDAO clientDAO = new ClientDAO();

    @Test
    void show() {
    }

    @Test
    void add() {
        assertNull(clientDAO.add(new ClientModel("AA123", "HH111", "bilal", "yassine", "+212", "64253", "YC", "15b blv 20 safi", LocalDate.of(2021,10,10)
                , "bilal@gmail.com")));
    }

    @Test
    void searchByCompany() {
        List<Object> list = new ArrayList<>();
        assertNotEquals(list,clientDAO.searchByCompany("YC"));
    }
}