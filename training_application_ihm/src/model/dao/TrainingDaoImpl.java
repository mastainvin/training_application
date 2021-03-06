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

import model.objects.Structure;
import model.objects.Training;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

/**
 * The Class TrainingDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class TrainingDaoImpl extends BasicRequestsDao implements TrainingDao {

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
			Training training = (Training) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("name", training.getName());
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
			Training training = (Training) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("name", training.getName());
			mapValues.put("description", training.getDescription());
			mapValues.put("layout", training.getLayout().toString());
			mapValues.put("duration", training.getDuration().toString());
			mapValues.put("id_training", training.getIdTraining().toString());

			try {
				mapValues.put("id_training_type", training.getIdTrainingType().toString());
			} catch (NullPointerException e) {
			}

			try {
				mapValues.put("id_structure", training.getIdStructure().toString());
			} catch (NullPointerException e) {
			}

			return mapValues;
		}
	}

	/** The singleton. */
	static TrainingDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the training dao impl
	 */
	public static TrainingDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			return new TrainingDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new training dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private TrainingDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Training");
		this.setIdLabel("id_training");
	}

	/**
	 * Adds the training.
	 *
	 * @param training the training
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addTraining(Training training) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		Map<String, String> getMap = valuesMap.getMapOfValues(training);
		this.add(getMap);
	}

	/**
	 * Delete training.
	 *
	 * @param training the training
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteTraining(Training training) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(training));
	}

	/**
	 * Gets the all training.
	 *
	 * @return the all training
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Training> getAllTraining() throws EmptyResultsQueryException {
		List<Training> trainingList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for (Map<String, String> valueMap : results) {
			Training training = new Training();
			this.objectConstructor(valueMap, training);
			trainingList.add(training);
		}
		return trainingList;
	}

	/**
	 * Gets the first training.
	 *
	 * @return the first training
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Training getFirstTraining() throws EmptyResultsQueryException {
		Training training = new Training();
		this.<Training>getFirst(training);
		return training;
	}

	/**
	 * Gets the training by id.
	 *
	 * @param id_training the id training
	 * @return the training by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Training getTrainingById(Integer id_training) throws EmptyResultsQueryException {
		Training training = new Training();
		this.<Training>getById(id_training, training);
		return training;
	}

	/**
	 * Gets the training by name.
	 *
	 * @param name the name
	 * @return the training by name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Training getTrainingByName(String name) throws EmptyResultsQueryException {
		Map<String, String> getMap = new HashMap<>();
		getMap.put("name", name);

		ArrayList<Map<String, String>> results = this.get(getMap);
		Iterator<Map<String, String>> iterator = results.iterator();

		Training training = new Training();
		this.objectConstructor(iterator.next(), training);
		return training;
	}

	/**
	 * Gets the user structure.
	 *
	 * @param user the user
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void getUserStructure(User user) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;

		try {
			String sqlRequest;
			sqlRequest = "SELECT t.* FROM Training t, Structure s, Disponibility d, User u, CompatibleDisponibility cd, CanTrainOn cto\n"
					+ "WHERE t.id_structure = s.id_structure\n" + "AND cd.id_structure = s.id_structure\n"
					+ "AND cd.id_disponibility = d.id_disponibility\n" + "AND cto.id_user = u.id_user\n"
					+ "AND cto.id_disponibility = d.id_disponibility\n" + "AND s.id_goal = u.id_goal\n"
					+ "AND d.layout = t.layout\n" + "AND u.id_user = " + user.getIdUser() + ";";

			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			results = preparedStatement.executeQuery();
			Structure structure = new Structure();
			structure.setTrainingsList(new ArrayList<>());
			boolean empty = true;

			while (results.next()) {
				Training training = new Training();
				this.objectConstructor(this.setMapFromResultSet(results), training);
				structure.getTrainingsList().add(training);
				empty = false;
			}
			if (empty) {
				throw new EmptyResultsQueryException();
			}
			structure.getTrainingsList().sort(null);
			user.setStructure(structure);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Update training.
	 *
	 * @param training the training
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void updateTraining(Training training) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(training), keysMap.getMapOfValues(training));
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
		((Training) dataBaseObject).setName(mapValues.get("name"));
		((Training) dataBaseObject).setDescription(mapValues.get("description"));
		((Training) dataBaseObject).setLayout(Integer.parseInt(mapValues.get("layout")));
		((Training) dataBaseObject).setDuration(Integer.parseInt(mapValues.get("duration")));
		((Training) dataBaseObject).setIdTraining(Integer.parseInt(mapValues.get("id_training")));

		try {
			((Training) dataBaseObject).setIdStructure(Integer.parseInt(mapValues.get("id_structure")));
		} catch (NumberFormatException e) {
		}

		try {
			((Training) dataBaseObject).setIdTrainingType(Integer.parseInt(mapValues.get("id_training_type")));
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
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("description", results.getString("description"));
		valuesMap.put("id_training_type", results.getString("id_training_type"));
		valuesMap.put("layout", results.getString("layout"));
		valuesMap.put("duration", results.getString("duration"));
		valuesMap.put("id_structure", results.getString("id_structure"));
		valuesMap.put("id_training", results.getString("id_training"));
		return valuesMap;
	}

}
