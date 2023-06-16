package leo.labatut.projet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import leo.labatut.projet.controller.ControllerAgAdmin.Deconnexion;
import leo.labatut.projet.controller.ControllerMedecin.RowSelectionListener;
import leo.labatut.projet.dao.*;
import leo.labatut.projet.model.*;
import leo.labatut.projet.view.InterfaceInfirmier;
import leo.labatut.projet.view.Login;

import java.util.ArrayList;

public class ControllerInfirmier {
	
	private Infirmier infirmier;
	private InterfaceInfirmier view;
	
	private ChambreDAO chambreDAO;
	private PatientDAO patientDAO;
	private SuiviDAO suiviDAO;
	private ConsultationDAO consultationDAO;
	
	/**
	 * constructeur
	 * @param cn
	 * @param view
	 * @param infirmier
	 */
	public ControllerInfirmier(Connection cn,InterfaceInfirmier view, Infirmier infirmier) {
		
		this.view=view;
		this.infirmier=infirmier;
		
		this.chambreDAO= new ChambreDAO(cn);
		this.patientDAO= new PatientDAO(cn);
		this.suiviDAO = new SuiviDAO(cn);
		this.consultationDAO = new ConsultationDAO(cn);
		
		this.view.fillTablePatient(patientDAO.findAll());
		this.view.fillTableChambre(chambreDAO.findByInfirmier(infirmier));
		
		this.view.getTableChambre().getSelectionModel().addListSelectionListener(new RowSelectionListenerChambre());
		this.view.getTablePatient().getSelectionModel().addListSelectionListener(new RowSelectionListenerPatient());
		this.view.getDeconnexionButton().addActionListener(new Deconnexion());
	}
	/**
	 * Trouve les patients correspondants à une chambre quand la ligne est cliquée
	 * @author User
	 *
	 */
	public class RowSelectionListenerChambre implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent event) {
			int viewRow = view.getTableChambre().getSelectedRow();

	        if (!event.getValueIsAdjusting() && viewRow != -1) {

	            int columnIndex = 0;

	            int modelRow = view.getTableChambre().convertRowIndexToModel(viewRow);

	            int id = (int)view.getTableChambre().getModel().getValueAt(modelRow, columnIndex);
	            
	            Chambre chambre = chambreDAO.find(id);
	            
	            view.fillTablePatient(patientDAO.findByChambre(chambre));
	            view.getTablePatient().getSelectionModel().addListSelectionListener(new RowSelectionListenerPatient());
	        }

	          	
		}
		
	}
	/**
	 * affiche les infos médicale du patient quand la ligne est cliquée
	 * @author User
	 *
	 */
	public class RowSelectionListenerPatient implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent event) {
			int viewRow = view.getTablePatient().getSelectedRow();

	        if (!event.getValueIsAdjusting() && viewRow != -1) {

	            int columnIndex = 0;

	          
	            int modelRow = view.getTablePatient().convertRowIndexToModel(viewRow);

	           
	            int id = (int)view.getTablePatient().getModel().getValueAt(modelRow, columnIndex);
	            
	            Patient patient = patientDAO.find(id);
	            ArrayList <Suivi>listSuivi = suiviDAO.findByPatient(patient);
	            ArrayList <Consultation>listConsultation;
	            StringBuilder strSuiviPatient = new StringBuilder(""); 
	            
	            for (int i =0;i<listSuivi.size();i++) {
	            	listConsultation= consultationDAO.findBySuivi(listSuivi.get(i));	
	            	for(int j=0;j<listConsultation.size();j++) {
	            		strSuiviPatient.append("Patient :\nNom : "+ patient.getNom()+"\nPrénom : "+patient.getPrenom()+"\nDate de naissance : "+patient.getDateNaissance()+"\nPathologie : "+listConsultation.get(j).getSuivi().getPathologie().getNom()+"\nConsultation  : Date : "+listConsultation.get(j).getDate().toString()+"\nOrdonnance : "+listConsultation.get(j).getOrdonnance()+"\nSoin : "+listConsultation.get(j).getSoin());
	            	}
	            }
	            view.getInfoPatient().setText(strSuiviPatient.toString());
	              	
	        }
		
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
