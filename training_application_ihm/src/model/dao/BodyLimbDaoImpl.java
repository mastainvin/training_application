/**
 *
 */
package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.objects.BodyLimb;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

/**
 * The Class BodyLimbDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class BodyLimbDaoImpl extends BasicRequestsDao implements BodyLimbDao {

	/**
	 * The Class MapOfValuesGet.
	 */
	public class MapOfValuesGet implements ValuesMap {

		/**
		 * Gets the map of values.
		 *
		 * @param <DataBaseObject> the generic type
		 * @param dataBaseObject   the data base object
		 * @return the map of values
		 */
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			BodyLimb bodyLimb = (BodyLimb) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("id_BodyLimb", bodyLimb.getIdBodyLimb().toString());
			return mapValues;
		}
	}

	/**
	 * The Class MapOfValuesInsert.
	 */
	public class MapOfValuesInsert implements ValuesMap {

		/**
		 * Gets the map of values.
		 *
		 * @param <DataBaseObject> the generic type
		 * @param dataBaseObject   the data base object
		 * @return the map of values
		 */
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			BodyLimb bodyLimb = (BodyLimb) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("name", bodyLimb.getName());
			mapValues.put("lower", Integer.valueOf(bodyLimb.getLower() ? 1 : 0).toString());
			mapValues.put("upper", Integer.valueOf(bodyLimb.getUpper() ? 1 : 0).toString());
			mapValues.put("id_BodyLimb", bodyLimb.getIdBodyLimb().toString());
			return mapValues;
		}
	}

	/** The singleton. */
	static BodyLimbDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the body limb dao impl
	 */
	public static BodyLimbDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			return new BodyLimbDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new body limb dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private BodyLimbDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("BodyLimb");
		this.setIdLabel("id_BodyLimb");
	}

	/**
	 * Adds the body limb.
	 *
	 * @param bodyLimb the body limb
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addBodyLimb(BodyLimb bodyLimb) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(bodyLimb));
	}

	/**
	 * Delete body limb.
	 *
	 * @param bodyLimb the body limb
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteBodyLimb(BodyLimb bodyLimb) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(bodyLimb));
	}

	/**
	 * Gets the all body limb.
	 *
	 * @return the all body limb
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<BodyLimb> getAllBodyLimb() throws EmptyResultsQueryException {
		List<BodyLimb> bodyLimbList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for (Map<String, String> valueMap : results) {
			BodyLimb bodyLimb = new BodyLimb();
			bodyLimb.setName(valueMap.get("name"));
			bodyLimbList.add(bodyLimb);
		}
		return bodyLimbList;
	}

	/**
	 * Gets the body limb by id.
	 *
	 * @param id_bodyLimb the id body limb
	 * @return the body limb by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public BodyLimb getBodyLimbById(Integer id_bodyLimb) throws EmptyResultsQueryException {
		BodyLimb bodyLimb = new BodyLimb();
		this.<BodyLimb>getById(id_bodyLimb, bodyLimb);
		return bodyLimb;
	}

	/**
	 * Gets the body limb by name.
	 *
	 * @param name the name
	 * @return the body limb by name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public BodyLimb getBodyLimbByName(String name) throws EmptyResultsQueryException {
		Map<String, String> getMap = new HashMap<>();
		getMap.put("name", name);

		ArrayList<Map<String, String>> results = this.get(getMap);
		Iterator<Map<String, String>> iterator = results.iterator();

		BodyLimb bodyLimb = new BodyLimb();
		this.objectConstructor(iterator.next(), bodyLimb);
		return bodyLimb;
	}

	/**
	 * Gets the first body limb.
	 *
	 * @return the first body limb
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public BodyLimb getFirstBodyLimb() throws EmptyResultsQueryException {
		BodyLimb bodyLimb = new BodyLimb();
		this.<BodyLimb>getFirst(bodyLimb);
		return bodyLimb;
	}

	/**
	 * Update body limb.
	 *
	 * @param bodyLimb the body limb
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void updateBodyLimb(BodyLimb bodyLimb) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(bodyLimb), keysMap.getMapOfValues(bodyLimb));
	}

	/**
	 * Object constructor.
	 *
	 * @param <DataBaseObject> the generic type
	 * @param mapValues        the map values
	 * @param dataBaseObject   the data base object
	 */
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((BodyLimb) dataBaseObject).setName(mapValues.get("name"));
		((BodyLimb) dataBaseObject).setIdBodyLimb(Integer.parseInt(mapValues.get("id_BodyLimb")));
		((BodyLimb) dataBaseObject).setLower(Integer.parseInt(mapValues.get("lower")) == 1 ? true : false);
		((BodyLimb) dataBaseObject).setUpper(Integer.parseInt(mapValues.get("upper")) == 1 ? true : false);
	}

	/**
	 * Sets the map from result set.
	 *
	 * @param results the results
	 * @return the map
	 * @throws SQLException the SQL exception
	 */
	@Override
	Map<String, String> setMapFromResultSet(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("id_BodyLimb", results.getString("id_BodyLimb"));
		valuesMap.put("lower", results.getString("lower"));
		valuesMap.put("upper", results.getString("upper"));
		return valuesMap;
	}

}
