package leo.labatut.projet.view;

import java.awt.Dimension;

import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame{

	private JPanel panel = new JPanel(new GridBagLayout());
	private GridBagConstraints c = new GridBagConstraints();
	
	private JLabel loginLabel= new JLabel("Login : ");
	private JTextField login= new JTextField(20);
	private JLabel passwordLabel= new JLabel("Password : ");
	private JPasswordField password= new JPasswordField(20);
	private JComboBox box;
	private JButton submit= new JButton("Submit");
	/**
	 * constructeur
	 */
	public Login() {
		String s1[]= {"Invités","SuperAdmin","Medecin","Infirmier","Technicien","Agent d'administration"};
		
		this.box=new JComboBox(s1);
		
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=0;
		panel.add(loginLabel,c);
		
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=1;
		panel.add(login,c);
		
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=2;
		panel.add(passwordLabel,c);
		
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=3;
		panel.add(password,c);
		
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=4;
		panel.add(box,c);
		
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=5;
		panel.add(submit,c);
		
		this.setContentPane(panel);
		this.setTitle ("Login") ;
		this.setSize (new Dimension (700, 450)) ;
		
		centreWindow((Window)this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * écoute le bouton "submit"
	 * @param listenForSubmitButton
	 */
	public void submitListener(ActionListener listenForSubmitButton){
		submit.addActionListener(listenForSubmitButton);
	}
	/*
	 * getters
	 */
	public JComboBox getBox() {
		return this.box;
	}

	public JTextField getLogin() {
		return this.login;
	}
	public JTextField getPassword() {
		return this.password;
	}
		
	/**
	 * centrage fenêtres
	 * @param frame
	 */
	public static void centreWindow(Window frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}

}
