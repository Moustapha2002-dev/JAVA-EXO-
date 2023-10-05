package entities;

public abstract class AbstractEntity {
    protected int id;
    protected String libelle;



    public AbstractEntity(String libelle) {
        this.libelle = libelle;
    }

    public AbstractEntity(int nextId, String libelle2) {
    }

    public AbstractEntity() {
    }

    public int getId() {
        return this.id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", libelle=" + libelle + "]";
    }
}
