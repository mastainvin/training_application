/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Structure;
import model.objects.Training;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface StructureDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface StructureDao {
	
	/**
	 * Gets the first structure.
	 *
	 * @return Frist structure of the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Structure getFirstStructure() throws EmptyResultsQueryException;
	
	/**
	 * Gets the structure by name.
	 *
	 * @param name  name of the structure
	 * @return structure which corresponds to the name
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Structure getStructureByName(String name) throws EmptyResultsQueryException;
	
	/**
	 * Gets the structure by id.
	 *
	 * @param id_structure id requested
	 * @return structure which corresponds to the id param
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Structure getStructureById(Integer id_structure) throws EmptyResultsQueryException;
	
	
	/**
	 * Adds the structure.
	 *
	 * @param structure structure wanted
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addStructure(Structure structure) throws InsertDataBaseException;
	
	/**
	 * Update structure.
	 *
	 * @param structure the structure
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void updateStructure(Structure structure) throws EmptyResultsQueryException, InsertDataBaseException;
	
	/**
	 * Delete structure.
	 *
	 * @param structure structure to delete
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteStructure(Structure structure) throws EmptyResultsQueryException;
	
	/**
	 * Gets the all structure.
	 *
	 * @return the all structure
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public List<Structure> getAllStructure() throws EmptyResultsQueryException;
		
	/**
	 * Gets the structure from training.
	 *
	 * @param training the training
	 * @return the structure from training
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public Structure getStructureFromTraining(Training training) throws EmptyResultsQueryException;
	
	
	public void getUserStructure(User user) throws EmptyResultsQueryException;
}
