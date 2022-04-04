/**
 * 
 */
package model.objects;

import java.util.List;

/** Represents a set of exercices
 * @author Vincent Mastain
 * @version 1.0
 */
public class ExerciceType {
	private String name;
	private String description;
	private List<Exercice> exercicesList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

	public List<Exercice> getExercicesList() {
		return exercicesList;
	}
	public void setExercicesList(List<Exercice> exercicesList) {
		this.exercicesList = exercicesList;
	}
	@Override
	public String toString() {
		return this.getName();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof ExerciceType) {
			ExerciceType et = (ExerciceType) o;
			return this.getName().equals(et.getName()) &&
					this.getDescription().equals(et.getDescription());
		}
		return false;
	}
	
}
