package leo.labatut.projet.controller;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import leo.labatut.projet.controller.ControllerInvite.Deconnexion;
import leo.labatut.projet.dao.*;
import leo.labatut.projet.dao.InfirmierDAO;
import leo.labatut.projet.dao.MedecinDAO;
import leo.labatut.projet.dao.ServiceDAO;
import leo.labatut.projet.dao.SuiviDAO;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Service;
import leo.labatut.projet.model.*;
import leo.labatut.projet.view.InterfaceSuperAdmin;
import leo.labatut.projet.view.Login;

public class ControllerSuperAdmin {
	
	private MedecinDAO medecinDAO;
	private InfirmierDAO infirmierDAO;
	private AgentAdminDAO agAdminDAO;
	private SuiviDAO suiviDAO;
	private ConsultationDAO consultationDAO;
	private TechnicienDAO technicienDAO;
	private ServiceDAO serviceDAO;
	
	private InterfaceSuperAdmin view;
	/**
	 * constructeur
	 * @param cn
	 * @param view
	 */
	public ControllerSuperAdmin(Connection cn,InterfaceSuperAdmin view) {
		
		this.medecinDAO=new MedecinDAO(cn);
		this.agAdminDAO=new AgentAdminDAO(cn);
		this.infirmierDAO= new InfirmierDAO(cn);
		this.suiviDAO= new SuiviDAO(cn);
		this.consultationDAO= new ConsultationDAO(cn);
		this.technicienDAO= new TechnicienDAO(cn);
		this.serviceDAO = new ServiceDAO(cn);
		
		this.view=view;
		
		this.view.fillTableMedecins(this.medecinDAO.findAll());
		this.view.getOkayButton_ajouterMedecin().addActionListener(new AjouterMedecinOkayListener());
		this.view.getOkayButton_supprimerMedecin().addActionListener(new SupprimerMedecinOkayListener());
		this.view.getOkayButton_updateMedecin().addActionListener(new UpdateMedecinOkayListener());
		this.view.fillListMedecin(medecinDAO.findAll());
		
		this.view.fillTableAgAdmin(this.agAdminDAO.findAll());
		this.view.getOkayButton_ajouterAgAdmin().addActionListener(new AjouterAgAdminOkayListener());
		this.view.getOkayButton_supprimerAgAdmin().addActionListener(new SupprimerAgAdminOkayListener());
		this.view.getOkayButton_updateAgAdmin().addActionListener(new UpdateAgAdminOkayListener());
		this.view.fillListAgAdmin(this.agAdminDAO.findAll());
		
		this.view.fillTableInfirmier(this.infirmierDAO.findAll());
		this.view.getOkayButton_ajouterInfirmier().addActionListener(new AjouterInfirmierOkayListener());
		this.view.getOkayButton_supprimerInfirmier().addActionListener(new SupprimerInfirmierOkayListener());
		this.view.getOkayButton_updateInfirmier().addActionListener(new UpdateInfirmierOkayListener());
		this.view.fillListInfirmier(infirmierDAO.findAll());
		
		this.view.fillTableTechnicien(this.technicienDAO.findAll());
		this.view.getOkayButton_ajouterTechnicien().addActionListener(new AjouterTechnicienOkayListener());
		this.view.getOkayButton_supprimerTechnicien().addActionListener(new SupprimerTechnicienOkayListener());
		this.view.getOkayButton_updateTechnicien().addActionListener(new UpdateTechnicienOkayListener());
		this.view.fillListTechnicien(technicienDAO.findAll());
		
		this.view.fillListService(serviceDAO.findAll());
		
		this.view.getDeconnexionButton().addActionListener(new Deconnexion());
		
		

	}
	/**
	 * ajoute un nouveau médecin quand le bouton est cliqué
	 * @author User
	 *
	 */
	class AjouterMedecinOkayListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			String strService=view.getService().getText();
			int idService =Integer.parseInt(strService.substring(0,strService.indexOf(" ")));
			
