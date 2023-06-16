package leo.labatut.projet.dao;

import leo.labatut.projet.model.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class PathologieDAO extends DAO<Pathologie> {

	public PathologieDAO(Connection connection) {
		super(connection);
		
	}

	@Override
	public boolean create(Pathologie obj) {
		String sql="INSERT INTO pathologie(nom,service) VALUES ('"+obj.getNom()+"',"+obj.getService().getId()+")";
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
	public boolean delete(Pathologie obj) {
		boolean bool = false;
		String s = "DELETE FROM pathologie WHERE id = "+obj.getId();
		
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
	public boolean update(Pathologie obj) {
		String sql="UPDATE pathologie SET nom = '"+obj.getNom()+ "' WHERE pathologie_id= "+obj.getId();
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
	public Pathologie find(int id) {
		String sql="SELECT * FROM pathologie WHERE pathologie_id = "+id+";";
		Statement stmt= null;
		ResultSet rs=null;
		
		Pathologie pathologie=null;
		Service service;
		ServiceDAO serviceDAO = new ServiceDAO(cn);
		
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
				i = rs.getInt("pathologie_id");
				s1 = rs.getString("nom");
				service= serviceDAO.find(rs.getInt("service"));
				pathologie= new Pathologie(i,s1,service) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return pathologie;
	}

	@Override
	public ArrayList<Pathologie> findAll() {
		listDAO.clear();
		String sql="SELECT * FROM pathologie;";
		Statement stmt= null;
		ResultSet rs=null;
		
		int i;
		String s1;
		Service service;
		ServiceDAO serviceDAO = new ServiceDAO(cn);
		
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				i = rs.getInt("pathologie_id");
				s1 = rs.getString("nom");
				service= serviceDAO.find(rs.getInt("service"));
				this.listDAO.add( new Pathologie(i,s1,service)) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return this.listDAO;
	}
	public ArrayList<Pathologie> findByService(Service service) {
		listDAO.clear();
		String sql="SELECT * FROM pathologie WHERE service= "+service.getId() +";";
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
				i = rs.getInt("pathologie_id");
				s1 = rs.getString("nom");
				this.listDAO.add( new Pathologie(i,s1,service)) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return this.listDAO;
	}
	
	

}
