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

import model.objects.Disponibility;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincednt Mastain
 * @version 1.0
 */
public class DisponibilityDaoImpl extends BasicRequestsDao implements DisponibilityDao {

	static DisponibilityDaoImpl singleton = null;
	public static DisponibilityDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new DisponibilityDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private DisponibilityDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Disponibility");
		this.setIdLabel("id_disponibility");
	}
	
	@Override
	Map<String, String> setMapFromResultSet(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("duration", results.getString("duration"));
		valuesMap.put("layout", results.getString("layout"));

		return valuesMap;
	}
	
	public class MapOfValuesInsert implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Disponibility disponibility = (Disponibility) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("duration", disponibility.getDuration().toString());
			mapValues.put("layout", disponibility.getLayout().toString());

			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Disponibility disponibility = (Disponibility) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("duration", disponibility.getDuration().toString());
			mapValues.put("layout", disponibility.getLayout().toString());
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((Disponibility) dataBaseObject).setDuration(Integer.parseInt(mapValues.get("duration")));
		((Disponibility) dataBaseObject).setLayout(Integer.parseInt(mapValues.get("layout")));
	}
	
	
	@Override
	public List<Disponibility> getAllDisponibility() throws EmptyResultsQueryException {
		List<Disponibility> disponibilityList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			Disponibility disponibility = new Disponibility();
			this.objectConstructor(valueMap, disponibility);
			disponibilityList.add(disponibility);
		}
		return disponibilityList;
	}	

	@Override
	public Disponibility getFirstDisponibility() throws EmptyResultsQueryException {
		Disponibility disponibility = new Disponibility();
		this.<Disponibility>getFirst(disponibility);
		return disponibility;
	}

	@Override
	public Disponibility getDisponibilityById(Integer id_disponibility) throws EmptyResultsQueryException {
		Disponibility disponibility = new Disponibility();
		this.<Disponibility>getById(id_disponibility, disponibility);
		return disponibility;
	}
	
	@Override
	public Integer getDisponibilityId(Disponibility disponibility) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		return this.getId(valuesMapGet.getMapOfValues(disponibility));
	}
	
	@Override
	public void addDisponibility(Disponibility disponibility) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(disponibility));
	}

	@Override
	public void updateDisponibility(Disponibility previousDisponibility, Disponibility newDisponibility) throws EmptyResultsQueryException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		this.update(this.getDisponibilityId(previousDisponibility), valuesMapInsert.getMapOfValues(newDisponibility));
	}

	@Override
	public void deleteDisponibility(Disponibility disponibility) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(disponibility));
	}

}
