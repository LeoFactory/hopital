package leo.labatut.projet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import leo.labatut.projet.model.Appareil;
import leo.labatut.projet.model.Chambre;
import leo.labatut.projet.model.Infirmier;
import leo.labatut.projet.model.Service;

public class ChambreDAO extends DAO<Chambre>{

	public ChambreDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Chambre obj) {
		String sql="INSERT INTO chambre(capacite,service_id) VALUES ("+obj.getCapacite()+","+obj.getService().getId()+")";
		Statement stmt= null;	
		
		boolean bool =false;
		
		try {	
			stmt = cn.createStatement();
			int res = stmt.executeUpdate(sql);
			bool=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bool;
	}

	@Override
	public boolean delete(Chambre obj) {
		boolean bool = false;
		String s = "DELETE FROM chambre WHERE id = "+obj.getId();
		
		Statement stmt=null;
		
		try {
			stmt = cn.createStatement();
			int i = stmt.executeUpdate(s);
			bool=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return bool;
	}

	@Override
	public boolean update(Chambre obj) {
		String sql="UPDATE chambre SET nb_patients = "+obj.getNbPatient()+", capacite = "+obj.getCapacite()+", service_id = "+ obj.getService().getId()+", infirmier_id = "+ obj.getInfirmier().getId()+ " WHERE id = "+obj.getId();
		Statement stmt= null;	

		boolean bool =false;


		try {	
			stmt = cn.createStatement();
			int res = stmt.executeUpdate(sql);
			bool=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bool;
	}

	@Override
	public Chambre find(int id) {
		String sql="SELECT * FROM chambre WHERE id = "+id+";";
		Statement stmt= null;
		ResultSet rs=null;
		
		Chambre chambre=null;
		Service service = null;
		ServiceDAO serviceDAO = new ServiceDAO(cn);
		Infirmier infirmier= null;
		InfirmierDAO infirmierDAO = new InfirmierDAO(cn);
		
		int i,j,k,l,m;
	
		
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				i = rs.getInt("id");
				j = rs.getInt("capacite");
				k = rs.getInt("service_id");
				l = rs.getInt("nb_patients");
				m = rs.getInt("infirmier_id");
				service= serviceDAO.find(k);
				infirmier = infirmierDAO.find(m);
				chambre= new Chambre(i,j,service,l,infirmier) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return chambre;
	}

	@Override
	public ArrayList<Chambre> findAll() {
		
		this.listDAO.clear();
		String sql="SELECT * FROM chambre;";
		Statement stmt= null;
		ResultSet rs=null;
		
		Service service = null;
		ServiceDAO serviceDAO = new ServiceDAO(cn);
		Infirmier infirmier= null;
		InfirmierDAO infirmierDAO = new InfirmierDAO(cn);
		
		int i,j,k,l,m;
		
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				i = rs.getInt("id");
				j = rs.getInt("capacite");
				k = rs.getInt("service_id");
				l = rs.getInt("nb_patients");
				m = rs.getInt("infirmier_id");
				service= serviceDAO.find(k);
				infirmier = infirmierDAO.find(m);
				listDAO.add(new Chambre(i,j,service,l,infirmier) );
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return this.listDAO;
	}
	public ArrayList<Chambre> findByInfirmier(Infirmier obj) {
		
		this.listDAO.clear();
		String sql="SELECT * FROM chambre WHERE infirmier_id = "+obj.getId()+";";
		Statement stmt= null;
		ResultSet rs=null;
		
		Service service = null;
		ServiceDAO serviceDAO = new ServiceDAO(cn);
		Infirmier infirmier= null;
		InfirmierDAO infirmierDAO = new InfirmierDAO(cn);
		
		int i,j,k,l,m;
		
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				i = rs.getInt("id");
				j = rs.getInt("capacite");
				k = rs.getInt("service_id");
				l = rs.getInt("nb_patients");
				m = rs.getInt("infirmier_id");
				service= serviceDAO.find(k);
				infirmier = infirmierDAO.find(m);
				listDAO.add(new Chambre(i,j,service,l,infirmier) );
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return this.listDAO;
	}
	
	

}
