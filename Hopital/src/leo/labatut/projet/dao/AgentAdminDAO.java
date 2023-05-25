package leo.labatut.projet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import leo.labatut.projet.model.AgentAdmin;

public class AgentAdminDAO extends DAO<AgentAdmin>{
	
		public AgentAdminDAO(Connection connection) {
			super(connection);	
		}

		@Override
		public boolean create(AgentAdmin obj) {
			String sql="INSERT INTO agent_admin(nom, prenom, date_naissance,sexe, email) VALUES ('"+obj.getNom()+"','"+obj.getPrenom()+"','"+new java.sql.Date(obj.getDateNaissance().getTime())+"','"+obj.getSexe()+"','"+obj.getEmail()+"')";
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
		public boolean delete(AgentAdmin obj) {
			boolean bool = false;
			String s = "DELETE FROM agent_admin WHERE id = "+obj.getId();
			
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
		public boolean update(AgentAdmin obj) {
			String sql="UPDATE agent_admin SET nom = '"+obj.getNom()+"', prenom = '"+obj.getPrenom()
					+ "' WHERE agent_admin_id = "+obj.getId();
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
		public ArrayList<AgentAdmin> findAll(){
			
			String sql="SELECT * FROM agent_admin;";
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
					i = rs.getInt("agent_admin_id");
					s1 = rs.getString("nom");
					s2 = rs.getString("prenom");
					dateNaissance= rs.getDate("date_naissance");
					ch= rs.getString("sexe").charAt(0);
					s3 = rs.getString("email");
					this.listDAO.add( new AgentAdmin(i,s1,s2,dateNaissance,ch,s3)) ;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			return this.listDAO;
		}
		
		@Override
		public AgentAdmin find(int id){
			
			String sql="SELECT * FROM agent_admin WHERE agent_admin_id = "+id;
			Statement stmt= null;
			ResultSet rs=null;
			
			AgentAdmin agAdmin=null;
			
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
					i = rs.getInt("agent_admin_id");
					s1 = rs.getString("nom");
					s2 = rs.getString("prenom");
					dateNaissance= rs.getDate("date_naissance");
					ch= rs.getString("sexe").charAt(0);
					s3 = rs.getString("email");
					agAdmin= new AgentAdmin(i,s1,s2,dateNaissance,ch,s3) ;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			return agAdmin;
		
		}
		
		public AgentAdmin find(String nom){
			
			String sql="SELECT * FROM agent_admin WHERE nom = '"+nom+"'";
			Statement stmt= null;
			ResultSet rs=null;
			
			AgentAdmin agAdmin=null;
			
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
				i = rs.getInt("agent_admin_id");
				s1 = rs.getString("nom");
				s2 = rs.getString("prenom");
				dateNaissance= rs.getDate("date_naissance");
				ch= rs.getString("sexe").charAt(0);
				s3 = rs.getString("email");
				agAdmin= new AgentAdmin(i,s1,s2,dateNaissance,ch,s3) ;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			return agAdmin;
		
		}
}
