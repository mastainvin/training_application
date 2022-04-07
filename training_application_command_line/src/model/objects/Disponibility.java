package model.objects;

// TODO: Auto-generated Javadoc
/**
 *  Represents a disponibility in the week.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class Disponibility {
	
	/** The duration. */
	private Integer duration;
	
	/** The layout. */
	private Integer layout;
	
	/** The id disponibility. */
	private Integer id_disponibility;
	
	/**
	 * Instantiates a new disponibility.
	 */
	public Disponibility() {
		duration = 0;
		layout = 0;
	}
	
	/**
	 *  get the duration (in min) of a training.
	 *
	 * @return return the duration of a training
	 */
	public Integer getDuration() {
		return this.duration;
	}
	
	/**
	 *  set the durcytechtion (in min) of a training.
	 *
	 * @param duration of a training
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	/**
	 *  get the order of the training in the week.
	 *
	 * @return the order in the week
	 */
	public Integer getLayout() {
		return this.layout;
	}
	
	
	/**
	 *  set the order of the training in the week.
	 *
	 * @param layout the new layout
	 */
	public void setLayout(Integer layout) {
		this.layout = layout;
	}
	
	
	
	/**
	 * Gets the id disponibility.
	 *
	 * @return the id_disponibility
	 */
	public Integer getIdDisponibility() {
		return id_disponibility;
	}

	/**
	 * Sets the id disponibility.
	 *
	 * @param id_disponibility the id_disponibility to set
	 */
	public void setIdDisponibility(Integer id_disponibility) {
		this.id_disponibility = id_disponibility;
	}

	@Override
	public String toString() {
		return "Disponibility [duration=" + duration + ", layout=" + layout + "]";
	}
	
	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Disponibility) {
			Disponibility d = (Disponibility) o;
			return this.getDuration().equals(d.getDuration()) && this.getLayout().equals(d.getLayout());
		}
		return false;
	}
}
