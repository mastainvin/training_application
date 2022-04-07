/**
 * 
 */
package model.objects;

// TODO: Auto-generated Javadoc
/**
 * The Class BiomecanicFunction.
 *
 * @author Vincent Mastain
 */
public class BiomecanicFunction {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_biomecanic_function == null) ? 0 : id_biomecanic_function.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
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

	/** The name. */
	private String name;
	
	/** The id biomecanic function. */
	private Integer id_biomecanic_function;
	
	/**
	 * Instantiates a new biomecanic function.
	 */
	public BiomecanicFunction() {
		name = "";
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
	 * Gets the id biomecanic function.
	 *
	 * @return the id_biomecanic_function
	 */
	public Integer getIdBiomecanicFunction() {
		return id_biomecanic_function;
	}
	
	/**
	 * Sets the id biomecanic function.
	 *
	 * @param id_biomecanic_function the id_biomecanic_function to set
	 */
	public void setIdBiomecanicFunction(Integer id_biomecanic_function) {
		this.id_biomecanic_function = id_biomecanic_function;
	}

	@Override
	public String toString() {
		return "BiomecanicFunction [name=" + name + "]";
	}
	

	
	
}
