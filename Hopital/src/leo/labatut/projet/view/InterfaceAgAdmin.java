package leo.labatut.projet.view;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.*;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import leo.labatut.projet.model.Chambre;
import leo.labatut.projet.model.Patient;

public class InterfaceAgAdmin extends JFrame{
	
	private JTabbedPane tabbedPane= new JTabbedPane();
	
	private JButton deconnexion = new JButton("Déconnexion");
	private JPanel deconnexionPan = new JPanel();
	
	private JPanel mainPanel = new JPanel(new BorderLayout());
	
	private JSplitPane ajoutSuiviSplitPane1= new JSplitPane();
	private JSplitPane ajoutSuiviSplitPane2= new JSplitPane();
	private JScrollPane ajoutSuiviScPane1;
	private JScrollPane ajoutSuiviScPane2;
	
	private JDialog ajoutPatientDialog = new JDialog();
	private JDialog gestionChambreDialog = new JDialog();
	
	private JSplitPane ajoutPatientSplitPane= new JSplitPane();
	private JScrollPane ajoutPatientScPane;
	
	private JPanel patientButtonPanel = new JPanel();
	private JPanel chambreButtonPanel = new JPanel();
	private JButton okPatient = new JButton("OK");
	private JButton ajoutPatient = new JButton ("Ajouter Patient");
	private JButton okChambre = new JButton("OK");
	private JButton ajoutChambre = new JButton ("Compléter une chambre");
	
	private JScrollPane scPanePatient=new JScrollPane();
	private JScrollPane scPaneChambre=new JScrollPane();
	
	private JSplitPane splitPanePatients = new JSplitPane();
	private JSplitPane splitPaneChambres = new JSplitPane();
	
	private JTable tablePatient;
	private JTable tableChambre;
	private String colPatient[] = {"Id","Nom","Prénom","Date de Naissance", "Sexe", "email"};
	private String colChambre[] = {"Numéro de chambre","Service","Patients","Capacité totale"};
		
	private DefaultTableModel tableModelPatients;
	private DefaultTableModel tableModelChambres;
	
	private JList patients;
	
	private JTextField numero= new JTextField(15);
	
	private JTextField id= new JTextField(15);
	private JTextField nom= new JTextField(15);
	private JTextField prenom= new JTextField(15);
	private JTextField dateNaissance= new JTextField(15);
	private JTextField sexe= new JTextField(15);
	private JTextField email= new JTextField(15);
	private JTextField mdp=new JPasswordField(15);
	
	private JTextField patient= new JTextField(15);
	
	private JLabel nomArea = new JLabel("Nom : ");
	private JLabel prenomArea = new JLabel("Prénom : ");
	private JLabel dateNaissanceArea = new JLabel("Date de naissance(dd/MM/yyyy): ");
	private JLabel sexeArea = new JLabel("Sexe (M/F): ");
	private JLabel emailArea = new JLabel("E-mail : ");
	
	private JDialog ajouterPatientDialog =new JDialog(this,"Ajouter un Patient");
	private JDialog completerChambreDialog =new JDialog(this,"Compléter une Chambre");
	
	private JDialog erreurDialog=new JDialog(this,"ERREUR");
	private JTextArea erreur = new JTextArea("ERREUR chambre complète");
	private JDialog erreur2Dialog=new JDialog(this,"ERREUR");
	private JTextArea erreurChamp = new JTextArea("ERREUR Champ incomplet");
	
	private JPanel dialogPan_ajouter=new JPanel();
	private JPanel dialogPanelChambre=new JPanel();
	
	private JScrollPane jScPaneChambre = new JScrollPane();
	private JSplitPane splitPaneChambre = new JSplitPane();
	
	private JButton okayButton_ajouterPatient = new JButton("OK");
	private JButton okayButton_Chambre = new JButton("OK");

