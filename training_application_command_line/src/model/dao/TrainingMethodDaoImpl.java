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

import model.objects.Repartition;
import model.objects.TrainingComponent;
import model.objects.TrainingMethod;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class TrainingMethodDaoImpl.
 *
 * @author Vincednt Mastain
 * @version 1.0
 */
public class TrainingMethodDaoImpl extends BasicRequestsDao implements TrainingMethodDao {

	/** The singleton. */
	static TrainingMethodDaoImpl singleton = null;
	
	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the training method dao impl
	 */
	public static TrainingMethodDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new TrainingMethodDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	/**
	 * Instantiates a new training method dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private TrainingMethodDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("TrainingMethod");
		this.setIdLabel("id_training_method");
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
		valuesMap.put("math_function", results.getString("math_function"));
		valuesMap.put("rep_max", results.getString("rep_max"));
		valuesMap.put("rep_min", results.getString("rep_min"));
		valuesMap.put("weight_max", results.getString("weight_max"));
		valuesMap.put("weight_min", results.getString("weight_min"));
		valuesMap.put("id_training_method", results.getString("id_training_method"));
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
			TrainingMethod trainingMethod = (TrainingMethod) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", trainingMethod.getName());
			mapValues.put("math_function", trainingMethod.getRepartition().getName());
			mapValues.put("rep_min", trainingMethod.getRepMin().toString());
			mapValues.put("rep_max", trainingMethod.getRepMax().toString());
			mapValues.put("weight_min", trainingMethod.getWeightMin().toString());
			mapValues.put("weight_max", trainingMethod.getWeightMax().toString());
			mapValues.put("id_training_method", trainingMethod.getIdTrainingMethod().toString());
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
			TrainingMethod trainingMethod = (TrainingMethod) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("id_training_method", trainingMethod.getIdTrainingMethod().toString());
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
		((TrainingMethod) dataBaseObject).setName(mapValues.get("name"));
		((TrainingMethod) dataBaseObject).setRepartition(Repartition.getRepartition(mapValues.get("math_function")));
		((TrainingMethod) dataBaseObject).setRepMin(Integer.parseInt(mapValues.get("rep_min")));
		((TrainingMethod) dataBaseObject).setRepMax(Integer.parseInt(mapValues.get("rep_max")));
		((TrainingMethod) dataBaseObject).setWeightMin(Integer.parseInt(mapValues.get("weight_min")));
		((TrainingMethod) dataBaseObject).setWeightMax(Integer.parseInt(mapValues.get("weight_max")));
		((TrainingMethod) dataBaseObject).setIdTrainingMethod(Integer.parseInt(mapValues.get("id_training_method")));
	}
	
	
	/**
	 * Gets the all training method.
	 *
	 * @return the all training method
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<TrainingMethod> getAllTrainingMethod() throws EmptyResultsQueryException {
		List<TrainingMethod> trainingMethodList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			TrainingMethod trainingMethod = new TrainingMethod();
			this.objectConstructor(valueMap, trainingMethod);
			trainingMethodList.add(trainingMethod);
		}
		return trainingMethodList;
	}	

	/**
	 * Gets the first training method.
	 *
	 * @return the first training method
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public TrainingMethod getFirstTrainingMethod() throws EmptyResultsQueryException {
		TrainingMethod trainingMethod = new TrainingMethod();
		this.<TrainingMethod>getFirst(trainingMethod);
		return trainingMethod;
	}

	/**
	 * Gets the training method by name.
	 *
	 * @param name the name
	 * @return the training method by name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public TrainingMethod getTrainingMethodByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		Map<String,String> getMap = valuesMapGet.getMapOfValues(null);
		getMap.put("name", name);
		
		ArrayList<Map<String, String>> results = this.get(getMap);
		Iterator<Map<String, String>> iterator = results.iterator();
		
		TrainingMethod trainingMethod = new TrainingMethod();
		this.objectConstructor(iterator.next(), trainingMethod);
		return trainingMethod;
	}
	
	/**
	 * Gets the training method by id.
	 *
	 * @param id_trainingMethod the id training method
	 * @return the training method by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public TrainingMethod getTrainingMethodById(Integer id_trainingMethod) throws EmptyResultsQueryException {
		TrainingMethod trainingMethod = new TrainingMethod();
		this.<TrainingMethod>getById(id_trainingMethod, trainingMethod);
		return trainingMethod;
	}
	

	/**
	 * Adds the training method.
	 *
	 * @param trainingMethod the training method
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addTrainingMethod(TrainingMethod trainingMethod) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(trainingMethod));
	}

	/**
	 * Update training method.
	 *
	 * @param trainingMethod the training method
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void updateTrainingMethod(TrainingMethod trainingMethod) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(trainingMethod), keysMap.getMapOfValues(trainingMethod));
	}

	/**
	 * Delete training method.
	 *
	 * @param trainingMethod the training method
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteTrainingMethod(TrainingMethod trainingMethod) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(trainingMethod));
	}

	@Override
	public void getTrainingComponentTrainingMethod(TrainingComponent trainingComponent) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	    ResultSet results = null;
	    
	    try {
	    	String sqlRequest;
	    	
    		sqlRequest = "SELECT tm.* FROM TrainingMethod tm\n"
    				+ "WHERE tm.id_training_method =" + trainingComponent.getIdTrainingMethod()+";";
    	
	        connection = this.getDaoFactory().getConnection();
            preparedStatement = connection.prepareStatement(sqlRequest);
            results = preparedStatement.executeQuery();
            
            if(results.next()) {
            	TrainingMethod  tm = new TrainingMethod();
            	this.objectConstructor(this.setMapFromResultSet(results), tm);
            	trainingComponent.setTrainingMethod(tm);
            } else {
            	throw new EmptyResultsQueryException();
            }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	}

}
