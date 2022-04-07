package model.objects;

// TODO: Auto-generated Javadoc
/**
 *  Represents the speed of execution of one repetition.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public enum Velocity {
	
	/** The quick. */
	QUICK (1.0), 
 /** The medium. */
 MEDIUM (2.0), 
 /** The low. */
 LOW (4.0);
	
	/** The speed. */
	private final double speed;
	
	/**
	 * Instantiates a new velocity.
	 *
	 * @param speed is the speed of execution
	 */
	private Velocity(double speed) {
		this.speed = speed;
	}
	
	/**
	 * Gets the speed.
	 *
	 * @return a double which is the speed
	 */
	public double getSpeed() {
		return this.speed;
	}
}
