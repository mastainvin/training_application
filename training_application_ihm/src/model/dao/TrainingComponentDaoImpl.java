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

import model.objects.Training;
import model.objects.TrainingComponent;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;


/**
 * The Class TrainingComponentDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class TrainingComponentDaoImpl extends BasicRequestsDao implements TrainingComponentDao {

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
			Map<String, String> mapValues = new HashMap<>();
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
			TrainingComponent trainingComponent = (TrainingComponent) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("layout", trainingComponent.getLayout().toString());
			mapValues.put("is_super_set", (trainingComponent.getIsSuperSet() ? "1" : "0"));
			mapValues.put("id_training", trainingComponent.getIdTraining().toString());
			try {
				mapValues.put("id_biomecanic_function_list",
						trainingComponent.getIdBiomecanicFunctionList().toString());
			} catch (NullPointerException e) {
			}

			try {
				mapValues.put("id_training_method", trainingComponent.getIdTrainingMethod().toString());
			} catch (NullPointerException e) {
			}

			try {
				mapValues.put("id_type", trainingComponent.getIdExerciseType().toString());
			} catch (NullPointerException e) {
			}
			return mapValues;
		}
	}

	/** The singleton. */
	static TrainingComponentDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the training component dao impl
	 */
	public static TrainingComponentDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			return new TrainingComponentDaoImpl(daoFactory);
		}
		return singleton;
	}

	/** The exercise type dao. */
	ExerciseTypeDao exerciseTypeDao;

	/** The training dao. */
	TrainingDao trainingDao;

	/** The training method dao. */
	TrainingMethodDao trainingMethodDao;

	/**
	 * Instantiates a new training component dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private TrainingComponentDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("ComposeTraining");
		this.exerciseTypeDao = daoFactory.getExerciseTypeDao();
		this.trainingMethodDao = daoFactory.getTrainingMethodDao();
		this.trainingDao = daoFactory.getTrainingDao();
	}

	/**
	 * Adds the training component.
	 *
	 * @param trainingComponent the training component
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addTrainingComponent(TrainingComponent trainingComponent) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		Map<String, String> getMap = valuesMap.getMapOfValues(trainingComponent);
		this.add(getMap);
	}

	/**
	 * Delete training component.
	 *
	 * @param trainingComponent the training component
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteTrainingComponent(TrainingComponent trainingComponent) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		Map<String, String> insertMap = valuesMap.getMapOfValues(trainingComponent);
		this.delete(insertMap);
	}

	/**
	 * Gets the all training component.
	 *
	 * @return the all training component
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<TrainingComponent> getAllTrainingComponent() throws EmptyResultsQueryException {
		List<TrainingComponent> trainingComponentList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for (Map<String, String> valueMap : results) {
			TrainingComponent trainingComponent = new TrainingComponent();
			this.objectConstructor(valueMap, trainingComponent);
			trainingComponentList.add(trainingComponent);
		}
		return trainingComponentList;
	}

	/**
	 * Gets the first training component.
	 *
	 * @return the first training component
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public TrainingComponent getFirstTrainingComponent() throws EmptyResultsQueryException {
		TrainingComponent trainingComponent = new TrainingComponent();
		this.<TrainingComponent>getFirst(trainingComponent);
		return trainingComponent;
	}

	/**
	 * Gets the training component.
	 *
	 * @param training the training
	 * @param layout   the layout
	 * @return the training component
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public TrainingComponent getTrainingComponent(Training training, Integer layout) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		TrainingComponent trainingComponent = new TrainingComponent();
		trainingComponent.setLayout(layout);
		Map<String, String> values = valuesMapGet.getMapOfValues(trainingComponent);
		values.put("id_training", training.getIdTraining().toString());
		values.put("layout", layout.toString());
		ArrayList<Map<String, String>> results = this.get(values);
		Iterator<Map<String, String>> iterator = results.iterator();

		this.objectConstructor(iterator.next(), trainingComponent);
		return trainingComponent;
	}

	/**
	 * Gets the training component done list.
	 *
	 * @param user the user
	 * @return the training component done list
	 */
	@Override
	public List<TrainingComponent> getTrainingComponentDoneList(User user) {
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//	    ResultSet results = null;
//
//	    try {
//	    	String sqlRequest;
//
//    		sqlRequest = "SELECT tc.* FROM Training t, ComposeTraining tc\n"
//    				+ "WHERE tc.id_training = t.id_training\n"
//    				+ "AND t.id_training = " + training.getIdTraining() + ";";
//
//
//
//	        connection = this.getDaoFactory().getConnection();
//            preparedStatement = connection.prepareStatement(sqlRequest);
//            results = preparedStatement.executeQuery();
//
//            boolean empty = true;
//            List<TrainingComponent> trainingComponentList = new ArrayList<>();
//            while(results.next()) {
//            	TrainingComponent trainingComponent = new TrainingComponent();
//            	this.objectConstructor( this.setMapFromResultSet(results), trainingComponent);
//            	trainingComponentList.add(trainingComponent);
//            	empty = false;
//            }
//
//            if(empty) {
//            	throw new EmptyResultsQueryException();
//            }
//            trainingComponentList.sort(null);
//            training.setTrainingComponentList(trainingComponentList);
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
		return null;
	}

	/**
	 * Gets the training training component list.
	 *
	 * @param training the training
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void getTrainingTrainingComponentList(Training training) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;

		try {
			String sqlRequest;
			try {
				sqlRequest = "SELECT tc.* FROM Training t, ComposeTraining tc "
						+ "WHERE tc.id_training = t.id_training " + "AND t.id_training = " + training.getIdTraining()
						+ ";";
			} catch (NullPointerException e) {
				sqlRequest = "SELECT * FROM " + this.getDbName() + ";";
			}

			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			results = preparedStatement.executeQuery();

			boolean empty = true;
			List<TrainingComponent> trainingComponentList = new ArrayList<>();
			while (results.next()) {
				TrainingComponent trainingComponent = new TrainingComponent();
				this.objectConstructor(this.setMapFromResultSet(results), trainingComponent);
				trainingComponentList.add(trainingComponent);
				empty = false;
			}

			if (empty) {
				throw new EmptyResultsQueryException();
			}
			trainingComponentList.sort(null);
			training.setTrainingComponentList(trainingComponentList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update training component.
	 *
	 * @param trainingComponent the training component
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void updateTrainingComponent(TrainingComponent trainingComponent)
			throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(trainingComponent), keysMap.getMapOfValues(trainingComponent));
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
		((TrainingComponent) dataBaseObject).setLayout(Integer.parseInt(mapValues.get("layout")));
		((TrainingComponent) dataBaseObject)
				.setIsSuperSet(Integer.parseInt(mapValues.get("is_super_set")) == 1 ? true : false);
		((TrainingComponent) dataBaseObject).setIdTraining(Integer.parseInt(mapValues.get("id_training")));

		try {
			((TrainingComponent) dataBaseObject)
					.setIdBiomecanicFunctionList(Integer.parseInt(mapValues.get("id_biomecanic_function_list")));
		} catch (NumberFormatException e) {
		}

		try {
			((TrainingComponent) dataBaseObject).setIdExerciseType(Integer.parseInt(mapValues.get("id_type")));
		} catch (NumberFormatException e) {
		}

		try {
			((TrainingComponent) dataBaseObject)
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
		valuesMap.put("id_training", results.getString("id_training"));
		valuesMap.put("id_exercise_type", results.getString("id_type"));
		valuesMap.put("id_training_method", results.getString("id_training_method"));
		valuesMap.put("id_biomecanic_function_list", results.getString("id_biomecanic_function_list"));
		valuesMap.put("layout", results.getString("layout"));
		valuesMap.put("is_super_set", results.getString("is_super_set"));
		valuesMap.put("id_type", results.getString("id_type"));
		return valuesMap;
	}

}
