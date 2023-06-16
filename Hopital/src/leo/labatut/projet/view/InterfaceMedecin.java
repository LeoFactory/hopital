package leo.labatut.projet.view;

import java.awt.BorderLayout;
import java.awt.Dimension;


import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import leo.labatut.projet.controller.ControllerMedecin.RowSelectionListener;
import leo.labatut.projet.model.Appareil;
import leo.labatut.projet.model.Consultation;
import leo.labatut.projet.model.Pathologie;
import leo.labatut.projet.model.Patient;
import leo.labatut.projet.model.Suivi;

public class InterfaceMedecin extends JFrame {
	
	private JTable tableSuivi;
	private JTable tableConsultation;
	
	private JButton deconnexion = new JButton("Déconnexion");
	private JPanel deconnexionPan = new JPanel();
	
	private JPanel mainPanel = new JPanel(new BorderLayout());
	
	private JTextField pathologie = new JTextField(15);
	private JTextField patient = new JTextField(15);
	private JTextField suivi = new JTextField(15);
	private JTextField consultation = new JTextField(15);
	private JTextField appareil = new JTextField(15);
	private JTextArea soin = new JTextArea("Soin : ");
	private JTextArea ordonnance = new JTextArea("Ordonnance : ");
	
	private JList patients;
	private JList pathologies;
	private JList suivis;
	private JList appareils;
	
	private JPanel buttonPanel = new JPanel();
	private JPanel ajoutSuiviPane = new JPanel();
	private JPanel ajoutConsultPane = new JPanel();
	private JPanel completConsultPane = new JPanel();
	private JPanel completButtonPane = new JPanel();
	
	private JDialog erreurDialog=new JDialog(this,"ERREUR");
	private JTextArea erreur = new JTextArea("ERREUR champ incomplet");
	
	
	private JDialog ajoutSuiviDialog = new JDialog();
	private JSplitPane ajoutSuiviSplitPane1= new JSplitPane();
	private JSplitPane ajoutSuiviSplitPane2= new JSplitPane();
	private JScrollPane ajoutSuiviScPane1;
	private JScrollPane ajoutSuiviScPane2;
	
	private JDialog ajoutConsultDialog = new JDialog();
	private JSplitPane ajoutConsultSplitPane= new JSplitPane();
	private JScrollPane ajoutConsultScPane;
	
	private JTextArea erreurArea = new JTextArea("Erreur veuillez sélectionner une consultation !");
	private JDialog erreurdialog = new JDialog();
	
	private JDialog completConsultDialog = new JDialog();
	private JScrollPane completConsultScPane;
	private JSplitPane completConsultSplit1= new JSplitPane();;
	private JSplitPane completConsultSplit2= new JSplitPane();;
	
	
	
	private JButton okSuivi = new JButton("OK");
	private JButton ajoutSuivi = new JButton ("Ajout Suivi");
	private JButton okConsult = new JButton("OK");
	private JButton ajoutConsult = new JButton ("Ajout Consultation");
	private JButton soinAppareil = new JButton("Soin/Appareil/ordonnance");
	private JButton okCompleter = new JButton("OK");
	
	private JScrollPane scPaneSuivi=new JScrollPane();
	private JScrollPane scPaneConsultation=new JScrollPane();
	
	private JSplitPane splitPane = new JSplitPane();
	private JSplitPane splitPane2 = new JSplitPane();
	
	private String colSuivi[] = {"Id","Patient","Pathologie","Medecin"};
	private String colCons[] = {"Id","Date"};
	
