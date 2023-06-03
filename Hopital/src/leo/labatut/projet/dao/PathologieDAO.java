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
		String sql="INSERT INTO pathologie(nom) VALUES ('"+obj.getNom()+"')";
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
				pathologie= new Pathologie(i,s1) ;
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
				this.listDAO.add( new Pathologie(i,s1)) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return this.listDAO;
	}
	
	

}
