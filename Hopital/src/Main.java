

import leo.labatut.projet.gestion.GestionAgentAdmin;

import leo.labatut.projet.gestion.GestionMedecin;
import leo.labatut.projet.gestion.GestionPatient;
import leo.labatut.projet.model.AgentAdmin;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Patient;
import leo.labatut.projet.model.Service;

import leo.labatut.projet.dao.*;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.Calendar;

public class Main {
    public static void main(String[]args){
    	
    	String url="jdbc:mysql://localhost/hopitalbd";
		String login="root";
		String password="";

        Calendar c1= Calendar.getInstance();
        
        boolean bool;
        	
        AgentAdmin agent1=new AgentAdmin(1,"Carlos","Gisèle");
        
        
        Connection connection = SingleConnection.getInstance(url, login, password);
        AgentAdminDAO dao = new AgentAdminDAO(connection);
        
        
        agent1 = dao.find(1);
        System.out.println(agent1.toString());
        
        bool = dao.delete(agent1);

    }
}
