/**
 * 
 */
package model.dao.join;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import model.objects.Exercice;
import model.objects.Equipment;
import model.objects.exceptions.EmptyResultsQueryException;

// TODO: Auto-generated Javadoc
/**
 * The Interface CompatibleEquipmentDao.
 *
 * @author Vincent Mastain
 */
public interface CompatibleEquipmentDao {
	
	/**
	 * Gets the disponbilities.
	 *
	 * @param id_equipment the id equipment
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Exercice> getDisponbilities(Integer id_equipment) throws EmptyResultsQueryException;
	
	/**
	 * Gets the equipments.
	 *
	 * @param id_exercice the id exercice
	 * @return the equipments
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Equipment> getEquipments(Integer id_exercice) throws EmptyResultsQueryException;
	
	/**
	 * Adds the compatible exercice.
	 *
	 * @param id_equipment the id equipment
	 * @param id_exercice the id exercice
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	void addCompatibleExercice(Integer id_equipment, Integer id_exercice) throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;
	
	/**
	 * Delete compatible exercice.
	 *
	 * @param id_equipment the id equipment
	 * @param id_exercice the id exercice
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	void deleteCompatibleExercice(Integer id_equipment, Integer id_exercice) throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;
}
