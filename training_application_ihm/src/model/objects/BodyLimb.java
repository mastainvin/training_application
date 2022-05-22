package model.objects;


/**
 * Represents a body limb.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class BodyLimb {

	/** The id body limb. */
	private Integer id_BodyLimb;

	/** The lower. */
	private Boolean lower;

	/** The name. */
	private String name;

	/** The upper. */
	private Boolean upper;

	/**
	 * Instantiates a new body limb.
	 */
	public BodyLimb() {
		name = "";
		upper = false;
		lower = false;
	}

	/**
	 * Gets the id body limb.
	 *
	 * @return the id_BodyLimb
	 */
	public Integer getIdBodyLimb() {
		return id_BodyLimb;
	}

	/**
	 * Gets the lower.
	 *
	 * @return the lower
	 */
	public Boolean getLower() {
		return lower;
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
	 * Gets the upper.
	 *
	 * @return the upper
	 */
	public Boolean getUpper() {
		return upper;
	}

	/**
	 * Sets the id body limb.
	 *
	 * @param id_BodyLimb the id_BodyLimb to set
	 */
	public void setIdBodyLimb(Integer id_BodyLimb) {
		this.id_BodyLimb = id_BodyLimb;
	}

	/**
	 * Sets the lower.
	 *
	 * @param lower the lower to set
	 */
	public void setLower(Boolean lower) {
		this.lower = lower;
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
	 * Sets the upper.
	 *
	 * @param upper the upper to set
	 */
	public void setUpper(Boolean upper) {
		this.upper = upper;
	}

}
