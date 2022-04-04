/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 *
 */
public abstract class BasicRequestsDao {
	private String id_label;
	private String db_name;
	private DaoFactory daoFactory;
	
	public String getIdLabel() {
		return this.id_label;
	}
	public void setIdLabel(String id_label) {
		this.id_label = id_label;
	}
	
	public String getDbName() {
		return db_name;
	}
	public void setDbName(String db_name) {
		this.db_name = db_name;
	}
	
	public DaoFactory getDaoFactory() {
		return daoFactory;
	}
	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	abstract Map<String,String> setMapFromResultSet(ResultSet results) throws SQLException;
	abstract <DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject);
	
	public <DataBaseObject> void getFirst(DataBaseObject dataBaseObject) throws EmptyResultsQueryException {
		Connection connexion = null;
		Statement statement = null;
        ResultSet results = null;

        try {
            connexion = this.getDaoFactory().getConnection();
            statement = connexion.createStatement();
            results = statement.executeQuery("SELECT * FROM "+ this.getDbName() +" LIMIT 1;");
            
            if (results.next()) {
            	this.<DataBaseObject>objectConstructor(this.setMapFromResultSet(results), dataBaseObject);
            } else {
            	throw new EmptyResultsQueryException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public ArrayList<Map<String, String>> get(Map<String, String> valuesMap) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	    ResultSet results = null;
	    ArrayList<Map<String, String>> resultsArray = new ArrayList<Map<String, String>>();
	    
	    try {
	    	String sqlRequest;
	    	try {
	    		sqlRequest = "SELECT * FROM "+ this.getDbName() +" WHERE ";
		    	boolean first = true;
	        	for(String valueKey : valuesMap.keySet()) {
	        		if (first) {
	        			sqlRequest +=  valueKey + " = " + "'" + valuesMap.get(valueKey) + "'";
	        			first = false;
	        		} else {
	        			sqlRequest += " AND " + valueKey + " = " + "'" + valuesMap.get(valueKey) + "'";
	        		}
	        	}
	        	sqlRequest += ";";
	    	} catch (NullPointerException e) {
	    		sqlRequest = "SELECT * FROM "+ this.getDbName() + ";";
	    	}
	    	
        	
	        connection = this.getDaoFactory().getConnection();
            preparedStatement = connection.prepareStatement(sqlRequest);
            results = preparedStatement.executeQuery();
            
            boolean empty = true;
            
            while(results.next()) {
            	resultsArray.add(this.setMapFromResultSet(results));
            	empty=false;
            }
            
	        if (empty) {
	        	throw new EmptyResultsQueryException();
            } 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return resultsArray;
	}
	
	public <DataBaseObject> void getById(Integer id, DataBaseObject dataBaseObject) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        ResultSet results = null;

        try {
            connection = this.getDaoFactory().getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM "+ this.getDbName() +" WHERE "+ this.getIdLabel() +" = ? ;");
            preparedStatement.setInt(1, id);
            results = preparedStatement.executeQuery();
            
            if(results.next()) {
            	this.<DataBaseObject>objectConstructor(this.setMapFromResultSet(results), dataBaseObject);
            } else {
            	throw new EmptyResultsQueryException();
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public <DataBaseObject> Integer getId(Map<String, String> valuesMap) throws EmptyResultsQueryException {
		Integer id = -1;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	    ResultSet results = null;

	    try {
	    	
	    	String sqlRequest = "SELECT " + this.getIdLabel() + " FROM "+ this.getDbName() +" WHERE ";
        	
	    	boolean first = true;
        	for(String valueKey : valuesMap.keySet()) {
        		if (first) {
        			sqlRequest +=  valueKey + " = " + "'" + valuesMap.get(valueKey) + "'";
        			first = false;
        		} else {
        			sqlRequest += " AND " + valueKey + " = " + "'" + valuesMap.get(valueKey) + "'";
        		}
        	}
        	sqlRequest += ";";
	    		
	        connection = this.getDaoFactory().getConnection();
	        preparedStatement = connection.prepareStatement(sqlRequest);
	        results = preparedStatement.executeQuery();
	        
	        if (results.next()) {
	        	id = results.getInt(this.getIdLabel());
	        } else {
	        	throw new EmptyResultsQueryException();
	        }
	     
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return id;
	}

	public void add(Map<String, String> valuesMap) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

        try {
        	String sqlRequest = "INSERT INTO "+ this.getDbName() +" (";
        	
        	boolean first = true;
        	for(String valueKey : valuesMap.keySet()) {
        		if (first) {
        			sqlRequest += valueKey;
        			first = false;
        		} else {
        			sqlRequest += ", " + valueKey;
        		}
        	}
        	sqlRequest += ") VALUES (";
        	
        	first = true;
        	for(String valueKey : valuesMap.keySet()) {
        		if (first) {
        			sqlRequest += "'" + valuesMap.get(valueKey) + "'";
        			first = false;
        		} else {
        			sqlRequest += ", '" + valuesMap.get(valueKey) + "'";
        		}
        	}
        	
        	
        	sqlRequest += ");";
        	connection = this.getDaoFactory().getConnection();
            preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }	
	}
	
	public void update(Integer id, Map<String, String> valuesMap) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

        try {
        	String sqlRequest = "UPDATE " + this.getDbName();
        	
        	boolean first = true;
        	for(String valueKey : valuesMap.keySet()) {
        		if (first) {
        			sqlRequest += " SET " + valueKey + " = " + "'" + valuesMap.get(valueKey) + "'";
        			first = false;
        		} else {
        			sqlRequest += ", " + valueKey + " = " + "'" + valuesMap.get(valueKey) + "'";
        		}
        	}
        	sqlRequest += " WHERE " + this.getIdLabel() + " = " + "'" + id + "'";
        	sqlRequest += ";";
            connection = this.getDaoFactory().getConnection();
            preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
        	throw new EmptyResultsQueryException();
        }	
	}

	public void delete(Map<String, String> valuesMap) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

        try {
        	String sqlRequest = "DELETE FROM " + this.getDbName() +" WHERE ";
        	
        	boolean first = true;
        	for(String valueKey : valuesMap.keySet()) {
        		if (first) {
        			sqlRequest += valueKey + " = " + "'" + valuesMap.get(valueKey) + "'";
        			first = true;
        		} else {
        			sqlRequest += ", AND" + valueKey + " = " + "'" + valuesMap.get(valueKey) +"'";
        		}
        	}
        	sqlRequest += ";";
        	
            connection = this.getDaoFactory().getConnection();
            preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.executeUpdate();
        
        } catch (SQLException e) {
            throw new EmptyResultsQueryException();
        }
	}
}
