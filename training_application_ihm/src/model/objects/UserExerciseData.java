/**
 *
 */
package model.objects;

/**
 * Represents data for one user for one exercise.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class UserExerciseData {

	/** The id exercise. */
	private Integer id_exercise;

	/** The id user. */
	private Integer id_user;

	/** The mark. */
	private Double mark;

	/** The nb done. */
	private Integer nb_done;

	/** The weight. */
	private Double weight;

	/**
	 * Instantiates a new user exercise data.
	 */
	public UserExerciseData() {
		weight = 0.0;
		mark = 0.0;
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
	 * Gets the id user.
	 *
	 * @return the id_user
	 */
	public Integer getIdUser() {
		return id_user;
	}

	/**
	 * Gets the mark.
	 *
	 * @return the mark
	 */
	public Double getMark() {
		return mark;
	}

	/**
	 * Gets the nb done.
	 *
	 * @return the nb_done
	 */
	public Integer getNbDone() {
		return nb_done;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
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
	 * Sets the id user.
	 *
	 * @param id_user the id_user to set
	 */
	public void setIdUser(Integer id_user) {
		this.id_user = id_user;
	}

	/**
	 * Sets the mark.
	 *
	 * @param mark the new mark
	 */
	public void setMark(Double mark) {
		this.mark = mark;
	}

	/**
	 * Sets the nb done.
	 *
	 * @param nb_done the nb_done to set
	 */
	public void setNbDone(Integer nb_done) {
		this.nb_done = nb_done;
	}

	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "UserExerciseData [weight=" + weight + ", mark=" + mark + ", nb_done=" + nb_done + "]";
	}

}
