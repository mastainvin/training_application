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

/**
 * @author Vincednt Mastain
 * @version 1.0
 */
public class TrainingTypeDaoImpl extends BasicRequestsDao implements TrainingTypeDao {

	static TrainingTypeDaoImpl singleton = null;
	public static TrainingTypeDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new TrainingTypeDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private TrainingTypeDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("TrainingType");
		this.setIdLabel("id_training_type");
	}
	
	@Override
	Map<String, String> setMapFromResultSet(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("description", results.getString("description"));
		return valuesMap;
	}
	
	public class MapOfValuesInsert implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			TrainingType trainingType = (TrainingType) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", trainingType.getName());
			mapValues.put("description", trainingType.getDescription());
			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			TrainingType trainingType = (TrainingType) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", trainingType.getName());
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((TrainingType) dataBaseObject).setName(mapValues.get("name"));
		((TrainingType) dataBaseObject).setDescription(mapValues.get("description"));

	}
	
	
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

	@Override
	public TrainingType getFirstTrainingType() throws EmptyResultsQueryException {
		TrainingType trainingType = new TrainingType();
		this.<TrainingType>getFirst(trainingType);
		return trainingType;
	}

	@Override
	public TrainingType getTrainingTypeByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		TrainingType trainingType = new TrainingType();
		trainingType.setName(name);
		ArrayList<Map<String, String>> results = this.get(valuesMapGet.getMapOfValues(trainingType));
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), trainingType);
		return trainingType;
	}
	
	@Override
	public TrainingType getTrainingTypeById(Integer id_trainingType) throws EmptyResultsQueryException {
		TrainingType trainingType = new TrainingType();
		this.<TrainingType>getById(id_trainingType, trainingType);
		return trainingType;
	}
	
	@Override
	public Integer getTrainingTypeId(TrainingType trainingType) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		return this.getId(valuesMapGet.getMapOfValues(trainingType));
	}
	
	@Override
	public void addTrainingType(TrainingType trainingType) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(trainingType));
	}

	@Override
	public void updateTrainingType(TrainingType previousTrainingType, TrainingType newTrainingType) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		this.update(this.getId(valuesMapGet.getMapOfValues(previousTrainingType)), valuesMapInsert.getMapOfValues(newTrainingType));
	}

	@Override
	public void deleteTrainingType(TrainingType trainingType) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(trainingType));
	}

}
