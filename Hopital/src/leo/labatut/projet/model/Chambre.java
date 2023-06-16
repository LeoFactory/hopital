package leo.labatut.projet.model;

public class Chambre {
	private int id;
	private int nbPatients;
	private int capacite;
	private Service service;
	private Infirmier infirmier;
	/**
	 * constructeur
	 * @param capacite
	 * @param service
	 */
	public Chambre(int capacite, Service service) {
		this.capacite=capacite;
		this.service=service;
	}
	/**
	 * constructeur 2
	 * @param capacite
	 * @param service
	 */
	public Chambre (int id , int capacite,Service service) {
		this.id = id ;
		this.capacite= capacite;
		this.service= service;
		
	}
	/**
	 * constructeur 3
	 * @param capacite
	 * @param service
	 */
	public Chambre (int id , int capacite,Service service, int nbPatients) {
		this.id = id ;
		this.capacite= capacite;
		this.service= service;
		this.nbPatients=nbPatients;
		
	}
	/**
	 * constructeur 4
	 * @param capacite
	 * @param service
	 */
	public Chambre (int id , int capacite,Service service, int nbPatients, Infirmier infirmier) {
		this.id = id ;
		this.capacite= capacite;
		this.service= service;
		this.nbPatients=nbPatients;
		this.infirmier=infirmier;
	}
	/**
	 * ajoute un patient à la chambre
	 * @param patient
	 * @return
	 */
	public boolean ajoutPatient(Patient patient) {
		if(this.nbPatients<this.capacite) {
			nbPatients++;
			patient.setChambre(this);
			return true;
		}else {
			return false;
		}
	}
	/*
	 * getters / setters
	 */
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getCapacite() {
		return this.capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite=capacite;
	}
	public int getNbPatient() {
		return this.nbPatients;
	}
	public void setNbPatient(int nbPatient) {
		this.nbPatients=nbPatient;
	}
	public Service getService() {
		return this.service;
	}
	public void setService(Service service) {
		this.service=service;
	}
	public Infirmier getInfirmier() {
		return this.infirmier;
	}
	public void setInfirmier(Infirmier infirmier) {
		this.infirmier=infirmier;
	}
	public String toString() {
		return "\nId = "+ id+
				"\nService = "+service.getNom()+
				"\nInfirmier ="+ infirmier.getNom()+" "+infirmier.getPrenom();
				
	}
}

