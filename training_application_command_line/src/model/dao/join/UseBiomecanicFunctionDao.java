/**
 * 
 */
package model.dao.join;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import model.objects.BiomecanicFunctionList;
import model.objects.BiomecanicFunction;
import model.objects.exceptions.EmptyResultsQueryException;

// TODO: Auto-generated Javadoc
/**
 * The Interface UseBiomecanicFunctionDao.
 *
 * @author Vincent Mastain
 */
public interface UseBiomecanicFunctionDao {
	
	/**
	 * Gets the disponbilities.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<BiomecanicFunctionList> getDisponbilities(Integer id_biomecanicFunction) throws EmptyResultsQueryException;
	
	/**
	 * Gets the biomecanic functions.
	 *
	 * @param id_biomecanicFunctionList the id biomecanic function list
	 * @return the biomecanic functions
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<BiomecanicFunction> getBiomecanicFunctions(Integer id_biomecanicFunctionList) throws EmptyResultsQueryException;
	
	/**
	 * Adds the compatible biomecanic function list.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @param id_biomecanicFunctionList the id biomecanic function list
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	void addCompatibleBiomecanicFunctionList(Integer id_biomecanicFunction, Integer id_biomecanicFunctionList) throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;
	
	/**
	 * Delete compatible biomecanic function list.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @param id_biomecanicFunctionList the id biomecanic function list
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	void deleteCompatibleBiomecanicFunctionList(Integer id_biomecanicFunction, Integer id_biomecanicFunctionList) throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;
}
