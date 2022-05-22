/**
 *
 */
package model.dao;

import java.util.List;

import model.objects.BiomecanicFunctionList;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

/**
 * The Interface BiomecanicFunctionListDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface BiomecanicFunctionListDao {

	/**
	 * Adds the biomecanic function list.
	 *
	 * @param biomecanicFunctionList the biomecanic function list
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addBiomecanicFunctionList(BiomecanicFunctionList biomecanicFunctionList) throws InsertDataBaseException;

	/**
	 * Delete biomecanic function list.
	 *
	 * @param biomecanicFunctionList the biomecanic function list
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteBiomecanicFunctionList(BiomecanicFunctionList biomecanicFunctionList) throws EmptyResultsQueryException;

	/**
	 * Gets the all biomecanic function list.
	 *
	 * @return the all biomecanic function list
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<BiomecanicFunctionList> getAllBiomecanicFunctionList() throws EmptyResultsQueryException;

	/**
	 * Gets the biomecanic function list by id.
	 *
	 * @param id_biomecanicFunctionList the id biomecanic function list
	 * @return the corresponding biomecanicFunctionList
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	BiomecanicFunctionList getBiomecanicFunctionListById(Integer id_biomecanicFunctionList)
			throws EmptyResultsQueryException;

	/**
	 * Gets the first biomecanic function list.
	 *
	 * @return the first biomecanicFunctionList in the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	BiomecanicFunctionList getFirstBiomecanicFunctionList() throws EmptyResultsQueryException;

	/**
	 * Update biomecanic function list.
	 *
	 * @param bioMecanicFunction the bio mecanic function
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void updateBiomecanicFunctionList(BiomecanicFunctionList bioMecanicFunction)
			throws EmptyResultsQueryException, InsertDataBaseException;

}
