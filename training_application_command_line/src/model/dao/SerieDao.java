/**
 * 
 */
package model.dao;

import java.util.List;

import model.objects.Training;
import model.objects.TrainingComponent;
import model.objects.User;
import model.objects.Serie;

import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public interface SerieDao {
	

	/**
	 * 
	 * @param id_serie id requested
	 * @return serie which corresponds to the id param
	 * @throws EmptyResultsQueryException
	 */
	Serie getSerieById(Integer id_serie) throws EmptyResultsQueryException;
	
	List<Serie> getAllSeriesUser(User user) throws EmptyResultsQueryException;
	
	List<Serie> getAllSeriesTraining(User user, Training training) throws EmptyResultsQueryException;
	/**
	 * 
	 * @param serie which we want the id
	 * @return serie id corresponding
	 * @throws EmptyResultsQueryException
	 */
	Integer getSerieId(Serie serie, TrainingComponent trainingComponent, Training training, User user) throws EmptyResultsQueryException, InsertDataBaseException;
	
	
	/**
	 * 
	 * @param serie serie wanted
	 */
	void addSerie(Serie serie, TrainingComponent trainingComponent, User user, Training training, Integer layout) throws InsertDataBaseException;
	
	/**
	 * 
	 * @param previousSerie serie to change
	 * @param newSerie serie used to make the change
	 * @throws EmptyResultsQueryException
	 */
	void updateSerie(Serie previousSerie, Serie newSerie, TrainingComponent trainingComponent, Training training, User user, Integer layout) throws EmptyResultsQueryException, InsertDataBaseException;
	
	/**
	 * 
	 * @param serie serie to delete
	 */
	void deleteSerie(Serie serie, TrainingComponent trainingComponent, Training training, User user) throws EmptyResultsQueryException, InsertDataBaseException;
	
	List<Serie> getAllSerie() throws EmptyResultsQueryException;
	
	
}
