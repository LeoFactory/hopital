


import java.util.Date;



import javax.swing.JFrame;
import javax.swing.JOptionPane;

import leo.labatut.projet.model.AgentAdmin;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Patient;
import leo.labatut.projet.model.Service;
import leo.labatut.projet.dao.*;
import leo.labatut.projet.view.*;
import leo.labatut.projet.controller.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {
	/**
	 * point d'entrée
	 * permet de lancer l'application
	 * @param args
	 */
	
    public static void main(String[]args){
    	
    	Login login = new Login();
    	
    	LoginController loginCtrlr= new LoginController(login);
    	    	
       			    
    }
   
}
