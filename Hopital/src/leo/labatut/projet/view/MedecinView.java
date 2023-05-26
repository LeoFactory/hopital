package leo.labatut.projet.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import leo.labatut.projet.model.Medecin;


public class MedecinView extends JFrame {
	
	private JButton ajouter = new JButton("Ajouter");
	private JButton supprimer = new JButton("Supprimer");
	
	private JDialog ajouterDialog =new JDialog(this,"Ajouter un Medecin");
	private JDialog supprimerDialog =new JDialog(this,"Supprimer un Medecin");

	private JPanel buttonPanel = new JPanel();
	private JScrollPane scPane =new JScrollPane();
	private JSplitPane splitPane = new JSplitPane();
	
	private JTextField id= new JTextField(15);
	private JTextField nom= new JTextField(15);
	private JTextField prenom= new JTextField(15);
	private JTextField dateNaissance= new JTextField(15);
	private JTextField sexe= new JTextField(15);
	private JTextField service= new JTextField(15);
	private JTextField email= new JTextField(15);
	private JTextField mdp=new JPasswordField(15);
	
	private JButton okayButton_ajouter = new JButton("OK");
	private JButton okayButton_supprimer = new JButton("OK");
	
	
	private JPanel dialogPan_ajouter=new JPanel();
	private JPanel dialogPan_supprimer=new JPanel();
	
	private JTable table;
	private String col[] = {"Id","Nom","Prénom","Service"};
	private DefaultTableModel tableModel;
	
	public MedecinView() {
		
		
		ajouter.addActionListener(new AjouterListener());
		supprimer.addActionListener(new SupprimerListener());
		
        this.getContentPane().add(splitPane);
        
        scPane.setPreferredSize(new Dimension(450, 300));
        splitPane.setLeftComponent(scPane);
        
        
		this.setTitle ("Medecins") ;
		this.setSize (new Dimension (700, 450)) ;
		
		buttonPanel.add(ajouter);
		buttonPanel.add(supprimer);
		splitPane.setRightComponent(buttonPanel);
		//fenêtre de dialogue ajouter
		dialogPan_ajouter.add(new JTextArea("Nom"));
		dialogPan_ajouter.add(nom);
		dialogPan_ajouter.add(new JTextArea("Prénom"));
		dialogPan_ajouter.add(prenom);
		dialogPan_ajouter.add(new JTextArea("Date de naissance"));
		dialogPan_ajouter.add(dateNaissance);
		dialogPan_ajouter.add(new JTextArea("Sexe"));
		dialogPan_ajouter.add(sexe);
		dialogPan_ajouter.add(new JTextArea("Service"));
		dialogPan_ajouter.add(service);
		dialogPan_ajouter.add(new JTextArea("email"));
		dialogPan_ajouter.add(email);
		dialogPan_ajouter.add(new JTextArea("mot de passe"));
		dialogPan_ajouter.add(mdp);
		
		
		dialogPan_ajouter.add(okayButton_ajouter );
		                 
		ajouterDialog.add(dialogPan_ajouter);	
		ajouterDialog.setSize(new Dimension(200,450));
		
		//fenêtre de dialogue supprimer
		dialogPan_supprimer.add(id);
		dialogPan_supprimer.add(okayButton_supprimer);
		
		supprimerDialog.add(dialogPan_supprimer);	
		supprimerDialog.setSize(new Dimension(200,450));
		
		centreWindow((Window)this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Met à jour la table méthode appelée après chaque modification
	public void fillTable(ArrayList<Medecin>list) {
		this.tableModel = new DefaultTableModel(col, 0);
		this.table = new JTable(tableModel);
		
		for (int i = 0; i < list.size(); i++){
			int id = list.get(i).getId(); 
			String nom = list.get(i).getNom();
			String prenom = list.get(i).getPrenom();
			String service = list.get(i).getService().getNom();
			
			Object[] data = {id, nom, prenom, service};
			tableModel.addRow(data);
		}
		
		scPane.setViewportView(table);
				 
	}
	//classes  ActionListener
	class AjouterListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			centreWindow((Window)ajouterDialog);
			ajouterDialog.setVisible(true);
					
		}
		
	}
	class SupprimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			centreWindow((Window)supprimerDialog);
			supprimerDialog.setVisible(true);
					
		}
		
	}
	
	//méthode Listener
	public void ajouterListener(ActionListener listenForAjouter){
		ajouter.addActionListener(listenForAjouter);
	}
	
	public void supprimerListener(ActionListener listenForSupprimer){
		supprimer.addActionListener(listenForSupprimer);
	}
	public void ajouterOkayListener(ActionListener listenForOkay) {
		okayButton_ajouter.addActionListener(listenForOkay);
	}
	public void supprimerOkayListener(ActionListener listenForOkay) {
		okayButton_supprimer.addActionListener(listenForOkay);
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
	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	public JButton getOkayButton_ajouter() {
		return this.okayButton_ajouter;
	}
	public JButton getOkayButton_supprimer() {
		return this.okayButton_supprimer;
	}
	public JDialog getAjouterDialog() {
		return this.ajouterDialog;
	}
	public JDialog getSupprimerDialog() {
		return this.supprimerDialog;
	}
	public JButton getAjouter() {
		return this.ajouter;
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