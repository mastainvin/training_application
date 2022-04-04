/**
 * 
 */
package model.objects;

import java.util.ArrayList;

/** interface of a weight and repetitions repartitions, will use to make series
 * @author Vincent Mastain
 * @version 1.0
 */
public abstract class Repartition {
	private String name;
	
	/** Build the repartition of reps
	 * 
	 * @param rep_min
	 * @param rep_max
	 * @return an array of int, represents the number of serie for every series
	 */
	abstract ArrayList<Integer> rep_repartition(Integer rep_min, Integer rep_max);
	
	/**
	 * 
	 * @param weight_min
	 * @param weight_max
	 * @return an array of int, represents the reparition of weight for every series
	 */
	abstract ArrayList<Integer> weight_repartition(Integer weight_min, Integer weight_max);
	
	public static Repartition getRepartition(String name) {
		switch (name) {
		case "3x3":
			return new Repartition3x3("3x3");
		case "4x4":
			return new Repartition4x4("4x4");
		case "5x5":
			return new Repartititon5x5("5x5");
		case "bulgare":
			return new RepartitionBulgare("bulgare");
		case "charge_constante":
			return new RepartitionConstantWeight("charge_constante");
		case "4x15":
			return new Repartition4x15("4x15");
		case "4x10":
			return new Repartition4x10("4x10");
		default:
			return null;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
