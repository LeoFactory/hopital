package trucs;



import java.util.Date;

import javax.swing.JFrame;


import leo.labatut.projet.model.AgentAdmin;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Patient;
import leo.labatut.projet.model.Service;
import leo.labatut.projet.dao.*;

import trucs.LoginView;
import trucs.LoginViewController;
import leo.labatut.projet.controller.*;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.Calendar;

public class Main {
    public static void main(String[]args){
    	/*
    	String url="jdbc:mysql://localhost/hopitalbd";
		String login="root";
		String password="";
		Connection connection = SingleConnection.getInstance(url, login, password);
		*/
		LoginView view = new LoginView();
		LoginViewController controller = new LoginViewController(view);
        
		
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setVisible(true);
        

    }
}
