package leo.labatut.projet.model;

public class Appareil {
    private static int nbAppareils;
    private int idAppareil;
    private String libelle;
    public Appareil(String libelle) {
        this.idAppareil=nbAppareils;
        nbAppareils++;
        this.libelle=libelle;

    }

    public int getIdAppareil() {
        return idAppareil;
    }

    public int getNbAppareils() {
        return nbAppareils;
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
                "idAppareil=" + idAppareil +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}