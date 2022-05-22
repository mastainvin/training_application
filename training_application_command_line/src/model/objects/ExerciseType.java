/**
 * 
 */
package model.objects;

// TODO: Auto-generated Javadoc
/**
 * Represents a set of exercises.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class ExerciseType {

	/** The description. */
	private String description;

	/** The id exercise type. */
	private Integer id_exercise_type;

	/** The name. */
	private String name;

	/**
	 * Instantiates a new exercise type.
	 */
	public ExerciseType() {
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
		if (o instanceof ExerciseType) {
			ExerciseType et = (ExerciseType) o;
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
	 * Gets the id exercise type.
	 *
	 * @return the id_exercise_type
	 */
	public Integer getIdExerciseType() {
		return id_exercise_type;
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
	 * Sets the id exercise type.
	 *
	 * @param id_exercise_type the id_exercise_type to set
	 */
	public void setIdExerciseType(Integer id_exercise_type) {
		this.id_exercise_type = id_exercise_type;
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
