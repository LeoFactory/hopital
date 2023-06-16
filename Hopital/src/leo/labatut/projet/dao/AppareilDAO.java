package leo.labatut.projet.dao;

import leo.labatut.projet.model.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class AppareilDAO extends DAO<Appareil> {

	public AppareilDAO(Connection connection) {
		super(connection);
		
	}

	@Override
	public boolean create(Appareil obj) {
		String sql="INSERT INTO appareil(libelle) VALUES ('"+obj.getLibelle()+"')";
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
	public boolean delete(Appareil obj) {
		boolean bool = false;
		String s = "DELETE FROM appareil WHERE appareil_id = "+obj.getId();
		
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
	public boolean update(Appareil obj) {
		String sql="UPDATE appareil SET libelle = '"+obj.getLibelle()+ "' WHERE appareil_id= "+obj.getId();
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
	public Appareil find(int id) {
		String sql="SELECT * FROM appareil WHERE appareil_id = "+id+";";
		Statement stmt= null;
		ResultSet rs=null;
		
		Appareil appareil=null;
		
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
				i = rs.getInt("appareil_id");
				s1 = rs.getString("libelle");
				appareil= new Appareil(i,s1) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return appareil;
	}

	@Override
	public ArrayList<Appareil> findAll() {
		this.listDAO.clear();
		String sql="SELECT * FROM appareil;";
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
				i = rs.getInt("appareil_id");
				s1 = rs.getString("libelle");
				this.listDAO.add( new Appareil(i,s1)) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return this.listDAO;
	}
	
	

}
