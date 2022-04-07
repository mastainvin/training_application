package model.objects;

// TODO: Auto-generated Javadoc
/**
 *  Represents a serie during a trainig for one exercice.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class Serie implements Cloneable{
	
	/** The date. */
	private String date;
	
	/** The weight. */
	private Integer weight;
	
	/** The repetitions. */
	private Integer repetitions;
	
	/** The rpe. */
	private Integer rpe;
	
	/** The expected repetitions. */
	private Integer expected_repetitions;
	
	/** The expected weight. */
	private Integer expected_weight;
	
	/** The layout. */
	private Integer layout;
	
	/** The in actual week. */
	private Boolean inActualWeek;
	
	/** The id serie. */
	private Integer id_serie;
	
	/** The id compose training training. */
	private Integer id_compose_training_training;
	
	/** The id user. */
	private Integer id_user;
	
	/** The compose training layout. */
	private Integer compose_training_layout;
	
	/** The id exercice. */
	private Integer id_exercice;
	
	/** The id compose training type. */
	private Integer id_compose_training_type;
	
	/** The id compose training method. */
	private Integer id_compose_training_method;
	
	/**
	 * Instantiates a new serie.
	 */
	public Serie() {
		date = "";
		weight = 0;
		repetitions = 0;
		rpe = 0;
		expected_repetitions = 0;
		expected_weight = 0;
		layout = 0;
		inActualWeek = false;
	} 
	
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return this.date;
	}
	
	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public Integer getWeight() {
		return this.weight;
	}
	
	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	/**
	 * Gets the repetitions.
	 *
	 * @return the repetitions
	 */
	public Integer getRepetitions() {
		return this.repetitions;
	}
	
	/**
	 * Sets the repetitions.
	 *
	 * @param repetitions the new repetitions
	 */
	public void setRepetitions(Integer repetitions) {
		this.repetitions = repetitions;
	}
	
	/**
	 * Gets the rpe.
	 *
	 * @return the rpe
	 */
	public Integer getRpe() {
		return this.rpe;
	}
	
	/**
	 * Sets the rpe.
	 *
	 * @param rpe the new rpe
	 */
	public void setRpe(Integer rpe) {
		this.rpe = rpe;
	}
	
	/**
	 * Gets the expected repetitions.
	 *
	 * @return the expected repetitions
	 */
	public Integer getExpectedRepetitions() {
		return this.expected_repetitions;
	}
	
	/**
	 * Sets the expected repetitions.
	 *
	 * @param expected_repetitions the new expected repetitions
	 */
	public void setExpectedRepetitions(Integer expected_repetitions) {
		this.expected_repetitions = expected_repetitions;
	}
	
	/**
	 * Gets the expected weight.
	 *
	 * @return the expected weight
	 */
	public Integer getExpectedWeight() {
		return expected_weight;
	}

	/**
	 * Sets the expected weight.
	 *
	 * @param expected_weight the new expected weight
	 */
	public void setExpectedWeight(Integer expected_weight) {
		this.expected_weight = expected_weight;
	}

	/**
	 * Gets the layout.
	 *
	 * @return the layout
	 */
	public Integer getLayout() {
		return layout;
	}

	/**
	 * Sets the layout.
	 *
	 * @param layout the new layout
	 */
	public void setLayout(Integer layout) {
		this.layout = layout;
	}

	/**
	 * Gets the in actual week.
	 *
	 * @return the in actual week
	 */
	public Boolean getInActualWeek() {
		return inActualWeek;
	}

	/**
	 * Sets the in actual week.
	 *
	 * @param inActualWeek the new in actual week
	 */
	public void setInActualWeek(Boolean inActualWeek) {
		this.inActualWeek = inActualWeek;
	}



	/**
	 * Gets the id serie.
	 *
	 * @return the id_serie
	 */
	public Integer getIdSerie() {
		return id_serie;
	}

	/**
	 * Sets the id serie.
	 *
	 * @param id_serie the id_serie to set
	 */
	public void setIdSerie(Integer id_serie) {
		this.id_serie = id_serie;
	}

	/**
	 * Gets the id compose training training.
	 *
	 * @return the id_compose_training_training
	 */
	public Integer getIdComposeTrainingTraining() {
		return id_compose_training_training;
	}

	/**
	 * Sets the id compose training training.
	 *
	 * @param id_compose_training_training the id_compose_training_training to set
	 */
	public void setIdComposeTrainingTraining(Integer id_compose_training_training) {
		this.id_compose_training_training = id_compose_training_training;
	}



	/**
	 * Gets the id user.
	 *
	 * @return the id_user
	 */
	public Integer getIdUser() {
		return id_user;
	}

	/**
	 * Sets the id user.
	 *
	 * @param id_user the id_user to set
	 */
	public void setIdUser(Integer id_user) {
		this.id_user = id_user;
	}

	/**
	 * Gets the compose training layout.
	 *
	 * @return the compose_training_layout
	 */
	public Integer getComposeTrainingLayout() {
		return compose_training_layout;
	}

	/**
	 * Sets the compose training layout.
	 *
	 * @param compose_training_layout the compose_training_layout to set
	 */
	public void setComposeTrainingLayout(Integer compose_training_layout) {
		this.compose_training_layout = compose_training_layout;
	}

	/**
	 * Gets the id exercice.
	 *
	 * @return the id_exercice
	 */
	public Integer getIdExercice() {
		return id_exercice;
	}
	
	/**
	 * Sets the id exercice.
	 *
	 * @param id_exercice the id_exercice to set
	 */
	public void setIdExercice(Integer id_exercice) {
		this.id_exercice = id_exercice;
	}
	
	/**
	 * Gets the id compose training type.
	 *
	 * @return the id_compose_training_type
	 */
	public Integer getIdComposeTrainingType() {
		return id_compose_training_type;
	}
	
	/**
	 * Sets the id compose training type.
	 *
	 * @param id_compose_training_type the id_compose_training_type to set
	 */
	public void setIdComposeTrainingType(Integer id_compose_training_type) {
		this.id_compose_training_type = id_compose_training_type;
	}
	
	/**
	 * Gets the id compose training method.
	 *
	 * @return the id_compose_training_method
	 */
	public Integer getIdComposeTrainingMethod() {
		return id_compose_training_method;
	}
	
	/**
	 * Sets the id compose training method.
	 *
	 * @param id_compose_training_method the id_compose_training_method to set
	 */
	public void setIdComposeTrainingMethod(Integer id_compose_training_method) {
		this.id_compose_training_method = id_compose_training_method;
	}
	
	/**
	 * Clone.
	 *
	 * @return the object
	 * @throws CloneNotSupportedException the clone not supported exception
	 */
	public Object clone() throws CloneNotSupportedException {		
		Serie serie = null;
        try {
        	serie = (Serie) super.clone();
        } catch(CloneNotSupportedException cnse) {
              cnse.printStackTrace(System.err);
        }
        return serie;
	}
	
	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	public boolean equals(Object o) {
		if (o instanceof Serie) {
			Serie s = (Serie) o;
			return this.getDate() == s.getDate() && this.getInActualWeek() == s.getInActualWeek() && this.getExpectedRepetitions() == s.getExpectedRepetitions() && this.getExpectedWeight() == s.getExpectedWeight() && this.getLayout() == s.getLayout() && this.getRepetitions() == s.getRepetitions() && this.getRpe() == s.getRpe() && this.getWeight() == s.getWeight();
		}
		return false;
	}
	
	// TODO add toString
}
