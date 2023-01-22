package Model.dao;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface FileBasePaths {
    Path FILEBASE = Paths.get("src/Model/db");
    Path CLIENT_TABLE = Paths.get(FILEBASE + "/clients.txt");
    Path CLIENTINDEX = Paths.get(FILEBASE + "/clientsIndexes.txt");
    Path ACCOUNTS_TABLE = Paths.get(FILEBASE + "/comptes.txt");
    Path BANK_AGENCIES_TABLE = Paths.get(FILEBASE + "/agences.txt");
    Path LOGS_FOLDER = Paths.get(FILEBASE + "/Archives");

    static void createFileBaseTables(){
        if(!FILEBASE.toFile().exists()){
            FILEBASE.toFile().mkdir();
        } else {
            System.err.println("!!! " + FILEBASE.toFile().getName() + " Exixts deja !!!" );
        }
        if(!LOGS_FOLDER.toFile().exists()){
            LOGS_FOLDER.toFile().mkdir();
            // Or : Files.createDirectory();
        }        else {
            System.err.println("!!! " + FILEBASE.toFile().getName() + " Exixts deja !!!" );
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


        if(!ACCOUNTS_TABLE.toFile().exists()){
            try {
                ACCOUNTS_TABLE.toFile().createNewFile();
                String header = "id\t\t\tdateCreation\t\t\tsolde\t\t\tidClient\n";
                Files.writeString(ACCOUNTS_TABLE, header);

                System.out.println(ACCOUNTS_TABLE.toFile().getName() + " crée avec succès.");
            } catch (IOException e) {
                //throw new RuntimeException(e);
                System.err.println(e.getMessage());
            }
        }

        if(!BANK_AGENCIES_TABLE.toFile().exists()){
            try {
                BANK_AGENCIES_TABLE.toFile().createNewFile();
                String header = "id\t\t\tnom\t\t\tadresse\t\t\ttel\t\t\temail\n";
                Files.writeString(BANK_AGENCIES_TABLE, header);

                System.out.println(BANK_AGENCIES_TABLE.toFile().getName() + " crée avec succès.");
            } catch (IOException e) {
                //throw new RuntimeException(e);
                System.err.println(e.getMessage());
            }
        }
    }
}
