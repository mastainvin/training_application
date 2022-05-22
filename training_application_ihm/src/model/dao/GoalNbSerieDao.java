/**
 *
 */
package model.dao;

import java.util.List;

import model.objects.GoalNbSerie;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;


/**
 * The Interface GoalNbSerieDao.
 *
 * @author Vincent Mastain$
 * @version 1.0
 */
public interface GoalNbSerieDao {

	/**
	 * Adds the goal nb serie.
	 *
	 * @param goalNbSerie the goal nb serie
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addGoalNbSerie(GoalNbSerie goalNbSerie) throws InsertDataBaseException;

	/**
	 * Delete goal nb serie.
	 *
	 * @param goalNbSerie the goal nb serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteGoalNbSerie(GoalNbSerie goalNbSerie) throws EmptyResultsQueryException;

	/**
	 * Gets the all goal nb serie.
	 *
	 * @return the all goal nb serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<GoalNbSerie> getAllGoalNbSerie() throws EmptyResultsQueryException;

	/**
	 * Gets the goal nb serie by id.
	 *
	 * @param id_goalNbSerie the id goal nb serie
	 * @return the corresponding goalNbSerie
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	GoalNbSerie getGoalNbSerieById(Integer id_goalNbSerie) throws EmptyResultsQueryException;

	/**
	 * Update goal nb serie.
	 *
	 * @param goalNbSerie the goal nb serie
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void updateGoalNbSerie(GoalNbSerieDao goalNbSerie) throws EmptyResultsQueryException, InsertDataBaseException;
}
