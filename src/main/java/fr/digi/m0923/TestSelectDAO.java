package fr.digi.m0923;

import fr.digi.m0923.jdbc.dal.FournisseurDAO;
import fr.digi.m0923.jdbc.dal.jdbc.FournisseurDAOJDBC;
import fr.digi.m0923.jdbc.entites.Fournisseur;

import java.util.List;

public class TestSelectDAO {

    public static void main(String[] args) {
        try {
            FournisseurDAO dao = new FournisseurDAOJDBC();
            List<Fournisseur> fournisseurs = dao.extraire();
            for (Fournisseur item : fournisseurs) {
                System.out.println(item);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
