package leo.labatut.projet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import leo.labatut.projet.model.AgentAdmin;
import leo.labatut.projet.model.Personnel;
import leo.labatut.projet.model.SuperAdmin;

public class SuperAdminDAO extends DAO<SuperAdmin> {
	
	public SuperAdminDAO(Connection connection) {
		super(connection);	
	}

	@Override
	public boolean create(SuperAdmin obj) {
		String sql="INSERT INTO super_admin(nom, prenom, date_naissance,sexe, email) VALUES ('"+obj.getNom()+"','"+obj.getPrenom()+"','"+new java.sql.Date(obj.getDateNaissance().getTime())+"','"+obj.getSexe()+"','"+obj.getEmail()+"')";
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
	public boolean delete(SuperAdmin obj) {
		boolean bool = false;
		String s = "DELETE FROM super_admin WHERE id = "+obj.getId();
		
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
	public boolean update(SuperAdmin obj) {
		String sql="UPDATE super_admin SET nom = '"+obj.getNom()+"', prenom = '"+obj.getPrenom()
				+ "' WHERE super_admin_id = "+obj.getId();
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
	public ArrayList<SuperAdmin> findAll(){
		
		String sql="SELECT * FROM super_admin;";
		Statement stmt= null;
		ResultSet rs=null;
		
		int i;
		String s1,s2,s3;
		Date dateNaissance;
		char ch;
		
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				i = rs.getInt("super_admin_id");
				s1 = rs.getString("nom");
				s2 = rs.getString("prenom");
				dateNaissance= rs.getDate("date_naissance");
				ch= rs.getString("sexe").charAt(0);
				s3 = rs.getString("email");
				this.listDAO.add( new SuperAdmin(i,s1,s2,dateNaissance,ch,s3)) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return this.listDAO;
	}
	
	@Override
	public SuperAdmin find(int id){
		
		String sql="SELECT * FROM super_admin WHERE super_admin_id = "+id;
		Statement stmt= null;
		ResultSet rs=null;
		
		SuperAdmin superAdmin=null;
		
		int i;
		String s1,s2,s3;
		Date dateNaissance;
		char ch;
		
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				i = rs.getInt("super_admin_id");
				s1 = rs.getString("nom");
				s2 = rs.getString("prenom");
				dateNaissance= rs.getDate("date_naissance");
				ch= rs.getString("sexe").charAt(0);
				s3 = rs.getString("email");
				superAdmin= new SuperAdmin(i,s1,s2,dateNaissance,ch,s3) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return superAdmin;
	
	}
	
	public AgentAdmin find(String nom){
		
		String sql="SELECT * FROM super_admin_id WHERE nom = '"+nom+"'";
		Statement stmt= null;
		ResultSet rs=null;
		
		AgentAdmin superAdmin=null;
		
		int i;
		String s1,s2,s3;
		Date dateNaissance;
		char ch;
		
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
			i = rs.getInt("super_admin_id");
			s1 = rs.getString("nom");
			s2 = rs.getString("prenom");
			dateNaissance= rs.getDate("date_naissance");
			ch= rs.getString("sexe").charAt(0);
			s3 = rs.getString("email");
			superAdmin= new AgentAdmin(i,s1,s2,dateNaissance,ch,s3) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return superAdmin;
	
	}
}
