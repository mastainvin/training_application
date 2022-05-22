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
import model.objects.Exercise;
import model.objects.Morphology;
import model.objects.exceptions.EmptyResultsQueryException;

// TODO: Auto-generated Javadoc
/**
 * The Class CompatibleMorphDaoImpl.
 *
 * @author cytech
 */
public class CompatibleMorphDaoImpl extends JoinDao<Morphology, Exercise> implements CompatibleMorphDao {

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
		this.setBDbName("Exercise");
		this.setAIdLabel("id_morphology");
		this.setBIdLabel("id_exercise");
		this.setDbName("CompatibleMorph");
	}

	/**
	 * Adds the compatible exercise.
	 *
	 * @param id_morphology the id morphology
	 * @param id_exercise   the id exercise
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	@Override
	public void addCompatibleExercise(Integer id_morphology, Integer id_exercise)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.add(id_morphology, id_exercise);
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
	 * Delete compatible exercise.
	 *
	 * @param id_morphology the id morphology
	 * @param id_exercise   the id exercise
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	@Override
	public void deleteCompatibleExercise(Integer id_morphology, Integer id_exercise)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.delete(id_morphology, id_exercise);
	}

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_morphology the id morphology
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Exercise> getDisponbilities(Integer id_morphology) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getBList(id_morphology);
		List<Exercise> disponibilities = new ArrayList<>();

		for (Map<String, String> value : values) {
			Exercise d = BObjectConstructor(value);
			disponibilities.add(d);
		}
		return disponibilities;
	}

	/**
	 * Gets the morphologys.
	 *
	 * @param id_exercise the id exercise
	 * @return the morphologys
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Morphology> getMorphologys(Integer id_exercise) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getAList(id_exercise);
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
		valuesMap.put("id_exercise", results.getString("id_exercise"));
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("description", results.getString("description"));
		return valuesMap;
	}

}
