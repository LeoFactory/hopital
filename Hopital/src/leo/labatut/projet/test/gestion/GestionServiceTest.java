package leo.labatut.projet.test.gestion;

import leo.labatut.projet.gestion.GestionService;
import leo.labatut.projet.model.Service;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestionServiceTest {

    @Test
    void testGestionService() {

        Service service1 = new Service("Urgences");
        Service service2 = new Service("Psychiatrie");
        Service service3 = new Service("Chirurgie");

        Service[] tab = new Service[3];
        tab[0] = service1;
        tab[1] = service2;
        tab[2] = service3;


        GestionService gestion = new GestionService();

        ArrayList<Service> liste = gestion.getListe();

        gestion.ajoutez(service1);
        gestion.ajoutez(service2);
        gestion.ajoutez(service3);

        for (int i = 0; i < liste.size(); i++) {
            assertEquals(tab[i], liste.get(i));
        }
    }

}