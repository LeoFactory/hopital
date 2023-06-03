package leo.labatut.projet.view;

import java.awt.Dimension;


import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;

import leo.labatut.projet.model.AgentAdmin;
import leo.labatut.projet.model.Infirmier;
import leo.labatut.projet.model.Medecin;


public class InterfaceSuperAdmin extends JFrame {
	
	private JButton ajouterMedecin = new JButton("Ajouter");
	private JButton supprimerMedecin = new JButton("Supprimer");
	
	private JDialog ajouterMedecinDialog =new JDialog(this,"Ajouter un Medecin");
	private JDialog supprimerMedecinDialog =new JDialog(this,"Supprimer un Medecin");

	private JPanel buttonPanelMedecin = new JPanel();
	private JPanel buttonPanelAgAdmin = new JPanel();

	private JScrollPane scPaneMedecin =new JScrollPane();
	private JScrollPane scPaneAgAdmin =new JScrollPane();
	private JScrollPane scPaneInfirmier =new JScrollPane();
	
	private JSplitPane splitPaneMedecins = new JSplitPane();
	private JSplitPane splitPaneInfirmiers = new JSplitPane();
	private JSplitPane splitPaneAgAdmins = new JSplitPane();
	
	private JTextField id= new JTextField(15);
	private JTextField nom= new JTextField(15);
	private JTextField prenom= new JTextField(15);
	private JTextField dateNaissance= new JTextField(15);
	private JTextField sexe= new JTextField(15);
	private JTextField service= new JTextField(15);
	private JTextField email= new JTextField(15);
	private JTextField mdp=new JPasswordField(15);
	
	private JTextArea idArea = new JTextArea("Id : ");
	private JTextArea nomArea = new JTextArea("Nom : ");
	private JTextArea prenomArea = new JTextArea("Prénom : ");
	private JTextArea dateNaissanceArea = new JTextArea("Date de naissance : ");
	private JTextArea sexeArea = new JTextArea("Sexe : ");
	private JTextArea serviceArea = new JTextArea("Service : ");
	private JTextArea emailArea = new JTextArea("E-mail : ");
	private JTextArea mdpArea = new JTextArea("Mot de passe : ");
	
	private JButton okayButton_ajouterMedecin = new JButton("OK");
	private JButton okayButton_supprimerMedecin = new JButton("OK");
	
	
	private JPanel dialogPan_ajouter=new JPanel();
	private JPanel dialogPan_supprimer=new JPanel();
	
	private JTable table;
	private String colMed[] = {"Id","Nom","Prénom","Service"};
	private String colAg[] = {"Id","Nom","Prénom"};
	private String colInf[] = {"Id","Nom","Prénom"};
	private DefaultTableModel tableModelMedecins;
	private DefaultTableModel tableModelAgAdmins;
	private DefaultTableModel tableModelInfirmiers;
	
