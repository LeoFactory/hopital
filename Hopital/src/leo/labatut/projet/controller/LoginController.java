package leo.labatut.projet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import leo.labatut.projet.controller.*;
import leo.labatut.projet.dao.*;
import leo.labatut.projet.view.*;
import leo.labatut.projet.dao.SingleConnection;

import leo.labatut.projet.view.Login;

public class LoginController {
	
	private  Login login= new Login();
	
	
	public LoginController(Login login) {
		this.login=login;
		this.login.submitListener(new SubmitListener());
		
		this.login.setVisible(true);
		
	}
class SubmitListener implements ActionListener{
		
		private String url="jdbc:mysql://localhost/hopitalbd";
		private String user="root";
		private String password="";
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Connection cn = SingleConnection.getInstance(url, user, password);
			
			PreparedStatement st;
			
			if(login.getBox().getSelectedItem()=="SuperAdmin") {
				try {
					st = (PreparedStatement) cn.prepareStatement("SELECT nom, mdp FROM super_admin WHERE nom=? AND mdp=?");
					st.setString(1, login.getLogin().getText());
					st.setString(2, login.getPassword().getText());
	            
					ResultSet rs = st.executeQuery();
	                
	                
					if (rs.next()) {
						MedecinView view = new MedecinView();
						MedecinDAO dao = new MedecinDAO(cn);
						MedecinController medecinCtrlr = new MedecinController(dao,view);
						login.setVisible(false);
						view.setVisible(true);
					} else {
	                    JOptionPane.showMessageDialog(login, "Wrong Username & Password");
					}
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}else if(login.getBox().getSelectedItem()=="Medecin") {
				try {
					st = (PreparedStatement) cn.prepareStatement("SELECT nom, mdp FROM medecin WHERE nom=? AND mdp=?");
					st.setString(1, login.getLogin().getText());
					st.setString(2, login.getPassword().getText());
	            
					ResultSet rs = st.executeQuery();
	                
	                
					if (rs.next()) {
						PatientView view = new PatientView();
						
						login.setVisible(false);
						view.setVisible(true);
					} else {
	                    JOptionPane.showMessageDialog(login, "Wrong Username & Password");
					}
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}
			
		}
		
	}
}
