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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import leo.labatut.projet.model.AgentAdmin;
import leo.labatut.projet.model.Infirmier;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Pathologie;
import leo.labatut.projet.model.Patient;
import leo.labatut.projet.model.Service;
import leo.labatut.projet.model.Technicien;


public class InterfaceSuperAdmin extends JFrame {
	
	private JButton deconnexion = new JButton("Déconnexion");
	private JPanel deconnexionPan = new JPanel();
	
	private JDialog ajouterDialogMedecin =new JDialog(this,"Ajouter un Medecin");
	private JDialog supprimerDialogMedecin =new JDialog(this,"Supprimer un Medecin");
	private JDialog updateDialogMedecin =new JDialog(this,"Mettre à jour un Medecin");
	
	private JDialog ajouterDialogInfirmier =new JDialog(this,"Ajouter un Infirmier");
	private JDialog supprimerDialogInfirmier =new JDialog(this,"Supprimer un Infirmier");
	private JDialog updateDialogInfirmier =new JDialog(this,"Mettre à jour un Infirmier");
	
	private JDialog ajouterDialogAgAdmin =new JDialog(this,"Ajouter un AgAdmin");
	private JDialog supprimerDialogAgAdmin =new JDialog(this,"Supprimer un AgAdmin");
	private JDialog updateDialogAgAdmin =new JDialog(this,"Mettre à jour un AgAdmin");
	
	private JDialog ajouterDialogTechnicien =new JDialog(this,"Ajouter un Technicien");
	private JDialog supprimerDialogTechnicien =new JDialog(this,"Supprimer un Technicien");
	private JDialog updateDialogTechnicien =new JDialog(this,"Mettre à jour un Technicien");

	private GridBagConstraints c = new GridBagConstraints();
	
	private JPanel mainPanel = new JPanel(new BorderLayout());
	private JPanel buttonPanelMedecin = new JPanel(new GridBagLayout());
	private JPanel buttonPanelInfirmier = new JPanel(new GridBagLayout());
	private JPanel buttonPanelAgAdmin = new JPanel(new GridBagLayout());
	private JPanel buttonPanelTechnicien= new JPanel(new GridBagLayout());

	private JScrollPane scPaneMedecin =new JScrollPane();
	private JScrollPane scPaneAgAdmin =new JScrollPane();
	private JScrollPane scPaneInfirmier =new JScrollPane();
	private JScrollPane scPaneTechnicien =new JScrollPane();
	
	private JSplitPane splitPaneMedecins = new JSplitPane();
	private JSplitPane splitPaneInfirmiers = new JSplitPane();
	private JSplitPane splitPaneAgAdmins = new JSplitPane();
	private JSplitPane splitPaneTechnicien = new JSplitPane();
	
	private JTextField id= new JTextField(15);
	private JTextField nom= new JTextField(15);
	private JTextField prenom= new JTextField(15);
	private JTextField dateNaissance= new JTextField(15);
	private JTextField sexe= new JTextField(15);
	private JTextField service= new JTextField(15);
	private JTextField email= new JTextField(15);
	private JTextField mdp=new JPasswordField(15);
	
	private JLabel nomArea = new JLabel("Nom : ");
	private JLabel prenomArea = new JLabel("Prénom : ");
	private JLabel dateNaissanceArea = new JLabel("Date de naissance(dd/MM/yyyy) : ");
	private JLabel sexeArea = new JLabel("Sexe (M/F): ");
	private JLabel serviceArea = new JLabel("Service : ");
	private JLabel emailArea = new JLabel("E-mail : ");
	private JLabel mdpArea = new JLabel("Mot de passe : ");
	
	private JButton ajouterMedecin = new JButton("Ajouter");
	private JButton supprimerMedecin = new JButton("Supprimer");
	private JButton updateMedecin = new JButton("Mise à jour");
	private JButton ajouterInfirmier = new JButton("Ajouter");
	private JButton supprimerInfirmier = new JButton("Supprimer");
	private JButton updateInfirmier = new JButton("Mise à jour");
	private JButton ajouterAgAdmin = new JButton("Ajouter");
	private JButton supprimerAgAdmin = new JButton("Supprimer");
	private JButton updateAgAdmin= new JButton("Mise à jour");
	private JButton ajouterTechnicien = new JButton("Ajouter");
	private JButton supprimerTechnicien = new JButton("Supprimer");
	private JButton updateTechnicien = new JButton("Mise à jour");
	
	
	private JButton okayButton_ajouterMedecin = new JButton("OK");
	private JButton okayButton_supprimerMedecin = new JButton("OK");
	private JButton okayButton_updateMedecin = new JButton("OK");
	private JButton okayButton_ajouterInfirmier = new JButton("OK");
	private JButton okayButton_supprimerInfirmier = new JButton("OK");
	private JButton okayButton_updateInfirmier = new JButton("OK");
	private JButton okayButton_ajouterAgAdmin= new JButton("OK");
	private JButton okayButton_supprimerAgAdmin = new JButton("OK");
	private JButton okayButton_updateAgAdmin = new JButton("OK");
	private JButton okayButton_ajouterTechnicien= new JButton("OK");
	private JButton okayButton_supprimerTechnicien = new JButton("OK");
	private JButton okayButton_updateTechnicien = new JButton("OK");

	
	
