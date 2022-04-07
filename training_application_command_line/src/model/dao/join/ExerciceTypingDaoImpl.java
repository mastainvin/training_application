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
import model.objects.ExerciceType;
import model.objects.exceptions.EmptyResultsQueryException;

// TODO: Auto-generated Javadoc
/**
 * The Class ExerciceTypingDaoImpl.
 *
 * @author cytech
 */
public class ExerciceTypingDaoImpl extends JoinDao<ExerciceType, Exercice> implements ExerciceTypingDao {

	/** The singleton. */
	static private ExerciceTypingDaoImpl singleton = null;
	
	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the exercice typing dao impl
	 */
	public static ExerciceTypingDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			singleton = new ExerciceTypingDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	/**
	 * Instantiates a new exercice typing dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private ExerciceTypingDaoImpl(DaoFactory daoFactory) {
		super(daoFactory);
		this.setADbName("ExerciceType");
		this.setBDbName("Exercice");
		this.setAIdLabel("id_exerciceType");
		this.setBIdLabel("id_exercice");
		this.setDbName("ExerciceTyping");
	}

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_exerciceType the id exercice type
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Exercice> getDisponbilities(Integer id_exerciceType) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getBList(id_exerciceType);
		List<Exercice> disponibilities = new ArrayList<>();
		
		for(Map<String, String> value : values) {
			Exercice d = BObjectConstructor(value);
			disponibilities.add(d);
		}
		return disponibilities;
	}

	/**
	 * Gets the exercice types.
	 *
	 * @param id_exercice the id exercice
	 * @return the exercice types
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<ExerciceType> getExerciceTypes(Integer id_exercice) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getAList(id_exercice);
		List<ExerciceType> exerciceTypes = new ArrayList<>();
		
		for(Map<String, String> value : values) {
			ExerciceType s = AObjectConstructor(value);
			exerciceTypes.add(s);
		}
		return exerciceTypes;
	}

	/**
	 * Adds the compatible exercice.
	 *
	 * @param id_exerciceType the id exercice type
	 * @param id_exercice the id exercice
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	@Override
	public void addCompatibleExercice(Integer id_exerciceType, Integer id_exercice) throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.add(id_exerciceType, id_exercice);
	}

	/**
	 * Delete compatible exercice.
	 *
	 * @param id_exerciceType the id exercice type
	 * @param id_exercice the id exercice
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	@Override
	public void deleteCompatibleExercice(Integer id_exerciceType, Integer id_exercice) throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.delete(id_exerciceType, id_exercice);
	}

	/**
	 * A object constructor.
	 *
	 * @param valuesMap the values map
	 * @return the exercice type
	 */
	@Override
	ExerciceType AObjectConstructor(Map<String, String> valuesMap) {
		ExerciceType exerciceType = new ExerciceType();
		exerciceType.setName(valuesMap.get("name"));
		exerciceType.setDescription(valuesMap.get("description"));
		exerciceType.setIdExerciceType(Integer.parseInt(valuesMap.get("id_exercice_type")));
		return exerciceType;
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
		valuesMap.put("id_exercice_type", results.getString("id_exercice_type"));
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
