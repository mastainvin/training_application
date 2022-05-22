/**
 * 
 */
package model.objects;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * Represents a training exercise.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class Exercise {

	/** The biomecanic function list. */
	private List<BiomecanicFunction> biomecanicFunctionList;

	/** The description. */
	private String description;

	/** The id exercise. */
	private Integer id_exercise;

	/** The morphologies list. */
	private List<Morphology> morphologiesList;

	/** The name. */
	private String name;

	/** The user exercise datas. */
	private UserExerciseData userExerciseDatas;

	/**
	 * Z Instantiates a new exercise.
	 */
	public Exercise() {
		name = "";
		description = "";
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
		Exercise other = (Exercise) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id_exercise == null) {
			if (other.id_exercise != null)
				return false;
		} else if (!id_exercise.equals(other.id_exercise))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * Gets the biomecanic function list.
	 *
	 * @return the biomecanicFunctionList
	 */
	public List<BiomecanicFunction> getBiomecanicFunctionList() {
		return biomecanicFunctionList;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
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
	 * Gets the morphologies list.
	 *
	 * @return the morphologiesList
	 */
	public List<Morphology> getMorphologiesList() {
		return morphologiesList;
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
	 * Gets the user exercise datas.
	 *
	 * @return the userExerciseDatas
	 */
	public UserExerciseData getUserExerciseDatas() {
		return userExerciseDatas;
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
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id_exercise == null) ? 0 : id_exercise.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Sets the biomecanic function list.
	 *
	 * @param biomecanicFunctionList the biomecanicFunctionList to set
	 */
	public void setBiomecanicFunctionList(List<BiomecanicFunction> biomecanicFunctionList) {
		this.biomecanicFunctionList = biomecanicFunctionList;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * Sets the morphologies list.
	 *
	 * @param morphologiesList the morphologiesList to set
	 */
	public void setMorphologiesList(List<Morphology> morphologiesList) {
		this.morphologiesList = morphologiesList;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the user exercise datas.
	 *
	 * @param userExerciseDatas the userExerciseDatas to set
	 */
	public void setUserExerciseDatas(UserExerciseData userExerciseDatas) {
		this.userExerciseDatas = userExerciseDatas;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Exercise [name=" + name + "]";
	}

}
