package model.objects;

import java.util.List;

/** Represent a week of trainings
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
public class Structure {
	private String name;
	private Goal goal;
	private List<Training> trainingsList;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public List<Training> getTrainingsList() {
		return trainingsList;
	}

	public void setTrainingsList(List<Training> trainingsList) {
		this.trainingsList = trainingsList;
	}

	@Override
	public String toString() {
		return this.getName();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Structure) {
			Structure s = (Structure) o;
			return  this.getName().equals(s.getName()) &&
					this.getGoal().equals(s.getGoal());
		}
		return false;
	}


	
}
