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
import java.util.List;
import java.util.Map;

import model.objects.Exercise;
import model.objects.Serie;
import model.objects.Training;
import model.objects.TrainingComponent;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class SerieDaoImpl.
 *
 * @author Vincednt Mastain
 * @version 1.0
 */
public class SerieDaoImpl extends BasicRequestsDao implements SerieDao {

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
			Serie serie = (Serie) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String, String>();
			mapValues.put(getIdLabel(), serie.getIdSerie().toString());
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
			Serie serie = (Serie) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String, String>();

			mapValues.put("weight", serie.getWeight().toString());
			mapValues.put("repetitions", serie.getRepetitions().toString());
			mapValues.put("expected_repetitions", serie.getExpectedRepetitions().toString());
			mapValues.put("expected_weight", serie.getExpectedWeight().toString());
			mapValues.put("rest_duration", serie.getRestDuration().toString());
			mapValues.put("layout", serie.getLayout().toString());
			mapValues.put("in_actual_week", Integer.valueOf(serie.getInActualWeek() ? 1 : 0).toString());

			if (serie.getDate() != null && serie.getDate() != "") {
				mapValues.put("date", serie.getDate());
			}

			try {
				mapValues.put("id_compose_training_training", serie.getIdComposeTrainingTraining().toString());
			} catch (NullPointerException e) {
			}
			try {
				mapValues.put("compose_training_layout", serie.getComposeTrainingLayout().toString());
			} catch (NullPointerException e) {
			}
			try {
				mapValues.put("id_compose_training_type", serie.getIdComposeTrainingType().toString());
			} catch (NullPointerException e) {
			}
			try {
				mapValues.put("id_compose_training_method", serie.getIdComposeTrainingMethod().toString());
			} catch (NullPointerException e) {
			}
			try {
				mapValues.put("id_user", serie.getIdUser().toString());
			} catch (NullPointerException e) {
			}
			try {
				mapValues.put("id_exercise", serie.getIdExercise().toString());
			} catch (NullPointerException e) {
			}

