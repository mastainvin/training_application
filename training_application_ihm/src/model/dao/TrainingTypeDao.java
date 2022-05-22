/**
 *
 */
package model.dao;

import java.util.List;

import model.objects.TrainingType;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

/**
 * The Interface TrainingTypeDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface TrainingTypeDao {

	/**
	 * Gets the all training type.
	 *
	 * @return the all training type
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public List<TrainingType> getAllTrainingType() throws EmptyResultsQueryException;

	/**
	 * Adds the training type.
	 *
	 * @param trainingType trainingType wanted
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addTrainingType(TrainingType trainingType) throws InsertDataBaseException;

	/**
	 * Delete training type.
	 *
	 * @param trainingType trainingType to delete
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteTrainingType(TrainingType trainingType) throws EmptyResultsQueryException;

	/**
	 * Gets the first training type.
	 *
	 * @return Frist trainingType of the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	TrainingType getFirstTrainingType() throws EmptyResultsQueryException;

	/**
	 * Gets the training type by id.
	 *
	 * @param id_trainingType id requested
	 * @return trainingType which corresponds to the id param
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	TrainingType getTrainingTypeById(Integer id_trainingType) throws EmptyResultsQueryException;

	/**
	 * Gets the training type by name.
	 *
	 * @param name name of the trainingType
	 * @return trainingType which corresponds to the name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	TrainingType getTrainingTypeByName(String name) throws EmptyResultsQueryException;

	/**
	 * Update training type.
	 *
	 * @param trainingType the training type
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void updateTrainingType(TrainingType trainingType) throws EmptyResultsQueryException, InsertDataBaseException;
}
