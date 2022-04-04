/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.TrainingMethod;

import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public interface TrainingMethodDao {
	
	/**
	 * 
	 * @return Frist trainingMethod of the db
	 * @throws EmptyResultsQueryException
	 */
	TrainingMethod getFirstTrainingMethod() throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param name  name of the trainingMethod
	 * @return trainingMethod which corresponds to the name
	 * @throws EmptyResultsQueryException
	 */
	TrainingMethod getTrainingMethodByName(String name) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param id_trainingMethod id requested
	 * @return trainingMethod which corresponds to the id param
	 * @throws EmptyResultsQueryException
	 */
	TrainingMethod getTrainingMethodById(Integer id_trainingMethod) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param trainingMethod which we want the id
	 * @return trainingMethod id corresponding
	 * @throws EmptyResultsQueryException
	 */
	Integer getTrainingMethodId(TrainingMethod trainingMethod) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param trainingMethod trainingMethod wanted
	 */
	void addTrainingMethod(TrainingMethod trainingMethod);
	
	/**
	 * 
	 * @param previousTrainingMethod trainingMethod to change
	 * @param newTrainingMethod trainingMethod used to make the change
	 * @throws EmptyResultsQueryException
	 */
	void updateTrainingMethod(TrainingMethod previousTrainingMethod, TrainingMethod newTrainingMethod) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param trainingMethod trainingMethod to delete
	 * @throws EmptyResultsQueryException 
	 */
	void deleteTrainingMethod(TrainingMethod trainingMethod) throws EmptyResultsQueryException;
	
	public List<TrainingMethod> getAllTrainingMethod() throws EmptyResultsQueryException;
}
