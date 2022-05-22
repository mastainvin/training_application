/**
 *
 */
package model.dao.join;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import model.objects.BiomecanicFunction;
import model.objects.Exercise;
import model.objects.exceptions.EmptyResultsQueryException;


/**
 * The Interface CompatibleBiomecanicFunctionDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface CompatibleBiomecanicFunctionDao {

	/**
	 * Adds the compatible exercise.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @param id_exercise           the id exercise
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void addCompatibleExercise(Integer id_biomecanicFunction, Integer id_exercise)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Delete compatible exercise.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @param id_exercise           the id exercise
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void deleteCompatibleExercise(Integer id_biomecanicFunction, Integer id_exercise)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Gets the biomecanic functions.
	 *
	 * @param id_exercise the id exercise
	 * @return the biomecanic functions
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<BiomecanicFunction> getBiomecanicFunctions(Integer id_exercise) throws EmptyResultsQueryException;

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Exercise> getDisponbilities(Integer id_biomecanicFunction) throws EmptyResultsQueryException;
}
