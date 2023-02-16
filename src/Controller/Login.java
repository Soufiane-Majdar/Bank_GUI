package Controller;

import Model.Domain.Utilisateur;

public class Login {
    
    Utilisateur user;

    public Login(Utilisateur user) {
        this.user = user;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public boolean login(String login, String pass) {
        return false;
    }

    public boolean logout() {
        return false;
    }

}
