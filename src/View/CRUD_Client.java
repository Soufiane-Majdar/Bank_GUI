package View;

import org.w3c.dom.ls.LSException;

import Domain.Client;
import Domain.Sexe;

// using Model.DAO.ClientDao

import Model.DAO.ClientDao;
import Model.DAO.FileBasePaths;
     






public class CRUD_Client {

// create FileBasePaths and add client to clints.txt



    public static void main(String[] args) {


        ClientDao clientDao = new ClientDao();
        Client client = new Client("login", "pass", "nom", "prenom", "email", "cin", "tel", Sexe.HOMME);
        clientDao.save(client);    }
    
}
