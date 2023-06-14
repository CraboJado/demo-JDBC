package fr.diginamic.jdbc.entites;

public class BaseClass {
    private int ID;

    public BaseClass(int ID) {
        this.ID = ID;
    }

    public BaseClass() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
