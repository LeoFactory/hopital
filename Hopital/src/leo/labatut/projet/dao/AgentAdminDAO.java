package leo.labatut.projet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import leo.labatut.projet.model.AgentAdmin;

public class AgentAdminDAO extends DAO<AgentAdmin>{
	
		public AgentAdminDAO(Connection connection) {
			super(connection);
		}

		@Override
		public boolean create(AgentAdmin obj) {
			String sql="INSERT INTO agentadmin(nom, prenom) VALUES ('"+obj.getNom()+"','"+obj.getPrenom()+"')";
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
			String s = "DELETE FROM agentadmin WHERE id = "+obj.getId();
			
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
			String sql="UPDATE agentadmin SET nom = '"+obj.getNom()+"', prenom = '"+obj.getPrenom()
					+ "' WHERE id = "+obj.getId();
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
		public AgentAdmin find(int id){
			
			String sql="SELECT * FROM agentadmin WHERE id = "+id;
			Statement stmt= null;
			ResultSet rs=null;
			
			AgentAdmin agAdmin=null;
			
			int i;
			String s1,s2;
			
			try {	
				stmt = cn.createStatement();
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				while (rs.next()) {
				i = rs.getInt("id");
				s1 = rs.getString("nom");
				s2 = rs.getString("prenom");
				agAdmin= new AgentAdmin(i,s1,s2) ;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			return agAdmin;
		
		}
		
		public AgentAdmin find(String nom){
			
			String sql="SELECT * FROM agentadmin WHERE nom = '"+nom+"'";
			Statement stmt= null;
			ResultSet rs=null;
			
			AgentAdmin agAdmin=null;
			
			int i;
			String s1,s2;
			
			try {	
				stmt = cn.createStatement();
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				while (rs.next()) {
				i = rs.getInt("id");
				s1 = rs.getString("nom");
				s2 = rs.getString("prenom");
				agAdmin= new AgentAdmin(i,s1,s2) ;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			return agAdmin;
		
		}
}
