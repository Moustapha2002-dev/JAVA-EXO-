package entities;

public class Categorie extends AbstractEntity {
    private static int nextId = 1; // Variable statique pour l'auto-incrémentation des ID de catégories

    public Categorie() {
        super(); // Appel du constructeur de la classe parente sans argument
        this.id = nextId++;
    }

    public Categorie(String libelle) {
        super(); // Appel du constructeur de la classe parente sans argument
        this.libelle = libelle;
        this.id = nextId++;
    }

    @Override
    public String toString() {
        return "Categorie " + super.toString();
    }
}
