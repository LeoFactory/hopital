package leo.labatut.projet.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class SuperAdminView extends JFrame {
	
	private JPanel panel = new JPanel();
	private JTextArea txt= new JTextArea("SUPER ADMIN");
	
	public SuperAdminView() {
		
		panel.add(txt);

		
		this.setContentPane(panel);
		this.setTitle ("SuperAdmin") ;
		this.setSize (new Dimension (700, 450)) ;
	}
	
	public JTextArea getTxt() {
		return this.txt;
	}

}
