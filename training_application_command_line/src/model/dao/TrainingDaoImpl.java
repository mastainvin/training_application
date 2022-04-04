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
public class TrainingDaoImpl extends BasicRequestsDao implements TrainingDao {
	private TrainingTypeDao trainingTypeDao;
	private StructureDao structureDao;
	
	static TrainingDaoImpl singleton = null;
	public static TrainingDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new TrainingDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private TrainingDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Training");
		this.setIdLabel("id_training");
		this.trainingTypeDao = daoFactory.getTrainingTypeDao();
		this.structureDao = daoFactory.getStructureDao();
	}
	
	@Override
	Map<String, String> setMapFromResultSet(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("description", results.getString("description"));
		valuesMap.put("id_training_type", results.getString("id_training_type"));
		valuesMap.put("layout", results.getString("layout"));
		valuesMap.put("duration", results.getString("duration"));
		return valuesMap;
	}
	
	public class MapOfValuesInsert implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Training training = (Training) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", training.getName());
			mapValues.put("description", training.getDescription());
			mapValues.put("layout", training.getLayout().toString());
			mapValues.put("duration", training.getDuration().toString());
			try {
				mapValues.put("id_training_type", trainingTypeDao.getTrainingTypeId(training.getTrainingType()).toString());
			} catch (EmptyResultsQueryException e) {	
				mapValues.put("id_training_type", "NULL");
			}
			

			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Training training = (Training) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", training.getName());
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((Training) dataBaseObject).setName(mapValues.get("name"));
		((Training) dataBaseObject).setDescription(mapValues.get("description"));
		((Training) dataBaseObject).setLayout(Integer.parseInt(mapValues.get("layout")));
		((Training) dataBaseObject).setDuration(Integer.parseInt(mapValues.get("duration")));
		try {
			((Training) dataBaseObject).setTrainingType(trainingTypeDao.getTrainingTypeById(Integer.parseInt(mapValues.get("id_training_type"))));
		} catch (EmptyResultsQueryException e) {	
		}
		
	}
	
	
	@Override
	public List<Training> getAllTraining() throws EmptyResultsQueryException {
		List<Training> trainingList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			Training training = new Training();
			this.objectConstructor(valueMap, training);
			trainingList.add(training);
		}
		return trainingList;
	}	

	@Override
	public Training getFirstTraining() throws EmptyResultsQueryException {
		Training training = new Training();
		this.<Training>getFirst(training);
		return training;
	}

	@Override
	public Training getTrainingByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		Training training = new Training();
		training.setName(name);
		ArrayList<Map<String, String>> results = this.get(valuesMapGet.getMapOfValues(training));
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), training);
		return training;
	}
	
	@Override
	public Training getTrainingById(Integer id_training) throws EmptyResultsQueryException {
		Training training = new Training();
		this.<Training>getById(id_training, training);
		return training;
	}
	
	@Override
	public Integer getTrainingId(Training training) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		return this.getId(valuesMapGet.getMapOfValues(training));
	}
	
	@Override
	public void addTraining(Training training, Structure motherStructure) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		Map<String,String> getMap = valuesMap.getMapOfValues(training);
		try {
			getMap.put("id_structure", structureDao.getStructureId(motherStructure).toString());
		} catch (EmptyResultsQueryException e) {
			getMap.put("id_structure", "NULL");
		}
		
		this.add(getMap);
	}

	@Override
	public void updateTraining(Training previousTraining, Training newTraining, Structure motherStructure) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		Map<String,String> insertMap = valuesMapInsert.getMapOfValues(newTraining);
		try {
			insertMap.put("id_structure", structureDao.getStructureId(motherStructure).toString());
		} catch (EmptyResultsQueryException e) {
			insertMap.put("id_structure", "NULL");
		}
		this.update(this.getId(valuesMapGet.getMapOfValues(previousTraining)), insertMap);
	}

	@Override
	public void deleteTraining(Training training) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(training));
	}

	@Override
	public List<Training> getTrainingsListFromStructure(Structure structure) throws EmptyResultsQueryException{
		List<Training> trainingList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	    ResultSet results = null;

	    try {
	    	
	    	String sqlRequest = "SELECT t.* FROM Structure s, Training t WHERE s.id_structure = t.id_structure AND s.name = '" + structure.getName()+ "';";
	
	        connection = this.getDaoFactory().getConnection();
	        preparedStatement = connection.prepareStatement(sqlRequest);
	        results = preparedStatement.executeQuery();
	        
	        boolean empty = true;
	        while(results.next()) {
	        	Training training = new Training();
	        	this.objectConstructor(this.setMapFromResultSet(results), training);
	        	trainingList.add(training);
            	empty=false;
            }
            
	        if (empty) {
	        	throw new EmptyResultsQueryException();
            } 
	        
	  
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return trainingList;
	}
}
