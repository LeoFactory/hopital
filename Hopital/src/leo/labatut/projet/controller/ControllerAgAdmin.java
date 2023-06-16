package leo.labatut.projet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import leo.labatut.projet.controller.ControllerSuperAdmin.AjouterMedecinOkayListener;
import leo.labatut.projet.controller.ControllerSuperAdmin.Deconnexion;
import leo.labatut.projet.dao.ChambreDAO;
import leo.labatut.projet.dao.PatientDAO;
import leo.labatut.projet.dao.ServiceDAO;
import leo.labatut.projet.dao.SuiviDAO;
import leo.labatut.projet.model.*;
import leo.labatut.projet.view.InterfaceAgAdmin;
import leo.labatut.projet.view.InterfaceMedecin;
import leo.labatut.projet.view.Login;

public class ControllerAgAdmin {
	
	private PatientDAO patientDAO;
	private ChambreDAO chambreDAO;
	
	
	private AgentAdmin agAdmin;
	private InterfaceAgAdmin view;
	/**
	 * constructeur
	 * @param cn
	 * @param view
	 * @param agAdmin
	 */
	public ControllerAgAdmin(Connection cn,InterfaceAgAdmin view,AgentAdmin agAdmin) {
		
		this.patientDAO= new PatientDAO(cn);
		this.chambreDAO= new ChambreDAO(cn);
		
		this.agAdmin= agAdmin;
		this.view= view;
		
		this.view.fillTablePatients(this.patientDAO.findAll());
		this.view.fillTableChambres(this.chambreDAO.findAll());
		
		this.view.fillListPatient(patientDAO.findAll());
		
		this.view.getOkayButton_ajouterPatient().addActionListener(new AjouterPatientOkayListener());
		this.view.getOkayButton_Chambre().addActionListener(new CompleterChambreOkayListener());
		this.view.getDeconnexionButton().addActionListener(new Deconnexion());
	}
	/**
	 * ajoute un patient quand le bouton okay correspondant est cliqué
	 * @author User
	 *
	 */
class AjouterPatientOkayListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			if(view.getNom().getText().equals("")||view.getPrenom().getText().equals("")||view.getDateNaissance().getText().equals("")||view.getSexe().getText().equals("")||view.getEmail().getText().equals("")) {
				view.getErreur2Dialog().setVisible(true);
			}else {
			Patient newPatient= null;
			try {
				newPatient= new Patient(view.getNom().getText(),view.getPrenom().getText(),new SimpleDateFormat("dd/MM/yyyy").parse(view.getDateNaissance().getText()),Calendar.getInstance().getTime(),view.getSexe().getText().charAt(0),view.getEmail().getText());
			} catch (ParseException e1) {
				
				e1.printStackTrace();
			}
			patientDAO.create(newPatient);
			
			view.getNom().setText(null);
			view.getPrenom().setText(null);
			view.getDateNaissance().setText(null);
			view.getSexe().setText(null);

			view.getEmail().setText(null);
			view.getMdp().setText(null);
			
			view.getAjouterPatientDialog().dispose();
			view.getTableModelPatients().setRowCount(0);
			view.fillTablePatients(patientDAO.findAll());
			}
		}
	}
/**
 * ajoute un patient dans une chambre quand le bouton correspondant est cliqué
 * @author User
 *
 */
	class CompleterChambreOkayListener implements ActionListener{
	
		public void actionPerformed(ActionEvent e) {
			
			Chambre chambre =null;
			Patient patient =null;
			String strPatient =view.getPatient().getText();
			
			chambre =chambreDAO.find(Integer.valueOf(view.getNumero().getText()));
			patient = patientDAO.find(Integer.parseInt(strPatient.substring(0,strPatient.indexOf(" "))));
			
			boolean bool =chambre.ajoutPatient(patient);
			
			if(bool) {
				chambreDAO.update(chambre);
				patientDAO.update(patient);
				
				view.getPatient().setText(null);
				view.getNumero().setText(null);
				
				view.getTableModelPatients().setRowCount(0);
				view.fillTablePatients(patientDAO.findAll());
				view.getTableModelChambres().setRowCount(0);
				view.fillTableChambres(chambreDAO.findAll());
				
				view.getCompleterChambreDialog().dispose();
			}else {
				view.getErreurDialog().setVisible(true);
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
