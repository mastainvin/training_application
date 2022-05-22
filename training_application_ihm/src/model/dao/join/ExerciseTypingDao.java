/**
 *
 */
package model.dao.join;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import model.objects.Exercise;
import model.objects.ExerciseType;
import model.objects.exceptions.EmptyResultsQueryException;


/**
 * The Interface ExerciseTypingDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface ExerciseTypingDao {

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
	void addCompatibleExercise(Integer id_exerciseType, Integer id_exercise)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

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
	void deleteCompatibleExercise(Integer id_exerciseType, Integer id_exercise)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_exerciseType the id exercise type
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Exercise> getDisponbilities(Integer id_exerciseType) throws EmptyResultsQueryException;

	/**
	 * Gets the exercise types.
	 *
	 * @param id_exercise the id exercise
	 * @return the exercise types
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<ExerciseType> getExerciseTypes(Integer id_exercise) throws EmptyResultsQueryException;
}
