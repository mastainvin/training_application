/**
 *
 */
package model.dao.join;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import model.objects.Exercise;
import model.objects.Morphology;
import model.objects.exceptions.EmptyResultsQueryException;


/**
 * The Interface CompatibleMorphDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface CompatibleMorphDao {

	/**
	 * Adds the compatible exercise.
	 *
	 * @param id_morphology the id morphology
	 * @param id_exercise   the id exercise
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void addCompatibleExercise(Integer id_morphology, Integer id_exercise)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Delete compatible exercise.
	 *
	 * @param id_morphology the id morphology
	 * @param id_exercise   the id exercise
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void deleteCompatibleExercise(Integer id_morphology, Integer id_exercise)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_morphology the id morphology
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Exercise> getDisponbilities(Integer id_morphology) throws EmptyResultsQueryException;

	/**
	 * Gets the morphologys.
	 *
	 * @param id_exercise the id exercise
	 * @return the morphologys
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Morphology> getMorphologys(Integer id_exercise) throws EmptyResultsQueryException;
}
