/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Equipment;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface EquipmentDao.
 *
 * @author Vincent Mastain
 * @version 1.à
 */
public interface EquipmentDao {

	/**
	 * Adds the equipment.
	 *
	 * @param equipment equipment to add
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addEquipment(Equipment equipment) throws InsertDataBaseException;

	/**
	 * Delete equipment.
	 *
	 * @param equipment the equipment
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteEquipment(Equipment equipment) throws EmptyResultsQueryException;

	/**
	 * Gets the all equipment.
	 *
	 * @return the all equipment
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Equipment> getAllEquipment() throws EmptyResultsQueryException;

	/**
	 * Gets the equipment by id.
	 *
	 * @param id_equipment id of the wanted equipment
	 * @return the equipment requested
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Equipment getEquipmentById(Integer id_equipment) throws EmptyResultsQueryException;

	/**
	 * Gets the equipment by name.
	 *
	 * @param name the name of the equipment
	 * @return the equipment requested
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Equipment getEquipmentByName(String name) throws EmptyResultsQueryException;

	/**
	 * Update equipment.
	 *
	 * @param equipment the equipment
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void updateEquipment(Equipment equipment) throws EmptyResultsQueryException, InsertDataBaseException;

}
