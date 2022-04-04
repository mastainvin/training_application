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

import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public class UserDaoImpl extends BasicRequestsDao implements UserDao {
	private RoleDao roleDao;
	private MorphologyDao morphologyDao;
	private GoalDao goalDao;
	
	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public MorphologyDao getMorphologyDao() {
		return morphologyDao;
	}

	public void setMorphologyDao(MorphologyDao morphologyDao) {
		this.morphologyDao = morphologyDao;
	}

	public GoalDao getGoalDao() {
		return goalDao;
	}

	public void setGoalDao(GoalDao goalDao) {
		this.goalDao = goalDao;
	}
	
	static UserDaoImpl singleton = null;
	public static UserDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new UserDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	

	private UserDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("User");
		this.setIdLabel("id_user");
		
		this.setRoleDao(daoFactory.getRoleDao());
		this.setMorphologyDao(daoFactory.getMorphologyDao());
		this.setGoalDao(daoFactory.getGoalDao());
	}
	
	@Override
	Map<String, String> setMapFromResultSet(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("pseudonym", results.getString("pseudonym"));
		valuesMap.put("password", results.getString("password"));
		valuesMap.put("email", results.getString("email"));
		valuesMap.put("size", results.getString("size"));
		valuesMap.put("weight", results.getString("weight"));
		valuesMap.put("gender", results.getString("gender"));
		valuesMap.put("body_fat", results.getString("body_fat"));
		valuesMap.put("muscle_mass", results.getString("muscle_mass"));
		valuesMap.put("id_role", results.getString("id_role"));
		valuesMap.put("id_morphology", results.getString("id_morphology"));
		valuesMap.put("id_goal", results.getString("id_goal"));
		return valuesMap;
	}
	
	public class MapOfValuesInsert implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			User user = (User) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("pseudonym", user.getPseudonym());
			mapValues.put("password", user.getPassword());
			mapValues.put("email", user.getEmail());
			mapValues.put("size", user.getSize().toString());
			mapValues.put("weight", user.getWeight().toString());
			mapValues.put("gender", user.getGender().toString());
			mapValues.put("body_fat", user.getBodyFat().toString());
			mapValues.put("muscle_mass", user.getMuscleMass().toString());
			
			try {
				mapValues.put("id_role", roleDao.getRoleId(user.getRole()).toString());
			} catch (EmptyResultsQueryException e) {
				mapValues.put("id_role", "NULL");
			}
			
			try {
				mapValues.put("id_morphology", morphologyDao.getMorphologyId(user.getMorphology()).toString());
			} catch (EmptyResultsQueryException e) {
				mapValues.put("id_morphology", "NULL");
			}
			
			try {
				mapValues.put("id_goal", goalDao.getGoalId(user.getGoal()).toString());
			} catch (EmptyResultsQueryException e) {
				mapValues.put("id_goal", "NULL");
			}
			
			return mapValues;
		}
	}
	
	
	public class MapOfValuesGetByPseudonym implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			User user = (User) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("pseudonym", user.getPseudonym());
			return mapValues;
		}	
	}
	
	public class MapOfValuesGetByEmail implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			User user = (User) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("email", user.getEmail());
			return mapValues;
		}	
	}
	
	public class MapOfValuesGetByAuthenfication implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			User user = (User) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("pseudonym", user.getPseudonym());
			mapValues.put("password", user.getPassword());
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((User) dataBaseObject).setPseudonym(mapValues.get("pseudonym"));
		((User) dataBaseObject).setPassword(mapValues.get("password"));
		((User) dataBaseObject).setEmail(mapValues.get("email"));
		((User) dataBaseObject).setSize(Integer.parseInt(mapValues.get("size")));
		((User) dataBaseObject).setWeight(Integer.parseInt(mapValues.get("weight")));
		((User) dataBaseObject).setGender(mapValues.get("gender"));
		((User) dataBaseObject).setBodyFat(Integer.parseInt(mapValues.get("body_fat")));
		((User) dataBaseObject).setMuscleMass(Integer.parseInt(mapValues.get("muscle_mass")));
		
		try {
			((User) dataBaseObject).setRole(roleDao.getRoleById(Integer.valueOf(mapValues.get("id_role"))));
		} catch (EmptyResultsQueryException e) {
		}
		
		try {
			((User) dataBaseObject).setMorphology(morphologyDao.getMorphologyById(Integer.valueOf(mapValues.get("id_morphology"))));
		} catch (EmptyResultsQueryException e) {
		}
        
		try {
			((User) dataBaseObject).setGoal(goalDao.getGoalById(Integer.valueOf(mapValues.get("id_goal"))));
		} catch (EmptyResultsQueryException e) {
		}
		
	}
	
	
	@Override
	public List<User> getAllUser() throws EmptyResultsQueryException {
		List<User> userList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			User user = new User();
			this.objectConstructor(valueMap, user);
			userList.add(user);
		}
		return userList;
	}	

	@Override
	public User getFirstUser() throws EmptyResultsQueryException {
		User user = new User();
		this.<User>getFirst(user);
		return user;
	}

	@Override
	public User authentificate(String pseudonym, String password) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGetByAuthenfication();
		User user = new User();
		user.setPseudonym(pseudonym);
		user.setPasswordEncrypted(password);
		ArrayList<Map<String, String>> results = this.get(valuesMapGet.getMapOfValues(user));
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), user);
		return user;
	}
	
	@Override
	public User getUserByPseudonym(String pseudonym) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGetByPseudonym();
		User user = new User();
		user.setPseudonym(pseudonym);
		ArrayList<Map<String, String>> results = this.get(valuesMapGet.getMapOfValues(user));
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), user);
		return user;
	}
	
	@Override
	public User getUserByEmail(String email) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGetByEmail();
		User user = new User();
		user.setEmail(email);
		ArrayList<Map<String, String>> results = this.get(valuesMapGet.getMapOfValues(user));
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), user);
		return user;
	}

	
	@Override
	public User getUserById(Integer id_user) throws EmptyResultsQueryException {
		User user = new User();
		this.<User>getById(id_user, user);
		return user;
	}
	
	@Override
	public Integer getUserId(User user) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGetByPseudonym();
		return this.getId(valuesMapGet.getMapOfValues(user));
	}
	
	@Override
	public void addUser(User user) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(user));
	}

	@Override
	public void updateUser(User previousUser, User newUser) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGetByPseudonym();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		this.update(this.getId(valuesMapGet.getMapOfValues(previousUser)), valuesMapInsert.getMapOfValues(newUser));
	}

	@Override
	public void deleteUser(User user) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGetByPseudonym();
		this.delete(valuesMap.getMapOfValues(user));
	}
}
