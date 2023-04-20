package leo.labatut.projet.test.gestion;

import leo.labatut.projet.gestion.GestionConsultation;
import leo.labatut.projet.model.Consultation;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Patient;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GestionConsultationTest {

    @Test
    void testGestionConsultation() {
        Patient patient1 = new Patient("Georges","Richard", new Date());
        Patient patient2 = new Patient("Nicolas","Joris", new Date());

        Medecin medecin1 =new Medecin("Barnabé", "Paul");
        Medecin medecin2 =new Medecin("Martin", "John");

        Consultation consultation1 =new Consultation(patient1, medecin1);
        Consultation consultation2=new Consultation(patient1, medecin2);
        Consultation consultation3 =new Consultation(patient2, medecin1);

        Consultation[] tabConsultation = new Consultation[3];
        tabConsultation[0] = consultation1;
        tabConsultation[1] = consultation2;
        tabConsultation[2] = consultation3;

        GestionConsultation gestionConsultation = new GestionConsultation();

        ArrayList<Consultation> listeConsultation = gestionConsultation.getListe();

        gestionConsultation.ajoutez(consultation1);
        gestionConsultation.ajoutez(consultation2);
        gestionConsultation.ajoutez(consultation3);

        for (int i = 0; i < listeConsultation.size(); i++) {
            assertEquals(tabConsultation[i], listeConsultation.get(i));
        }
    }

}