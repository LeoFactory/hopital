package leo.labatut.projet.model;

public abstract class Personnel {
    private String nom;
    private String prenom;
    public Personnel(String nom, String prenom) {
        this.nom=nom;
        this.prenom=prenom;
    }
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }

    @Override
    public String toString() {
        return
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\''
                ;
    }
}