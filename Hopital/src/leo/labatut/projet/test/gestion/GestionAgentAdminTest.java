package leo.labatut.projet.test.gestion;

import leo.labatut.projet.gestion.GestionAgentAdmin;
import leo.labatut.projet.model.AgentAdmin;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestionAgentAdminTest {

    @Test
    void testGestionAgAdmin(){
        AgentAdmin agAdmin1 = new AgentAdmin("Berenard","Bob");
        AgentAdmin agAdmin2 = new AgentAdmin("Meunier","Daniel");
        AgentAdmin agAdmin3 = new AgentAdmin("Lefoulc","Fernand");

        AgentAdmin[]tabAg =new AgentAdmin[3];
        tabAg[0]=agAdmin1;
        tabAg[1]=agAdmin2;
        tabAg[2]=agAdmin3;

        GestionAgentAdmin gestionAgentAdmin= new GestionAgentAdmin();

        ArrayList<AgentAdmin> listeAg = gestionAgentAdmin.getListe();

        gestionAgentAdmin.ajoutez(agAdmin1);
        gestionAgentAdmin.ajoutez(agAdmin2);
        gestionAgentAdmin.ajoutez(agAdmin3);

        for(int i = 0;i<listeAg.size();i++){
            assertEquals(tabAg[i],listeAg.get(i));
        }
    }

}