	private JPanel dialogPan_ajouterMedecin=new JPanel();
	private JPanel dialogPan_supprimerMedecin=new JPanel();
	private JPanel dialogPan_updateMedecin=new JPanel();
	
	private JPanel dialogPan_ajouterInfirmier=new JPanel();
	private JPanel dialogPan_supprimerInfirmier=new JPanel();
	private JPanel dialogPan_updateInfirmier=new JPanel();
	
	private JPanel dialogPan_ajouterAgAdmin=new JPanel();
	private JPanel dialogPan_supprimerAgAdmin=new JPanel();
	private JPanel dialogPan_updateAgAdmin=new JPanel();
	
	private JPanel dialogPan_ajouterTechnicien=new JPanel();
	private JPanel dialogPan_supprimerTechnicien=new JPanel();
	private JPanel dialogPan_updateTechnicien=new JPanel();
	
	private JTable table;
	
	private String colMed[] = {"Id","Nom","Prénom","Service"};
	private String colAg[] = {"Id","Nom","Prénom"};
	private String colInf[] = {"Id","Nom","Prénom"};
	private String colTec[] = {"Id","Nom","Prénom"};
	
	private DefaultTableModel tableModelMedecins;
	private DefaultTableModel tableModelAgAdmins;
	private DefaultTableModel tableModelInfirmiers;
	private DefaultTableModel tableModelTechniciens;
	
	private JTabbedPane tabbedPane= new JTabbedPane();
	
	private JList medecins;
	private JScrollPane scPaneListMedecins = new JScrollPane();
 	private JTextField medecin = new JTextField(15);
 	
	private JList infirmiers;
	private JScrollPane scPaneListInfirmiers = new JScrollPane();
	private JTextField infirmier = new JTextField(15);
	
	private JList agAdmins;
	private JScrollPane scPaneListAgAdmin = new JScrollPane();
	private JTextField agAdmin = new JTextField(15);
	
	private JList techniciens;
	private JScrollPane scPaneListTechniciens = new JScrollPane();
	private JTextField technicien = new JTextField(15);
		
