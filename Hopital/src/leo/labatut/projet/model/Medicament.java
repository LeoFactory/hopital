package leo.labatut.projet.model;

public class Medicament {
	
	private int id;
	private String libelle;
	private int qte;
	
	public Medicament(String libelle, int qte) {
		this.libelle=libelle;
		this.qte=qte;
	}
	public Medicament(int id , String libelle, int qte) {
		this.id=id;
		this.libelle=libelle;
		this.qte=qte;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getLibelle() {
		return this.libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle=libelle;
	}
}
