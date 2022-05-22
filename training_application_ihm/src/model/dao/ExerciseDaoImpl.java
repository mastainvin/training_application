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
import model.objects.TrainingComponent;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

/**
 * The Class ExerciseDaoImpl.
 *
 * @author Vincednt Mastain
 * @version 1.0
 */
public class ExerciseDaoImpl extends BasicRequestsDao implements ExerciseDao {

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
			Exercise exercise = (Exercise) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("id_exercise", exercise.getIdExercise().toString());
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
			Exercise exercise = (Exercise) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("id_exercise", exercise.getIdExercise().toString());
			mapValues.put("name", exercise.getName());
			mapValues.put("description", exercise.getDescription());
			return mapValues;
		}
	}

	/** The singleton. */
	private static ExerciseDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the exercise dao impl
	 */
	public static ExerciseDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			singleton = new ExerciseDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new exercise dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private ExerciseDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Exercise");
		this.setIdLabel("id_exercise");
	}

	/**
	 * Adds the exercise.
	 *
	 * @param exercise the exercise
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addExercise(Exercise exercise) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(exercise));
	}

	/**
	 * Delete exercise.
	 *
	 * @param exercise the exercise
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteExercise(Exercise exercise) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(exercise));
	}

	/**
	 * Gets the all exercise.
	 *
	 * @return the all exercise
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Exercise> getAllExercise() throws EmptyResultsQueryException {
		List<Exercise> exerciseList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for (Map<String, String> valueMap : results) {
			Exercise exercise = new Exercise();
			this.objectConstructor(valueMap, exercise);
			exerciseList.add(exercise);
		}
		return exerciseList;
	}

	/**
	 * Gets the exercise by id.
	 *
	 * @param id_exercise the id exercise
	 * @return the exercise by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Exercise getExerciseById(Integer id_exercise) throws EmptyResultsQueryException {
		Exercise exercise = new Exercise();
		this.<Exercise>getById(id_exercise, exercise);
		return exercise;
	}

	/**
	 * Gets the exercise by name.
	 *
	 * @param name the name
	 * @return the exercise by name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Exercise getExerciseByName(String name) throws EmptyResultsQueryException {
		Map<String, String> getMap = new HashMap<>();
		getMap.put("name", name);

		ArrayList<Map<String, String>> results = this.get(getMap);
		Iterator<Map<String, String>> iterator = results.iterator();

		Exercise exercise = new Exercise();
		this.objectConstructor(iterator.next(), exercise);
		return exercise;
	}

	/**
	 * Gets the first exercise.
	 *
	 * @return the first exercise
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Exercise getFirstExercise() throws EmptyResultsQueryException {
		Exercise exercise = new Exercise();
		this.<Exercise>getFirst(exercise);
		return exercise;
	}

	/**
	 * Gets the training component exercise list.
	 *
	 * @param trainingComponent the training component
	 * @param user              the user
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void getTrainingComponentExerciseList(TrainingComponent trainingComponent, User user)
			throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;

		try {
			String sqlRequest;

			sqlRequest = "SELECT e.* FROM Exercise e, ExerciseType et, ExerciseTyping etg, CompatibleEquipment ce\n"
					+ "WHERE e.id_exercise = etg.id_exercise\n" + "AND et.id_exercise_type = etg.id_exercise_type\n"
					+ "AND et.id_exercise_type = " + trainingComponent.getIdExerciseType() + "\n"
					+ "AND ce.id_exercise = e.id_exercise\n"
					+ "AND ce.id_equipment in (SELECT eq.id_equipment FROM HasEquipment he, Equipment eq\n"
					+ "    WHERE he.id_equipment = eq.id_equipment\n" + "    AND he.id_user = " + user.getIdUser()
					+ ")\n" + "GROUP BY e.id_exercise;";

			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			results = preparedStatement.executeQuery();

			boolean empty = true;
			List<Exercise> exerciseList = new ArrayList<>();
			while (results.next()) {
				Exercise exercise = new Exercise();
				this.objectConstructor(this.setMapFromResultSet(results), exercise);
				exerciseList.add(exercise);
				empty = false;
			}

			if (empty) {
				throw new EmptyResultsQueryException();
			}
			trainingComponent.setExercisesList(exerciseList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update exercise.
	 *
	 * @param exercise the exercise
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void updateExercise(Exercise exercise) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(exercise), keysMap.getMapOfValues(exercise));
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
		((Exercise) dataBaseObject).setName(mapValues.get("name"));
		((Exercise) dataBaseObject).setDescription(mapValues.get("description"));
		((Exercise) dataBaseObject).setIdExercise(Integer.parseInt(mapValues.get("id_exercise")));
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
		valuesMap.put("id_exercise", results.getString("id_exercise"));
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("description", results.getString("description"));
		return valuesMap;
	}

}
