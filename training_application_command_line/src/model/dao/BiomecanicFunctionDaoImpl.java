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

import model.objects.BiomecanicFunction;
import model.objects.Exercice;
import model.objects.TrainingComponent;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class BiomecanicFunctionDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class BiomecanicFunctionDaoImpl extends BasicRequestsDao implements BiomecanicFunctionDao {

	/** The singleton. */
	static BiomecanicFunctionDaoImpl singleton = null;
	
	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the biomecanic function dao impl
	 */
	public static BiomecanicFunctionDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new BiomecanicFunctionDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	/**
	 * Instantiates a new biomecanic function dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private BiomecanicFunctionDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("BiomecanicFunction");
		this.setIdLabel("id_biomecanic_function");
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
		valuesMap.put("id_biomecanic_function", results.getString("id_biomecanic_function"));
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
			BiomecanicFunction biomecanicFunction = (BiomecanicFunction) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", biomecanicFunction.getName());
			mapValues.put("id_biomecanic_function", biomecanicFunction.getIdBiomecanicFunction().toString());
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
			BiomecanicFunction biomecanicFunction = (BiomecanicFunction) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("id_biomecanic_function", biomecanicFunction.getIdBiomecanicFunction().toString());
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
		((BiomecanicFunction) dataBaseObject).setName(mapValues.get("name"));
		((BiomecanicFunction) dataBaseObject).setIdBiomecanicFunction(Integer.parseInt(mapValues.get("id_biomecanic_function")));
	}
	
	
	/**
	 * Gets the all biomecanic function.
	 *
	 * @return the all biomecanic function
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<BiomecanicFunction> getAllBiomecanicFunction() throws EmptyResultsQueryException {
		List<BiomecanicFunction> biomecanicFunctionList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			BiomecanicFunction biomecanicFunction = new BiomecanicFunction();
			biomecanicFunction.setName(valueMap.get("name"));
			biomecanicFunctionList.add(biomecanicFunction);
		}
		return biomecanicFunctionList;
	}	

	/**
	 * Gets the first biomecanic function.
	 *
	 * @return the first biomecanic function
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public BiomecanicFunction getFirstBiomecanicFunction() throws EmptyResultsQueryException {
		BiomecanicFunction biomecanicFunction = new BiomecanicFunction();
		this.<BiomecanicFunction>getFirst(biomecanicFunction);
		return biomecanicFunction;
	}

	/**
	 * Gets the biomecanic function by name.
	 *
	 * @param name the name
	 * @return the biomecanic function by name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public BiomecanicFunction getBiomecanicFunctionByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		Map<String,String> getMap = valuesMapGet.getMapOfValues(null);
		getMap.put("name", name);
		
		ArrayList<Map<String, String>> results = this.get(getMap);
		Iterator<Map<String, String>> iterator = results.iterator();
		
		BiomecanicFunction biomecanicFunction = new BiomecanicFunction();
		this.objectConstructor(iterator.next(), biomecanicFunction);
		return biomecanicFunction;
	}
	
	/**
	 * Gets the biomecanic function by id.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @return the biomecanic function by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public BiomecanicFunction getBiomecanicFunctionById(Integer id_biomecanicFunction) throws EmptyResultsQueryException {
		BiomecanicFunction biomecanicFunction = new BiomecanicFunction();
		this.<BiomecanicFunction>getById(id_biomecanicFunction, biomecanicFunction);
		return biomecanicFunction;
	}
	

	/**
	 * Adds the biomecanic function.
	 *
	 * @param biomecanicFunction the biomecanic function
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addBiomecanicFunction(BiomecanicFunction biomecanicFunction) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(biomecanicFunction));
	}

	/**
	 * Update biomecanic function.
	 *
	 * @param bioMecanicFunction the bio mecanic function
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void updateBiomecanicFunction(BiomecanicFunction bioMecanicFunction) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(bioMecanicFunction), keysMap.getMapOfValues(bioMecanicFunction));
	}

	

	/**
	 * Delete biomecanic function.
	 *
	 * @param biomecanicFunction the biomecanic function
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteBiomecanicFunction(BiomecanicFunction biomecanicFunction) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(biomecanicFunction));
	}

	@Override
	public void getTrainingComponentBiomecanicFunctionList(TrainingComponent trainingComponent) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	    ResultSet results = null;
	    
	    try {
	    	String sqlRequest;
	    	
    		sqlRequest = "SELECT bf.* From BiomecanicFunctionList bfl, UseBiomecanicFunction ubf, BiomecanicFunction bf\n"
    				+ "WHERE bfl.id_biomecanic_function_list = ubf.id_biomecanic_function_list\n"
    				+ "AND bf.id_biomecanic_function = ubf.id_biomecanic_function\n"
    				+ "AND bfl.id_biomecanic_function_list = "+ trainingComponent.getIdBiomecanicFunctionList()+";";
    	
        	
	        connection = this.getDaoFactory().getConnection();
            preparedStatement = connection.prepareStatement(sqlRequest);
            results = preparedStatement.executeQuery();
            
            boolean empty = true;
            List<BiomecanicFunction> biomecanicFunctionList = new ArrayList<>();
            while(results.next()) {
            	BiomecanicFunction biomecanicFunction = new BiomecanicFunction();
            	this.objectConstructor( this.setMapFromResultSet(results), biomecanicFunction);
            	biomecanicFunctionList.add(biomecanicFunction);
            	empty = false;
            }
           
            if(empty) {
            	throw new EmptyResultsQueryException();
            } 
            trainingComponent.setBiomecanicFunctionList(biomecanicFunctionList);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	}

	@Override
	public void getExerciceBiomecanicFunctionList(Exercice exercice) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	    ResultSet results = null;
	    
	    try {
	    	String sqlRequest;
	    	
    		sqlRequest = "SELECT bf.* FROM BiomecanicFunction bf, CompatibleBiomecanicFunction cbf, Exercice e\n"
    				+ "WHERE e.id_exercice = cbf.id_exercice\n"
    				+ "AND bf.id_biomecanic_function = cbf.id_biomecanic_function\n"
    				+ "AND e.id_exercice = " +exercice.getIdExercice()+ ";";
    	
        	
	        connection = this.getDaoFactory().getConnection();
            preparedStatement = connection.prepareStatement(sqlRequest);
            results = preparedStatement.executeQuery();
            
            boolean empty = true;
            List<BiomecanicFunction> biomecanicFunctionList = new ArrayList<>();
            while(results.next()) {
            	BiomecanicFunction biomecanicFunction = new BiomecanicFunction();
            	this.objectConstructor( this.setMapFromResultSet(results), biomecanicFunction);
            	biomecanicFunctionList.add(biomecanicFunction);
            	empty = false;
            }
           
            if(empty) {
            	throw new EmptyResultsQueryException();
            } 
            exercice.setBiomecanicFunctionList(biomecanicFunctionList);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	}

	

	
}
