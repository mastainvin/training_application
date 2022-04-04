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

import model.objects.Role;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public class RoleDaoImpl extends BasicRequestsDao implements RoleDao {

	static RoleDaoImpl singleton = null;
	public static RoleDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			return new RoleDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	
	private RoleDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Role");
		this.setIdLabel("id_role");
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
			Role role = (Role) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", role.getName());
			return mapValues;
		}
	}
	
	public class MapOfValuesGet implements ValuesMap {
		@Override
		public <DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject) {
			Role role = (Role) dataBaseObject;
			Map<String, String> mapValues = new HashMap<String,String>();
			mapValues.put("name", role.getName());
			return mapValues;
		}	
	}
	
	@Override
	<DataBaseObject> void objectConstructor(Map<String, String> mapValues, DataBaseObject dataBaseObject) {
		((Role) dataBaseObject).setName(mapValues.get("name"));
	}
	
	
	@Override
	public List<Role> getAllRole() throws EmptyResultsQueryException {
		List<Role> roleList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for(Map<String, String>valueMap : results) {
			Role role = new Role();
			role.setName(valueMap.get("name"));
			roleList.add(role);
		}
		return roleList;
	}	

	@Override
	public Role getFirstRole() throws EmptyResultsQueryException {
		Role role = new Role();
		this.<Role>getFirst(role);
		return role;
	}

	@Override
	public Role getRoleByName(String name) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		Role role = new Role();
		role.setName(name);
		ArrayList<Map<String, String>> results = this.get(valuesMapGet.getMapOfValues(role));
		Iterator<Map<String, String>> iterator = results.iterator();
		this.objectConstructor(iterator.next(), role);
		return role;
	}
	
	@Override
	public Role getRoleById(Integer id_role) throws EmptyResultsQueryException {
		Role role = new Role();
		this.<Role>getById(id_role, role);
		return role;
	}
	
	@Override
	public Integer getRoleId(Role role) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		return this.getId(valuesMapGet.getMapOfValues(role));
	}
	
	@Override
	public void addRole(Role role) {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(role));
	}

	@Override
	public void updateRole(Role previousRole, Role newRole) throws EmptyResultsQueryException {
		ValuesMap valuesMapGet = new MapOfValuesGet();
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		this.update(this.getId(valuesMapGet.getMapOfValues(previousRole)), valuesMapInsert.getMapOfValues(newRole));
	}

	@Override
	public void deleteRole(Role role) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(role));
	}

	
}
