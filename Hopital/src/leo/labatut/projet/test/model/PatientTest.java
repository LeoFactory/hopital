package leo.labatut.projet.test.model;

import leo.labatut.projet.model.Patient;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void getNom() {
        Calendar c1 = Calendar.getInstance();
        Patient p1 =new Patient("Richard","Georges",c1.getTime());
        assertEquals(p1.getNom(),"Richard");
    }

    @Test
    void getPrenom() {
        Calendar c1 = Calendar.getInstance();
        Patient p1 =new Patient("Richard","Georges",c1.getTime());
        assertEquals(p1.getPrenom(),"Georges");
    }

    @Test
    void getDateCreation() {
        Calendar c1 = Calendar.getInstance();
        Patient p1 =new Patient("Richard","Georges",c1.getTime());
        assertEquals(p1.getDateCreation(),c1.getTime());
    }

    @Test
    void getIdPatient() {
        Calendar c1 = Calendar.getInstance();
        Patient p1 =new Patient("Richard","Georges",c1.getTime());
        Patient p2 =new Patient("Richard","Georges",c1.getTime());
        Patient p3 =new Patient("Richard","Georges",c1.getTime());
        assertEquals(p1.getIdPatient(),0);
        assertEquals(p2.getIdPatient(),1);
        assertEquals(p3.getIdPatient(),2);
    }

    @Test
    void setNom() {
        Calendar c1 = Calendar.getInstance();
        Patient p1 =new Patient("Richard","Georges",c1.getTime());
        p1.setNom("Barnabé");
        assertEquals(p1.getNom(),"Barnabé");
    }

    @Test
    void setDateCreation() {
        Calendar c1 = Calendar.getInstance();
        Date date = new Date();
        Patient p1 =new Patient("Richard","Georges",c1.getTime());
        p1.setDateCreation(date);
        assertEquals(p1.getDateCreation(),date);
    }

    @Test
    void setPrenom() {
        Calendar c1 = Calendar.getInstance();
        Patient p1 =new Patient("Richard","Georges",c1.getTime());
        p1.setPrenom("Barnabé");
        assertEquals(p1.getPrenom(),"Barnabé");
    }
    @Test
    void getNbPatient(){
        Calendar c1 = Calendar.getInstance();
        Patient p1 =new Patient("Richard","Georges",c1.getTime());
        assertEquals(1,p1.getIdPatient());

    }
}