package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.util.List;

public interface IFournisseurDAO {
    List<Fournisseur> extraire();
    void insert(Fournisseur fournisseur);
    int update(String ancienNom, String newNom);
    boolean delete(Fournisseur fournisseur);

}
