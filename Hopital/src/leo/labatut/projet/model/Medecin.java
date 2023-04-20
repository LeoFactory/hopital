package leo.labatut.projet.model;

public class Medecin extends Personnel {
    private static int nbMedecin=0;
    private int idMedecin;
    private Service service;


    public Medecin(String nom, String prenom){
        super(nom,prenom);
        this.idMedecin=nbMedecin;
        nbMedecin++;
    }
    public Medecin(String nom, String prenom,Service service) {
      super(nom,prenom);
      this.service=service;
      this.idMedecin=nbMedecin;
      nbMedecin++;

    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public int getNbMedecin() {
        return nbMedecin;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }


    @Override
    public String toString() {
        return "Medecin{" + super.toString()+
                "idMedecin=" + idMedecin +
                ", service=" + service +
                '}';
    }
}