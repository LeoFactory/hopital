package leo.labatut.projet.model;

import java.util.Date;

public class SuperAdmin extends Personnel {

    public SuperAdmin(int id,String nom, String prenom, Date dateNaissance,char sexe,String email) {
        super (id, nom,prenom,dateNaissance, sexe,email);
    }

}