package leo.labatut.projet.model;

public class Service {
   private int id;
    private String nom;
    /**
     * constructeur
     * @param id
     * @param nom
     */
    public Service(int id , String nom) {
    	this.id=id;
        this.nom=nom;
        
    }
    /*
     * getters/setters
     */
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
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
                "idService=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}