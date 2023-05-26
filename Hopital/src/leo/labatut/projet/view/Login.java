package leo.labatut.projet.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import trucs.MedecinViewFail;
import trucs.SuperAdminViewFail;

public class Login extends JFrame{

	private JPanel panel = new JPanel();
	private JTextArea loginLabel= new JTextArea("Login : ");
	private JTextField login= new JTextField(20);
	private JTextArea passwordLabel= new JTextArea("Password : ");
	private JPasswordField password= new JPasswordField(20);
	private JComboBox box;
	private JButton submit= new JButton("Submit");
	private SuperAdminViewFail superView;
	private MedecinViewFail medecinView;
	
	public Login() {
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
		
		centreWindow((Window)this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
	//méthode de centrage des fenêtres
	public static void centreWindow(Window frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}

}
