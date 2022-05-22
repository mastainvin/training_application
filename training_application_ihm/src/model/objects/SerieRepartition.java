/**
 *
 */
package model.objects;

/**
 * Represents the way that we organize an exercise in a training.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class SerieRepartition implements Comparable<SerieRepartition> {

	/** The id serie repartition. */
	private Integer id_serie_repartition;

	/** The id training method. */
	private Integer id_training_method;

	/** The layout. */
	private Integer layout;

	/** The nb rep. */
	private Integer nb_rep;

	/** The rest duration. */
	private Integer rest_duration;

	/** The weight. */
	private Integer weight;

	/**
	 * Instantiates a new serie repartition.
	 */
	public SerieRepartition() {
		nb_rep = 0;
		weight = 0;
		layout = 0;
	}

	/**
	 * Compare to.
	 *
	 * @param sr the sr
	 * @return the int
	 */
	@Override
	public int compareTo(SerieRepartition sr) {
		if (this.getLayout() > sr.getLayout()) {
			return 1;
		} else if (this.getLayout() < sr.getLayout()) {
			return -1;
		}
		return 0;
	}

	/**
	 * Gets the id serie repartition.
	 *
	 * @return the id_serie_repartition
	 */
	public Integer getIdSerieRepartition() {
		return id_serie_repartition;
	}

	/**
	 * Gets the id training method.
	 *
	 * @return the id_training_method
	 */
	public Integer getIdTrainingMethod() {
		return id_training_method;
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
	 * Gets the nb rep.
	 *
	 * @return the nb_rep
	 */
	public Integer getNbRep() {
		return nb_rep;
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
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public Integer getWeight() {
		return weight;
	}

	/**
	 * Sets the id serie repartition.
	 *
	 * @param id_serie_repartition the id_serie_repartition to set
	 */
	public void setIdSerieRepartition(Integer id_serie_repartition) {
		this.id_serie_repartition = id_serie_repartition;
	}

	/**
	 * Sets the id training method.
	 *
	 * @param id_training_method the id_training_method to set
	 */
	public void setIdTrainingMethod(Integer id_training_method) {
		this.id_training_method = id_training_method;
	}

	/**
	 * Sets the layout.
	 *
	 * @param layout the layout to set
	 */
	public void setLayout(Integer layout) {
		this.layout = layout;
	}

	/**
	 * Sets the nb rep.
	 *
	 * @param nb_rep the nb_rep to set
	 */
	public void setNbRep(Integer nb_rep) {
		this.nb_rep = nb_rep;
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
	 * Sets the weight.
	 *
	 * @param weight the weight to set
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
}
