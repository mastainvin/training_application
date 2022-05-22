/**
 *
 */
package model.dao.join;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import model.objects.BiomecanicFunction;
import model.objects.BiomecanicFunctionList;
import model.objects.exceptions.EmptyResultsQueryException;


/**
 * The Interface UseBiomecanicFunctionDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface UseBiomecanicFunctionDao {

	/**
	 * Adds the compatible biomecanic function list.
	 *
	 * @param id_biomecanicFunction     the id biomecanic function
	 * @param id_biomecanicFunctionList the id biomecanic function list
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void addCompatibleBiomecanicFunctionList(Integer id_biomecanicFunction, Integer id_biomecanicFunctionList)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Delete compatible biomecanic function list.
	 *
	 * @param id_biomecanicFunction     the id biomecanic function
	 * @param id_biomecanicFunctionList the id biomecanic function list
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void deleteCompatibleBiomecanicFunctionList(Integer id_biomecanicFunction, Integer id_biomecanicFunctionList)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Gets the biomecanic functions.
	 *
	 * @param id_biomecanicFunctionList the id biomecanic function list
	 * @return the biomecanic functions
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<BiomecanicFunction> getBiomecanicFunctions(Integer id_biomecanicFunctionList)
			throws EmptyResultsQueryException;

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<BiomecanicFunctionList> getDisponbilities(Integer id_biomecanicFunction) throws EmptyResultsQueryException;
}
