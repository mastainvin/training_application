package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.text.Text;
import model.objects.Training;

public class TrainingDetailsCtrl implements Observer {
	private Training training;
	private Text trainingDescriptionText;
	private Text trainingDurationText;
	
	public TrainingDetailsCtrl(Training training, Text trainingDescriptionText, Text trainingDurationText) {
		this.training = training;
		this.trainingDescriptionText = trainingDescriptionText;
		this.trainingDurationText = trainingDurationText;
	}
	@Override
	public void update(Observable o, Object arg) {
		trainingDescriptionText.setText(training.getDescription());
		trainingDurationText.setText(training.getDuration().toString());
	}

}
