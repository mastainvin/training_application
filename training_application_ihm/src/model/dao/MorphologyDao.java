/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Exercice;
import model.objects.Morphology;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface MorphologyDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface MorphologyDao {

	/**
	 * Adds the morphology.
	 *
	 * @param morphology the morphology
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addMorphology(Morphology morphology) throws InsertDataBaseException;

	/**
	 * Delete morphology.
	 *
	 * @param morphology morphology wanted to be delete
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteMorphology(Morphology morphology) throws EmptyResultsQueryException;

	/**
	 * Gets the all morphology.
	 *
	 * @return the all morphology
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public List<Morphology> getAllMorphology() throws EmptyResultsQueryException;

	/**
	 * Gets the exercice morphology.
	 *
	 * @param exercice the exercice
	 * @return the exercice morphology
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void getExerciceMorphology(Exercice exercice) throws EmptyResultsQueryException;

	/**
	 * Gets the first morphology.
	 *
	 * @return the first morphology in the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Morphology getFirstMorphology() throws EmptyResultsQueryException;

	/**
	 * Gets the morphology by id.
	 *
	 * @param morphology_id the id requested
	 * @return the corresponding morphology
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Morphology getMorphologyById(Integer morphology_id) throws EmptyResultsQueryException;

	/**
	 * Gets the morphology by name.
	 *
	 * @param name of the morphology
	 * @return the corresponding morphology
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Morphology getMorphologyByName(String name) throws EmptyResultsQueryException;

	/**
	 * Update morphology.
	 *
	 * @param morphology the morphology
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	void updateMorphology(Morphology morphology) throws EmptyResultsQueryException, InsertDataBaseException;

}
