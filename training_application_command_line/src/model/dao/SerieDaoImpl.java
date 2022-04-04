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
import model.objects.TrainingComponent;
import model.objects.User;
import model.objects.Exercice;
import model.objects.Serie;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

/**
 * @author Vincednt Mastain
 * @version 1.0
 */
public class SerieDaoImpl extends BasicRequestsDao implements SerieDao {
	private TrainingComponentDao trainingComponentDao;
	private UserDao userDao;
	private ExerciceDao exerciceDao;
	
	static SerieDaoImpl singleton = null;
	public static SerieDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new SerieDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private SerieDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Serie");
		this.setIdLabel("id_serie");
		this.trainingComponentDao = daoFactory.getTrainingComponentDao();
		this.userDao = daoFactory.getUserDao();
		this.exerciceDao = daoFactory.getExerciceDao();
	}
	
	@Override
	Map<String, String> setMapFromResultSet(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("id_serie", results.getString("id_serie"));
		valuesMap.put("date", results.getString("date"));
		valuesMap.put("weight", results.getString("weight"));
		valuesMap.put("repetitions", results.getString("repetitions"));
		valuesMap.put("rpe", results.getString("rpe"));
		valuesMap.put("expected_repetitions", results.getString("expected_repetitions"));
		valuesMap.put("expected_weight", results.getString("expected_weight"));
		valuesMap.put("id_compose_training_training", results.getString("id_compose_training_training"));
		valuesMap.put("id_compose_training_type", results.getString("id_compose_training_type"));
		valuesMap.put("id_compose_training_method", results.getString("rpe"));
		valuesMap.put("id_user", results.getString("id_user"));
		valuesMap.put("id_exercice", results.getString("id_exercice"));
		valuesMap.put("compose_training_layout", results.getString("compose_training_layout"));
		valuesMap.put("layout", results.getString("layout"));
		valuesMap.put("in_actual_training", results.getString("in_actual_training"));
		return valuesMap;
	}
	
	public class MapOfValuesInsert implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Serie serie = (Serie) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("date", serie.getDate());
			mapValues.put("weight", serie.getWeight().toString());
			mapValues.put("repetitions", serie.getRepetitions().toString());
			mapValues.put("expected_repetitions", serie.getExpectedRepetitions().toString());
			mapValues.put("expected_weight", serie.getExpectedWeight().toString());
			mapValues.put("layout", serie.getLayout().toString());
			mapValues.put("in_actual_training", serie.getInActualWeek().toString());
			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Map<String, String> mapValues = new HashMap<String,String>();
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((Serie) dataBaseObject).setDate(mapValues.get("date"));
		((Serie) dataBaseObject).setWeight(Integer.parseInt(mapValues.get("weight")));
		((Serie) dataBaseObject).setRepetitions(Integer.parseInt(mapValues.get("repetitions")));
		((Serie) dataBaseObject).setRpe(Integer.parseInt(mapValues.get("rpe")));
		((Serie) dataBaseObject).setExpectedWeight(Integer.parseInt(mapValues.get("expected_weight")));
		((Serie) dataBaseObject).setExpectedRepetitions(Integer.parseInt(mapValues.get("weight")));
		((Serie) dataBaseObject).setLayout(Integer.parseInt(mapValues.get("layout")));
		if(mapValues.get("in_actual_week") == "1") {
			((Serie) dataBaseObject).setInActualWeek(true);
		} else {
			((Serie) dataBaseObject).setInActualWeek(false);
		}
	}
	
	
	@Override
	public List<Serie> getAllSerie() throws EmptyResultsQueryException {
		List<Serie> serieList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			Serie serie = new Serie();
			this.objectConstructor(valueMap, serie);
			serieList.add(serie);
		}
		return serieList;
	}	


	@Override
	public Serie getSerieById(Integer id_serie) throws EmptyResultsQueryException {
		Serie serie = new Serie();
		this.<Serie>getById(id_serie, serie);
		return serie;
	}
	
	@Override
	public Integer getSerieId(Serie serie, TrainingComponent trainingComponent, Training training, User user) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		Map<String,String> getMap = valuesMapGet.getMapOfValues(serie);
		try {
			Map<String, String> components_id = trainingComponentDao.getTrainingComponentId(trainingComponent, training);
			getMap.put("id_compose_training_training", components_id.get("id_training"));
			getMap.put("id_compose_training_type", components_id.get("id_type"));
			getMap.put("id_compose_training_method", components_id.get("id_training_method"));
			getMap.put("compose_training_layout", components_id.get("layout"));
		} catch (EmptyResultsQueryException e) {
			throw new InsertDataBaseException("no trainingcomponent associated");
		}
		
		try {
			getMap.put("id_user", userDao.getUserId(user).toString());
		} catch(EmptyResultsQueryException e) {
			throw new InsertDataBaseException("no user associated");
		}
		
		try {
			List<Exercice> exercicesList = trainingComponent.getExerciceType().getExercicesList();
			if(exercicesList.size() != 1) {
				throw new InsertDataBaseException("multiple exercices are still in component");
			}
			for(Exercice exercice : exercicesList) {
				getMap.put("id_exercice", exerciceDao.getExerciceId(exercice).toString());
			}
		} catch (EmptyResultsQueryException e) {
			throw new InsertDataBaseException("no exercice type associated");
		}
		
		return this.getId(getMap);
	}
	
	@Override
	public void addSerie(Serie serie, TrainingComponent trainingComponent, User user, Training training, Integer layout) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		Map<String,String> getMap = valuesMap.getMapOfValues(serie);
		try {
			Map<String, String> components_id = trainingComponentDao.getTrainingComponentId(trainingComponent, training);
			getMap.put("id_compose_training_training", components_id.get("id_training"));
			getMap.put("id_compose_training_type", components_id.get("id_type"));
			getMap.put("id_compose_training_method", components_id.get("id_training_method"));
			getMap.put("compose_training_layout", components_id.get("layout"));
		} catch (EmptyResultsQueryException e) {
			throw new InsertDataBaseException("no trainingcomponent associated");
		}
		
		try {
			getMap.put("id_user", userDao.getUserId(user).toString());
		} catch(EmptyResultsQueryException e) {
			throw new InsertDataBaseException("no user associated");
		}
		
		try {
			List<Exercice> exercicesList = trainingComponent.getExerciceType().getExercicesList();
			if(exercicesList.size() != 1) {
				throw new InsertDataBaseException("multiple exercices are still in component");
			}
			for(Exercice exercice : exercicesList) {
				getMap.put("id_exercice", exerciceDao.getExerciceId(exercice).toString());
			}
		} catch (EmptyResultsQueryException e) {
			throw new InsertDataBaseException("no exercice type associated");
		}
		this.add(getMap);
	}

	@Override
	public void updateSerie(Serie previousSerie, Serie newSerie, TrainingComponent trainingComponent, Training training, User user, Integer layout) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		Map<String,String> insertMap = valuesMapInsert.getMapOfValues(newSerie);
		try {
			Map<String, String> components_id = trainingComponentDao.getTrainingComponentId(trainingComponent, training);
			insertMap.put("id_compose_training_training", components_id.get("id_training"));
			insertMap.put("id_compose_training_type", components_id.get("id_type"));
			insertMap.put("id_compose_training_method", components_id.get("id_training_method"));
			insertMap.put("compose_training_layout", components_id.get("layout"));
		} catch (EmptyResultsQueryException e) {
			throw new InsertDataBaseException("no trainingcomponent associated");
		}
		
		try {
			insertMap.put("id_user", userDao.getUserId(user).toString());
		} catch(EmptyResultsQueryException e) {
			throw new InsertDataBaseException("no user associated");
		}
		
		try {
			List<Exercice> exercicesList = trainingComponent.getExerciceType().getExercicesList();
			if(exercicesList.size() != 1) {
				throw new InsertDataBaseException("multiple exercices are still in component");
			}
			for(Exercice exercice : exercicesList) {
				insertMap.put("id_exercice", exerciceDao.getExerciceId(exercice).toString());
			}
		} catch (EmptyResultsQueryException e) {
			throw new InsertDataBaseException("no exercice type associated");
		}
		this.update(this.getId(valuesMapGet.getMapOfValues(previousSerie)), insertMap);
	}

	@Override
	public void deleteSerie(Serie serie, TrainingComponent trainingComponent, Training training, User user) throws EmptyResultsQueryException, InsertDataBaseException {
		Map<String, String> valuesMap = new HashMap<>();
		try {
			valuesMap.put("id_serie", this.getSerieId(serie, trainingComponent, training, user).toString());
			this.delete(valuesMap);
		} catch (InsertDataBaseException e) {
			throw e;
		} catch (EmptyResultsQueryException e2) {
			throw e2;
		}		
	}

	@Override
	public List<Serie> getAllSeriesUser(User user) throws EmptyResultsQueryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Serie> getAllSeriesTraining(User user, Training training) throws EmptyResultsQueryException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
