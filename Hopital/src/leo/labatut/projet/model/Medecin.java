package leo.labatut.projet.model;

import java.util.Date;

public class Medecin extends Personnel {
   
    private Service service;
    
    public Medecin() {
    }

    public Medecin( String nom, String prenom,Date dateNaissance ,char sexe,Service service,String email){
        super(nom,prenom,dateNaissance,sexe,email);
        this.service=service;
    }
    public Medecin(String nom, String prenom, Date dateNaissance,char sexe,Service service,String email, String mdp ) {
    	super(nom,prenom,dateNaissance,sexe,email,mdp);
    	this.service=service;
    }
    
    public Medecin(int id, String nom, String prenom , Date dateNaissance,char sexe,Service service,String email) {
      super(id,nom,prenom,dateNaissance,sexe,email);
      this.service=service;

    }

    public Service getService() {
        return this.service;
    }

    public void setService(Service service) {
        this.service = service;
    }


    @Override
    public String toString() {
        return "Medecin{" + super.toString()+
                '}'+"\n";
    }
}