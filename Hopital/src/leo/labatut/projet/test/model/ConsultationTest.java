package leo.labatut.projet.test.model;

import leo.labatut.projet.model.Consultation;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Patient;
import leo.labatut.projet.model.Service;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ConsultationTest {

    @Test
    void getIdConsultation() {
        Service service =new Service("Urgences");
        Patient patient =new Patient("Georges","Barnabé",new Date());
        Medecin medecin = new Medecin("Richard","Paul", service);

        Consultation consultation = new Consultation( patient, medecin);
        assertEquals(0,consultation.getIdConsultation());
    }

    @Test
    void getNbConsultation() {
        Service service =new Service("Urgences");
        Patient patient =new Patient("Georges","Barnabé",new Date());
        Medecin medecin = new Medecin("Richard","Paul", service);

        Consultation consultation = new Consultation( patient, medecin);
        assertEquals(consultation.getNbConsultation(),1);
    }
}