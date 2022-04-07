/**
 * 
 */
package model.objects;

// TODO: Auto-generated Javadoc
/**
 *  Class with user data for one exercice.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class UserExerciceData {
	
	@Override
	public String toString() {
		return "UserExerciceData [weight=" + weight + ", mark=" + mark + ", nb_done=" + nb_done + "]";
	}


	/** The weight. */
	private Double weight;
	
	/** The mark. */
	private Integer mark;
	
	/** The id exercice. */
	private Integer id_exercice;
	
	/** The id user. */
	private Integer id_user;
	
	private Integer nb_done;
	
	/**
	 * Instantiates a new user exercice data.
	 */
	public UserExerciceData() {
		weight = 0.0;
		mark = 0;
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
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	/**
	 * Gets the mark.
	 *
	 * @return the mark
	 */
	public Integer getMark() {
		return mark;
	}
	
	/**
	 * Sets the mark.
	 *
	 * @param mark the new mark
	 */
	public void setMark(Integer mark) {
		this.mark = mark;
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
	 * @return the nb_done
	 */
	public Integer getNbDone() {
		return nb_done;
	}


	/**
	 * @param nb_done the nb_done to set
	 */
	public void setNbDone(Integer nb_done) {
		this.nb_done = nb_done;
	}


	
}
