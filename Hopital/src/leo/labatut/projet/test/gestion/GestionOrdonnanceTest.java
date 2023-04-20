package leo.labatut.projet.test.gestion;

import leo.labatut.projet.gestion.GestionOrdonnance;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Ordonnance;
import leo.labatut.projet.model.Patient;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GestionOrdonnanceTest {

    @Test
    void testGestionOrdonnace() {
        Patient patient1 = new Patient("Georges","Richard", new Date());
        Patient patient2 = new Patient("Nicolas","Joris", new Date());

        Medecin medecin1 =new Medecin("Barnabé", "Paul");
        Medecin medecin2 =new Medecin("Martin", "John");

        Ordonnance ordonnance1 = new Ordonnance(patient1,medecin1);
        Ordonnance ordonnance2 = new Ordonnance(patient1,medecin2);
        Ordonnance ordonnance3 = new Ordonnance(patient2,medecin1);

        Ordonnance[] tabOrdonnance = new Ordonnance[3];
        tabOrdonnance[0] = ordonnance1;
        tabOrdonnance[1] = ordonnance2;
        tabOrdonnance[2] = ordonnance3;

        GestionOrdonnance gestionOrdonnance = new GestionOrdonnance();

        ArrayList<Ordonnance> listeOrdonnance = gestionOrdonnance.getListe();

        gestionOrdonnance.ajoutez(ordonnance1);
        gestionOrdonnance.ajoutez(ordonnance2);
        gestionOrdonnance.ajoutez(ordonnance3);

        for (int i = 0; i < listeOrdonnance.size(); i++) {
            assertEquals(tabOrdonnance[i], listeOrdonnance.get(i));
        }
    }

}