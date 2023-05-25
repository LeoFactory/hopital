package leo.labatut.projet.model;

import java.util.Date;

public abstract class Personnel {
	
	private int id;
    private String nom;
    private String prenom; 
    private Date dateNaissance;
    private char sexe;
    private String email;
    private String mdp;
    
    public Personnel() {
    	
    }
    
    public Personnel(String nom, String prenom, Date dateNaissance,char sexe,String email) {
    	this.nom=nom;
    	this.prenom=prenom;   	
        this.dateNaissance=dateNaissance;
        this.sexe=sexe;
        this.email=email;
    }
    public Personnel(String nom, String prenom, Date dateNaissance,char sexe,String email, String mdp) {
    	this.nom=nom;
    	this.prenom=prenom;   	
        this.dateNaissance=dateNaissance;
        this.sexe=sexe;
        this.email=email;
        this.mdp=mdp;
    }
    
    public Personnel(int id, String nom, String prenom, Date dateNaissance,char sexe,String email) {
    	this.id=id;
        this.nom=nom;
        this.prenom=prenom;    
        this.dateNaissance=dateNaissance;
        this.sexe=sexe;
        this.email=email;
        
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
    public String getEmail() {
    	return this.email;
    }
    public void setEmail(String email) {
    	this.email=email;
    }
    public Date getDateNaissance() {
    	return dateNaissance;
    }
    public void setDateNaissance(Date date) {
    	this.dateNaissance=date;
    }
    public char getSexe() {
    	return this.sexe;
    }
    public void setSexe(char genre) {
    	this.sexe = genre;
    }
    public String getMdp() {
    	return this.mdp;
    }
    public void setMdp(String mdp) {
    	this.mdp=mdp;
    }

    @Override
    public String toString() {
        return
                "Id = "+id+ " nom = '" + nom + '\'' +
                ", prenom = '" + prenom + '\''+
                ", date de naissance = '"+dateNaissance+'\''+
                ", genre = '"+sexe+'\''
                ;
    }
}