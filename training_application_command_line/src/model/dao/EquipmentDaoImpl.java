/**
 * 
 */
package model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.objects.Equipment;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class EquipmentDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class EquipmentDaoImpl extends BasicRequestsDao implements EquipmentDao {

	/** The singleton. */
	static EquipmentDaoImpl singleton = null;
	
	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the equipment dao impl
	 */
	public static EquipmentDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new EquipmentDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	/**
	 * Instantiates a new equipment dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private EquipmentDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Equipment");
		this.setIdLabel("id_equipment");
	}
	

	/**
	 * Gets the equipment by id.
	 *
	 * @param id_equipment the id equipment
	 * @return the equipment by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Equipment getEquipmentById(Integer id_equipment) throws EmptyResultsQueryException {
		Equipment equipment = new Equipment();
		this.<Equipment>getById(id_equipment, equipment);
		return equipment;
	}

	/**
	 * Gets the equipment by name.
	 *
	 * @param name the name
	 * @return the equipment by name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Equipment getEquipmentByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		Map<String,String> getMap = valuesMapGet.getMapOfValues(null);
		getMap.put("name", name);
		
		ArrayList<Map<String, String>> results = this.get(getMap);
		Iterator<Map<String, String>> iterator = results.iterator();
		
		Equipment equipment = new Equipment();
		this.objectConstructor(iterator.next(), equipment);
		return equipment;
	}

	/**
	 * Adds the equipment.
	 *
	 * @param equipment the equipment
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addEquipment(Equipment equipment) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(equipment));
	}

	/**
	 * Update equipment.
	 *
	 * @param equipment the equipment
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void updateEquipment(Equipment equipment) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(equipment), keysMap.getMapOfValues(equipment));
	}

	/**
	 * Delete equipment.
	 *
	 * @param equipment the equipment
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteEquipment(Equipment equipment) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(equipment));
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
		valuesMap.put("id_equipment", results.getString("id_equipment"));
		return valuesMap;
	}

	/**
	 * Object constructor.
	 *
	 * @param <DataBaseObject> the generic type
	 * @param mapValues the map values
	 * @param dataBaseObject the data base object
	 */
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((Equipment) dataBaseObject).setName(mapValues.get("name"));
		((Equipment) dataBaseObject).setIdEquipment(Integer.parseInt(mapValues.get("id_equipment")));
	}

	/**
	 * The Class MapOfValuesInsert.
	 */
	public class MapOfValuesInsert implements ValuesMap {
		
		/**
		 * Gets the map of values.
		 *
		 * @param <DataBaseObject> the generic type
		 * @param dataBaseObject the data base object
		 * @return the map of values
		 */
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Equipment equipment = (Equipment) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", equipment.getName());
			mapValues.put("id_equipment", equipment.getIdEquipment().toString());
			return mapValues;
		}
	}
	
	/**
	 * The Class MapOfValuesGet.
	 */
	public class MapOfValuesGet implements ValuesMap {
		
		/**
		 * Gets the map of values.
		 *
		 * @param <DataBaseObject> the generic type
		 * @param dataBaseObject the data base object
		 * @return the map of values
		 */
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Equipment equipment = (Equipment) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("id_equipment", equipment.getIdEquipment().toString());
			return mapValues;
		}	
	}
}
