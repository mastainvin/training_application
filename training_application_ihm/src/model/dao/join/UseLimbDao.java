/**
 *
 */
package model.dao.join;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import model.objects.BodyLimb;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * The Interface UseLimbDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface UseLimbDao {

	/**
	 * Adds the compatible body limb.
	 *
	 * @param id_user     the id user
	 * @param id_bodyLimb the id body limb
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void addCompatibleBodyLimb(Integer id_user, Integer id_bodyLimb)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Delete compatible body limb.
	 *
	 * @param id_user     the id user
	 * @param id_bodyLimb the id body limb
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void deleteCompatibleBodyLimb(Integer id_user, Integer id_bodyLimb)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_user the id user
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<BodyLimb> getDisponbilities(Integer id_user) throws EmptyResultsQueryException;

	/**
	 * Gets the users.
	 *
	 * @param id_bodyLimb the id body limb
	 * @return the users
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<User> getUsers(Integer id_bodyLimb) throws EmptyResultsQueryException;
}
