/**
 *
 */
package model.dao;

import java.util.List;

import model.objects.Training;
import model.objects.TrainingComponent;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;


/**
 * The Interface TrainingComponentDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface TrainingComponentDao {

	/**
	 * Adds the training component.
	 *
	 * @param trainingComponent trainingComponent wanted
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addTrainingComponent(TrainingComponent trainingComponent) throws InsertDataBaseException;

	/**
	 * Delete training component.
	 *
	 * @param trainingComponent trainingComponent to delete
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteTrainingComponent(TrainingComponent trainingComponent) throws EmptyResultsQueryException;

	/**
	 * Gets the all training component.
	 *
	 * @return the all training component
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<TrainingComponent> getAllTrainingComponent() throws EmptyResultsQueryException;

	/**
	 * Gets the first training component.
	 *
	 * @return Frist trainingComponent of the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	TrainingComponent getFirstTrainingComponent() throws EmptyResultsQueryException;

	/**
	 * Gets the training component.
	 *
	 * @param training the training
	 * @param layout   the layout
	 * @return the training component
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	TrainingComponent getTrainingComponent(Training training, Integer layout) throws EmptyResultsQueryException;

	/**
	 * Gets the training component done list.
	 *
	 * @param user the user
	 * @return the training component done list
	 */
	List<TrainingComponent> getTrainingComponentDoneList(User user);

	/**
	 * Gets the training training component list.
	 *
	 * @param training the training
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void getTrainingTrainingComponentList(Training training) throws EmptyResultsQueryException;

	/**
	 * Update training component.
	 *
	 * @param trainingComponent the training component
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void updateTrainingComponent(TrainingComponent trainingComponent)
			throws EmptyResultsQueryException, InsertDataBaseException;

}
