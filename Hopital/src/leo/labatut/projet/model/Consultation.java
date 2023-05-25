package leo.labatut.projet.model;

public class Consultation {
    
    private int id;
    private Patient patient;
    private Medecin medecin;
    
    public Consultation(Patient patient, Medecin medecin) {
    	 this.patient=patient;
         this.medecin=medecin;
    }
    
    public Consultation(int id, Patient patient, Medecin medecin) {
        
        this.id=id;
        this.patient=patient;
        this.medecin=medecin;

    }
    public int getId() {
    	return this.id;
    }
    public void setId(int id) {
    	this.id=id;
    }
    public Patient getPatient() {
    	return this.patient;
    }
    public void setPatient(Patient patient) {
    	this.patient=patient;
    }
    public Medecin getMedecin() {
    	return this.medecin;
    }
    public void setMedecin(Medecin medecin) {
    	this.medecin=medecin;
    }
    @Override
    public String toString() {
        return "Consultation{" +
                "idConsultation=" + id +
                ", patient=" + patient.toString() +
                ", medecin=" + medecin.toString() +
                '}';
    }
}