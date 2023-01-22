package Model.DAO;

import Model.DAO.IDao;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import Domain.Client;
import Domain.Sexe;


public class ClientDao  implements IDao<Client, Long> {

    @Override
    public List<Client> findAll() {
        List<Client> listClients = new ArrayList<>();

        try {
            List<String> lines =Files.readAllLines(FileBasePaths.CLIENT_TABLE, StandardCharsets.UTF_8);
            lines.remove(0);
            listClients = lines
                    .stream()
                    .map(line -> {
                        Client cl = null;

                        StringTokenizer st = new StringTokenizer(line, "\t\t\t");

                        Long id = Long.parseLong(st.nextToken());
                        String nom = st.nextToken();
                        String prenom = st.nextToken();
                        String login = st.nextToken();
                        String password = st.nextToken();
                        String cin = st.nextToken();
                        String tel = st.nextToken();
                        String email = st.nextToken();
                        Sexe sexe = null;

                        if(st.nextToken().equals("HOMME")){
                            sexe = Sexe.HOMME;
                        } else {
                            sexe = Sexe.FEMME;
                        }

                        if(tel.equals("NULL")) cl.setTel("");
                        if(email.equals("NULL")) cl.setEmail("");

                        cl = new Client(login,password, nom, prenom,email, cin, tel, sexe);
                        cl.setId(id);

                        return cl;

                    })
                    .toList();

                    System.out.println("Extraction Succes");
                } catch (IOException e) {
                    System.err.println("Erreur: " + e.getMessage());;
                }

        return listClients;
            }


    @Override
    public Client findById(Long id) {
        return null;
    }

    @Override
    public Client save(Client client) {
        //id			nom			prenom			login			password			cin			tel			email			sexe

        String indexStr = null;
        long id = 1;

        try {
            indexStr = Files.readString(FileBasePaths.CLIENT_TABLE, StandardCharsets.UTF_8);
            id = Long.parseLong(indexStr);
            id++;
            client.setId(id);
        } catch (IOException e) {
            client.setId(id);
        }


        String clientStr = client.getId() + "\t\t\t";
        clientStr += client.getNom() + "\t\t\t";
        clientStr += client.getPrenom() + "\t\t\t";
        clientStr += client.getLogin() + "\t\t\t";
        clientStr += client.getPassword() + "\t\t\t";
        clientStr += client.getCin() + "\t\t\t";
        clientStr += client.getTel() + "\t\t\t";
        clientStr += client.getEmail() + "\t\t\t";
        clientStr += client.getSexe() + "\n";

        try {
            Files.writeString(FileBasePaths.CLIENT_TABLE, clientStr, StandardOpenOption.APPEND);
            System.out.println("Client " + client.getId() + " avec succes !");
            Files.writeString(FileBasePaths.CLIENTINDEX, client.getId().toString());

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return null;

    }



    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public Boolean delete(Client client) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }



}
