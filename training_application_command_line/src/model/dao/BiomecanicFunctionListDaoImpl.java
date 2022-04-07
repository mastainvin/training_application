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

import model.objects.BiomecanicFunction;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public class BiomecanicFunctionDaoImpl extends BasicRequestsDao implements BiomecanicFunctionDao {

	static BiomecanicFunctionDaoImpl singleton = null;
	public static BiomecanicFunctionDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new BiomecanicFunctionDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private BiomecanicFunctionDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("BiomecanicFunction");
		this.setIdLabel("id_biomecanic_function");
	}
	
	@Override
	Map<String, String> setMapFromResultSet(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("name", results.getString("name"));
		return valuesMap;
	}
	
	public class MapOfValuesInsert implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			BiomecanicFunction biomecanicFunction = (BiomecanicFunction) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", biomecanicFunction.getName());
			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			BiomecanicFunction biomecanicFunction = (BiomecanicFunction) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", biomecanicFunction.getName());
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((BiomecanicFunction) dataBaseObject).setName(mapValues.get("name"));
	}
	
	
	@Override
	public List<BiomecanicFunction> getAllBiomecanicFunction() throws EmptyResultsQueryException {
		List<BiomecanicFunction> biomecanicFunctionList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			BiomecanicFunction biomecanicFunction = new BiomecanicFunction();
			biomecanicFunction.setName(valueMap.get("name"));
			biomecanicFunctionList.add(biomecanicFunction);
		}
		return biomecanicFunctionList;
	}	

	@Override
	public BiomecanicFunction getFirstBiomecanicFunction() throws EmptyResultsQueryException {
		BiomecanicFunction biomecanicFunction = new BiomecanicFunction();
		this.<BiomecanicFunction>getFirst(biomecanicFunction);
		return biomecanicFunction;
	}

	@Override
	public BiomecanicFunction getBiomecanicFunctionByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		BiomecanicFunction biomecanicFunction = new BiomecanicFunction();
		biomecanicFunction.setName(name);
		ArrayList<Map<String, String>> results = this.get(valuesMapGet.getMapOfValues(biomecanicFunction));
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), biomecanicFunction);
		return biomecanicFunction;
	}
	
	@Override
	public BiomecanicFunction getBiomecanicFunctionById(Integer id_biomecanicFunction) throws EmptyResultsQueryException {
		BiomecanicFunction biomecanicFunction = new BiomecanicFunction();
		this.<BiomecanicFunction>getById(id_biomecanicFunction, biomecanicFunction);
		return biomecanicFunction;
	}
	
	@Override
	public Integer getBiomecanicFunctionId(BiomecanicFunction biomecanicFunction) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		return this.getId(valuesMapGet.getMapOfValues(biomecanicFunction));
	}
	
	@Override
	public void addBiomecanicFunction(BiomecanicFunction biomecanicFunction) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(biomecanicFunction));
	}

	@Override
	public void updateBiomecanicFunction(BiomecanicFunction previousBiomecanicFunction, BiomecanicFunction newBiomecanicFunction) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		this.update(this.getId(valuesMapGet.getMapOfValues(previousBiomecanicFunction)), valuesMapInsert.getMapOfValues(newBiomecanicFunction));
	}

	@Override
	public void deleteBiomecanicFunction(BiomecanicFunction biomecanicFunction) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(biomecanicFunction));
	}

	
}
