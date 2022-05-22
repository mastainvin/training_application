/**
 *
 */
package model.dao;

import java.util.List;

import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;


/**
 * The Interface UserDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface UserDao {

	/**
	 * Gets the all user.
	 *
	 * @return the all user
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public List<User> getAllUser() throws EmptyResultsQueryException;

	/**
	 * Gets the first user.
	 *
	 * @return the first user
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public User getFirstUser() throws EmptyResultsQueryException;

	/**
	 * Update user.
	 *
	 * @param user user to update
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	public void updateUser(User user) throws EmptyResultsQueryException, InsertDataBaseException;

	/**
	 * Adds the user.
	 *
	 * @param user to add
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addUser(User user) throws InsertDataBaseException;

	/**
	 * Authentificate.
	 *
	 * @param pseudonym user's pseudonym requested
	 * @param password  user's password requested
	 * @return the user authenficate
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	User authentificate(String pseudonym, String password) throws EmptyResultsQueryException;

	/**
	 * Delete user.
	 *
	 * @param user the user
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteUser(User user) throws EmptyResultsQueryException;

	/**
	 * Gets the user by email.
	 *
	 * @param email user's email reqested
	 * @return the user wanted
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	User getUserByEmail(String email) throws EmptyResultsQueryException;

	/**
	 * Gets the user by id.
	 *
	 * @param id_user user'is id requested
	 * @return the user wanted
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	User getUserById(Integer id_user) throws EmptyResultsQueryException;

	/**
	 * Gets the user by pseudonym.
	 *
	 * @param pseudonym user's pseudonym requested
	 * @return the user wanted
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	User getUserByPseudonym(String pseudonym) throws EmptyResultsQueryException;

}
