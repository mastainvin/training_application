package model.objects;

import java.time.LocalDate;
import java.util.Observable;

/**
 * Represents a serie during a training for one exercise.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class Serie extends Observable implements Cloneable, Comparable<Serie> {

	/** The compose training layout. */
	private Integer compose_training_layout;

	/** The date. */
	private String date;

	/** The expected repetitions. */
	private Integer expected_repetitions;

	/** The expected weight. */
	private Integer expected_weight;

	/** The id compose training method. */
	private Integer id_compose_training_method;

	/** The id compose training training. */
	private Integer id_compose_training_training;

	/** The id compose training type. */
	private Integer id_compose_training_type;

	/** The id exercise. */
	private Integer id_exercise;
	/** The id serie. */
	private Integer id_serie;

	/** The id user. */
	private Integer id_user;

	/** The in actual week. */
	private Boolean inActualWeek;

	/** The layout. */
	private Integer layout;

	/** The repetitions. */
	private Integer repetitions;

	/** The rest duration. */
	private Integer rest_duration;

	/** The rpe. */
	private Integer rpe;

	/** The weight. */
	private Double weight;

	/**
	 * Instantiates a new serie.
	 */
	public Serie() {
		date = "";
		weight = 0.0;
		repetitions = 0;
		rpe = 0;
		expected_repetitions = 0;
		expected_weight = 0;
		layout = 0;
		inActualWeek = false;
	}

	/**
	 * Clone.
	 *
	 * @return the object
	 * @throws CloneNotSupportedException the clone not supported exception
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		Serie serie = null;
		try {
			serie = (Serie) super.clone();
		} catch (CloneNotSupportedException cnse) {
			cnse.printStackTrace(System.err);
		}
		return serie;
	}

	/**
	 * Compare to.
	 *
	 * @param o the o
	 * @return the int
	 */
	@Override
	public int compareTo(Serie o) {
		LocalDate date = LocalDate.parse(this.getDate());
		LocalDate dateToCompare = LocalDate.parse(o.getDate());
		return date.compareTo(dateToCompare);
	}

	/**
	 * Copy.
	 *
	 * @param s the serie
	 */
	public void copy(Serie s) {
		this.setComposeTrainingLayout(s.getComposeTrainingLayout());
		this.setDate(s.getDate());
		this.setExpectedRepetitions(s.getExpectedRepetitions());
		this.setExpectedWeight(s.getExpectedWeight());
		this.setIdComposeTrainingMethod(s.getIdComposeTrainingMethod());
		this.setIdComposeTrainingTraining(s.getIdComposeTrainingTraining());
		this.setIdComposeTrainingType(s.getIdComposeTrainingType());
		this.setIdExercise(s.getIdExercise());
		this.setIdSerie(s.getIdSerie());
		this.setIdUser(s.getIdUser());
		this.setInActualWeek(s.getInActualWeek());
		this.setLayout(s.getLayout());
		this.setRepetitions(s.getRepetitions());
		this.setRestDuration(s.getRestDuration());
		this.setRpe(s.getRpe());
		this.setWeight(s.getWeight());
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Equals.
	 *
	 * @param o the object
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Serie) {
			Serie s = (Serie) o;
			return this.getDate() == s.getDate() && this.getInActualWeek() == s.getInActualWeek()
					&& this.getExpectedRepetitions() == s.getExpectedRepetitions()
					&& this.getExpectedWeight() == s.getExpectedWeight() && this.getLayout() == s.getLayout()
					&& this.getRepetitions() == s.getRepetitions() && this.getRpe() == s.getRpe()
					&& this.getWeight() == s.getWeight();
		}
		return false;
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
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return this.date;
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
	 * Gets the expected weight.
	 *
	 * @return the expected weight
	 */
	public Integer getExpectedWeight() {
		return expected_weight;
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
	 * Gets the id compose training training.
	 *
	 * @return the id_compose_training_training
	 */
	public Integer getIdComposeTrainingTraining() {
		return id_compose_training_training;
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
	 * Gets the id exercise.
	 *
	 * @return the id_exercise
	 */
	public Integer getIdExercise() {
		return id_exercise;
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
	 * Gets the id user.
	 *
	 * @return the id_user
	 */
	public Integer getIdUser() {
		return id_user;
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
	 * Gets the layout.
	 *
	 * @return the layout
	 */
	public Integer getLayout() {
		return layout;
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
	 * Gets the rest duration.
	 *
	 * @return the rest_duration
	 */
	public Integer getRestDuration() {
		return rest_duration;
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
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public Double getWeight() {
		return this.weight;
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
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		this.date = date;
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
	 * Sets the expected weight.
	 *
	 * @param expected_weight the new expected weight
	 */
	public void setExpectedWeight(Integer expected_weight) {
		this.expected_weight = expected_weight;
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
	 * Sets the id compose training training.
	 *
	 * @param id_compose_training_training the id_compose_training_training to set
	 */
	public void setIdComposeTrainingTraining(Integer id_compose_training_training) {
		this.id_compose_training_training = id_compose_training_training;
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
	 * Sets the id exercise.
	 *
	 * @param id_exercise the id_exercise to set
	 */
	public void setIdExercise(Integer id_exercise) {
		this.id_exercise = id_exercise;
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
	 * Sets the id user.
	 *
	 * @param id_user the id_user to set
	 */
	public void setIdUser(Integer id_user) {
		this.id_user = id_user;
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
	 * Sets the layout.
	 *
	 * @param layout the new layout
	 */
	public void setLayout(Integer layout) {
		this.layout = layout;
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
	 * Sets the rest duration.
	 *
	 * @param rest_duration the rest_duration to set
	 */
	public void setRestDuration(Integer rest_duration) {
		this.rest_duration = rest_duration;
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
	 * Sets the weight.
	 *
	 * @param d the new weight
	 */
	public void setWeight(Double d) {
		this.weight = d;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Serie [date=" + date + ", weight=" + weight + ", repetitions=" + repetitions + ", rpe=" + rpe
				+ ", expected_repetitions=" + expected_repetitions + ", expected_weight=" + expected_weight
				+ ", rest_duration=" + rest_duration + ", layout=" + layout + ", inActualWeek=" + inActualWeek + "]";
	}

}
