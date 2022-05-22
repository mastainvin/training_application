/*
 * 
 */
package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.objects.Serie;


/**
 * For the training view. The user can put the number of repetition that he done and the weight that he lift.
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class SerieInputCtrl implements ChangeListener<String>, Observer {

	/** The repetition input. */
	private TextField repetitionInput;

	/** The serie. */
	private Serie serie;

	/** The weight input. */
	private TextField weightInput;

	/** The valid button. */
	private Button validButton;
	
	/**
	 * Instantiates a new serie input ctrl.
	 *
	 * @param serie the serie
	 * @param weightInput the weight input
	 * @param repetitionInput the repetition input
	 * @param validButton the valid button
	 */
	public SerieInputCtrl(Serie serie, TextField weightInput, TextField repetitionInput, Button validButton) {
		this.serie = serie;
		this.weightInput = weightInput;
		this.repetitionInput = repetitionInput;
		this.validButton = validButton;
	}

	/**
	 * Changed.
	 *
	 * @param arg0 the arg 0
	 * @param arg1 the arg 1
	 * @param arg2 the arg 2
	 */
	@Override
	public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		String inputWeight = weightInput.getText();
		String inputRepetition = repetitionInput.getText();
		if (utils.Utils.isInteger(inputRepetition) && utils.Utils.isNumeric(inputWeight)) {
			Double weight = Double.parseDouble(inputWeight);
			Integer repetition = Integer.parseInt(inputRepetition);
			if(weight >= 0 && weight <= 1000 && repetition >= 0 && repetition <= 1000) {
				serie.setWeight(weight);
				serie.setRepetitions(repetition);
				validButton.setDisable(false);
			} else {
				validButton.setDisable(true);
			}
		} else {
			validButton.setDisable(true);
		}

	}

	/**
	 * Update.
	 *
	 * @param o the o
	 * @param arg the arg
	 */
	@Override
	public void update(Observable o, Object arg) {
		repetitionInput.setText(serie.getExpectedRepetitions().toString());
		weightInput.setText(serie.getExpectedWeight().toString());
	}

}
