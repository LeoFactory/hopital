package leo.labatut.projet.test.gestion;

import leo.labatut.projet.gestion.GestionAppareil;
import leo.labatut.projet.model.Appareil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestionAppareilTest {

    @Test
    void testGestionAppareil() {

        Appareil app1 = new Appareil("Bidule1");
        Appareil app2 = new Appareil("Bidule2");
        Appareil app3 = new Appareil("Bidule3");

        Appareil[] tabAppareil = new Appareil[3];
        tabAppareil[0] = app1;
        tabAppareil[1] = app2;
        tabAppareil[2] = app3;

        GestionAppareil gestionAppareil = new GestionAppareil();

        ArrayList<Appareil> listeAppareil = gestionAppareil.getListe();

        gestionAppareil.ajoutez(app1);
        gestionAppareil.ajoutez(app2);
        gestionAppareil.ajoutez(app3);

        for (int i = 0; i < listeAppareil.size(); i++) {
            assertEquals(tabAppareil[i], listeAppareil.get(i));
        }
    }

}