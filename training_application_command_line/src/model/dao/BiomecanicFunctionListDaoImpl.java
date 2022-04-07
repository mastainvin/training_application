/**
 * 
 */
package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.objects.BiomecanicFunctionList;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Class BiomecanicFunctionListDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class BiomecanicFunctionListDaoImpl extends BasicRequestsDao implements BiomecanicFunctionListDao {

	/** The singleton. */
	static BiomecanicFunctionListDaoImpl singleton = null;
	
	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the biomecanic function list dao impl
	 */
	public static BiomecanicFunctionListDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new BiomecanicFunctionListDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	/**
	 * Instantiates a new biomecanic function list dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private BiomecanicFunctionListDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("BiomecanicFunctionList");
		this.setIdLabel("id_biomecanic_function_list");
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
		valuesMap.put("id_biomecanic_function_list", results.getString("id_biomecanic_function_list"));
		return valuesMap;
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
			BiomecanicFunctionList biomecanicFunctionList = (BiomecanicFunctionList) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("id_biomecanic_function_list", biomecanicFunctionList.getIdBiomecanicFunctionList().toString());
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
			BiomecanicFunctionList biomecanicFunctionList = (BiomecanicFunctionList) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("id_biomecanic_function_list", biomecanicFunctionList.getIdBiomecanicFunctionList().toString());
			return mapValues;
		}	
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
		((BiomecanicFunctionList) dataBaseObject).setIdBiomecanicFunctionList(Integer.parseInt(mapValues.get("id_biomecanic_function_list")));
	}
	
	
	/**
	 * Gets the all biomecanic function list.
	 *
	 * @return the all biomecanic function list
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<BiomecanicFunctionList> getAllBiomecanicFunctionList() throws EmptyResultsQueryException {
		List<BiomecanicFunctionList> biomecanicFunctionListList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			BiomecanicFunctionList biomecanicFunctionList = new BiomecanicFunctionList();
			this.objectConstructor(valueMap, biomecanicFunctionList);
			biomecanicFunctionListList.add(biomecanicFunctionList);
		}
		return biomecanicFunctionListList;
	}	

	/**
	 * Gets the first biomecanic function list.
	 *
	 * @return the first biomecanic function list
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public BiomecanicFunctionList getFirstBiomecanicFunctionList() throws EmptyResultsQueryException {
		BiomecanicFunctionList biomecanicFunctionList = new BiomecanicFunctionList();
		this.<BiomecanicFunctionList>getFirst(biomecanicFunctionList);
		return biomecanicFunctionList;
	}

	
	/**
	 * Gets the biomecanic function list by id.
	 *
	 * @param id_biomecanicFunctionList the id biomecanic function list
	 * @return the biomecanic function list by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public BiomecanicFunctionList getBiomecanicFunctionListById(Integer id_biomecanicFunctionList) throws EmptyResultsQueryException {
		BiomecanicFunctionList biomecanicFunctionList = new BiomecanicFunctionList();
		this.<BiomecanicFunctionList>getById(id_biomecanicFunctionList, biomecanicFunctionList);
		return biomecanicFunctionList;
	}
	

	/**
	 * Adds the biomecanic function list.
	 *
	 * @param biomecanicFunctionList the biomecanic function list
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addBiomecanicFunctionList(BiomecanicFunctionList biomecanicFunctionList) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(biomecanicFunctionList));
	}

	/**
	 * Update biomecanic function list.
	 *
	 * @param bioMecanicFunction the bio mecanic function
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void updateBiomecanicFunctionList(BiomecanicFunctionList bioMecanicFunction) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(bioMecanicFunction), keysMap.getMapOfValues(bioMecanicFunction));
	}

	

	/**
	 * Delete biomecanic function list.
	 *
	 * @param biomecanicFunctionList the biomecanic function list
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteBiomecanicFunctionList(BiomecanicFunctionList biomecanicFunctionList) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(biomecanicFunctionList));
	}

	

	
}
