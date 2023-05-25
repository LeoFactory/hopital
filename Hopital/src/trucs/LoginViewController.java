package trucs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JOptionPane;

import leo.labatut.projet.dao.SingleConnection;
import leo.labatut.projet.view.*;

public class LoginViewController {
	
	private LoginView loginView;
	
	
	public LoginViewController(LoginView loginView) {
		this.loginView=loginView;
		this.loginView.submitListener(new SubmitListener());
		
	}
	
	class SubmitListener implements ActionListener{
		
		private String url="jdbc:mysql://localhost/hopitalbd";
		private String login="root";
		private String password="";
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Connection connection = SingleConnection.getInstance(url, login, password);
			
			PreparedStatement st;
			
			if(loginView.getBox().getSelectedItem()=="SuperAdmin") {
				try {
					st = (PreparedStatement) connection.prepareStatement("SELECT nom, mdp FROM super_admin WHERE nom=? AND mdp=?");
					st.setString(1, loginView.getLogin().getText());
					st.setString(2, loginView.getPassword().getText());
	            
					ResultSet rs = st.executeQuery();
	                
	                
					if (rs.next()) {
						loginView.setSuperView( new SuperAdminViewFail()); 
						loginView.getSuperView().setTitle("Welcome");
						loginView.getSuperView().setVisible(true);
	                	loginView.setVisible(false);
	                    JOptionPane.showMessageDialog(loginView.getSuperView().getTxt(),"SuperAdmin success");
					} else {
	                    JOptionPane.showMessageDialog(loginView, "Wrong Username & Password");
					}
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}else if(loginView.getBox().getSelectedItem()=="Medecin") {
				try {
					st = (PreparedStatement) connection.prepareStatement("SELECT nom, mdp FROM medecin WHERE nom=? AND mdp=?");
					st.setString(1, loginView.getLogin().getText());
					st.setString(2, loginView.getPassword().getText());
	            
					ResultSet rs = st.executeQuery();
	                
	                
					if (rs.next()) {
						MedecinViewController medecinContr = new MedecinViewController(new MedecinViewFail());
						loginView.setMedecinView( medecinContr.getMedecinView()); 
						loginView.getMedecinView().setTitle("Welcome");
						loginView.getMedecinView().setVisible(true);
	                	loginView.setVisible(false);
	                    JOptionPane.showMessageDialog(loginView.getMedecinView().getTxt(),"Medecin success");
					} else {
	                    JOptionPane.showMessageDialog(loginView, "Wrong Username & Password");
					}
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			}
			
		}
		
	}

}
