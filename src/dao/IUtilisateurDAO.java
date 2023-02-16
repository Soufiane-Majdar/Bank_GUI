package dao;

import Model.Domain.Utilisateur;

public interface IUtilisateurDAO extends IDao<Utilisateur, Long> {

    Utilisateur findByLoginAndPass(String login, String pass);
}
