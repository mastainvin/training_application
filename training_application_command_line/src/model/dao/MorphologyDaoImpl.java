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

import model.objects.Morphology;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 *
 */
public class MorphologyDaoImpl extends BasicRequestsDao implements MorphologyDao {

	static MorphologyDaoImpl singleton = null;
	public static MorphologyDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new MorphologyDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	private MorphologyDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Morphology");
		this.setIdLabel("id_morphology");
	}
	
	@Override
	Map<String, String> setMapFromResultSet(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("name", results.getString("name"));
		valuesMap.put("description", results.getString("description"));
		return valuesMap;
	}
	
	public class MapOfValuesInsert implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Morphology morphology = (Morphology) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", morphology.getName());
			mapValues.put("description",morphology.getDescription());
			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Morphology morphology = (Morphology) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", morphology.getName());
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((Morphology) dataBaseObject).setName(mapValues.get("name"));
		((Morphology) dataBaseObject).setDescription(mapValues.get("description"));
	}
	
	
	@Override
	public List<Morphology> getAllMorphology() throws EmptyResultsQueryException {
		List<Morphology> morphologyList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			Morphology morphology = new Morphology();
			morphology.setName(valueMap.get("name"));
			morphologyList.add(morphology);
		}
		return morphologyList;
	}	

	@Override
	public Morphology getFirstMorphology() throws EmptyResultsQueryException {
		Morphology morphology = new Morphology();
		this.<Morphology>getFirst(morphology);
		return morphology;
	}

	@Override
	public Morphology getMorphologyByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		Morphology morphology = new Morphology();
		morphology.setName(name);
		ArrayList<Map<String, String>> results = this.get(valuesMapGet.getMapOfValues(morphology));
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), morphology);
		return morphology;
	}
	
	@Override
	public Morphology getMorphologyById(Integer id_morphology) throws EmptyResultsQueryException {
		Morphology morphology = new Morphology();
		this.<Morphology>getById(id_morphology, morphology);
		return morphology;
	}
	
	@Override
	public Integer getMorphologyId(Morphology morphology) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		return this.getId(valuesMapGet.getMapOfValues(morphology));
	}
	
	@Override
	public void addMorphology(Morphology morphology) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(morphology));
	}

	@Override
	public void updateMorphology(Morphology previousMorphology, Morphology newMorphology) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		this.update(this.getId(valuesMapGet.getMapOfValues(previousMorphology)), valuesMapInsert.getMapOfValues(newMorphology));
	}

	@Override
	public void deleteMorphology(Morphology morphology) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(morphology));
	}


}
