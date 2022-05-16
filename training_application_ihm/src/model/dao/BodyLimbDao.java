/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.BodyLimb;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface BodyLimbDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface BodyLimbDao {

	/**
	 * Adds the body limb.
	 *
	 * @param bodyLimb body to add
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addBodyLimb(BodyLimb bodyLimb) throws InsertDataBaseException;

	/**
	 * Delete body limb.
	 *
	 * @param bodyLimb bodylib wanted to be delete
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteBodyLimb(BodyLimb bodyLimb) throws EmptyResultsQueryException;

	/**
	 * Gets the all body limb.
	 *
	 * @return the all body limb
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public List<BodyLimb> getAllBodyLimb() throws EmptyResultsQueryException;

	/**
	 * Gets the body limb by id.
	 *
	 * @param id_body_limb id of the wanted body limb
	 * @return the bodylimb requested
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	BodyLimb getBodyLimbById(Integer id_body_limb) throws EmptyResultsQueryException;

	/**
	 * Gets the body limb by name.
	 *
	 * @param name the name of the bodylimb
	 * @return the bodylimb requested
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	BodyLimb getBodyLimbByName(String name) throws EmptyResultsQueryException;

	/**
	 * Gets the first body limb.
	 *
	 * @return the first body limb
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public BodyLimb getFirstBodyLimb() throws EmptyResultsQueryException;

	/**
	 * Update body limb.
	 *
	 * @param bodyLimb the body limb
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void updateBodyLimb(BodyLimb bodyLimb) throws EmptyResultsQueryException, InsertDataBaseException;
}
