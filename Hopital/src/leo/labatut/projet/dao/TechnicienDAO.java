package leo.labatut.projet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import leo.labatut.projet.model.AgentAdmin;
import leo.labatut.projet.model.Technicien;

public class TechnicienDAO extends DAO<Technicien>{
	
	public TechnicienDAO(Connection connection) {
		super(connection);	
	}

	@Override
	public boolean create(Technicien obj) {
		String sql="INSERT INTO technicien(nom, prenom, date_naissance,sexe, email) VALUES ('"+obj.getNom()+"','"+obj.getPrenom()+"','"+new java.sql.Date(obj.getDateNaissance().getTime())+"','"+obj.getSexe()+"','"+obj.getEmail()+"')";
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
	public boolean delete(Technicien obj) {
		boolean bool = false;
		String s = "DELETE FROM technicien WHERE id = "+obj.getId();
		
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
	public boolean update(Technicien obj) {
		String sql="UPDATE technicien SET email = '"+obj.getEmail()+"', mdp = '"+obj.getMdp()
				+ "' WHERE technicien = "+obj.getId();
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
	public ArrayList<Technicien> findAll(){
		this.listDAO.clear();
		String sql="SELECT * FROM technicien;";
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
				i = rs.getInt("technicien_id");
				s1 = rs.getString("nom");
				s2 = rs.getString("prenom");
				dateNaissance= rs.getDate("date_naissance");
				ch= rs.getString("sexe").charAt(0);
				s3 = rs.getString("email");
				this.listDAO.add( new Technicien(i,s1,s2,dateNaissance,ch,s3)) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return this.listDAO;
	}
	
	@Override
	public Technicien find(int id){
		
		String sql="SELECT * FROM technicien WHERE technicien_id = "+id;
		Statement stmt= null;
		ResultSet rs=null;
		
		Technicien tec=null;
		
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
				i = rs.getInt("technicien_id");
				s1 = rs.getString("nom");
				s2 = rs.getString("prenom");
				dateNaissance= rs.getDate("date_naissance");
				ch= rs.getString("sexe").charAt(0);
				s3 = rs.getString("email");
				tec= new Technicien(i,s1,s2,dateNaissance,ch,s3) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return tec;
	
	}
	
	public Technicien find(String nom){
		
		String sql="SELECT * FROM technicien WHERE nom = '"+nom+"'";
		Statement stmt= null;
		ResultSet rs=null;
		
		Technicien tec=null;
		
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
			i = rs.getInt("technicien_id");
			s1 = rs.getString("nom");
			s2 = rs.getString("prenom");
			dateNaissance= rs.getDate("date_naissance");
			ch= rs.getString("sexe").charAt(0);
			s3 = rs.getString("email");
			tec= new Technicien(i,s1,s2,dateNaissance,ch,s3) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return tec;
	
	}
}
