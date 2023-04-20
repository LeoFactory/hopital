package leo.labatut.projet.model;

public class Ordonnance {
    private static int nbOrdonnance;
    private int idOrdonnance;
    private Patient patient;
    private Medecin medecin;
    public Ordonnance(Patient patient , Medecin medecin) {
        this.patient=patient;
        this.medecin=medecin;
        this.idOrdonnance=nbOrdonnance;
        nbOrdonnance++;
    }

    public int getIdOrdonnance() {
        return idOrdonnance;
    }

    public static int getNbOrdonnance() {
        return nbOrdonnance;
    }
    public Patient getPatient() {
    	return this.patient;
    }
    public void setPatirnt(Patient patient) {
    	this.patient=patient;
    }
    
    public Medecin getMedecin() {
    	return this.medecin;
    }
    public void setPatirnt(Medecin medecin) {
    	this.medecin=medecin;
    }
}