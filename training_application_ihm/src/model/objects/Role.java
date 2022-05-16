package model.objects;

// TODO: Auto-generated Javadoc
/**
 * Represents a user role.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class Role {

	/** The id role. */
	private Integer id_role;

	/** Represents the role's name . */
	private String name;

	/**
	 * Instantiates a new role.
	 */
	public Role() {
		name = "";
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

	/**
	 * Gets the id role.
	 *
	 * @return the id_role
	 */
	public Integer getIdRole() {
		return id_role;
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
	 * Sets the id role.
	 *
	 * @param id_role the id_role to set
	 */
	public void setIdRole(Integer id_role) {
		this.id_role = id_role;
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return this.name;
	}
}
