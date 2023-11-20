package fr.digi.m0923.jdbc.dal;

import fr.digi.m0923.jdbc.entites.Utilisateur;

public interface UtilisateurDAO {

    Utilisateur authentification(String login, String password) throws Exception;
    Utilisateur authentificationSecurisee(String login, String password) throws Exception;
}
