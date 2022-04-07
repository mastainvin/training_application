/**
 * 
 */
package model.dao.join;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import model.objects.Disponibility;
import model.objects.Structure;
import model.objects.exceptions.EmptyResultsQueryException;

// TODO: Auto-generated Javadoc
/**
 * The Interface CompatibleDisponibilityDao.
 *
 * @author Vincent Mastain
 */
public interface CompatibleDisponibilityDao {
	
	/**
	 * Gets the disponbilities.
	 *
	 * @param id_structure the id structure
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Disponibility> getDisponbilities(Integer id_structure) throws EmptyResultsQueryException;
	
	/**
	 * Gets the structures.
	 *
	 * @param id_disponibility the id disponibility
	 * @return the structures
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Structure> getStructures(Integer id_disponibility) throws EmptyResultsQueryException;
	
	/**
	 * Adds the compatible disponibility.
	 *
	 * @param id_structure the id structure
	 * @param id_disponibility the id disponibility
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	void addCompatibleDisponibility(Integer id_structure, Integer id_disponibility) throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;
	
	/**
	 * Delete compatible disponibility.
	 *
	 * @param id_structure the id structure
	 * @param id_disponibility the id disponibility
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	void deleteCompatibleDisponibility(Integer id_structure, Integer id_disponibility) throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;
}
