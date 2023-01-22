 package Model.Domain;

public class Admin extends Utilisateur{

    private static  Admin ADMIN = new Admin();

    private Admin(){

        login       = "bachir";
        motDePasse  = "ben";
        role        = "Admin";
        nom         =  "BENSELLAK";
        prenom      = "ELBACHIR";

    }


    public static Admin getInstance(){
        return ADMIN;
    }
}
