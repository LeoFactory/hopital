package leo.labatut.projet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import leo.labatut.projet.model.Infirmier;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Service;

public class InfirmierDAO extends DAO<Infirmier>{
	
	public InfirmierDAO(Connection connection) {
		super(connection);	
	}

	@Override
	public boolean create(Infirmier obj) {
		String sql="INSERT INTO infirmier(nom, prenom, date_naissance,sexe, email,mdp) VALUES ('"+obj.getNom()+"','"+obj.getPrenom()+"','"+new java.sql.Date(obj.getDateNaissance().getTime())+"','"+obj.getSexe()+"','"+obj.getEmail()+"','"+obj.getMdp()+"')";
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
	public boolean delete(Infirmier obj) {
		boolean bool = false;
		String s = "DELETE FROM infirmier WHERE infirmier_id = "+obj.getId();
		
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
	public boolean update(Infirmier obj) {
		String sql="UPDATE infirmier SET nom = '"+obj.getNom()+"', prenom = '"+obj.getPrenom()
				+ "' WHERE infirmier_id = "+obj.getId();
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
	public ArrayList<Infirmier> findAll(){
		
		this.listDAO.clear();
		
		String sql="SELECT * FROM infirmier;";
		Statement stmt= null;
		ResultSet rs=null;
		
		int i,service;
		String s1,s2,s3;
		Date dateNaissance;
		char ch;
		ServiceDAO dao = new ServiceDAO(cn);
		
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				i = rs.getInt("infirmier_id");
				s1 = rs.getString("nom");
				s2 = rs.getString("prenom");
				dateNaissance= rs.getDate("date_naissance");
				ch= rs.getString("sexe").charAt(0);
				s3 = rs.getString("email");
				this.listDAO.add( new Infirmier(i,s1,s2,dateNaissance,ch,s3)) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return this.listDAO;
	}
	
	@Override
	public Infirmier find(int id){
		
		String sql="SELECT * FROM infirmier WHERE infirmier_id = "+id+";";
		Statement stmt= null;
		ResultSet rs=null;
		
		Infirmier infirmier=null;
		
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
				i = rs.getInt("infirmier_id");
				s1 = rs.getString("nom");
				s2 = rs.getString("prenom");
				dateNaissance= rs.getDate("date_naissance");
				ch= rs.getString("sexe").charAt(0);
				
				s3 = rs.getString("email");
				infirmier= new Infirmier(i,s1,s2,dateNaissance,ch,s3) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return infirmier;
	
	}
	
	public Infirmier find(String nom){
		
		String sql="SELECT * FROM infirmier WHERE nom = '"+nom+"'";
		Statement stmt= null;
		ResultSet rs=null;
		
		Infirmier infirmier=null;
		
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
			i = rs.getInt("infirmier_id");
			s1 = rs.getString("nom");
			s2 = rs.getString("prenom");
			dateNaissance= rs.getDate("date_naissance");
			ch= rs.getString("sexe").charAt(0);
			s3 = rs.getString("email");
			infirmier= new Infirmier(i,s1,s2,dateNaissance,ch,s3) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return infirmier;
	
	}
	
}
