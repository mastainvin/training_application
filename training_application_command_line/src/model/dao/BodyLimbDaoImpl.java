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

import model.objects.BodyLimb;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public class BodyLimbDaoImpl extends BasicRequestsDao implements BodyLimbDao {

	static BodyLimbDaoImpl singleton = null;
	public static BodyLimbDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new BodyLimbDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private BodyLimbDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("BodyLimb");
		this.setIdLabel("id_BodyLimb");
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
			BodyLimb bodyLimb = (BodyLimb) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", bodyLimb.getName());
			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			BodyLimb bodyLimb = (BodyLimb) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", bodyLimb.getName());
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((BodyLimb) dataBaseObject).setName(mapValues.get("name"));
	}
	
	
	@Override
	public List<BodyLimb> getAllBodyLimb() throws EmptyResultsQueryException {
		List<BodyLimb> bodyLimbList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			BodyLimb bodyLimb = new BodyLimb();
			bodyLimb.setName(valueMap.get("name"));
			bodyLimbList.add(bodyLimb);
		}
		return bodyLimbList;
	}	

	@Override
	public BodyLimb getFirstBodyLimb() throws EmptyResultsQueryException {
		BodyLimb bodyLimb = new BodyLimb();
		this.<BodyLimb>getFirst(bodyLimb);
		return bodyLimb;
	}

	@Override
	public BodyLimb getBodyLimbByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		BodyLimb bodyLimb = new BodyLimb();
		bodyLimb.setName(name);
		ArrayList<Map<String, String>> results = this.get(valuesMapGet.getMapOfValues(bodyLimb));
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), bodyLimb);
		return bodyLimb;
	}
	
	@Override
	public BodyLimb getBodyLimbById(Integer id_bodyLimb) throws EmptyResultsQueryException {
		BodyLimb bodyLimb = new BodyLimb();
		this.<BodyLimb>getById(id_bodyLimb, bodyLimb);
		return bodyLimb;
	}
	
	@Override
	public Integer getBodyLimbId(BodyLimb bodyLimb) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		return this.getId(valuesMapGet.getMapOfValues(bodyLimb));
	}
	
	@Override
	public void addBodyLimb(BodyLimb bodyLimb) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(bodyLimb));
	}

	@Override
	public void updateBodyLimb(BodyLimb previousBodyLimb, BodyLimb newBodyLimb) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		this.update(this.getId(valuesMapGet.getMapOfValues(previousBodyLimb)), valuesMapInsert.getMapOfValues(newBodyLimb));
	}

	@Override
	public void deleteBodyLimb(BodyLimb bodyLimb) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(bodyLimb));
	}


}
