/**
 *
 */
package model.dao.join;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dao.DaoFactory;
import model.objects.Equipment;
import model.objects.Exercise;
import model.objects.exceptions.EmptyResultsQueryException;


/**
 * The Class CompatibleEquipmentDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class CompatibleEquipmentDaoImpl extends JoinDao<Equipment, Exercise> implements CompatibleEquipmentDao {

	/** The singleton. */
	static private CompatibleEquipmentDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the compatible equipment dao impl
	 */
	public static CompatibleEquipmentDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			singleton = new CompatibleEquipmentDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new compatible equipment dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private CompatibleEquipmentDaoImpl(DaoFactory daoFactory) {
		super(daoFactory);
		this.setADbName("Equipment");
		this.setBDbName("Exercise");
		this.setAIdLabel("id_equipment");
		this.setBIdLabel("id_exercise");
		this.setDbName("CompatibleEquipment");
	}

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
	@Override
	public void addCompatibleExercise(Integer id_equipment, Integer id_exercise)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.add(id_equipment, id_exercise);
	}

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
	@Override
	public void deleteCompatibleExercise(Integer id_equipment, Integer id_exercise)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.delete(id_equipment, id_exercise);
	}

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_equipment the id equipment
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Exercise> getDisponbilities(Integer id_equipment) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getBList(id_equipment);
		List<Exercise> disponibilities = new ArrayList<>();

		for (Map<String, String> value : values) {
			Exercise d = BObjectConstructor(value);
			disponibilities.add(d);
		}
		return disponibilities;
	}

	/**
	 * Gets the equipments.
	 *
	 * @param id_exercise the id exercise
	 * @return the equipments
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Equipment> getEquipments(Integer id_exercise) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getAList(id_exercise);
		List<Equipment> equipments = new ArrayList<>();

		for (Map<String, String> value : values) {
			Equipment s = AObjectConstructor(value);
			equipments.add(s);
		}
		return equipments;
	}

	/**
	 * A object constructor.
	 *
	 * @param valuesMap the values map
	 * @return the equipment
	 */
	@Override
	Equipment AObjectConstructor(Map<String, String> valuesMap) {
		Equipment equipment = new Equipment();
		equipment.setName(valuesMap.get("name"));
		equipment.setIdEquipment(Integer.parseInt(valuesMap.get("id_equipment")));
		return equipment;
	}

	/**
	 * B object constructor.
	 *
	 * @param valuesMap the values map
	 * @return the exercise
	 */
	@Override
	Exercise BObjectConstructor(Map<String, String> valuesMap) {
		Exercise exercise = new Exercise();
		exercise.setName(valuesMap.get("name"));
		exercise.setDescription(valuesMap.get("description"));
		exercise.setIdExercise(Integer.parseInt(valuesMap.get("id_exercise")));

		return exercise;
	}

	/**
	 * Sets the map from result set A.
	 *
	 * @param results the results
	 * @return the map
	 * @throws SQLException the SQL exception
	 */
	@Override
	Map<String, String> setMapFromResultSetA(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("id_equipment", results.getString("id_equipment"));
		return valuesMap;
	}

	/**
	 * Sets the map from result set B.
	 *
	 * @param results the results
	 * @return the map
	 * @throws SQLException the SQL exception
	 */
	@Override
	Map<String, String> setMapFromResultSetB(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("id_exercise", results.getString("id_exercise"));
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("description", results.getString("description"));
		return valuesMap;
	}

}
