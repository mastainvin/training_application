/**
 *
 */
package model.dao;

import java.util.List;

import model.objects.Training;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;


/**
 * The Interface TrainingDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface TrainingDao {

	/**
	 * Adds the training.
	 *
	 * @param training training wanted
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addTraining(Training training) throws InsertDataBaseException;

	/**
	 * Delete training.
	 *
	 * @param training training to delete
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteTraining(Training training) throws EmptyResultsQueryException;

	/**
	 * Gets the all training.
	 *
	 * @return the all training
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Training> getAllTraining() throws EmptyResultsQueryException;

	/**
	 * Gets the first training.
	 *
	 * @return Frist training of the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Training getFirstTraining() throws EmptyResultsQueryException;

	/**
	 * Gets the training by id.
	 *
	 * @param id_training id requested
	 * @return training which corresponds to the id param
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Training getTrainingById(Integer id_training) throws EmptyResultsQueryException;

	/**
	 * Gets the training by name.
	 *
	 * @param name name of the training
	 * @return training which corresponds to the name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Training getTrainingByName(String name) throws EmptyResultsQueryException;

	/**
	 * Gets the user structure.
	 *
	 * @param user the user
	 * @return the user structure
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void getUserStructure(User user) throws EmptyResultsQueryException;

	/**
	 * Update training.
	 *
	 * @param training the training
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void updateTraining(Training training) throws EmptyResultsQueryException, InsertDataBaseException;

}
