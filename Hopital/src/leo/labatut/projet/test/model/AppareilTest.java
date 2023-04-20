package leo.labatut.projet.test.model;

import leo.labatut.projet.model.Appareil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppareilTest {



    @Test
    void getLibelle() {
        Appareil app = new Appareil("Sonotone");
        assertEquals("Sonotone",app.getLibelle());
    }

    @Test
    void setLibelle() {
        Appareil app = new Appareil("Sonotone");
        app.setLibelle("Béquille");
        assertEquals("Béquille",app.getLibelle());
    }
    @Test
    void getIdAppareil() {
        Appareil app = new Appareil("Sonotone");
        assertEquals(app.getIdAppareil(),0);
    }

    @Test
    void getNbAppareils() {
        Appareil app = new Appareil("Sonotone");
        assertEquals(app.getNbAppareils(),1);
    }
}