package leo.labatut.projet.test.model;

import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Service;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

class MedecinTest {


    @Test
    void getIdMedecin() {
        Service service = new Service(1,"Urgences");
        Date naissance = new Date();
        Medecin medecin = new Medecin(1,"Paul","Richard",naissance,'M',service,"kjqhsd@yahoo.com");
        assertEquals(1,medecin.getId());
    }
 

    @Test
    void getService() {
    	Service service = new Service(1,"Urgences");
        Date naissance = new Date();
        Medecin medecin = new Medecin(1,"Paul","Richard",naissance,'M',service,"kjqhsd@yahoo.com");
        assertSame(service,medecin.getService());
    }

    @Test
    void setService() {
    	Service service = new Service(1,"Urgences");
    	Service service2 = new Service(2,"pas urgent");
        Date naissance = new Date();
        Medecin medecin = new Medecin(1,"Paul","Richard",naissance,'M',service,"kjqhsd@yahoo.com");
        medecin.setService(service2);
        assertSame(service2,medecin.getService());
    }
}