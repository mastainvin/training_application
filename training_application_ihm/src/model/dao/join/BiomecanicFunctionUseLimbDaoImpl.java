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
import model.objects.BodyLimb;
import model.objects.exceptions.EmptyResultsQueryException;

// TODO: Auto-generated Javadoc
/**
 * The Class BiomecanicFunctionUseLimbDaoImpl.
 *
 * @author cytech
 */
public class BiomecanicFunctionUseLimbDaoImpl extends JoinDao<BiomecanicFunction, BodyLimb>
		implements BiomecanicFunctionUseLimbDao {

	/** The singleton. */
	static private BiomecanicFunctionUseLimbDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the biomecanic function use limb dao impl
	 */
	public static BiomecanicFunctionUseLimbDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			singleton = new BiomecanicFunctionUseLimbDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new biomecanic function use limb dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private BiomecanicFunctionUseLimbDaoImpl(DaoFactory daoFactory) {
		super(daoFactory);
		this.setADbName("BiomecanicFunction");
		this.setBDbName("BodyLimb");
		this.setAIdLabel("id_biomecanic_function");
		this.setBIdLabel("id_BodyLimb");
		this.setDbName("biomecanicFunctionUseLimb");
	}

	/**
	 * Adds the compatible body limb.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @param id_bodyLimb           the id body limb
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	@Override
	public void addCompatibleBodyLimb(Integer id_biomecanicFunction, Integer id_bodyLimb)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.add(id_biomecanicFunction, id_bodyLimb);
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
	 * @return the body limb
	 */
	@Override
	BodyLimb BObjectConstructor(Map<String, String> valuesMap) {
		BodyLimb bodyLimb = new BodyLimb();
		bodyLimb.setName(valuesMap.get("name"));
		bodyLimb.setIdBodyLimb(Integer.parseInt(valuesMap.get("id_BodyLimb")));
		bodyLimb.setLower(valuesMap.get("lower") == "1" ? true : false);
		bodyLimb.setUpper(valuesMap.get("upper") == "1" ? true : false);

		return bodyLimb;
	}

	/**
	 * Delete compatible body limb.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @param id_bodyLimb           the id body limb
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	@Override
	public void deleteCompatibleBodyLimb(Integer id_biomecanicFunction, Integer id_bodyLimb)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.delete(id_biomecanicFunction, id_bodyLimb);
	}

	/**
	 * Gets the biomecanic functions.
	 *
	 * @param id_bodyLimb the id body limb
	 * @return the biomecanic functions
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<BiomecanicFunction> getBiomecanicFunctions(Integer id_bodyLimb) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getAList(id_bodyLimb);
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
	public List<BodyLimb> getDisponbilities(Integer id_biomecanicFunction) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getBList(id_biomecanicFunction);
		List<BodyLimb> disponibilities = new ArrayList<>();

		for (Map<String, String> value : values) {
			BodyLimb d = BObjectConstructor(value);
			disponibilities.add(d);
		}
		return disponibilities;
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
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("id_BodyLimb", results.getString("id_BodyLimb"));
		valuesMap.put("lower", results.getString("lower"));
		valuesMap.put("upper", results.getString("upper"));
		return valuesMap;
	}

}