	private JList services;
	private JScrollPane scPaneListService = new JScrollPane();
	/**
	 * constructeur
	 */
	public InterfaceSuperAdmin() {
		
		this.setTitle ("Interface Super Admin") ;
		this.setSize (new Dimension (700, 450)) ;
        this.getContentPane().add(mainPanel);
        
        this.deconnexionPan.add(deconnexion);
        this.mainPanel.add(deconnexionPan,BorderLayout.PAGE_START);
        this.mainPanel.add(tabbedPane,BorderLayout.CENTER);
        
        /*
         * onglet infirmiers
         */
        tabbedPane.addTab("Infirmiers",splitPaneInfirmiers);
        scPaneInfirmier.setPreferredSize(new Dimension(450, 300));
        splitPaneInfirmiers.setLeftComponent(scPaneInfirmier);
        

		ajouterInfirmier.addActionListener(new AjouterInfirmierListener());
		supprimerInfirmier.addActionListener(new SupprimerInfirmierListener());
		updateInfirmier.addActionListener(new UpdateInfirmierListener());
        
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=0;
        buttonPanelInfirmier.add(ajouterInfirmier,c);
        
        c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=1;
		buttonPanelInfirmier.add(supprimerInfirmier,c);
		
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=3;
		buttonPanelInfirmier.add(updateInfirmier,c);
		splitPaneInfirmiers.setRightComponent(buttonPanelInfirmier);
        
        /*
         * onglet agent d'administration
         */
        tabbedPane.addTab("Agents d'Administration",splitPaneAgAdmins);
        scPaneAgAdmin.setPreferredSize(new Dimension(450, 300));
        splitPaneAgAdmins.setLeftComponent(scPaneAgAdmin);
        
        ajouterAgAdmin.addActionListener(new AjouterAgAdminListener());
        supprimerAgAdmin.addActionListener(new SupprimerAgAdminListener());
        updateAgAdmin.addActionListener(new UpdateAgAdminListener());
        
        c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=0;
        buttonPanelAgAdmin.add(ajouterAgAdmin,c);
        
        c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=1;
		buttonPanelAgAdmin.add(supprimerAgAdmin,c);
		
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=2;
		buttonPanelAgAdmin.add(updateAgAdmin,c);
		splitPaneAgAdmins.setRightComponent(buttonPanelAgAdmin);
        
        /*
         * onglet médecins
         */
        tabbedPane.addTab("Medecins",splitPaneMedecins);
        scPaneMedecin.setPreferredSize(new Dimension(450, 300));
        splitPaneMedecins.setLeftComponent(scPaneMedecin);
        updateMedecin.addActionListener(new UpdateMedecinListener());
        
        ajouterMedecin.addActionListener(new AjouterMedecinListener());
		supprimerMedecin.addActionListener(new SupprimerMedecinListener());
        
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=0;
        buttonPanelMedecin.add(ajouterMedecin,c);
        
        c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=1;
		buttonPanelMedecin.add(supprimerMedecin,c);
		
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=2;
		buttonPanelMedecin.add(updateMedecin,c);
		splitPaneMedecins.setRightComponent(buttonPanelMedecin);
		
		
        
        /*
         * onglet techniciens
         */
        tabbedPane.addTab("Techniciens",splitPaneTechnicien);
        scPaneTechnicien.setPreferredSize(new Dimension(450, 300));
        splitPaneTechnicien.setLeftComponent(scPaneTechnicien);
        
        ajouterTechnicien.addActionListener(new AjouterTechnicienListener());
		supprimerTechnicien.addActionListener(new SupprimerTechnicienListener());
		updateTechnicien.addActionListener(new UpdateTechnicienListener());
        
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=0;
        buttonPanelTechnicien.add(ajouterTechnicien,c);
        
        c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=1;
		buttonPanelTechnicien.add(supprimerTechnicien,c);
		
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx =0;
		c.gridy=3;
		buttonPanelTechnicien.add(updateTechnicien,c);
		splitPaneTechnicien.setRightComponent(buttonPanelTechnicien);   
		
		centreWindow((Window)this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * rempli la JTable medecins
	 * @param list
	 */
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
	/**
	 * rempli la JTable technicien
	 * @param list
	 */
	public void fillTableTechnicien(ArrayList<Technicien>list) {
		this.tableModelTechniciens = new DefaultTableModel(colTec, 0);
		this.table = new JTable(tableModelTechniciens);
		
		for (int i = 0; i < list.size(); i++){
			int id = list.get(i).getId(); 
			String nom = list.get(i).getNom();
			String prenom = list.get(i).getPrenom();
			
			Object[] data = {id, nom, prenom};
			tableModelTechniciens.addRow(data);
		}
		
		scPaneTechnicien.setViewportView(table);
				 
	}
	/**
	 * rempli la JTable agents d'adminisitration
	 * @param list
	 */
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
	/**
	 * rempli la JTable infirmiers
	 * @param list
	 */
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
	
	//remplir les Jlists des dialogues de suppression
	/**
	 * rempli la Jlist medecins
	 * @param list
	 */
	public void fillListMedecin(ArrayList<Medecin>list) {
		
		String[]tabMedecins= new String[list.size()];
		
		for(int i=0; i<list.size();i++) {
			tabMedecins[i]=list.get(i).getId()+" "+list.get(i).getNom()+" "+list.get(i).getPrenom();
		}
		this.medecins= new JList(tabMedecins);
		this.scPaneListMedecins=new JScrollPane(medecins);
	}
	/**
	 * rempli le JList infirmier
	 * @param list
	 */
	public void fillListInfirmier(ArrayList<Infirmier>list) {
		
		String[]tabInfirmiers= new String[list.size()];
		
		for(int i=0; i<list.size();i++) {
			tabInfirmiers[i]=list.get(i).getId()+" "+list.get(i).getNom()+" "+list.get(i).getPrenom();
		}
		this.infirmiers= new JList(tabInfirmiers);
		
	}
	/**
	 * rempli la Jlist agents d' administration
	 * @param list
	 */
	public void fillListAgAdmin(ArrayList<AgentAdmin>list) {
		
		String[]tabAgAdmins= new String[list.size()];
		
		for(int i=0; i<list.size();i++) {
			tabAgAdmins[i]=list.get(i).getId()+" "+list.get(i).getNom()+" "+list.get(i).getPrenom();
		}
		this.agAdmins= new JList(tabAgAdmins);
		
	}
	/**
	 * rempli la JList technciens
	 * @param list
	 */
	public void fillListTechnicien(ArrayList<Technicien>list) {
		
		String[]tabTechniciens= new String[list.size()];
		
		for(int i=0; i<list.size();i++) {
			tabTechniciens[i]=list.get(i).getId()+" "+list.get(i).getNom()+" "+list.get(i).getPrenom();
		}
		this.techniciens= new JList(tabTechniciens);
		
	}
	/**
	 * rempli la Jlist Services
	 * @param list
	 */
	public void fillListService(ArrayList<Service>list) {
		
		String[]tabServices= new String[list.size()];
		
		for(int i=0; i<list.size();i++) {
			tabServices[i]=list.get(i).getId()+" "+list.get(i).getNom();
		}
		this.services= new JList(tabServices);
		this.scPaneListService=new JScrollPane(services);
	}
	
	/*
	 * classes  ActionListener
	 */
	/**
	 * ouvre un dialogue d'ajout de medecin
	 * @author User
	 *
	 */
	class AjouterMedecinListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			services.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                	service.setText(services.getSelectedValue().toString());
	              }
	         }
	    });
			
			//fenêtre de dialogue ajouter medecin
			dialogPan_ajouterMedecin.removeAll();
			dialogPan_ajouterMedecin.add(nomArea);
			dialogPan_ajouterMedecin.add(nom);
			dialogPan_ajouterMedecin.add(prenomArea);
			dialogPan_ajouterMedecin.add(prenom);
			dialogPan_ajouterMedecin.add(dateNaissanceArea);
			dialogPan_ajouterMedecin.add(dateNaissance);
			dialogPan_ajouterMedecin.add(sexeArea);
			dialogPan_ajouterMedecin.add(sexe);
			
			dialogPan_ajouterMedecin.add(scPaneListService);
			
			dialogPan_ajouterMedecin.add(serviceArea);
			dialogPan_ajouterMedecin.add(service);
			dialogPan_ajouterMedecin.add(emailArea);
			dialogPan_ajouterMedecin.add(email);
			dialogPan_ajouterMedecin.add(mdpArea);
			dialogPan_ajouterMedecin.add(mdp);
			
			
			dialogPan_ajouterMedecin.add(okayButton_ajouterMedecin );
			                 
			ajouterDialogMedecin.add(dialogPan_ajouterMedecin);	
			ajouterDialogMedecin.setSize(new Dimension(250,500));
			centreWindow((Window)ajouterDialogMedecin);
			ajouterDialogMedecin.setVisible(true);
					
		}
		
	}
	/**
	 * ouvre un dialogue de suppression de medecin
	 * @author User
	 *
	 */
	class SupprimerMedecinListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			medecins.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                	medecin.setText(medecins.getSelectedValue().toString());
	              }
	         }
	    });
			
			//fenêtre de dialogue supprimer
			dialogPan_supprimerMedecin.removeAll();
			dialogPan_supprimerMedecin.add(scPaneListMedecins);
			dialogPan_supprimerMedecin.add(medecin);
			dialogPan_supprimerMedecin.add(okayButton_supprimerMedecin);
			
			supprimerDialogMedecin.add(dialogPan_supprimerMedecin);	
			supprimerDialogMedecin.setSize(new Dimension(200,450));
			
			centreWindow((Window)supprimerDialogMedecin);
			supprimerDialogMedecin.setVisible(true);
					
		}
		
	}
	/**
	 * ouvre un dialogue de mise à jour de medecin
	 * @author User
	 *
	 */
	class UpdateMedecinListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			medecins.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                	medecin.setText(medecins.getSelectedValue().toString());
	              }
	         }
	    });
			services.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                	service.setText(services.getSelectedValue().toString());
	              }
	         }
	    });
			
			//fenêtre de dialogue update medecin
			dialogPan_updateMedecin.removeAll();
			dialogPan_updateMedecin.add(scPaneListMedecins);
			dialogPan_updateMedecin.add(medecin);
			dialogPan_updateMedecin.add(scPaneListService);
			
			
			dialogPan_updateMedecin.add(serviceArea);
			dialogPan_updateMedecin.add(service);
			dialogPan_updateMedecin.add(emailArea);
			dialogPan_updateMedecin.add(email);
			dialogPan_updateMedecin.add(mdpArea);
			dialogPan_updateMedecin.add(mdp);
			
			
			dialogPan_updateMedecin.add(okayButton_updateMedecin );
			                 
			updateDialogMedecin.add(dialogPan_updateMedecin);	
			updateDialogMedecin.setSize(new Dimension(200,450));
			centreWindow((Window)updateDialogMedecin);
			updateDialogMedecin.setVisible(true);
					
		}
		
	}
	/**
	 * ouvre un dialogue ajouter infirmier
	 * @author User
	 *
	 */
	class AjouterInfirmierListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//fenêtre de dialogue ajouter medecin
			
			dialogPan_ajouterInfirmier.removeAll();
			dialogPan_ajouterInfirmier.add(nomArea);
			dialogPan_ajouterInfirmier.add(nom);
			dialogPan_ajouterInfirmier.add(prenomArea);
			dialogPan_ajouterInfirmier.add(prenom);
			dialogPan_ajouterInfirmier.add(dateNaissanceArea);
			dialogPan_ajouterInfirmier.add(dateNaissance);
			dialogPan_ajouterInfirmier.add(sexeArea);
			dialogPan_ajouterInfirmier.add(sexe);			
			dialogPan_ajouterInfirmier.add(emailArea);
			dialogPan_ajouterInfirmier.add(email);
			dialogPan_ajouterInfirmier.add(mdpArea);
			dialogPan_ajouterInfirmier.add(mdp);
			
			
			dialogPan_ajouterInfirmier.add(okayButton_ajouterInfirmier );
			                 
			ajouterDialogInfirmier.add(dialogPan_ajouterInfirmier);	
			ajouterDialogInfirmier.setSize(new Dimension(200,450));
			centreWindow((Window)ajouterDialogInfirmier);
			ajouterDialogInfirmier.setVisible(true);
					
		}
		
	}
	/**
	 * ouvre un dialogue supprimer infirmier
	 * @author User
	 *
	 */
	class SupprimerInfirmierListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			infirmiers.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                	infirmier.setText(infirmiers.getSelectedValue().toString());
	              }
	         }
	    });
			
			//fenêtre de dialogue supprimer
			dialogPan_supprimerInfirmier.removeAll();
			dialogPan_supprimerInfirmier.add(infirmiers);
			dialogPan_supprimerInfirmier.add(infirmier);
			dialogPan_supprimerInfirmier.add(okayButton_supprimerInfirmier);
			
			supprimerDialogInfirmier.add(dialogPan_supprimerInfirmier);	
			supprimerDialogInfirmier.setSize(new Dimension(200,450));
			
			centreWindow((Window)supprimerDialogInfirmier);
			supprimerDialogInfirmier.setVisible(true);
					
		}
		
	}
	/**
	 * ouvre un dialogue mise à jour infirmier
	 * @author User
	 *
	 */
	class UpdateInfirmierListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			infirmiers.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                	infirmier.setText(infirmiers.getSelectedValue().toString());
	              }
	         }
	    });
			
			//fenêtre de dialogue ajouter medecin
			
			dialogPan_updateInfirmier.removeAll();
			dialogPan_updateInfirmier.add(infirmiers);
			dialogPan_updateInfirmier.add(infirmier);

			dialogPan_updateInfirmier.add(emailArea);
			dialogPan_updateInfirmier.add(email);
			dialogPan_updateInfirmier.add(mdpArea);
			dialogPan_updateInfirmier.add(mdp);
			
			
			dialogPan_updateInfirmier.add(okayButton_updateInfirmier );
			                 
			updateDialogInfirmier.add(dialogPan_updateInfirmier);	
			updateDialogInfirmier.setSize(new Dimension(200,450));
			centreWindow((Window)updateDialogInfirmier);
			updateDialogInfirmier.setVisible(true);
					
		}
		
	}
	/**
	 * ouvre un dialogue ajouter agent d'administration
	 * @author User
	 *
	 */
	class AjouterAgAdminListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//fenêtre de dialogue ajouter medecin
			
			dialogPan_ajouterAgAdmin.removeAll();
			dialogPan_ajouterAgAdmin.add(nomArea);
			dialogPan_ajouterAgAdmin.add(nom);
			dialogPan_ajouterAgAdmin.add(prenomArea);
			dialogPan_ajouterAgAdmin.add(prenom);
			dialogPan_ajouterAgAdmin.add(dateNaissanceArea);
			dialogPan_ajouterAgAdmin.add(dateNaissance);
			dialogPan_ajouterAgAdmin.add(sexeArea);
			dialogPan_ajouterAgAdmin.add(sexe);			
			dialogPan_ajouterAgAdmin.add(emailArea);
			dialogPan_ajouterAgAdmin.add(email);
			dialogPan_ajouterAgAdmin.add(mdpArea);
			dialogPan_ajouterAgAdmin.add(mdp);
			
			
			dialogPan_ajouterAgAdmin.add(okayButton_ajouterAgAdmin );
			                 
			ajouterDialogAgAdmin.add(dialogPan_ajouterAgAdmin);	
			ajouterDialogAgAdmin.setSize(new Dimension(200,450));
			centreWindow((Window)ajouterDialogAgAdmin);
			ajouterDialogAgAdmin.setVisible(true);
					
		}
		
	}
	/**
	 * ouvre un dialogue supprimer agent d'administration
	 * @author User
	 *
	 */
	class SupprimerAgAdminListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			agAdmins.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                	agAdmin.setText(agAdmins.getSelectedValue().toString());
	              }
	         }
	    });
			
			//fenêtre de dialogue supprimer
			
			dialogPan_supprimerAgAdmin.removeAll();
			dialogPan_supprimerAgAdmin.add(agAdmins);
			dialogPan_supprimerAgAdmin.add(agAdmin);
			dialogPan_supprimerAgAdmin.add(okayButton_supprimerAgAdmin);
			
			supprimerDialogAgAdmin.add(dialogPan_supprimerAgAdmin);	
			supprimerDialogAgAdmin.setSize(new Dimension(200,450));
			
			centreWindow((Window)supprimerDialogAgAdmin);
			supprimerDialogAgAdmin.setVisible(true);
					
		}
		
	}
	/**
	 * ouvre un dialogue mise à jour agent d'administration
	 * @author User
	 *
	 */
	class UpdateAgAdminListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			agAdmins.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                	agAdmin.setText(agAdmins.getSelectedValue().toString());
	              }
	         }
	    });
			
			//fenêtre de dialogue ajouter medecin
			
			dialogPan_updateAgAdmin.removeAll();
			dialogPan_updateAgAdmin.add(agAdmins);
			dialogPan_updateAgAdmin.add(agAdmin);
			
			dialogPan_updateAgAdmin.add(emailArea);
			dialogPan_updateAgAdmin.add(email);
			dialogPan_updateAgAdmin.add(mdpArea);
			dialogPan_updateAgAdmin.add(mdp);
			
			
			dialogPan_updateAgAdmin.add(okayButton_updateAgAdmin );
			                 
			updateDialogAgAdmin.add(dialogPan_updateAgAdmin);	
			updateDialogAgAdmin.setSize(new Dimension(200,450));
			centreWindow((Window)updateDialogAgAdmin);
			updateDialogAgAdmin.setVisible(true);
					
		}
		
	}
	/**
	 * ouvre un dialogue ajouter technicien
	 * @author User
	 *
	 */
	class AjouterTechnicienListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//fenêtre de dialogue ajouter medecin
			dialogPan_ajouterTechnicien.removeAll();
			dialogPan_ajouterTechnicien.add(nomArea);
			dialogPan_ajouterTechnicien.add(nom);
			dialogPan_ajouterTechnicien.add(prenomArea);
			dialogPan_ajouterTechnicien.add(prenom);
			dialogPan_ajouterTechnicien.add(dateNaissanceArea);
			dialogPan_ajouterTechnicien.add(dateNaissance);
			dialogPan_ajouterTechnicien.add(sexeArea);
			dialogPan_ajouterTechnicien.add(sexe);			
			dialogPan_ajouterTechnicien.add(emailArea);
			dialogPan_ajouterTechnicien.add(email);
			dialogPan_ajouterTechnicien.add(mdpArea);
			dialogPan_ajouterTechnicien.add(mdp);
			
			
			dialogPan_ajouterTechnicien.add(okayButton_ajouterTechnicien );
			                 
			ajouterDialogTechnicien.add(dialogPan_ajouterTechnicien);	
			ajouterDialogTechnicien.setSize(new Dimension(200,450));
			centreWindow((Window)ajouterDialogTechnicien);
			ajouterDialogTechnicien.setVisible(true);
					
		}
		
	}
	/**
	 * ouvre un dialogue supprimer technicien
	 * @author User
	 *
	 */
	class SupprimerTechnicienListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			techniciens.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                	technicien.setText(techniciens.getSelectedValue().toString());
	              }
	         }
	    });
			
			//fenêtre de dialogue supprimer
			dialogPan_supprimerTechnicien.removeAll();
			dialogPan_supprimerTechnicien.add(techniciens);
			dialogPan_supprimerTechnicien.add(technicien);
			dialogPan_supprimerTechnicien.add(okayButton_supprimerTechnicien);
			
			supprimerDialogTechnicien.add(dialogPan_supprimerTechnicien);	
			supprimerDialogTechnicien.setSize(new Dimension(200,450));
			
			centreWindow((Window)supprimerDialogTechnicien);
			supprimerDialogTechnicien.setVisible(true);
					
		}
		
	}
	/**
	 * ouvre un dialogue mise à jour technicien
	 * @author User
	 *
	 */
	class UpdateTechnicienListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			techniciens.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                	technicien.setText(techniciens.getSelectedValue().toString());
	              }
	         }
	    });
			//fenêtre de dialogue ajouter medecin
			dialogPan_updateTechnicien.removeAll();
			dialogPan_updateTechnicien.add(techniciens);
			dialogPan_updateTechnicien.add(technicien);
		
			dialogPan_updateTechnicien.add(emailArea);
			dialogPan_updateTechnicien.add(email);
			dialogPan_updateTechnicien.add(mdpArea);
			dialogPan_updateTechnicien.add(mdp);
			
			
			dialogPan_updateTechnicien.add(okayButton_updateTechnicien );
			                 
			updateDialogTechnicien.add(dialogPan_updateTechnicien);	
			updateDialogTechnicien.setSize(new Dimension(200,450));
			centreWindow((Window)updateDialogTechnicien);
			updateDialogTechnicien.setVisible(true);
					
		}
		
	}
	
	/*
	 * listener medecin
	 */
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
	public void UpdateMedecinListener(ActionListener listenForSupprimer){
		updateMedecin.addActionListener(listenForSupprimer);
	}
	public void UpdateMedecinOkayListener(ActionListener listenForOkay) {
		okayButton_updateMedecin.addActionListener(listenForOkay);
	}
	
