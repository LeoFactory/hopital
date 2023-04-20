package leo.labatut.projet.test.model;

import leo.labatut.projet.model.AgentAdmin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AgentAdminTest {

    String nom ="Lelouche";
    String prenom ="Jean";
    AgentAdmin agAdmin = new AgentAdmin(nom,prenom);

    @Test
    void getNom() {
        assertEquals(nom,agAdmin.getNom());
    }
    @Test
    void getPrenom(){
        assertEquals(prenom,agAdmin.getPrenom());
        }
    }
