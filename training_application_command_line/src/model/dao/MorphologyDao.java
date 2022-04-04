/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Morphology;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public interface MorphologyDao {
	
	/**
	 * 
	 * @return the first morphology in the db
	 * @throws EmptyResultsQueryException
	 */
	Morphology getFirstMorphology() throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param name of the morphology
	 * @return the corresponding morphology
	 * @throws EmptyResultsQueryException
	 */
	Morphology getMorphologyByName(String name) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param morphology_id the id requested
	 * @return the corresponding morphology
	 * @throws EmptyResultsQueryException
	 */
	Morphology getMorphologyById(Integer morphology_id) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param morphology the morphology which we want the id
	 * @return the morphology's id
	 * @throws EmptyResultsQueryException
	 */
	Integer getMorphologyId(Morphology morphology) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param Morphology morphology to add
	 */
	void addMorphology(Morphology Morphology);
	
	/**
	 * 
	 * @param previousMorphology morphology to change
	 * @param newMorphology morphology used to change
	 * @throws EmptyResultsQueryException
	 */
	void updateMorphology(Morphology previousMorphology, Morphology newMorphology) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param morphology morphology wanted to be delete
	 * @throws EmptyResultsQueryException 
	 */
	void deleteMorphology(Morphology morphology) throws EmptyResultsQueryException;
	
	public List<Morphology> getAllMorphology() throws EmptyResultsQueryException;
}
