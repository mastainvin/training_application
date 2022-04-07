package model.objects;

// TODO: Auto-generated Javadoc
/**
 *  Represents an interval (min, max) of integers.
 *
 * @author Vincent Mastain
 */
public class Interval {
	
	/** The min. */
	private Integer min;
	
	/** The max. */
	private Integer max;
	
	/**
	 * Gets the min.
	 *
	 * @return the min value
	 */
	public Integer getMin() {
		return this.min;
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
	 * Gets the max.
	 *
	 * @return the max value
	 */
	public Integer getMax() {
		return this.max;
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return this.getMin() + " / " + this.getMax(); 
	}
	
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
}
