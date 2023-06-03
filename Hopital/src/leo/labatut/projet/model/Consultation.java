package leo.labatut.projet.model;

import java.util.Date;

public class Consultation {
    
    private int id;
    private Suivi suivi;
    private Date date;
    private Ordonnance ordonnance;
    
    public Consultation(Suivi suivi, Date date) {
    	this.date=date;
         this.suivi=suivi;
    }
    
    public Consultation(int id, Suivi suivi,Date date) {
        
        this.id=id;
        this.date=date;
        this.suivi=suivi;

    }
    public Consultation(int id, Suivi suivi, Date date, Ordonnance ordonnance) {
        
        this.id=id;
        this.date=date;
        this.suivi=suivi;
        this.ordonnance=ordonnance;

    }
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
    public Ordonnance getOrdonnance() {
    	return this.ordonnance;
    }
    public void setOrdonnance(Ordonnance ordonnance) {
    	this.ordonnance=ordonnance;
    }
    @Override
    public String toString() {
        return "Consultation{" +
                "idConsultation=" + id +
                "Date = "+this.date+
                '}';
    }
}