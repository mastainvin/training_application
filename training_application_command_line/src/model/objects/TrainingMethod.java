/**
 * 
 */
package model.objects;

// TODO: Auto-generated Javadoc
/**
 *  Represents a training method connected to a training componnent.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class TrainingMethod {
	
	/** The name. */
	private String name;
	
	/** The rep max. */
	private Integer rep_max;
	
	/** The rep min. */
	private Integer rep_min;
	
	/** The weight max. */
	private Integer weight_max;
	
	/** The weight min. */
	private Integer weight_min;
	
	/** The repartition. */
	private Repartition repartition;
	
	/** The id training method. */
	private Integer id_training_method;
	
	/**
	 * Instantiates a new training method.
	 */
	public TrainingMethod() {
		name = "";
		rep_max = 0;
		rep_min = 0;
		weight_max = 0;
		weight_min = 0;
		
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the rep max.
	 *
	 * @return the rep max
	 */
	public Integer getRepMax() {
		return rep_max;
	}
	
	/**
	 * Sets the rep max.
	 *
	 * @param rep_max the new rep max
	 */
	public void setRepMax(Integer rep_max) {
		this.rep_max = rep_max;
	}
	
	/**
	 * Gets the rep min.
	 *
	 * @return the rep min
	 */
	public Integer getRepMin() {
		return rep_min;
	}
	
	/**
	 * Sets the rep min.
	 *
	 * @param rep_min the new rep min
	 */
	public void setRepMin(Integer rep_min) {
		this.rep_min = rep_min;
	}
	
	/**
	 * Gets the weight max.
	 *
	 * @return the weight max
	 */
	public Integer getWeightMax() {
		return weight_max;
	}
	
	/**
	 * Sets the weight max.
	 *
	 * @param weight_max the new weight max
	 */
	public void setWeightMax(Integer weight_max) {
		this.weight_max = weight_max;
	}
	
	/**
	 * Gets the weight min.
	 *
	 * @return the weight min
	 */
	public Integer getWeightMin() {
		return weight_min;
	}
	
	/**
	 * Sets the weight min.
	 *
	 * @param weight_min the new weight min
	 */
	public void setWeightMin(Integer weight_min) {
		this.weight_min = weight_min;
	}
	
	/**
	 * Gets the repartition.
	 *
	 * @return the repartition
	 */
	public Repartition getRepartition() {
		return repartition;
	}
	
	/**
	 * Sets the repartition.
	 *
	 * @param repartition the new repartition
	 */
	public void setRepartition(Repartition repartition) {
		this.repartition = repartition;
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
	 * Sets the id training method.
	 *
	 * @param id_training_method the id_training_method to set
	 */
	public void setIdTrainingMethod(Integer id_training_method) {
		this.id_training_method = id_training_method;
	}

	@Override
	public String toString() {
		return "TrainingMethod [name=" + name + ", rep_max=" + rep_max + ", rep_min=" + rep_min + ", weight_max="
				+ weight_max + ", weight_min=" + weight_min + ", repartition=" + repartition + "]";
	}
	
}
