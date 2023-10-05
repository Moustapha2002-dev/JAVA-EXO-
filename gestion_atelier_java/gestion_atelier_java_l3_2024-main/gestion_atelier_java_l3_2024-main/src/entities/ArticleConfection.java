package entities;

import java.util.ArrayList;

public class ArticleConfection extends AbstractEntity {
    private static int nextId = 1; // Variable statique pour l'auto-incrémentation
    private double prix;
    private double qte;
    private Categorie categorie;
    private ArrayList<Unite> unites = new ArrayList<>();

    public ArticleConfection() {
        super();
        this.id = nextId++;
    }

    public ArticleConfection(String libelle, double prix, double qte, Categorie categorie, Unite unite) {
        super();
        this.libelle = libelle;
        this.prix = prix;
        this.qte = qte;
        this.categorie = categorie;
        this.unites.add(unite);
        this.id = nextId++;
    }

    public void addUnite(Unite unite) {
        unites.add(unite);
    }

    public ArrayList<Unite> getUnites() {
        return unites;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "ArticleConfection [ID=" + getId() + ", Libellé=" + libelle + ", Prix=" + prix + ", Quantité=" + qte
                + ", Catégorie=" + categorie.getLibelle() + ", Unités=" + unites.toString() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getId();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArticleConfection other = (ArticleConfection) obj;
        if (getId() != other.getId())
            return false;
        return true;
    }
}
