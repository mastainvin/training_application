/**
 * 
 */
package model.dao;

import model.objects.Equipment;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.à
 */
public interface EquipmentDao {
	/**
	 * 
	 * @param id_equipment id of the wanted equipment
	 * @return the equipment requested
	 * @throws EmptyResultsQueryException
	 */
	Equipment getEquipmentById(Integer id_equipment) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param name the name of the equipment
	 * @return the equipment requested
	 * @throws EmptyResultsQueryException
	 */
	Equipment getEquipmentByName(String name) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param equipment equipment requested
	 * @return the id of the equipment wanted
	 * @throws EmpryResultsQueryException
	 */
	Integer getEquipmentId(Equipment equipment) throws EmptyResultsQueryException;
	/**
	 * 
	 * @param equipment equipment to add
	 */
	void addEquipment(Equipment equipment);
	
	/**
	 * 
	 * @param previousEquipment equipment wanted to change
	 * @param newEquipment the new equipment used to make the change
	 */
	void updateEquipment(Equipment previousEquipment, Equipment newEquipment) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param bodyLimb equipment wanted to be delete
	 * @throws EmptyResultsQueryException 
	 */
	void deleteEquipment(Equipment equipment) throws EmptyResultsQueryException;
}
