package model.objects;

/** Represents the speed of execution of one repetition
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
public enum Velocity {
	QUICK (1.0), MEDIUM (2.0), LOW (4.0);
	
	private final double speed;
	/**
	 * 
	 * @param speed is the speed of execution
	 */
	private Velocity(double speed) {
		this.speed = speed;
	}
	
	/**
	 * 
	 * @return a double which is the speed
	 */
	public double getSpeed() {
		return this.speed;
	}
}
