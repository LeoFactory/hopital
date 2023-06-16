package leo.labatut.projet.test.model;

import leo.labatut.projet.model.Appareil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppareilTest {



    @Test
    void getLibelle() {
        Appareil app = new Appareil(1,"Sonotone");
        assertEquals("Sonotone",app.getLibelle());
    }

    @Test
    void setLibelle() {
        Appareil app = new Appareil(1,"Sonotone");
        app.setLibelle("Béquille");
        assertEquals("Béquille",app.getLibelle());
    }
    @Test
    void getIdAppareil() {
        Appareil app = new Appareil(1,"Sonotone");
        assertEquals(1,app.getId());
    }
}