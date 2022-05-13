/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.objects.SerieRepartition;
import model.objects.TrainingMethod;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class SerieRepartitionDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class SerieRepartitionDaoImpl extends BasicRequestsDao implements SerieRepartitionDao {

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
			SerieRepartition serieRepartition = (SerieRepartition) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String, String>();
			mapValues.put("id_serie_repartition", serieRepartition.getIdSerieRepartition().toString());
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
			SerieRepartition serieRepartition = (SerieRepartition) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String, String>();

			mapValues.put("id_serie_repartition", serieRepartition.getIdSerieRepartition().toString());
			mapValues.put("nb_rep", serieRepartition.getNbRep().toString());
			mapValues.put("weight", serieRepartition.getWeight().toString());
			mapValues.put("layout", serieRepartition.getLayout().toString());
			mapValues.put("rest_duration", serieRepartition.getRestDuration().toString());
			try {
				mapValues.put("id_training_method", serieRepartition.getIdTrainingMethod().toString());
			} catch (NullPointerException e) {
			}

			return mapValues;
		}
	}

	/** The singleton. */
	static SerieRepartitionDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the serieRepartition dao impl
	 */
	public static SerieRepartitionDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			return new SerieRepartitionDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new serieRepartition dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private SerieRepartitionDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("SerieRepartition");
		this.setIdLabel("id_serie_repartition");
	}

	/**
	 * Adds the serieRepartition.
	 *
	 * @param serieRepartition the serieRepartition
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addSerieRepartition(SerieRepartition serieRepartition) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(serieRepartition));
	}

	/**
	 * Delete serieRepartition.
	 *
	 * @param serieRepartition the serieRepartition
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteSerieRepartition(SerieRepartition serieRepartition) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(serieRepartition));
	}

	/**
	 * Gets the all serieRepartition.
	 *
	 * @return the all serieRepartition
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<SerieRepartition> getAllSerieRepartition() throws EmptyResultsQueryException {
		List<SerieRepartition> serieRepartitionList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for (Map<String, String> valueMap : results) {
			SerieRepartition serieRepartition = new SerieRepartition();
			this.objectConstructor(valueMap, serieRepartition);
			serieRepartitionList.add(serieRepartition);
		}
		return serieRepartitionList;
	}

	/**
	 * Gets the first serieRepartition.
	 *
	 * @return the first serieRepartition
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public SerieRepartition getFirstSerieRepartition() throws EmptyResultsQueryException {
		SerieRepartition serieRepartition = new SerieRepartition();
		this.<SerieRepartition>getFirst(serieRepartition);
		return serieRepartition;
	}

	/**
	 * Gets the serie reparition from training method.
	 *
	 * @param trainingMethod the training method
	 * @return the serie reparition from training method
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void getSerieReparitionFromTrainingMethod(TrainingMethod trainingMethod) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;

		try {
			String sqlRequest;
			sqlRequest = "SELECT * FROM SerieRepartition\n" + "WHERE id_training_method = "
					+ trainingMethod.getIdTrainingMethod() + ";";

			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			results = preparedStatement.executeQuery();

			boolean empty = true;
			List<SerieRepartition> serieReparitionlist = new ArrayList<>();
			while (results.next()) {
				SerieRepartition serieRepartition = new SerieRepartition();
				this.objectConstructor(this.setMapFromResultSet(results), serieRepartition);
				serieReparitionlist.add(serieRepartition);
				empty = false;
			}

			if (empty) {
				throw new EmptyResultsQueryException();
			}
			serieReparitionlist.sort(null);
			trainingMethod.setSerieRepartition(serieReparitionlist);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the serieRepartition by id.
	 *
	 * @param id_serieRepartition the id serieRepartition
	 * @return the serieRepartition by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public SerieRepartition getSerieRepartitionById(Integer id_serieRepartition) throws EmptyResultsQueryException {
		SerieRepartition serieRepartition = new SerieRepartition();
		this.<SerieRepartition>getById(id_serieRepartition, serieRepartition);
		return serieRepartition;
	}

	/**
	 * Gets the serieRepartition by name.
	 *
	 * @param name the name
	 * @return the serieRepartition by name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public SerieRepartition getSerieRepartitionByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		Map<String, String> getMap = valuesMapGet.getMapOfValues(null);
		getMap.put("name", name);

		ArrayList<Map<String, String>> results = this.get(getMap);
		Iterator<Map<String, String>> iterator = results.iterator();

		SerieRepartition serieRepartition = new SerieRepartition();
		this.objectConstructor(iterator.next(), serieRepartition);
		return serieRepartition;
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
		((SerieRepartition) dataBaseObject)
				.setIdSerieRepartition(Integer.parseInt(mapValues.get("id_serie_repartition")));
		((SerieRepartition) dataBaseObject).setNbRep(Integer.parseInt(mapValues.get("nb_rep")));
		((SerieRepartition) dataBaseObject).setWeight(Integer.parseInt(mapValues.get("weight")));
		((SerieRepartition) dataBaseObject).setLayout(Integer.parseInt(mapValues.get("layout")));
		((SerieRepartition) dataBaseObject).setRestDuration(Integer.parseInt(mapValues.get("rest_duration")));
		try {
			((SerieRepartition) dataBaseObject)
					.setIdTrainingMethod(Integer.parseInt(mapValues.get("id_training_method")));
		} catch (NumberFormatException e) {
		}
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
		valuesMap.put("nb_rep", results.getString("nb_rep"));
		valuesMap.put("weight", results.getString("weight"));
		valuesMap.put("layout", results.getString("layout"));
		valuesMap.put("rest_duration", results.getString("rest_duration"));
		valuesMap.put("id_training_method", results.getString("id_training_method"));
		valuesMap.put("id_serie_repartition", results.getString("id_serie_repartition"));
		return valuesMap;
	}

	/**
	 * Update serieRepartition.
	 *
	 * @param serieRepartition the serieRepartition
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void updateSerieRepartition(SerieRepartition serieRepartition)
			throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(serieRepartition), keysMap.getMapOfValues(serieRepartition));
	}

}
