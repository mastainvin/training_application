/*
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import model.objects.Exercise;
import model.objects.Serie;
import model.objects.TrainingComponent;


/**
 * For the main scene. For the selectraining component (exercise) we show the series that the user have to do.
 * 
 * @author Vincent Mastain 
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class SerieListCtrl implements Observer {

	/** The selected training component. */
	private TrainingComponent selectedTrainingComponent;

	/** The serie list. */
	private ListView<String> serieList;

	/**
	 * Instantiates a new serie list ctrl.
	 *
	 * @param selectedTrainingComponent the selected training component
	 * @param serieList the serie list
	 */
	public SerieListCtrl(TrainingComponent selectedTrainingComponent, ListView<String> serieList) {
		this.serieList = serieList;
		this.selectedTrainingComponent = selectedTrainingComponent;

	}

	/**
	 * Update.
	 *
	 * @param o the o
	 * @param arg the arg
	 */
	@Override
	public void update(Observable o, Object arg) {
		List<String> series = new ArrayList<>();
		for (Serie serie : selectedTrainingComponent.getSeriesList()) {
			Exercise exercise = null;
			for (Exercise e : selectedTrainingComponent.getExercisesList()) {
				if (e.getIdExercise() == serie.getIdExercise()) {
					exercise = e;
				}
			}
			series.add(exercise.getName() + " charge : " + serie.getExpectedWeight() + " répétitions : "
					+ serie.getExpectedRepetitions() + " repos : " + serie.getRestDuration() + " sec");
		}
		ObservableList<String> names = FXCollections.observableArrayList(series);

		serieList.getItems().clear();
		serieList.getItems().addAll(names);
	}

}
