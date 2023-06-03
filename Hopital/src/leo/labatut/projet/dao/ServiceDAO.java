package leo.labatut.projet.dao;

import leo.labatut.projet.model.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ServiceDAO extends DAO<Service> {

	public ServiceDAO(Connection connection) {
		super(connection);
		
	}

	@Override
	public boolean create(Service obj) {
		String sql="INSERT INTO service(nom) VALUES ('"+obj.getNom()+"')";
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
	public boolean delete(Service obj) {
		boolean bool = false;
		String s = "DELETE FROM service WHERE service_id = "+obj.getId();
		
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
	public boolean update(Service obj) {
		String sql="UPDATE service SET nom = '"+obj.getNom()+ "' WHERE service_id= "+obj.getId();
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
	public Service find(int id) {
		String sql="SELECT * FROM service WHERE service_id = "+id+";";
		Statement stmt= null;
		ResultSet rs=null;
		
		Service service=null;
		
		int i;
		String s1;
	
		
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				i = rs.getInt("service_id");
				s1 = rs.getString("nom");
				service= new Service(i,s1) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return service;
	}
	
	public Service find(String nom) {
		String sql="SELECT * FROM service WHERE nom = '"+nom+"';";
		Statement stmt= null;
		ResultSet rs=null;
		
		Service service=null;
		
		int i;
		String s1;
	
		
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				i = rs.getInt("service_id");
				s1 = rs.getString("nom");
				service= new Service(i,s1) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return service;
	}

	@Override
	public ArrayList<Service> findAll() {
		String sql="SELECT * FROM service;";
		Statement stmt= null;
		ResultSet rs=null;
		
		int i;
		String s1;
		
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				i = rs.getInt("Medecin_id");
				s1 = rs.getString("nom");
				this.listDAO.add( new Service(i,s1)) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return this.listDAO;
	}
	
	

}
