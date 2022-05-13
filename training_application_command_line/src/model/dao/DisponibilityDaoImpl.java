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

import model.objects.Disponibility;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class DisponibilityDaoImpl.
 *
 * @author Vincednt Mastain
 * @version 1.0
 */
public class DisponibilityDaoImpl extends BasicRequestsDao implements DisponibilityDao {

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
			Disponibility disponibility = (Disponibility) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String, String>();
			mapValues.put("duration", disponibility.getDuration().toString());
			mapValues.put("layout", disponibility.getLayout().toString());
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
			Disponibility disponibility = (Disponibility) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String, String>();
			mapValues.put("duration", disponibility.getDuration().toString());
			mapValues.put("layout", disponibility.getLayout().toString());
			mapValues.put("id_disponibility", disponibility.getIdDisponibility().toString());
			return mapValues;
		}
	}

	/** The singleton. */
	static DisponibilityDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the disponibility dao impl
	 */
	public static DisponibilityDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			return new DisponibilityDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new disponibility dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private DisponibilityDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Disponibility");
	}

	/**
	 * Adds the disponibility.
	 *
	 * @param disponibility the disponibility
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addDisponibility(Disponibility disponibility) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(disponibility));
	}

	/**
	 * Delete disponibility.
	 *
	 * @param disponibility the disponibility
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteDisponibility(Disponibility disponibility) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(disponibility));
	}

	/**
	 * Gets the all disponibility.
	 *
	 * @return the all disponibility
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Disponibility> getAllDisponibility() throws EmptyResultsQueryException {
		List<Disponibility> disponibilityList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for (Map<String, String> valueMap : results) {
			Disponibility disponibility = new Disponibility();
			this.objectConstructor(valueMap, disponibility);
			disponibilityList.add(disponibility);
		}
		return disponibilityList;
	}

	/**
	 * Gets the disponibility.
	 *
	 * @param duration the duration
	 * @param layout   the layout
	 * @return the disponibility
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Disponibility getDisponibility(Integer duration, Integer layout) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		Disponibility disponibility = new Disponibility();
		disponibility.setDuration(duration);
		disponibility.setLayout(layout);
		ArrayList<Map<String, String>> results = this.get(valuesMap.getMapOfValues(disponibility));
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), disponibility);
		return disponibility;
	}

	/**
	 * Gets the disponibility by id.
	 *
	 * @param id_disponibility the id disponibility
	 * @return the disponibility by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Disponibility getDisponibilityById(Integer id_disponibility) throws EmptyResultsQueryException {
		Disponibility disponibility = new Disponibility();
		this.<Disponibility>getById(id_disponibility, disponibility);
		return disponibility;
	}

	/**
	 * Gets the first disponibility.
	 *
	 * @return the first disponibility
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Disponibility getFirstDisponibility() throws EmptyResultsQueryException {
		Disponibility disponibility = new Disponibility();
		this.<Disponibility>getFirst(disponibility);
		return disponibility;
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
		((Disponibility) dataBaseObject).setDuration(Integer.parseInt(mapValues.get("duration")));
		((Disponibility) dataBaseObject).setLayout(Integer.parseInt(mapValues.get("layout")));
		((Disponibility) dataBaseObject).setIdDisponibility(Integer.parseInt(mapValues.get("id_disponibility")));
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
		valuesMap.put("duration", results.getString("duration"));
		valuesMap.put("layout", results.getString("layout"));
		valuesMap.put("id_disponibility", results.getString("id_disponibility"));
		return valuesMap;
	}

	/**
	 * Update disponibility.
	 *
	 * @param disponibility the disponibility
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void updateDisponibility(Disponibility disponibility)
			throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(disponibility), keysMap.getMapOfValues(disponibility));
	}

}
