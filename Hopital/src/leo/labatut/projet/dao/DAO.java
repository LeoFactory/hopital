package leo.labatut.projet.dao;

import java.sql.Connection;

public abstract class DAO<T> {
	
	protected Connection cn;
	
	public DAO(Connection connection) {
		this.cn=connection;
	}
	
	public abstract boolean create(T obj);
		
	public abstract boolean delete(T obj);
		
	public abstract boolean update(T obj);
		
	public abstract T find(int id);

}
