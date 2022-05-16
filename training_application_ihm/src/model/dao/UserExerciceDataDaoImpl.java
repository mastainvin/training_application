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

import model.objects.Exercice;
import model.objects.User;
import model.objects.UserExerciceData;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class UserExerciceDataDaoImpl.
 *
 * @author Vincednt Mastain
 * @version 1.0
 */
public class UserExerciceDataDaoImpl extends BasicRequestsDao implements UserExerciceDataDao {

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
			UserExerciceData ued = (UserExerciceData) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String, String>();
			mapValues.put("id_exercice", ued.getIdExercice().toString());
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
			UserExerciceData userExerciceData = (UserExerciceData) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String, String>();
			mapValues.put("weight", userExerciceData.getWeight().toString());
			mapValues.put("mark", userExerciceData.getMark().toString());
			mapValues.put("id_exercice", userExerciceData.getIdExercice().toString());
			mapValues.put("id_user", userExerciceData.getIdUser().toString());
			mapValues.put("nb_done", userExerciceData.getNbDone().toString());
			return mapValues;
		}
	}

	/** The singleton. */
	static UserExerciceDataDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the user exercice data dao impl
	 */
	public static synchronized UserExerciceDataDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			singleton = new UserExerciceDataDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new user exercice data dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private UserExerciceDataDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("UserExerciceData");
	}

	/**
	 * Adds the user exercice data.
	 *
	 * @param userExerciceData the user exercice data
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addUserExerciceData(UserExerciceData userExerciceData) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		Map<String, String> getMap = valuesMap.getMapOfValues(userExerciceData);
		this.add(getMap);
	}

	/**
	 * Delete user exercice data.
	 *
	 * @param userExerciceData the user exercice data
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteUserExerciceData(UserExerciceData userExerciceData) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(userExerciceData));
	}

	/**
	 * Gets the all user exercice data.
	 *
	 * @return the all user exercice data
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<UserExerciceData> getAllUserExerciceData() throws EmptyResultsQueryException {
		List<UserExerciceData> userExerciceDataList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for (Map<String, String> valueMap : results) {
			UserExerciceData userExerciceData = new UserExerciceData();
			this.objectConstructor(valueMap, userExerciceData);
			userExerciceDataList.add(userExerciceData);
		}
		return userExerciceDataList;
	}

	/**
	 * Gets the exercice user exercice data.
	 *
	 * @param exercice the exercice
	 * @param user     the user
	 * @return the exercice user exercice data
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void getExerciceUserExerciceData(Exercice exercice, User user) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;

		try {
			String sqlRequest;

			sqlRequest = "SELECT ued.* FROM UserExerciceData ued\n" + "WHERE ued.id_exercice = "
					+ exercice.getIdExercice() + "\n" + "AND ued.id_user = " + user.getIdUser() + ";";

			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			results = preparedStatement.executeQuery();

			if (results.next()) {
				UserExerciceData ued = new UserExerciceData();
				this.objectConstructor(this.setMapFromResultSet(results), ued);
				exercice.setUserExerciceDatas(ued);
			} else {
				throw new EmptyResultsQueryException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the first user exercice data.
	 *
	 * @return the first user exercice data
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public UserExerciceData getFirstUserExerciceData() throws EmptyResultsQueryException {
		UserExerciceData userExerciceData = new UserExerciceData();
		this.<UserExerciceData>getFirst(userExerciceData);
		return userExerciceData;
	}

	/**
	 * Gets the nb done exercice user.
	 *
	 * @param user the user
	 * @return the nb done exercice user
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public int getNbDoneExerciceUser(User user) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;

		try {
			String sqlRequest;

			sqlRequest = "SELECT sum(nb_done) total FROM UserExerciceData ued\n" + "WHERE id_user = " + user.getIdUser()
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
	 * Gets the user exercice data.
	 *
	 * @param user     the user
	 * @param exercice the exercice
	 * @return the user exercice data
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public UserExerciceData getUserExerciceData(User user, Exercice exercice) throws EmptyResultsQueryException {
		UserExerciceData userExerciceData = new UserExerciceData();
		Map<String, String> values = new HashMap<>();
		values.put("id_exercice", exercice.getIdExercice().toString());
		values.put("id_user", user.getIdUser().toString());
		ArrayList<Map<String, String>> results = this.get(values);
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), userExerciceData);
		return userExerciceData;
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
		((UserExerciceData) dataBaseObject).setWeight(Double.parseDouble(mapValues.get("weight")));
		((UserExerciceData) dataBaseObject).setMark(Double.parseDouble(mapValues.get("mark")));
		((UserExerciceData) dataBaseObject).setIdExercice(Integer.parseInt(mapValues.get("id_exercice")));
		((UserExerciceData) dataBaseObject).setIdUser(Integer.parseInt(mapValues.get("id_user")));
		((UserExerciceData) dataBaseObject).setNbDone(Integer.parseInt(mapValues.get("nb_done")));
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
		valuesMap.put("id_exercice", results.getString("id_exercice"));
		valuesMap.put("id_user", results.getString("id_user"));
		valuesMap.put("nb_done", results.getString("nb_done"));
		return valuesMap;
	}

	/**
	 * Update user exercice data.
	 *
	 * @param userExerciceData the user exercice data
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void updateUserExerciceData(UserExerciceData userExerciceData)
			throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(userExerciceData), keysMap.getMapOfValues(userExerciceData));
	}

}
