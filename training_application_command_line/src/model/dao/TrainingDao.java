/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Structure;
import model.objects.Training;

import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public interface TrainingDao {
	
	/**
	 * 
	 * @return Frist training of the db
	 * @throws EmptyResultsQueryException
	 */
	Training getFirstTraining() throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param name  name of the training
	 * @return training which corresponds to the name
	 * @throws EmptyResultsQueryException
	 */
	Training getTrainingByName(String name) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param id_training id requested
	 * @return training which corresponds to the id param
	 * @throws EmptyResultsQueryException
	 */
	Training getTrainingById(Integer id_training) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param training which we want the id
	 * @return training id corresponding
	 * @throws EmptyResultsQueryException
	 */
	Integer getTrainingId(Training training) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param training training wanted
	 */
	void addTraining(Training training, Structure motherStructure);
	
	/**
	 * 
	 * @param previousTraining training to change
	 * @param newTraining training used to make the change
	 * @throws EmptyResultsQueryException
	 */
	void updateTraining(Training previousTraining, Training newTraining, Structure motherStructure) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param training training to delete
	 * @throws EmptyResultsQueryException 
	 */
	void deleteTraining(Training training) throws EmptyResultsQueryException;
	
	List<Training> getAllTraining() throws EmptyResultsQueryException;
	
	List<Training> getTrainingsListFromStructure(Structure structure) throws EmptyResultsQueryException;
	
}
