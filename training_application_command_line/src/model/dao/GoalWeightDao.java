/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.GoalWeight;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface GoalWeightDao.
 *
 * @author Vincent Mastain
 */
public interface GoalWeightDao {
	
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
	 * Adds the goal weight.
	 *
	 * @param goalWeight the goal weight
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addGoalWeight(GoalWeight goalWeight) throws InsertDataBaseException;
	
	/**
	 * Update goal weight.
	 *
	 * @param goalWeight the goal weight
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void updateGoalWeight(GoalWeightDao goalWeight) throws EmptyResultsQueryException, InsertDataBaseException;
	
	/**
	 * Delete goal weight.
	 *
	 * @param goalWeight the goal weight
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteGoalWeight(GoalWeight goalWeight) throws EmptyResultsQueryException;
}
