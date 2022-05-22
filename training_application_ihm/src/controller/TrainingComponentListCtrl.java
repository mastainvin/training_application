/*
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import model.objects.Exercise;
import model.objects.Training;
import model.objects.TrainingComponent;


/**
 * For the main scene. Show all the training component in the selected training.
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class TrainingComponentListCtrl implements Observer, ChangeListener<String> {

	/** The exercise list. */
	private ListView<String> exerciseList;

	/** The selected training. */
	private Training selectedTraining;

	/** The selected training component. */
	private TrainingComponent selectedTrainingComponent;

	/**
	 * Instantiates a new training component list ctrl.
	 *
	 * @param selectedTraining the selected training
	 * @param exerciseList the exercise list
	 * @param selectedTrainingComponent the selected training component
	 */
	public TrainingComponentListCtrl(Training selectedTraining, ListView<String> exerciseList,
			TrainingComponent selectedTrainingComponent) {
		this.selectedTraining = selectedTraining;
		this.exerciseList = exerciseList;
		this.selectedTrainingComponent = selectedTrainingComponent;

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
		int index = exerciseList.getSelectionModel().getSelectedIndex();

		if (index > 0) {
			selectedTrainingComponent.copy(this.selectedTraining.getTrainingComponentList().get(index));
		} else {
			selectedTrainingComponent.copy(this.selectedTraining.getTrainingComponentList().get(0));
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
		List<String> exerciseListname = new ArrayList<>();
		for (TrainingComponent trainingComponent : selectedTraining.getTrainingComponentList()) {
			String exercises = "";
			for (Exercise exercise : trainingComponent.getExercisesList()) {
				exercises += exercise.getName() + " ";
			}
			exerciseListname.add(exercises);

		}
		ObservableList<String> names = FXCollections.observableArrayList(exerciseListname);

		exerciseList.getItems().clear();
		exerciseList.getItems().addAll(names);
		exerciseList.getSelectionModel().select(0);
		selectedTrainingComponent.copy(selectedTraining.getTrainingComponentList().get(0));
	}

}
