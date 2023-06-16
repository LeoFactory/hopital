package leo.labatut.projet.test.model;

import leo.labatut.projet.model.AgentAdmin;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AgentAdminTest {
	
	Date date =Calendar.getInstance().getTime();

    String nom ="Lelouche";
    String prenom ="Jean";
    AgentAdmin agAdmin = new AgentAdmin(1,nom,prenom,date,'M',"leloucheJean@yahoo.fr" );

    @Test
    void getNom() {
        assertEquals(nom,agAdmin.getNom());
    }
    @Test
    void getPrenom(){
        assertEquals(prenom,agAdmin.getPrenom());
        }
    }
