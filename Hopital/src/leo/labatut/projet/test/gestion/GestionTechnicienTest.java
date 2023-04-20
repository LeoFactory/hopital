package leo.labatut.projet.test.gestion;

import leo.labatut.projet.gestion.GestionTechnicien;
import leo.labatut.projet.model.Technicien;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestionTechnicienTest {

    @Test
    void testGestionTechnicien() {

        Technicien technicien1 = new Technicien("Gérard","Corentin");
        Technicien technicien2 = new Technicien("Richard","Barnabé");
        Technicien technicien3 = new Technicien("Dupont","Gisèle");

        Technicien[] tab = new Technicien[3];
        tab[0] = technicien1;
        tab[1] = technicien2;
        tab[2] = technicien3;

        GestionTechnicien gestion = new GestionTechnicien();

        ArrayList<Technicien> liste = gestion.getListe();

        gestion.ajoutez(technicien1);
        gestion.ajoutez(technicien2);
        gestion.ajoutez(technicien3);

        for (int i = 0; i < liste.size(); i++) {
            assertEquals(tab[i], liste.get(i));
        }
    }

}