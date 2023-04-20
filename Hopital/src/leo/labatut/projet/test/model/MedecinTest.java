package leo.labatut.projet.test.model;

import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Service;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedecinTest {


    @Test
    void getIdMedecin() {
        Service service = new Service("Urgences");
        Medecin medecin = new Medecin("Paul","Richard",service);
        assertEquals(0,medecin.getIdMedecin());
    }

    @Test
    void getNbMedecin() {
        Service service = new Service("Urgences");
        Medecin medecin = new Medecin("Paul","Richard",service);
        assertEquals(1,medecin.getNbMedecin());
    }

    @Test
    void getService() {
        Service service = new Service("Urgences");
        Medecin medecin = new Medecin("Paul","Richard",service);
        assertEquals(service,medecin.getService());
    }

    @Test
    void setService() {
    }
}