package leo.labatut.projet.model;

public class Ordonnance {

    private int idOrdonnance;
    private Patient patient;
    private Medecin medecin;
    public Ordonnance(Patient patient , Medecin medecin) {
        this.patient=patient;
        this.medecin=medecin;
        
    }

    public int getIdOrdonnance() {
        return idOrdonnance;
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