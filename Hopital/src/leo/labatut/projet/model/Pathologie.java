package leo.labatut.projet.model;

public class Pathologie {
    private static int nbPathologies=0;
    private int idPathologie;
    private String nom;

    public Pathologie(String nom) {
        this.idPathologie=nbPathologies;
        nbPathologies++;
        this.nom=nom;
    }

    public String getNom() {
        return nom;
    }

    public int getIdPathologie() {
        return idPathologie;
    }

    public static int getNbPathologies() {
        return nbPathologies;
    }

    @Override
    public String toString() {
        return "Pathologie{" +
                "idPathologie=" + idPathologie +
                ", nom='" + nom +
                '}';
    }
}