package leo.labatut.projet.model;
import java.util.*;

public class Patient {
 
    private int id;
    private String nom;
    private String prenom;
    private Date dateCreation;
    
    public Patient(int id, String nom, String prenom, Date date) {
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.dateCreation=date;

    }
    public int getId() {
    	return this.id;
    }
    public void setId(int id) {
    	this.id=id;
    }
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateCreation() {
        return dateCreation;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id = " + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateCreation=" + dateCreation +
                '}';
    }
}