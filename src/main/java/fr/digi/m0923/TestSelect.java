package fr.digi.m0923;

import fr.digi.m0923.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static fr.digi.m0923.App.*;

public class TestSelect {

    public static void main(String[] args) {

        List<Fournisseur> fournisseurs = new ArrayList<>();
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery("SELECT ID, NOM FROM FOURNISSEUR")) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nomFournisseur = rs.getString("NOM");
                Fournisseur fournisseur = new Fournisseur(id, nomFournisseur);
                fournisseurs.add(fournisseur);
            }
        } catch (SQLException e) {
            System.out.println("Attention : " + e.getMessage());
        }

        for (Fournisseur item : fournisseurs) {
            System.out.println(item);
        }
    }
}
