/**
 * 
 */
package model.dao.join;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import model.objects.Equipment;
import model.objects.Exercise;
import model.objects.exceptions.EmptyResultsQueryException;

// TODO: Auto-generated Javadoc
/**
 * The Interface CompatibleEquipmentDao.
 *
 * @author Vincent Mastain
 */
public interface CompatibleEquipmentDao {

	/**
	 * Adds the compatible exercise.
	 *
	 * @param id_equipment the id equipment
	 * @param id_exercise  the id exercise
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void addCompatibleExercise(Integer id_equipment, Integer id_exercise)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Delete compatible exercise.
	 *
	 * @param id_equipment the id equipment
	 * @param id_exercise  the id exercise
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	void deleteCompatibleExercise(Integer id_equipment, Integer id_exercise)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException;

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_equipment the id equipment
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Exercise> getDisponbilities(Integer id_equipment) throws EmptyResultsQueryException;

	/**
	 * Gets the equipments.
	 *
	 * @param id_exercise the id exercise
	 * @return the equipments
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Equipment> getEquipments(Integer id_exercise) throws EmptyResultsQueryException;
}
