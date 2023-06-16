package leo.labatut.projet.model;
import java.util.*;

public class Patient {
 
    private int id;   
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Date dateCreation;
    private String email;
    private char sexe;
    private Chambre chambre; 
   /**
    * Constructeur
    * @param nom
    * @param prenom
    * @param dateNaissance
    * @param dateCreation
    * @param sexe
    * @param email
    */
    public Patient( String nom, String prenom, Date dateNaissance, Date dateCreation,char sexe,String email) {        
        this.nom=nom;
        this.prenom=prenom;     
        this.dateNaissance=dateNaissance;
        this.email=email;
        this.dateCreation=dateCreation;
        this.sexe=sexe;
        
    }
    /**
     * constructeur 2
     * @param id
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param dateCreation
     * @param sexe
     * @param email
     */
    public Patient(int id, String nom, String prenom, Date dateNaissance, Date dateCreation,char sexe,String email) {
        this.id=id;        
        this.nom=nom;
        this.prenom=prenom;  
        this.dateNaissance=dateNaissance;
        this.email=email;
        this.dateCreation=dateCreation;
        this.sexe=sexe;
        
        

    }
    /**
     * constructeur 3
     * @param id
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param dateCreation
     * @param sexe
     * @param email
     * @param chambre
     */
    public Patient(int id, String nom, String prenom, Date dateNaissance, Date dateCreation,char sexe,String email,Chambre chambre) {
        this.id=id;        
        this.nom=nom;
        this.prenom=prenom;  
        this.dateNaissance=dateNaissance;
        this.email=email;
        this.dateCreation=dateCreation;
        this.sexe=sexe;
        this.chambre=chambre;
        

    }
    /*
     * getters/setters
     */
    public int getId() {
    	return this.id;
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

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
    	this.prenom=prenom;
    }
    public Date getDateNaissance() {
    	return this.dateNaissance;
    }
    
    public void setDateNaissance(Date dateNaissance) {
    	this.dateNaissance=dateNaissance;
    	
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    public String getEmail() {
    	return this.email;
    }
    public void setEmail(String email) {
    	this.email=email;
    }
    
    public char getSexe() {
    	return this.sexe;
    }
    public void setSexe(char sexe) {
    	this.sexe=sexe;
    }
    
    public Chambre getChambre() {
    	return this.chambre;
    }
    public void setChambre(Chambre chambre) {
    	this.chambre=chambre;
    }

    @Override
    public String toString() {
        return "Patient{" +
        		", \ndateCreation=" + dateCreation +
                ", \nid = " + id +
                ", \nnom='" + nom + '\'' +
                ", \nprenom='" + prenom + '\'' +
                ", \nDate de naissance='" + dateNaissance + '\'' +
                ", \nChambre ='" + chambre + '\'' +
                ", \nE-mail='" + email + '\'' +              
                '}';
    }
}