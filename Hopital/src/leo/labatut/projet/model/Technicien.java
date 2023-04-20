package leo.labatut.projet.model;

public class Technicien extends Personnel {
    private static int nbTechnicien=0;
    private int idTech;
    public Technicien(String nom , String prenom) {
        super(nom,prenom);
        this.idTech=nbTechnicien;
        nbTechnicien++;

    }

    public int getIdTech() {
        return idTech;
    }

    public static int getNbTechnicien() {
        return nbTechnicien;
    }
}