package leo.labatut.projet.model;

public class Consultation {
    private static int nbConsultation;
    private int idConsultation;
    private Patient patient;
    private Medecin medecin;
    public Consultation(Patient patient, Medecin medecin) {
        this.idConsultation=nbConsultation;
        nbConsultation++;
        this.patient=patient;
        this.medecin=medecin;

    }

    public int getIdConsultation() {
        return idConsultation;
    }

    public int getNbConsultation() {
        return nbConsultation;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "idConsultation=" + idConsultation +
                ", patient=" + patient.toString() +
                ", medecin=" + medecin.toString() +
                '}';
    }
}