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

/**
 * @author cytech
 *
 */
public class GoalNbSerieDaoImpl extends BasicRequestsDao implements GoalNbSerieDao {

	static GoalNbSerieDaoImpl singleton = null;
	public static GoalNbSerieDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new GoalNbSerieDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private GoalNbSerieDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("GoalNbSerie");
		this.setIdLabel("id_GoalNbSerie");
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
			GoalNbSerie goalNbSerie = (GoalNbSerie) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("min", goalNbSerie.getMin().toString());
			mapValues.put("max", goalNbSerie.getMax().toString());
			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			GoalNbSerie goalNbSerie = (GoalNbSerie) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("min", goalNbSerie.getMin().toString());
			mapValues.put("max", goalNbSerie.getMax().toString());
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((GoalNbSerie) dataBaseObject).setMin(Integer.parseInt(mapValues.get("min")));
		((GoalNbSerie) dataBaseObject).setMax(Integer.parseInt(mapValues.get("max")));
	}
	
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

	@Override
	public GoalNbSerie getGoalNbSerieById(Integer id_goalNbSerie) throws EmptyResultsQueryException {
		GoalNbSerie goalNbSerie = new GoalNbSerie();
		this.<GoalNbSerie>getById(id_goalNbSerie, goalNbSerie);
		return goalNbSerie;
	}

	@Override
	public Integer getGoalNbSerieId(GoalNbSerie goalNbSerie) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		return this.getId(valuesMapGet.getMapOfValues(goalNbSerie));
	}

	@Override
	public void addGoalNbSerie(GoalNbSerie goalNbSerie) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(goalNbSerie));
	}

	@Override
	public void updateGoalNbSerie(GoalNbSerie previousGoalNbSerie, GoalNbSerieDao newGoalNbSerie) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		this.update(this.getId(valuesMapGet.getMapOfValues(previousGoalNbSerie)), valuesMapInsert.getMapOfValues(newGoalNbSerie));
	}

	@Override
	public void deleteGoalNbSerie(GoalNbSerie goalNbSerie) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(goalNbSerie));
	}

}
