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
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class ExerciceTypeDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class ExerciceTypeDaoImpl extends BasicRequestsDao implements ExerciceTypeDao {

	/** The singleton. */
	static ExerciceTypeDaoImpl singleton = null;
	
	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the exercice type dao impl
	 */
	public static ExerciceTypeDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new ExerciceTypeDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	/**
	 * Instantiates a new exercice type dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private ExerciceTypeDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("ExerciceType");
		this.setIdLabel("id_exercice_type");
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
		valuesMap.put("id_exercice_type", results.getString("id_exercice_type"));
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
			ExerciceType exerciceType = (ExerciceType) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("id_exercice_type", exerciceType.getIdExerciceType().toString());
			mapValues.put("name", exerciceType.getName());
			mapValues.put("description", exerciceType.getDescription());
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
			ExerciceType exerciceType = (ExerciceType) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("id_exercice_type", exerciceType.getIdExerciceType().toString());
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
		((ExerciceType) dataBaseObject).setName(mapValues.get("name"));
		((ExerciceType) dataBaseObject).setDescription(mapValues.get("description"));
		((ExerciceType) dataBaseObject).setIdExerciceType(Integer.parseInt(mapValues.get("id_exercice_type")));
	}
	
	
	/**
	 * Gets the all exercice type.
	 *
	 * @return the all exercice type
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
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

	/**
	 * Gets the first exercice type.
	 *
	 * @return the first exercice type
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public ExerciceType getFirstExerciceType() throws EmptyResultsQueryException {
		ExerciceType exerciceType = new ExerciceType();
		this.<ExerciceType>getFirst(exerciceType);
		return exerciceType;
	}

	/**
	 * Gets the exercice type by name.
	 *
	 * @param name the name
	 * @return the exercice type by name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public ExerciceType getExerciceTypeByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		Map<String,String> getMap = valuesMapGet.getMapOfValues(null);
		getMap.put("name", name);
		
		ArrayList<Map<String, String>> results = this.get(getMap);
		Iterator<Map<String, String>> iterator = results.iterator();
		
		ExerciceType exerciceType = new ExerciceType();
		this.objectConstructor(iterator.next(), exerciceType);
		return exerciceType;
	}
	
	/**
	 * Gets the exercice type by id.
	 *
	 * @param id_exerciceType the id exercice type
	 * @return the exercice type by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public ExerciceType getExerciceTypeById(Integer id_exerciceType) throws EmptyResultsQueryException {
		ExerciceType exerciceType = new ExerciceType();
		this.<ExerciceType>getById(id_exerciceType, exerciceType);
		return exerciceType;
	}
	
	/**
	 * Adds the exercice type.
	 *
	 * @param exerciceType the exercice type
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addExerciceType(ExerciceType exerciceType) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(exerciceType));
	}

	/**
	 * Update exercice type.
	 *
	 * @param exerciceType the exercice type
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void updateExerciceType(ExerciceType exerciceType) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(exerciceType), keysMap.getMapOfValues(exerciceType));
	}

	/**
	 * Delete exercice type.
	 *
	 * @param exerciceType the exercice type
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteExerciceType(ExerciceType exerciceType) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(exerciceType));
	}

	
}
