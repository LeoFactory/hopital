package leo.labatut.projet.controller;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;

import leo.labatut.projet.dao.MedecinDAO;
import leo.labatut.projet.dao.ServiceDAO;
import leo.labatut.projet.view.MedecinView;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Service;

public class MedecinController {
	
	private MedecinDAO dao;
	private MedecinView view;
	
	public MedecinController(MedecinDAO dao, MedecinView view) {
		this.dao=dao;
		this.view=view;
		this.view.fillTable(this.dao.findAll());
		this.view.getOkayButton().addActionListener(new AjouterOkayListener());
		
		

	}
	class AjouterOkayListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			ServiceDAO serviceDAO = new ServiceDAO(dao.getConnection());
			Service service = serviceDAO.find(view.getService().getText());
			Medecin newMedecin= null;
			try {
				newMedecin= new Medecin(view.getNom().getText(),view.getPrenom().getText(),new SimpleDateFormat("dd/MM/yyyy").parse(view.getDateNaissance().getText()),view.getSexe().getText().charAt(0),service,view.getEmail().getText(),view.getMdp().getText());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dao.create(newMedecin);
			
			view.getNom().setText(null);
			view.getPrenom().setText(null);
			view.getDateNaissance().setText(null);
			view.getSexe().setText(null);
			view.getService().setText(null);
			view.getEmail().setText(null);
			view.getMdp().setText(null);
			
			view.getAjouterDialog().dispose();
			view.getTableModel().setRowCount(0);
			view.fillTable(dao.findAll());

			}
		}
			
}
