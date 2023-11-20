package fr.digi.m0923.jdbc;

import fr.digi.m0923.jdbc.dal.FournisseurDAO;
import fr.digi.m0923.jdbc.dal.jdbc.FournisseurDAOJDBC;
import fr.digi.m0923.jdbc.entites.Fournisseur;

public class TestInsertionDAO {

    public static void main(String[] args) {
        try {
            FournisseurDAO dao = new FournisseurDAOJDBC();
            dao.insert(new Fournisseur("L''entreprise"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
