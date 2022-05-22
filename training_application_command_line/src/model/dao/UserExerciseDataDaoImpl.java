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

import model.objects.Exercise;
import model.objects.User;
import model.objects.UserExerciseData;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class UserExerciseDataDaoImpl.
 *
 * @author Vincednt Mastain
 * @version 1.0
 */
public class UserExerciseDataDaoImpl extends BasicRequestsDao implements UserExerciseDataDao {

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
			UserExerciseData ued = (UserExerciseData) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String, String>();
			mapValues.put("id_exercise", ued.getIdExercise().toString());
			mapValues.put("id_user", ued.getIdUser().toString());
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
			UserExerciseData userExerciseData = (UserExerciseData) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String, String>();
			mapValues.put("weight", userExerciseData.getWeight().toString());
			mapValues.put("mark", userExerciseData.getMark().toString());
			mapValues.put("id_exercise", userExerciseData.getIdExercise().toString());
			mapValues.put("id_user", userExerciseData.getIdUser().toString());
			mapValues.put("nb_done", userExerciseData.getNbDone().toString());
			return mapValues;
		}
	}

	/** The singleton. */
	static UserExerciseDataDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the user exercise data dao impl
	 */
	public static synchronized UserExerciseDataDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			singleton = new UserExerciseDataDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new user exercise data dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private UserExerciseDataDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("UserExerciseData");
	}

	/**
	 * Adds the user exercise data.
	 *
	 * @param userExerciseData the user exercise data
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addUserExerciseData(UserExerciseData userExerciseData) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		Map<String, String> getMap = valuesMap.getMapOfValues(userExerciseData);
		this.add(getMap);
	}

	/**
	 * Delete user exercise data.
	 *
	 * @param userExerciseData the user exercise data
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteUserExerciseData(UserExerciseData userExerciseData) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(userExerciseData));
	}

	/**
	 * Gets the all user exercise data.
	 *
	 * @return the all user exercise data
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<UserExerciseData> getAllUserExerciseData() throws EmptyResultsQueryException {
		List<UserExerciseData> userExerciseDataList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for (Map<String, String> valueMap : results) {
			UserExerciseData userExerciseData = new UserExerciseData();
			this.objectConstructor(valueMap, userExerciseData);
			userExerciseDataList.add(userExerciseData);
		}
		return userExerciseDataList;
	}

	/**
	 * Gets the exercise user exercise data.
	 *
	 * @param exercise the exercise
	 * @param user     the user
	 * @return the exercise user exercise data
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void getExerciseUserExerciseData(Exercise exercise, User user) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;

		try {
			String sqlRequest;

			sqlRequest = "SELECT ued.* FROM UserExerciseData ued\n" + "WHERE ued.id_exercise = "
					+ exercise.getIdExercise() + "\n" + "AND ued.id_user = " + user.getIdUser() + ";";

			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			results = preparedStatement.executeQuery();

			if (results.next()) {
				UserExerciseData ued = new UserExerciseData();
				this.objectConstructor(this.setMapFromResultSet(results), ued);
				exercise.setUserExerciseDatas(ued);
			} else {
				throw new EmptyResultsQueryException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the first user exercise data.
	 *
	 * @return the first user exercise data
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public UserExerciseData getFirstUserExerciseData() throws EmptyResultsQueryException {
		UserExerciseData userExerciseData = new UserExerciseData();
		this.<UserExerciseData>getFirst(userExerciseData);
		return userExerciseData;
	}

	/**
	 * Gets the nb done exercise user.
	 *
	 * @param user the user
	 * @return the nb done exercise user
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public int getNbDoneExerciseUser(User user) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;

		try {
			String sqlRequest;

			sqlRequest = "SELECT sum(nb_done) total FROM UserExerciseData ued\n" + "WHERE id_user = " + user.getIdUser()
					+ ";";

			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			results = preparedStatement.executeQuery();

			if (results.next()) {
				return results.getInt("total");
			} else {
				throw new EmptyResultsQueryException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Gets the user exercise data.
	 *
	 * @param user     the user
	 * @param exercise the exercise
	 * @return the user exercise data
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public UserExerciseData getUserExerciseData(User user, Exercise exercise) throws EmptyResultsQueryException {
		UserExerciseData userExerciseData = new UserExerciseData();
		Map<String, String> values = new HashMap<>();
		values.put("id_exercise", exercise.getIdExercise().toString());
		values.put("id_user", user.getIdUser().toString());
		ArrayList<Map<String, String>> results = this.get(values);
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), userExerciseData);
		return userExerciseData;
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
		((UserExerciseData) dataBaseObject).setWeight(Double.parseDouble(mapValues.get("weight")));
		((UserExerciseData) dataBaseObject).setMark(Double.parseDouble(mapValues.get("mark")));
		((UserExerciseData) dataBaseObject).setIdExercise(Integer.parseInt(mapValues.get("id_exercise")));
		((UserExerciseData) dataBaseObject).setIdUser(Integer.parseInt(mapValues.get("id_user")));
		((UserExerciseData) dataBaseObject).setNbDone(Integer.parseInt(mapValues.get("nb_done")));
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
		valuesMap.put("weight", results.getString("weight"));
		valuesMap.put("mark", results.getString("mark"));
		valuesMap.put("id_exercise", results.getString("id_exercise"));
		valuesMap.put("id_user", results.getString("id_user"));
		valuesMap.put("nb_done", results.getString("nb_done"));
		return valuesMap;
	}

	/**
	 * Update user exercise data.
	 *
	 * @param userExerciseData the user exercise data
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void updateUserExerciseData(UserExerciseData userExerciseData)
			throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(userExerciseData), keysMap.getMapOfValues(userExerciseData));
	}

}
