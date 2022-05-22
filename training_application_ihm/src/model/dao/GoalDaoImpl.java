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

import model.objects.Goal;
import model.objects.Velocity;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

/**
 * The Class GoalDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class GoalDaoImpl extends BasicRequestsDao implements GoalDao {

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
			Goal goal = (Goal) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("id_goal", goal.getIdGoal().toString());
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
			Goal goal = (Goal) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("name", goal.getName());
			mapValues.put("duration", goal.getDuration().toString());
			mapValues.put("rest_duration", goal.getRestDuration().toString());
			mapValues.put("velocity", goal.getVelocity().name());
			mapValues.put("id_goal", goal.getIdGoal().toString());

			try {
				mapValues.put("id_GoalNbSerie", goal.getIdGoalNbSerie().toString());
			} catch (NullPointerException e) {
			}
			try {
				mapValues.put("id_GoalNbRep", goal.getIdGoalNbRep().toString());
			} catch (NullPointerException e) {
			}
			try {
				mapValues.put("id_GoalWeight", goal.getIdGoalWeight().toString());
			} catch (NullPointerException e) {
			}
			return mapValues;
		}
	}

	/** The singleton. */
	static GoalDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the goal dao impl
	 */
	public static GoalDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			return new GoalDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new goal dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private GoalDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Goal");
		this.setIdLabel("id_goal");
	}

	/**
	 * Adds the goal.
	 *
	 * @param goal the goal
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addGoal(Goal goal) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(goal));
	}

	/**
	 * Delete goal.
	 *
	 * @param goal the goal
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteGoal(Goal goal) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(goal));
	}

	/**
	 * Gets the all goal.
	 *
	 * @return the all goal
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Goal> getAllGoal() throws EmptyResultsQueryException {
		List<Goal> goalList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for (Map<String, String> valueMap : results) {
			Goal goal = new Goal();
			this.objectConstructor(valueMap, goal);
			goalList.add(goal);
		}
		return goalList;
	}

	/**
	 * Gets the first goal.
	 *
	 * @return the first goal
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Goal getFirstGoal() throws EmptyResultsQueryException {
		Goal goal = new Goal();
		this.<Goal>getFirst(goal);
		return goal;
	}

	/**
	 * Gets the goal by id.
	 *
	 * @param id_goal the id goal
	 * @return the goal by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Goal getGoalById(Integer id_goal) throws EmptyResultsQueryException {
		Goal goal = new Goal();
		this.<Goal>getById(id_goal, goal);
		return goal;
	}

	/**
	 * Gets the goal by name.
	 *
	 * @param name the name
	 * @return the goal by name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Goal getGoalByName(String name) throws EmptyResultsQueryException {
		Map<String, String> getMap = new HashMap<>();
		getMap.put("name", name);

		ArrayList<Map<String, String>> results = this.get(getMap);
		Iterator<Map<String, String>> iterator = results.iterator();

		Goal goal = new Goal();
		this.objectConstructor(iterator.next(), goal);
		return goal;
	}

	/**
	 * Update goal.
	 *
	 * @param goal the goal
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void updateGoal(Goal goal) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(goal), keysMap.getMapOfValues(goal));
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
		((Goal) dataBaseObject).setName(mapValues.get("name"));
		((Goal) dataBaseObject).setDuration(Integer.parseInt(mapValues.get("duration")));
		((Goal) dataBaseObject).setRestDuration(Integer.parseInt(mapValues.get("rest_duration")));
		((Goal) dataBaseObject).setVelocity(Velocity.valueOf(mapValues.get("velocity")));
		((Goal) dataBaseObject).setIdGoal(Integer.parseInt(mapValues.get("id_goal")));

		try {
			((Goal) dataBaseObject).setIdGoalNbSerie(Integer.parseInt(mapValues.get("id_GoalNbSerie")));
		} catch (NumberFormatException e) {
		}

		try {
			((Goal) dataBaseObject).setIdGoalNbRep(Integer.parseInt(mapValues.get("id_GoalNbRep")));
		} catch (NumberFormatException e) {
		}

		try {
			((Goal) dataBaseObject).setIdGoalWeight(Integer.parseInt(mapValues.get("id_GoalWeight")));
		} catch (NumberFormatException e) {
		}
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
		valuesMap.put("duration", results.getString("duration"));
		valuesMap.put("rest_duration", results.getString("rest_duration"));
		valuesMap.put("velocity", results.getString("velocity"));
		valuesMap.put("id_GoalNbSerie", results.getString("id_GoalNbSerie"));
		valuesMap.put("id_GoalNbRep", results.getString("id_GoalNbRep"));
		valuesMap.put("id_GoalWeight", results.getString("id_GoalWeight"));
		valuesMap.put("id_goal", results.getString("id_goal"));
		return valuesMap;
	}

}
