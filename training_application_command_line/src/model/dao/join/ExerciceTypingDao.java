/**
 * 
 */
package model.dao.join;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import model.objects.Exercice;
import model.objects.ExerciceType;
import model.objects.exceptions.EmptyResultsQueryException;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExerciceTypingDao.
 *
 * @author Vincent Mastain
 */
public interface ExerciceTypingDao {
	
	/**
	 * Gets the disponbilities.
	 *
	 * @param id_exerciceType the id exercice type
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Exercice> getDisponbilities(Integer id_exerciceType) throws EmptyResultsQueryException;
	
	/**
	 * Gets the exercice types.
	 *
	 * @param id_exercice the id exercice
	 * @return the exercice types
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<ExerciceType> getExerciceTypes(Integer id_exercice) throws EmptyResultsQueryException;
	
	/**
	 * Adds the compatible exercice.
	 *
	 * @param id_exerciceType the id exercice type
	 * @param id_exercice the id exercice
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	void addCompatibleExercice(Integer id_exerciceType, Integer id_exercice) throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;
	
	/**
	 * Delete compatible exercice.
	 *
	 * @param id_exerciceType the id exercice type
	 * @param id_exercice the id exercice
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	void deleteCompatibleExercice(Integer id_exerciceType, Integer id_exercice) throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;
}
