/**
 * 
 */
package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.objects.GoalWeight;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class GoalWeightDaoImpl.
 *
 * @author cytech
 */
public class GoalWeightDaoImpl extends BasicRequestsDao implements GoalWeightDao {

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
			GoalWeight goalWeight = (GoalWeight) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String, String>();
			mapValues.put("id_GoalWeight", goalWeight.getIdGoalWeight().toString());
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
			GoalWeight goalWeight = (GoalWeight) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String, String>();
			mapValues.put("min", goalWeight.getMin().toString());
			mapValues.put("max", goalWeight.getMax().toString());
			mapValues.put("id_GoalWeight", goalWeight.getIdGoalWeight().toString());
			return mapValues;
		}
	}

	/** The singleton. */
	static GoalWeightDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the goal weight dao impl
	 */
	public static GoalWeightDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			return new GoalWeightDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new goal weight dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private GoalWeightDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("GoalWeight");
		this.setIdLabel("id_GoalWeight");
	}

	/**
	 * Adds the goal weight.
	 *
	 * @param goalWeight the goal weight
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addGoalWeight(GoalWeight goalWeight) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(goalWeight));
	}

	/**
	 * Delete goal weight.
	 *
	 * @param goalWeight the goal weight
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteGoalWeight(GoalWeight goalWeight) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(goalWeight));
	}

	/**
	 * Gets the all goal weight.
	 *
	 * @return the all goal weight
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<GoalWeight> getAllGoalWeight() throws EmptyResultsQueryException {
		List<GoalWeight> goalWeightList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for (Map<String, String> valueMap : results) {
			GoalWeight goalWeight = new GoalWeight();
			this.objectConstructor(valueMap, goalWeight);
			goalWeightList.add(goalWeight);
		}
		return goalWeightList;
	}

	/**
	 * Gets the goal weight by id.
	 *
	 * @param id_goalWeight the id goal weight
	 * @return the goal weight by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public GoalWeight getGoalWeightById(Integer id_goalWeight) throws EmptyResultsQueryException {
		GoalWeight goalWeight = new GoalWeight();
		this.<GoalWeight>getById(id_goalWeight, goalWeight);
		return goalWeight;
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
		((GoalWeight) dataBaseObject).setMin(Integer.parseInt(mapValues.get("min")));
		((GoalWeight) dataBaseObject).setMax(Integer.parseInt(mapValues.get("max")));
		((GoalWeight) dataBaseObject).setIdGoalWeight(Integer.parseInt(mapValues.get("id_GoalWeight")));
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
		valuesMap.put("min", results.getString("min"));
		valuesMap.put("max", results.getString("max"));
		valuesMap.put("id_GoalWeight", results.getString("id_GoalWeight"));
		return valuesMap;
	}

	/**
	 * Update goal weight.
	 *
	 * @param goalWeight the goal weight
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void updateGoalWeight(GoalWeightDao goalWeight) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(goalWeight), keysMap.getMapOfValues(goalWeight));
	}

}
