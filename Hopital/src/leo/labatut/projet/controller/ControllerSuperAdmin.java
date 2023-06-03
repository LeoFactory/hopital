package leo.labatut.projet.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import leo.labatut.projet.dao.AgentAdminDAO;
import leo.labatut.projet.dao.InfirmierDAO;
import leo.labatut.projet.dao.MedecinDAO;
import leo.labatut.projet.dao.ServiceDAO;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Service;
import leo.labatut.projet.view.InterfaceSuperAdmin;

public class ControllerSuperAdmin {
	
	private MedecinDAO medecinDAO;
	private InfirmierDAO infirmierDAO;
	private AgentAdminDAO agAdminDAO;
	private InterfaceSuperAdmin view;
	
	public ControllerSuperAdmin(Connection cn,InterfaceSuperAdmin view) {
		
		this.medecinDAO=new MedecinDAO(cn);
		this.agAdminDAO=new AgentAdminDAO(cn);
		this.infirmierDAO= new InfirmierDAO(cn);
		
		this.view=view;
		this.view.fillTableMedecins(this.medecinDAO.findAll());
		this.view.getOkayButton_ajouterMedecin().addActionListener(new AjouterMedecinOkayListener());
		this.view.getOkayButton_supprimerMedecin().addActionListener(new SupprimerMedecinOkayListener());
		
		this.view.fillTableAgAdmin(this.agAdminDAO.findAll());
		
		this.view.fillTableInfirmier(this.infirmierDAO.findAll());
		
		

	}
	class AjouterMedecinOkayListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			ServiceDAO serviceDAO = new ServiceDAO(medecinDAO.getConnection());
			Service service = serviceDAO.find(view.getService().getText());
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
			
			view.getAjouterMedecinDialog().dispose();
			view.getTableModelMedecins().setRowCount(0);
			view.fillTableMedecins(medecinDAO.findAll());

			}
		}
	class SupprimerMedecinOkayListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			//il faut supprimer tous les suivis du médecin avant de faire la suppression du medecin 
			//sinon erreur SQL lié à la contrainte FOREIGN KEY dans suivi
			
			medecinDAO.delete(medecinDAO.find(Integer.parseInt(view.getId().getText())));
			view.getId().setText(null);
			
			view.getSupprimerMedecinDialog().dispose();
			view.getTableModelMedecins().setRowCount(0);
			view.fillTableMedecins(medecinDAO.findAll());
		}
	}
			
}
