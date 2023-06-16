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
	/**
	 * constructeur
	 * @param login
	 */
	public LoginController(Login login) {
		this.login=login;
		this.login.submitListener(new SubmitListener());
		
		this.login.setVisible(true);
		
	}
	/**
	 * dirige l'utilisateur vers l'interface approprié en fonction des informations de connection fournies
	 * @author User
	 *
	 */
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
			}else if(login.getBox().getSelectedItem()=="Technicien") {
				try {
					st = (PreparedStatement) cn.prepareStatement("SELECT technicien_id, nom, prenom, date_naissance,sexe,email, mdp FROM technicien WHERE nom=? AND mdp=?");
					st.setString(1, login.getLogin().getText());
					st.setString(2, login.getPassword().getText());
	            
					ResultSet rs = st.executeQuery();
	                
					if (rs.next()) {
						int id = rs.getInt("technicien_id");
						String nom = rs.getString("nom");
						String prenom = rs.getString("prenom");
						Date date = rs.getDate("date_naissance");
						char sexe = rs.getString("sexe").charAt(0);
						String email = rs.getString("email");
						String mdp = rs.getString("mdp");
						
						
						Technicien technicien = new Technicien(id, nom, prenom, date, sexe, email);
						
						InterfaceTechnicien view = new InterfaceTechnicien();
						ControllerTechnicien techCtrl = new ControllerTechnicien(cn,view,technicien);
						
						login.setVisible(false);
						view.setVisible(true);
					} else {
	                    JOptionPane.showMessageDialog(login, "Wrong Username & Password");
					}
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}else if(login.getBox().getSelectedItem()=="Agent d'administration") {
				try {
					st = (PreparedStatement) cn.prepareStatement("SELECT agent_admin_id, nom, prenom, date_naissance,sexe,email, mdp FROM agent_admin WHERE nom=? AND mdp=?");
					st.setString(1, login.getLogin().getText());
					st.setString(2, login.getPassword().getText());
	            
					ResultSet rs = st.executeQuery();
	                
					if (rs.next()) {
						int id = rs.getInt("agent_admin_id");
						String nom = rs.getString("nom");
						String prenom = rs.getString("prenom");
						Date date = rs.getDate("date_naissance");
						char sexe = rs.getString("sexe").charAt(0);
						String email = rs.getString("email");
						String mdp = rs.getString("mdp");
						
						
						AgentAdmin agAdmin = new AgentAdmin(id, nom, prenom, date, sexe, email);
						
						InterfaceAgAdmin view = new InterfaceAgAdmin();
						ControllerAgAdmin techCtrl = new ControllerAgAdmin(cn,view,agAdmin);
						
						login.setVisible(false);
						view.setVisible(true);
					} else {
	                    JOptionPane.showMessageDialog(login, "Wrong Username & Password");
					}
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}else if(login.getBox().getSelectedItem()=="Infirmier") {
				
				try {
					st = (PreparedStatement) cn.prepareStatement("SELECT infirmier_id, nom, prenom, date_naissance,sexe,email, mdp FROM infirmier WHERE nom=? AND mdp=?");
					st.setString(1, login.getLogin().getText());
					st.setString(2, login.getPassword().getText());
	            
					ResultSet rs = st.executeQuery();
	                
					if (rs.next()) {
						int id = rs.getInt("infirmier_id");
						String nom = rs.getString("nom");
						String prenom = rs.getString("prenom");
						Date date = rs.getDate("date_naissance");
						char sexe = rs.getString("sexe").charAt(0);
						String email = rs.getString("email");
						String mdp = rs.getString("mdp");
						
						
						Infirmier infirmier = new Infirmier(id, nom, prenom, date, sexe, email);
						
						InterfaceInfirmier view = new InterfaceInfirmier();
						ControllerInfirmier infirmierCtrl = new ControllerInfirmier(cn,view,infirmier);
						
						login.setVisible(false);
						view.setVisible(true);
					} else {
	                    JOptionPane.showMessageDialog(login, "Wrong Username & Password");
					}
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
				
			}else if(login.getBox().getSelectedItem()=="Invités") {
			
				
				InterfaceInvite view = new InterfaceInvite();
				ControllerInvite inviteCtrl = new ControllerInvite(cn,view);
				
				login.setVisible(false);
				view.setVisible(true);
			}
		}
		
	}
	/**
	 * retourne le singleton connection
	 * @return
	 */
	public Connection getConnection() {
		return this.cn;
	}
}
