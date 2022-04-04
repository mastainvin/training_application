/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.TrainingType;

import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public interface TrainingTypeDao {
	
	/**
	 * 
	 * @return Frist trainingType of the db
	 * @throws EmptyResultsQueryException
	 */
	TrainingType getFirstTrainingType() throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param name  name of the trainingType
	 * @return trainingType which corresponds to the name
	 * @throws EmptyResultsQueryException
	 */
	TrainingType getTrainingTypeByName(String name) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param id_trainingType id requested
	 * @return trainingType which corresponds to the id param
	 * @throws EmptyResultsQueryException
	 */
	TrainingType getTrainingTypeById(Integer id_trainingType) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param trainingType which we want the id
	 * @return trainingType id corresponding
	 * @throws EmptyResultsQueryException
	 */
	Integer getTrainingTypeId(TrainingType trainingType) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param trainingType trainingType wanted
	 */
	void addTrainingType(TrainingType trainingType);
	
	/**
	 * 
	 * @param previousTrainingType trainingType to change
	 * @param newTrainingType trainingType used to make the change
	 * @throws EmptyResultsQueryException
	 */
	void updateTrainingType(TrainingType previousTrainingType, TrainingType newTrainingType) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param trainingType trainingType to delete
	 * @throws EmptyResultsQueryException 
	 */
	void deleteTrainingType(TrainingType trainingType) throws EmptyResultsQueryException;
	
	public List<TrainingType> getAllTrainingType() throws EmptyResultsQueryException;
}
