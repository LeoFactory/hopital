package leo.labatut.projet.test.gestion;

import leo.labatut.projet.gestion.GestionPatient;
import leo.labatut.projet.model.Patient;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GestionPatientTest {

    @Test
    void testGestionPatient() {

        Patient patient1 = new Patient("Gérard","Corentin",new Date());
        Patient patient2 = new Patient("Ronaldo","Christiano",new Date());
        Patient patient3 = new Patient("Richard","Paul",new Date());

        Patient[] tab = new Patient[3];
        tab[0] = patient1;
        tab[1] = patient2;
        tab[2] = patient3;

        GestionPatient gestion = new GestionPatient();

        ArrayList<Patient> liste = gestion.getListe();

        gestion.ajoutez(patient1);
        gestion.ajoutez(patient2);
        gestion.ajoutez(patient3);

        for (int i = 0; i < liste.size(); i++) {
            assertEquals(tab[i], liste.get(i));
        }
    }

}