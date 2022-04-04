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

/**
 * @author Vincednt Mastain
 * @version 1.0
 */
public class GoalDaoImpl extends BasicRequestsDao implements GoalDao {
	private GoalNbSerieDao goalNbSerieDao;
	private GoalNbRepDao goalNbRepDao;
	private GoalWeightDao goalWeightDao;
	
	static GoalDaoImpl singleton = null;
	public static GoalDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new GoalDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private GoalDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Goal");
		this.setIdLabel("id_goal");
		this.goalNbSerieDao = daoFactory.getGoalNbSerieDao();
		this.goalNbRepDao = daoFactory.getGoalNbRepDao();
		this.goalWeightDao = daoFactory.getGoalWeightDao();
	}
	
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
		return valuesMap;
	}
	
	public class MapOfValuesInsert implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Goal goal = (Goal) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", goal.getName());
			mapValues.put("duration", goal.getDuration().toString());
			mapValues.put("rest_duration", goal.getRestDuration().toString());
			mapValues.put("velocity", goal.getVelocity().name());
			
			try {
				mapValues.put("id_GoalNbSerie", goalNbSerieDao.getGoalNbSerieId(goal.getGoalNbSerie()).toString());
			} catch (EmptyResultsQueryException e) {
				mapValues.put("id_GoalNbSerie", "NULL");
			}
			
			try {
				mapValues.put("id_GoalNbRep", goalNbRepDao.getGoalNbRepId(goal.getGoalNbRep()).toString());
			} catch (EmptyResultsQueryException e) {
				mapValues.put("id_GoalNbRep", "NULL");
			}
			
			try {
				mapValues.put("id_GoalWeight", goalWeightDao.getGoalWeightId(goal.getGoalWeight()).toString());
			} catch (EmptyResultsQueryException e) {
				mapValues.put("id_GoalWeight", "NULL");
			}
			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Goal goal = (Goal) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", goal.getName());
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((Goal) dataBaseObject).setName(mapValues.get("name"));
		((Goal) dataBaseObject).setDuration(Integer.parseInt(mapValues.get("duration")));
		((Goal) dataBaseObject).setDuration(Integer.parseInt(mapValues.get("rest_duration")));
		((Goal) dataBaseObject).setVelocity(Velocity.valueOf(mapValues.get("velocity")));
		
		try {
			((Goal) dataBaseObject).setGoalNbSerie(goalNbSerieDao.getGoalNbSerieById(Integer.valueOf(mapValues.get("id_GoalNbSerie"))));
		} catch (EmptyResultsQueryException e) {
		}
		
		try {
			((Goal) dataBaseObject).setGoalNbRep(goalNbRepDao.getGoalNbRepById(Integer.valueOf(mapValues.get("id_GoalNbRep"))));
		} catch (EmptyResultsQueryException e) {
		}
		
		try {
			((Goal) dataBaseObject).setGoalWeight(goalWeightDao.getGoalWeightById(Integer.valueOf(mapValues.get("id_GoalWeight"))));
		} catch (EmptyResultsQueryException e) {
		}
		
	}
	
	
	@Override
	public List<Goal> getAllGoal() throws EmptyResultsQueryException {
		List<Goal> goalList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			Goal goal = new Goal();
			this.objectConstructor(valueMap, goal);
			goalList.add(goal);
		}
		return goalList;
	}	

	@Override
	public Goal getFirstGoal() throws EmptyResultsQueryException {
		Goal goal = new Goal();
		this.<Goal>getFirst(goal);
		return goal;
	}

	@Override
	public Goal getGoalByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		Goal goal = new Goal();
		goal.setName(name);
		ArrayList<Map<String, String>> results = this.get(valuesMapGet.getMapOfValues(goal));
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), goal);
		return goal;
	}
	
	@Override
	public Goal getGoalById(Integer id_goal) throws EmptyResultsQueryException {
		Goal goal = new Goal();
		this.<Goal>getById(id_goal, goal);
		return goal;
	}
	
	@Override
	public Integer getGoalId(Goal goal) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		return this.getId(valuesMapGet.getMapOfValues(goal));
	}
	
	@Override
	public void addGoal(Goal goal) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(goal));
	}

	@Override
	public void updateGoal(Goal previousGoal, Goal newGoal) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		this.update(this.getId(valuesMapGet.getMapOfValues(previousGoal)), valuesMapInsert.getMapOfValues(newGoal));
	}

	@Override
	public void deleteGoal(Goal goal) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(goal));
	}

}
