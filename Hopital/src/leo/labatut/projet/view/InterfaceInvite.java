package leo.labatut.projet.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import leo.labatut.projet.model.Patient;

public class InterfaceInvite extends JFrame {
	
	private JButton deconnexion = new JButton("Déconnexion");
	private JPanel deconnexionPan = new JPanel();
	
	private JTabbedPane tabbedPane= new JTabbedPane();
	
	private JPanel mainPanel= new JPanel(new BorderLayout());
	private JPanel panelRecherche = new JPanel();
	
	private JDialog erreur = new JDialog(this,"Erreur");
	private JLabel personnel = new JLabel("Personnel(nom de famille)");
	private JLabel patient = new JLabel("Patient(nom de famille)");
	
	private JTextField fieldPersonnel = new JTextField(15);
	private JTextField fieldPatient = new JTextField(15);
	
	private JButton recherchePersonnel = new JButton("Chercher");
	private JButton recherchePatient = new JButton("Chercher");

	private JScrollPane infoScPane ;
	private JScrollPane rechercheScPane;
	private JSplitPane splitPaneRecherche= new JSplitPane();
	

	private JTextArea info = new JTextArea(20,50);
	private JTextArea resultRecherche = new JTextArea(20,50);
	
	/**
	 * constructeur
	 */
	public InterfaceInvite() {
		
		this.setSize (new Dimension (700, 450));
		
		this.erreur.add(new JLabel("Erreur champ incomplet !"));
		
		this.setTitle("Invités");
		this.deconnexionPan.add(deconnexion);
		this.mainPanel.add(deconnexionPan,BorderLayout.PAGE_START);
		
		this.infoScPane= new JScrollPane(info);
		this.tabbedPane.addTab("Statistiques",infoScPane);
		
		this.mainPanel.add(tabbedPane,BorderLayout.CENTER);
		
		this.splitPaneRecherche.setDividerLocation(450);
		
		this.rechercheScPane= new JScrollPane(resultRecherche);
		this.splitPaneRecherche.setLeftComponent(rechercheScPane);
		
		panelRecherche.setLayout(new BoxLayout(panelRecherche, BoxLayout.Y_AXIS));
		panelRecherche.add(personnel);
		
		fieldPersonnel.setMaximumSize(new Dimension(400, 20));
		panelRecherche.add(fieldPersonnel);
		panelRecherche.add(recherchePersonnel);
		panelRecherche.add(patient);
		
		fieldPatient.setMaximumSize(new Dimension(400, 20));
		panelRecherche.add(fieldPatient);
		panelRecherche.add(recherchePatient);
		this.splitPaneRecherche.setRightComponent(panelRecherche);
		this.tabbedPane.addTab("Recherche",splitPaneRecherche);
		
		this.add(mainPanel);
		
		centreWindow((Window)this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * centrage fenêtre
	 * @param frame
	 */
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
	
	/*
	 * getters
	 */
	public JButton getDeconnexionButton() {
		return this.deconnexion;
	}
	public JTextArea getInfo() {
		return this.info;
	}
	public JTextArea getResult() {
		return this.resultRecherche;
	}
	public JTextField getPatient() {
		return this.fieldPatient;
	}
	public JTextField getPersonnel() {
		return this.fieldPersonnel;
	}
	public JButton getBoutonRecherchePatient() {
		return this.recherchePatient;
	}
	public JButton getBoutonRecherchePersonnel() {
		return this.recherchePersonnel;
	}
	public JDialog getErreurDialog() {
		return this.erreur;
	}


}
