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
 * For the first page of the main scene. Represents the list of exercise and the action of changing the
 * selected Exercise.
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class ExerciseListCtrl implements Observer, ChangeListener<String> {

	/** The exercise list. */
	private ListView<String> exerciseList;

	/** The exercises in training. */
	private List<Exercise> exercisesInTraining;

	/** The selected exercise. */
	private Exercise selectedExercise;

	/** The selected training. */
	private Training selectedTraining;

	/**
	 * Instantiates a new exercise list ctrl.
	 *
	 * @param selectedTraining the selected training
	 * @param exerciseList the exercise list
	 * @param selectedExercise the selected exercise
	 * @param exercisesInTraining the exercises in training
	 */
	public ExerciseListCtrl(Training selectedTraining, ListView<String> exerciseList, Exercise selectedExercise,
			List<Exercise> exercisesInTraining) {
		this.selectedTraining = selectedTraining;
		this.exerciseList = exerciseList;
		this.selectedExercise = selectedExercise;
		this.exercisesInTraining = exercisesInTraining;

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
			selectedExercise.copy(this.exercisesInTraining.get(index));
		} else {
			selectedExercise.copy(this.exercisesInTraining.get(0));
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
		List<String> exerciseListName = new ArrayList<>();

		exercisesInTraining.clear();
		for (TrainingComponent trainingComponent : selectedTraining.getTrainingComponentList()) {
			for (Exercise exercise : trainingComponent.getExercisesList()) {
				if (!exercisesInTraining.contains(exercise)) {
					exercisesInTraining.add(exercise);
				}

			}
		}

		for (Exercise exercise : exercisesInTraining) {
			exerciseListName.add(exercise.getName());
		}
		ObservableList<String> names = FXCollections.observableArrayList(exerciseListName);

		exerciseList.getItems().clear();
		exerciseList.getItems().addAll(names);
		exerciseList.getSelectionModel().select(0);
		selectedExercise.copy(this.exercisesInTraining.get(0));
	}

}
