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

import model.objects.GoalNbRep;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class GoalNbRepDaoImpl.
 *
 * @author cytech
 */
public class GoalNbRepDaoImpl extends BasicRequestsDao implements GoalNbRepDao {

	/** The singleton. */
	static GoalNbRepDaoImpl singleton = null;
	
	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the goal nb rep dao impl
	 */
	public static GoalNbRepDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new GoalNbRepDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	/**
	 * Instantiates a new goal nb rep dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private GoalNbRepDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("GoalNbRep");
		this.setIdLabel("id_GoalNbRep");
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
		valuesMap.put("id_GoalNbRep", results.getString("id_GoalNbRep"));
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
			GoalNbRep goalNbRep = (GoalNbRep) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("min", goalNbRep.getMin().toString());
			mapValues.put("max", goalNbRep.getMax().toString());
			mapValues.put("id_GoalNbRep", goalNbRep.getIdGoalNbrep().toString());
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
			GoalNbRep goalNbRep = (GoalNbRep) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("id_GoalNbRep", goalNbRep.getIdGoalNbrep().toString());
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
		((GoalNbRep) dataBaseObject).setMin(Integer.parseInt(mapValues.get("min")));
		((GoalNbRep) dataBaseObject).setMax(Integer.parseInt(mapValues.get("max")));
		((GoalNbRep) dataBaseObject).setIdGoalNbrep(Integer.parseInt(mapValues.get("id_GoalNbRep")));
	}
	
	/**
	 * Gets the all goal nb rep.
	 *
	 * @return the all goal nb rep
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<GoalNbRep> getAllGoalNbRep() throws EmptyResultsQueryException {
		List<GoalNbRep> goalNbRepList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			GoalNbRep goalNbRep = new GoalNbRep();
			this.objectConstructor(valueMap, goalNbRep);
			goalNbRepList.add(goalNbRep);
		}
		return goalNbRepList;
	}

	/**
	 * Gets the goal nb rep by id.
	 *
	 * @param id_goalNbRep the id goal nb rep
	 * @return the goal nb rep by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public GoalNbRep getGoalNbRepById(Integer id_goalNbRep) throws EmptyResultsQueryException {
		GoalNbRep goalNbRep = new GoalNbRep();
		this.<GoalNbRep>getById(id_goalNbRep, goalNbRep);
		return goalNbRep;
	}

	/**
	 * Adds the goal nb rep.
	 *
	 * @param goalNbRep the goal nb rep
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addGoalNbRep(GoalNbRep goalNbRep) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(goalNbRep));
	}

	/**
	 * Update goal nb rep.
	 *
	 * @param goalNbRep the goal nb rep
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void updateGoalNbRep(GoalNbRepDao goalNbRep) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(goalNbRep), keysMap.getMapOfValues(goalNbRep));
	}

	/**
	 * Delete goal nb rep.
	 *
	 * @param goalNbRep the goal nb rep
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteGoalNbRep(GoalNbRep goalNbRep) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(goalNbRep));
	}

}
