package leo.labatut.projet.model;

public class AgentAdmin extends Personnel {
    private static int nbAgent=0;
    private int idAgAdmin;
    public AgentAdmin(String nom, String prenom) {
        super(nom,prenom);
        idAgAdmin=nbAgent;
        nbAgent++;
    }
    public int getIdAgAdmin() {
        return idAgAdmin;
    }

    public static int getNbAgent() {
        return nbAgent;
    }

    @Override
    public String toString() {
        return "AgentAdmin{" +super.toString()+
                "idAgAdmin=" + idAgAdmin +
                '}';
    }
}