package leo.labatut.projet.test.model;

import leo.labatut.projet.model.Appareil;
import leo.labatut.projet.model.Consultation;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Pathologie;
import leo.labatut.projet.model.Patient;
import leo.labatut.projet.model.Service;
import leo.labatut.projet.model.Suivi;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ConsultationTest {

    @Test
    void getIdConsultation() {
        Suivi suivi = new Suivi(1,new Patient(1,"Paul","Bertrand",new Date(),new Date(),'M',"kijdsq@kjdsfh.com"),new Pathologie(1,"grippe"), new Medecin());
        Appareil appareil = new Appareil(1,"lunettes");

        Consultation consultation = new Consultation( 1, suivi,new Date(), appareil, "instance");
        
        assertEquals(1,consultation.getId());
        assertSame(suivi,consultation.getSuivi());
        assertSame(appareil,consultation.getAppareil());
        assertEquals("instance",consultation.getStatutAppareil());
    }

}