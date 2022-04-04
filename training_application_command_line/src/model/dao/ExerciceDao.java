/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Exercice;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public interface ExerciceDao {
	
	/**
	 * 
	 * @return Frist exercice of the db
	 * @throws EmptyResultsQueryException
	 */
	Exercice getFirstExercice() throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param name  name of the exercice
	 * @return exercice which corresponds to the name
	 * @throws EmptyResultsQueryException
	 */
	Exercice getExerciceByName(String name) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param id_exercice id requested
	 * @return exercice which corresponds to the id param
	 * @throws EmptyResultsQueryException
	 */
	Exercice getExerciceById(Integer id_exercice) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param exercice which we want the id
	 * @return exercice id corresponding
	 * @throws EmptyResultsQueryException
	 */
	Integer getExerciceId(Exercice exercice) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param exercice exercice wanted
	 */
	void addExercice(Exercice exercice);
	
	/**
	 * 
	 * @param previousExercice exercice to change
	 * @param newExercice exercice used to make the change
	 * @throws EmptyResultsQueryException
	 */
	void updateExercice(Exercice previousExercice, Exercice newExercice) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param exercice exercice to delete
	 * @throws EmptyResultsQueryException 
	 */
	void deleteExercice(Exercice exercice) throws EmptyResultsQueryException;
	
	public List<Exercice> getAllExercice() throws EmptyResultsQueryException;
	
	public void getUserExerciceData(Exercice exercice, User user);
}
