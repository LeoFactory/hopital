package leo.labatut.projet.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Date;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import leo.labatut.projet.controller.ControllerInfirmier.RowSelectionListenerPatient;
import leo.labatut.projet.controller.ControllerMedecin.RowSelectionListener;
import leo.labatut.projet.model.Chambre;
import leo.labatut.projet.model.Consultation;

public class InterfaceTechnicien extends JFrame {
	
	
	private JButton deconnexion = new JButton("Déconnexion");
	private JPanel deconnexionPan = new JPanel();
	
	private JPanel mainPanel = new JPanel(new BorderLayout());
	
	private JTable tableConsultation;
	private JScrollPane scPaneConsultation=new JScrollPane();
	private String colCons[] = {"Id","Date","Appareil","Statut"};
	private DefaultTableModel tableModelConsultation;
	
	private JTextField numeroConsultation= new JTextField(15);
	
	private JButton buttonOk = new JButton("OK");
	
	private JDialog octroieDialog = new JDialog();
	private JComboBox box;
	
	private JPanel dialogPan = new JPanel(); 
	private JPanel buttonPanel;	
	private JSplitPane splitPane = new JSplitPane();
	/**
	 * constructeur
	 */
	
	public InterfaceTechnicien() {
		
		this.getContentPane().add(mainPanel);
        
	     this.deconnexionPan.add(deconnexion);
	     this.mainPanel.add(deconnexionPan,BorderLayout.PAGE_START);
	     this.mainPanel.add(splitPane,BorderLayout.CENTER);
		
		this.splitPane.setDividerLocation(300);
		this.splitPane.setLeftComponent(scPaneConsultation);
		this.splitPane.setRightComponent(buttonPanel);
        
        String s1[]= {"instance","octroyé"};
		this.box=new JComboBox(s1);
		
		this.dialogPan.add(numeroConsultation);
		this.dialogPan.add(box);
		this.dialogPan.add(buttonOk);
		
		this.octroieDialog.add(dialogPan);  
		
		
		this.setSize (new Dimension (700, 450)) ;
		centreWindow((Window)this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/**
	 * remplir la JTable consultation
	 * @param list
	 */
	public void fillTableConsultation(ArrayList<Consultation> list) {
		this.tableModelConsultation = new DefaultTableModel(colCons, 0);
		this.tableConsultation = new JTable(tableModelConsultation);
		
		for (int i = 0; i < list.size(); i++){
			int id = list.get(i).getId(); 
			Date date= list.get(i).getDate();
			String appareil = list.get(i).getAppareil().getLibelle();		
			String statut = list.get(i).getStatutAppareil();
			
			Object[] data = {id, date, appareil,statut};
			tableModelConsultation.addRow(data);
		}
		
		scPaneConsultation.setViewportView(tableConsultation);
		
	}
	/*
	 * getters
	 */
	
	public JTable getTableConsultation() {
		return this.tableConsultation;
	}
	public JComboBox getBox() {
		return this.box;
	}
	public JTextField getNumero() {
		return this.numeroConsultation;
	}
	public JButton getOkButton() {
		return this.buttonOk;
	}
	public JButton getDeconnexionButton() {
		return this.deconnexion;
	}
	public JDialog getOctroieDialog() {
		return this.octroieDialog;
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
	

}
