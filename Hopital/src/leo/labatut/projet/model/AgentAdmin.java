package leo.labatut.projet.model;

public class AgentAdmin extends Personnel {
	
	public AgentAdmin(String nom, String prenom) {
		super(nom,prenom);
	}
	
    public AgentAdmin(int id, String nom, String prenom) {
        super(id,nom,prenom);
        
    }

    @Override
    public String toString() {
        return "AgentAdmin{" +super.toString();
    }
}