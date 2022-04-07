/**
 * 
 */
package model.objects;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class RepartitionBulgare.
 *
 * @author cytech
 */
public class RepartitionBulgare extends Repartition {

	/**
	 * Instantiates a new repartition bulgare.
	 *
	 * @param name the name
	 */
	public RepartitionBulgare(String name) {
		this.setName(name);
	}
	
	/**
	 * Rep repartition.
	 *
	 * @param rep_min the rep min
	 * @param rep_max the rep max
	 * @return the array list
	 */
	@Override
	ArrayList<Integer> rep_repartition(Integer rep_min, Integer rep_max) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Weight repartition.
	 *
	 * @param weight_min the weight min
	 * @param weight_max the weight max
	 * @return the array list
	 */
	@Override
	ArrayList<Integer> weight_repartition(Integer weight_min, Integer weight_max) {
		// TODO Auto-generated method stub
		return null;
	}

}
