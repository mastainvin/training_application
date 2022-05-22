/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Exercise;
import model.objects.Serie;
import model.objects.Training;
import model.objects.TrainingComponent;
import model.objects.User;
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
	 * Adds the serie.
	 *
	 * @param serie serie wanted
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addSerie(Serie serie) throws InsertDataBaseException;

	/**
	 * Delete all week series.
	 *
	 * @param user the user
	 */
	void deleteAllWeekSeries(User user);

	/**
	 * Delete not done user serie.
	 *
	 * @param user the user
	 */
	void deleteNotDoneUserSerie(User user);

	/**
	 * Delete serie.
	 *
	 * @param serie             serie to delete
	 * @param trainingComponent the training component
	 * @param training          the training
	 * @param user              the user
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void deleteSerie(Serie serie, TrainingComponent trainingComponent, Training training, User user)
			throws EmptyResultsQueryException, InsertDataBaseException;

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
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void finishUserSerie(Serie serie) throws EmptyResultsQueryException, InsertDataBaseException;

	/**
	 * Gets the all actual week serie.
	 *
	 * @param user the user
	 * @return the all actual week serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	List<Serie> getAllActualWeekSerie(User user) throws EmptyResultsQueryException, InsertDataBaseException;

	/**
	 * Gets the all date training.
	 *
	 * @param user the user
	 * @return the all date training
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	List<String> getAllDateTraining(User user) throws EmptyResultsQueryException, InsertDataBaseException;

	/**
	 * Gets the all serie.
	 *
	 * @return the all serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Serie> getAllSerie() throws EmptyResultsQueryException;

	/**
	 * Gets the all series user.
	 *
	 * @param user the user
	 * @return the all series user
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	List<Serie> getAllSeriesUser(User user) throws EmptyResultsQueryException, InsertDataBaseException;

	/**
	 * Gets the next trainings serie.
	 *
	 * @param user the user
	 * @return the next trainings serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	List<Serie> getNextTrainingsSerie(User user) throws EmptyResultsQueryException, InsertDataBaseException;

	/**
	 * Gets the previous best series.
	 *
	 * @param user     the user
	 * @param exercise the exercise
	 * @return the previous best series
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	List<Serie> getPreviousBestSeries(User user, Exercise exercise)
			throws EmptyResultsQueryException, InsertDataBaseException;

	/**
	 * Gets the serie by id.
	 *
	 * @param id_serie id requested
	 * @return serie which corresponds to the id param
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Serie getSerieById(Integer id_serie) throws EmptyResultsQueryException;

	/**
	 * Gets the with date serie.
	 *
	 * @param user the user
	 * @param date the date
	 * @return the with date serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	List<Serie> getWithDateSerie(User user, String date) throws EmptyResultsQueryException, InsertDataBaseException;

	/**
	 * Update serie.
	 *
	 * @param serie the serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void updateSerie(Serie serie) throws EmptyResultsQueryException, InsertDataBaseException;
}
