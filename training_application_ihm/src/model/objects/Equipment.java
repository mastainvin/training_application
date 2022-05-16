package model.objects;

// TODO: Auto-generated Javadoc
/**
 * Represents an equipment.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class Equipment {

	/** The id equipment. */
	private Integer idEquipment;

	/** The name. */
	private String name;

	/**
	 * Instantiates a new equipment.
	 */
	public Equipment() {
		name = "";
	}

	/**
	 * Gets the id equipment.
	 *
	 * @return the idEquipement
	 */
	public Integer getIdEquipment() {
		return idEquipment;
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
	 * Sets the id equipment.
	 *
	 * @param idEquipment the new id equipment
	 */
	public void setIdEquipment(Integer idEquipment) {
		this.idEquipment = idEquipment;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
