/*
 * 
 */
package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.text.Text;
import model.objects.Exercise;


/**
 * For the first page of the main scene. It's the description the exercise (not use for the moment).
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class ExerciseDetailsCtrl implements Observer {

	/** The exercise description text. */
	private Text exerciseDescriptionText;

	/** The selected exercise. */
	private Exercise selectedExercise;

	/**
	 * Instantiates a new exercise details ctrl.
	 *
	 * @param selectedExercise the selected exercise
	 * @param exerciseDescriptionText the exercise description text
	 */
	public ExerciseDetailsCtrl(Exercise selectedExercise, Text exerciseDescriptionText) {
		this.selectedExercise = selectedExercise;
		this.exerciseDescriptionText = exerciseDescriptionText;
	}

	/**
	 * Update.
	 *
	 * @param o the o
	 * @param arg the arg
	 */
	@Override
	public void update(Observable o, Object arg) {
		exerciseDescriptionText.setText(selectedExercise.getDescription());
	}

}
