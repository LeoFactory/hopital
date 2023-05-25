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
	private JPanel buttonPanel = new JPanel();
	private JScrollPane scPane =new JScrollPane();
	private JSplitPane splitPane = new JSplitPane();
	
	private JTextField nom= new JTextField(15);
	private JTextField prenom= new JTextField(15);
	private JTextField dateNaissance= new JTextField(15);
	private JTextField sexe= new JTextField(15);
	private JTextField service= new JTextField(15);
	private JTextField email= new JTextField(15);
	private JTextField mdp=new JPasswordField(15);
	
	private JButton okayButton = new JButton("OK");
	private JPanel dialogPan=new JPanel();
	
	private JTable table;
	private String col[] = {"Nom","Prénom","Service"};
	private DefaultTableModel tableModel;
	
	public MedecinView() {
		
		
		ajouter.addActionListener(new AjouterListener());
		
        this.getContentPane().add(splitPane);
        
        scPane.setPreferredSize(new Dimension(450, 300));
        splitPane.setLeftComponent(scPane);
        
        
		this.setTitle ("Medecins") ;
		this.setSize (new Dimension (700, 450)) ;
		
		buttonPanel.add(ajouter);
		buttonPanel.add(supprimer);
		splitPane.setRightComponent(buttonPanel);
		
		dialogPan.add(new JTextArea("Nom"));
		dialogPan.add(nom);
		dialogPan.add(new JTextArea("Prénom"));
		dialogPan.add(prenom);
		dialogPan.add(new JTextArea("Date de naissance"));
		dialogPan.add(dateNaissance);
		dialogPan.add(new JTextArea("Sexe"));
		dialogPan.add(sexe);
		dialogPan.add(new JTextArea("Service"));
		dialogPan.add(service);
		dialogPan.add(new JTextArea("email"));
		dialogPan.add(email);
		dialogPan.add(new JTextArea("mot de passe"));
		dialogPan.add(mdp);
		
		
		dialogPan.add(okayButton );
		                 
		ajouterDialog.add(dialogPan);	
		ajouterDialog.setSize(new Dimension(200,450));
		
		centreWindow((Window)this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void fillTable(ArrayList<Medecin>list) {
		this.tableModel = new DefaultTableModel(col, 0);
		this.table = new JTable(tableModel);
		
		for (int i = 0; i < list.size(); i++){
			String nom = list.get(i).getNom();
			String prenom = list.get(i).getPrenom();
			String service = list.get(i).getService().getNom();
			
			Object[] data = {nom, prenom, service};
			tableModel.addRow(data);
		}
		
		scPane.setViewportView(table);
				 
	}

	class AjouterListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			centreWindow((Window)ajouterDialog);
			ajouterDialog.setVisible(true);
					
		}
		
	}
	
	public void ajouterListener(ActionListener listenForAjouter){
		ajouter.addActionListener(listenForAjouter);
	}
	
	public void supprimerListener(ActionListener listenForSupprimer){
		supprimer.addActionListener(listenForSupprimer);
	}
	public void ajouterOkayListener(ActionListener listenForOkay) {
		okayButton.addActionListener(listenForOkay);
	}
	
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
	
	public JTable getTable() {
		return this.table;
	}
	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	public JButton getOkayButton() {
		return this.okayButton;
	}
	public JDialog getAjouterDialog() {
		return this.ajouterDialog;
	}
	public JButton getAjouter() {
		return this.ajouter;
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