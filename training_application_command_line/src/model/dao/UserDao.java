/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.UserEmailTakenException;
import model.objects.exceptions.UserInsertException;
import model.objects.exceptions.UserPseudonymTakenException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public interface UserDao {
	
	/**
	 * 
	 * @param pseudonym user's pseudonym requested
	 * @return the user wanted
	 * @throws EmptyResultsQueryException
	 */
	User getUserByPseudonym(String pseudonym) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param email user's email reqested
	 * @return the user wanted
	 * @throws EmptyResultsQueryException
	 */
	User getUserByEmail(String email) throws EmptyResultsQueryException ;
	
	/**
	 * 
	 * @param id_user user'is id requested
	 * @return the user wanted
	 * @throws EmptyResultsQueryException
	 */
	User getUserById(Integer id_user) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param pseudonym user's pseudonym requested
	 * @param password user's password requested
	 * @return the user authenficate
	 * @throws EmptyResultsQueryException
	 */
	User authentificate(String pseudonym, String password) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param user to add
	 * @throws UserInsertException
	 * @throws UserPseudonymTakenException
	 * @throws UserEmailTakenException
	 */
	void addUser(User user) throws UserInsertException, UserPseudonymTakenException, UserEmailTakenException;
	
	/**
	 * 
	 * @param user user to update
	 * @throws UserInsertException
	 */
	public void updateUser(User previousUser, User newUser) throws EmptyResultsQueryException;
	void deleteUser(User user) throws EmptyResultsQueryException;
	public List<User> getAllUser() throws EmptyResultsQueryException;
	public User getFirstUser() throws EmptyResultsQueryException;
	Integer getUserId(User user) throws EmptyResultsQueryException;
}
