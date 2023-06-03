package leo.labatut.projet.dao;

import leo.labatut.projet.model.Service;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import leo.labatut.projet.model.Medecin;

public class MedecinDAO extends DAO<Medecin>{
	
		public MedecinDAO(Connection connection) {
			super(connection);	
		}

		@Override
		public boolean create(Medecin obj) {
			String sql="INSERT INTO medecin(nom, prenom, date_naissance,sexe, email,mdp,service_id) VALUES ('"+obj.getNom()+"','"+obj.getPrenom()+"','"+new java.sql.Date(obj.getDateNaissance().getTime())+"','"+obj.getSexe()+"','"+obj.getEmail()+"','"+obj.getMdp()+"','"+obj.getService().getId()+"')";
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
		public boolean delete(Medecin obj) {
			boolean bool = false;
			String s = "DELETE FROM medecin WHERE medecin_id = "+obj.getId();
			
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
		public boolean update(Medecin obj) {
			String sql="UPDATE medecin SET nom = '"+obj.getNom()+"', prenom = '"+obj.getPrenom()
					+ "' WHERE medecin_id = "+obj.getId();
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
		public ArrayList<Medecin> findAll(){
			
			this.listDAO.clear();
			
			String sql="SELECT * FROM medecin;";
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
					i = rs.getInt("Medecin_id");
					s1 = rs.getString("nom");
					s2 = rs.getString("prenom");
					dateNaissance= rs.getDate("date_naissance");
					ch= rs.getString("sexe").charAt(0);
					service = rs.getInt("service_id");
					s3 = rs.getString("email");
					this.listDAO.add( new Medecin(i,s1,s2,dateNaissance,ch,dao.find(service),s3)) ;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			return this.listDAO;
		}
		
		@Override
		public Medecin find(int id){
			
			String sql="SELECT * FROM medecin WHERE medecin_id = "+id+";";
			Statement stmt= null;
			ResultSet rs=null;
			
			Medecin medecin=null;
			
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
					i = rs.getInt("medecin_id");
					s1 = rs.getString("nom");
					s2 = rs.getString("prenom");
					dateNaissance= rs.getDate("date_naissance");
					ch= rs.getString("sexe").charAt(0);
					service = rs.getInt("service_id");
					s3 = rs.getString("email");
					medecin= new Medecin(i,s1,s2,dateNaissance,ch,dao.find(service),s3) ;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			return medecin;
		
		}
		
		public Medecin find(String nom){
			
			String sql="SELECT * FROM medecin WHERE nom = '"+nom+"'";
			Statement stmt= null;
			ResultSet rs=null;
			
			Medecin medecin=null;
			
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
				i = rs.getInt("medecin_id");
				s1 = rs.getString("nom");
				s2 = rs.getString("prenom");
				dateNaissance= rs.getDate("date_naissance");
				ch= rs.getString("sexe").charAt(0);
				service= rs.getInt("service_id");
				s3 = rs.getString("email");
				dao.find(service);
				medecin= new Medecin(i,s1,s2,dateNaissance,ch,dao.find(service),s3) ;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			return medecin;
		
		}
		public ArrayList<Medecin> findByService(Service service){
			String sql="SELECT * FROM medecin WHERE service_id="+service.getId()+";";
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
					i = rs.getInt("Medecin_id");
					s1 = rs.getString("nom");
					s2 = rs.getString("prenom");
					dateNaissance= rs.getDate("date_naissance");
					ch= rs.getString("sexe").charAt(0);
					s3 = rs.getString("email");
					this.listDAO.add( new Medecin(i,s1,s2,dateNaissance,ch,service,s3)) ;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			return this.listDAO;
			
		}
}
