package leo.labatut.projet.model;

public class Medecin extends Personnel {
   
    private Service service;


    public Medecin(int id, String nom, String prenom){
        super(id,nom,prenom);
        
    }
    
    public Medecin(int id , String nom, String prenom,Service service) {
      super(id, nom,prenom);
      this.service=service;

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