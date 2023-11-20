package fr.digi.m0923.jdbc.dal.jdbc;

import fr.digi.m0923.jdbc.dal.FournisseurDAO;
import fr.digi.m0923.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDAOJDBC implements FournisseurDAO {
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
    private static final String EXTRAIRE_QUERY = "SELECT ID, NOM FROM FOURNISSEUR";
    private static final String INSERT_QUERY = "INSERT INTO FOURNISSEUR (NOM) VALUES ('%s')";
    @Override
    public List<Fournisseur> extraire() throws SQLException {

        List<Fournisseur> lesFournisseursTrouves = new ArrayList<>();
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery("SELECT ID, NOM FROM FOURNISSEUR")) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nomFournisseur = rs.getString("NOM");
                Fournisseur fournisseur = new Fournisseur(id, nomFournisseur);
                lesFournisseursTrouves.add(fournisseur);
            }
        }
        return lesFournisseursTrouves;
    }

    @Override
    public void insert(Fournisseur fournisseur) throws SQLException {

        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = cnx.createStatement();) {
            st.executeUpdate(String.format(INSERT_QUERY, fournisseur.getNom()));
        }
    }
}
