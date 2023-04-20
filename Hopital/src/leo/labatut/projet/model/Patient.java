package leo.labatut.projet.model;
import java.util.*;

public class Patient {
    private static int nbPatient;
    private int idPatient;
    private String nom;
    private String prenom;
    private Date dateCreation;
    public Patient(String nom, String prenom, Date date) {
        this.idPatient=nbPatient;
        nbPatient++;
        this.nom=nom;
        this.prenom=prenom;
        this.dateCreation=date;

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

    public int getIdPatient() {
        return idPatient;
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

    public static int getNbPatient() {
        return nbPatient;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "idPatient=" + idPatient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateCreation=" + dateCreation +
                '}';
    }
}