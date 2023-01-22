package Model.dao.Impl;

import java.util.List;

import Model.Domain.Client;
import Model.Domain.Sexe;
import Model.dao.Dao;
import Model.dao.FileBasePaths;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class ClientDao implements Dao<Client>{

    public ClientDao()
    {
        FileBasePaths.createFileBaseTables();
    }

    @Override
    public Client getById(int id) {
        // TODO Auto-generated method stub
        return null;
    }
 
    @Override
    public List<Client> getAll() {
        List<Client> listClients = new ArrayList<>();

        try {
            List<String> lines =Files.readAllLines(FileBasePaths.CLIENT_TABLE, StandardCharsets.UTF_8);
            lines.remove(0);
            listClients = lines
                    .stream()
                    .map(line -> {
                        Client cl = null;

                        StringTokenizer tokens = new StringTokenizer(line);
                        long id = Long.parseLong(tokens.nextToken());
                        String nom = tokens.nextToken();
                        String prenom = tokens.nextToken();
                        String login = tokens.nextToken();
                        String password = tokens.nextToken();
                        String cin = tokens.nextToken();
                        String tel = tokens.nextToken();
                        String email = tokens.nextToken();
                        Sexe sexe = null;

                        if(tel.equals("NULL")) cl.setTel("");
                        if(email.equals("NULL")) cl.setEmail("");

                        cl = new Client(login, password, nom, prenom, email, cin, tel, sexe);
                        cl.setId(id);

                        return  cl;
                    })
                    .toList();
            System.out.println("Extraction Succes");
        } catch (IOException e) {
            System.err.println("Erreur: " + e.getMessage());;
        }

        return listClients;
    }

    @Override
    public boolean save(Client client) {
        //id			nom			prenom			login			password			cin			tel			email			sexe

        String indexStr = null;
        long id = 1;
        try{
            indexStr = Files.readString((FileBasePaths.CLIENTINDEX));
            id = Long.parseLong(indexStr);
            id++;
            client.setId(id);
        } catch (IOException e){
            client.setId(id);
        }

        String clientStr = client.getId() + "\t\t\t";
        clientStr += client.getNom() + "\t\t\t";
        clientStr += client.getPrenom() + "\t\t\t";
        clientStr += client.getLogin() + "\t\t\t";
        clientStr += client.getMotDePasse() + "\t\t\t";
        clientStr += client.getCin() + "\t\t\t";
        clientStr += (client.getTel() != null && client.getTel().trim().length() != 0 ? client.getTel() : "NULL") + "\t\t\t";
        clientStr += (client.getEmail() != null && client.getEmail().trim().length() != 0 ? client.getEmail() : "NULL") + "\t\t\t";
        clientStr += client.getSexe() + "\n";
        try {
            Files.writeString(FileBasePaths.CLIENT_TABLE, clientStr, StandardOpenOption.APPEND);
            System.out.println("Client " + client.getId() + " avec succes !");
            Files.writeString(FileBasePaths.CLIENTINDEX, client.getId().toString());

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    @Override
    public boolean saveAll(List<Client> items) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(Client item) {
        // update
        //id			nom			prenom			login			password			cin			tel			email			sexe
        return false;
    }

    @Override
    public boolean update(List<Client> items) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Client item) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(List<Client> items) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
