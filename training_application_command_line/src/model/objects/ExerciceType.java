/**
 * 
 */
package model.objects;

// TODO: Auto-generated Javadoc
/**
 * Represents a set of exercices.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class ExerciceType {

	/** The description. */
	private String description;

	/** The id exercice type. */
	private Integer id_exercice_type;

	/** The name. */
	private String name;

	/**
	 * Instantiates a new exercice type.
	 */
	public ExerciceType() {
		name = "";
		description = "";
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof ExerciceType) {
			ExerciceType et = (ExerciceType) o;
			return this.getName().equals(et.getName()) && this.getDescription().equals(et.getDescription());
		}
		return false;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gets the id exercice type.
	 *
	 * @return the id_exercice_type
	 */
	public Integer getIdExerciceType() {
		return id_exercice_type;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Sets the id exercice type.
	 *
	 * @param id_exercice_type the id_exercice_type to set
	 */
	public void setIdExerciceType(Integer id_exercice_type) {
		this.id_exercice_type = id_exercice_type;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
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
		return this.getName();
	}

}
