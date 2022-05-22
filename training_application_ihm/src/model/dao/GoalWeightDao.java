/**
 *
 */
package model.dao;

import java.util.List;

import model.objects.GoalWeight;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;


/**
 * The Interface GoalWeightDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface GoalWeightDao {

	/**
	 * Adds the goal weight.
	 *
	 * @param goalWeight the goal weight
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addGoalWeight(GoalWeight goalWeight) throws InsertDataBaseException;

	/**
	 * Delete goal weight.
	 *
	 * @param goalWeight the goal weight
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteGoalWeight(GoalWeight goalWeight) throws EmptyResultsQueryException;

	/**
	 * Gets the all goal weight.
	 *
	 * @return the all goal weight
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<GoalWeight> getAllGoalWeight() throws EmptyResultsQueryException;

	/**
	 * Gets the goal weight by id.
	 *
	 * @param id_goalWeight the id goal weight
	 * @return the corresponding goalWeight
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	GoalWeight getGoalWeightById(Integer id_goalWeight) throws EmptyResultsQueryException;

	/**
	 * Update goal weight.
	 *
	 * @param goalWeight the goal weight
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void updateGoalWeight(GoalWeightDao goalWeight) throws EmptyResultsQueryException, InsertDataBaseException;
}
