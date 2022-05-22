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
import model.objects.Disponibility;
import model.objects.Structure;
import model.objects.exceptions.EmptyResultsQueryException;


/**
 * The Class CompatibleDisponibilityDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class CompatibleDisponibilityDaoImpl extends JoinDao<Structure, Disponibility>
		implements CompatibleDisponibilityDao {

	/** The singleton. */
	static private CompatibleDisponibilityDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the compatible disponibility dao impl
	 */
	public static CompatibleDisponibilityDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			singleton = new CompatibleDisponibilityDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new compatible disponibility dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private CompatibleDisponibilityDaoImpl(DaoFactory daoFactory) {
		super(daoFactory);
		this.setADbName("Structure");
		this.setBDbName("Disponibility");
		this.setAIdLabel("id_structure");
		this.setBIdLabel("id_disponibility");
		this.setDbName("CompatibleDisponibility");
	}

	/**
	 * Adds the compatible disponibility.
	 *
	 * @param id_structure     the id structure
	 * @param id_disponibility the id disponibility
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	@Override
	public void addCompatibleDisponibility(Integer id_structure, Integer id_disponibility)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.add(id_structure, id_disponibility);
	}

	/**
	 * Delete compatible disponibility.
	 *
	 * @param id_structure     the id structure
	 * @param id_disponibility the id disponibility
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	@Override
	public void deleteCompatibleDisponibility(Integer id_structure, Integer id_disponibility)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.delete(id_structure, id_disponibility);
	}

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_structure the id structure
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Disponibility> getDisponbilities(Integer id_structure) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getBList(id_structure);
		List<Disponibility> disponibilities = new ArrayList<>();

		for (Map<String, String> value : values) {
			Disponibility d = BObjectConstructor(value);
			disponibilities.add(d);
		}
		return disponibilities;
	}

	/**
	 * Gets the structures.
	 *
	 * @param id_disponibility the id disponibility
	 * @return the structures
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Structure> getStructures(Integer id_disponibility) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getAList(id_disponibility);
		List<Structure> structures = new ArrayList<>();

		for (Map<String, String> value : values) {
			Structure s = AObjectConstructor(value);
			structures.add(s);
		}
		return structures;
	}

	/**
	 * A object constructor.
	 *
	 * @param valuesMap the values map
	 * @return the structure
	 */
	@Override
	Structure AObjectConstructor(Map<String, String> valuesMap) {
		Structure structure = new Structure();

		structure.setName(valuesMap.get("name"));
		structure.setIdStructure(Integer.parseInt(valuesMap.get("id_structure")));

		try {
			structure.setIdGoal(Integer.parseInt(valuesMap.get("id_goal")));
		} catch (NumberFormatException e) {

		}
		return structure;
	}

	/**
	 * B object constructor.
	 *
	 * @param valuesMap the values map
	 * @return the disponibility
	 */
	@Override
	Disponibility BObjectConstructor(Map<String, String> valuesMap) {
		Disponibility disponibility = new Disponibility();
		disponibility.setDuration(Integer.parseInt(valuesMap.get("duration")));
		disponibility.setLayout(Integer.parseInt(valuesMap.get("layout")));
		disponibility.setIdDisponibility(Integer.parseInt(valuesMap.get("id_disponibility")));

		return disponibility;
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
		valuesMap.put("id_structure", results.getString("id_structure"));
		valuesMap.put("id_goal", results.getString("id_goal"));
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
		valuesMap.put("duration", results.getString("duration"));
		valuesMap.put("layout", results.getString("layout"));
		valuesMap.put("id_disponibility", results.getString("id_disponibility"));
		return valuesMap;
	}

}
