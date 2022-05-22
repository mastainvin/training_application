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
import model.objects.exceptions.InsertDataBaseException;


/**
 * The Class RoleDaoImpl.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class RoleDaoImpl extends BasicRequestsDao implements RoleDao {

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
			Role role = (Role) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("id_role", role.getIdRole().toString());
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
			Role role = (Role) dataBaseObject;
			Map<String, String> mapValues = new HashMap<>();
			mapValues.put("name", role.getName());
			mapValues.put("id_role", role.getIdRole().toString());
			return mapValues;
		}
	}

	/** The singleton. */
	static RoleDaoImpl singleton = null;

	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the role dao impl
	 */
	public static RoleDaoImpl instance(DaoFactory daoFactory) {
		if (singleton == null) {
			return new RoleDaoImpl(daoFactory);
		}
		return singleton;
	}

	/**
	 * Instantiates a new role dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private RoleDaoImpl(DaoFactory daoFactory) {
		this.setDaoFactory(daoFactory);
		this.setDbName("Role");
		this.setIdLabel("id_role");
	}

	/**
	 * Adds the role.
	 *
	 * @param role the role
	 * @throws InsertDataBaseException the insert data base exception
	 */
	@Override
	public void addRole(Role role) throws InsertDataBaseException {
		ValuesMap valuesMap = new MapOfValuesInsert();
		this.add(valuesMap.getMapOfValues(role));
	}

	/**
	 * Delete role.
	 *
	 * @param role the role
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public void deleteRole(Role role) throws EmptyResultsQueryException {
		ValuesMap valuesMap = new MapOfValuesGet();
		this.delete(valuesMap.getMapOfValues(role));
	}

	/**
	 * Gets the all role.
	 *
	 * @return the all role
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Role> getAllRole() throws EmptyResultsQueryException {
		List<Role> roleList = new ArrayList<>();
		ArrayList<Map<String, String>> results = this.get(null);
		for (Map<String, String> valueMap : results) {
			Role role = new Role();
			role.setName(valueMap.get("name"));
			roleList.add(role);
		}
		return roleList;
	}

	/**
	 * Gets the first role.
	 *
	 * @return the first role
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Role getFirstRole() throws EmptyResultsQueryException {
		Role role = new Role();
		this.<Role>getFirst(role);
		return role;
	}

	/**
	 * Gets the role by id.
	 *
	 * @param id_role the id role
	 * @return the role by id
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Role getRoleById(Integer id_role) throws EmptyResultsQueryException {
		Role role = new Role();
		this.<Role>getById(id_role, role);
		return role;
	}

	/**
	 * Gets the role by name.
	 *
	 * @param name the name
	 * @return the role by name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public Role getRoleByName(String name) throws EmptyResultsQueryException {
		Map<String, String> getMap = new HashMap<>();
		getMap.put("name", name);

		ArrayList<Map<String, String>> results = this.get(getMap);
		Iterator<Map<String, String>> iterator = results.iterator();

		Role role = new Role();
		this.objectConstructor(iterator.next(), role);
		return role;
	}

	/**
	 * Update role.
	 *
	 * @param role the role
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	@Override
	public void updateRole(Role role) throws EmptyResultsQueryException, InsertDataBaseException {
		ValuesMap valuesMapInsert = new MapOfValuesInsert();
		ValuesMap keysMap = new MapOfValuesGet();
		this.update(valuesMapInsert.getMapOfValues(role), keysMap.getMapOfValues(role));
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
		((Role) dataBaseObject).setName(mapValues.get("name"));
		((Role) dataBaseObject).setIdRole(Integer.parseInt(mapValues.get("id_role")));
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
		valuesMap.put("id_role", results.getString("id_role"));
		return valuesMap;
	}

}
