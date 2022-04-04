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
public class UserExerciceDataDaoImpl extends BasicRequestsDao implements UserExerciceDataDao {

	private UserDao userDao;
	private ExerciceDao exerciceDao;
	
	static UserExerciceDataDaoImpl singleton = null;
	public static UserExerciceDataDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new UserExerciceDataDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private UserExerciceDataDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("UserExerciceData");
		this.setIdLabel("id_userExerciceData");
		this.userDao = daoFactory.getUserDao();
		this.exerciceDao = daoFactory.getExerciceDao();
	}
	
	@Override
	Map<String, String> setMapFromResultSet(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("weight", results.getString("weight"));
		valuesMap.put("mark", results.getString("mark"));

		return valuesMap;
	}
	
	public class MapOfValuesInsert implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			UserExerciceData userExerciceData = (UserExerciceData) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("weight", userExerciceData.getWeight().toString());
			mapValues.put("mark", userExerciceData.getMark().toString());

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
		((UserExerciceData) dataBaseObject).setWeight(Integer.parseInt(mapValues.get("weight")));
		((UserExerciceData) dataBaseObject).setMark(Integer.parseInt(mapValues.get("mark")));

	}
	
	
	@Override
	public List<UserExerciceData> getAllUserExerciceData() throws EmptyResultsQueryException {
		List<UserExerciceData> userExerciceDataList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			UserExerciceData userExerciceData = new UserExerciceData();
			this.objectConstructor(valueMap, userExerciceData);
			userExerciceDataList.add(userExerciceData);
		}
		return userExerciceDataList;
	}	

	@Override
	public UserExerciceData getFirstUserExerciceData() throws EmptyResultsQueryException {
		UserExerciceData userExerciceData = new UserExerciceData();
		this.<UserExerciceData>getFirst(userExerciceData);
		return userExerciceData;
	}

	@Override
	public UserExerciceData getUserExerciceData(User user, Exercice exercice) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		UserExerciceData userExerciceData = new UserExerciceData();
		Map<String, String> values = valuesMapGet.getMapOfValues(userExerciceData);
		values.put("id_exercice", this.exerciceDao.getExerciceId(exercice).toString());
		values.put("id_user", this.userDao.getUserId(user).toString());
		ArrayList<Map<String, String>> results = this.get(values);
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), userExerciceData);
		return userExerciceData;
	}
	
	
	
	@Override
	public void addUserExerciceData(UserExerciceData userExerciceData, User user, Exercice exercice) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		Map<String,String> getMap = valuesMap.getMapOfValues(userExerciceData);
		
		try {
			getMap.put("id_exercice", exerciceDao.getExerciceId(exercice).toString());
		} catch (EmptyResultsQueryException e) {
			getMap.put("id_exercice", "NULL");
		}
		
		try {
			getMap.put("id_user", userDao.getUserId(user).toString());
		} catch (EmptyResultsQueryException e) {
			getMap.put("id_user", "NULL");
		}
		
		this.add(getMap);
	}

	@Override
	public void updateUserExerciceData(UserExerciceData previousUserExerciceData, UserExerciceData newUserExerciceData, User user, Exercice exercice) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		Map<String,String> insertMap = valuesMapInsert.getMapOfValues(newUserExerciceData);
		
		try {
			insertMap.put("id_exercice", exerciceDao.getExerciceId(exercice).toString());
		} catch (EmptyResultsQueryException e) {
			insertMap.put("id_exercice", "NULL");
		}
		
		try {
			insertMap.put("id_user", userDao.getUserId(user).toString());
		} catch (EmptyResultsQueryException e) {
			insertMap.put("id_user", "NULL");
		}
		
		this.update(this.getId(valuesMapGet.getMapOfValues(previousUserExerciceData)), insertMap);
	}

	@Override
	public void deleteUserExerciceData(UserExerciceData userExerciceData) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(userExerciceData));
	}

	
}
