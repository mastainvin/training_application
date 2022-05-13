/**
 * 
 */
package model.dao.join;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import model.objects.Exercice;
import model.objects.Morphology;
import model.objects.exceptions.EmptyResultsQueryException;

// TODO: Auto-generated Javadoc
/**
 * The Interface CompatibleMorphDao.
 *
 * @author Vincent Mastain
 */
public interface CompatibleMorphDao {

	/**
	 * Adds the compatible exercice.
	 *
	 * @param id_morphology the id morphology
	 * @param id_exercice   the id exercice
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void addCompatibleExercice(Integer id_morphology, Integer id_exercice)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Delete compatible exercice.
	 *
	 * @param id_morphology the id morphology
	 * @param id_exercice   the id exercice
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void deleteCompatibleExercice(Integer id_morphology, Integer id_exercice)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_morphology the id morphology
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Exercice> getDisponbilities(Integer id_morphology) throws EmptyResultsQueryException;

	/**
	 * Gets the morphologys.
	 *
	 * @param id_exercice the id exercice
	 * @return the morphologys
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Morphology> getMorphologys(Integer id_exercice) throws EmptyResultsQueryException;
}
