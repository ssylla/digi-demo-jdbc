package fr.digi.m0923.jdbc.dal;

import fr.digi.m0923.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public interface FournisseurDAO {

    List<Fournisseur> extraire() throws Exception;

    void insert(Fournisseur fournisseur) throws Exception;
}
