package model.objects;

// TODO: Auto-generated Javadoc
/**
 *  Represents Goals.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class Goal {
	
	/** The name. */
	private String name;
	
	/** The duration. */
	private Integer duration;
	
	/** The rest duration. */
	private Integer rest_duration;
	
	/** The velocity. */
	private Velocity velocity;
	
	/** The id goal. */
	private Integer id_goal;
	
	/** The id goal nb serie. */
	private Integer id_GoalNbSerie;
	
	/** The id goal nb rep. */
	private Integer id_GoalNbRep;
	
	/** The id goal weight. */
	private Integer id_GoalWeight;
	
	/**
	 * Instantiates a new goal.
	 */
	public Goal() {
		this.name = "";
		this.duration = 0;
		this.rest_duration = 0;
		this.velocity = Velocity.MEDIUM;
	}
	
	/**
	 *  get the name of the goal.
	 *
	 * @return String which represents the goal name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 *  set the name of the goal.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 *  get the duration (in sec) of the goal's serie.
	 *
	 * @return the duration of a serie
	 */
	public Integer getDuration() {
		return this.duration;
	}
	
	/**
	 *  set the duration (in sec) of the goal's serie.
	 *
	 * @param duration of a serie
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	/**
	 *  get the rest duration (in sec) for every serie.
	 *
	 * @return the rest duration for every serie
	 */
	public Integer getRestDuration() {
		return this.rest_duration;
	}
	
	/**
	 *  set the rest duration (in sec) for every serie .
	 *
	 * @param rest_duration for every serie
	 */
	public void setRestDuration(Integer rest_duration) {
		this.rest_duration = rest_duration;
	}
	


	/**
	 * Gets the velocity.
	 *
	 * @return the velocity
	 */
	public Velocity getVelocity() {
		return velocity;
	}

	/**
	 * Sets the velocity.
	 *
	 * @param velocity the new velocity
	 */
	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}
	
	/**
	 * Gets the id goal.
	 *
	 * @return the id_goal
	 */
	public Integer getIdGoal() {
		return id_goal;
	}
	
	/**
	 * Sets the id goal.
	 *
	 * @param id_goal the id_goal to set
	 */
	public void setIdGoal(Integer id_goal) {
		this.id_goal = id_goal;
	}
	
	/**
	 * Gets the id goal nb serie.
	 *
	 * @return the id_GoalNbSerie
	 */
	public Integer getIdGoalNbSerie() {
		return id_GoalNbSerie;
	}
	
	/**
	 * Sets the id goal nb serie.
	 *
	 * @param id_GoalNbSerie the id_GoalNbSerie to set
	 */
	public void setIdGoalNbSerie(Integer id_GoalNbSerie) {
		this.id_GoalNbSerie = id_GoalNbSerie;
	}
	
	/**
	 * Gets the id goal nb rep.
	 *
	 * @return the id_GoalNbRep
	 */
	public Integer getIdGoalNbRep() {
		return id_GoalNbRep;
	}
	
	/**
	 * Sets the id goal nb rep.
	 *
	 * @param id_GoalNbRep the id_GoalNbRep to set
	 */
	public void setIdGoalNbRep(Integer id_GoalNbRep) {
		this.id_GoalNbRep = id_GoalNbRep;
	}
	
	/**
	 * Gets the id goal weight.
	 *
	 * @return the id_GoalWeight
	 */
	public Integer getIdGoalWeight() {
		return id_GoalWeight;
	}
	
	/**
	 * Sets the id goal weight.
	 *
	 * @param id_GoalWeight the id_GoalWeight to set
	 */
	public void setIdGoalWeight(Integer id_GoalWeight) {
		this.id_GoalWeight = id_GoalWeight;
	}

	
	@Override
	public String toString() {
		return "Goal [name=" + name + ", duration=" + duration + ", rest_duration=" + rest_duration + ", velocity="
				+ velocity + "]";
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Goal) {
			Goal g = (Goal) o;
			return this.getName().equals(g.getName()) && this.getDuration().equals(g.getDuration()) && this.getRestDuration().equals(g.getRestDuration());
		}
		return false;
	}
}
