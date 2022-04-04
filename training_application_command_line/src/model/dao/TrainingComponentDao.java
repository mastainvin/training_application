/**
 * 
 */
package model.dao;

import java.util.List;
import java.util.Map;

import model.objects.ExerciceType;
import model.objects.Training;
import model.objects.TrainingComponent;
import model.objects.TrainingMethod;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public interface TrainingComponentDao {
	
	/**
	 * 
	 * @return Frist trainingComponent of the db
	 * @throws EmptyResultsQueryException
	 */
	TrainingComponent getFirstTrainingComponent() throws EmptyResultsQueryException;
	
	TrainingComponent getTrainingComponent(TrainingMethod trainingMethod, ExerciceType exerciceType, Training training, Integer layout) throws EmptyResultsQueryException;
	
	Map<String, String> getTrainingComponentId(TrainingComponent trainingComponent, Training training) throws EmptyResultsQueryException;
	/**
	 * 
	 * @param trainingComponent trainingComponent wanted
	 */
	void addTrainingComponent(TrainingComponent trainingComponent, Training training);
	
	/**
	 * 
	 * @param previousTrainingComponent trainingComponent to change
	 * @param newTrainingComponent trainingComponent used to make the change
	 * @throws EmptyResultsQueryException
	 */
	void updateTrainingComponent(TrainingComponent previousTrainingComponent, TrainingComponent newTrainingComponent, Training training) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param trainingComponent trainingComponent to delete
	 * @throws EmptyResultsQueryException 
	 */
	void deleteTrainingComponent(TrainingComponent trainingComponent, Training training) throws EmptyResultsQueryException;
	
	List<TrainingComponent> getAllTrainingComponent() throws EmptyResultsQueryException;
	
	
	List<TrainingComponent> getTrainingsComponentsListFromTraining(Training training) throws EmptyResultsQueryException;

	
}
