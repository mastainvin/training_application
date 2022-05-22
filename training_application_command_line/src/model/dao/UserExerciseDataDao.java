/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Exercise;
import model.objects.User;
import model.objects.UserExerciseData;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserExerciseDataDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface UserExerciseDataDao {

	/**
	 * Adds the user exercise data.
	 *
	 * @param userExerciseData userExerciseData wanted
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addUserExerciseData(UserExerciseData userExerciseData) throws InsertDataBaseException;

	/**
	 * Delete user exercise data.
	 *
	 * @param userExerciseData userExerciseData to delete
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteUserExerciseData(UserExerciseData userExerciseData) throws EmptyResultsQueryException;

	/**
	 * Gets the all user exercise data.
	 *
	 * @return the all user exercise data
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<UserExerciseData> getAllUserExerciseData() throws EmptyResultsQueryException;

	/**
	 * Gets the exercise user exercise data.
	 *
	 * @param exercise the exercise
	 * @param user     the user
	 * @return the exercise user exercise data
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void getExerciseUserExerciseData(Exercise exercise, User user) throws EmptyResultsQueryException;

	/**
	 * Gets the first user exercise data.
	 *
	 * @return Frist userExerciseData of the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	UserExerciseData getFirstUserExerciseData() throws EmptyResultsQueryException;

	/**
	 * Gets the nb done exercise user.
	 *
	 * @param user the user
	 * @return the nb done exercise user
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	int getNbDoneExerciseUser(User user) throws EmptyResultsQueryException;

	/**
	 * Gets the user exercise data.
	 *
	 * @param user     the user
	 * @param exercise the exercise
	 * @return userExerciseData which corresponds to the name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	UserExerciseData getUserExerciseData(User user, Exercise exercise) throws EmptyResultsQueryException;

	/**
	 * Update user exercise data.
	 *
	 * @param userExerciseData the user exercise data
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void updateUserExerciseData(UserExerciseData userExerciseData)
			throws EmptyResultsQueryException, InsertDataBaseException;
}
