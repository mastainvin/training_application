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

/**
 * @author cytech
 *
 */
public class GoalNbRepDaoImpl extends BasicRequestsDao implements GoalNbRepDao {

	static GoalNbRepDaoImpl singleton = null;
	public static GoalNbRepDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new GoalNbRepDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private GoalNbRepDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("GoalNbRep");
		this.setIdLabel("id_GoalNbRep");
	}
	
	@Override
	Map<String, String> setMapFromResultSet(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("min", results.getString("min"));
		valuesMap.put("max", results.getString("max"));
		return valuesMap;
	}
	
	public class MapOfValuesInsert implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			GoalNbRep goalNbRep = (GoalNbRep) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("min", goalNbRep.getMin().toString());
			mapValues.put("max", goalNbRep.getMax().toString());
			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			GoalNbRep goalNbRep = (GoalNbRep) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("min", goalNbRep.getMin().toString());
			mapValues.put("max", goalNbRep.getMax().toString());
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((GoalNbRep) dataBaseObject).setMin(Integer.parseInt(mapValues.get("min")));
		((GoalNbRep) dataBaseObject).setMax(Integer.parseInt(mapValues.get("max")));
	}
	
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

	@Override
	public GoalNbRep getGoalNbRepById(Integer id_goalNbRep) throws EmptyResultsQueryException {
		GoalNbRep goalNbRep = new GoalNbRep();
		this.<GoalNbRep>getById(id_goalNbRep, goalNbRep);
		return goalNbRep;
	}

	@Override
	public Integer getGoalNbRepId(GoalNbRep goalNbRep) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		return this.getId(valuesMapGet.getMapOfValues(goalNbRep));
	}

	@Override
	public void addGoalNbRep(GoalNbRep goalNbRep) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(goalNbRep));
	}

	@Override
	public void updateGoalNbRep(GoalNbRep previousGoalNbRep, GoalNbRepDao newGoalNbRep) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		this.update(this.getId(valuesMapGet.getMapOfValues(previousGoalNbRep)), valuesMapInsert.getMapOfValues(newGoalNbRep));
	}

	@Override
	public void deleteGoalNbRep(GoalNbRep goalNbRep) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(goalNbRep));
	}

}
