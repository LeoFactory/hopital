package leo.labatut.projet.model;

public class Appareil {
    
    private int id;
    private String libelle;
    
    public Appareil(int id, String libelle) {
        this.id=id;
        this.libelle=libelle;

    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Appareil{" +
                "id =" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}