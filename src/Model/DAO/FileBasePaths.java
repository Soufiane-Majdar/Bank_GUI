package Model.DAO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface FileBasePaths {

    Path BASE_PATH = Paths.get("Files");
    Path CLIENT_TABLE = Paths.get(BASE_PATH +"/Clients.txt");
    Path CLIENTINDEX = Paths.get(BASE_PATH + "/clientsIndexes.txt");
    Path ADMIN_TABLE = Paths.get(BASE_PATH +"/Admins.txt");
    Path COMPTE_TABLE = Paths.get(BASE_PATH +"/Comptes.txt");
    Path OPERATION_TABLE = Paths.get(BASE_PATH +"/Operations.txt");
    Path LOG_TABLE = Paths.get(BASE_PATH +"/Logs.txt");

    static void createFileBaseTables(){
        if(!BASE_PATH.toFile().exists()){
            BASE_PATH.toFile().mkdir();
        } else {
            System.err.println("!!! " + BASE_PATH.toFile().getName() + " Exixts deja !!!" );
        }


        if(!CLIENT_TABLE.toFile().exists()){
            try {
                CLIENT_TABLE.toFile().createNewFile();
                String header = "id\t\t\tnom\t\t\tprenom\t\t\tlogin\t\t\tpassword\t\t\tcin\t\t\ttel\t\t\temail\t\t\tsexe\n";
                Files.writeString(CLIENT_TABLE, header);
                System.out.println(CLIENT_TABLE.toFile().getName() + " crée avec succès.");
            } catch (IOException e) {
                                //throw new RuntimeException(e);
                                System.err.println(e.getMessage());
            }
        } else {
            System.err.println("!!! " + CLIENT_TABLE.toFile().getName() + " Exixts deja !!!" );
        }


        if(!ADMIN_TABLE.toFile().exists()){
            try {
                ADMIN_TABLE.toFile().createNewFile();
                String header = "id\t\t\tnom\t\t\tprenom\t\t\tlogin\t\t\tpassword\n";
                Files.writeString(ADMIN_TABLE, header);
                System.out.println(ADMIN_TABLE.toFile().getName() + " crée avec succès.");
            } catch (IOException e) {
                                //throw new RuntimeException(e);
                                System.err.println(e.getMessage());
            }
        } else {
            System.err.println("!!! " + ADMIN_TABLE.toFile().getName() + " Exixts deja !!!" );
        }


        if(!COMPTE_TABLE.toFile().exists()){
            try {
                COMPTE_TABLE.toFile().createNewFile();
                String header = "id\t\t\tidClient\t\t\tnumero\t\t\tsolde\t\t\tdateCreation\n";
                Files.writeString(COMPTE_TABLE, header);
                System.out.println(COMPTE_TABLE.toFile().getName() + " crée avec succès.");
            } catch (IOException e) {
                                //throw new RuntimeException(e);
                                System.err.println(e.getMessage());
            }
        } else {
            System.err.println("!!! " + COMPTE_TABLE.toFile().getName() + " Exixts deja !!!" );
        }


        if(!OPERATION_TABLE.toFile().exists()){
            try {
                OPERATION_TABLE.toFile().createNewFile();
                String header = "id\t\t\tidCompte\t\t\ttype\t\t\tmontant\t\t\tdateOperation\n";
                Files.writeString(OPERATION_TABLE, header);
                System.out.println(OPERATION_TABLE.toFile().getName() + " crée avec succès.");
            } catch (IOException e) {
                                //throw new RuntimeException(e);
                                System.err.println(e.getMessage());
            }
        } else {
            System.err.println("!!! " + OPERATION_TABLE.toFile().getName() + " Exixts deja !!!" );
        }


        if(!LOG_TABLE.toFile().exists()){
            try {
                LOG_TABLE.toFile().createNewFile();
                String header = "id\t\t\tidCompte\t\t\ttype\t\t\tmontant\t\t\tdateOperation\n";
                Files.writeString(LOG_TABLE, header);
                System.out.println(LOG_TABLE.toFile().getName() + " crée avec succès.");
            } catch (IOException e) {
                                //throw new RuntimeException(e);
                                System.err.println(e.getMessage());
            }
        } else {
            System.err.println("!!! " + LOG_TABLE.toFile().getName() + " Exixts deja !!!" );
        }




    



    }





}