			return mapValues;
		}
	}

	/** The singleton. */
	static SerieDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the serie dao impl
	 */
	public static SerieDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			return new SerieDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new serie dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private SerieDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Serie");
		this.setIdLabel("id_serie");
	}

	/**
	 * Adds the serie.
	 *
	 * @param serie the serie
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addSerie(Serie serie) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		Map<String, String> getMap = valuesMap.getMapOfValues(serie);
		this.add(getMap);
	}

	/**
	 * Delete all week series.
	 *
	 * @param user the user
	 */
	@Override
	public void deleteAllWeekSeries(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			String sqlRequest;

			sqlRequest = "DELETE FROM Serie\n" + "WHERE id_user = " + user.getIdUser() + "\n "
					+ "AND in_actual_week = 1 " + "AND isNull(date); ";

			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete not done user serie.
	 *
	 * @param user the user
	 */
	@Override
	public void deleteNotDoneUserSerie(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			String sqlRequest;

			sqlRequest = "DELETE FROM Serie\n" + "WHERE id_user = " + user.getIdUser() + "\n" + "AND isNull(date)\n"
					+ "AND in_actual_week = 1;";

			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete serie.
	 *
	 * @param serie             the serie
	 * @param trainingComponent the training component
	 * @param training          the training
	 * @param user              the user
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void deleteSerie(Serie serie, TrainingComponent trainingComponent, Training training, User user)
			throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		Map<String, String> insertMap = valuesMapInsert.getMapOfValues(serie);
		this.delete(insertMap);

	}

	/**
	 * Finish all user series.
	 *
	 * @param user the user
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void finishAllUserSeries(User user) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			String sqlRequest = "UPDATE Serie SET in_actual_week = 0 WHERE id_user = '" + user.getIdUser() + "';";
			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new EmptyResultsQueryException();
		}
	}

	/**
	 * Finish user serie.
	 *
	 * @param serie the serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void finishUserSerie(Serie serie) throws EmptyResultsQueryException, InsertDataBaseException {
		serie.setDate(java.time.LocalDateTime.now().toString());
		this.updateSerie(serie);
	}

	/**
	 * Gets the all actual week serie.
	 *
	 * @param user the user
	 * @return the all actual week serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public List<Serie> getAllActualWeekSerie(User user) throws EmptyResultsQueryException, InsertDataBaseException {
		List<Serie> series = new ArrayList<>();

		Map<String, String> getMap = new HashMap<>();
		getMap.put("in_actual_week", "1");
		getMap.put("id_user", user.getIdUser().toString());
		for (Map<String, String> map : this.get(getMap)) {
			Serie serie = new Serie();
			this.objectConstructor(map, serie);
			series.add(serie);
		}
		return series;
	}

	/**
	 * Gets the all date training.
	 *
	 * @param user the user
	 * @return the all date training
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public List<String> getAllDateTraining(User user) throws EmptyResultsQueryException, InsertDataBaseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;
		List<String> dates = new ArrayList<>();
		try {
			String sqlRequest;
			sqlRequest = "SELECT date FROM Serie s\n" + "WHERE id_user = " + user.getIdUser() + "\n"
					+ "AND not isNull(date)\n" + "group by date;";

			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			results = preparedStatement.executeQuery();

			Boolean empty = true;

			while (results.next()) {
				dates.add(results.getString("date"));
				empty = false;
			}
			if (empty) {
				throw new EmptyResultsQueryException();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dates;
	}

	/**
	 * Gets the all serie.
	 *
	 * @return the all serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Serie> getAllSerie() throws EmptyResultsQueryException {
		List<Serie> serieList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for (Map<String, String> valueMap : results) {
			Serie serie = new Serie();
			this.objectConstructor(valueMap, serie);
			serieList.add(serie);
		}
		return serieList;
	}

	/**
	 * Gets the all series user.
	 *
	 * @param user the user
	 * @return the all series user
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public List<Serie> getAllSeriesUser(User user) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		List<Serie> series = new ArrayList<>();

		Map<String, String> getMap = valuesMapGet.getMapOfValues(null);

		getMap.put("id_user", user.getIdUser().toString());

		for (Map<String, String> map : this.get(getMap)) {
			Serie serie = new Serie();
			this.objectConstructor(map, serie);
			series.add(serie);
		}
		return series;
	}

	/**
	 * Gets the next trainings serie.
	 *
	 * @param user the user
	 * @return the next trainings serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public List<Serie> getNextTrainingsSerie(User user) throws EmptyResultsQueryException, InsertDataBaseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;
		List<Serie> series = new ArrayList<>();
		try {
			String sqlRequest;
			sqlRequest = "SELECT * FROM Serie\n" + "WHERE id_user = " + user.getIdUser() + "\n" + "AND isNull(date)\n"
					+ "AND in_actual_week = 1;";

			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			results = preparedStatement.executeQuery();

			Boolean empty = true;

			while (results.next()) {
				Serie serie = new Serie();
				this.objectConstructor(this.setMapFromResultSet(results), serie);
				series.add(serie);
				empty = false;
			}
			if (empty) {
				throw new EmptyResultsQueryException();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return series;
	}

	/**
	 * Gets the previous best series.
	 *
	 * @param user     the user
	 * @param exercise the exercise
	 * @return the previous best series
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public List<Serie> getPreviousBestSeries(User user, Exercise exercise)
			throws EmptyResultsQueryException, InsertDataBaseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;
		List<Serie> series = new ArrayList<>();
		try {
			String sqlRequest;
			sqlRequest = "SELECT s.* FROM Serie s\n" + "WHERE s.id_user = " + user.getIdUser() + "\n"
					+ "AND s.id_exercise = " + exercise.getIdExercise() + "\n" + "AND not isNull(s.date)\n"
					+ "AND repetitions * weight >= (SELECT max(s2.repetitions * s2.weight) \n"
					+ "							FROM Serie s2\n"
					+ "                            WHERE s2.id_user = s.id_user\n"
					+ "							AND s2.id_exercise = s.id_exercise\n"
					+ "							AND s2.date = s.date);";

			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			results = preparedStatement.executeQuery();

			Boolean empty = true;

			while (results.next()) {
				Serie serie = new Serie();
				this.objectConstructor(this.setMapFromResultSet(results), serie);
				series.add(serie);
				empty = false;
			}
			if (empty) {
				throw new EmptyResultsQueryException();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return series;
	}

	/**
	 * Gets the serie by id.
	 *
	 * @param id_serie the id serie
	 * @return the serie by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Serie getSerieById(Integer id_serie) throws EmptyResultsQueryException {
		Serie serie = new Serie();
		this.<Serie>getById(id_serie, serie);
		return serie;
	}

	/**
	 * Gets the with date serie.
	 *
	 * @param user the user
	 * @param date the date
	 * @return the with date serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public List<Serie> getWithDateSerie(User user, String date)
			throws EmptyResultsQueryException, InsertDataBaseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;
		List<Serie> series = new ArrayList<>();
		try {
			String sqlRequest;
			sqlRequest = "SELECT s.* FROM Serie s\n" + "WHERE s.id_user = " + user.getIdUser() + "\n" + "AND s.date = '"
					+ date + "';";

			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			results = preparedStatement.executeQuery();

			Boolean empty = true;

			while (results.next()) {
				Serie serie = new Serie();
				this.objectConstructor(this.setMapFromResultSet(results), serie);
				series.add(serie);
				empty = false;
			}
			if (empty) {
				throw new EmptyResultsQueryException();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return series;
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
		((Serie) dataBaseObject).setDate(mapValues.get("date"));
		((Serie) dataBaseObject).setWeight(Double.parseDouble(mapValues.get("weight")));
		((Serie) dataBaseObject).setRepetitions(Integer.parseInt(mapValues.get("repetitions")));
		((Serie) dataBaseObject).setRpe(Integer.parseInt(mapValues.get("rpe")));
		((Serie) dataBaseObject).setExpectedWeight(Integer.parseInt(mapValues.get("expected_weight")));
		((Serie) dataBaseObject).setRestDuration(Integer.parseInt(mapValues.get("rest_duration")));
		((Serie) dataBaseObject).setExpectedRepetitions(Integer.parseInt(mapValues.get("expected_repetitions")));
		((Serie) dataBaseObject).setLayout(Integer.parseInt(mapValues.get("layout")));
		((Serie) dataBaseObject).setIdSerie(Integer.parseInt(mapValues.get("id_serie")));

		if (Integer.parseInt(mapValues.get("in_actual_week")) == 1) {
			((Serie) dataBaseObject).setInActualWeek(true);
		} else {
			((Serie) dataBaseObject).setInActualWeek(false);
		}

		try {
			((Serie) dataBaseObject)
					.setIdComposeTrainingTraining(Integer.parseInt(mapValues.get("id_compose_training_training")));
		} catch (NumberFormatException e) {
		}

		try {
			((Serie) dataBaseObject)
					.setComposeTrainingLayout(Integer.parseInt(mapValues.get("compose_training_layout")));
		} catch (NumberFormatException e) {
		}

		try {
			((Serie) dataBaseObject)
					.setIdComposeTrainingType(Integer.parseInt(mapValues.get("id_compose_training_type")));
		} catch (NumberFormatException e) {
		}

		try {
			((Serie) dataBaseObject)
					.setIdComposeTrainingMethod(Integer.parseInt(mapValues.get("id_compose_training_method")));
		} catch (NumberFormatException e) {
		}

		try {
			((Serie) dataBaseObject).setIdExercise(Integer.parseInt(mapValues.get("id_exercise")));
		} catch (NumberFormatException e) {
		}

		try {
			((Serie) dataBaseObject).setIdUser(Integer.parseInt(mapValues.get("id_user")));
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
		valuesMap.put("id_serie", results.getString("id_serie"));
		valuesMap.put("date", results.getString("date"));
		valuesMap.put("weight", results.getString("weight"));
		valuesMap.put("repetitions", results.getString("repetitions"));
		valuesMap.put("rpe", results.getString("rpe"));
		valuesMap.put("expected_repetitions", results.getString("expected_repetitions"));
		valuesMap.put("expected_weight", results.getString("expected_weight"));
		valuesMap.put("rest_duration", results.getString("rest_duration"));
		valuesMap.put("id_compose_training_training", results.getString("id_compose_training_training"));
		valuesMap.put("id_user", results.getString("id_user"));
		valuesMap.put("id_exercise", results.getString("id_exercise"));
		valuesMap.put("compose_training_layout", results.getString("compose_training_layout"));
		valuesMap.put("id_compose_training_type", results.getString("id_compose_training_type"));
		valuesMap.put("id_compose_training_method", results.getString("id_compose_training_method"));
		valuesMap.put("layout", results.getString("layout"));
		valuesMap.put("in_actual_week", results.getString("in_actual_week"));
		return valuesMap;
	}

	/**
	 * Update serie.
	 *
	 * @param serie the serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void updateSerie(Serie serie) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		Map<String, String> insertMap = valuesMapInsert.getMapOfValues(serie);
		insertMap.put(getIdLabel(), serie.getIdSerie().toString());
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(insertMap, keysMap.getMapOfValues(serie));
	}

}
