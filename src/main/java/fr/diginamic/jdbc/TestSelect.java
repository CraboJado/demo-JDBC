package fr.diginamic.jdbc;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TestSelect {
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PSW;

    static {
        ResourceBundle monFichierConf = ResourceBundle.getBundle("db");
        DB_URL = monFichierConf.getString("db.DB_URL");
        DB_USER = monFichierConf.getString("db.DB_USER");
        DB_PSW = monFichierConf.getString("db.DB_PSW");
    }

    public static void main(String[] args) {
        try (Connection maConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PSW);
             Statement monStatement = maConnection.createStatement();
             ResultSet curseur = monStatement.executeQuery("SELECT * FROM FOURNISSEUR");
        ) {
            ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
            while(curseur.next()){
//                Integer id = curseur.getInt("ID");
                String nom = curseur.getString("NOM");
                Fournisseur fournisseurCourant = new Fournisseur(nom);
                fournisseurs.add(fournisseurCourant);
            }
            System.out.println(fournisseurs);
        } catch (SQLException e) {
            System.err.println("err is " + e);
//            throw new RuntimeException(e);
        }
    }
}
