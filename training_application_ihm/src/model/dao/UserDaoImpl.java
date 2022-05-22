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
import model.objects.exceptions.InsertDataBaseException;


/**
 * The Class UserDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class UserDaoImpl extends BasicRequestsDao implements UserDao {

	/**
	 * The Class MapOfValuesGet.
	 */
	public class MapOfValuesGet implements ValuesMap {

		/**
		 * Gets the map of values.
		 *
		 * @param <DataBaseObject> the generic type
		 * @param dataBaseObject   the data base object
		 * @return the map of values
		 */
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			User user = (User) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("id_user", user.getIdUser().toString());
			return mapValues;
		}
	}

	/**
	 * The Class MapOfValuesGetByAuthenfication.
	 */
	public class MapOfValuesGetByAuthenfication implements ValuesMap {

		/**
		 * Gets the map of values.
		 *
		 * @param <DataBaseObject> the generic type
		 * @param dataBaseObject   the data base object
		 * @return the map of values
		 */
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			User user = (User) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("pseudonym", user.getPseudonym());
			mapValues.put("password", user.getPassword());
			return mapValues;
		}
	}

	/**
	 * The Class MapOfValuesGetByEmail.
	 */
	public class MapOfValuesGetByEmail implements ValuesMap {

		/**
		 * Gets the map of values.
		 *
		 * @param <DataBaseObject> the generic type
		 * @param dataBaseObject   the data base object
		 * @return the map of values
		 */
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			User user = (User) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("email", user.getEmail());
			return mapValues;
		}
	}

	/**
	 * The Class MapOfValuesGetByPseudonym.
	 */
	public class MapOfValuesGetByPseudonym implements ValuesMap {

		/**
		 * Gets the map of values.
		 *
		 * @param <DataBaseObject> the generic type
		 * @param dataBaseObject   the data base object
		 * @return the map of values
		 */
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			User user = (User) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("pseudonym", user.getPseudonym());
			return mapValues;
		}
	}

	/**
	 * The Class MapOfValuesInsert.
	 */
	public class MapOfValuesInsert implements ValuesMap {

		/**
		 * Gets the map of values.
		 *
		 * @param <DataBaseObject> the generic type
		 * @param dataBaseObject   the data base object
		 * @return the map of values
		 */
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			User user = (User) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("pseudonym", user.getPseudonym());
			mapValues.put("password", user.getPassword());
			mapValues.put("email", user.getEmail());
			mapValues.put("size", user.getSize().toString());
			mapValues.put("weight", user.getWeight().toString());
			mapValues.put("gender", user.getGender().toString());
			mapValues.put("body_fat", user.getBodyFat().toString());
			mapValues.put("muscle_mass", user.getMuscleMass().toString());

			try {
				mapValues.put("id_role", user.getIdRole().toString());
			} catch (NullPointerException e) {
			}

			try {
				mapValues.put("id_morphology", user.getIdMorphology().toString());
			} catch (NullPointerException e) {
			}

			try {
				mapValues.put("id_goal", user.getIdGoal().toString());
			} catch (NullPointerException e) {
			}

			try {
				mapValues.put("id_user", user.getIdUser().toString());
			} catch (NullPointerException e) {
			}

			return mapValues;
		}
	}

	/** The singleton. */
	static UserDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the user dao impl
	 */
	public static UserDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			return new UserDaoImpl(daoFactory);
		}
		return singleton;
	}

	/** The goal dao. */
	private GoalDao goalDao;

	/** The morphology dao. */
	private MorphologyDao morphologyDao;

	/** The role dao. */
	private RoleDao roleDao;

	/**
	 * Instantiates a new user dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private UserDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("User");
		this.setIdLabel("id_user");

		this.setRoleDao(daoFactory.getRoleDao());
		this.setMorphologyDao(daoFactory.getMorphologyDao());
		this.setGoalDao(daoFactory.getGoalDao());
	}

	/**
	 * Adds the user.
	 *
	 * @param user the user
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addUser(User user) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(user));
	}

	/**
	 * Authentificate.
	 *
	 * @param pseudonym the pseudonym
	 * @param password  the password
	 * @return the user
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
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

	/**
	 * Delete user.
	 *
	 * @param user the user
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteUser(User user) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGetByPseudonym();
		this.delete(valuesMap.getMapOfValues(user));
	}

	/**
	 * Gets the all user.
	 *
	 * @return the all user
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<User> getAllUser() throws EmptyResultsQueryException {
		List<User> userList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for (Map<String, String> valueMap : results) {
			User user = new User();
			this.objectConstructor(valueMap, user);
			userList.add(user);
		}
		return userList;
	}

	/**
	 * Gets the first user.
	 *
	 * @return the first user
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public User getFirstUser() throws EmptyResultsQueryException {
		User user = new User();
		this.<User>getFirst(user);
		return user;
	}

	/**
	 * Gets the goal dao.
	 *
	 * @return the goal dao
	 */
	public GoalDao getGoalDao() {
		return goalDao;
	}

	/**
	 * Gets the morphology dao.
	 *
	 * @return the morphology dao
	 */
	public MorphologyDao getMorphologyDao() {
		return morphologyDao;
	}

	/**
	 * Gets the role dao.
	 *
	 * @return the role dao
	 */
	public RoleDao getRoleDao() {
		return roleDao;
	}

	/**
	 * Gets the user by email.
	 *
	 * @param email the email
	 * @return the user by email
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
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

	/**
	 * Gets the user by id.
	 *
	 * @param id_user the id user
	 * @return the user by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public User getUserById(Integer id_user) throws EmptyResultsQueryException {
		User user = new User();
		this.<User>getById(id_user, user);
		return user;
	}

	/**
	 * Gets the user by pseudonym.
	 *
	 * @param pseudonym the pseudonym
	 * @return the user by pseudonym
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
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

	/**
	 * Sets the goal dao.
	 *
	 * @param goalDao the new goal dao
	 */
	public void setGoalDao(GoalDao goalDao) {
		this.goalDao = goalDao;
	}

	/**
	 * Sets the morphology dao.
	 *
	 * @param morphologyDao the new morphology dao
	 */
	public void setMorphologyDao(MorphologyDao morphologyDao) {
		this.morphologyDao = morphologyDao;
	}

	/**
	 * Sets the role dao.
	 *
	 * @param roleDao the new role dao
	 */
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/**
	 * Update user.
	 *
	 * @param user the user
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void updateUser(User user) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(user), keysMap.getMapOfValues(user));
	}

	/**
	 * Object constructor.
	 *
	 * @param <DataBaseObject> the generic type
	 * @param mapValues        the map values
	 * @param dataBaseObject   the data base object
	 */
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
		((User) dataBaseObject).setIdUser(Integer.parseInt(mapValues.get("id_user")));

		try {
			((User) dataBaseObject).setIdRole(Integer.parseInt(mapValues.get("id_role")));
		} catch (NumberFormatException e) {
		}

		try {
			((User) dataBaseObject).setIdMorphology(Integer.parseInt(mapValues.get("id_morphology")));
		} catch (NumberFormatException e) {
		}

		try {
			((User) dataBaseObject).setIdGoal(Integer.parseInt(mapValues.get("id_goal")));
		} catch (NumberFormatException e) {
		}

	}

	/**
	 * Sets the map from result set.
	 *
	 * @param results the results
	 * @return the map
	 * @throws SQLException the SQL exception
	 */
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
		valuesMap.put("id_user", results.getString("id_user"));
		return valuesMap;
	}

}
