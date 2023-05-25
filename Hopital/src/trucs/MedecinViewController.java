package trucs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

import leo.labatut.projet.dao.SingleConnection;
import leo.labatut.projet.view.*;

public class MedecinViewController {
	
	private MedecinViewFail medecinView;
	private String url="jdbc:mysql://localhost/hopitalbd";
	private String login="root";
	private String password="";
	private Connection con =SingleConnection.getInstance(url, login, password);
	
	public MedecinViewController(MedecinViewFail medecinView) {
		
		this.medecinView=medecinView;
		setTable();
	    this.medecinView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.medecinView.setVisible(true);
		
	}
	private void setTable() {
		
		String query = "SELECT suivi.suivi_id,patient.nom, pathologie.nom FROM suivi INNER JOIN patient ON suivi.patient_id=patient.patient_id INNER JOIN pathologie ON suivi.pathologie_id=pathologie.pathologie_id;";
		
	    PreparedStatement stm;
	      
		try {
			stm = (PreparedStatement) con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet res = stm.executeQuery();
			
			int rowsCount=0;
			
			while (res.next()) {
				rowsCount++;
			}
			
		    
		     String columns[] = { "Numéro de suivi", "Patient", "Pathologie" };
		    
		     String data[][] = new String[rowsCount][3];
		    
		     res.beforeFirst();
		     int i = 0;
		     while (res.next()) {
		       int id = res.getInt("suivi.suivi_id");
		       String patient = res.getString("patient.nom");
		       String pathologie = res.getString("pathologie.nom");
		       data[i][0] = id + "";
		       data[i][1] = patient;
		       data[i][2] = pathologie;
		        i++;
		     }
		     DefaultTableModel model = new DefaultTableModel(data, columns);
		     this.medecinView.getTable().setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
		
		
	}
	
	public MedecinViewFail getMedecinView() {
		return this.medecinView;
	}

}
