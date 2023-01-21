package Model;

import java.util.ArrayList;
import java.util.List;

public class Client extends Utilisateur{
    private String email, cin, tel;
    private Sexe sexe;
    private List<Compte> comptesClient = new ArrayList<>();


    public String       getCin() {
        return cin;
    }
    public String       getTel() {
        return tel;
    }
    public String       getEmail() {
        return email;
    }
    public List<Compte> getComptesClient() {
        return comptesClient;
    }
    public String getSexe() {
        return sexe.toString();
    }
    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }
    public void         setEmail(String email) {
        this.email = email;
    }
    public void         setTel(String tel) {
        this.tel = tel;
    }
    public void         setCin(String cin) {
        this.cin = cin;
    }
    public void         setComptesClient(List<Compte> comptesClient) {
        this.comptesClient = comptesClient;
    }

    public Client(){
        comptesClient = new ArrayList<>();
    }

    public Client(String login, String pass){
        super(login, pass, "Client");
        comptesClient = new ArrayList<>();
    }

    public Client(String login, String pass, String n, String p){
        super(login, pass, "Client");
        setNom(n);
        setPrenom(p);
        comptesClient = new ArrayList<>();
    }
    public Client(String login, String pass, String n, String p, String mail, String cin, String tel, Sexe sexe){
        super(login, pass, "Client");
        setNom(n);
        setPrenom(p);
        setTel(tel);
        setEmail(mail);
        setCin(cin);
        setSexe(sexe);
        comptesClient = new ArrayList<Compte>();
    }

    // setId
    public void setId(Long id) {
        this.id = id;
    }

    // getPassword
    public String getPassword() {
        return super.motDePasse;
    }

    @Override
    public String toString() {

        String      clientStr  = "------------------------------------------------------\n";
        clientStr += "| Identifiant du Client     : "   + this.id        + "\n";
        clientStr += "| Nom Complet               : "   + this.getNomComplet() + "\n" ;
        clientStr += "| Adresse email             : "   + this.email     + "\n" ;
        clientStr += "| Numéro téléphone          : "   + this.tel       + "\n" ;
        clientStr += "| Numéro de CIN             : "   + this.cin       + "\n" ;
        clientStr += "------------------------------------------------------\n";

        return clientStr;
    }

}
