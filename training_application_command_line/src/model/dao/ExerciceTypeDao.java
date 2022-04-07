/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.ExerciceType;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExerciceTypeDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface ExerciceTypeDao {
	
	/**
	 * Gets the all exercice type.
	 *
	 * @return the all exercice type
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<ExerciceType> getAllExerciceType() throws EmptyResultsQueryException;
	
	/**
	 * Gets the first exercice type.
	 *
	 * @return the first exerciceType in the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	ExerciceType getFirstExerciceType() throws EmptyResultsQueryException;
	
	/**
	 * Gets the exercice type by name.
	 *
	 * @param name of the goal
	 * @return the corresponding goal
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	ExerciceType getExerciceTypeByName(String name) throws EmptyResultsQueryException;
	
	/**
	 * Gets the exercice type by id.
	 *
	 * @param id_exerciceType the id exercice type
	 * @return the corresponding exerciceType
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	ExerciceType getExerciceTypeById(Integer id_exerciceType) throws EmptyResultsQueryException;
	
	/**
	 * Adds the exercice type.
	 *
	 * @param exerciceType the exercice type
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addExerciceType(ExerciceType exerciceType) throws InsertDataBaseException;
	
	/**
	 * Update exercice type.
	 *
	 * @param exerciceType the exercice type
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void updateExerciceType(ExerciceType exerciceType) throws EmptyResultsQueryException, InsertDataBaseException;
	
	/**
	 * Delete exercice type.
	 *
	 * @param exerciceType the exercice type
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteExerciceType(ExerciceType exerciceType) throws EmptyResultsQueryException;
	
}
