package model.objects;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * Represents a day of training (set of exercice).
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class Training implements Comparable<Training> {

	/** The description. */
	private String description;

	/** The duration. */
	private Integer duration;

	/** The id structure. */
	private Integer id_structure;

	/** The id training. */
	private Integer id_training;

	/** The id training type. */
	private Integer id_training_type;

	/** The layout. */
	private Integer layout;

	/** The name. */
	private String name;

	/** The training component list. */
	private List<TrainingComponent> trainingComponentList;

	/**
	 * Instantiates a new training.
	 */
	public Training() {
		name = "";
		layout = 0;
		description = "";
		duration = 0;

	}

	/**
	 * Compare to.
	 *
	 * @param o the o
	 * @return the int
	 */
	@Override
	public int compareTo(Training o) {
		Training t = o;
		if (this.getLayout().equals(t.getLayout())) {
			return 0;
		} else if (this.getLayout() > t.getLayout()) {
			return 1;
		}
		return -1;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Training other = (Training) obj;
		if (id_training == null) {
			if (other.id_training != null)
				return false;
		} else if (!id_training.equals(other.id_training))
			return false;
		if (layout == null) {
			if (other.layout != null)
				return false;
		} else if (!layout.equals(other.layout))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public Integer getDuration() {
		return this.duration;
	}

	/**
	 * Gets the id structure.
	 *
	 * @return the id_structure
	 */
	public Integer getIdStructure() {
		return id_structure;
	}

	/**
	 * Gets the id training.
	 *
	 * @return the id_training
	 */
	public Integer getIdTraining() {
		return id_training;
	}

	/**
	 * Gets the id training type.
	 *
	 * @return the id_training_type
	 */
	public Integer getIdTrainingType() {
		return id_training_type;
	}

	/**
	 * Gets the layout.
	 *
	 * @return the layout
	 */
	public Integer getLayout() {
		return this.layout;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the training component list.
	 *
	 * @return the training component list
	 */
	public List<TrainingComponent> getTrainingComponentList() {
		return trainingComponentList;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_training == null) ? 0 : id_training.hashCode());
		result = prime * result + ((layout == null) ? 0 : layout.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Sets the duration.
	 *
	 * @param duration the new duration
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * Sets the id structure.
	 *
	 * @param id_structure the id_structure to set
	 */
	public void setIdStructure(Integer id_structure) {
		this.id_structure = id_structure;
	}

	/**
	 * Sets the id training.
	 *
	 * @param id_training the id_training to set
	 */
	public void setIdTraining(Integer id_training) {
		this.id_training = id_training;
	}

	/**
	 * Sets the id training type.
	 *
	 * @param id_training_type the id_training_type to set
	 */
	public void setIdTrainingType(Integer id_training_type) {
		this.id_training_type = id_training_type;
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
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the training component list.
	 *
	 * @param trainingComponentList the new training component list
	 */
	public void setTrainingComponentList(List<TrainingComponent> trainingComponentList) {
		this.trainingComponentList = trainingComponentList;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Training [name=" + name + ", layout=" + layout + "]";
	}
}
