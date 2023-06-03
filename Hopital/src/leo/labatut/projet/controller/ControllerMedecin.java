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

import leo.labatut.projet.dao.ConsultationDAO;
import leo.labatut.projet.dao.PathologieDAO;
import leo.labatut.projet.dao.PatientDAO;
import leo.labatut.projet.dao.SuiviDAO;
import leo.labatut.projet.model.*;
import leo.labatut.projet.model.Suivi;
import leo.labatut.projet.view.InterfaceMedecin;

public class ControllerMedecin {
	
	private SuiviDAO suiviDAO;
	private PathologieDAO pathologieDAO;
	private PatientDAO patientDAO;
	private ConsultationDAO consultationDAO;
	private InterfaceMedecin view;
	private Medecin medecin;

	
	public ControllerMedecin(Connection cn,InterfaceMedecin view,Medecin medecin) {
		
		this.suiviDAO=new SuiviDAO(cn);
		this.consultationDAO= new ConsultationDAO(cn);
		this.patientDAO= new PatientDAO(cn);
		pathologieDAO = new PathologieDAO(cn);
		
		this.view=view;
		this.medecin=medecin;
		
		this.view.setTitle(this.medecin.getNom()+" "+this.medecin.getPrenom());
		
		this.view.fillTableSuivi(this.suiviDAO.findByMedecin(this.medecin));
		this.view.fillTableConsultation(this.consultationDAO.findByMedecin(this.medecin));
		this.view.fillListPatient(patientDAO.findAll());
		this.view.fillListPathologie(pathologieDAO.findAll());
		this.view.fillListSuivis(suiviDAO.findAll());
		
		this.view.getTableSuivi().getSelectionModel().addListSelectionListener(new RowSelectionListener());
		this.view.getOkSuivi().addActionListener(new AjouterSuiviOkListener());
		this.view.getOkConsult().addActionListener(new AjouterConsultOkListener());
		
	}
	
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
	            
	        }

	          	
		}
		
	}
	class AjouterSuiviOkListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
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
			view.getAjoutSuiviDialog().dispose();
			
		}
	}
	class AjouterConsultOkListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			String strSuivi = view.getSuivi().getText();
			
			int idSuivi = Integer.parseInt(strSuivi.substring(0,strSuivi.indexOf(" ")));
			
			Consultation consultation = new Consultation(suiviDAO.find(idSuivi),Calendar.getInstance().getTime());
			consultationDAO.create(consultation);
			view.getSuivi().setText(null);
			
			view.getTableModelConsultation().setRowCount(0);
			view.fillTableConsultation(consultationDAO.findByMedecin(medecin));
			view.getAjoutConsultDialog().dispose();
			
		}
		
	}

}