	/**
	 * constructeur
	 */
	public InterfaceAgAdmin() {
		 this.getContentPane().add(mainPanel);
	        
	     this.deconnexionPan.add(deconnexion);
	     this.mainPanel.add(deconnexionPan,BorderLayout.PAGE_START);
	     this.mainPanel.add(tabbedPane,BorderLayout.CENTER);
	     
		erreurDialog.add(erreur);	
		erreurDialog.setSize(new Dimension(300,150));
		
		centreWindow((Window)erreurDialog);
		erreur2Dialog.add(erreurChamp);	
		erreur2Dialog.setSize(new Dimension(300,150));
		centreWindow((Window)erreur2Dialog);
		
		// gestion patients
		patientButtonPanel.add(ajoutPatient);
		ajoutPatient.addActionListener(new AjouterPatientListener());
		
		tabbedPane.addTab("Patients",splitPanePatients);
		
        scPanePatient.setPreferredSize(new Dimension(450, 300));
        splitPanePatients.setDividerLocation(500);
        splitPanePatients.setLeftComponent(scPanePatient);
        splitPanePatients.setRightComponent(patientButtonPanel);
        
        //gestion chambres  
        chambreButtonPanel.add(numero);
        chambreButtonPanel.add(ajoutChambre);
		ajoutChambre.addActionListener(new CompleterChambreListener());
        
        tabbedPane.addTab("Chambres",splitPaneChambres);
        
        scPaneChambre.setPreferredSize(new Dimension(450, 300));
        splitPaneChambres.setLeftComponent(scPaneChambre);
        splitPaneChambres.setRightComponent(chambreButtonPanel);
        splitPaneChambres.setDividerLocation(500);
		
		this.setSize (new Dimension (700, 450)) ;
		centreWindow((Window)this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/**
	 * ouvre un  dialogue quand le bouton ajouter patient est cliqué
	 * @author User
	 *
	 */
	class AjouterPatientListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//fenêtre de dialogue ajouter medecin
			dialogPan_ajouter.removeAll();
			dialogPan_ajouter.add(nomArea);
			dialogPan_ajouter.add(nom);
			dialogPan_ajouter.add(prenomArea);
			dialogPan_ajouter.add(prenom);
			dialogPan_ajouter.add(dateNaissanceArea);
			dialogPan_ajouter.add(dateNaissance);
			dialogPan_ajouter.add(sexeArea);
			dialogPan_ajouter.add(sexe);
			dialogPan_ajouter.add(emailArea);
			dialogPan_ajouter.add(email);
			
			
			dialogPan_ajouter.add(okayButton_ajouterPatient );
			                 
			ajouterPatientDialog.add(dialogPan_ajouter);	
			ajouterPatientDialog.setSize(new Dimension(200,450));
			centreWindow((Window)ajouterPatientDialog);
			ajouterPatientDialog.setVisible(true);
					
		}
		
	}
	/**
	 * récupère l'id d'un chambre quand la ligne correspondante est cliquée
	 * @author User
	 *
	 */
	public class RowSelectionListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent event) {
			int viewRow = tableChambre.getSelectedRow();

	        if (!event.getValueIsAdjusting() && viewRow != -1) {

	            int columnIndex = 0;

	            // Better to access table row using modelRow rather than viewRow
	            int modelRow = tableChambre.convertRowIndexToModel(viewRow);

	            // Access value at selected row at the first column (columnIndex = 0)
	            int id = (int)tableChambre.getModel().getValueAt(modelRow, columnIndex);
	            
	            numero.setText(Integer.toString(id));
	            
	        }

	          	
		}
		
	}
	/**
	 * ouvre un dialogue quand le bouton compléter chambre est cliqué
	 * @author User
	 *
	 */
	class CompleterChambreListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(numero.getText().equals("")) {
				erreur2Dialog.setVisible(true);
			}else {
			//fenêtre de dialogue ajouter medecin
			patients.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                  patient.setText(patients.getSelectedValue().toString());
	              }
	            }
			});
			dialogPanelChambre.removeAll();
			dialogPanelChambre.add(patient);
			dialogPanelChambre.add(okayButton_Chambre);
			
			jScPaneChambre=new JScrollPane(patients);
			
			splitPaneChambre.setDividerLocation(650);
			splitPaneChambre.setLeftComponent(jScPaneChambre);
			splitPaneChambre.setRightComponent(dialogPanelChambre);
			
			completerChambreDialog.add(splitPaneChambre);	
			completerChambreDialog.setSize(new Dimension(850,300));
			centreWindow((Window)completerChambreDialog);
			completerChambreDialog.setVisible(true);
			}	
		}
		
	}
	/**
	 * rempli la Jlist patients
	 * @param list
	 */
	public void fillTablePatients(ArrayList<Patient>list) {
		this.tableModelPatients = new DefaultTableModel(colPatient, 0);
		this.tablePatient = new JTable(tableModelPatients);
		
		for (int i = 0; i < list.size(); i++){
			int id = list.get(i).getId(); 
			String nom = list.get(i).getNom();
			String prenom = list.get(i).getPrenom();
			String date = list.get(i).getDateNaissance().toString();
			char sexe =list.get(i).getSexe();
			String email=list.get(i).getEmail();
			
			Object[] data = {id, nom, prenom,date, sexe, email };
			tableModelPatients.addRow(data);
		}
		
		scPanePatient.setViewportView(tablePatient);
				 
	}
	/**
	 * rempli la JTable chambres
	 * @param list
	 */
	public void fillTableChambres(ArrayList<Chambre>list) {
		this.tableModelChambres = new DefaultTableModel(colChambre, 0);
		this.tableChambre = new JTable(tableModelChambres);
		
		for (int i = 0; i < list.size(); i++){
			int id = list.get(i).getId(); 
			String service = list.get(i).getService().getNom();
			int patient = list.get(i).getNbPatient();
			int capacite = list.get(i).getCapacite();
			
			Object[] data = {id, service, patient, capacite };
			tableModelChambres.addRow(data);
		}
		this.tableChambre.getSelectionModel().addListSelectionListener(new RowSelectionListener());
		scPaneChambre.setViewportView(tableChambre);
				 
	}
	/**
	 * rempli la JList patients
	 * @param list
	 */
	public void fillListPatient(ArrayList<Patient>list) {
		
		String[]tabPatients= new String[list.size()];
		
		for(int i=0; i<list.size();i++) {
			tabPatients[i]=list.get(i).getId()+" "+list.get(i).getNom()+" "+list.get(i).getPrenom()+" Chambre numéro :"+list.get(i).getChambre();
		}
		this.patients= new JList(tabPatients);
		
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
	 * getters textfields
	 */
	public JTextField getNumero() {
		return this.numero;
	}
	public JTextField getPatient() {
		return this.patient;
	}
	public JTextField getId() {
		return this.id;
	}
	public JTextField getNom() {
		return this.nom;
	}
	public JTextField getPrenom() {
		return this.prenom;
	}
	public JTextField getDateNaissance() {
		return this.dateNaissance;
	}
	public JTextField getSexe() {
		return this.sexe;
	}
	public JTextField getEmail() {
		return this.email;
	}

	public JTextField getMdp() {
		return this.mdp;
	}
	
	/*
	 * getters Jdialog
	 */
	public JDialog getAjouterPatientDialog() {
		return this.ajouterPatientDialog;
	}
	public JDialog getCompleterChambreDialog() {
		return this.completerChambreDialog;
	}
	public JDialog getErreurDialog() {
		return this.erreurDialog;
	}
	public JDialog getErreur2Dialog() {
		return this.erreur2Dialog;
	}
	public DefaultTableModel getTableModelPatients() {
		return tableModelPatients;
	}
	public DefaultTableModel getTableModelChambres() {
		return tableModelChambres;
	}
	
	/*
	 * getters boutons
	 */
	public JButton getOkayButton_ajouterPatient() {
		return this.okayButton_ajouterPatient;
	}
	public JButton getOkayButton_Chambre() {
		return this.okayButton_Chambre;
	}
	public JButton getDeconnexionButton() {
		return this.deconnexion;
	}
}
