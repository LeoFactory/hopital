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
	/**
	 * créer un objet (une nouvelle ligne dans la table correspondante)
	 * @param obj
	 * @return
	 */
	public abstract boolean create(T obj);
		
	/**
	 * supprimer un objet (supprime une ligne dans la table correspondante)
	 * @param obj
	 * @return
	 */
	public abstract boolean delete(T obj);
		
	/**
	 * mise à jour d'une ligne dans la table correspondante
	 * @param obj
	 * @return
	 */
	public abstract boolean update(T obj);
		
	/**
	 * trouve une ligne dans la table correspondante à partir d'un id
	 * @param id
	 * @return
	 */
	public abstract T find(int id);
	
	/**
	 * renvoie la totalité des lignes sous la forme de POJO correspondants
	 * @return
	 */
	public abstract ArrayList<T> findAll();
	
	/**
	 * getter connection
	 * @return
	 */
	public Connection getConnection() {
		return this.cn;
	}

}
