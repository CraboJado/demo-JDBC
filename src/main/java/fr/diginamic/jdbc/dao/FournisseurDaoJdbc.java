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
    public List<Fournisseur> extraire() {
        ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
        try (Connection maConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PSW);
             Statement monStatement = maConnection.createStatement();
             ResultSet curseur = monStatement.executeQuery("SELECT * FROM FOURNISSEUR");
        ) {
            while(curseur.next()){
                Integer id = curseur.getInt("ID");
                String nom = curseur.getString("NOM");
                Fournisseur fournisseurCourant = new Fournisseur(id,nom);
                fournisseurs.add(fournisseurCourant);
            }
        } catch (SQLException e) {
            System.err.println("err is " + e);
//            throw new RuntimeException(e);

        }
        return fournisseurs;
    }

    @Override
    public void insert(Fournisseur fournisseur) {
        try (Connection maConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PSW);
             PreparedStatement pstmt = maConnection.prepareStatement("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (?,?)")
        ) {
            pstmt.setInt(1,fournisseur.getID());
            pstmt.setString(2,fournisseur.getNom());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("err is " + e);
//            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(String ancienNom, String newNom) {
        int nb = 0;
        try (Connection maConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PSW);
             PreparedStatement pstmt = maConnection.prepareStatement("UPDATE FOURNISSEUR SET NOM = ? WHERE NOM = ?")
        ) {
            pstmt.setString(1,newNom);
            pstmt.setString(2,ancienNom);
            nb = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("err is " + e);
//            throw new RuntimeException(e);
        }
        return nb;
    }

    @Override
    public boolean delete(Fournisseur fournisseur) {
        boolean flag = false;

        try (Connection maConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PSW);
             PreparedStatement psmt = maConnection.prepareStatement("DELETE FROM FOURNISSEUR WHERE ID = ?")
        ) {
            psmt.setInt(1,fournisseur.getID());
            psmt.executeUpdate();
            flag=true;
        } catch (SQLException e) {
            System.err.println("err is " + e);
//            throw new RuntimeException(e);
        }

        return flag;
    }
}
