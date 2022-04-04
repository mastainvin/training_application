/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Disponibility;

import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public interface DisponibilityDao {
	
	/**
	 * 
	 * @return Frist disponibility of the db
	 * @throws EmptyResultsQueryException
	 */
	Disponibility getFirstDisponibility() throws EmptyResultsQueryException;
	

	/**
	 * 
	 * @param id_disponibility id requested
	 * @return disponibility which corresponds to the id param
	 * @throws EmptyResultsQueryException
	 */
	Disponibility getDisponibilityById(Integer id_disponibility) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param disponibility which we want the id
	 * @return disponibility id corresponding
	 * @throws EmptyResultsQueryException
	 */
	Integer getDisponibilityId(Disponibility disponibility) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param disponibility disponibility wanted
	 */
	void addDisponibility(Disponibility disponibility);
	
	/**
	 * 
	 * @param previousDisponibility disponibility to change
	 * @param newDisponibility disponibility used to make the change
	 * @throws EmptyResultsQueryException
	 */
	void updateDisponibility(Disponibility previousDisponibility, Disponibility newDisponibility) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param disponibility disponibility to delete
	 * @throws EmptyResultsQueryException 
	 */
	void deleteDisponibility(Disponibility disponibility) throws EmptyResultsQueryException;
	
	public List<Disponibility> getAllDisponibility() throws EmptyResultsQueryException;
}
