package trucs;

import java.awt.Dimension;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import leo.labatut.projet.view.MedecinView;
import leo.labatut.projet.view.SuperAdminView;

public class LoginView extends JFrame {
	
	private JPanel panel = new JPanel();
	private JTextArea loginLabel= new JTextArea("Login : ");
	private JTextField login= new JTextField(20);
	private JTextArea passwordLabel= new JTextArea("Password : ");
	private JPasswordField password= new JPasswordField(20);
	private JComboBox box;
	private JButton submit= new JButton("Submit");
	private SuperAdminViewFail superView;
	private MedecinViewFail medecinView;
	
	public LoginView() {
		
		
		
		String s1[]= {"SuperAdmin","Medecin","Infirmier","Technicien","Agent d'administration"};
		
		this.box=new JComboBox(s1);
		
		panel.add(loginLabel);
		panel.add(login);
		panel.add(passwordLabel);
		panel.add(password);
		panel.add(box);
		panel.add(submit);
		
		this.setContentPane(panel);
		this.setTitle ("Login") ;
		this.setSize (new Dimension (700, 450)) ;
	}
	
	
	public void submitListener(ActionListener listenForSubmitButton){
		submit.addActionListener(listenForSubmitButton);
	}

	public JTextField getLogin() {
		return this.login;
	}
	public JTextField getPassword() {
		return this.password;
	}
	
	public JComboBox getBox() {
		return this.box;
	}
	
	public SuperAdminViewFail getSuperView() {
		return this.superView;
	}
	public void setSuperView(SuperAdminViewFail superView) {
		this.superView=superView;
	}
	public MedecinViewFail getMedecinView() {
		return this.medecinView;
	}
	public void setMedecinView(MedecinViewFail medecinView) {
		this.medecinView=medecinView;
	}

	
	
}
