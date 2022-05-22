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

import model.objects.ExerciseType;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;


/**
 * The Class ExerciseTypeDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class ExerciseTypeDaoImpl extends BasicRequestsDao implements ExerciseTypeDao {

	/**
	 * The Class MapOfValuesGet.
	 */
	public class MapOfValuesGet implements ValuesMap {

		/**
		 * Gets the map of values.
		 *
		 * @param <DataBaseObject> the generic type
		 * @param dataBaseObject   the data base object
		 * @return the map of values
		 */
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			ExerciseType exerciseType = (ExerciseType) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("id_exercise_type", exerciseType.getIdExerciseType().toString());
			return mapValues;
		}
	}

	/**
	 * The Class MapOfValuesInsert.
	 */
	public class MapOfValuesInsert implements ValuesMap {

		/**
		 * Gets the map of values.
		 *
		 * @param <DataBaseObject> the generic type
		 * @param dataBaseObject   the data base object
		 * @return the map of values
		 */
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			ExerciseType exerciseType = (ExerciseType) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("id_exercise_type", exerciseType.getIdExerciseType().toString());
			mapValues.put("name", exerciseType.getName());
			mapValues.put("description", exerciseType.getDescription());
			return mapValues;
		}
	}

	/** The singleton. */
	static ExerciseTypeDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the exercise type dao impl
	 */
	public static ExerciseTypeDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			return new ExerciseTypeDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new exercise type dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private ExerciseTypeDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("ExerciseType");
		this.setIdLabel("id_exercise_type");
	}

	/**
	 * Adds the exercise type.
	 *
	 * @param exerciseType the exercise type
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addExerciseType(ExerciseType exerciseType) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(exerciseType));
	}

	/**
	 * Delete exercise type.
	 *
	 * @param exerciseType the exercise type
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteExerciseType(ExerciseType exerciseType) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(exerciseType));
	}

	/**
	 * Gets the all exercise type.
	 *
	 * @return the all exercise type
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<ExerciseType> getAllExerciseType() throws EmptyResultsQueryException {
		List<ExerciseType> exerciseTypeList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for (Map<String, String> valueMap : results) {
			ExerciseType exerciseType = new ExerciseType();
			this.objectConstructor(valueMap, exerciseType);
			exerciseTypeList.add(exerciseType);
		}
		return exerciseTypeList;
	}

	/**
	 * Gets the exercise type by id.
	 *
	 * @param id_exerciseType the id exercise type
	 * @return the exercise type by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public ExerciseType getExerciseTypeById(Integer id_exerciseType) throws EmptyResultsQueryException {
		ExerciseType exerciseType = new ExerciseType();
		this.<ExerciseType>getById(id_exerciseType, exerciseType);
		return exerciseType;
	}

	/**
	 * Gets the exercise type by name.
	 *
	 * @param name the name
	 * @return the exercise type by name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public ExerciseType getExerciseTypeByName(String name) throws EmptyResultsQueryException {
		Map<String, String> getMap = new HashMap<>();
		getMap.put("name", name);

		ArrayList<Map<String, String>> results = this.get(getMap);
		Iterator<Map<String, String>> iterator = results.iterator();

		ExerciseType exerciseType = new ExerciseType();
		this.objectConstructor(iterator.next(), exerciseType);
		return exerciseType;
	}

	/**
	 * Gets the first exercise type.
	 *
	 * @return the first exercise type
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public ExerciseType getFirstExerciseType() throws EmptyResultsQueryException {
		ExerciseType exerciseType = new ExerciseType();
		this.<ExerciseType>getFirst(exerciseType);
		return exerciseType;
	}

	/**
	 * Update exercise type.
	 *
	 * @param exerciseType the exercise type
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void updateExerciseType(ExerciseType exerciseType)
			throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(exerciseType), keysMap.getMapOfValues(exerciseType));
	}

	/**
	 * Object constructor.
	 *
	 * @param <DataBaseObject> the generic type
	 * @param mapValues        the map values
	 * @param dataBaseObject   the data base object
	 */
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((ExerciseType) dataBaseObject).setName(mapValues.get("name"));
		((ExerciseType) dataBaseObject).setDescription(mapValues.get("description"));
		((ExerciseType) dataBaseObject).setIdExerciseType(Integer.parseInt(mapValues.get("id_exercise_type")));
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
		valuesMap.put("id_exercise_type", results.getString("id_exercise_type"));
		return valuesMap;
	}

}
