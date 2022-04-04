package model.objects;

import java.util.List;

/** Represents a day of training (set of exercice)
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
public class Training {
	private String name;
	private Integer Layout;
	private String description;
	private Integer duration;
	private TrainingType trainingType;
	private List<TrainingComponent> trainingComponentList;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getLayout() {
		return this.Layout;
	}
	
	public void setLayout(Integer Layout) {
		this.Layout = Layout;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getDuration() {
		return this.duration;
	}
	
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	

	public TrainingType getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(TrainingType trainingType) {
		this.trainingType = trainingType;
	}

	public List<TrainingComponent> getTrainingComponentList() {
		return trainingComponentList;
	}

	public void setTrainingComponentList(List<TrainingComponent> trainingComponentList) {
		this.trainingComponentList = trainingComponentList;
	}

	@Override
	public String toString() {
		return this.getName();
	}
	
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
}
