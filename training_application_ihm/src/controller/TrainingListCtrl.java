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
import model.objects.Training;
import model.objects.User;


/**
 * The training list controller. Changing when the user change his training.
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class TrainingListCtrl implements Observer, ChangeListener<String> {

	/** The selected training. */
	private Training selectedTraining;

	/** The training list. */
	private ListView<String> trainingList;

	/** The user. */
	private User user;

	/**
	 * Instantiates a new training list ctrl.
	 *
	 * @param user the user
	 * @param trainingList the training list
	 * @param selectedTraining the selected training
	 */
	public TrainingListCtrl(User user, ListView<String> trainingList, Training selectedTraining) {
		this.user = user;
		this.trainingList = trainingList;
		this.selectedTraining = selectedTraining;
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
		int index = trainingList.getSelectionModel().getSelectedIndex();
		if (index > 0) {
			selectedTraining.copy(user.getStructure().getTrainingsList().get(index));
		} else {
			selectedTraining.copy(user.getStructure().getTrainingsList().get(0));
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
		List<String> trainingListName = new ArrayList<>();
		for (Training training : user.getStructure().getTrainingsList()) {
			trainingListName.add(training.getName());
		}
		ObservableList<String> names = FXCollections.observableArrayList(trainingListName);

		trainingList.getItems().clear();
		trainingList.getItems().addAll(names);

		trainingList.getSelectionModel().select(0);
		selectedTraining.copy(user.getStructure().getTrainingsList().get(0));

	}

}
