/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.GoalNbRep;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface GoalNbRepDao.
 *
 * @author Vincent Mastain
 */
public interface GoalNbRepDao {
	
	/**
	 * Gets the all goal nb rep.
	 *
	 * @return the all goal nb rep
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<GoalNbRep> getAllGoalNbRep() throws EmptyResultsQueryException;

	/**
	 * Gets the goal nb rep by id.
	 *
	 * @param id_goalNbRep the id goal nb rep
	 * @return the corresponding goalNbRep
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	GoalNbRep getGoalNbRepById(Integer id_goalNbRep) throws EmptyResultsQueryException;
	
	
	/**
	 * Adds the goal nb rep.
	 *
	 * @param goalNbRep the goal nb rep
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addGoalNbRep(GoalNbRep goalNbRep) throws InsertDataBaseException;
	
	/**
	 * Update goal nb rep.
	 *
	 * @param goalNbRep the goal nb rep
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void updateGoalNbRep(GoalNbRepDao goalNbRep) throws EmptyResultsQueryException, InsertDataBaseException;
	
	/**
	 * Delete goal nb rep.
	 *
	 * @param goalNbRep the goal nb rep
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteGoalNbRep(GoalNbRep goalNbRep) throws EmptyResultsQueryException;
}
