package leo.labatut.projet.model;

import java.util.Date;

public class Consultation {
    
    private int id;
    private Suivi suivi;
    private Date date;
    private String ordonnance;
    private String soin;
    private Appareil appareil;
    private String statutAppareil;
    /**
     * constructeur
     * @param suivi
     * @param date
     */
    public Consultation(Suivi suivi, Date date) {
    	this.date=date;
         this.suivi=suivi;
    }
    /**
     * constructeur 2
     * @param suivi
     * @param date
     */
    public Consultation(int id, Suivi suivi,Date date) {
        
        this.id=id;
        this.date=date;
        this.suivi=suivi;

    }
    /**
     * constructeur 3
     * @param suivi
     * @param date
     */
    public Consultation(int id, Suivi suivi,Date date,Appareil appareil) {
        
        this.id=id;
        this.date=date;
        this.suivi=suivi;
        this.appareil=appareil;

    }
    /**
     * constructeur 4
     * @param suivi
     * @param date
     */
    public Consultation(int id, Suivi suivi,Date date,Appareil appareil,String statut) {
        
        this.id=id;
        this.date=date;
        this.suivi=suivi;
        this.appareil=appareil;
        this.statutAppareil=statut;
    }
    /**
     * constructeur 5
     * @param suivi
     * @param date
     */
    public Consultation(int id, Suivi suivi, Date date, String ordonnance) {
        
        this.id=id;
        this.date=date;
        this.suivi=suivi;
        this.ordonnance=ordonnance;

    }
    /**
     * constructeur 6
     * @param suivi
     * @param date
     */
    public Consultation(int id, Suivi suivi, Date date, String ordonnance, String soin) {
        
        this.id=id;
        this.date=date;
        this.suivi=suivi;
        this.ordonnance=ordonnance;
        this.soin=soin;

    }
    
    /*
     * getters/setters
     */
    public int getId() {
    	return this.id;
    }
    public void setId(int id) {
    	this.id=id;
    }
    public Date getDate() {
    	return this.date;
    }
    public void setDate(Date date) {
    	this.date=date;
    }
    public Suivi getSuivi() {
    	return this.suivi;
    }
    public void setSuivi(Suivi suivi) {
    	this.suivi=suivi;
    }
    public String getOrdonnance() {
    	return this.ordonnance;
    }
    public void setOrdonnance(String ordonnance) {
    	this.ordonnance=ordonnance;
    }
    public Appareil getAppareil() {
    	return this.appareil;
    }
    public void setAppareil(Appareil appareil) {
    	this.appareil=appareil;
    }
    public String getStatutAppareil() {
    	return this.statutAppareil;
    }
    public void setStatutAppareil(String statut) {
    	this.statutAppareil=statut;
    }
    
    public String getSoin() {
    	return this.soin;
    }
    public void setSoin(String soin) {
    	this.soin=soin;
    }
    @Override
    public String toString() {
        return "Consultation{" +
                "idConsultation=" + id +
                "Date = "+this.date+
                '}';
    }
}