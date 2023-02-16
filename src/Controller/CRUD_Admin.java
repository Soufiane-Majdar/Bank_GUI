package Controller;

import org.w3c.dom.ls.LSException;

// using Model.DAO.ClientDao


import View.Dashboard.Dashboard;
import Model.Domain.Client;
import Model.Domain.Sexe;
import dao.daoFiles.ClientDao;


import static javax.swing.JOptionPane.showMessageDialog;
/**
 * CRUD_Admin
 */
public class CRUD_Admin {

    Dashboard dash;

    public CRUD_Admin(Dashboard dash) {
        this.dash = dash;
        ActionLisner();
    }

    // crud by buttons click on getCenterpanel()

    // actionlisner
    public void addClient() {
        if (dash.getCenterpanel().getTxts().get("Login").getText().isEmpty() || 
        dash.getCenterpanel().getTxts().get("Pass").getText().isEmpty() || 
        dash.getCenterpanel().getTxts().get("Nom").getText().isEmpty() || 
        dash.getCenterpanel().getTxts().get("Prénom").getText().isEmpty() || 
        dash.getCenterpanel().getTxts().get("Email").getText().isEmpty() || 
        dash.getCenterpanel().getTxts().get("Cin").getText().isEmpty() || 
        dash.getCenterpanel().getTxts().get("Tel").getText().isEmpty()) {
            showMessageDialog(null, "Please fill up the fields");
       
    }
    else{
        // add client
        ClientDao clientDao = new ClientDao();
        // Client client = new Client("login", "pass", "nom", "prenom", "email", "cin", "tel", Sexe.HOMME);
        
        Client client = new Client(
            //"Id", "Nom", "Prénom","Login", "Pass", "Cin", "Email", "Tel", "Sexe"
            dash.getCenterpanel().getTxts().get("Login").getText(),
            dash.getCenterpanel().getTxts().get("Pass").getText(),
            dash.getCenterpanel().getTxts().get("Nom").getText(),
            dash.getCenterpanel().getTxts().get("Prénom").getText(),
            dash.getCenterpanel().getTxts().get("Email").getText(),
            dash.getCenterpanel().getTxts().get("Cin").getText(),
            dash.getCenterpanel().getTxts().get("Tel").getText(),
            // getSexe combobox
            Sexe.valueOf((String)dash.getCenterpanel().getSexe().getSelectedItem())
        );
        clientDao.save(client);

        // refresh table
        dash.getCenterpanel().getTable().initClientsData(new ClientDao().findAll());
    }
    }

    // delete by id
    // public void deleteClient() {
    //     // delete client
    //     ClientDao clientDao = new ClientDao();
    //     clientDao.delete(Integer.parseInt(dash.getCenterpanel().getTxts().get("Id").getText()));

    //     // refresh table
    //     dash.getCenterpanel().getTable().initClientsData(new ClientDao().findAll());
    // }

    // update by id
    // public void updateClient() {
    //     // update client
    //     ClientDao clientDao = new ClientDao();
    //     Client client = new Client(
    //         //"Id", "Nom", "Prénom","Login", "Pass", "Cin", "Email", "Tel", "Sexe"
    //         dash.getCenterpanel().getTxts().get("Login").getText(),
    //         dash.getCenterpanel().getTxts().get("Pass").getText(),
    //         dash.getCenterpanel().getTxts().get("Nom").getText(),
    //         dash.getCenterpanel().getTxts().get("Prénom").getText(),
    //         dash.getCenterpanel().getTxts().get("Email").getText(),
    //         dash.getCenterpanel().getTxts().get("Cin").getText(),
    //         dash.getCenterpanel().getTxts().get("Tel").getText(),
    //         // getSexe combobox
    //         Sexe.valueOf((String)dash.getCenterpanel().getSexe().getSelectedItem())
    //     );
    //     clientDao.update(Integer.parseInt(dash.getCenterpanel().getTxts().get("Id").getText()), client);

    //     // refresh table
    //     dash.getCenterpanel().getTable().initClientsData(new ClientDao().findAll());
    // }

    // action lisner
    public void ActionLisner() {


        // add client
       
            dash.getCenterpanel().getBtn_Action().addActionListener(e -> {
                dash.getCenterpanel().getBtn_Action().setEnabled(false);

                if (dash.getCenterpanel().getBtn_Action().getText()=="Ajouter") {
                // disactivate dash.getCenterpanel().getBtn_Action()
                addClient();
                }
                dash.getCenterpanel().getBtn_Action().setEnabled(true);

            });
        
    }
}