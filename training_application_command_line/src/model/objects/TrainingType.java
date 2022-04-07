package model.objects;

// TODO: Auto-generated Javadoc
/**
 *  Represent a type of training.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class TrainingType {
	
	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The id training type. */
	private Integer id_training_type;
	
	/**
	 * Instantiates a new training type.
	 */
	public TrainingType() {
		name = "";
		description = "";
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
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
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
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
	 * Gets the id training type.
	 *
	 * @return the id_training_type
	 */
	public Integer getIdTrainingType() {
		return id_training_type;
	}

	/**
	 * Sets the id training type.
	 *
	 * @param id_training_type the id_training_type to set
	 */
	public void setIdTrainingType(Integer id_training_type) {
		this.id_training_type = id_training_type;
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
	
	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof TrainingType) {
			TrainingType t = (TrainingType) o;
			return this.getName().equals(t.getName());
		}
		return false;
	}
}
