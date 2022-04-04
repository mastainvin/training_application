package model.objects;

/** Represent a type of training
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
public class TrainingType {
	private String name;
	private String description;
	
	public String getName() {
		return this.name;
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

	@Override
	public String toString() {
		return this.getName();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof TrainingType) {
			TrainingType t = (TrainingType) o;
			return this.getName().equals(t.getName());
		}
		return false;
	}
}
