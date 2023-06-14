package fr.diginamic.jdbc.entites;

public class Fournisseur extends BaseClass{
    private String nom;

    public Fournisseur(int ID, String nom) {
        super(ID);
        this.nom = nom;
    }

    public Fournisseur(String nom) {
        super();
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
                "ID='" + this.getID() + '\'' +
                "nom='" + nom + '\'' +
                '}';
    }
}
