package model.objects;

/** Represents an attribute
 * 
 * @author Vincent Mastain
 * @version 1.0
 * @category Parameters
 */
public class Attribute {
	private String name;
	
	/** Attribute constructor with name param
	 * 
	 * @param name
	 */
	public Attribute(String name) {
		this.name = name;
	}
	
	/** Attribute constructor without name param
	 * 
	 */
	public Attribute() {
		this ("");
	}
	
	/** 
	 * @return a String which represents the attribute
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @param name represents the attribute
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}