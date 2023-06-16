package leo.labatut.projet.controller;

import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JComboBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import leo.labatut.projet.controller.ControllerAgAdmin.Deconnexion;
import leo.labatut.projet.controller.ControllerMedecin.RowSelectionListener;
import leo.labatut.projet.dao.ConsultationDAO;
import leo.labatut.projet.model.Consultation;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Technicien;
import leo.labatut.projet.view.InterfaceMedecin;
import leo.labatut.projet.view.InterfaceTechnicien;
import leo.labatut.projet.view.Login;

public class ControllerTechnicien {
	
	private Technicien technicien;
	private InterfaceTechnicien view;
	private ConsultationDAO consultationDAO;
	/**
	 * constructeur
	 * @param cn
	 * @param view
	 * @param technicien
	 */
	public ControllerTechnicien(Connection cn,InterfaceTechnicien view,Technicien technicien) {
		
		this.consultationDAO= new ConsultationDAO(cn);
		
		this.technicien=technicien;
		this.view=view;
		
		this.view.fillTableConsultation(this.consultationDAO.findByAppareilStatut());
		this.view.getTableConsultation().getSelectionModel().addListSelectionListener(new RowSelectionListener());
		this.view.getOkButton().addActionListener(new OctroieOkListener());
		
		this.view.setTitle(this.technicien.getNom()+" "+this.technicien.getPrenom());
		this.view.getDeconnexionButton().addActionListener(new Deconnexion());
		
		
	}
	/**
	 * ouvre un dialogue de modification du statut de l'appareil quand la ligne de la consultation est cliquée
	 * @author User
	 *
	 */
	public class RowSelectionListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent event) {
			int viewRow = view.getTableConsultation().getSelectedRow();

	        if (!event.getValueIsAdjusting() && viewRow != -1) {

	            int columnIndex = 0;

	            // Better to access table row using modelRow rather than viewRow
	            int modelRow = view.getTableConsultation().convertRowIndexToModel(viewRow);

	            // Access value at selected row at the first column (columnIndex = 0)
	            int id = (int)view.getTableConsultation().getModel().getValueAt(modelRow, columnIndex);
	            
	            Consultation consultation = consultationDAO.find(id);
	            
	            if(consultation.getStatutAppareil().equals("octroyé")) 
	            	view.getBox().setSelectedIndex(1);
	            else
	            	view.getBox().setSelectedIndex(0);
	            
	            view.getNumero().setText(Integer.toString(consultation.getId()));
	            
	            view.getOctroieDialog().setSize(new Dimension(300,100));
	    		view.centreWindow((Window)view.getOctroieDialog());
	    		view.getOctroieDialog().setVisible(true);
	        }
	          	
		}
		
	}
	/**
	 * Modifie le statut de l'appareil dans la consultation quand "OK" est cliqué
	 * @author User
	 *
	 */
	class OctroieOkListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			Consultation consultation = consultationDAO.find(Integer.parseInt(view.getNumero().getText()));
			
			
			
			consultation.setStatutAppareil(view.getBox().getSelectedItem().toString());
			
			consultationDAO.updateAppareil(consultation);
			
			view.fillTableConsultation(consultationDAO.findByAppareilStatut());
			view.getTableConsultation().getSelectionModel().addListSelectionListener(new RowSelectionListener());
			view.getOctroieDialog().dispose();
			
			
		}
	}
	/**
	 * retour fenêtre login
	 * @author User
	 *
	 */
	class Deconnexion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			view.dispose();
			
			Login login = new Login();
	    	LoginController loginCtrlr= new LoginController(login);
			
		}
	}

}
