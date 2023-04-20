package leo.labatut.projet.model;

public class Service {
    private static int nbService=0;
    private int idService;
    private String nom;
    public Service(String nom) {
        this.nom=nom;
        this.idService=nbService;
        nbService++;
    }
    public int getIdService() {
        return idService;
    }

    public static int getNbService() {
        return nbService;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Service{" +
                "idService=" + idService +
                ", nom='" + nom + '\'' +
                '}';
    }
}