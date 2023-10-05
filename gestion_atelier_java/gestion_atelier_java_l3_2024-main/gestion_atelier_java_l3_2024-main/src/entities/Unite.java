package entities;

public class Unite extends AbstractEntity {
    private static int nextId = 1; // Variable statique pour l'auto-incrémentation des ID d'unités

    public Unite(String libelle) {
        super(); // Appel du constructeur de la classe parente sans argument
        this.libelle = libelle;
        this.id = nextId++;
    }

    @Override
    public String toString() {
        return "Unite " + super.toString();
    }
}
