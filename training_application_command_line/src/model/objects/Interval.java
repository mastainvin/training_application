package model.objects;

/** Represents an interval (min, max) of integers
 * 
 * @author Vincent Mastain
 *
 */
public class Interval {
	private Integer min;
	private Integer max;
	
	/**
	 * 
	 * @return the min value
	 */
	public Integer getMin() {
		return this.min;
	}
	
	/**
	 * 
	 * @param min
	 */
	public void setMin(Integer min) {
		this.min = min;
	}
	
	/**
	 * 
	 * @return the max value
	 */
	public Integer getMax() {
		return this.max;
	}
	
	/**
	 * 
	 * @param max value
	 */
	public void setMax(Integer max) {
		this.max = max;
	}
	
	@Override
	public String toString() {
		return this.getMin() + " / " + this.getMax(); 
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Interval) {
			Interval i = (Interval) o;
			return this.getMin().equals(i.getMin()) && this.getMax().equals(i.getMax());
		}
		return false;
	}
}
