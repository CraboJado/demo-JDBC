package fr.diginamic.jdbc.entites;

public class Fournisseur {
    private String nom;

    public Fournisseur(String nom) {
        this.nom = nom;
    }

    public Fournisseur() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
