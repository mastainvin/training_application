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

import model.objects.ExerciceType;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public class ExerciceTypeDaoImpl extends BasicRequestsDao implements ExerciceTypeDao {

	static ExerciceTypeDaoImpl singleton = null;
	public static ExerciceTypeDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new ExerciceTypeDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private ExerciceTypeDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("ExerciceType");
		this.setIdLabel("id_exercice_type");
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
			ExerciceType exerciceType = (ExerciceType) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", exerciceType.getName());
			mapValues.put("description", exerciceType.getDescription());
			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			ExerciceType exerciceType = (ExerciceType) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", exerciceType.getName());
			mapValues.put("description", exerciceType.getDescription());
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((ExerciceType) dataBaseObject).setName(mapValues.get("name"));
		((ExerciceType) dataBaseObject).setDescription(mapValues.get("description"));
	}
	
	
	@Override
	public List<ExerciceType> getAllExerciceType() throws EmptyResultsQueryException {
		List<ExerciceType> exerciceTypeList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			ExerciceType exerciceType = new ExerciceType();
			this.objectConstructor(valueMap, exerciceType);
			exerciceTypeList.add(exerciceType);
		}
		return exerciceTypeList;
	}	

	@Override
	public ExerciceType getFirstExerciceType() throws EmptyResultsQueryException {
		ExerciceType exerciceType = new ExerciceType();
		this.<ExerciceType>getFirst(exerciceType);
		return exerciceType;
	}

	@Override
	public ExerciceType getExerciceTypeByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ExerciceType exerciceType = new ExerciceType();
		exerciceType.setName(name);
		ArrayList<Map<String, String>> results = this.get(valuesMapGet.getMapOfValues(exerciceType));
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), exerciceType);
		return exerciceType;
	}
	
	@Override
	public ExerciceType getExerciceTypeById(Integer id_exerciceType) throws EmptyResultsQueryException {
		ExerciceType exerciceType = new ExerciceType();
		this.<ExerciceType>getById(id_exerciceType, exerciceType);
		return exerciceType;
	}
	
	@Override
	public Integer getExerciceTypeId(ExerciceType exerciceType) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		return this.getId(valuesMapGet.getMapOfValues(exerciceType));
	}
	
	@Override
	public void addExerciceType(ExerciceType exerciceType) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(exerciceType));
	}

	@Override
	public void updateExerciceType(ExerciceType previousExerciceType, ExerciceType newExerciceType) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		this.update(this.getId(valuesMapGet.getMapOfValues(previousExerciceType)), valuesMapInsert.getMapOfValues(newExerciceType));
	}

	@Override
	public void deleteExerciceType(ExerciceType exerciceType) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(exerciceType));
	}

	
}
