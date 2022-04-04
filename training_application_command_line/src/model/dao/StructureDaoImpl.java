/**
 * 
 */
package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.objects.Structure;
import model.objects.Training;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincednt Mastain
 * @version 1.0
 */
public class StructureDaoImpl extends BasicRequestsDao implements StructureDao {
	private GoalDao goalDao;
	
	static StructureDaoImpl singleton = null;
	public static StructureDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new StructureDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private StructureDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Structure");
		this.setIdLabel("id_structure");
		this.goalDao = daoFactory.getGoalDao();
	}
	
	@Override
	Map<String, String> setMapFromResultSet(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("id_goal", results.getString("id_goal"));
		return valuesMap;
	}
	
	public class MapOfValuesInsert implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Structure structure = (Structure) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", structure.getName());
			
			try {
				mapValues.put("id_goal", goalDao.getGoalId(structure.getGoal()).toString());
			} catch (EmptyResultsQueryException e) {	
				mapValues.put("id_goal", "NULL");
			}
			

			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Structure structure = (Structure) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", structure.getName());
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((Structure) dataBaseObject).setName(mapValues.get("name"));
		
		try {
			((Structure) dataBaseObject).setGoal(goalDao.getGoalById(Integer.parseInt(mapValues.get("id_goal"))));
		} catch (EmptyResultsQueryException e) {	
		}
		
	}
	
	
	@Override
	public List<Structure> getAllStructure() throws EmptyResultsQueryException {
		List<Structure> structureList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			Structure structure = new Structure();
			this.objectConstructor(valueMap, structure);
			structureList.add(structure);
		}
		return structureList;
	}	

	@Override
	public Structure getFirstStructure() throws EmptyResultsQueryException {
		Structure structure = new Structure();
		this.<Structure>getFirst(structure);
		return structure;
	}

	@Override
	public Structure getStructureByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		Structure structure = new Structure();
		structure.setName(name);
		ArrayList<Map<String, String>> results = this.get(valuesMapGet.getMapOfValues(structure));
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), structure);
		return structure;
	}
	
	@Override
	public Structure getStructureById(Integer id_structure) throws EmptyResultsQueryException {
		Structure structure = new Structure();
		this.<Structure>getById(id_structure, structure);
		return structure;
	}
	
	@Override
	public Integer getStructureId(Structure structure) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		return this.getId(valuesMapGet.getMapOfValues(structure));
	}
	
	@Override
	public void addStructure(Structure structure) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(structure));
	}

	@Override
	public void updateStructure(Structure previousStructure, Structure newStructure) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		this.update(this.getId(valuesMapGet.getMapOfValues(previousStructure)), valuesMapInsert.getMapOfValues(newStructure));
	}

	@Override
	public void deleteStructure(Structure structure) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(structure));
	}

	

	@Override
	public Structure getStructureFromTraining(Training training) throws EmptyResultsQueryException {
		Structure structure = new Structure();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	    ResultSet results = null;

	    try {
	    	
	    	String sqlRequest = "SELECT s.* FROM Structure s, Training t WHERE s.id_structure = t.id_structure AND t.name = '" + training.getName() + "';";
	
	        connection = this.getDaoFactory().getConnection();
	        preparedStatement = connection.prepareStatement(sqlRequest);
	        results = preparedStatement.executeQuery();
	        
	        if (results.next()) {
	        	this.objectConstructor(this.setMapFromResultSet(results), structure);
	        } else {
	        	throw new EmptyResultsQueryException();
	        }
	     
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return structure;
	}

}
