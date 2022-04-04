/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.BiomecanicFunction;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 *
 */
public interface BiomecanicFunctionDao {
	
	List<BiomecanicFunction> getAllBiomecanicFunction() throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @return the first biomecanicFunction in the db
	 * @throws EmptyResultsQueryException
	 */
	BiomecanicFunction getFirstBiomecanicFunction() throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param name of the goal
	 * @return the corresponding goal
	 * @throws EmptyResultsQueryException
	 */
	BiomecanicFunction getBiomecanicFunctionByName(String name) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param id_biomecanicFunction
	 * @return the corresponding biomecanicFunction
	 * @throws EmptyResultsQueryException
	 */
	BiomecanicFunction getBiomecanicFunctionById(Integer id_biomecanicFunction) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param biomecanicFunction which we want the id
	 * @return the biomecanicFunction's id
	 * @throws EmptyResultsQueryException
	 */
	Integer getBiomecanicFunctionId(BiomecanicFunction biomecanicFunction) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param biomecanicFunction
	 */
	void addBiomecanicFunction(BiomecanicFunction biomecanicFunction);
	
	/**
	 * 
	 * @param previousBiomecanicFunction
	 * @param newBiomecanicFunction
	 * @throws EmptyResultsQueryException
	 */
	void updateBiomecanicFunction(BiomecanicFunction previousBiomecanicFunction, BiomecanicFunction newBiomecanicFunction) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param biomecanicFunction
	 * @throws EmptyResultsQueryException 
	 */
	void deleteBiomecanicFunction(BiomecanicFunction biomecanicFunction) throws EmptyResultsQueryException;
	
}
