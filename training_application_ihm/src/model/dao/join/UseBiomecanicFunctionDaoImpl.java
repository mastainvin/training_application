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
import model.objects.BiomecanicFunction;
import model.objects.BiomecanicFunctionList;
import model.objects.exceptions.EmptyResultsQueryException;


/**
 * The Class UseBiomecanicFunctionDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class UseBiomecanicFunctionDaoImpl extends JoinDao<BiomecanicFunction, BiomecanicFunctionList>
		implements UseBiomecanicFunctionDao {

	/** The singleton. */
	static private UseBiomecanicFunctionDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the use biomecanic function dao impl
	 */
	public static UseBiomecanicFunctionDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			singleton = new UseBiomecanicFunctionDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new use biomecanic function dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private UseBiomecanicFunctionDaoImpl(DaoFactory daoFactory) {
		super(daoFactory);
		this.setADbName("BiomecanicFunction");
		this.setBDbName("BiomecanicFunctionList");
		this.setAIdLabel("id_biomecanic_function");
		this.setBIdLabel("id_biomecanic_function_list");
		this.setDbName("UseBiomecanicFunction");
	}

	/**
	 * Adds the compatible biomecanic function list.
	 *
	 * @param id_biomecanicFunction     the id biomecanic function
	 * @param id_biomecanicFunctionList the id biomecanic function list
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	@Override
	public void addCompatibleBiomecanicFunctionList(Integer id_biomecanicFunction, Integer id_biomecanicFunctionList)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.add(id_biomecanicFunction, id_biomecanicFunctionList);
	}

	/**
	 * Delete compatible biomecanic function list.
	 *
	 * @param id_biomecanicFunction     the id biomecanic function
	 * @param id_biomecanicFunctionList the id biomecanic function list
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	@Override
	public void deleteCompatibleBiomecanicFunctionList(Integer id_biomecanicFunction, Integer id_biomecanicFunctionList)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.delete(id_biomecanicFunction, id_biomecanicFunctionList);
	}

	/**
	 * Gets the biomecanic functions.
	 *
	 * @param id_biomecanicFunctionList the id biomecanic function list
	 * @return the biomecanic functions
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<BiomecanicFunction> getBiomecanicFunctions(Integer id_biomecanicFunctionList)
			throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getAList(id_biomecanicFunctionList);
		List<BiomecanicFunction> biomecanicFunctions = new ArrayList<>();

		for (Map<String, String> value : values) {
			BiomecanicFunction s = AObjectConstructor(value);
			biomecanicFunctions.add(s);
		}
		return biomecanicFunctions;
	}

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<BiomecanicFunctionList> getDisponbilities(Integer id_biomecanicFunction)
			throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getBList(id_biomecanicFunction);
		List<BiomecanicFunctionList> disponibilities = new ArrayList<>();

		for (Map<String, String> value : values) {
			BiomecanicFunctionList d = BObjectConstructor(value);
			disponibilities.add(d);
		}
		return disponibilities;
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
	 * @return the biomecanic function list
	 */
	@Override
	BiomecanicFunctionList BObjectConstructor(Map<String, String> valuesMap) {
		BiomecanicFunctionList biomecanicFunctionList = new BiomecanicFunctionList();
		biomecanicFunctionList
				.setIdBiomecanicFunctionList(Integer.parseInt(valuesMap.get("id_biomecanic_function_list")));
		return biomecanicFunctionList;
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
		valuesMap.put("id_biomecanic_function_list", results.getString("id_biomecanic_function_list"));
		return valuesMap;
	}

}
