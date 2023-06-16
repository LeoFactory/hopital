package leo.labatut.projet.controller;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import leo.labatut.projet.controller.ControllerAgAdmin.Deconnexion;
import leo.labatut.projet.dao.AppareilDAO;
import leo.labatut.projet.dao.ConsultationDAO;
import leo.labatut.projet.dao.PathologieDAO;
import leo.labatut.projet.dao.PatientDAO;
import leo.labatut.projet.dao.SuiviDAO;
import leo.labatut.projet.model.*;
import leo.labatut.projet.model.Suivi;
import leo.labatut.projet.view.InterfaceMedecin;
import leo.labatut.projet.view.Login;

public class ControllerMedecin {
	
	private SuiviDAO suiviDAO;
	private PathologieDAO pathologieDAO;
	private PatientDAO patientDAO;
	private ConsultationDAO consultationDAO;
	private AppareilDAO appareilDAO;
	
	private InterfaceMedecin view;
	private Medecin medecin;
/**
 * constructeur controller medecin
 * @param cn
 * @param view
 * @param medecin
 */
	
	public ControllerMedecin(Connection cn,InterfaceMedecin view,Medecin medecin) {
		
		this.suiviDAO=new SuiviDAO(cn);
		this.consultationDAO= new ConsultationDAO(cn);
		this.patientDAO= new PatientDAO(cn);
		this.appareilDAO= new AppareilDAO(cn);
		
		pathologieDAO = new PathologieDAO(cn);
		
		this.view=view;
		this.medecin=medecin;
		
		this.view.setTitle(this.medecin.getNom()+" "+this.medecin.getPrenom());
		
		this.view.fillTableSuivi(this.suiviDAO.findByMedecin(this.medecin));
		this.view.fillTableConsultation(this.consultationDAO.findByMedecin(this.medecin));
		this.view.fillListPatient(patientDAO.findAll());
		this.view.fillListPathologie(pathologieDAO.findByService(this.medecin.getService()));
		this.view.fillListSuivis(suiviDAO.findByMedecin(this.medecin));
		this.view.fillListAppareils(appareilDAO.findAll());
		
		this.view.getTableSuivi().getSelectionModel().addListSelectionListener(new RowSelectionListener());
		
		this.view.getTableConsultation().getSelectionModel().addListSelectionListener(new ConsultRowSelectionListener());
		
		this.view.getOkSuivi().addActionListener(new AjouterSuiviOkListener());
		this.view.getOkConsult().addActionListener(new AjouterConsultOkListener());
		this.view.getOkComplet().addActionListener(new CompletConsultOkListener());
		this.view.getDeconnexionButton().addActionListener(new Deconnexion());
		
	}
	/**
	 * montre les consultations correspondant au suivi de la ligne cliquée
	 * @author User
	 *
	 */
	public class RowSelectionListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent event) {
			int viewRow = view.getTableSuivi().getSelectedRow();

	        if (!event.getValueIsAdjusting() && viewRow != -1) {

	            int columnIndex = 0;

	            // Better to access table row using modelRow rather than viewRow
	            int modelRow = view.getTableSuivi().convertRowIndexToModel(viewRow);

	            // Access value at selected row at the first column (columnIndex = 0)
	            int id = (int)view.getTableSuivi().getModel().getValueAt(modelRow, columnIndex);
	            
	            Suivi suivi = suiviDAO.find(id);
	            
	            view.fillTableConsultation(consultationDAO.findBySuivi(suivi));
	            view.getTableConsultation().getSelectionModel().addListSelectionListener(new ConsultRowSelectionListener());
	        }

	          	
		}
		
	}
	/**
	 * récupère l'id d'une consultation en cliquant sur la ligne
	 * @author User
	 *
	 */
	public class ConsultRowSelectionListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent event) {
			int viewRow = view.getTableConsultation().getSelectedRow();

	        if (!event.getValueIsAdjusting() && viewRow != -1) {

	            int columnIndex = 0;

	            // Better to access table row using modelRow rather than viewRow
	            int modelRow = view.getTableConsultation().convertRowIndexToModel(viewRow);

	            // Access value at selected row at the first column (columnIndex = 0)
	            int id = (int)view.getTableConsultation().getModel().getValueAt(modelRow, columnIndex);
	            
	            view.getConsultation().setText(Integer.toString(id));
	            
	        }

	          	
		}
		
	}
	/**
	 * ajoute un suivi
	 * @author User
	 *
	 */
	class AjouterSuiviOkListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if(view.getPatient().getText().equals("")||view.getPathologie().getText().equals("")) {
				view.getErreurDialog().setVisible(true);
			}else {
			String strPatient = view.getPatient().getText();
			String strPathologie = view .getPathologie().getText();
			
			int idPatient = Integer.parseInt(strPatient.substring(0,strPatient.indexOf(" ")));
			int idPathologie = Integer.parseInt(strPathologie.substring(0,strPathologie.indexOf(" ")));
			
			Suivi suivi = new Suivi(patientDAO.find(idPatient),pathologieDAO.find(idPathologie), medecin);
			suiviDAO.create(suivi);
			
			view.getPatient().setText(null);
			view.getPathologie().setText(null);
			
			view.getTableModelSuivi().setRowCount(0);
			view.fillTableSuivi(suiviDAO.findByMedecin(medecin));
			view.getTableSuivi().getSelectionModel().addListSelectionListener(new RowSelectionListener());		
			view.getTableConsultation().getSelectionModel().addListSelectionListener(new ConsultRowSelectionListener());
			view.fillListSuivis(suiviDAO.findByMedecin(medecin));
			view.getAjoutSuiviDialog().dispose();
			}
		}
	}
	/**
	 * ajoute une consultation
	 * @author User
	 *
	 */
	class AjouterConsultOkListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if(view.getSuivi().getText().equals("")) {
				view.getErreurDialog().setVisible(true);
			}else {
			String strSuivi = view.getSuivi().getText();
			
			int idSuivi = Integer.parseInt(strSuivi.substring(0,strSuivi.indexOf(" ")));
			
			Consultation consultation = new Consultation(suiviDAO.find(idSuivi),Calendar.getInstance().getTime());
			consultationDAO.create(consultation);
			view.getSuivi().setText(null);
			
			view.getTableModelConsultation().setRowCount(0);
			view.fillTableConsultation(consultationDAO.findByMedecin(medecin));
			view.getTableSuivi().getSelectionModel().addListSelectionListener(new RowSelectionListener());			
			view.getTableConsultation().getSelectionModel().addListSelectionListener(new ConsultRowSelectionListener());
			view.getAjoutConsultDialog().dispose();
			}
		}
		
	}
	/**
	 * ajoute la prescription de soin l'ordonnance et éventuellement un appareil
	 * @author User
	 *
	 */
	class CompletConsultOkListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if(view.getAppareil().getText().equals("")) {
				
				String strSoin = view.getSoin().getText();
				String strOrdo = view.getOrdonnance().getText();
				
				Consultation consultation = consultationDAO.find(Integer.parseInt(view.getConsultation().getText()));
				consultation.setSoin(strSoin);
				consultation.setOrdonnance(strOrdo);
				
				consultationDAO.update(consultation);
				view.getOrdonnance().setText("Ordonnance :");
				view.getSoin().setText("Soin :");
				view.getConsultation().setText(null);
				view.getAppareil().setText(null);
			
				view.getCompletConsultDialog().dispose();
			}else {
			String strAppareil = view.getAppareil().getText();
			String strSoin = view.getSoin().getText();
			String strOrdo = view.getOrdonnance().getText();
			
			int idAppareil = Integer.parseInt(strAppareil.substring(0,strAppareil.indexOf(" ")));
			
			Consultation consultation = consultationDAO.find(Integer.parseInt(view.getConsultation().getText()));
			consultation.setAppareil(appareilDAO.find(idAppareil));
			consultation.setStatutAppareil("instance");
			consultation.setSoin(strSoin);
			consultation.setOrdonnance(strOrdo);
			
			consultationDAO.updateAppareil(consultation);
			view.getOrdonnance().setText("Ordonnance :");
			view.getSoin().setText("Soin :");
			view.getConsultation().setText(null);
			view.getAppareil().setText(null);
		
			view.getCompletConsultDialog().dispose();
			}
		}
		
	}
	
	/**
	 * déconnexion et retour à la fenêtre login
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
