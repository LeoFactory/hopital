package leo.labatut.projet.controller;

import leo.labatut.projet.dao.SuperAdminDAO;
import leo.labatut.projet.view.SuperAdminView;

public class SuperAdminController {
	
	private SuperAdminDAO dao;
	private SuperAdminView view;
	
	public SuperAdminController(SuperAdminDAO dao,SuperAdminView view) {
		this.dao=dao;
		this.view=view;
	}

}
