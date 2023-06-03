package leo.labatut.projet.model;

import java.util.Date;

public class Infirmier extends Personnel{
	    
	    public Infirmier() {
	    }

	    public Infirmier( String nom, String prenom,Date dateNaissance ,char sexe,String email){
	        super(nom,prenom,dateNaissance,sexe,email);
	       
	    }
	    public Infirmier(String nom, String prenom, Date dateNaissance,char sexe,String email, String mdp ) {
	    	super(nom,prenom,dateNaissance,sexe,email,mdp);
	    	
	    }
	    
	    public Infirmier(int id, String nom, String prenom , Date dateNaissance,char sexe,String email) {
	      super(id,nom,prenom,dateNaissance,sexe,email);


	    }

	    @Override
	    public String toString() {
	        return "Medecin{" + super.toString()+
	                '}'+"\n";
	    }

}
