package Controller;

import View.Dashboard.Dashboard;

public class App {

    CRUD_Admin admin;
    CRUD_Client client;
    Login login;


    // App 
    public App(Dashboard dash) {
        this.admin = new CRUD_Admin(dash);
        this.client = new CRUD_Client(dash);
    }

    
// main app to control the project
    public static void main(String[] args) {
    
        Dashboard dash = new Dashboard("D A S H B O A R D | Admin");
        App app = new App(dash);
        app.admin = new CRUD_Admin(dash);
        // app.client = new CRUD_Client(dash);


        
    }
}
