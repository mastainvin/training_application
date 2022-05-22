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
import model.objects.Exercice;
import model.objects.Morphology;
import model.objects.exceptions.EmptyResultsQueryException;

// TODO: Auto-generated Javadoc
/**
 * The Class CompatibleMorphDaoImpl.
 *
 * @author cytech
 */
public class CompatibleMorphDaoImpl extends JoinDao<Morphology, Exercice> implements CompatibleMorphDao {

	/** The singleton. */
	static private CompatibleMorphDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the compatible morph dao impl
	 */
	public static CompatibleMorphDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			singleton = new CompatibleMorphDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new compatible morph dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private CompatibleMorphDaoImpl(DaoFactory daoFactory) {
		super(daoFactory);
		this.setADbName("Morphology");
		this.setBDbName("Exercice");
		this.setAIdLabel("id_morphology");
		this.setBIdLabel("id_exercice");
		this.setDbName("CompatibleMorph");
	}

	/**
	 * Adds the compatible exercice.
	 *
	 * @param id_morphology the id morphology
	 * @param id_exercice   the id exercice
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	@Override
	public void addCompatibleExercice(Integer id_morphology, Integer id_exercice)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.add(id_morphology, id_exercice);
	}

	/**
	 * A object constructor.
	 *
	 * @param valuesMap the values map
	 * @return the morphology
	 */
	@Override
	Morphology AObjectConstructor(Map<String, String> valuesMap) {
		Morphology morphology = new Morphology();
		morphology.setName(valuesMap.get("name"));
		morphology.setDescription(valuesMap.get("description"));
		morphology.setIdMorphology(Integer.parseInt(valuesMap.get("id_morphology")));
		return morphology;
	}

	/**
	 * B object constructor.
	 *
	 * @param valuesMap the values map
	 * @return the exercice
	 */
	@Override
	Exercice BObjectConstructor(Map<String, String> valuesMap) {
		Exercice exercice = new Exercice();
		exercice.setName(valuesMap.get("name"));
		exercice.setDescription(valuesMap.get("description"));
		exercice.setIdExercice(Integer.parseInt(valuesMap.get("id_exercice")));

		return exercice;
	}

	/**
	 * Delete compatible exercice.
	 *
	 * @param id_morphology the id morphology
	 * @param id_exercice   the id exercice
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	@Override
	public void deleteCompatibleExercice(Integer id_morphology, Integer id_exercice)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.delete(id_morphology, id_exercice);
	}

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_morphology the id morphology
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Exercice> getDisponbilities(Integer id_morphology) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getBList(id_morphology);
		List<Exercice> disponibilities = new ArrayList<>();

		for (Map<String, String> value : values) {
			Exercice d = BObjectConstructor(value);
			disponibilities.add(d);
		}
		return disponibilities;
	}

	/**
	 * Gets the morphologys.
	 *
	 * @param id_exercice the id exercice
	 * @return the morphologys
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Morphology> getMorphologys(Integer id_exercice) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getAList(id_exercice);
		List<Morphology> morphologys = new ArrayList<>();

		for (Map<String, String> value : values) {
			Morphology s = AObjectConstructor(value);
			morphologys.add(s);
		}
		return morphologys;
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
		valuesMap.put("description", results.getString("description"));
		valuesMap.put("id_morphology", results.getString("id_morphology"));
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
		valuesMap.put("id_exercice", results.getString("id_exercice"));
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("description", results.getString("description"));
		return valuesMap;
	}

}
