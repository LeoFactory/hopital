package leo.labatut.projet.test.gestion;

import leo.labatut.projet.gestion.GestionMedecin;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Service;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestionMedecinTest {
    @Test
    void testGestionMedecin(){Service service1 = new Service ("Urgences");
        Medecin medecin1 = new Medecin("Berenard","Bob",service1);
        Medecin medecin2 = new Medecin("Meunier","Daniel",service1);
        Medecin medecin3 = new Medecin("Lefoulc","Fernand",service1);

        Medecin[]tabMedecin =new Medecin[3];
        tabMedecin[0]=medecin1;
        tabMedecin[1]=medecin2;
        tabMedecin[2]=medecin3;

        GestionMedecin gestionMedecin= new GestionMedecin();

        ArrayList<Medecin> listeMedecin = gestionMedecin.getListe();

        gestionMedecin.ajoutez(medecin1);
        gestionMedecin.ajoutez(medecin2);
        gestionMedecin.ajoutez(medecin3);

        for(int i = 0;i<listeMedecin.size();i++){
            assertEquals(tabMedecin[i],listeMedecin.get(i));
        }



    }



}