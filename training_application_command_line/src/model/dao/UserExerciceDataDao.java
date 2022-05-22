/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Exercice;
import model.objects.User;
import model.objects.UserExerciceData;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserExerciceDataDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface UserExerciceDataDao {

	/**
	 * Adds the user exercice data.
	 *
	 * @param userExerciceData userExerciceData wanted
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addUserExerciceData(UserExerciceData userExerciceData) throws InsertDataBaseException;

	/**
	 * Delete user exercice data.
	 *
	 * @param userExerciceData userExerciceData to delete
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteUserExerciceData(UserExerciceData userExerciceData) throws EmptyResultsQueryException;

	/**
	 * Gets the all user exercice data.
	 *
	 * @return the all user exercice data
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<UserExerciceData> getAllUserExerciceData() throws EmptyResultsQueryException;

	/**
	 * Gets the exercice user exercice data.
	 *
	 * @param exercice the exercice
	 * @param user     the user
	 * @return the exercice user exercice data
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void getExerciceUserExerciceData(Exercice exercice, User user) throws EmptyResultsQueryException;

	/**
	 * Gets the first user exercice data.
	 *
	 * @return Frist userExerciceData of the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	UserExerciceData getFirstUserExerciceData() throws EmptyResultsQueryException;

	/**
	 * Gets the nb done exercice user.
	 *
	 * @param user the user
	 * @return the nb done exercice user
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	int getNbDoneExerciceUser(User user) throws EmptyResultsQueryException;

	/**
	 * Gets the user exercice data.
	 *
	 * @param user     the user
	 * @param exercice the exercice
	 * @return userExerciceData which corresponds to the name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	UserExerciceData getUserExerciceData(User user, Exercice exercice) throws EmptyResultsQueryException;

	/**
	 * Update user exercice data.
	 *
	 * @param userExerciceData the user exercice data
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void updateUserExerciceData(UserExerciceData userExerciceData)
			throws EmptyResultsQueryException, InsertDataBaseException;
}
