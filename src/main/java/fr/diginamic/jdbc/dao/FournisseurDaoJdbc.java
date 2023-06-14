package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDaoJdbc implements  IFournisseurDAO{

    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PSW;

    static {
        ResourceBundle monFichierConf = ResourceBundle.getBundle("db");
        DB_URL = monFichierConf.getString("db.DB_URL");
        DB_USER = monFichierConf.getString("db.DB_USER");
        DB_PSW = monFichierConf.getString("db.DB_PSW");
    }
    @Override
    public List<Fournisseur> extraire() throws SQLException {
        ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
        try (Connection maConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PSW);
             PreparedStatement psmt = maConnection.prepareStatement("SELECT * FROM FOURNISSEUR");
             ResultSet curseur = psmt.executeQuery();
        ) {
            while(curseur.next()){
                Integer id = curseur.getInt("ID");
                String nom = curseur.getString("NOM");
                Fournisseur fournisseurCourant = new Fournisseur(id,nom);
                fournisseurs.add(fournisseurCourant);
            }
        }
        return fournisseurs;
    }

    @Override
    public void insert(Fournisseur fournisseur) throws SQLException {
        try (Connection maConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PSW);
             PreparedStatement psmt = maConnection.prepareStatement("INSERT INTO FOURNISSEUR (NOM) VALUES (?)");
        ) {
            psmt.setString(1, fournisseur.getNom());
            psmt.executeUpdate();
        }
    }

    @Override
    public int update(String ancienNom, String newNom) throws SQLException {
        int nb = 0;
        try (Connection maConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PSW);
             PreparedStatement psmt = maConnection.prepareStatement("UPDATE FOURNISSEUR SET NOM = ? WHERE NOM = ?");
        ) {
           psmt.setString(1,newNom);
           psmt.setString(2,ancienNom);
           nb = psmt.executeUpdate();
        }
        return nb;
    }

    @Override
    public boolean delete(Fournisseur fournisseur) throws SQLException {
        int nb = 0;

        try (Connection maConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PSW);
             PreparedStatement psmt = maConnection.prepareStatement("DELETE FROM FOURNISSEUR WHERE ID = ? ");
        ) {
            psmt.setString(1, fournisseur.getNom());
            nb = psmt.executeUpdate();
        }
        return nb > 0;
    }
}