	private JTabbedPane tabbedPane= new JTabbedPane();
	
	
	public InterfaceSuperAdmin() {
		this.setTitle ("Interface Super Admin") ;
		this.setSize (new Dimension (700, 450)) ;
		
		ajouterMedecin.addActionListener(new AjouterMedecinListener());
		supprimerMedecin.addActionListener(new SupprimerMedecinListener());

        this.getContentPane().add(tabbedPane);
        
        //onglet infirmiers
        tabbedPane.addTab("Infirmiers",splitPaneInfirmiers);
        scPaneInfirmier.setPreferredSize(new Dimension(450, 300));
        splitPaneInfirmiers.setLeftComponent(scPaneInfirmier);
        
        //onglet agents adminisitration
        tabbedPane.addTab("Agents d'Administration",splitPaneAgAdmins);
        scPaneAgAdmin.setPreferredSize(new Dimension(450, 300));
        splitPaneAgAdmins.setLeftComponent(scPaneAgAdmin);
        
        //onglet medecin
        tabbedPane.addTab("Medecins",splitPaneMedecins);
        scPaneMedecin.setPreferredSize(new Dimension(450, 300));
        splitPaneMedecins.setLeftComponent(scPaneMedecin);
        
        
		
		
		buttonPanelMedecin.add(ajouterMedecin);
		buttonPanelMedecin.add(supprimerMedecin);
		splitPaneMedecins.setRightComponent(buttonPanelMedecin);
		
		
		
		
		centreWindow((Window)this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Met à jour la table méthode appelée après chaque modification
	public void fillTableMedecins(ArrayList<Medecin>list) {
		this.tableModelMedecins = new DefaultTableModel(colMed, 0);
		this.table = new JTable(tableModelMedecins);
		
		for (int i = 0; i < list.size(); i++){
			int id = list.get(i).getId(); 
			String nom = list.get(i).getNom();
			String prenom = list.get(i).getPrenom();
			String service = list.get(i).getService().getNom();
			
			Object[] data = {id, nom, prenom, service};
			tableModelMedecins.addRow(data);
		}
		
		scPaneMedecin.setViewportView(table);
				 
	}
	public void fillTableAgAdmin(ArrayList<AgentAdmin>list) {
		this.tableModelAgAdmins = new DefaultTableModel(colAg, 0);
		this.table = new JTable(tableModelAgAdmins);
		
		for (int i = 0; i < list.size(); i++){
			int id = list.get(i).getId(); 
			String nom = list.get(i).getNom();
			String prenom = list.get(i).getPrenom();
						
			Object[] data = {id, nom, prenom};
			tableModelAgAdmins.addRow(data);
		}
		
		scPaneAgAdmin.setViewportView(table);
				 
	}
	public void fillTableInfirmier(ArrayList<Infirmier>list) {
		this.tableModelInfirmiers = new DefaultTableModel(colInf, 0);
		this.table = new JTable(tableModelInfirmiers);
		
		for (int i = 0; i < list.size(); i++){
			int id = list.get(i).getId(); 
			String nom = list.get(i).getNom();
			String prenom = list.get(i).getPrenom();
						
			Object[] data = {id, nom, prenom};
			tableModelInfirmiers.addRow(data);
		}
		
		scPaneInfirmier.setViewportView(table);
				 
	}
	//classes  ActionListener
	class AjouterMedecinListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//fenêtre de dialogue ajouter medecin
			dialogPan_ajouter.add(nomArea);
			dialogPan_ajouter.add(nom);
			dialogPan_ajouter.add(prenomArea);
			dialogPan_ajouter.add(prenom);
			dialogPan_ajouter.add(dateNaissanceArea);
			dialogPan_ajouter.add(dateNaissance);
			dialogPan_ajouter.add(sexeArea);
			dialogPan_ajouter.add(sexe);
			dialogPan_ajouter.add(serviceArea);
			dialogPan_ajouter.add(service);
			dialogPan_ajouter.add(emailArea);
			dialogPan_ajouter.add(email);
			dialogPan_ajouter.add(mdpArea);
			dialogPan_ajouter.add(mdp);
			
			
			dialogPan_ajouter.add(okayButton_ajouterMedecin );
			                 
			ajouterMedecinDialog.add(dialogPan_ajouter);	
			ajouterMedecinDialog.setSize(new Dimension(200,450));
			centreWindow((Window)ajouterMedecinDialog);
			ajouterMedecinDialog.setVisible(true);
					
		}
		
	}
	class SupprimerMedecinListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//fenêtre de dialogue supprimer
			dialogPan_supprimer.add(id);
			dialogPan_supprimer.add(okayButton_supprimerMedecin);
			
			supprimerMedecinDialog.add(dialogPan_supprimer);	
			supprimerMedecinDialog.setSize(new Dimension(200,450));
			
			centreWindow((Window)supprimerMedecinDialog);
			supprimerMedecinDialog.setVisible(true);
					
		}
		
	}
	
	//méthode Listener
	public void ajouterMedecinListener(ActionListener listenForAjouter){
		ajouterMedecin.addActionListener(listenForAjouter);
	}
	
	public void supprimerMedecinListener(ActionListener listenForSupprimer){
		supprimerMedecin.addActionListener(listenForSupprimer);
	}
	public void ajouterMedecinOkayListener(ActionListener listenForOkay) {
		okayButton_ajouterMedecin.addActionListener(listenForOkay);
	}
	public void supprimerMedecinOkayListener(ActionListener listenForOkay) {
		okayButton_supprimerMedecin.addActionListener(listenForOkay);
	}
	//méthode de centrage des fenêtres
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
	
	//getters
	public JTable getTable() {
		return this.table;
	}
	public DefaultTableModel getTableModelMedecins() {
		return tableModelMedecins;
	}
	public DefaultTableModel getTableModelAgAdmins() {
		return tableModelAgAdmins;
	}
	public JButton getOkayButton_ajouterMedecin() {
		return this.okayButton_ajouterMedecin;
	}
	public JButton getOkayButton_supprimerMedecin() {
		return this.okayButton_supprimerMedecin;
	}
	public JDialog getAjouterMedecinDialog() {
		return this.ajouterMedecinDialog;
	}
	public JDialog getSupprimerMedecinDialog() {
		return this.supprimerMedecinDialog;
	}
	public JButton getAjouter() {
		return this.ajouterMedecin;
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
	public JTextField getService() {
		return this.service;
	}
	public JTextField getMdp() {
		return this.mdp;
	}
	

}