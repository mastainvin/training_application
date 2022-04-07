/**
 * 
 */
package model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.objects.TrainingType;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class TrainingTypeDaoImpl.
 *
 * @author Vincednt Mastain
 * @version 1.0
 */
public class TrainingTypeDaoImpl extends BasicRequestsDao implements TrainingTypeDao {

	/** The singleton. */
	static TrainingTypeDaoImpl singleton = null;
	
	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the training type dao impl
	 */
	public static TrainingTypeDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new TrainingTypeDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	/**
	 * Instantiates a new training type dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private TrainingTypeDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("TrainingType");
		this.setIdLabel("id_training_type");
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
		valuesMap.put("description", results.getString("description"));
		valuesMap.put("id_training_type", results.getString("id_training_type"));
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
			TrainingType trainingType = (TrainingType) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", trainingType.getName());
			mapValues.put("description", trainingType.getDescription());
			mapValues.put("id_training_type", trainingType.getIdTrainingType().toString());
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
			TrainingType trainingType = (TrainingType) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("id_training_type", trainingType.getIdTrainingType().toString());
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
		((TrainingType) dataBaseObject).setName(mapValues.get("name"));
		((TrainingType) dataBaseObject).setDescription(mapValues.get("description"));
		((TrainingType) dataBaseObject).setIdTrainingType(Integer.parseInt(mapValues.get("id_training_type")));
	}
	
	
	/**
	 * Gets the all training type.
	 *
	 * @return the all training type
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<TrainingType> getAllTrainingType() throws EmptyResultsQueryException {
		List<TrainingType> trainingTypeList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			TrainingType trainingType = new TrainingType();
			this.objectConstructor(valueMap, trainingType);
			trainingTypeList.add(trainingType);
		}
		return trainingTypeList;
	}	

	/**
	 * Gets the first training type.
	 *
	 * @return the first training type
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public TrainingType getFirstTrainingType() throws EmptyResultsQueryException {
		TrainingType trainingType = new TrainingType();
		this.<TrainingType>getFirst(trainingType);
		return trainingType;
	}

	/**
	 * Gets the training type by name.
	 *
	 * @param name the name
	 * @return the training type by name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public TrainingType getTrainingTypeByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		Map<String,String> getMap = valuesMapGet.getMapOfValues(null);
		getMap.put("name", name);
		
		ArrayList<Map<String, String>> results = this.get(getMap);
		Iterator<Map<String, String>> iterator = results.iterator();
		
		TrainingType trainingType = new TrainingType();
		this.objectConstructor(iterator.next(), trainingType);
		return trainingType;
	}
	
	/**
	 * Gets the training type by id.
	 *
	 * @param id_trainingType the id training type
	 * @return the training type by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public TrainingType getTrainingTypeById(Integer id_trainingType) throws EmptyResultsQueryException {
		TrainingType trainingType = new TrainingType();
		this.<TrainingType>getById(id_trainingType, trainingType);
		return trainingType;
	}
	
	/**
	 * Adds the training type.
	 *
	 * @param trainingType the training type
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addTrainingType(TrainingType trainingType) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(trainingType));
	}

	/**
	 * Update training type.
	 *
	 * @param trainingType the training type
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void updateTrainingType(TrainingType trainingType) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(trainingType), keysMap.getMapOfValues(trainingType));
	}

	/**
	 * Delete training type.
	 *
	 * @param trainingType the training type
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteTrainingType(TrainingType trainingType) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(trainingType));
	}

}
