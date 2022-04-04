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

import model.objects.Repartition;
import model.objects.TrainingMethod;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincednt Mastain
 * @version 1.0
 */
public class TrainingMethodDaoImpl extends BasicRequestsDao implements TrainingMethodDao {

	static TrainingMethodDaoImpl singleton = null;
	public static TrainingMethodDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new TrainingMethodDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private TrainingMethodDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("TrainingMethod");
		this.setIdLabel("id_training_method");
	}
	
	@Override
	Map<String, String> setMapFromResultSet(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("math_function", results.getString("math_function"));
		valuesMap.put("rep_max", results.getString("rep_max"));
		valuesMap.put("rep_min", results.getString("rep_min"));
		valuesMap.put("weight_max", results.getString("weight_max"));
		valuesMap.put("weight_min", results.getString("weight_min"));
		
		return valuesMap;
	}
	
	public class MapOfValuesInsert implements ValuesMap {
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
			
			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			TrainingMethod trainingMethod = (TrainingMethod) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", trainingMethod.getName());
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((TrainingMethod) dataBaseObject).setName(mapValues.get("name"));
		((TrainingMethod) dataBaseObject).setRepartition(Repartition.getRepartition(mapValues.get("math_function")));
		((TrainingMethod) dataBaseObject).setRepMin(Integer.parseInt(mapValues.get("rep_min")));
		((TrainingMethod) dataBaseObject).setRepMax(Integer.parseInt(mapValues.get("rep_max")));
		((TrainingMethod) dataBaseObject).setWeightMin(Integer.parseInt(mapValues.get("weight_min")));
		((TrainingMethod) dataBaseObject).setWeightMax(Integer.parseInt(mapValues.get("weight_max")));
	}
	
	
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

	@Override
	public TrainingMethod getFirstTrainingMethod() throws EmptyResultsQueryException {
		TrainingMethod trainingMethod = new TrainingMethod();
		this.<TrainingMethod>getFirst(trainingMethod);
		return trainingMethod;
	}

	@Override
	public TrainingMethod getTrainingMethodByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		TrainingMethod trainingMethod = new TrainingMethod();
		trainingMethod.setName(name);
		ArrayList<Map<String, String>> results = this.get(valuesMapGet.getMapOfValues(trainingMethod));
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), trainingMethod);
		return trainingMethod;
	}
	
	@Override
	public TrainingMethod getTrainingMethodById(Integer id_trainingMethod) throws EmptyResultsQueryException {
		TrainingMethod trainingMethod = new TrainingMethod();
		this.<TrainingMethod>getById(id_trainingMethod, trainingMethod);
		return trainingMethod;
	}
	
	@Override
	public Integer getTrainingMethodId(TrainingMethod trainingMethod) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		return this.getId(valuesMapGet.getMapOfValues(trainingMethod));
	}
	
	@Override
	public void addTrainingMethod(TrainingMethod trainingMethod) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(trainingMethod));
	}

	@Override
	public void updateTrainingMethod(TrainingMethod previousTrainingMethod, TrainingMethod newTrainingMethod) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		this.update(this.getId(valuesMapGet.getMapOfValues(previousTrainingMethod)), valuesMapInsert.getMapOfValues(newTrainingMethod));
	}

	@Override
	public void deleteTrainingMethod(TrainingMethod trainingMethod) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(trainingMethod));
	}

}
