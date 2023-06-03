package leo.labatut.projet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import leo.labatut.projet.model.Consultation;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Service;
import leo.labatut.projet.model.Suivi;
import java.text.SimpleDateFormat;

public class ConsultationDAO extends DAO<Consultation>{

	public ConsultationDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Consultation obj) {
		String sql="INSERT INTO consultation( suivi_id, date_consultation) VALUES ("+obj.getSuivi().getId()+",'"+new java.sql.Date(obj.getDate().getTime())+"')";
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
	public boolean delete(Consultation obj) {
		boolean bool = false;
		String s = "DELETE FROM consultation WHERE consultation_id = "+obj.getId();
		
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
	public boolean update(Consultation obj) {
		String sql="UPDATE consultation SET suivi_id = '"+obj.getSuivi().getId()+ "' WHERE consultation_id= "+obj.getId();
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
	public Consultation find(int id) {
		String sql="SELECT * FROM consultation WHERE consultation_id = "+id+";";
		Statement stmt= null;
		ResultSet rs=null;
		
		Consultation consultation = null;
		Suivi suivi=null;
		SuiviDAO suiviDAO = new SuiviDAO(cn);
		
		int i;
		Date date;
	
		
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				i = rs.getInt("consultation_id");
				date = rs.getDate("date_consultation");
				suivi= suiviDAO.find(rs.getInt("suivi_id"));
				consultation=new Consultation (i,suivi,date);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return consultation;
	}

	@Override
	public ArrayList<Consultation> findAll() {
		listDAO.clear();
		String sql="SELECT * FROM consultation;";
		Statement stmt= null;
		ResultSet rs=null;
		
		Suivi suivi=null;
		SuiviDAO suiviDAO = new SuiviDAO(cn);
		
		int i;
		Date date;
		
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				i = rs.getInt("consultation_id");
				date = rs.getDate("date_consultation");
				suivi= suiviDAO.find(rs.getInt("suivi_id"));
				listDAO.add(new Consultation (i,suivi,date));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return this.listDAO;
	}
	public ArrayList<Consultation> findBySuivi(Suivi suivi) {
		listDAO.clear();
		String sql="SELECT * FROM consultation WHERE suivi_id = "+suivi.getId()+";";
		Statement stmt= null;
		ResultSet rs=null;
		
		int i;
		Date date;
		
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				i = rs.getInt("consultation_id");
				date = rs.getDate("date_consultation");
				listDAO.add(new Consultation (i,suivi,date));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return this.listDAO;
	}
	public ArrayList<Consultation> findByMedecin(Medecin medecin) {
		listDAO.clear();
		String sql= "SELECT * FROM consultation INNER JOIN suivi ON consultation.suivi_id=suivi.suivi_id WHERE medecin_id=" +medecin.getId()+";";
		Statement stmt= null;
		ResultSet rs=null;
		
		int i;
		Date date;
		Suivi suivi=null;
		SuiviDAO suiviDAO = new SuiviDAO(cn);
		
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				i = rs.getInt("consultation_id");
				date = rs.getDate("date_consultation");
				suivi= suiviDAO.find(rs.getInt("suivi_id"));
				listDAO.add(new Consultation (i,suivi,date));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return this.listDAO;
	}

}
