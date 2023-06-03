package leo.labatut.projet.controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import leo.labatut.projet.model.*;
import leo.labatut.projet.controller.*;
import leo.labatut.projet.dao.*;
import leo.labatut.projet.view.*;
import leo.labatut.projet.dao.SingleConnection;
import java.util.Date;

import leo.labatut.projet.view.Login;

public class LoginController {
	
	private  Login login= new Login();
	private String url="jdbc:mysql://localhost/hopitalbd";
	private String user="root";
	private String password="";
	private Connection cn = SingleConnection.getInstance(url, user, password);
	
	public LoginController(Login login) {
		this.login=login;
		this.login.submitListener(new SubmitListener());
		
		this.login.setVisible(true);
		
	}
class SubmitListener implements ActionListener{
		
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			PreparedStatement st;
			
			if(login.getBox().getSelectedItem()=="SuperAdmin") {
				try {
					st = (PreparedStatement) cn.prepareStatement("SELECT nom, mdp FROM super_admin WHERE nom=? AND mdp=?");
					st.setString(1, login.getLogin().getText());
					st.setString(2, login.getPassword().getText());
	            
					ResultSet rs = st.executeQuery();
	                
	                
					if (rs.next()) {
						
						InterfaceSuperAdmin view = new InterfaceSuperAdmin();
						ControllerSuperAdmin superAdminCtrl = new ControllerSuperAdmin(cn,view);
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
					st = (PreparedStatement) cn.prepareStatement("SELECT medecin_id, nom, prenom, date_naissance,sexe, service_id,email, mdp FROM medecin WHERE nom=? AND mdp=?");
					st.setString(1, login.getLogin().getText());
					st.setString(2, login.getPassword().getText());
	            
					ResultSet rs = st.executeQuery();
	                
					if (rs.next()) {
						int id = rs.getInt("medecin_id");
						String nom = rs.getString("nom");
						String prenom = rs.getString("prenom");
						Date date = rs.getDate("date_naissance");
						char sexe = rs.getString("sexe").charAt(0);
						int serviceId = rs.getInt("service_id");
						String email = rs.getString("email");
						String mdp = rs.getString("mdp");
						
						ServiceDAO serviceDAO = new ServiceDAO(cn);
						Service service= serviceDAO.find(serviceId);
						Medecin medecin = new Medecin(id, nom, prenom, date, sexe,service, email);
						
						InterfaceMedecin view = new InterfaceMedecin();
						ControllerMedecin medCtrl = new ControllerMedecin(cn,view,medecin);
						
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
	public Connection getConnection() {
		return this.cn;
	}
}
