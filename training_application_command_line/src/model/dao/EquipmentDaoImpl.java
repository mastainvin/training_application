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

/**
 * @author Vincent Mastain
 * @version 1.0
 *
 */
public class EquipmentDaoImpl extends BasicRequestsDao implements EquipmentDao {

	static EquipmentDaoImpl singleton = null;
	public static EquipmentDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new EquipmentDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private EquipmentDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Equipment");
		this.setIdLabel("id_equipment");
	}
	
	@Override
	public Equipment getEquipmentById(Integer id_equipment) throws EmptyResultsQueryException {
		Equipment equipment = new Equipment();
		this.<Equipment>getById(id_equipment, equipment);
		return equipment;
	}

	@Override
	public Equipment getEquipmentByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		Equipment equipment = new Equipment();
		equipment.setName(name);
		ArrayList<Map<String, String>> results = this.get(valuesMapGet.getMapOfValues(equipment));
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), equipment);
		return equipment;
	}

	@Override
	public Integer getEquipmentId(Equipment equipment) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		return this.getId(valuesMapGet.getMapOfValues(equipment));
	}

	@Override
	public void addEquipment(Equipment equipment) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(equipment));
	}

	@Override
	public void updateEquipment(Equipment previousEquipment, Equipment newEquipment) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		this.update(this.getId(valuesMapGet.getMapOfValues(previousEquipment)), valuesMapInsert.getMapOfValues(newEquipment));
	}

	@Override
	public void deleteEquipment(Equipment equipment) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(equipment));
	}

	@Override
	Map<String, String> setMapFromResultSet(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("name", results.getString("name"));
		return valuesMap;
	}

	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((Equipment) dataBaseObject).setName(mapValues.get("name"));
	}

	public class MapOfValuesInsert implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Equipment equipment = (Equipment) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", equipment.getName());
			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Equipment equipment = (Equipment) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", equipment.getName());
			return mapValues;
		}	
	}
}
