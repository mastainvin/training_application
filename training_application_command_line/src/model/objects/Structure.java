package model.objects;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 *  Represent a week of trainings.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class Structure {
	
	/** The name. */
	private String name;
	
	/** The id goal. */
	private Integer id_goal;
	
	/** The id structure. */
	private Integer id_structure;
	
	/** The trainings list. */
	private List<Training> trainingsList;
	
	/**
	 * Instantiates a new structure.
	 */
	public Structure() {
		name = "";
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
	 * Gets the trainings list.
	 *
	 * @return the trainings list
	 */
	public List<Training> getTrainingsList() {
		return trainingsList;
	}

	/**
	 * Sets the trainings list.
	 *
	 * @param trainingsList the new trainings list
	 */
	public void setTrainingsList(List<Training> trainingsList) {
		this.trainingsList = trainingsList;
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
		return "Structure [name=" + name + "]";
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Structure) {
			Structure s = (Structure) o;
			return  this.getName().equals(s.getName()) &&
					this.getIdGoal().equals(s.getIdGoal());
		}
		return false;
	}


	
}
