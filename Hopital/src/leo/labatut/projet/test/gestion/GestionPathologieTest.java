package leo.labatut.projet.test.gestion;

import leo.labatut.projet.gestion.GestionPathologie;
import leo.labatut.projet.model.Pathologie;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestionPathologieTest {
    @Test
    void testGestionAppareil() {

        Pathologie pathologie1 = new Pathologie("Maladie grave");
        Pathologie pathologie2 = new Pathologie("Maladie Super grave");
        Pathologie pathologie3 = new Pathologie("Maladie OK tranquille");

        Pathologie[] tab = new Pathologie[3];
        tab[0] = pathologie1;
        tab[1] = pathologie2;
        tab[2] = pathologie3;

        GestionPathologie gestion = new GestionPathologie();

        ArrayList<Pathologie> liste = gestion.getListe();

        gestion.ajoutez(pathologie1);
        gestion.ajoutez(pathologie2);
        gestion.ajoutez(pathologie3);

        for (int i = 0; i < liste.size(); i++) {
            assertEquals(tab[i], liste.get(i));
        }
    }

}