package leo.labatut.projet.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import leo.labatut.projet.model.Chambre;
import leo.labatut.projet.model.Consultation;
import leo.labatut.projet.model.Patient;
import leo.labatut.projet.model.Suivi;


public class InterfaceInfirmier extends JFrame{
	
	
	
	private JPanel patientInfos = new JPanel();
	
	private JTextArea infoPatient = new JTextArea(50,50);
	
	private JButton deconnexion = new JButton("Déconnexion");
	private JPanel deconnexionPan = new JPanel();
	
	private JPanel mainPanel = new JPanel(new BorderLayout());
	
	private JSplitPane splitPane= new JSplitPane();
	private JSplitPane splitPane2= new JSplitPane();
	
	private JScrollPane scPaneChambre = new JScrollPane();
	private JScrollPane scPanePatient = new JScrollPane();
	private JScrollPane scPaneInfoPatient = new JScrollPane();
	
	private JTable tableChambre;
	private JTable tablePatient;
	
	private String colChambre[] = {"Id","Service", "Patients"};
	private String colPatient[] = {"Id","nom","Prenom"};
	
	
	private DefaultTableModel tableModelChambre;
	private DefaultTableModel tableModelPatient;

	/**
	 * constructeur
	 */
	public InterfaceInfirmier() {
		
		this.getContentPane().add(mainPanel);
        
	     this.deconnexionPan.add(deconnexion);
	     this.mainPanel.add(deconnexionPan,BorderLayout.PAGE_START);
	     this.mainPanel.add(splitPane,BorderLayout.CENTER);
		
		splitPane2.setDividerLocation(200);
		splitPane2.setLeftComponent(scPaneChambre);
		splitPane2.setRightComponent(scPanePatient);
		
		splitPane.setDividerLocation(400);
		splitPane.setLeftComponent(splitPane2);
		scPaneInfoPatient= new JScrollPane(infoPatient);
		splitPane.setRightComponent(scPaneInfoPatient);
		
		this.setSize (new Dimension (700, 450)) ;
		this.centreWindow((Window)this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/**
	 * rempli la Jlist chambres
	 * @param list
	 */
	public void fillTableChambre(ArrayList<Chambre> list) {
		this.tableModelChambre = new DefaultTableModel(colChambre, 0);
		this.tableChambre = new JTable(tableModelChambre);
		
		for (int i = 0; i < list.size(); i++){
			int id = list.get(i).getId(); 
			String service = list.get(i).getService().getNom();
			int nbPatient = list.get(i).getNbPatient();
			
			Object[] data = {id, service, nbPatient};
			tableModelChambre.addRow(data);
		}
		
		scPaneChambre.setViewportView(tableChambre);
		
	}
	/**
	 * rempli la JList patients
	 * @param list
	 */
	public void fillTablePatient(ArrayList<Patient> list) {
		this.tableModelPatient = new DefaultTableModel(colPatient, 0);
		this.tablePatient = new JTable(tableModelPatient);
		
		for (int i = 0; i < list.size(); i++){
			
			int id = list.get(i).getId(); 
			String nom= list.get(i).getNom();
			String prenom = list.get(i).getPrenom();
			
			Object[] data = {id, nom, prenom};
			tableModelPatient.addRow(data);
		}
		
		scPanePatient.setViewportView(tablePatient);
		
	}
	/**
	 * centrage des fenêtres
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
	public JTextArea getInfoPatient() {
		return this.infoPatient;
	}
	
	public JTable getTableChambre() {
		return this.tableChambre;
	}
	public JTable getTablePatient() {
		return this.tablePatient;
	}
	public JButton getDeconnexionButton() {
		return this.deconnexion;
	}
	

}
