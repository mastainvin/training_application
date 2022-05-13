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
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;

// TODO: Auto-generated Javadoc
/**
 * The Class HasEquipmentDaoImpl.
 *
 * @author cytech
 */
public class HasEquipmentDaoImpl extends JoinDao<User, Equipment> implements HasEquipmentDao {

	/** The singleton. */
	static private HasEquipmentDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the checks for equipment dao impl
	 */
	public static HasEquipmentDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			singleton = new HasEquipmentDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new checks for equipment dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private HasEquipmentDaoImpl(DaoFactory daoFactory) {
		super(daoFactory);
		this.setADbName("User");
		this.setBDbName("Equipment");
		this.setAIdLabel("id_user");
		this.setBIdLabel("id_equipment");
		this.setDbName("HasEquipment");
	}

	/**
	 * Adds the compatible equipment.
	 *
	 * @param id_user      the id user
	 * @param id_equipment the id equipment
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	@Override
	public void addCompatibleEquipment(Integer id_user, Integer id_equipment)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.add(id_user, id_equipment);
	}

	/**
	 * A object constructor.
	 *
	 * @param valuesMap the values map
	 * @return the user
	 */
	@Override
	User AObjectConstructor(Map<String, String> valuesMap) {
		User user = new User();
		user.setPseudonym(valuesMap.get("pseudonym"));
		user.setPassword(valuesMap.get("password"));
		user.setEmail(valuesMap.get("email"));
		user.setSize(Integer.parseInt(valuesMap.get("size")));
		user.setWeight(Integer.parseInt(valuesMap.get("weight")));
		user.setGender(valuesMap.get("gender"));
		user.setBodyFat(Integer.parseInt(valuesMap.get("body_fat")));
		user.setMuscleMass(Integer.parseInt(valuesMap.get("muscle_mass")));
		user.setIdUser(Integer.parseInt(valuesMap.get("id_user")));

		try {
			user.setIdRole(Integer.parseInt(valuesMap.get("id_role")));
		} catch (NumberFormatException e) {
		}

		try {
			user.setIdMorphology(Integer.parseInt(valuesMap.get("id_morphology")));
		} catch (NumberFormatException e) {
		}

		try {
			user.setIdGoal(Integer.parseInt(valuesMap.get("id_goal")));
		} catch (NumberFormatException e) {
		}
		return user;
	}

	/**
	 * B object constructor.
	 *
	 * @param valuesMap the values map
	 * @return the equipment
	 */
	@Override
	Equipment BObjectConstructor(Map<String, String> valuesMap) {
		Equipment equipment = new Equipment();
		equipment.setName(valuesMap.get("name"));
		equipment.setIdEquipment(Integer.parseInt(valuesMap.get("id_equipment")));

		return equipment;
	}

	/**
	 * Delete compatible equipment.
	 *
	 * @param id_user      the id user
	 * @param id_equipment the id equipment
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	@Override
	public void deleteCompatibleEquipment(Integer id_user, Integer id_equipment)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.delete(id_user, id_equipment);
	}

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_user the id user
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Equipment> getEquipments(Integer id_user) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getBList(id_user);
		List<Equipment> disponibilities = new ArrayList<>();

		for (Map<String, String> value : values) {
			Equipment d = BObjectConstructor(value);
			disponibilities.add(d);
		}
		return disponibilities;
	}

	/**
	 * Gets the users.
	 *
	 * @param id_equipment the id equipment
	 * @return the users
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<User> getUsers(Integer id_equipment) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getAList(id_equipment);
		List<User> users = new ArrayList<>();

		for (Map<String, String> value : values) {
			User s = AObjectConstructor(value);
			users.add(s);
		}
		return users;
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
		valuesMap.put("pseudonym", results.getString("pseudonym"));
		valuesMap.put("password", results.getString("password"));
		valuesMap.put("email", results.getString("email"));
		valuesMap.put("size", results.getString("size"));
		valuesMap.put("weight", results.getString("weight"));
		valuesMap.put("gender", results.getString("gender"));
		valuesMap.put("body_fat", results.getString("body_fat"));
		valuesMap.put("muscle_mass", results.getString("muscle_mass"));
		valuesMap.put("id_role", results.getString("id_role"));
		valuesMap.put("id_morphology", results.getString("id_morphology"));
		valuesMap.put("id_goal", results.getString("id_goal"));
		valuesMap.put("id_user", results.getString("id_user"));
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
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("id_equipment", results.getString("id_equipment"));
		return valuesMap;
	}

}
