package leo.labatut.projet.model;

public class Pathologie {
 
    private int id;
    private String nom;
    private Service service;
/**
 * constructeur
 * @param id
 * @param nom
 */
    public Pathologie(int id, String nom) {
    	
        this.id=id;
        this.nom=nom;
    }
    /**
     * constructeur 2
     * @param id
     * @param nom
     */
    public Pathologie(String nom,Service service) {
    	
        this.nom=nom;
        this.service=service;
    }
    /**
     * constructeur 3
     * @param id
     * @param nom
     */
    public Pathologie(int id, String nom,Service service) {
    	
        this.id=id;
        this.nom=nom;
        this.service=service;
    }
    
    /*
     * getters/setters
     */
    public int getId() {
        return id;
    }
    public void setId(int id) {
    	this.id=id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
    	this.nom=nom;
    }
    public Service getService() {
		return this.service;
	}
    public void setService (Service service) {
    	this.service=service;
    }

    @Override
    public String toString() {
        return "Pathologie{" +
                "\nidPathologie=" + id +
                ", \nnom='" + nom +
                '}';
    }



	
}