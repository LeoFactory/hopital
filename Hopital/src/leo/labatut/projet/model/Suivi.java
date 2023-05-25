package leo.labatut.projet.model;

public class Suivi {
	
	private int id;
	private Patient patient;
	private Pathologie pathologie;
	private Medecin medecin;
	
	
	
	public Suivi(Patient patient, Pathologie pathologie, Medecin medecin) {
		this.patient=patient;
		this.pathologie=pathologie;
		this.medecin=medecin;
	}
	public Suivi(int id,Patient patient, Pathologie pathologie, Medecin medecin) {
		this.id=id;
		this.patient=patient;
		this.pathologie=pathologie;
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
	public Pathologie getPathologie() {
		return this.pathologie;
	}
	public void setPathologie(Pathologie pathologie) {
		this.pathologie=pathologie;
	}
	public Medecin getMedecin() {
		return this.medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin=medecin;
	}
}

