package leo.labatut.projet.dao;

import java.sql.Connection;
import java.util.ArrayList;

import leo.labatut.projet.model.AgentAdmin;

public abstract class DAO<T> {
	
	protected Connection cn;
	protected ArrayList<T>listDAO;
	
	public DAO(Connection connection) {
		this.cn=connection;
		this.listDAO=new ArrayList<T>();
	}
	
	public abstract boolean create(T obj);
		
	public abstract boolean delete(T obj);
		
	public abstract boolean update(T obj);
		
	public abstract T find(int id);
	
	public abstract ArrayList<T> findAll();
	
	public Connection getConnection() {
		return this.cn;
	}

}
