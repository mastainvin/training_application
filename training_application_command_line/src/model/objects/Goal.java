package model.objects;

/** Represents Goals
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
public class Goal {
	private String name;
	private Integer duration;
	private Integer rest_duration;
	private Velocity velocity;
	private GoalNbSerie goalNbSerie;
	private GoalNbRep goalNbRep;
	private GoalWeight goalWeight;
	
	public Goal() {
		this.name = "";
		this.duration = 0;
		this.rest_duration = 0;
		this.velocity = Velocity.MEDIUM;
	}
	/** get the name of the goal
	 * 
	 * @return String which represents the goal name
	 */
	public String getName() {
		return this.name;
	}
	
	/** set the name of the goal
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** get the duration (in sec) of the goal's serie
	 * 
	 * @return the duration of a serie  
	 */
	public Integer getDuration() {
		return this.duration;
	}
	
	/** set the duration (in sec) of the goal's serie
	 * 
	 * @param duration of a serie
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	/** get the rest duration (in sec) for every serie
	 * 
	 * @return the rest duration for every serie
	 */
	public Integer getRestDuration() {
		return this.rest_duration;
	}
	
	/** set the rest duration (in sec) for every serie 
	 * 
	 * @param rest_duration for every serie
	 */
	public void setRestDuration(Integer rest_duration) {
		this.rest_duration = rest_duration;
	}
	


	public Velocity getVelocity() {
		return velocity;
	}

	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}

	public GoalNbSerie getGoalNbSerie() {
		return goalNbSerie;
	}
	public void setGoalNbSerie(GoalNbSerie goalNbSerie) {
		this.goalNbSerie = goalNbSerie;
	}
	public GoalNbRep getGoalNbRep() {
		return goalNbRep;
	}
	public void setGoalNbRep(GoalNbRep goalNbRep) {
		this.goalNbRep = goalNbRep;
	}
	public GoalWeight getGoalWeight() {
		return goalWeight;
	}
	public void setGoalWeight(GoalWeight goalWeight) {
		this.goalWeight = goalWeight;
	}
	@Override
	public String toString() {
		return this.getName();
 	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Goal) {
			Goal g = (Goal) o;
			return this.getName().equals(g.getName()) && this.getDuration().equals(g.getDuration()) && this.getRestDuration().equals(g.getRestDuration());
		}
		return false;
	}
}
