/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Training;
import model.objects.TrainingComponent;
import model.objects.User;
import model.objects.Serie;

import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface SerieDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface SerieDao {
	

	/**
	 * Gets the serie by id.
	 *
	 * @param id_serie id requested
	 * @return serie which corresponds to the id param
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Serie getSerieById(Integer id_serie) throws EmptyResultsQueryException;
	
	/**
	 * Gets the all series user.
	 *
	 * @param user the user
	 * @return the all series user
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	List<Serie> getAllSeriesUser(User user) throws EmptyResultsQueryException, InsertDataBaseException;
	
	/**
	 * Gets the all actual week serie.
	 *
	 * @param user the user
	 * @return the all actual week serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	List<Serie> getAllActualWeekSerie(User user) throws EmptyResultsQueryException, InsertDataBaseException;
	
	/**
	 * Adds the serie.
	 *
	 * @param serie serie wanted
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addSerie(Serie serie) throws InsertDataBaseException;
	
	/**
	 * Update serie.
	 *
	 * @param serie the serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void updateSerie(Serie serie) throws EmptyResultsQueryException, InsertDataBaseException;
	
	/**
	 * Delete serie.
	 *
	 * @param serie serie to delete
	 * @param trainingComponent the training component
	 * @param training the training
	 * @param user the user
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void deleteSerie(Serie serie, TrainingComponent trainingComponent, Training training, User user) throws EmptyResultsQueryException, InsertDataBaseException;
	
	/**
	 * Gets the all serie.
	 *
	 * @return the all serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Serie> getAllSerie() throws EmptyResultsQueryException;
	
	/**
	 * Finish all user series.
	 *
	 * @param user the user
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void finishAllUserSeries(User user) throws EmptyResultsQueryException;
	
	/**
	 * Finish user serie.
	 *
	 * @param serie the serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void finishUserSerie(Serie serie) throws EmptyResultsQueryException, InsertDataBaseException;
	
}
