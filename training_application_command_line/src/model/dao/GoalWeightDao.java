/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.GoalWeight;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 *
 */
public interface GoalWeightDao {
	
	/**
	 * 
	 * @return
	 * @throws EmptyResultsQueryException
	 */
	List<GoalWeight> getAllGoalWeight() throws EmptyResultsQueryException;

	/**
	 * 
	 * @param id_goalWeight
	 * @return the corresponding goalWeight
	 * @throws EmptyResultsQueryException
	 */
	GoalWeight getGoalWeightById(Integer id_goalWeight) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param goalWeight which we want the id
	 * @return the goalWeight's id
	 * @throws EmptyResultsQueryException
	 */
	Integer getGoalWeightId(GoalWeight goalWeight) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param goalWeight
	 */
	void addGoalWeight(GoalWeight goalWeight);
	
	/**
	 * 
	 * @param previousGoalWeight
	 * @param newGoalWeight
	 * @throws EmptyResultsQueryException
	 */
	void updateGoalWeight(GoalWeight previousGoalWeight, GoalWeightDao newGoalWeight) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param goalWeight
	 * @throws EmptyResultsQueryException 
	 */
	void deleteGoalWeight(GoalWeight goalWeight) throws EmptyResultsQueryException;
}
