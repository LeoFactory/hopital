package leo.labatut.projet.model;

import java.util.Date;

public class Technicien extends Personnel {
	
	public Technicien(String nom, String prenom, Date dateNaissance,char sexe,String email) {
        super( nom,prenom, dateNaissance, sexe,email);
    }
	
    
    public Technicien(int id, String nom, String prenom, Date dateNaissance,char sexe,String email) {
        super(id, nom,prenom, dateNaissance, sexe, email);
    }
}