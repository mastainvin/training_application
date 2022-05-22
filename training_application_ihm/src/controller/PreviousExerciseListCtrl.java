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
import model.objects.Serie;
import model.objects.Training;
import model.objects.TrainingComponent;


/**
 *	For the second scene of the application. Represent the choise of an selected exercise in the list after chose
 * the training in the tree. (Not use yet).
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class PreviousExerciseListCtrl implements Observer, ChangeListener<String> {

	/** The exercise list. */
	private ListView<String> exerciseList;

	/** The selected exercise. */
	private Exercise selectedExercise;

	/** The selected training. */
	private Training selectedTraining;

	/**
	 * Instantiates a new previous exercise list ctrl.
	 *
	 * @param selectedTraining the selected training
	 * @param exerciseList the exercise list
	 * @param selectedExercise the selected exercise
	 */
	public PreviousExerciseListCtrl(Training selectedTraining, ListView<String> exerciseList,
			Exercise selectedExercise) {
		this.selectedTraining = selectedTraining;
		this.exerciseList = exerciseList;
		this.selectedExercise = selectedExercise;

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
			selectedExercise.copy(this.selectedTraining.getTrainingComponentList().get(index).getChosenExercise());
		} else {
			selectedExercise.copy(this.selectedTraining.getTrainingComponentList().get(0).getChosenExercise());
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

		List<String> serieList = new ArrayList<>();
		for (TrainingComponent trainingComponent : selectedTraining.getTrainingComponentList()) {
			for (Serie serie : trainingComponent.getSeriesList()) {
				Exercise exercise = null;
				for (Exercise e : trainingComponent.getExercisesList()) {
					if (e.getIdExercise() == serie.getIdExercise()) {
						exercise = e;
					}
				}
				serieList.add(exercise.getName() + " charge : " + serie.getWeight() + " répétitions : "
						+ serie.getRepetitions());
			}

		}
		ObservableList<String> names = FXCollections.observableArrayList(serieList);

		exerciseList.getItems().clear();
		exerciseList.getItems().addAll(names);

		exerciseList.getSelectionModel().select(0);
	}

}
