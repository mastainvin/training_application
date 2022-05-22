/**
 *
 */
package model.dao;

import java.util.List;

import model.objects.TrainingComponent;
import model.objects.TrainingMethod;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

/**
 * The Interface TrainingMethodDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface TrainingMethodDao {

	/**
	 * Gets the all training method.
	 *
	 * @return the all training method
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public List<TrainingMethod> getAllTrainingMethod() throws EmptyResultsQueryException;

	/**
	 * Adds the training method.
	 *
	 * @param trainingMethod trainingMethod wanted
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addTrainingMethod(TrainingMethod trainingMethod) throws InsertDataBaseException;

	/**
	 * Delete training method.
	 *
	 * @param trainingMethod trainingMethod to delete
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteTrainingMethod(TrainingMethod trainingMethod) throws EmptyResultsQueryException;

	/**
	 * Gets the first training method.
	 *
	 * @return Frist trainingMethod of the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	TrainingMethod getFirstTrainingMethod() throws EmptyResultsQueryException;

	/**
	 * Gets the training component training method.
	 *
	 * @param trainingComponent the training component
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void getTrainingComponentTrainingMethod(TrainingComponent trainingComponent) throws EmptyResultsQueryException;

	/**
	 * Gets the training method by id.
	 *
	 * @param id_trainingMethod id requested
	 * @return trainingMethod which corresponds to the id param
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	TrainingMethod getTrainingMethodById(Integer id_trainingMethod) throws EmptyResultsQueryException;

	/**
	 * Gets the training method by name.
	 *
	 * @param name name of the trainingMethod
	 * @return trainingMethod which corresponds to the name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	TrainingMethod getTrainingMethodByName(String name) throws EmptyResultsQueryException;

	/**
	 * Update training method.
	 *
	 * @param trainingMethod the training method
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void updateTrainingMethod(TrainingMethod trainingMethod) throws EmptyResultsQueryException, InsertDataBaseException;

}
