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
import model.objects.BiomecanicFunction;
import model.objects.exceptions.EmptyResultsQueryException;

// TODO: Auto-generated Javadoc
/**
 * The Class CompatibleBiomecanicFunctionDaoImpl.
 *
 * @author cytech
 */
public class CompatibleBiomecanicFunctionDaoImpl extends JoinDao<BiomecanicFunction, Exercice> implements CompatibleBiomecanicFunctionDao {

	/** The singleton. */
	static private CompatibleBiomecanicFunctionDaoImpl singleton = null;
	
	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the compatible biomecanic function dao impl
	 */
	public static CompatibleBiomecanicFunctionDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			singleton = new CompatibleBiomecanicFunctionDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	/**
	 * Instantiates a new compatible biomecanic function dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private CompatibleBiomecanicFunctionDaoImpl(DaoFactory daoFactory) {
		super(daoFactory);
		this.setADbName("BiomecanicFunction");
		this.setBDbName("Exercice");
		this.setAIdLabel("id_biomecanic_function");
		this.setBIdLabel("id_exercice");
		this.setDbName("CompatibleBiomecanicFunction");
	}

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Exercice> getDisponbilities(Integer id_biomecanicFunction) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getBList(id_biomecanicFunction);
		List<Exercice> disponibilities = new ArrayList<>();
		
		for(Map<String, String> value : values) {
			Exercice d = BObjectConstructor(value);
			disponibilities.add(d);
		}
		return disponibilities;
	}

	/**
	 * Gets the biomecanic functions.
	 *
	 * @param id_exercice the id exercice
	 * @return the biomecanic functions
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<BiomecanicFunction> getBiomecanicFunctions(Integer id_exercice) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getAList(id_exercice);
		List<BiomecanicFunction> biomecanicFunctions = new ArrayList<>();
		
		for(Map<String, String> value : values) {
			BiomecanicFunction s = AObjectConstructor(value);
			biomecanicFunctions.add(s);
		}
		return biomecanicFunctions;
	}

	/**
	 * Adds the compatible exercice.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @param id_exercice the id exercice
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	@Override
	public void addCompatibleExercice(Integer id_biomecanicFunction, Integer id_exercice) throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.add(id_biomecanicFunction, id_exercice);
	}

	/**
	 * Delete compatible exercice.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @param id_exercice the id exercice
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	@Override
	public void deleteCompatibleExercice(Integer id_biomecanicFunction, Integer id_exercice) throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.delete(id_biomecanicFunction, id_exercice);
	}

	/**
	 * A object constructor.
	 *
	 * @param valuesMap the values map
	 * @return the biomecanic function
	 */
	@Override
	BiomecanicFunction AObjectConstructor(Map<String, String> valuesMap) {
		BiomecanicFunction biomecanicFunction = new BiomecanicFunction();
		biomecanicFunction.setName(valuesMap.get("name"));
		biomecanicFunction.setIdBiomecanicFunction(Integer.parseInt(valuesMap.get("id_biomecanic_function")));
		return biomecanicFunction;
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
		valuesMap.put("id_biomecanic_function", results.getString("id_biomecanic_function"));
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
