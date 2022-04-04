/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Goal;

import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public interface GoalDao {
	
	/**
	 * 
	 * @return Frist goal of the db
	 * @throws EmptyResultsQueryException
	 */
	Goal getFirstGoal() throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param name  name of the goal
	 * @return goal which corresponds to the name
	 * @throws EmptyResultsQueryException
	 */
	Goal getGoalByName(String name) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param id_goal id requested
	 * @return goal which corresponds to the id param
	 * @throws EmptyResultsQueryException
	 */
	Goal getGoalById(Integer id_goal) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param goal which we want the id
	 * @return goal id corresponding
	 * @throws EmptyResultsQueryException
	 */
	Integer getGoalId(Goal goal) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param goal goal wanted
	 */
	void addGoal(Goal goal);
	
	/**
	 * 
	 * @param previousGoal goal to change
	 * @param newGoal goal used to make the change
	 * @throws EmptyResultsQueryException
	 */
	void updateGoal(Goal previousGoal, Goal newGoal) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param goal goal to delete
	 * @throws EmptyResultsQueryException 
	 */
	void deleteGoal(Goal goal) throws EmptyResultsQueryException;
	
	public List<Goal> getAllGoal() throws EmptyResultsQueryException;
}
