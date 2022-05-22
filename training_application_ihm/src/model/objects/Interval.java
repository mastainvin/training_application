package model.objects;

/**
 * Represents an interval (min, max) of integers.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class Interval {

	/** The max. */
	private Integer max;

	/** The min. */
	private Integer min;

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Interval) {
			Interval i = (Interval) o;
			return this.getMin().equals(i.getMin()) && this.getMax().equals(i.getMax());
		}
		return false;
	}

	/**
	 * Gets the max.
	 *
	 * @return the max value
	 */
	public Integer getMax() {
		return this.max;
	}

	/**
	 * Gets the min.
	 *
	 * @return the min value
	 */
	public Integer getMin() {
		return this.min;
	}

	/**
	 * Sets the max.
	 *
	 * @param max value
	 */
	public void setMax(Integer max) {
		this.max = max;
	}

	/**
	 * Sets the min.
	 *
	 * @param min the new min
	 */
	public void setMin(Integer min) {
		this.min = min;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return this.getMin() + " / " + this.getMax();
	}
}
