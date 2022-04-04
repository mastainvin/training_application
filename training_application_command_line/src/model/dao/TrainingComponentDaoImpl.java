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

import model.objects.ExerciceType;
import model.objects.Training;
import model.objects.TrainingComponent;
import model.objects.TrainingMethod;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public class TrainingComponentDaoImpl extends BasicRequestsDao implements TrainingComponentDao {
	ExerciceTypeDao exerciceTypeDao;
	TrainingMethodDao trainingMethodDao;
	TrainingDao trainingDao;
	
	static TrainingComponentDaoImpl singleton = null;
	public static TrainingComponentDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new TrainingComponentDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private TrainingComponentDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("ComposeTraining");
		this.exerciceTypeDao = daoFactory.getExerciceTypeDao();
		this.trainingMethodDao = daoFactory.getTrainingMethodDao();
		this.trainingDao = daoFactory.getTrainingDao();
	}
	
	@Override
	Map<String, String> setMapFromResultSet(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("id_training", results.getString("id_training"));
		valuesMap.put("id_exercice_type", results.getString("id_type"));
		valuesMap.put("id_training_method", results.getString("id_training_method"));
		valuesMap.put("layout", results.getString("layout"));
		valuesMap.put("met", results.getString("met"));
		valuesMap.put("is_super_set", results.getString("is_super_set"));
		return valuesMap;
	}
	
	public class MapOfValuesInsert implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			TrainingComponent trainingComponent = (TrainingComponent) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("layout", trainingComponent.getLayout().toString());
			mapValues.put("met", trainingComponent.getMet().toString());
			mapValues.put("is_super_set", trainingComponent.getIsSuperSet().toString());

			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			TrainingComponent trainingComponent = (TrainingComponent) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("layout", trainingComponent.getLayout().toString());
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((TrainingComponent) dataBaseObject).setLayout(Integer.parseInt(mapValues.get("layout")));
		((TrainingComponent) dataBaseObject).setIsSuperSet(Boolean.parseBoolean(mapValues.get("is_super_set")));
		((TrainingComponent) dataBaseObject).setMet(Double.parseDouble(mapValues.get("layout")));
		
		try {
			((TrainingComponent) dataBaseObject).setExerciceType(exerciceTypeDao.getExerciceTypeById(Integer.parseInt(mapValues.get("id_type"))));
		} catch (EmptyResultsQueryException e) {
		}
		
		try {
			((TrainingComponent) dataBaseObject).setTrainingMethod(trainingMethodDao.getTrainingMethodById(Integer.parseInt(mapValues.get("id_training_method"))));
		} catch (EmptyResultsQueryException e) {
		}
		
	}
	
	
	@Override
	public List<TrainingComponent> getAllTrainingComponent() throws EmptyResultsQueryException{
		List<TrainingComponent> trainingComponentList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			TrainingComponent trainingComponent = new TrainingComponent();
			this.objectConstructor(valueMap, trainingComponent);
			trainingComponentList.add(trainingComponent);
		}
		return trainingComponentList;
	}	

	@Override
	public TrainingComponent getFirstTrainingComponent() throws EmptyResultsQueryException {
		TrainingComponent trainingComponent = new TrainingComponent();
		this.<TrainingComponent>getFirst(trainingComponent);
		return trainingComponent;
	}

	@Override
	public TrainingComponent getTrainingComponent(TrainingMethod trainingMethod, ExerciceType exerciceType, Training training, Integer layout) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		TrainingComponent trainingComponent = new TrainingComponent();
		trainingComponent.setLayout(layout);
		Map<String,String> values = valuesMapGet.getMapOfValues(trainingComponent);
		values.put("id_training", this.trainingDao.getTrainingId(training).toString());
		values.put("id_type", this.exerciceTypeDao.getExerciceTypeId(exerciceType).toString());
		values.put("id_training_method", this.trainingMethodDao.getTrainingMethodId(trainingMethod).toString());
		
		ArrayList<Map<String, String>> results = this.get(values);
		Iterator<Map<String, String>> iterator = results.iterator();
		
		this.objectConstructor(iterator.next(), trainingComponent);
		return trainingComponent;
	}
	
	@Override
	public void addTrainingComponent(TrainingComponent trainingComponent, Training training) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		Map<String,String> getMap = valuesMap.getMapOfValues(trainingComponent);
		
		try {
			getMap.put("id_type", exerciceTypeDao.getExerciceTypeId(trainingComponent.getExerciceType()).toString());
		} catch (EmptyResultsQueryException e) {
			getMap.put("id_type", "NULL");
		}
		
		try {
			getMap.put("id_training_method", trainingMethodDao.getTrainingMethodId(trainingComponent.getTrainingMethod()).toString());
		} catch (EmptyResultsQueryException e) {
			getMap.put("id_training_method", "NULL");
		}
		
		try {
			getMap.put("id_training", trainingDao.getTrainingId(training).toString());
		} catch (EmptyResultsQueryException e) {
			getMap.put("id_training", "NULL");
		}
		
		this.add(getMap);
	}

	@Override
	public void updateTrainingComponent(TrainingComponent previousTrainingComponent, TrainingComponent newTrainingComponent, Training training) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		Map<String,String> insertMap = valuesMapInsert.getMapOfValues(newTrainingComponent);
		try {
			insertMap.put("id_type", exerciceTypeDao.getExerciceTypeId(newTrainingComponent.getExerciceType()).toString());
		} catch (EmptyResultsQueryException e) {
			insertMap.put("id_type", "NULL");
		}
		
		try {
			insertMap.put("id_training_method", trainingMethodDao.getTrainingMethodId(newTrainingComponent.getTrainingMethod()).toString());
		} catch (EmptyResultsQueryException e) {
			insertMap.put("id_training_method", "NULL");
		}
		
		try {
			insertMap.put("id_training", trainingDao.getTrainingId(training).toString());
		} catch (EmptyResultsQueryException e) {
			insertMap.put("id_training", "NULL");
		}
		this.update(this.getId(valuesMapGet.getMapOfValues(previousTrainingComponent)), insertMap);
	}

	@Override
	public void deleteTrainingComponent(TrainingComponent trainingComponent, Training training) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		Map<String,String> insertMap = valuesMap.getMapOfValues(trainingComponent);
		try {
			insertMap.put("id_training", trainingDao.getTrainingId(training).toString());
		} catch (EmptyResultsQueryException e) {
			insertMap.put("id_training", "NULL");
		}
		
		this.delete(insertMap);
	}

	@Override
	public Map<String, String> getTrainingComponentId(TrainingComponent trainingComponent, Training training) throws EmptyResultsQueryException {
		Map<String, String> ids = new HashMap<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	    ResultSet results = null;

	    try {
	    	
	    	String sqlRequest = "SELECT id_training, id_type, id_training_method, layout FROM Training t, ComposeTraining ct WHERE t.id_training = ct.id_training AND t.name = '" + training.getName()+ "' AND ct.layout = '"+ trainingComponent.getLayout()+"';";
	
	        connection = this.getDaoFactory().getConnection();
	        preparedStatement = connection.prepareStatement(sqlRequest);
	        results = preparedStatement.executeQuery();
	        
	        if (results.next()) {
	        	ids.put("id_training", results.getString("id_training"));
	        	ids.put("id_type", results.getString("id_type"));
	        	ids.put("id_training_method", results.getString("id_training_method"));
	        	ids.put("layout", results.getString("layout"));
            } else {
            	throw new EmptyResultsQueryException();
            }
	        
	  
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return ids;
	}

	@Override
	public List<TrainingComponent> getTrainingsComponentsListFromTraining(Training training) throws EmptyResultsQueryException {
		List<TrainingComponent> trainingComponentList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	    ResultSet results = null;

	    try {
	    	
	    	String sqlRequest = "SELECT ct.* FROM Training t, ComposeTraining ct WHERE t.id_training = ct.id_training AND t.name = '" + training.getName()+ "';";
	
	        connection = this.getDaoFactory().getConnection();
	        preparedStatement = connection.prepareStatement(sqlRequest);
	        results = preparedStatement.executeQuery();
	        
	        boolean empty = true;
	        while(results.next()) {
	        	TrainingComponent trainingComponent = new TrainingComponent();
	        	this.objectConstructor(this.setMapFromResultSet(results), trainingComponent);
	        	trainingComponentList.add(trainingComponent);
            	empty=false;
            }
            
	        if (empty) {
	        	throw new EmptyResultsQueryException();
            } 
	        
	  
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return trainingComponentList;
	}

	
}
