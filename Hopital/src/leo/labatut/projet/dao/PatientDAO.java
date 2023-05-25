package leo.labatut.projet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import leo.labatut.projet.model.Patient;

public class PatientDAO extends DAO<Patient>{
	
		public PatientDAO(Connection connection) {
			super(connection);	
		}

		@Override
		public boolean create(Patient obj) {
			String sql="INSERT INTO patient(nom, prenom, date_naissance, email, date_creation, sexe) VALUES ('"+obj.getNom()+"','"+obj.getPrenom()+"','"+new java.sql.Date(obj.getDateNaissance().getTime())+"','"+obj.getEmail()+"','"+obj.getDateCreation()+"','"+obj.getSexe()+"')";
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
		public boolean delete(Patient obj) {
			boolean bool = false;
			String s = "DELETE FROM patient WHERE id = "+obj.getId();
			
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
		public boolean update(Patient obj) {
			String sql="UPDATE patient SET nom = '"+obj.getNom()+"', prenom = '"+obj.getPrenom()
					+ "' WHERE patient_id = "+obj.getId();
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
		public ArrayList<Patient> findAll(){
			
			String sql="SELECT * FROM patient;";
			Statement stmt= null;
			ResultSet rs=null;
			
			int i;
			String s1,s2,s3;
			Date dateNaissance,dateCreation;
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
					i = rs.getInt("patient_id");
					s1 = rs.getString("nom");
					s2 = rs.getString("prenom");
					dateNaissance= rs.getDate("date_naissance");
					s3 = rs.getString("email");
					dateCreation=rs.getDate("date_creation");
					ch= rs.getString("sexe").charAt(0);
					
					this.listDAO.add( new Patient(i,s1,s2,dateNaissance,s3,dateCreation,ch)) ;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			return this.listDAO;
		}
		
		@Override
		public Patient find(int id){
			
			String sql="SELECT * FROM patient WHERE patient_id = "+id;
			Statement stmt= null;
			ResultSet rs=null;
			
			Patient patient=null;
			
			int i;
			String s1,s2,s3;
			Date dateNaissance,dateCreation;
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
					i = rs.getInt("patient_id");
					s1 = rs.getString("nom");
					s2 = rs.getString("prenom");
					dateNaissance= rs.getDate("date_naissance");
					s3 = rs.getString("email");
					dateCreation=rs.getDate("date_creation");
					ch= rs.getString("sexe").charAt(0);
					
					patient= new Patient(i,s1,s2,dateNaissance,s3,dateCreation,ch) ;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			return patient;
		
		}
		
		public Patient find(String nom){
			
			String sql="SELECT * FROM patient WHERE nom = '"+nom+"'";
			Statement stmt= null;
			ResultSet rs=null;
			
			Patient patient=null;
			
			int i;
			String s1,s2,s3;
			Date dateNaissance,dateCreation;
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
					i = rs.getInt("patient_id");
					s1 = rs.getString("nom");
					s2 = rs.getString("prenom");
					dateNaissance= rs.getDate("date_naissance");
					s3 = rs.getString("email");
					dateCreation=rs.getDate("date_creation");
					ch= rs.getString("sexe").charAt(0);
				patient= new Patient(i,s1,s2,dateNaissance,s3,dateCreation,ch) ;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			return patient;
		
		}
}

