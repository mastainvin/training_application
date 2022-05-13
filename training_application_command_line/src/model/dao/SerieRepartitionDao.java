/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.SerieRepartition;
import model.objects.TrainingMethod;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface SerieRepartitionDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface SerieRepartitionDao {

	/**
	 * Adds the structure.
	 *
	 * @param structure structure wanted
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addSerieRepartition(SerieRepartition structure) throws InsertDataBaseException;

	/**
	 * Delete structure.
	 *
	 * @param structure structure to delete
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteSerieRepartition(SerieRepartition structure) throws EmptyResultsQueryException;

	/**
	 * Gets the all structure.
	 *
	 * @return the all structure
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public List<SerieRepartition> getAllSerieRepartition() throws EmptyResultsQueryException;

	/**
	 * Gets the first structure.
	 *
	 * @return Frist structure of the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	SerieRepartition getFirstSerieRepartition() throws EmptyResultsQueryException;

	/**
	 * Gets the serie reparition from training method.
	 *
	 * @param trainingMethod the training method
	 * @return the serie reparition from training method
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public void getSerieReparitionFromTrainingMethod(TrainingMethod trainingMethod) throws EmptyResultsQueryException;

	/**
	 * Gets the structure by id.
	 *
	 * @param id_structure id requested
	 * @return structure which corresponds to the id param
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	SerieRepartition getSerieRepartitionById(Integer id_structure) throws EmptyResultsQueryException;

	/**
	 * Gets the structure by name.
	 *
	 * @param name name of the structure
	 * @return structure which corresponds to the name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	SerieRepartition getSerieRepartitionByName(String name) throws EmptyResultsQueryException;

	/**
	 * Update structure.
	 *
	 * @param structure the structure
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void updateSerieRepartition(SerieRepartition structure) throws EmptyResultsQueryException, InsertDataBaseException;
}
