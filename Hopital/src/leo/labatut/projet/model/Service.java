package leo.labatut.projet.model;

public class Service {
   private int id;
    private String nom;
    
    public Service(int id , String nom) {
    	this.id=id;
        this.nom=nom;
        
    }
    public int getId() {
        return this.id;
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