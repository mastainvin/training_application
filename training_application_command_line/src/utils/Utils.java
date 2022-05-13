/**
 * 
 */
package utils;

import java.util.Collection;

// TODO: Auto-generated Javadoc
/**
 * The Class Utils.
 *
 * @author cytech
 */
public class Utils {

	/**
	 * Checks if is empty or null.
	 *
	 * @param collection the collection
	 * @return true, if is empty or null
	 */
	public static boolean isEmptyOrNull(Collection<?> collection) {
		if (collection == null) {
			return true;
		} else {
			return collection.isEmpty();
		}
	}
}
