/**
 * 
 */
package model.dao.join;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import model.objects.Equipment;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;

// TODO: Auto-generated Javadoc
/**
 * The Interface HasEquipmentDao.
 *
 * @author Vincent Mastain
 */
public interface HasEquipmentDao {
	
	/**
	 * Gets the disponbilities.
	 *
	 * @param id_user the id user
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Equipment> getDisponbilities(Integer id_user) throws EmptyResultsQueryException;
	
	/**
	 * Gets the users.
	 *
	 * @param id_equipment the id equipment
	 * @return the users
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<User> getUsers(Integer id_equipment) throws EmptyResultsQueryException;
	
	/**
	 * Adds the compatible equipment.
	 *
	 * @param id_user the id user
	 * @param id_equipment the id equipment
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	void addCompatibleEquipment(Integer id_user, Integer id_equipment) throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;
	
	/**
	 * Delete compatible equipment.
	 *
	 * @param id_user the id user
	 * @param id_equipment the id equipment
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	void deleteCompatibleEquipment(Integer id_user, Integer id_equipment) throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;
}
