/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.BodyLimb;
import model.objects.exceptions.EmptyResultsQueryException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public interface BodyLimbDao {
	
	/**
	 * 
	 * @param id_body_limb id of the wanted body limb
	 * @return the bodylimb requested
	 * @throws EmptyResultsQueryException
	 */
	BodyLimb getBodyLimbById(Integer id_body_limb) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param name the name of the bodylimb
	 * @return the bodylimb requested
	 * @throws EmptyResultsQueryException
	 */
	BodyLimb getBodyLimbByName(String name) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param bodylimb body limb requested
	 * @return the id of the bodylimb wanted
	 * @throws EmpryResultsQueryException
	 */
	Integer getBodyLimbId(BodyLimb bodyLimb) throws EmptyResultsQueryException;
	/**
	 * 
	 * @param bodyLimb body to add
	 */
	void addBodyLimb(BodyLimb bodyLimb);
	
	/**
	 * 
	 * @param previousBodyLimb body limb wanted to change
	 * @param newBodyLimb the new body limb use to make the change
	 * @throws EmptyResultsQueryException 
	 */
	void updateBodyLimb(BodyLimb previousBodyLimb, BodyLimb newBodyLimb) throws EmptyResultsQueryException;
	
	/**
	 * 
	 * @param bodyLimb bodylib wanted to be delete
	 * @throws EmptyResultsQueryException 
	 */
	void deleteBodyLimb(BodyLimb bodyLimb) throws EmptyResultsQueryException;
	
	public List<BodyLimb> getAllBodyLimb() throws EmptyResultsQueryException;
	public BodyLimb getFirstBodyLimb() throws EmptyResultsQueryException;
}
