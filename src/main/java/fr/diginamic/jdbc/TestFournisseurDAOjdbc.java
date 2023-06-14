package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public class TestFournisseurDAOjdbc {
    public static void main(String[] args) {
        try{
            FournisseurDaoJdbc fourDao = new FournisseurDaoJdbc();
            // lister les fournisseurs
            List<Fournisseur> fournisseurs = fourDao.extraire();
            for (Fournisseur f:fournisseurs
            ) {
                System.out.println(f);
            }

            // ajouter new fournisseur
            Fournisseur newFour = new Fournisseur("l'alalal");
            fourDao.insert(newFour);

            // update fournisseur
            fourDao.update("l'alalal","l'a");

            // delete fournisseur
            fourDao.delete(newFour);

        }catch (Exception e){
            System.out.println(e);
        }

    }
}
