package fr.digi.m0923;

import fr.digi.m0923.jdbc.dal.UtilisateurDAO;
import fr.digi.m0923.jdbc.dal.jdbc.UtilisateurDAOJDBC;
import fr.digi.m0923.jdbc.entites.Utilisateur;

import java.util.Scanner;

public class TestLogin {

    public static void main(String[] args) {
        System.out.println("**********************************************************");
        System.out.println("***************Bienvenue dans mon App*********************");
        System.out.println("**********************************************************");
        System.out.println("* Merci de vous authentifier...");

        Scanner sc = new Scanner(System.in);
        System.out.print("* Votre identifiant : ");
        String login = sc.nextLine();
        System.out.print("* Votre mot de passe : ");
        String password = sc.nextLine();

        try {
            UtilisateurDAO dao = new UtilisateurDAOJDBC();
            Utilisateur utilisateurConnecte = dao.authentificationSecurisee(login, password);
            if (null != utilisateurConnecte) {
                System.out.printf("* Bienvenue à toi %s%n", utilisateurConnecte.getLogin());
            } else {
                System.err.println("* Erreur d'authentification....");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