			Service service = serviceDAO.find(idService);
			Medecin newMedecin= null;
			try {
				newMedecin= new Medecin(view.getNom().getText(),view.getPrenom().getText(),new SimpleDateFormat("dd/MM/yyyy").parse(view.getDateNaissance().getText()),view.getSexe().getText().charAt(0),service,view.getEmail().getText(),view.getMdp().getText());
			} catch (ParseException e1) {
				
				e1.printStackTrace();
			}
			medecinDAO.create(newMedecin);
			
			view.getNom().setText(null);
			view.getPrenom().setText(null);
			view.getDateNaissance().setText(null);
			view.getSexe().setText(null);
			view.getService().setText(null);
			view.getEmail().setText(null);
			view.getMdp().setText(null);
			
			view.getAjouterDialogMedecin().dispose();
			view.getTableModelMedecins().setRowCount(0);
			view.fillTableMedecins(medecinDAO.findAll());
			view.fillListMedecin(medecinDAO.findAll());

			}
		}
	/**
	 * supprime un médecin quand le bouton est cliqué
	 * @author User
	 *
	 */
	class SupprimerMedecinOkayListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			//il faut supprimer tous les suivis du médecin avant de faire la suppression du medecin 
			//sinon erreur SQL lié à la contrainte FOREIGN KEY dans suivi
			
			String strMedecin=view.getMedecin().getText();
			int id =Integer.parseInt(strMedecin.substring(0,strMedecin.indexOf(" ")));
			
			ArrayList<Consultation>listConsult;
			ArrayList<Suivi>listSuivi = suiviDAO.findByMedecin(medecinDAO.find(id));
			
			
			for (int i =0;i<listSuivi.size();i++) {
				listConsult=consultationDAO.findBySuivi(listSuivi.get(i));
				for(int j=0;j<listConsult.size();j++) {
					consultationDAO.delete(listConsult.get(j));
				}
				suiviDAO.delete(listSuivi.get(i));
			}
			
			medecinDAO.delete(medecinDAO.find(id));
			view.getMedecin().setText(null);
			
			view.getSupprimerDialogMedecin().dispose();
			view.getTableModelMedecins().setRowCount(0);
			view.fillTableMedecins(medecinDAO.findAll());
			view.fillListMedecin(medecinDAO.findAll());
		}
	}
	/**
	 * met à jour service, mdp et email quand le bouton est cliqué
	 * @author User
	 *
	 */
	class UpdateMedecinOkayListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			String strMedecin=view.getMedecin().getText();
			int id =Integer.parseInt(strMedecin.substring(0,strMedecin.indexOf(" ")));
				
			
			String strService=view.getService().getText();
			int idService =Integer.parseInt(strService.substring(0,strService.indexOf(" ")));
			
			Medecin updateMed= medecinDAO.find(id);
			
			updateMed.setService(serviceDAO.find(idService));
			updateMed.setEmail(view.getEmail().getText());
			updateMed.setMdp(view.getMdp().getText());
			
			medecinDAO.update(updateMed);
			
			view.getMedecin().setText(null);
			view.getNom().setText(null);
			view.getPrenom().setText(null);
			view.getDateNaissance().setText(null);
			view.getSexe().setText(null);
			view.getService().setText(null);
			view.getEmail().setText(null);
			view.getMdp().setText(null);
			
			view.getUpdateDialogMedecin().dispose();
			view.getTableModelMedecins().setRowCount(0);
			view.fillTableMedecins(medecinDAO.findAll());
			view.fillListMedecin(medecinDAO.findAll());

			}
		}
	/**
	 * ajoute un infirmier quand le bouton est cliqué
	 * @author User
	 *
	 */
	class AjouterInfirmierOkayListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			Infirmier newInfirmier= null;
			try {
				newInfirmier= new Infirmier(view.getNom().getText(),view.getPrenom().getText(),new SimpleDateFormat("dd/MM/yyyy").parse(view.getDateNaissance().getText()),view.getSexe().getText().charAt(0),view.getEmail().getText(),view.getMdp().getText());
			} catch (ParseException e1) {
				
				e1.printStackTrace();
			}
			infirmierDAO.create(newInfirmier);
			
			view.getNom().setText(null);
			view.getPrenom().setText(null);
			view.getDateNaissance().setText(null);
			view.getSexe().setText(null);
			view.getService().setText(null);
			view.getEmail().setText(null);
			view.getMdp().setText(null);
			
			view.getAjouterDialogInfirmier().dispose();
			view.getTableModelInfirmiers().setRowCount(0);
			view.fillTableInfirmier(infirmierDAO.findAll());
			view.fillListInfirmier(infirmierDAO.findAll());

		}
	}
	/**
	 * supprime un infirmier quand le bouton est cliqué
	 * @author User
	 *
	 */
	
	class SupprimerInfirmierOkayListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			//il faut supprimer tous les suivis du médecin avant de faire la suppression du medecin 
			//sinon erreur SQL lié à la contrainte FOREIGN KEY dans suivi
			
			String strInfirmier=view.getInfirmier().getText();
			int id =Integer.parseInt(strInfirmier.substring(0,strInfirmier.indexOf(" ")));
			
			
			infirmierDAO.delete(infirmierDAO.find(id));
			view.getInfirmier().setText(null);
			
			view.getSupprimerDialogInfirmier().dispose();
			view.getTableModelInfirmiers().setRowCount(0);
			view.fillTableInfirmier(infirmierDAO.findAll());
			view.fillListInfirmier(infirmierDAO.findAll());
		}
	}
	/**
	 * met à jour un infirmier quand le bouton est cliqué
	 * @author User
	 *
	 */
class UpdateInfirmierOkayListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			String strInfirmier=view.getInfirmier().getText();
			
			int id =Integer.parseInt(strInfirmier.substring(0,strInfirmier.indexOf(" ")));
			Infirmier updateInf= infirmierDAO.find(id);
			
			
			updateInf.setEmail(view.getEmail().getText());
			updateInf.setMdp(view.getMdp().getText());
			
			infirmierDAO.update(updateInf);
			
			view.getInfirmier().setText(null);
			view.getNom().setText(null);
			view.getPrenom().setText(null);
			view.getDateNaissance().setText(null);
			view.getSexe().setText(null);
			view.getService().setText(null);
			view.getEmail().setText(null);
			view.getMdp().setText(null);
			
			view.getUpdateDialogInfirmier().dispose();
			view.getTableModelInfirmiers().setRowCount(0);
			view.fillTableInfirmier(infirmierDAO.findAll());
			view.fillListInfirmier(infirmierDAO.findAll());

			}
		}
	/**
	 * ajoute un agent quand le bouton est cliqué
	 * @author User
	 *
	 */
	class AjouterAgAdminOkayListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			AgentAdmin agAdmin= null;
			try {
				agAdmin= new AgentAdmin(view.getNom().getText(),view.getPrenom().getText(),new SimpleDateFormat("dd/MM/yyyy").parse(view.getDateNaissance().getText()),view.getSexe().getText().charAt(0),view.getEmail().getText());
			} catch (ParseException e1) {
				
				e1.printStackTrace();
			}
			agAdminDAO.create(agAdmin);
			
			view.getNom().setText(null);
			view.getPrenom().setText(null);
			view.getDateNaissance().setText(null);
			view.getSexe().setText(null);
			view.getService().setText(null);
			view.getEmail().setText(null);
			view.getMdp().setText(null);
			
			view.getAjouterDialogAgAdmin().dispose();
			view.getTableModelAgAdmins().setRowCount(0);
			view.fillTableAgAdmin(agAdminDAO.findAll());
			view.fillListAgAdmin(agAdminDAO.findAll());
		}
	}
	/**
	 * supprime un agent quand le bouton est cliqué
	 * @author User
	 *
	 */
	class SupprimerAgAdminOkayListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			//il faut supprimer tous les suivis du médecin avant de faire la suppression du medecin 
			//sinon erreur SQL lié à la contrainte FOREIGN KEY dans suivi
			
			String strAgAdmin=view.getAgAdmin().getText();
			int id =Integer.parseInt(strAgAdmin.substring(0,strAgAdmin.indexOf(" ")));
			
			
			agAdminDAO.delete(agAdminDAO.find(id));
			view.getAgAdmin().setText(null);
			
			view.getSupprimerDialogAgAdmin().dispose();
			view.getTableModelAgAdmins().setRowCount(0);
			view.fillTableAgAdmin(agAdminDAO.findAll());
			view.fillListAgAdmin(agAdminDAO.findAll());
		}
	}
	/**
	 * met à jour un agent quand le bouton est cliqué
	 * @author User
	 *
	 */
	class UpdateAgAdminOkayListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			String strAgAdmin=view.getAgAdmin().getText();
			
			int id =Integer.parseInt(strAgAdmin.substring(0,strAgAdmin.indexOf(" ")));
			AgentAdmin updateAg= agAdminDAO.find(id);
			
			
			updateAg.setEmail(view.getEmail().getText());
			updateAg.setMdp(view.getMdp().getText());
			
			agAdminDAO.update(updateAg);
			
			view.getInfirmier().setText(null);
			view.getNom().setText(null);
			view.getPrenom().setText(null);
			view.getDateNaissance().setText(null);
			view.getSexe().setText(null);
			view.getService().setText(null);
			view.getEmail().setText(null);
			view.getMdp().setText(null);
			
			view.getUpdateDialogAgAdmin().dispose();
			view.getTableModelAgAdmins().setRowCount(0);
			view.fillTableAgAdmin(agAdminDAO.findAll());
			view.fillListAgAdmin(agAdminDAO.findAll());

			}
		}
	/**
	 * ajoute un technicien quand le bouton est cliqué
	 * @author User
	 *
	 */
	class AjouterTechnicienOkayListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			Technicien tec= null;
			try {
				tec= new Technicien(view.getNom().getText(),view.getPrenom().getText(),new SimpleDateFormat("dd/MM/yyyy").parse(view.getDateNaissance().getText()),view.getSexe().getText().charAt(0),view.getEmail().getText());
			} catch (ParseException e1) {
				
				e1.printStackTrace();
			}
			technicienDAO.create(tec);
			
			view.getNom().setText(null);
			view.getPrenom().setText(null);
			view.getDateNaissance().setText(null);
			view.getSexe().setText(null);
			view.getService().setText(null);
			view.getEmail().setText(null);
			view.getMdp().setText(null);
			
			view.getAjouterDialogTechnicien().dispose();
			view.getTableModelTechnicien().setRowCount(0);
			view.fillTableTechnicien(technicienDAO.findAll());
			view.fillListTechnicien(technicienDAO.findAll());
		}
	}
	/**
	 * supprime un technicien quand le bouton est cliqué
	 * @author User
	 *
	 */
	class SupprimerTechnicienOkayListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			//il faut supprimer tous les suivis du médecin avant de faire la suppression du medecin 
			//sinon erreur SQL lié à la contrainte FOREIGN KEY dans suivi
			
			String strTechnicien=view.getTechnicien().getText();
			int id =Integer.parseInt(strTechnicien.substring(0,strTechnicien.indexOf(" ")));
			
			
			technicienDAO.delete(technicienDAO.find(id));
			view.getAgAdmin().setText(null);
			
			view.getSupprimerDialogTechnicien().dispose();
			view.getTableModelTechnicien().setRowCount(0);
			view.fillTableTechnicien(technicienDAO.findAll());
			view.fillListTechnicien(technicienDAO.findAll());
		}
	}
	/**
	 * met à jour un technicien quand le bouton est cliqué
	 * @author User
	 *
	 */
	class UpdateTechnicienOkayListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			String strTechnicien=view.getTechnicien().getText();
			
			int id =Integer.parseInt(strTechnicien.substring(0,strTechnicien.indexOf(" ")));
			Technicien updateTec= technicienDAO.find(id);
			
			
			updateTec.setEmail(view.getEmail().getText());
			updateTec.setMdp(view.getMdp().getText());
			
			technicienDAO.update(updateTec);
			
			view.getTechnicien().setText(null);
			view.getNom().setText(null);
			view.getPrenom().setText(null);
			view.getDateNaissance().setText(null);
			view.getSexe().setText(null);
			view.getService().setText(null);
			view.getEmail().setText(null);
			view.getMdp().setText(null);
			
			view.getUpdateDialogTechnicien().dispose();
			view.getTableModelTechnicien().setRowCount(0);
			view.fillTableTechnicien(technicienDAO.findAll());
			view.fillListTechnicien(technicienDAO.findAll());

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
