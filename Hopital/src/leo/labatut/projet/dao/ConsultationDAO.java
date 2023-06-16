package leo.labatut.projet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import leo.labatut.projet.model.Appareil;
import leo.labatut.projet.model.Consultation;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Service;
import leo.labatut.projet.model.Suivi;
import java.text.SimpleDateFormat;

public class ConsultationDAO extends DAO<Consultation>{

	public ConsultationDAO(Connection connection) {
		super(connection);
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
		String sql="UPDATE consultation SET suivi_id = "+obj.getSuivi().getId()+", ordonnance = '"+obj.getOrdonnance()+"', soin = '"+obj.getSoin()+ "' WHERE consultation_id= "+obj.getId();
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
	public boolean updateAppareil(Consultation obj) {
		String sql="UPDATE consultation SET suivi_id = "+obj.getSuivi().getId()+", appareil_id = "+obj.getAppareil().getId()+", statut_appareil = '"+obj.getStatutAppareil()+"', ordonnance = '"+obj.getOrdonnance()+"', soin = '"+obj.getSoin()+ "' WHERE consultation_id= "+obj.getId();
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
		Appareil appareil = null;
		AppareilDAO appareilDAO = new AppareilDAO(cn);
		String statut;
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
				appareil= appareilDAO.find(rs.getInt("appareil_id"));
				statut=rs.getString("statut_appareil");
				consultation=new Consultation (i,suivi,date,appareil,statut);
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
	public ArrayList<Consultation> findByAppareilStatut() {
		listDAO.clear();
		String sql= "SELECT * FROM consultation WHERE appareil_id IS NOT NULL;";
		Statement stmt= null;
		ResultSet rs=null;
		
		int i;
		Date date;
		Suivi suivi=null;
		Appareil appareil= null;
		String statut;
		SuiviDAO suiviDAO = new SuiviDAO(cn);
		AppareilDAO appareilDAO = new AppareilDAO(cn);
		
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
				appareil= appareilDAO.find(rs.getInt("appareil_id"));
				statut = rs.getString("statut_appareil");
				listDAO.add(new Consultation (i,suivi,date,appareil,statut));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return this.listDAO;
	}

}
