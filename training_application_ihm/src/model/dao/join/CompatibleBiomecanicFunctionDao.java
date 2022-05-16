/**
 * 
 */
package model.dao.join;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import model.objects.BiomecanicFunction;
import model.objects.Exercice;
import model.objects.exceptions.EmptyResultsQueryException;

// TODO: Auto-generated Javadoc
/**
 * The Interface CompatibleBiomecanicFunctionDao.
 *
 * @author Vincent Mastain
 */
public interface CompatibleBiomecanicFunctionDao {

	/**
	 * Adds the compatible exercice.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @param id_exercice           the id exercice
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void addCompatibleExercice(Integer id_biomecanicFunction, Integer id_exercice)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Delete compatible exercice.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @param id_exercice           the id exercice
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void deleteCompatibleExercice(Integer id_biomecanicFunction, Integer id_exercice)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Gets the biomecanic functions.
	 *
	 * @param id_exercice the id exercice
	 * @return the biomecanic functions
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<BiomecanicFunction> getBiomecanicFunctions(Integer id_exercice) throws EmptyResultsQueryException;

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Exercice> getDisponbilities(Integer id_biomecanicFunction) throws EmptyResultsQueryException;
}
