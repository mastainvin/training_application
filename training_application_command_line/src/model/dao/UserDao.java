/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;
import model.objects.exceptions.UserEmailTakenException;
import model.objects.exceptions.UserInsertException;
import model.objects.exceptions.UserPseudonymTakenException;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface UserDao {
	
	/**
	 * Gets the user by pseudonym.
	 *
	 * @param pseudonym user's pseudonym requested
	 * @return the user wanted
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	User getUserByPseudonym(String pseudonym) throws EmptyResultsQueryException;
	
	/**
	 * Gets the user by email.
	 *
	 * @param email user's email reqested
	 * @return the user wanted
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	User getUserByEmail(String email) throws EmptyResultsQueryException ;
	
	/**
	 * Gets the user by id.
	 *
	 * @param id_user user'is id requested
	 * @return the user wanted
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	User getUserById(Integer id_user) throws EmptyResultsQueryException;
	
	/**
	 * Authentificate.
	 *
	 * @param pseudonym user's pseudonym requested
	 * @param password user's password requested
	 * @return the user authenficate
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	User authentificate(String pseudonym, String password) throws EmptyResultsQueryException;
	
	/**
	 * Adds the user.
	 *
	 * @param user to add
	 * @throws UserInsertException the user insert exception
	 * @throws UserPseudonymTakenException the user pseudonym taken exception
	 * @throws UserEmailTakenException the user email taken exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addUser(User user) throws UserInsertException, UserPseudonymTakenException, UserEmailTakenException, InsertDataBaseException;
	
	/**
	 * Update user.
	 *
	 * @param user user to update
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	public void updateUser(User user) throws EmptyResultsQueryException, InsertDataBaseException;
	
	/**
	 * Delete user.
	 *
	 * @param user the user
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteUser(User user) throws EmptyResultsQueryException;
	
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
	

}