	private DefaultTableModel tableModelSuivi;
	private DefaultTableModel tableModelConsultation;
	/**
	 * constructeur
	 */
	public InterfaceMedecin() {
		
		this.getContentPane().add(mainPanel);
		
		erreurDialog.add(erreur);	
		erreurDialog.setSize(new Dimension(300,150));
		centreWindow((Window)erreurDialog);
        
	    this.deconnexionPan.add(deconnexion);
	    this.mainPanel.add(deconnexionPan,BorderLayout.PAGE_START);
	    this.mainPanel.add(splitPane,BorderLayout.CENTER);
		
		splitPane2.setDividerLocation(250);
		splitPane2.setLeftComponent(scPaneSuivi);
		splitPane2.setRightComponent(scPaneConsultation);
		
		ajoutSuivi.addActionListener(new AjoutSuiviListener());
		ajoutConsult.addActionListener(new AjoutConsultListener());
		soinAppareil.addActionListener(new CompleterConsultListener());
		buttonPanel.add(ajoutSuivi);
		buttonPanel.add(ajoutConsult);
		buttonPanel.add(consultation);
		buttonPanel.add(soinAppareil);
		
		splitPane.setDividerLocation(500);
        splitPane.setLeftComponent(splitPane2);
        splitPane.setRightComponent(buttonPanel);
        
		this.setSize (new Dimension (700, 450)) ;
		centreWindow((Window)this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * configure et affiche un dialogue permettant d'ajouter un suivi
	 * @author User
	 *
	 */
	class AjoutSuiviListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			patients.addListSelectionListener(new ListSelectionListener() {

		            @Override
		            public void valueChanged(ListSelectionEvent arg0) {
		                if (!arg0.getValueIsAdjusting()) {
		                  patient.setText(patients.getSelectedValue().toString());
		              }
		         }
		    });
			pathologies.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                  pathologie.setText(pathologies.getSelectedValue().toString());
	              }
	         }
			});
			ajoutSuiviPane.removeAll();
			ajoutSuiviSplitPane1.setLeftComponent(ajoutSuiviSplitPane2);
			ajoutSuiviPane.add(patient);
			ajoutSuiviPane.add(pathologie);
			ajoutSuiviPane.add(okSuivi);
			ajoutSuiviSplitPane1.setRightComponent(ajoutSuiviPane);
			
			
			ajoutSuiviScPane1=new JScrollPane(patients);
			ajoutSuiviScPane2=new JScrollPane(pathologies);
			
			ajoutSuiviSplitPane1.setDividerLocation(200);
			ajoutSuiviSplitPane2.setLeftComponent(ajoutSuiviScPane1);
			ajoutSuiviSplitPane2.setRightComponent(ajoutSuiviScPane2);
			ajoutSuiviSplitPane2.setDividerLocation(100);
			
			ajoutSuiviDialog.add(ajoutSuiviSplitPane1);	
			ajoutSuiviDialog.setSize(new Dimension(400,300));
			centreWindow((Window)ajoutSuiviDialog);
			ajoutSuiviDialog.setVisible(true);
			
		}
		
	}
	/**
	 * configure et affiche un dialogue d'ajout de consultation
	 * @author User
	 *
	 */
	class AjoutConsultListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			suivis.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                  suivi.setText(suivis.getSelectedValue().toString());
	              }
	         }
	    });
			ajoutConsultPane.removeAll();
			ajoutConsultPane.add(suivi);
			ajoutConsultPane.add(okConsult);
			
			ajoutConsultScPane=new JScrollPane(suivis);
			
			ajoutConsultSplitPane.setDividerLocation(200);
			ajoutConsultSplitPane.setLeftComponent(ajoutConsultScPane);
			ajoutConsultSplitPane.setRightComponent(ajoutConsultPane);
			
			ajoutConsultDialog.add(ajoutConsultSplitPane);	
			ajoutConsultDialog.setSize(new Dimension(400,300));
			centreWindow((Window)ajoutConsultDialog);
			ajoutConsultDialog.setVisible(true);
			
			
		}
		
	}
	/**
	 * configure et affiche un dialogue d'ajout de consultation
	 * @author User
	 *
	 */
	class CompleterConsultListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(!consultation.getText().equals("")) {
			appareils.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                	appareil.setText(appareils.getSelectedValue().toString());
	              }
	         }
	    });
			completButtonPane.removeAll();
			completButtonPane.add(appareil);
			completButtonPane.add(okCompleter);
			completConsultScPane=new JScrollPane(appareils);
			
			ordonnance.setPreferredSize(new Dimension(120,170));
			soin.setPreferredSize(new Dimension(120,170));
			
			ordonnance.setLineWrap(true);
			ordonnance.setWrapStyleWord(true);
			soin.setLineWrap(true);
			soin.setWrapStyleWord(true);
			
			completConsultPane.add(ordonnance);
			completConsultPane.add(soin);
			
			completConsultSplit1.setDividerLocation(150);
			completConsultSplit1.setRightComponent(completConsultPane);
			completConsultSplit1.setLeftComponent(completConsultScPane);
		
			completConsultSplit2.setDividerLocation(300);
			completConsultSplit2.setLeftComponent(completConsultSplit1);
			completConsultSplit2.setRightComponent(completButtonPane);
			
			completConsultDialog.add(completConsultSplit2);	
			completConsultDialog.setSize(new Dimension(500,400));
			centreWindow((Window)completConsultDialog);
			completConsultDialog.setVisible(true);
			}else {
				erreurdialog.add(erreurArea);
				erreurdialog.setSize(new Dimension(300,100));
				centreWindow((Window)erreurdialog);
				erreurdialog.setVisible(true);
			}
			
		}
		
	}
	
	public JDialog getAjoutSuiviDialog() {
		return this.ajoutSuiviDialog;
	}
	public JDialog getAjoutConsultDialog() {
		return this.ajoutConsultDialog;
	}
	public JTextField getPatient() {
		return this.patient;
	}
	public JTextField getPathologie() {
		return this.pathologie;
	}
	public JTextField getSuivi() {
		return this.suivi;
	}
	public JButton getOkConsult() {
		return this.okConsult;
	}
	public JButton getOkSuivi() {
		return this.okSuivi;
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

/**
 * rempli la JTable de suivi
 * @param list
 */
		public void fillTableSuivi(ArrayList<Suivi> list) {
			this.tableModelSuivi = new DefaultTableModel(colSuivi, 0);
			this.tableSuivi = new JTable(tableModelSuivi);
			
			for (int i = 0; i < list.size(); i++){
				int id = list.get(i).getId(); 
				String patient = list.get(i).getPatient().getNom();
				String pathologie = list.get(i).getPathologie().getNom();
				String medecin = list.get(i).getMedecin().getNom();
				
				Object[] data = {id, patient, pathologie, medecin};
				tableModelSuivi.addRow(data);
			}
			
			scPaneSuivi.setViewportView(tableSuivi);
			
		}
		/**
		 * rempli la jtable de consultation
		 * @param list
		 */
		public void fillTableConsultation(ArrayList<Consultation> list) {
			this.tableModelConsultation = new DefaultTableModel(colCons, 0);
			this.tableConsultation = new JTable(tableModelConsultation);
			
			for (int i = 0; i < list.size(); i++){
				int id = list.get(i).getId(); 
				Date date= list.get(i).getDate();
				
				Object[] data = {id, date};
				tableModelConsultation.addRow(data);
			}
			
			scPaneConsultation.setViewportView(tableConsultation);
			
		}
		/**
		 * rempli la jlist de patients
		 * @param list
		 */
		public void fillListPatient(ArrayList<Patient>list) {
			
			String[]tabPatients= new String[list.size()];
			
			for(int i=0; i<list.size();i++) {
				tabPatients[i]=list.get(i).getId()+" "+list.get(i).getNom()+" "+list.get(i).getPrenom();
			}
			this.patients= new JList(tabPatients);
			
		}
		/**
		 * rempli la jlist de pathologie
		 * @param list
		 */
		public void fillListPathologie(ArrayList<Pathologie>list) {
			
			String[]tabPathologies= new String[list.size()];
			
			for(int i=0; i<list.size();i++) {
				tabPathologies[i]=list.get(i).getId()+" "+list.get(i).getNom();
			}
			this.pathologies= new JList(tabPathologies);
			
		}
		/**
		 * rempli la Jlist de suivi
		 * @param list
		 */
		public void fillListSuivis(ArrayList<Suivi>list) {
			
			String[]tabSuivis= new String[list.size()];
			
			for(int i=0; i<list.size();i++) {
				tabSuivis[i]=list.get(i).getId()+" "+list.get(i).getPatient().getNom()+" "+list.get(i).getPathologie().getNom();
			}
			this.suivis= new JList(tabSuivis);
			
		}
		/**
		 * rempli la Jlist d'appareil
		 * @param list
		 */
		public void fillListAppareils(ArrayList<Appareil>list) {
			
			String[]tabAppareils= new String[list.size()];
			
			for(int i=0; i<list.size();i++) {
				tabAppareils[i]=list.get(i).getId()+" "+list.get(i).getLibelle();
			}
			this.appareils= new JList(tabAppareils);
			
		}
		/*
		 * getters
		 */
		public DefaultTableModel getTableModelSuivi() {
			return this.tableModelSuivi;
		}
		public DefaultTableModel getTableModelConsultation() {
			return this.tableModelConsultation;
		}
		public JTable getTableSuivi() {
			return this.tableSuivi;
		}
		public JTable getTableConsultation() {
			return this.tableConsultation;
		}
		public JTextField getConsultation() {
			return this.consultation;
		}
		public JTextArea getSoin() {
			return this.soin;
		}
		public JTextArea getOrdonnance() {
			return this.ordonnance;
		}
		public JTextField getAppareil() {
			return this.appareil;
		}
		public JButton getOkComplet() {
			return this.okCompleter;
		}
		public JButton getDeconnexionButton() {
			return this.deconnexion;
		}
		public JDialog getCompletConsultDialog() {
			return this.completConsultDialog;
		}
		public JDialog getErreurDialog() {
			return this.erreurDialog;
		}
					
}
