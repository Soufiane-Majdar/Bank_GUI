package Controller;

import org.w3c.dom.ls.LSException;

// using Model.DAO.ClientDao

import Model.dao.Impl.*;
import View.Dashboard.Dashboard;
import Model.Domain.Client;
import Model.Domain.Sexe;
import Model.dao.*;
     






public class CRUD_Client {

// create FileBasePaths and add client to clints.txt



    public static void main(String[] args) {


        ClientDao clientDao = new ClientDao();
        Client client = new Client("login", "pass", "nom", "prenom", "email", "cin", "tel", Sexe.HOMME);
        clientDao.save(client);   
    
    
        Dashboard dash= new Dashboard("D A S H B O A R D");

      
    }
    
}
