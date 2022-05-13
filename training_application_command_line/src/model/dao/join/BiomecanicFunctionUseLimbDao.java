/**
 * 
 */
package model.dao.join;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import model.objects.BiomecanicFunction;
import model.objects.BodyLimb;
import model.objects.exceptions.EmptyResultsQueryException;

// TODO: Auto-generated Javadoc
/**
 * The Interface BiomecanicFunctionUseLimbDao.
 *
 * @author Vincent Mastain
 */
public interface BiomecanicFunctionUseLimbDao {

	/**
	 * Adds the compatible body limb.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @param id_bodyLimb           the id body limb
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void addCompatibleBodyLimb(Integer id_biomecanicFunction, Integer id_bodyLimb)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Delete compatible body limb.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @param id_bodyLimb           the id body limb
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void deleteCompatibleBodyLimb(Integer id_biomecanicFunction, Integer id_bodyLimb)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Gets the biomecanic functions.
	 *
	 * @param id_bodyLimb the id body limb
	 * @return the biomecanic functions
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<BiomecanicFunction> getBiomecanicFunctions(Integer id_bodyLimb) throws EmptyResultsQueryException;

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<BodyLimb> getDisponbilities(Integer id_biomecanicFunction) throws EmptyResultsQueryException;
}
