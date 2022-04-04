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

import model.objects.Exercice;
import model.objects.User;
import model.objects.UserExerciceData;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincednt Mastain
 * @version 1.0
 */
public class ExerciceDaoImpl extends BasicRequestsDao implements ExerciceDao {
	private UserExerciceDataDao userExerciceDataDao;
	
	static ExerciceDaoImpl singleton = null;
	public static ExerciceDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new ExerciceDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private ExerciceDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Exercice");
		this.setIdLabel("id_exercice");
		this.userExerciceDataDao = daoFactory.getUserExerciceDataDao();
	}
	
	@Override
	Map<String, String> setMapFromResultSet(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("description", results.getString("description"));
		return valuesMap;
	}
	
	public class MapOfValuesInsert implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Exercice exercice = (Exercice) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", exercice.getName());
			mapValues.put("description", exercice.getDescription());
			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Exercice exercice = (Exercice) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", exercice.getName());
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((Exercice) dataBaseObject).setName(mapValues.get("name"));
		((Exercice) dataBaseObject).setDescription(mapValues.get("description"));

	}
	
	
	@Override
	public List<Exercice> getAllExercice() throws EmptyResultsQueryException {
		List<Exercice> exerciceList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			Exercice exercice = new Exercice();
			this.objectConstructor(valueMap, exercice);
			exerciceList.add(exercice);
		}
		return exerciceList;
	}	

	@Override
	public Exercice getFirstExercice() throws EmptyResultsQueryException {
		Exercice exercice = new Exercice();
		this.<Exercice>getFirst(exercice);
		return exercice;
	}

	@Override
	public Exercice getExerciceByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		Exercice exercice = new Exercice();
		exercice.setName(name);
		ArrayList<Map<String, String>> results = this.get(valuesMapGet.getMapOfValues(exercice));
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), exercice);
		return exercice;
	}
	
	@Override
	public Exercice getExerciceById(Integer id_exercice) throws EmptyResultsQueryException {
		Exercice exercice = new Exercice();
		this.<Exercice>getById(id_exercice, exercice);
		return exercice;
	}
	
	@Override
	public Integer getExerciceId(Exercice exercice) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		return this.getId(valuesMapGet.getMapOfValues(exercice));
	}
	
	@Override
	public void addExercice(Exercice exercice) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(exercice));
	}

	@Override
	public void updateExercice(Exercice previousExercice, Exercice newExercice) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		this.update(this.getId(valuesMapGet.getMapOfValues(previousExercice)), valuesMapInsert.getMapOfValues(newExercice));
	}

	@Override
	public void deleteExercice(Exercice exercice) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(exercice));
	}

	@Override
	public void getUserExerciceData(Exercice exercice, User user) {
		try {
			exercice.setUserExerciceDatas(userExerciceDataDao.getUserExerciceData(user, exercice));
		} catch (EmptyResultsQueryException e) {
			UserExerciceData userExerciceDataDefault = new UserExerciceData();
			userExerciceDataDefault.setMark(5);
			userExerciceDataDefault.setWeight(0);
		}
	}

}
