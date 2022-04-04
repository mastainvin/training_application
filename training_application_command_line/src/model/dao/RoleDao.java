/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Role;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 *
 */
public interface RoleDao {
	
	List<Role> getAllRole() throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @return the first role in the db
	 * @throws EmptyResultsQueryException
	 */
	Role getFirstRole() throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param name of the goal
	 * @return the corresponding goal
	 * @throws EmptyResultsQueryException
	 */
	Role getRoleByName(String name) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param id_role
	 * @return the corresponding role
	 * @throws EmptyResultsQueryException
	 */
	Role getRoleById(Integer id_role) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param role which we want the id
	 * @return the role's id
	 * @throws EmptyResultsQueryException
	 */
	Integer getRoleId(Role role) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param role
	 */
	void addRole(Role role);
	
	/**
	 * 
	 * @param previousRole
	 * @param newRole
	 * @throws EmptyResultsQueryException
	 */
	void updateRole(Role previousRole, Role newRole) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param role
	 * @throws EmptyResultsQueryException 
	 */
	void deleteRole(Role role) throws EmptyResultsQueryException;
	
}
