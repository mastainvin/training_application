/**
 * 
 */
package model.dao.join;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import model.objects.Disponibility;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;

// TODO: Auto-generated Javadoc
/**
 * The Interface CanTrainOnDao.
 *
 * @author Vincent Mastain
 */
public interface CanTrainOnDao {

	/**
	 * Adds the compatible disponibility.
	 *
	 * @param id_user          the id user
	 * @param id_disponibility the id disponibility
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void addCompatibleDisponibility(Integer id_user, Integer id_disponibility)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Delete compatible disponibility.
	 *
	 * @param id_user          the id user
	 * @param id_disponibility the id disponibility
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void deleteCompatibleDisponibility(Integer id_user, Integer id_disponibility)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_user the id user
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Disponibility> getDisponibilities(Integer id_user) throws EmptyResultsQueryException;

	/**
	 * Gets the users.
	 *
	 * @param id_disponibility the id disponibility
	 * @return the users
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<User> getUsers(Integer id_disponibility) throws EmptyResultsQueryException;
}
