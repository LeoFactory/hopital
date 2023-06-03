package leo.labatut.projet.view;

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

import leo.labatut.projet.model.Consultation;
import leo.labatut.projet.model.Pathologie;
import leo.labatut.projet.model.Patient;
import leo.labatut.projet.model.Suivi;

public class InterfaceMedecin extends JFrame {
	
	private JTable tableSuivi;
	private JTable tableConsultation;
	
	private JTextField pathologie = new JTextField(15);
	private JTextField patient = new JTextField(15);
	private JTextField suivi = new JTextField(15);
	
	private JList patients;
	private JList pathologies;
	private JList suivis;
	
	private JPanel buttonPanel = new JPanel();
	private JPanel ajoutSuiviPane = new JPanel();
	private JPanel ajoutConsultPane = new JPanel();
	
	
	private JDialog ajoutSuiviDialog = new JDialog();
	private JSplitPane ajoutSuiviSplitPane1= new JSplitPane();
	private JSplitPane ajoutSuiviSplitPane2= new JSplitPane();
	private JScrollPane ajoutSuiviScPane1;
	private JScrollPane ajoutSuiviScPane2;
	
	private JDialog ajoutConsultDialog = new JDialog();
	private JSplitPane ajoutConsultSplitPane= new JSplitPane();
	private JScrollPane ajoutConsultScPane;
	
	
	private JButton okSuivi = new JButton("OK");
	private JButton ajoutSuivi = new JButton ("Ajout Suivi");
	private JButton okConsult = new JButton("OK");
	private JButton ajoutConsult = new JButton ("Ajout Consultation");
	
	private JScrollPane scPaneSuivi=new JScrollPane();
	private JScrollPane scPaneConsultation=new JScrollPane();
	
	private JSplitPane splitPane = new JSplitPane();
	private JSplitPane splitPane2 = new JSplitPane();
	
	private String colSuivi[] = {"Id","Patient","Pathologie","Medecin"};
	private String colCons[] = {"Id","Date"};
	
	private DefaultTableModel tableModelSuivi;
	private DefaultTableModel tableModelConsultation;
	
	public InterfaceMedecin() {
		
		splitPane2.setDividerLocation(250);
		splitPane2.setLeftComponent(scPaneSuivi);
		splitPane2.setRightComponent(scPaneConsultation);
		
		ajoutSuivi.addActionListener(new AjoutSuiviListener());
		ajoutConsult.addActionListener(new AjoutConsultListener());
		buttonPanel.add(ajoutSuivi);
		buttonPanel.add(ajoutConsult);
		
		splitPane.setDividerLocation(500);
        splitPane.setLeftComponent(splitPane2);
        splitPane.setRightComponent(buttonPanel);
        
		this.setSize (new Dimension (700, 450)) ;
		this.getContentPane().add(splitPane);
		centreWindow((Window)this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
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
	
	
	//méthode de centrage des fenêtres
		public static void centreWindow(Window frame) {
		    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		    frame.setLocation(x, y);
		}


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
		public void fillListPatient(ArrayList<Patient>list) {
			
			String[]tabPatients= new String[list.size()];
			
			for(int i=0; i<list.size();i++) {
				tabPatients[i]=list.get(i).getId()+" "+list.get(i).getNom()+" "+list.get(i).getPrenom();
			}
			this.patients= new JList(tabPatients);
			
		}
		public void fillListPathologie(ArrayList<Pathologie>list) {
			
			String[]tabPathologies= new String[list.size()];
			
			for(int i=0; i<list.size();i++) {
				tabPathologies[i]=list.get(i).getId()+" "+list.get(i).getNom();
			}
			this.pathologies= new JList(tabPathologies);
			
		}
		public void fillListSuivis(ArrayList<Suivi>list) {
			
			String[]tabSuivis= new String[list.size()];
			
			for(int i=0; i<list.size();i++) {
				tabSuivis[i]=list.get(i).getId()+" "+list.get(i).getPatient().getNom()+" "+list.get(i).getPathologie().getNom();
			}
			this.suivis= new JList(tabSuivis);
			
		}
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
		
		

}
