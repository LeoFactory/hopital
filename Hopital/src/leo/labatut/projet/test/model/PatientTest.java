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
        Date naissance = new Date();
        Patient p1 =new Patient(1,"Richard","Georges",c1.getTime(),naissance,'M',"kjhsqd@hotmail.com");
        assertEquals(p1.getNom(),"Richard");
    }

    @Test
    void getPrenom() {
        Calendar c1 = Calendar.getInstance();
        Date naissance = new Date();
        Patient p1 =new Patient(1,"Richard","Georges",c1.getTime(),naissance,'M',"kjhsqd@hotmail.com");
        assertEquals(p1.getPrenom(),"Georges");
    }

    @Test
    void getDateCreation() {
        Calendar c1 = Calendar.getInstance();
        Date naissance = new Date();
        Patient p1 =new Patient(1,"Richard","Georges",c1.getTime(),naissance,'M',"kjhsqd@hotmail.com");
        assertEquals(p1.getDateCreation(),c1.getTime());
    }

    @Test
    void getIdPatient() {
        Calendar c1 = Calendar.getInstance();
        Date naissance = new Date();
        Date naissance2 = new Date();
        Date naissance3 = new Date();
        Patient p1 =new Patient(0,"Richard","Georges",c1.getTime(),naissance,'M',"kjhsqd@hotmail.com");
        Patient p2 =new Patient(1,"Richard","Georges",c1.getTime(),naissance2,'M',"tytuu@hotmail.com");
        Patient p3 =new Patient(2,"Richard","Georges",c1.getTime(),naissance3,'M',"1234@hotmail.com");
        assertEquals(p1.getId(),0);
        assertEquals(p2.getId(),1);
        assertEquals(p3.getId(),2);
    }

    @Test
    void setNom() {
        Calendar c1 = Calendar.getInstance();
        Date naissance = new Date();
        Patient p1 =new Patient(0,"Richard","Georges",c1.getTime(),naissance,'M',"kjhsqd@hotmail.com");
        p1.setNom("Barnabé");
        assertEquals(p1.getNom(),"Barnabé");
    }

    @Test
    void setDateCreation() {
        Calendar c1 = Calendar.getInstance();
        Date naissance = new Date();
        Date date = new Date();
        Patient p1 =new Patient(0,"Richard","Georges",c1.getTime(),naissance,'M',"kjhsqd@hotmail.com");
        p1.setDateCreation(date);
        assertEquals(p1.getDateCreation(),date);
    }

    @Test
    void setPrenom() {
        Calendar c1 = Calendar.getInstance();
        Date naissance = new Date();
        Patient p1 =new Patient(0,"Richard","Georges",c1.getTime(),naissance,'M',"kjhsqd@hotmail.com");
        p1.setPrenom("Barnabé");
        assertEquals(p1.getPrenom(),"Barnabé");
    }
    
}