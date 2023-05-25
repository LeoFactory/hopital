package trucs;

import java.awt.Dimension;

import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class MedecinViewFail extends JFrame {
	
	private JPanel panel = new JPanel();
	private JTextArea txt= new JTextArea("MEDECIN");
	private JTable table =new JTable();
	private DefaultTableModel model= new DefaultTableModel();
	
	public MedecinViewFail() {
		
		panel.add(txt);
		panel.add(new JScrollPane(table));
	    table.setShowGrid(true);
	    table.setShowVerticalLines(true);
		

		
		this.setContentPane(panel);
		this.setTitle ("Medecin") ;
		this.setSize (new Dimension (700, 450)) ;
	}
	
	public DefaultTableModel getTableModel() {
		return this.model;
	}
	
	public JTable getTable() {
		return this.table;
	}
	public void setTable(JTable table) {
		this.table=table;
	}
	public JTextArea getTxt() {
		return this.txt;
	}
	

}