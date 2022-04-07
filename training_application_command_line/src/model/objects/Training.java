package model.objects;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 *  Represents a day of training (set of exercice).
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class Training implements Comparable<Training>{
	
	/** The name. */
	private String name;
	
	/** The layout. */
	private Integer layout;
	
	/** The description. */
	private String description;
	
	/** The duration. */
	private Integer duration;
	
	/** The id training. */
	private Integer id_training;
	
	/** The id training type. */
	private Integer id_training_type;
	
	/** The id structure. */
	private Integer id_structure;
	
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
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
	 * Gets the layout.
	 *
	 * @return the layout
	 */
	public Integer getLayout() {
		return this.layout;
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
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
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
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public Integer getDuration() {
		return this.duration;
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
	 * Gets the training component list.
	 *
	 * @return the training component list
	 */
	public List<TrainingComponent> getTrainingComponentList() {
		return trainingComponentList;
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
	 * Gets the id training type.
	 *
	 * @return the id_training_type
	 */
	public Integer getIdTrainingType() {
		return id_training_type;
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
	 * Gets the id structure.
	 *
	 * @return the id_structure
	 */
	public Integer getIdStructure() {
		return id_structure;
	}

	/**
	 * Sets the id structure.
	 *
	 * @param id_structure the id_structure to set
	 */
	public void setIdStructure(Integer id_structure) {
		this.id_structure = id_structure;
	}

	
	@Override
	public String toString() {
		return "Training [name=" + name + ", layout=" + layout + "]";
	}	

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof Training) {
			Training t = (Training) o;
			return  this.getName().equals(t.getName()) &&
					this.getLayout().equals(t.getLayout()) && 
					this.getDescription().equals(t.getDescription()) &&
					this.getDuration().equals(t.getDuration());
		}
		return false;
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
	 * Sets the id training.
	 *
	 * @param id_training the id_training to set
	 */
	public void setIdTraining(Integer id_training) {
		this.id_training = id_training;
	}


	@Override
	public int compareTo(Training o) {
		Training t = (Training) o;
		if (this.getLayout().equals(t.getLayout())) {
			return 0;
		} else if (this.getLayout() > t.getLayout()) {
			return 1;
		}
		return -1;
	}
}
