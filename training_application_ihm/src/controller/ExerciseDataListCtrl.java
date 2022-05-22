/*
 * 
 */
package controller;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.dao.DaoFactory;
import model.objects.Exercise;
import model.objects.Serie;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;


/**
 * For the third page of the main scene. Represents the user exercises datas.
 * @author Vincent Mastain
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class ExerciseDataListCtrl implements ChangeListener<String>, Observer {

	/** The exercise evolution. */
	private LineChart<String, Double> exerciseEvolution;

	/** The exercise list list. */
	private ListView<String> exerciseListList;

	/** The selected exercise. */
	private Exercise selectedExercise;

	/** The exercise list. */
	List<Exercise> exerciseList;

	/** The mark input. */
	TextField markInput;

	/** The rm input. */
	TextField rmInput;

	/** The user. */
	User user;

	/**
	 * Instantiates a new exercise data list ctrl.
	 *
	 * @param selectedExercise the selected exercise
	 * @param exerciseListList the exercise list list
	 * @param exerciseList the exercise list
	 * @param user the user
	 * @param markInput the mark input
	 * @param rmInput the rm input
	 * @param exerciseEvolution the exercise evolution
	 */
	public ExerciseDataListCtrl(Exercise selectedExercise, ListView<String> exerciseListList,
			List<Exercise> exerciseList, User user, TextField markInput, TextField rmInput,
			LineChart<String, Double> exerciseEvolution) {
		this.selectedExercise = selectedExercise;
		this.exerciseListList = exerciseListList;
		this.exerciseList = exerciseList;
		this.user = user;
		this.markInput = markInput;
		this.rmInput = rmInput;
		this.exerciseEvolution = exerciseEvolution;
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
		int index = exerciseListList.getSelectionModel().getSelectedIndex();

		if (index > 0) {
			selectedExercise.copy(this.exerciseList.get(index));
		} else {
			selectedExercise.copy(this.exerciseList.get(0));
		}
		try {
			DaoFactory.getInstance().getUserExerciseDataDao().getExerciseUserExerciseData(selectedExercise, user);
			markInput.setText(selectedExercise.getUserExerciseDatas().getMark().toString());
			rmInput.setText(selectedExercise.getUserExerciseDatas().getWeight().toString());

			List<Serie> previousTrainings = DaoFactory.getInstance().getSerieDao().getPreviousBestSeries(user,
					selectedExercise);
			XYChart.Series<String, Double> exerciseChartSerie = new XYChart.Series<>();
			previousTrainings.sort(null);
			for (Serie s : previousTrainings) {
				Double rm = user.getRm(s.getRepetitions(), s.getWeight());
				exerciseChartSerie.getData().add(new XYChart.Data<>(s.getDate(), rm));
			}
			exerciseEvolution.getData().clear();
			exerciseEvolution.getData().add(exerciseChartSerie);
		} catch (EmptyResultsQueryException | InsertDataBaseException e) {
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

	}

}
