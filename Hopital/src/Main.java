

import leo.labatut.projet.gestion.GestionAgentAdmin;
import leo.labatut.projet.gestion.GestionMedecin;
import leo.labatut.projet.gestion.GestionPatient;
import leo.labatut.projet.model.AgentAdmin;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Patient;
import leo.labatut.projet.model.Service;

import java.util.ArrayList;
import java.util.Calendar;

public class Main {
    public static void main(String[]args){
        Calendar c1= Calendar.getInstance();

        AgentAdmin agadmin1 =new AgentAdmin("Breton","Pierre");
        AgentAdmin agadmin2 =new AgentAdmin("Richard","Barnabé");
        AgentAdmin agadmin3 =new AgentAdmin("Rénier","Eustache");

        Service service1 = new Service ("Urgences");

        Medecin medecin1 = new Medecin("Berenard","Bob",service1);
        Medecin medecin2 = new Medecin("Meunier","Daniel",service1);
        Medecin medecin3 = new Medecin("Lefoulc","Fernand",service1);

        Patient patient1 =new Patient("Norbert","Mérédithe",c1.getTime());
        Patient patient2 =new Patient("Leroy","Sébastien",c1.getTime());
        Patient patient3 =new Patient("Leménélec","Robert",c1.getTime());
        Patient patient4 =new Patient("Dru","Charles",c1.getTime());
        Patient patient5 =new Patient("Félon","Nicole",c1.getTime());
        Patient patient6 =new Patient("Ripoli","Benjamin",c1.getTime());

        GestionMedecin gestionMedecin= new GestionMedecin();
        GestionAgentAdmin gestionAgentAdmin = new GestionAgentAdmin();
        GestionPatient gestionPatient =new GestionPatient();

        gestionMedecin.ajoutez(medecin1);
        gestionMedecin.ajoutez(medecin2);
        gestionMedecin.ajoutez(medecin3);

        gestionAgentAdmin.ajoutez(agadmin1);
        gestionAgentAdmin.ajoutez(agadmin2);
        gestionAgentAdmin.ajoutez(agadmin3);

        gestionPatient.ajoutez(patient1);
        gestionPatient.ajoutez(patient2);
        gestionPatient.ajoutez(patient3);
        gestionPatient.ajoutez(patient4);
        gestionPatient.ajoutez(patient5);
        gestionPatient.ajoutez(patient6);

        ArrayList<Medecin>listeMedecin = gestionMedecin.getListe();
        ArrayList<AgentAdmin>listeAgAdmin = gestionAgentAdmin.getListe();
        ArrayList<Patient>listePatient = gestionPatient.getListe();

        for (int i = 0; i<listeMedecin.size();i++){
            System.out.println(listeMedecin.get(i));
        }

        System.out.println();

        for (int i = 0; i<listeAgAdmin.size();i++){
            System.out.println(listeAgAdmin.get(i));
        }
        System.out.println();

        for (int i = 0; i<listePatient.size();i++){
            System.out.println(listePatient.get(i));
        }




    }
}
