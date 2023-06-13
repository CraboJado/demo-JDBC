package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public interface IFournisseurDAO {
    List<Fournisseur> extraire() throws SQLException;
    void insert(Fournisseur fournisseur) throws SQLException;
    int update(String ancienNom, String newNom) throws SQLException;
    boolean delete(Fournisseur fournisseur) throws SQLException;

}
