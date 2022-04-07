/**
 * 
 */
package model.objects;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 *  Represents a training exercice.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class Exercice {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id_exercice == null) ? 0 : id_exercice.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

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

	@Override
	public String toString() {
		return "Exercice [name=" + name + "]";
	}

	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The user exercice datas. */
	private UserExerciceData userExerciceDatas;
	
	/** The id exercice. */
	private Integer id_exercice;
	
	private List<BiomecanicFunction> biomecanicFunctionList;
	
	/**Z
	 * Instantiates a new exercice.
	 */
	public Exercice() {
		name = "";
		description = "";
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
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * Sets the description.
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * Sets the user exercice datas.
	 *
	 * @param userExerciceDatas the userExerciceDatas to set
	 */
	public void setUserExerciceDatas(UserExerciceData userExerciceDatas) {
		this.userExerciceDatas = userExerciceDatas;
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
	 * @return the biomecanicFunctionList
	 */
	public List<BiomecanicFunction> getBiomecanicFunctionList() {
		return biomecanicFunctionList;
	}

	/**
	 * @param biomecanicFunctionList the biomecanicFunctionList to set
	 */
	public void setBiomecanicFunctionList(List<BiomecanicFunction> biomecanicFunctionList) {
		this.biomecanicFunctionList = biomecanicFunctionList;
	}

}
