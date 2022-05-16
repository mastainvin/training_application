package model.objects;

// TODO: Auto-generated Javadoc
/**
 * Represents a morphology.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class Morphology {

	/** The description. */
	private String description;

	/** The id morphology. */
	private Integer id_morphology;

	/** The name. */
	private String name;

	/**
	 * Instantiates a new morphology.
	 */
	public Morphology() {
		name = "";
		description = "";
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Morphology other = (Morphology) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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
	 * Gets the id morphology.
	 *
	 * @return the id_morphology
	 */
	public Integer getIdMorphology() {
		return id_morphology;
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
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
	 * Sets the id morphology.
	 *
	 * @param id_morphology the id_morphology to set
	 */
	public void setIdMorphology(Integer id_morphology) {
		this.id_morphology = id_morphology;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
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
		return "Morphology [name=" + name + ", description=" + description + "]";
	}

}