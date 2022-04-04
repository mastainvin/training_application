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

/**
 * @author cytech
 *
 */
public class GoalWeightDaoImpl extends BasicRequestsDao implements GoalWeightDao {

	static GoalWeightDaoImpl singleton = null;
	public static GoalWeightDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new GoalWeightDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private GoalWeightDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("GoalWeight");
		this.setIdLabel("id_GoalWeight");
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
			GoalWeight goalWeight = (GoalWeight) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("min", goalWeight.getMin().toString());
			mapValues.put("max", goalWeight.getMax().toString());
			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			GoalWeight goalWeight = (GoalWeight) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("min", goalWeight.getMin().toString());
			mapValues.put("max", goalWeight.getMax().toString());
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((GoalWeight) dataBaseObject).setMin(Integer.parseInt(mapValues.get("min")));
		((GoalWeight) dataBaseObject).setMax(Integer.parseInt(mapValues.get("max")));
	}
	
	@Override
	public List<GoalWeight> getAllGoalWeight() throws EmptyResultsQueryException {
		List<GoalWeight> goalWeightList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			GoalWeight goalWeight = new GoalWeight();
			this.objectConstructor(valueMap, goalWeight);
			goalWeightList.add(goalWeight);
		}
		return goalWeightList;
	}

	@Override
	public GoalWeight getGoalWeightById(Integer id_goalWeight) throws EmptyResultsQueryException {
		GoalWeight goalWeight = new GoalWeight();
		this.<GoalWeight>getById(id_goalWeight, goalWeight);
		return goalWeight;
	}

	@Override
	public Integer getGoalWeightId(GoalWeight goalWeight) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		return this.getId(valuesMapGet.getMapOfValues(goalWeight));
	}

	@Override
	public void addGoalWeight(GoalWeight goalWeight) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(goalWeight));
	}

	@Override
	public void updateGoalWeight(GoalWeight previousGoalWeight, GoalWeightDao newGoalWeight) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		this.update(this.getId(valuesMapGet.getMapOfValues(previousGoalWeight)), valuesMapInsert.getMapOfValues(newGoalWeight));
	}

	@Override
	public void deleteGoalWeight(GoalWeight goalWeight) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(goalWeight));
	}

}
