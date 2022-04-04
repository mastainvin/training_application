/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.GoalNbRep;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 *
 */
public interface GoalNbRepDao {
	
	/**
	 * 
	 * @return
	 * @throws EmptyResultsQueryException
	 */
	List<GoalNbRep> getAllGoalNbRep() throws EmptyResultsQueryException;

	/**
	 * 
	 * @param id_goalNbRep
	 * @return the corresponding goalNbRep
	 * @throws EmptyResultsQueryException
	 */
	GoalNbRep getGoalNbRepById(Integer id_goalNbRep) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param goalNbRep which we want the id
	 * @return the goalNbRep's id
	 * @throws EmptyResultsQueryException
	 */
	Integer getGoalNbRepId(GoalNbRep goalNbRep) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param goalNbRep
	 */
	void addGoalNbRep(GoalNbRep goalNbRep);
	
	/**
	 * 
	 * @param previousGoalNbRep
	 * @param newGoalNbRep
	 * @throws EmptyResultsQueryException
	 */
	void updateGoalNbRep(GoalNbRep previousGoalNbRep, GoalNbRepDao newGoalNbRep) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param goalNbRep
	 * @throws EmptyResultsQueryException 
	 */
	void deleteGoalNbRep(GoalNbRep goalNbRep) throws EmptyResultsQueryException;
}
