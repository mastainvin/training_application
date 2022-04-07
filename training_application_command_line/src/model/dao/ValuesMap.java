/**
 * 
 */
package model.dao;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValuesMap.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface ValuesMap {
	
	/**
	 * Gets the map of values.
	 *
	 * @param <DataBaseObject> the generic type
	 * @param dataBaseObject the data base object
	 * @return the map of values
	 */
	<DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject);
}
