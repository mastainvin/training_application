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

import model.objects.GoalNbSerie;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class GoalNbSerieDaoImpl.
 *
 * @author cytech
 */
public class GoalNbSerieDaoImpl extends BasicRequestsDao implements GoalNbSerieDao {

	/** The singleton. */
	static GoalNbSerieDaoImpl singleton = null;
	
	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the goal nb serie dao impl
	 */
	public static GoalNbSerieDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new GoalNbSerieDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	/**
	 * Instantiates a new goal nb serie dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private GoalNbSerieDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("GoalNbSerie");
		this.setIdLabel("id_GoalNbSerie");
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
		valuesMap.put("id_GoalNbSerie", results.getString("id_GoalNbSerie"));
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
			GoalNbSerie goalNbSerie = (GoalNbSerie) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("min", goalNbSerie.getMin().toString());
			mapValues.put("max", goalNbSerie.getMax().toString());
			mapValues.put("id_GoalNbSerie", goalNbSerie.getIdGoalNbSerie().toString());
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
			GoalNbSerie goalNbSerie = (GoalNbSerie) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("id_GoalNbSerie", goalNbSerie.getIdGoalNbSerie().toString());
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
		((GoalNbSerie) dataBaseObject).setMin(Integer.parseInt(mapValues.get("min")));
		((GoalNbSerie) dataBaseObject).setMax(Integer.parseInt(mapValues.get("max")));
		((GoalNbSerie) dataBaseObject).setIdGoalNbSerie(Integer.parseInt(mapValues.get("id_GoalNbSerie")));
	}
	
	/**
	 * Gets the all goal nb serie.
	 *
	 * @return the all goal nb serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<GoalNbSerie> getAllGoalNbSerie() throws EmptyResultsQueryException {
		List<GoalNbSerie> goalNbSerieList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			GoalNbSerie goalNbSerie = new GoalNbSerie();
			this.objectConstructor(valueMap, goalNbSerie);
			goalNbSerieList.add(goalNbSerie);
		}
		return goalNbSerieList;
	}

	/**
	 * Gets the goal nb serie by id.
	 *
	 * @param id_goalNbSerie the id goal nb serie
	 * @return the goal nb serie by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public GoalNbSerie getGoalNbSerieById(Integer id_goalNbSerie) throws EmptyResultsQueryException {
		GoalNbSerie goalNbSerie = new GoalNbSerie();
		this.<GoalNbSerie>getById(id_goalNbSerie, goalNbSerie);
		return goalNbSerie;
	}

	/**
	 * Adds the goal nb serie.
	 *
	 * @param goalNbSerie the goal nb serie
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addGoalNbSerie(GoalNbSerie goalNbSerie) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(goalNbSerie));
	}

	/**
	 * Update goal nb serie.
	 *
	 * @param goalNbSerie the goal nb serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void updateGoalNbSerie(GoalNbSerieDao goalNbSerie) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(goalNbSerie), keysMap.getMapOfValues(goalNbSerie));
	}

	/**
	 * Delete goal nb serie.
	 *
	 * @param goalNbSerie the goal nb serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteGoalNbSerie(GoalNbSerie goalNbSerie) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(goalNbSerie));
	}

}
