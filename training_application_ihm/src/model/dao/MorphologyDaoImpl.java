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

import model.objects.Exercice;
import model.objects.Morphology;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class MorphologyDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class MorphologyDaoImpl extends BasicRequestsDao implements MorphologyDao {

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
			Morphology morphology = (Morphology) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String, String>();
			mapValues.put("id_morphology", morphology.getIdMorphology().toString());
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
			Morphology morphology = (Morphology) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String, String>();
			mapValues.put("name", morphology.getName());
			mapValues.put("description", morphology.getDescription());
			mapValues.put("id_morphology", morphology.getIdMorphology().toString());
			return mapValues;
		}
	}

	/** The singleton. */
	static MorphologyDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the morphology dao impl
	 */
	public static MorphologyDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			return new MorphologyDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new morphology dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private MorphologyDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Morphology");
		this.setIdLabel("id_morphology");
	}

	/**
	 * Adds the morphology.
	 *
	 * @param morphology the morphology
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addMorphology(Morphology morphology) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(morphology));
	}

	/**
	 * Delete morphology.
	 *
	 * @param morphology the morphology
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteMorphology(Morphology morphology) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(morphology));
	}

	/**
	 * Gets the all morphology.
	 *
	 * @return the all morphology
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Morphology> getAllMorphology() throws EmptyResultsQueryException {
		List<Morphology> morphologyList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for (Map<String, String> valueMap : results) {
			Morphology morphology = new Morphology();
			morphology.setName(valueMap.get("name"));
			morphologyList.add(morphology);
		}
		return morphologyList;
	}

	/**
	 * Gets the exercice morphology.
	 *
	 * @param exercice the exercice
	 * @return the exercice morphology
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void getExerciceMorphology(Exercice exercice) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;

		try {
			String sqlRequest;

			sqlRequest = "SELECT m.* FROM Morphology m, CompatibleMorph cm\n"
					+ "WHERE m.id_morphology = cm.id_morphology\n" + "AND cm.id_exercice = " + exercice.getIdExercice()
					+ ";";

			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			results = preparedStatement.executeQuery();

			boolean empty = true;
			List<Morphology> morphologiesList = new ArrayList<>();
			while (results.next()) {
				Morphology morphology = new Morphology();
				this.objectConstructor(this.setMapFromResultSet(results), morphology);
				morphologiesList.add(morphology);
				empty = false;
			}

			if (empty) {
				throw new EmptyResultsQueryException();
			}
			exercice.setMorphologiesList(morphologiesList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the first morphology.
	 *
	 * @return the first morphology
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Morphology getFirstMorphology() throws EmptyResultsQueryException {
		Morphology morphology = new Morphology();
		this.<Morphology>getFirst(morphology);
		return morphology;
	}

	/**
	 * Gets the morphology by id.
	 *
	 * @param id_morphology the id morphology
	 * @return the morphology by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Morphology getMorphologyById(Integer id_morphology) throws EmptyResultsQueryException {
		Morphology morphology = new Morphology();
		this.<Morphology>getById(id_morphology, morphology);
		return morphology;
	}

	/**
	 * Gets the morphology by name.
	 *
	 * @param name the name
	 * @return the morphology by name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Morphology getMorphologyByName(String name) throws EmptyResultsQueryException {
		Map<String, String> getMap = new HashMap<>();
		getMap.put("name", name);

		ArrayList<Map<String, String>> results = this.get(getMap);
		Iterator<Map<String, String>> iterator = results.iterator();

		Morphology morphology = new Morphology();
		this.objectConstructor(iterator.next(), morphology);
		return morphology;
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
		((Morphology) dataBaseObject).setName(mapValues.get("name"));
		((Morphology) dataBaseObject).setDescription(mapValues.get("description"));
		((Morphology) dataBaseObject).setIdMorphology(Integer.parseInt(mapValues.get("id_morphology")));
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
		valuesMap.put("description", results.getString("description"));
		valuesMap.put("id_morphology", results.getString("id_morphology"));
		return valuesMap;
	}

	/**
	 * Update morphology.
	 *
	 * @param morphology the morphology
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void updateMorphology(Morphology morphology) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(morphology), keysMap.getMapOfValues(morphology));
	}

}
