/**
 *
 */
package model.objects;


/**
 * Represents a biomecanic function that symbolize a way to move parts of our body.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class BiomecanicFunction {

	/** The id biomecanic function. */
	private Integer id_biomecanic_function;

	/** The name. */
	private String name;

	/**
	 * Instantiates a new biomecanic function.
	 */
	public BiomecanicFunction() {
		name = "";
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
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		BiomecanicFunction other = (BiomecanicFunction) obj;
		if (id_biomecanic_function == null) {
			if (other.id_biomecanic_function != null)
				return false;
		} else if (!id_biomecanic_function.equals(other.id_biomecanic_function))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * Gets the id biomecanic function.
	 *
	 * @return the id_biomecanic_function
	 */
	public Integer getIdBiomecanicFunction() {
		return id_biomecanic_function;
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
		result = prime * result + ((id_biomecanic_function == null) ? 0 : id_biomecanic_function.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Sets the id biomecanic function.
	 *
	 * @param id_biomecanic_function the id_biomecanic_function to set
	 */
	public void setIdBiomecanicFunction(Integer id_biomecanic_function) {
		this.id_biomecanic_function = id_biomecanic_function;
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
		return "BiomecanicFunction [name=" + name + "]";
	}

}
