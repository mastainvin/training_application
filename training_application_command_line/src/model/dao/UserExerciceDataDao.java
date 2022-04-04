/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Exercice;
import model.objects.User;
import model.objects.UserExerciceData;

import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public interface UserExerciceDataDao {
	
	/**
	 * 
	 * @return Frist userExerciceData of the db
	 * @throws EmptyResultsQueryException
	 */
	UserExerciceData getFirstUserExerciceData() throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param name  name of the userExerciceData
	 * @return userExerciceData which corresponds to the name
	 * @throws EmptyResultsQueryException
	 */
	UserExerciceData getUserExerciceData(User user, Exercice exercice) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param userExerciceData userExerciceData wanted
	 */
	void addUserExerciceData(UserExerciceData userExerciceData, User user, Exercice exercice);
	
	/**
	 * 
	 * @param previousUserExerciceData userExerciceData to change
	 * @param newUserExerciceData userExerciceData used to make the change
	 * @throws EmptyResultsQueryException
	 */
	void updateUserExerciceData(UserExerciceData previousUserExerciceData, UserExerciceData newUserExerciceData, User user, Exercice exercice) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param userExerciceData userExerciceData to delete
	 * @throws EmptyResultsQueryException 
	 */
	void deleteUserExerciceData(UserExerciceData userExerciceData) throws EmptyResultsQueryException;
	
	List<UserExerciceData> getAllUserExerciceData() throws EmptyResultsQueryException;
	

	
}
