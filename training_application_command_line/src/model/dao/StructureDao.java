/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Structure;
import model.objects.Training;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public interface StructureDao {
	
	/**
	 * 
	 * @return Frist structure of the db
	 * @throws EmptyResultsQueryException
	 */
	Structure getFirstStructure() throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param name  name of the structure
	 * @return structure which corresponds to the name
	 * @throws EmptyResultsQueryException
	 */
	Structure getStructureByName(String name) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param id_structure id requested
	 * @return structure which corresponds to the id param
	 * @throws EmptyResultsQueryException
	 */
	Structure getStructureById(Integer id_structure) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param structure which we want the id
	 * @return structure id corresponding
	 * @throws EmptyResultsQueryException
	 */
	Integer getStructureId(Structure structure) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param structure structure wanted
	 */
	void addStructure(Structure structure);
	
	/**
	 * 
	 * @param previousStructure structure to change
	 * @param newStructure structure used to make the change
	 * @throws EmptyResultsQueryException
	 */
	void updateStructure(Structure previousStructure, Structure newStructure) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param structure structure to delete
	 * @throws EmptyResultsQueryException 
	 */
	void deleteStructure(Structure structure) throws EmptyResultsQueryException;
	
	public List<Structure> getAllStructure() throws EmptyResultsQueryException;
		
	public Structure getStructureFromTraining(Training training) throws EmptyResultsQueryException;
	
}
