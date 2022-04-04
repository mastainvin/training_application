/**
 * 
 */
package model.dao;

import java.util.Map;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public interface ValuesMap {
	<DataBaseObject> Map<String, String> getMapOfValues(DataBaseObject dataBaseObject);
}
