/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Exercise;
import model.objects.TrainingComponent;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExerciseDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface ExerciseDao {

	/**
	 * Adds the exercise.
	 *
	 * @param exercise exercise wanted
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addExercise(Exercise exercise) throws InsertDataBaseException;

	/**
	 * Delete exercise.
	 *
	 * @param exercise exercise to delete
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteExercise(Exercise exercise) throws EmptyResultsQueryException;

	/**
	 * Gets the all exercise.
	 *
	 * @return the all exercise
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public List<Exercise> getAllExercise() throws EmptyResultsQueryException;

	/**
	 * Gets the exercise by id.
	 *
	 * @param id_exercise id requested
	 * @return exercise which corresponds to the id param
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Exercise getExerciseById(Integer id_exercise) throws EmptyResultsQueryException;

	/**
	 * Gets the exercise by name.
	 *
	 * @param name name of the exercise
	 * @return exercise which corresponds to the name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Exercise getExerciseByName(String name) throws EmptyResultsQueryException;

	/**
	 * Gets the first exercise.
	 *
	 * @return Frist exercise of the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Exercise getFirstExercise() throws EmptyResultsQueryException;

	/**
	 * Gets the training component exercise list.
	 *
	 * @param trainingComponent the training component
	 * @param user              the user
	 * @return the training component exercise list
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void getTrainingComponentExerciseList(TrainingComponent trainingComponent, User user)
			throws EmptyResultsQueryException;

	/**
	 * Update exercise.
	 *
	 * @param exercise the exercise
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void updateExercise(Exercise exercise) throws EmptyResultsQueryException, InsertDataBaseException;

}
