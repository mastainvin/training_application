/**
 * 
 */
package model.objects;

// TODO: Auto-generated Javadoc
/**
 * Class with user data for one exercice.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class UserExerciceData {

	/** The id exercice. */
	private Integer id_exercice;

	/** The id user. */
	private Integer id_user;

	/** The mark. */
	private Double mark;

	/** The nb done. */
	private Integer nb_done;

	/** The weight. */
	private Double weight;

	/**
	 * Instantiates a new user exercice data.
	 */
	public UserExerciceData() {
		weight = 0.0;
		mark = 0.0;
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
	 * Sets the id exercice.
	 *
	 * @param id_exercice the id_exercice to set
	 */
	public void setIdExercice(Integer id_exercice) {
		this.id_exercice = id_exercice;
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
		return "UserExerciceData [weight=" + weight + ", mark=" + mark + ", nb_done=" + nb_done + "]";
	}

}
