package fr.digi.m0923.jdbc.dal.xml;

import fr.digi.m0923.jdbc.dal.FournisseurDAO;
import fr.digi.m0923.jdbc.entites.Fournisseur;

import java.util.List;

public class FounisseurDAOXML implements FournisseurDAO {
    @Override
    public List<Fournisseur> extraire() throws Exception {
        //TODO FAire ce qu'il faut pour aller chercher les fournisseurs dans un fichier XML
        return null;
    }

    @Override
    public void insert(Fournisseur fournisseur) throws Exception {

    }
}
