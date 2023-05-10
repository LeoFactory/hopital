package leo.labatut.projet.model;

public abstract class Personnel {
	
	private int id;
    private String nom;
    private String prenom;
    
    public Personnel(String nom, String prenom) {
    	this.nom=nom;
    	this.prenom=prenom;
    }
    
    public Personnel(int id, String nom, String prenom) {
    	this.id=id;
        this.nom=nom;
        this.prenom=prenom;
    }
    public int getId() {
    	return this.id;
    }
    public void setId(int id) {
    	this.id =id;
    }
    public String getNom(){
        return nom;
    }
    public void setNom(String nom) {
    	this.nom=nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom) {
    	this.prenom=prenom;
    }

    @Override
    public String toString() {
        return
                "Id = "+id+ " nom = '" + nom + '\'' +
                ", prenom = '" + prenom + '\''
                ;
    }
}