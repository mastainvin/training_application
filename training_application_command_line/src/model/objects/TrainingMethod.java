/**
 * 
 */
package model.objects;

/** Represents a training method connected to a training componnent
 * @author Vincent Mastain
 * @version 1.0
 */
public class TrainingMethod {
	private String name;
	private Integer rep_max;
	private Integer rep_min;
	private Integer weight_max;
	private Integer weight_min;
	private Repartition repartition;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRepMax() {
		return rep_max;
	}
	public void setRepMax(Integer rep_max) {
		this.rep_max = rep_max;
	}
	public Integer getRepMin() {
		return rep_min;
	}
	public void setRepMin(Integer rep_min) {
		this.rep_min = rep_min;
	}
	public Integer getWeightMax() {
		return weight_max;
	}
	public void setWeightMax(Integer weight_max) {
		this.weight_max = weight_max;
	}
	public Integer getWeightMin() {
		return weight_min;
	}
	public void setWeightMin(Integer weight_min) {
		this.weight_min = weight_min;
	}
	public Repartition getRepartition() {
		return repartition;
	}
	public void setRepartition(Repartition repartition) {
		this.repartition = repartition;
	}

	@Override
	public String toString() {
		return this.getName();
	}
}
