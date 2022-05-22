package model.objects;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * Represent a week of trainings.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class Structure {

	/** The id goal. */
	private Integer id_goal;

	/** The id structure. */
	private Integer id_structure;

	/** The name. */
	private String name;

	/** The trainings list. */
	private List<Training> trainingsList;

	/**
	 * Instantiates a new structure.
	 */
	public Structure() {
		name = "";
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
			return this.getName().equals(s.getName()) && this.getIdGoal().equals(s.getIdGoal());
		}
		return false;
	}

	public Set<Exercice> getExercices() {
		Set<Exercice> exerciceSet = new HashSet<>();
		for (Training t : this.getTrainingsList()) {
			for (TrainingComponent tc : t.getTrainingComponentList()) {
				for (Exercice e : tc.getExercicesList()) {
					exerciceSet.add(e);
				}
			}
		}
		return exerciceSet;
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
	 * Gets the id structure.
	 *
	 * @return the id_structure
	 */
	public Integer getIdStructure() {
		return id_structure;
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
	 * Gets the trainings list.
	 *
	 * @return the trainings list
	 */
	public List<Training> getTrainingsList() {
		return trainingsList;
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
	 * Sets the id structure.
	 *
	 * @param id_structure the id_structure to set
	 */
	public void setIdStructure(Integer id_structure) {
		this.id_structure = id_structure;
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
	 * Sets the trainings list.
	 *
	 * @param trainingsList the new trainings list
	 */
	public void setTrainingsList(List<Training> trainingsList) {
		this.trainingsList = trainingsList;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Structure [name=" + name + "]";
	}

}
