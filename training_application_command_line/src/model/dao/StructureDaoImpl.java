/**
 * 
 */
package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.objects.Structure;
import model.objects.Training;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class StructureDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class StructureDaoImpl extends BasicRequestsDao implements StructureDao {
	
	/** The singleton. */
	static StructureDaoImpl singleton = null;
	
	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the structure dao impl
	 */
	public static StructureDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new StructureDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	/**
	 * Instantiates a new structure dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private StructureDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Structure");
		this.setIdLabel("id_structure");
	}

	/**
	 * Sets the map from result set.
	 *
	 * @param results the results
	 * @return the map
	 * @throws SQLException the SQL exception
	 */
	@Override
	Map<String, String> setMapFromResultSet(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("id_goal", results.getString("id_goal"));
		valuesMap.put("id_structure", results.getString("id_structure"));
		return valuesMap;
	}
	
	/**
	 * The Class MapOfValuesInsert.
	 */
	public class MapOfValuesInsert implements ValuesMap {
		
		/**
		 * Gets the map of values.
		 *
		 * @param <DataBaseObject> the generic type
		 * @param dataBaseObject the data base object
		 * @return the map of values
		 */
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Structure structure = (Structure) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", structure.getName());
			
			mapValues.put("id_structure", structure.getIdStructure().toString());
			
			try {
				mapValues.put("id_goal", structure.getIdGoal().toString());
			} catch (NullPointerException e) {
			}
			
			return mapValues;
		}
	}
	
	/**
	 * The Class MapOfValuesGet.
	 */
	public class MapOfValuesGet implements ValuesMap {
		
		/**
		 * Gets the map of values.
		 *
		 * @param <DataBaseObject> the generic type
		 * @param dataBaseObject the data base object
		 * @return the map of values
		 */
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Structure structure = (Structure) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("id_structure", structure.getIdStructure().toString());
			return mapValues;
		}	
	}
	
	/**
	 * Object constructor.
	 *
	 * @param <DataBaseObject> the generic type
	 * @param mapValues the map values
	 * @param dataBaseObject the data base object
	 */
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((Structure) dataBaseObject).setName(mapValues.get("name"));
		((Structure) dataBaseObject).setIdStructure(Integer.parseInt(mapValues.get("id_structure")));
		
		try {
			((Structure) dataBaseObject).setIdGoal(Integer.parseInt(mapValues.get("id_goal")));
		} catch (NumberFormatException e) {
		}
	}
	
	
	/**
	 * Gets the all structure.
	 *
	 * @return the all structure
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Structure> getAllStructure() throws EmptyResultsQueryException {
		List<Structure> structureList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			Structure structure = new Structure();
			this.objectConstructor(valueMap, structure);
			structureList.add(structure);
		}
		return structureList;
	}	

	/**
	 * Gets the first structure.
	 *
	 * @return the first structure
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Structure getFirstStructure() throws EmptyResultsQueryException {
		Structure structure = new Structure();
		this.<Structure>getFirst(structure);
		return structure;
	}

	/**
	 * Gets the structure by name.
	 *
	 * @param name the name
	 * @return the structure by name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Structure getStructureByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		Map<String,String> getMap = valuesMapGet.getMapOfValues(null);
		getMap.put("name", name);
		
		ArrayList<Map<String, String>> results = this.get(getMap);
		Iterator<Map<String, String>> iterator = results.iterator();
		
		Structure structure = new Structure();
		this.objectConstructor(iterator.next(), structure);
		return structure;
	}
	
	/**
	 * Gets the structure by id.
	 *
	 * @param id_structure the id structure
	 * @return the structure by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Structure getStructureById(Integer id_structure) throws EmptyResultsQueryException {
		Structure structure = new Structure();
		this.<Structure>getById(id_structure, structure);
		return structure;
	}

	
	/**
	 * Adds the structure.
	 *
	 * @param structure the structure
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addStructure(Structure structure) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(structure));
	}

	/**
	 * Update structure.
	 *
	 * @param structure the structure
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void updateStructure(Structure structure) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(structure), keysMap.getMapOfValues(structure));
	}

	/**
	 * Delete structure.
	 *
	 * @param structure the structure
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteStructure(Structure structure) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(structure));
	}

	

	/**
	 * Gets the structure from training.
	 *
	 * @param training the training
	 * @return the structure from training
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Structure getStructureFromTraining(Training training) throws EmptyResultsQueryException {
		Structure structure = new Structure();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	    ResultSet results = null;

	    try {
	    	
	    	String sqlRequest = "SELECT s.* FROM Structure s, Training t WHERE s.id_structure = t.id_structure AND t.name = '" + training.getName() + "';";
	
	        connection = this.getDaoFactory().getConnection();
	        preparedStatement = connection.prepareStatement(sqlRequest);
	        results = preparedStatement.executeQuery();
	        
	        if (results.next()) {
	        	this.objectConstructor(this.setMapFromResultSet(results), structure);
	        } else {
	        	throw new EmptyResultsQueryException();
	        }
	     
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return structure;
	}
	
	@Override
	public void getUserStructure(User user) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	    ResultSet results = null;
	    
	    try {
	    	String sqlRequest;
	    	try {
	    		sqlRequest = "SELECT s.* FROM Structure s, User u, CompatibleDisponibility cd, CanTrainOn cto\n"
	    				+ "WHERE s.id_goal = u.id_goal\n"
	    				+ "AND cd.id_disponibility = cto.id_disponibility\n"
	    				+ "AND cd.id_structure = s.id_structure\n"
	    				+ "AND cto.id_user = u.id_user\n"
	    				+ "AND u.id_user = "+ user.getIdUser() +";";
	    	} catch (NullPointerException e) {
	    		sqlRequest = "SELECT * FROM "+ this.getDbName() + ";";
	    	}
	    	
        	
	        connection = this.getDaoFactory().getConnection();
            preparedStatement = connection.prepareStatement(sqlRequest);
            results = preparedStatement.executeQuery();
            
            if(results.next()) {
            	Structure structure = new Structure();
            	this.objectConstructor( this.setMapFromResultSet(results), structure);
            	user.setStructure(structure);
            } else {
            	throw new EmptyResultsQueryException();
            }
   
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    
	}

}
