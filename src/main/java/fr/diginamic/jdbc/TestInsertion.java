package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {
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
        ) {
            int nb = monStatement.executeUpdate("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (4,'La Maison de la Peinture')");
            System.out.println(nb);
        } catch (SQLException e) {
            System.err.println("err is " + e);
//            throw new RuntimeException(e);
        }
    }
}
