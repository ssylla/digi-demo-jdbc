package fr.digi.m0923;

import java.sql.*;
import java.util.ResourceBundle;

public class App {
    public static final String DB_URL ;
    public static final String DB_USER;
    public static final String DB_PWD;

    static {
        System.out.println("Bloc static");
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.password");
    }

    {
        System.out.println("Hello bloc d'instance");
    }

    public static void main(String[] args) {

        creation();
    }

    private static void creation() {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = cnx.createStatement()) {
            cnx.setAutoCommit(false);
            int nb = st.executeUpdate("INSERT INTO FOURNISSEUR (NOM) VALUES ('Diginamic AUTOCOMMIT')");
            System.out.println("Nombre d'éléments modifés : "+ nb);
            cnx.commit();
        } catch (SQLException e) {
            System.out.println("Attention : " + e.getMessage());
        }
    }
    private static void lecture() {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery("SELECT ID, NOM FROM FOURNISSEUR")) {
            while (rs.next()) {
                System.out.println("Fournisseur : id = "+rs.getInt("ID")+", nom = "+rs.getString("NOM"));
            }
        } catch (SQLException e) {
            System.out.println("Attention : " + e.getMessage());
        }
    }
}