/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.GoalNbSerie;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 *
 */
public interface GoalNbSerieDao {
	
	/**
	 * 
	 * @return
	 * @throws EmptyResultsQueryException
	 */
	List<GoalNbSerie> getAllGoalNbSerie() throws EmptyResultsQueryException;

	/**
	 * 
	 * @param id_goalNbSerie
	 * @return the corresponding goalNbSerie
	 * @throws EmptyResultsQueryException
	 */
	GoalNbSerie getGoalNbSerieById(Integer id_goalNbSerie) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param goalNbSerie which we want the id
	 * @return the goalNbSerie's id
	 * @throws EmptyResultsQueryException
	 */
	Integer getGoalNbSerieId(GoalNbSerie goalNbSerie) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param goalNbSerie
	 */
	void addGoalNbSerie(GoalNbSerie goalNbSerie);
	
	/**
	 * 
	 * @param previousGoalNbSerie
	 * @param newGoalNbSerie
	 * @throws EmptyResultsQueryException
	 */
	void updateGoalNbSerie(GoalNbSerie previousGoalNbSerie, GoalNbSerieDao newGoalNbSerie) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param goalNbSerie
	 * @throws EmptyResultsQueryException 
	 */
	void deleteGoalNbSerie(GoalNbSerie goalNbSerie) throws EmptyResultsQueryException;
}
