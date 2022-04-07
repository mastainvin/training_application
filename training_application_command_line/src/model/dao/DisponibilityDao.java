/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Disponibility;

import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface DisponibilityDao.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public interface DisponibilityDao {
	
	/**
	 * Gets the first disponibility.
	 *
	 * @return Frist disponibility of the db
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Disponibility getFirstDisponibility() throws EmptyResultsQueryException;
	

	/**
	 * Gets the disponibility by id.
	 *
	 * @param id_disponibility id requested
	 * @return disponibility which corresponds to the id param
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	Disponibility getDisponibilityById(Integer id_disponibility) throws EmptyResultsQueryException;
	

	/**
	 * Adds the disponibility.
	 *
	 * @param disponibility disponibility wanted
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void addDisponibility(Disponibility disponibility) throws InsertDataBaseException;
	
	/**
	 * Update disponibility.
	 *
	 * @param disponibility the disponibility
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException the insert data base exception
	 */
	void updateDisponibility(Disponibility disponibility) throws EmptyResultsQueryException, InsertDataBaseException;
	
	/**
	 * Delete disponibility.
	 *
	 * @param disponibility disponibility to delete
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	void deleteDisponibility(Disponibility disponibility) throws EmptyResultsQueryException;
	
	/**
	 * Gets the all disponibility.
	 *
	 * @return the all disponibility
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public List<Disponibility> getAllDisponibility() throws EmptyResultsQueryException;
}
