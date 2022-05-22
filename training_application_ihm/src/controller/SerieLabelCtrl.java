/*
 * 
 */
package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.control.Label;
import model.dao.DaoFactory;
import model.objects.Exercise;
import model.objects.Serie;
import model.objects.exceptions.EmptyResultsQueryException;


/**
 * Name of the serie for the training scene.
 * @author Vincent Mastain
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class SerieLabelCtrl implements Observer {

	/** The exercise name. */
	private Label exerciseName;

	/** The serie. */
	private Serie serie;

	/**
	 * Instantiates a new serie label ctrl.
	 *
	 * @param serie the serie
	 * @param exerciseName the exercise name
	 */
	public SerieLabelCtrl(Serie serie, Label exerciseName) {
		this.serie = serie;
		this.exerciseName = exerciseName;
	}

	/**
	 * Update.
	 *
	 * @param o the o
	 * @param arg the arg
	 */
	@Override
	public void update(Observable o, Object arg) {
		Exercise exercise;
		try {
			exercise = DaoFactory.getInstance().getExerciseDao().getExerciseById(serie.getIdExercise());
			exerciseName.setText(exercise.getName() + "(" + serie.getLayout() + ") " + "Repos : " + serie.getRestDuration() + " sec");
		} catch (EmptyResultsQueryException e) {
		}
	}

}
