/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Exercice;
import model.objects.TrainingComponent;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExerciceDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface ExerciceDao {
	
	/**
	 * Gets the first exercice.
	 *
	 * @return Frist exercice of the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Exercice getFirstExercice() throws EmptyResultsQueryException;
	
	/**
	 * Gets the exercice by name.
	 *
	 * @param name  name of the exercice
	 * @return exercice which corresponds to the name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Exercice getExerciceByName(String name) throws EmptyResultsQueryException;
	
	/**
	 * Gets the exercice by id.
	 *
	 * @param id_exercice id requested
	 * @return exercice which corresponds to the id param
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Exercice getExerciceById(Integer id_exercice) throws EmptyResultsQueryException;
	
	/**
	 * Adds the exercice.
	 *
	 * @param exercice exercice wanted
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addExercice(Exercice exercice) throws InsertDataBaseException;
	
	/**
	 * Update exercice.
	 *
	 * @param exercice the exercice
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void updateExercice(Exercice exercice) throws EmptyResultsQueryException, InsertDataBaseException;
	
	/**
	 * Delete exercice.
	 *
	 * @param exercice exercice to delete
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteExercice(Exercice exercice) throws EmptyResultsQueryException;
	
	/**
	 * Gets the all exercice.
	 *
	 * @return the all exercice
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public List<Exercice> getAllExercice() throws EmptyResultsQueryException;
	
	void getTrainingComponentExerciceList(TrainingComponent trainingComponent, User user) throws EmptyResultsQueryException ;
	
}
