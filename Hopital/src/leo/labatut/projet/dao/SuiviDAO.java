package leo.labatut.projet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import leo.labatut.projet.model.AgentAdmin;
import leo.labatut.projet.model.Medecin;
import leo.labatut.projet.model.Suivi;

public class SuiviDAO extends DAO<Suivi>{
	
	public SuiviDAO(Connection connection) {
		super(connection);
	}

	@Override
	public boolean create(Suivi obj) {
		String sql="INSERT INTO suivi(patient_id, pathologie_id, medecin_id) VALUES ('"+obj.getPatient().getId()+"','"+obj.getPathologie().getId()+"','"+obj.getMedecin().getId()+"')";
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
	public boolean delete(Suivi obj) {
		boolean bool = false;
		String s = "DELETE FROM suivi WHERE id = "+obj.getId();
		
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
	public boolean update(Suivi obj) {
		String sql="UPDATE suivi SET patient_id = '"+obj.getPatient().getId()+"', pathologie_id = '"+obj.getPathologie().getId()+"', medecin_id = '"+obj.getMedecin().getId()
		+ "' WHERE suivi_id = "+obj.getId();
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
	public Suivi find(int id) {
		String sql="SELECT * FROM suivi WHERE suivi_id = "+id;
		Statement stmt= null;
		ResultSet rs=null;
		
		Suivi suivi=null;
		
		int i,j,k,l;
		PatientDAO patientDAO = new PatientDAO(this.cn);
		PathologieDAO pathologieDAO = new PathologieDAO(this.cn);
		MedecinDAO medecinDAO = new MedecinDAO(this.cn);
		
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				i = rs.getInt("suivi_id");
				j = rs.getInt("patient_id");
				k = rs.getInt("pathologie_id");
				l = rs.getInt("medecin_id");
				suivi= new Suivi(i,patientDAO.find(j),pathologieDAO.find(k),medecinDAO.find(l)) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return suivi;
	}

	@Override
	public ArrayList<Suivi> findAll() {
		listDAO.clear();
		String sql="SELECT * FROM suivi;";
		Statement stmt= null;
		ResultSet rs=null;
		
		int i,j,k,l;
		PatientDAO patientDAO = new PatientDAO(this.cn);
		PathologieDAO pathologieDAO = new PathologieDAO(this.cn);
		MedecinDAO medecinDAO = new MedecinDAO(this.cn);
	
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				i = rs.getInt("suivi_id");
				j = rs.getInt("patient_id");
				k = rs.getInt("pathologie_id");
				l = rs.getInt("medecin_id");
					
				this.listDAO.add( new Suivi(i,patientDAO.find(j),pathologieDAO.find(k),medecinDAO.find(l))) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return this.listDAO;
	}
	public ArrayList findByMedecin(Medecin medecin) {
		listDAO.clear();
		String sql="SELECT * FROM suivi WHERE medecin_id = "+medecin.getId();
		Statement stmt= null;
		ResultSet rs=null;
		
		int i,j,k,l;
		PatientDAO patientDAO = new PatientDAO(this.cn);
		PathologieDAO pathologieDAO = new PathologieDAO(this.cn);
		MedecinDAO medecinDAO = new MedecinDAO(this.cn);
		
		try {	
			stmt = cn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				i = rs.getInt("suivi_id");
				j = rs.getInt("patient_id");
				k = rs.getInt("pathologie_id");
				l = rs.getInt("medecin_id");
				this.listDAO.add( new Suivi(i,patientDAO.find(j),pathologieDAO.find(k),medecinDAO.find(l))) ;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return this.listDAO;
	}

}
