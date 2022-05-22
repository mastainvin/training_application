/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.ExerciseType;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExerciseTypeDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface ExerciseTypeDao {

	/**
	 * Adds the exercise type.
	 *
	 * @param exerciseType the exercise type
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addExerciseType(ExerciseType exerciseType) throws InsertDataBaseException;

	/**
	 * Delete exercise type.
	 *
	 * @param exerciseType the exercise type
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteExerciseType(ExerciseType exerciseType) throws EmptyResultsQueryException;

	/**
	 * Gets the all exercise type.
	 *
	 * @return the all exercise type
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<ExerciseType> getAllExerciseType() throws EmptyResultsQueryException;

	/**
	 * Gets the exercise type by id.
	 *
	 * @param id_exerciseType the id exercise type
	 * @return the corresponding exerciseType
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	ExerciseType getExerciseTypeById(Integer id_exerciseType) throws EmptyResultsQueryException;

	/**
	 * Gets the exercise type by name.
	 *
	 * @param name of the goal
	 * @return the corresponding goal
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	ExerciseType getExerciseTypeByName(String name) throws EmptyResultsQueryException;

	/**
	 * Gets the first exercise type.
	 *
	 * @return the first exerciseType in the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	ExerciseType getFirstExerciseType() throws EmptyResultsQueryException;

	/**
	 * Update exercise type.
	 *
	 * @param exerciseType the exercise type
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void updateExerciseType(ExerciseType exerciseType) throws EmptyResultsQueryException, InsertDataBaseException;

}
