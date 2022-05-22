/**
 *
 */
package model.dao;

import java.util.List;

import model.objects.Role;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;


/**
 * The Interface RoleDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface RoleDao {

	/**
	 * Adds the role.
	 *
	 * @param role the role
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addRole(Role role) throws InsertDataBaseException;

	/**
	 * Delete role.
	 *
	 * @param role the role
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteRole(Role role) throws EmptyResultsQueryException;

	/**
	 * Gets the all role.
	 *
	 * @return the all role
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<Role> getAllRole() throws EmptyResultsQueryException;

	/**
	 * Gets the first role.
	 *
	 * @return the first role in the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Role getFirstRole() throws EmptyResultsQueryException;

	/**
	 * Gets the role by id.
	 *
	 * @param id_role the id role
	 * @return the corresponding role
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Role getRoleById(Integer id_role) throws EmptyResultsQueryException;

	/**
	 * Gets the role by name.
	 *
	 * @param name of the goal
	 * @return the corresponding goal
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Role getRoleByName(String name) throws EmptyResultsQueryException;

	/**
	 * Update role.
	 *
	 * @param role the role
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void updateRole(Role role) throws EmptyResultsQueryException, InsertDataBaseException;

}
