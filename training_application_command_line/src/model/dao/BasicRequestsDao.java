/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class BasicRequestsDao.
 *
 * @author Vincent Mastain
 */
public abstract class BasicRequestsDao {
	
	/** The db name. */
	private String db_name;
	
	/** The id label. */
	private String id_label;
	
	/** The dao factory. */
	private DaoFactory daoFactory;
	
	/**
	 * Gets the db name.
	 *
	 * @return the db name
	 */
	public String getDbName() {
		return db_name;
	}
	
	/**
	 * Sets the db name.
	 *
	 * @param db_name the new db name
	 */
	public void setDbName(String db_name) {
		this.db_name = db_name;
	}
	
	/**
	 * Gets the id label.
	 *
	 * @return the id_label
	 */
	public String getIdLabel() {
		return id_label;
	}
	
	/**
	 * Sets the id label.
	 *
	 * @param id_label the id_label to set
	 */
	public void setIdLabel(String id_label) {
		this.id_label = id_label;
	}
	
	/**
	 * Gets the dao factory.
	 *
	 * @return the dao factory
	 */
	public DaoFactory getDaoFactory() {
		return daoFactory;
	}
	
	/**
	 * Sets the dao factory.
	 *
	 * @param daoFactory the new dao factory
	 */
	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	/**
	 * Sets the map from result set.
	 *
	 * @param results the results
	 * @return the map
	 * @throws SQLException the SQL exception
	 */
	abstract Map<String,String> setMapFromResultSet(ResultSet results) throws SQLException;
	
	/**
	 * Object constructor.
	 *
	 * @param <DataBaseObject> the generic type
	 * @param mapValues the map values
	 * @param dataBaseObject the data base object
	 */
	abstract <DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject);

	
	/**
	 * Gets the first.
	 *
	 * @param <DataBaseObject> the generic type
	 * @param dataBaseObject the data base object
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
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
	
	/**
	 * Gets the.
	 *
	 * @param valuesMap the values map
	 * @return the array list
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
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
	
	/**
	 * Gets the by id.
	 *
	 * @param <DataBaseObject> the generic type
	 * @param id the id
	 * @param dataBaseObject the data base object
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
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
	

	/**
	 * Adds the.
	 *
	 * @param valuesMap the values map
	 * @throws InsertDataBaseException the insert data base exception
	 */
	public void add(Map<String, String> valuesMap) throws InsertDataBaseException {
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
            
        } catch (SQLIntegrityConstraintViolationException e2) {
        	throw new InsertDataBaseException("insert error foreign key invalid");
        } catch (SQLException e) {
            e.printStackTrace();
        } 
	}
	
	/**
	 * Update.
	 *
	 * @param valuesMap the values map
	 * @param keysMap the keys map
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	public void update(Map<String, String> valuesMap, Map<String, String> keysMap) throws EmptyResultsQueryException, InsertDataBaseException {
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
        	sqlRequest += " WHERE ";
        	

        	first = true;
        	for(String keyMap : keysMap.keySet()) {
        		if (first) {
        			sqlRequest += keyMap + " = " + "'" + valuesMap.get(keyMap) + "'";
        			first = true;
        		} else {
        			sqlRequest += ", AND" + keyMap + " = " + "'" + valuesMap.get(keyMap) +"'";
        		}
        	}
        	
        	sqlRequest += ";";
            connection = this.getDaoFactory().getConnection();
            preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.executeUpdate();
            
        } catch (SQLIntegrityConstraintViolationException e2) {
        	throw new InsertDataBaseException("insert error foreign key invalid");
        } catch (SQLException e) {
        	throw new EmptyResultsQueryException();
        }	
	}

	/**
	 * Delete.
	 *
	 * @param valuesMap the values map
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
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
