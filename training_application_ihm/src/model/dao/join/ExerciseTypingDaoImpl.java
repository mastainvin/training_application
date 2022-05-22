/**
 *
 */
package model.dao.join;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dao.DaoFactory;
import model.objects.Exercise;
import model.objects.ExerciseType;
import model.objects.exceptions.EmptyResultsQueryException;


/**
 * The Class ExerciseTypingDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class ExerciseTypingDaoImpl extends JoinDao<ExerciseType, Exercise> implements ExerciseTypingDao {

	/** The singleton. */
	static private ExerciseTypingDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the exercise typing dao impl
	 */
	public static ExerciseTypingDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			singleton = new ExerciseTypingDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new exercise typing dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private ExerciseTypingDaoImpl(DaoFactory daoFactory) {
		super(daoFactory);
		this.setADbName("ExerciseType");
		this.setBDbName("Exercise");
		this.setAIdLabel("id_exerciseType");
		this.setBIdLabel("id_exercise");
		this.setDbName("ExerciseTyping");
	}

	/**
	 * Adds the compatible exercise.
	 *
	 * @param id_exerciseType the id exercise type
	 * @param id_exercise     the id exercise
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	@Override
	public void addCompatibleExercise(Integer id_exerciseType, Integer id_exercise)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.add(id_exerciseType, id_exercise);
	}

	/**
	 * Delete compatible exercise.
	 *
	 * @param id_exerciseType the id exercise type
	 * @param id_exercise     the id exercise
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	@Override
	public void deleteCompatibleExercise(Integer id_exerciseType, Integer id_exercise)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.delete(id_exerciseType, id_exercise);
	}

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_exerciseType the id exercise type
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Exercise> getDisponbilities(Integer id_exerciseType) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getBList(id_exerciseType);
		List<Exercise> disponibilities = new ArrayList<>();

		for (Map<String, String> value : values) {
			Exercise d = BObjectConstructor(value);
			disponibilities.add(d);
		}
		return disponibilities;
	}

	/**
	 * Gets the exercise types.
	 *
	 * @param id_exercise the id exercise
	 * @return the exercise types
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<ExerciseType> getExerciseTypes(Integer id_exercise) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getAList(id_exercise);
		List<ExerciseType> exerciseTypes = new ArrayList<>();

		for (Map<String, String> value : values) {
			ExerciseType s = AObjectConstructor(value);
			exerciseTypes.add(s);
		}
		return exerciseTypes;
	}

	/**
	 * A object constructor.
	 *
	 * @param valuesMap the values map
	 * @return the exercise type
	 */
	@Override
	ExerciseType AObjectConstructor(Map<String, String> valuesMap) {
		ExerciseType exerciseType = new ExerciseType();
		exerciseType.setName(valuesMap.get("name"));
		exerciseType.setDescription(valuesMap.get("description"));
		exerciseType.setIdExerciseType(Integer.parseInt(valuesMap.get("id_exercise_type")));
		return exerciseType;
	}

	/**
	 * B object constructor.
	 *
	 * @param valuesMap the values map
	 * @return the exercise
	 */
	@Override
	Exercise BObjectConstructor(Map<String, String> valuesMap) {
		Exercise exercise = new Exercise();
		exercise.setName(valuesMap.get("name"));
		exercise.setDescription(valuesMap.get("description"));
		exercise.setIdExercise(Integer.parseInt(valuesMap.get("id_exercise")));
		return exercise;
	}

	/**
	 * Sets the map from result set A.
	 *
	 * @param results the results
	 * @return the map
	 * @throws SQLException the SQL exception
	 */
	@Override
	Map<String, String> setMapFromResultSetA(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("description", results.getString("description"));
		valuesMap.put("id_exercise_type", results.getString("id_exercise_type"));
		return valuesMap;
	}

	/**
	 * Sets the map from result set B.
	 *
	 * @param results the results
	 * @return the map
	 * @throws SQLException the SQL exception
	 */
	@Override
	Map<String, String> setMapFromResultSetB(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("id_exercise", results.getString("id_exercise"));
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("description", results.getString("description"));
		return valuesMap;
	}

}