/*
 * listener infirmier
 */
	public void ajouterInfirmierListener(ActionListener listenForAjouter){
		ajouterInfirmier.addActionListener(listenForAjouter);
	}
	
	public void supprimerInfirmierListener(ActionListener listenForSupprimer){
		supprimerInfirmier.addActionListener(listenForSupprimer);
	}
	public void ajouterInfirmierOkayListener(ActionListener listenForOkay) {
		okayButton_ajouterInfirmier.addActionListener(listenForOkay);
	}
	public void supprimerInfirmierOkayListener(ActionListener listenForOkay) {
		okayButton_supprimerInfirmier.addActionListener(listenForOkay);
	}
	public void UpdateInfirmierListener(ActionListener listenForSupprimer){
		updateInfirmier.addActionListener(listenForSupprimer);
	}
	public void UpdateInfirmierOkayListener(ActionListener listenForOkay) {
		okayButton_updateInfirmier.addActionListener(listenForOkay);
	}
	
	/*
	 * listener agAdmin
	 */
	public void ajouterAgAdminListener(ActionListener listenForAjouter){
		ajouterAgAdmin.addActionListener(listenForAjouter);
	}
		
	public void supprimerAgAdminListener(ActionListener listenForSupprimer){
		supprimerAgAdmin.addActionListener(listenForSupprimer);
	}
	public void ajouterAgAdminOkayListener(ActionListener listenForOkay) {
		okayButton_ajouterAgAdmin.addActionListener(listenForOkay);
	}
	public void supprimerAgAdminOkayListener(ActionListener listenForOkay) {
		okayButton_supprimerAgAdmin.addActionListener(listenForOkay);
	}
	public void UpdateAgAdminListener(ActionListener listenForSupprimer){
		updateAgAdmin.addActionListener(listenForSupprimer);
	}
	public void UpdateAgAdminOkayListener(ActionListener listenForOkay) {
		okayButton_updateAgAdmin.addActionListener(listenForOkay);
	}
	
	/*
	 * lsitener technicien
	 */
	public void ajouterTechnicienListener(ActionListener listenForAjouter){
		ajouterTechnicien.addActionListener(listenForAjouter);
	}
			
	public void supprimerTechnicienListener(ActionListener listenForSupprimer){
		supprimerTechnicien.addActionListener(listenForSupprimer);
	}
	public void ajouterTechnicienOkayListener(ActionListener listenForOkay) {
		okayButton_ajouterTechnicien.addActionListener(listenForOkay);
	}
	public void supprimerTechnicienOkayListener(ActionListener listenForOkay) {
		okayButton_supprimerTechnicien.addActionListener(listenForOkay);
	}
	public void UpdateTechnicienListener(ActionListener listenForSupprimer){
		updateTechnicien.addActionListener(listenForSupprimer);
	}
	public void UpdateTechnicienOkayListener(ActionListener listenForOkay) {
		okayButton_updateTechnicien.addActionListener(listenForOkay);
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
	
	/*
	 * getters table model
	 */
	public JTable getTable() {
		return this.table;
	}
	public DefaultTableModel getTableModelMedecins() {
		return tableModelMedecins;
	}
	public DefaultTableModel getTableModelInfirmiers() {
		return tableModelInfirmiers;
	}
	public DefaultTableModel getTableModelAgAdmins() {
		return tableModelAgAdmins;
	}
	public DefaultTableModel getTableModelTechnicien() {
		return tableModelTechniciens;
	}

	/*
	 * getters boutons
	 */
	//medecins
	public JButton getAjouter() {
		return this.ajouterMedecin;
	}
	public JButton getOkayButton_ajouterMedecin() {
		return this.okayButton_ajouterMedecin;
	}
	public JButton getOkayButton_supprimerMedecin() {
		return this.okayButton_supprimerMedecin;
	}
	public JButton getOkayButton_updateMedecin() {
		return this.okayButton_updateMedecin;
	}
	//infirmier
	public JButton getOkayButton_ajouterInfirmier() {
		return this.okayButton_ajouterInfirmier;
	}
	public JButton getOkayButton_supprimerInfirmier() {
		return this.okayButton_supprimerInfirmier;
	}
	public JButton getOkayButton_updateInfirmier() {
		return this.okayButton_updateInfirmier;
	}
	//agadmin
	public JButton getOkayButton_ajouterAgAdmin() {
		return this.okayButton_ajouterAgAdmin;
	}
	public JButton getOkayButton_supprimerAgAdmin() {
		return this.okayButton_supprimerAgAdmin;
	}
	public JButton getOkayButton_updateAgAdmin() {
		return this.okayButton_updateAgAdmin;
	}
	//tec
	public JButton getOkayButton_ajouterTechnicien() {
		return this.okayButton_ajouterTechnicien;
	}
	public JButton getOkayButton_supprimerTechnicien() {
		return this.okayButton_supprimerTechnicien;
	}
	public JButton getOkayButton_updateTechnicien() {
		return this.okayButton_updateTechnicien;
	}
	public JButton getDeconnexionButton() {
		return this.deconnexion;
	}
	
	/*
	 * getters dialogues
	 */
	public JDialog getAjouterDialogAgAdmin() {
		return this.ajouterDialogAgAdmin;
	}
	public JDialog getSupprimerDialogAgAdmin() {
		return this.supprimerDialogAgAdmin;
	}
	public JDialog getUpdateDialogAgAdmin() {
		return this.updateDialogAgAdmin;
	}
	
	public JDialog getAjouterDialogMedecin() {
		return this.ajouterDialogMedecin;
	}
	public JDialog getUpdateDialogMedecin() {
		return this.updateDialogMedecin;
	}
	public JDialog getSupprimerDialogMedecin() {
		return this.supprimerDialogMedecin;
	}
	public JDialog getAjouterDialogInfirmier() {
		return this.ajouterDialogInfirmier;
	}
	public JDialog getSupprimerDialogInfirmier() {
		return this.supprimerDialogInfirmier;
	}
	public JDialog getUpdateDialogInfirmier() {
		return this.updateDialogInfirmier;
	}
	
	public JDialog getAjouterDialogTechnicien() {
		return this.ajouterDialogTechnicien;
	}
	public JDialog getUpdateDialogTechnicien() {
		return this.updateDialogTechnicien;
	}
	public JDialog getSupprimerDialogTechnicien() {
		return this.supprimerDialogTechnicien;
	}
	
	
	/*
	 * getters textfields
	 */
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
	
	/*
	 * getters des champs de suppression
	 */
	public JTextField getMedecin() {
		return this.medecin;
	}
	public JTextField getInfirmier() {
		return this.infirmier;
	}
	public JTextField getAgAdmin() {
		return this.agAdmin;
	}
	public JTextField getTechnicien() {
		return this.technicien;
	}	
	
	/*
	 * getteres dialogue panel
	 */
	public JPanel getDialogPan_ajouterMedecin() {
		return this.dialogPan_ajouterMedecin;
	}
	public JPanel getDialogPan_supprimerMedecin() {
		return this.dialogPan_supprimerMedecin;
	}
	public JPanel getDialogPan_ajouterInfirmier() {
		return this.dialogPan_ajouterInfirmier;
	}
	public JPanel getDialogPan_supprimerInfirmier() {
		return this.dialogPan_supprimerInfirmier;
	}
	public JPanel getDialogPan_ajouterAgAdmin() {
		return this.dialogPan_ajouterAgAdmin;
	}
	public JPanel getDialogPan_supprimerAgAdmin() {
		return this.dialogPan_supprimerAgAdmin;
	}
	public JPanel getDialogPan_ajouterTechnicien() {
		return this.dialogPan_ajouterTechnicien;
	}
	public JPanel getDialogPan_supprimerTechnicien() {
		return this.dialogPan_supprimerTechnicien;
	}		

}