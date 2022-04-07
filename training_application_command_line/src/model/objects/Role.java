package model.objects;

// TODO: Auto-generated Javadoc
/**
 *  Represents a user role.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class Role {
	
	/**  Represents the role's name . */
	private String name;
	
	/** The id role. */
	private Integer id_role;
	
	/**
	 * Instantiates a new role.
	 */
	public Role() {
		name = "";
	}
	
	/**
	 * Gets the name.
	 *
	 * @return name of the role
	 */
	public String getName() {
		return name;
	}
	

	
	/**
	 * Sets the name.
	 *
	 * @param name of the role
	 */
	public void setName(String name) {
		this.name = name;
	}
	




	/**
	 * Gets the id role.
	 *
	 * @return the id_role
	 */
	public Integer getIdRole() {
		return id_role;
	}



	/**
	 * Sets the id role.
	 *
	 * @param id_role the id_role to set
	 */
	public void setIdRole(Integer id_role) {
		this.id_role = id_role;
	}



	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return this.name;
	}
	
	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Role) {
			Role r = (Role) o;
			return r.getName().equals(r.getName());
		}
		return false;
	}
}
