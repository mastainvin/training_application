package model.objects;

// TODO: Auto-generated Javadoc
/**
 *  Represents a morphology.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class Morphology{
	
	@Override
	public String toString() {
		return "Morphology [name=" + name + ", description=" + description + "]";
	}

	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The id morphology. */
	private Integer id_morphology;
	
	/**
	 * Instantiates a new morphology.
	 */
	public Morphology() {
		name = "";
		description = "";
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
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
	 * Gets the id morphology.
	 *
	 * @return the id_morphology
	 */
	public Integer getIdMorphology() {
		return id_morphology;
	}

	/**
	 * Sets the id morphology.
	 *
	 * @param id_morphology the id_morphology to set
	 */
	public void setIdMorphology(Integer id_morphology) {
		this.id_morphology = id_morphology;
	}

}