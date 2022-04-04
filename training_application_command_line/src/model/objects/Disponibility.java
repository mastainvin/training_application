package model.objects;

/** Represents a disponibility in the week
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
public class Disponibility {
	private Integer duration;
	private Integer layout;
	
	/** get the duration (in min) of a training
	 * 
	 * @return return the duration of a training
	 */
	public Integer getDuration() {
		return this.duration;
	}
	
	/** set the durcytechtion (in min) of a training
	 * 
	 * @param duration of a training
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	/** get the order of the training in the week
	 * 
	 * @return the order in the week
	 */
	public Integer getLayout() {
		return this.layout;
	}
	
	
	/** set the order of the training in the week
	 * 
	 * @param order of the disponibility in the week
	 */
	public void setLayout(Integer layout) {
		this.layout = layout;
	}
	
	
	
	@Override
	public String toString() {
		return this.getLayout() + "/" + this.getDuration();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Disponibility) {
			Disponibility d = (Disponibility) o;
			return this.getDuration().equals(d.getDuration()) && this.getLayout().equals(d.getLayout());
		}
		return false;
	}
}
