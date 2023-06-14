package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public class TestFournisseurDAOjdbc {
    public static void main(String[] args) {
        try{
            FournisseurDaoJdbc fourDaoJdbc = new FournisseurDaoJdbc();
            listerFournisseur(fourDaoJdbc);
//            insertFournisseur(fourDaoJdbc);
//            updateFournisseur(fourDaoJdbc);
//            deleteFournisseur(fourDaoJdbc);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    private static void listerFournisseur(FournisseurDaoJdbc dao) throws SQLException {
        List<Fournisseur> fournisseurs = dao.extraire();
        for (Fournisseur f:fournisseurs
             ) {
            System.out.println(f);
        }
    }

    private static void insertFournisseur(FournisseurDaoJdbc dao) throws SQLException {
        Fournisseur f = new Fournisseur("l'alalal");
        dao.insert(f);
    }

    private static void updateFournisseur(FournisseurDaoJdbc dao) throws SQLException {
        dao.update("l'alalal","newL'alala");
    }

    private static void deleteFournisseur(FournisseurDaoJdbc dao) throws SQLException {
        List<Fournisseur> fournisseurs = dao.extraire();

        for (Fournisseur f: fournisseurs
             ) {
            if(f.getNom() == "l'alalal"){
                dao.delete(f);
                System.out.println(f);
            }
        }

    }
}
