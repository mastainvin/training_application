/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.ExerciceType;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 *
 */
public interface ExerciceTypeDao {
	
	List<ExerciceType> getAllExerciceType() throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @return the first exerciceType in the db
	 * @throws EmptyResultsQueryException
	 */
	ExerciceType getFirstExerciceType() throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param name of the goal
	 * @return the corresponding goal
	 * @throws EmptyResultsQueryException
	 */
	ExerciceType getExerciceTypeByName(String name) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param id_exerciceType
	 * @return the corresponding exerciceType
	 * @throws EmptyResultsQueryException
	 */
	ExerciceType getExerciceTypeById(Integer id_exerciceType) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param exerciceType which we want the id
	 * @return the exerciceType's id
	 * @throws EmptyResultsQueryException
	 */
	Integer getExerciceTypeId(ExerciceType exerciceType) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param exerciceType
	 */
	void addExerciceType(ExerciceType exerciceType);
	
	/**
	 * 
	 * @param previousExerciceType
	 * @param newExerciceType
	 * @throws EmptyResultsQueryException
	 */
	void updateExerciceType(ExerciceType previousExerciceType, ExerciceType newExerciceType) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param exerciceType
	 * @throws EmptyResultsQueryException 
	 */
	void deleteExerciceType(ExerciceType exerciceType) throws EmptyResultsQueryException;
	
}
