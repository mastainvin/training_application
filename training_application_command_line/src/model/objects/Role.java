package model.objects;

/** Represents a user role
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
public class Role {
	/** Represents the role's name 
	 * 
	 */
	private String name;

	/**
	 * 
	 * @return name of the role
	 */
	public String getName() {
		return name;
	}
	

	
	/**
	 * 
	 * @param name of the role
	 */
	public void setName(String name) {
		this.name = name;
	}
	




	@Override
	public String toString() {
		return this.name;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Role) {
			Role r = (Role) o;
			return r.getName().equals(r.getName());
		}
		return false;
	}
}
