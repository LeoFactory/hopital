


import java.util.Date;


import javax.swing.JFrame;


import leo.labatut.projet.model.AgentAdmin;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Patient;
import leo.labatut.projet.model.Service;
import leo.labatut.projet.dao.*;
import leo.labatut.projet.view.*;
import leo.labatut.projet.controller.*;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.Calendar;

public class Main {
    public static void main(String[]args){
    	
    	String url="jdbc:mysql://localhost/hopitalbd";
		String login="root";
		String password="";
		Connection cn = SingleConnection.getInstance(url, login, password);
		
    	MedecinView view= new MedecinView();
    	MedecinDAO dao = new MedecinDAO(cn);
    	
        MedecinController medecinCtrlr =new MedecinController(dao,view);

		view.setVisible(true);
		    
    }
}
