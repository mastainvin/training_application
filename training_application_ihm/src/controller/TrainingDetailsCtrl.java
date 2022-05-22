/*
 * 
 */
package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.text.Text;
import model.objects.Training;


/**
 * Details of the training (not use yet).
 * 
 * @author Vincent Mastain
 * @version 1.0
 */

@SuppressWarnings("deprecation")
public class TrainingDetailsCtrl implements Observer {

	/** The training. */
	private Training training;

	/** The training description text. */
	private Text trainingDescriptionText;

	/** The training duration text. */
	private Text trainingDurationText;

	/**
	 * Instantiates a new training details ctrl.
	 *
	 * @param training the training
	 * @param trainingDescriptionText the training description text
	 * @param trainingDurationText the training duration text
	 */
	public TrainingDetailsCtrl(Training training, Text trainingDescriptionText, Text trainingDurationText) {
		this.training = training;
		this.trainingDescriptionText = trainingDescriptionText;
		this.trainingDurationText = trainingDurationText;
	}

	/**
	 * Update.
	 *
	 * @param o the o
	 * @param arg the arg
	 */
	@Override
	public void update(Observable o, Object arg) {
		trainingDescriptionText.setText(training.getDescription());
		trainingDurationText.setText(training.getDuration().toString());
	}

}
