/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.BiomecanicFunction;
import model.objects.Exercice;
import model.objects.TrainingComponent;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface BiomecanicFunctionDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface BiomecanicFunctionDao {
	
	/**
	 * Gets the all biomecanic function.
	 *
	 * @return the all biomecanic function
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	List<BiomecanicFunction> getAllBiomecanicFunction() throws EmptyResultsQueryException;
	
	/**
	 * Gets the first biomecanic function.
	 *
	 * @return the first biomecanicFunction in the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	BiomecanicFunction getFirstBiomecanicFunction() throws EmptyResultsQueryException;
	
	/**
	 * Gets the biomecanic function by name.
	 *
	 * @param name of the goal
	 * @return the corresponding goal
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	BiomecanicFunction getBiomecanicFunctionByName(String name) throws EmptyResultsQueryException;
	
	/**
	 * Gets the biomecanic function by id.
	 *
	 * @param id_biomecanicFunction the id biomecanic function
	 * @return the corresponding biomecanicFunction
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	BiomecanicFunction getBiomecanicFunctionById(Integer id_biomecanicFunction) throws EmptyResultsQueryException;
	
	/**
	 * Adds the biomecanic function.
	 *
	 * @param biomecanicFunction the biomecanic function
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addBiomecanicFunction(BiomecanicFunction biomecanicFunction) throws InsertDataBaseException;
	
	/**
	 * Update biomecanic function.
	 *
	 * @param bioMecanicFunction the bio mecanic function
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void updateBiomecanicFunction(BiomecanicFunction bioMecanicFunction) throws EmptyResultsQueryException, InsertDataBaseException;
	
	/**
	 * Delete biomecanic function.
	 *
	 * @param biomecanicFunction the biomecanic function
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteBiomecanicFunction(BiomecanicFunction biomecanicFunction) throws EmptyResultsQueryException;
	
	
	void getTrainingComponentBiomecanicFunctionList(TrainingComponent trainingComponent) throws EmptyResultsQueryException;
	
	void getExerciceBiomecanicFunctionList(Exercice exercice) throws EmptyResultsQueryException;
}
