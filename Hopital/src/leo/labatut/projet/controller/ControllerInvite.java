package leo.labatut.projet.controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import leo.labatut.projet.dao.*;
import leo.labatut.projet.model.*;
import leo.labatut.projet.view.*;


public class ControllerInvite {
	
	private StringBuilder info = new StringBuilder("");
	
	private SuiviDAO suiviDAO;
	private PathologieDAO pathologieDAO;
	private PatientDAO patientDAO;
	private ChambreDAO chambreDAO;
	private AgentAdminDAO agAdminDAO;
	private InfirmierDAO infirmierDAO;
	private MedecinDAO medecinDAO;
	private TechnicienDAO technicienDAO;
	
	private InterfaceInvite view;
	
	/**
	 * constructeur
	 * @param cn
	 * @param view
	 */
	
	public ControllerInvite(Connection cn, InterfaceInvite view) {
		
		this.view=view;
		
		this.pathologieDAO= new PathologieDAO(cn);
		this.suiviDAO = new SuiviDAO(cn);
		this.agAdminDAO=new AgentAdminDAO(cn);
		this.patientDAO=new PatientDAO(cn);
		this.chambreDAO=new ChambreDAO(cn);
		this.medecinDAO=new MedecinDAO(cn);
		this.infirmierDAO = new InfirmierDAO(cn);
		this.technicienDAO= new TechnicienDAO(cn);
		
		this.view.getBoutonRecherchePatient().addActionListener(new RecherchePatientListener());
		this.view.getBoutonRecherchePersonnel().addActionListener(new RecherchePersonnelListener());
		this.view.getDeconnexionButton().addActionListener(new Deconnexion());
		
		this.calculTauxOccupation();
		this.calculPatientParPathologies();
		this.calculStatGenerales();
		this.view.getInfo().setText(info.toString());
		
		
	}
	/**
	 * obtient les infos correspondant au nom du patient recherché
	 * @author User
	 *
	 */
	class RecherchePatientListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(view.getPatient().getText().equals("")) {
				view.getErreurDialog().setVisible(true);
			}else if(patientDAO.find(view.getPatient().getText())==null){
				view.getResult().setText("Il n'existe aucun patient portant ce nom");
			}else {
				Patient patient = patientDAO.find(view.getPatient().getText());
				view.getResult().setText(patient.toString());
			}
			
		}
		
	}
	/**
	 * obtient les infos correspondant au nom du membre du personnel recherché
	 * @author User
	 *
	 */
	class RecherchePersonnelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(view.getPersonnel().getText().equals("")) {
				view.getErreurDialog().setVisible(true);
			}else if(medecinDAO.find(view.getPersonnel().getText())==null&&infirmierDAO.find(view.getPersonnel().getText())==null&&agAdminDAO.find(view.getPersonnel().getText())==null){
				view.getResult().setText("Il n'existe aucun membre du personnel portant ce nom");
			}else {
				StringBuilder strPersonnel = new StringBuilder("");
				
				Medecin med = medecinDAO.find(view.getPersonnel().getText());
				if(med!=null)
					strPersonnel.append(med.toString());
				
				Infirmier inf = infirmierDAO.find(view.getPersonnel().getText());
				if(inf!=null)
					strPersonnel.append(inf.toString());
				
				AgentAdmin agent = agAdminDAO.find(view.getPersonnel().getText());
				if(agent!=null)
					strPersonnel.append(agent.toString());
				
				view.getResult().setText(strPersonnel.toString());
			}
			
		}
		
	}
	/**
	 * calcul l'occupation des lits de l'hôpital en %
	 */
	
	private void calculTauxOccupation() {
		
		
		
		ArrayList<Chambre>list = new ArrayList<Chambre>();
		list = chambreDAO.findAll();
		
		int capaciteTotale=0;
		int occupation=0;
		
		for (int i=0; i<list.size();i++) {
			capaciteTotale+=list.get(i).getCapacite();
			occupation +=list.get(i).getNbPatient();
		}
		
		float pourcentage = (100*occupation)/capaciteTotale;
		int nbChambres = chambreDAO.findAll().size();
		info.append("\nNombre de chambres : "+nbChambres);
		info.append("\nCapacité totale (lits) : "+Integer.toString(capaciteTotale));
		info.append("\nOccupation :"+Float.toString(pourcentage)+"%");
		
		
	}
	/**
	 * calcul en % la proportion de patient atteint par pathologie
	 */
	private void calculPatientParPathologies() {
		
		ArrayList<Pathologie>listPathologies=pathologieDAO.findAll();
		int nbPatients;
		int totalPatients = patientDAO.findAll().size();
		float pourcentage;
		
		info.append("\nTaux de malades atteint par pathologies : ");
		for (int i = 0; i<listPathologies.size();i++) {
			nbPatients= suiviDAO.findByPathologie(listPathologies.get(i)).size();
			pourcentage=(nbPatients*100)/totalPatients;
			info.append("\n       "+listPathologies.get(i).getNom()+" : "+pourcentage+"%");
		}
	}
	/**
	 * statistiques générales sur le personnel, les patients ...
	 */
	private void calculStatGenerales() {
		int nbMedecins,nbAgents, nbTec,nbInfirmiers,nbPatients;
		
		nbMedecins= medecinDAO.findAll().size();
		nbAgents= agAdminDAO.findAll().size();
		nbTec = technicienDAO.findAll().size();
		nbInfirmiers=infirmierDAO.findAll().size();	
		nbPatients =patientDAO.findAll().size();
		
		info.append("\nNombre de patients : "+nbPatients+"\nNombres de Medecin : "+nbMedecins+"\nNombre d'agents d'administration : "+ nbAgents+"\nNombre de techniciens : "+nbTec+"\nNombre d'infirmiers : "+nbInfirmiers);
		
	}
	/**
	 * deconnexion et retour fenêtre login
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
