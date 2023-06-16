package leo.labatut.projet.model;

import java.util.Date;

public class AgentAdmin extends Personnel {
	
	public AgentAdmin(String nom, String prenom, Date dateNaissance,char sexe,String email) {
		super(nom,prenom,dateNaissance,sexe,email);
	}
	
    public AgentAdmin(int id, String nom, String prenom, Date dateNaissance,char sexe,String email) {
        super(id,nom,prenom,dateNaissance,sexe,email);
        
    }
    public AgentAdmin(int id, String nom, String prenom, Date dateNaissance,char sexe,String email,String mdp) {
        super(id,nom,prenom,dateNaissance,sexe,email);
        
    }

    @Override
    public String toString() {
        return "AgentAdmin{" +super.toString()+"\n";
    }
}