/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Goal;

import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface GoalDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface GoalDao {
	
	/**
	 * Gets the first goal.
	 *
	 * @return Frist goal of the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Goal getFirstGoal() throws EmptyResultsQueryException;
	
	/**
	 * Gets the goal by name.
	 *
	 * @param name  name of the goal
	 * @return goal which corresponds to the name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Goal getGoalByName(String name) throws EmptyResultsQueryException;
	
	/**
	 * Gets the goal by id.
	 *
	 * @param id_goal id requested
	 * @return goal which corresponds to the id param
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Goal getGoalById(Integer id_goal) throws EmptyResultsQueryException;

	/**
	 * Adds the goal.
	 *
	 * @param goal goal wanted
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addGoal(Goal goal) throws InsertDataBaseException;
	
	/**
	 * Update goal.
	 *
	 * @param goal the goal
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void updateGoal(Goal goal) throws EmptyResultsQueryException, InsertDataBaseException;
	
	/**
	 * Delete goal.
	 *
	 * @param goal goal to delete
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteGoal(Goal goal) throws EmptyResultsQueryException;
	
	/**
	 * Gets the all goal.
	 *
	 * @return the all goal
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public List<Goal> getAllGoal() throws EmptyResultsQueryException;
}
