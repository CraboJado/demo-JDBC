package fr.diginamic.jdbc.entites;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;

import java.util.ArrayList;
import java.util.List;

public class TestFournisseurDAOjdbc {
    public static void main(String[] args) {
        FournisseurDaoJdbc fourDaoJdbc = new FournisseurDaoJdbc();
        List<Fournisseur> fournisseurs = fourDaoJdbc.extraire();


//        Fournisseur newFournisseur = new Fournisseur(4,"La Maison de la Peinture");
//        fourDaoJdbc.insert(newFournisseur);

//        fourDaoJdbc.update("La Maison de la Peinture","La Maison des Peintures");
        for (Fournisseur fournisseur:fournisseurs
             ) {
            if(fournisseur.getID() == 4){
                fourDaoJdbc.delete(fournisseur);
                System.out.println(fournisseur);
            }
        }

    }
}
