/**
 * 
 */
package model.objects;

import java.util.List;
import java.util.Observable;

// TODO: Auto-generated Javadoc
/**
 * Represents a training exercice.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class Exercice extends Observable{

	/** The biomecanic function list. */
	private List<BiomecanicFunction> biomecanicFunctionList;

	/** The description. */
	private String description;

	/** The id exercice. */
	private Integer id_exercice;

	/** The morphologies list. */
	private List<Morphology> morphologiesList;

	/** The name. */
	private String name;

	/** The user exercice datas. */
	private UserExerciceData userExerciceDatas;

	/**
	 * Z Instantiates a new exercice.
	 */
	public Exercice() {
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
		Exercice other = (Exercice) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id_exercice == null) {
			if (other.id_exercice != null)
				return false;
		} else if (!id_exercice.equals(other.id_exercice))
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
	 * Gets the id exercice.
	 *
	 * @return the id_exercice
	 */
	public Integer getIdExercice() {
		return id_exercice;
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
	 * Gets the user exercice datas.
	 *
	 * @return the userExerciceDatas
	 */
	public UserExerciceData getUserExerciceDatas() {
		return userExerciceDatas;
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
		result = prime * result + ((id_exercice == null) ? 0 : id_exercice.hashCode());
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
	 * Sets the id exercice.
	 *
	 * @param id_exercice the id_exercice to set
	 */
	public void setIdExercice(Integer id_exercice) {
		this.id_exercice = id_exercice;
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
	 * Sets the user exercice datas.
	 *
	 * @param userExerciceDatas the userExerciceDatas to set
	 */
	public void setUserExerciceDatas(UserExerciceData userExerciceDatas) {
		this.userExerciceDatas = userExerciceDatas;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Exercice [name=" + name + "]";
	}

	public void copy(Exercice exercice) {
		setDescription(exercice.getDescription());
		setBiomecanicFunctionList(exercice.getBiomecanicFunctionList());
		setIdExercice(exercice.getIdExercice());
		setMorphologiesList(exercice.getMorphologiesList());
		setName(exercice.getName());
		setUserExerciceDatas(exercice.getUserExerciceDatas());
		setChanged();
		notifyObservers();
	}

}
