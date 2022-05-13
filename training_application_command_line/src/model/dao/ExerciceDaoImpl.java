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
import model.objects.TrainingComponent;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class ExerciceDaoImpl.
 *
 * @author Vincednt Mastain
 * @version 1.0
 */
public class ExerciceDaoImpl extends BasicRequestsDao implements ExerciceDao {

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
			Exercice exercice = (Exercice) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String, String>();
			mapValues.put("id_exercice", exercice.getIdExercice().toString());
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
			Exercice exercice = (Exercice) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String, String>();
			mapValues.put("id_exercice", exercice.getIdExercice().toString());
			mapValues.put("name", exercice.getName());
			mapValues.put("description", exercice.getDescription());
			return mapValues;
		}
	}

	/** The singleton. */
	private static ExerciceDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the exercice dao impl
	 */
	public static ExerciceDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			singleton = new ExerciceDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new exercice dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private ExerciceDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Exercice");
		this.setIdLabel("id_exercice");
	}

	/**
	 * Adds the exercice.
	 *
	 * @param exercice the exercice
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addExercice(Exercice exercice) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(exercice));
	}

	/**
	 * Delete exercice.
	 *
	 * @param exercice the exercice
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteExercice(Exercice exercice) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(exercice));
	}

	/**
	 * Gets the all exercice.
	 *
	 * @return the all exercice
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Exercice> getAllExercice() throws EmptyResultsQueryException {
		List<Exercice> exerciceList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for (Map<String, String> valueMap : results) {
			Exercice exercice = new Exercice();
			this.objectConstructor(valueMap, exercice);
			exerciceList.add(exercice);
		}
		return exerciceList;
	}

	/**
	 * Gets the exercice by id.
	 *
	 * @param id_exercice the id exercice
	 * @return the exercice by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Exercice getExerciceById(Integer id_exercice) throws EmptyResultsQueryException {
		Exercice exercice = new Exercice();
		this.<Exercice>getById(id_exercice, exercice);
		return exercice;
	}

	/**
	 * Gets the exercice by name.
	 *
	 * @param name the name
	 * @return the exercice by name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Exercice getExerciceByName(String name) throws EmptyResultsQueryException {
		Map<String, String> getMap = new HashMap<>();
		getMap.put("name", name);

		ArrayList<Map<String, String>> results = this.get(getMap);
		Iterator<Map<String, String>> iterator = results.iterator();

		Exercice exercice = new Exercice();
		this.objectConstructor(iterator.next(), exercice);
		return exercice;
	}

	/**
	 * Gets the first exercice.
	 *
	 * @return the first exercice
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Exercice getFirstExercice() throws EmptyResultsQueryException {
		Exercice exercice = new Exercice();
		this.<Exercice>getFirst(exercice);
		return exercice;
	}

	/**
	 * Gets the training component exercice list.
	 *
	 * @param trainingComponent the training component
	 * @param user              the user
	 * @return the training component exercice list
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void getTrainingComponentExerciceList(TrainingComponent trainingComponent, User user)
			throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;

		try {
			String sqlRequest;

			sqlRequest = "SELECT e.* FROM Exercice e, ExerciceType et, ExerciceTyping etg, CompatibleEquipment ce\n"
					+ "WHERE e.id_exercice = etg.id_exercice\n" + "AND et.id_exercice_type = etg.id_exercice_type\n"
					+ "AND et.id_exercice_type = " + trainingComponent.getIdExerciceType() + "\n"
					+ "AND ce.id_exercice = e.id_exercice\n"
					+ "AND ce.id_equipment in (SELECT eq.id_equipment FROM HasEquipment he, Equipment eq\n"
					+ "    WHERE he.id_equipment = eq.id_equipment\n" + "    AND he.id_user = " + user.getIdUser()
					+ ")\n" + "GROUP BY e.id_exercice;";

			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			results = preparedStatement.executeQuery();

			boolean empty = true;
			List<Exercice> exerciceList = new ArrayList<>();
			while (results.next()) {
				Exercice exercice = new Exercice();
				this.objectConstructor(this.setMapFromResultSet(results), exercice);
				exerciceList.add(exercice);
				empty = false;
			}

			if (empty) {
				throw new EmptyResultsQueryException();
			}
			trainingComponent.setExercicesList(exerciceList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		((Exercice) dataBaseObject).setName(mapValues.get("name"));
		((Exercice) dataBaseObject).setDescription(mapValues.get("description"));
		((Exercice) dataBaseObject).setIdExercice(Integer.parseInt(mapValues.get("id_exercice")));
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
		valuesMap.put("id_exercice", results.getString("id_exercice"));
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("description", results.getString("description"));
		return valuesMap;
	}

	/**
	 * Update exercice.
	 *
	 * @param exercice the exercice
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void updateExercice(Exercice exercice) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(exercice), keysMap.getMapOfValues(exercice));
	}

}
