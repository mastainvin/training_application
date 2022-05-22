/*
 * 
 */
package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.dao.DaoFactory;
import model.objects.Exercise;
import model.objects.UserExerciseData;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

/**
 * ChangeMark action controller.
 * @author Vincent Mastain
 * @version 1.0
 */
public class ChangeMarkCtrl implements Initializable {

	/** The trained exercises. */
	public List<Exercise> exerciseTrained;

	/** The thumb down. */
	@FXML
	private ImageView thumbDown;

	/** The thumb up. */
	@FXML
	private ImageView thumbUp;

	/**
	 * Instantiates a new change mark ctrl.
	 *
	 * @param exerciseTrained the exercise trained
	 */
	public ChangeMarkCtrl(List<Exercise> exerciseTrained) {
		super();
		this.exerciseTrained = exerciseTrained;
	}

	/**
	 * Creates the thumb down.
	 */
	public void createThumbDown() {
		thumbDown.setOnMouseClicked(e -> {
			for (Exercise exercise : exerciseTrained) {
				UserExerciseData userExerciseData = exercise.getUserExerciseDatas();
				userExerciseData.setMark((0 + userExerciseData.getMark()) / 2);
				try {
					DaoFactory.getInstance().getUserExerciseDataDao().updateUserExerciseData(userExerciseData);
				} catch (EmptyResultsQueryException | InsertDataBaseException e1) {
				}
			}
			
			quit();
		});
	}

	/**
	 * Creates the thumb up.
	 */
	public void createThumbUp() {
		thumbUp.setOnMouseClicked(e -> {
			for (Exercise exercise : exerciseTrained) {
				UserExerciseData userExerciseData = exercise.getUserExerciseDatas();
				userExerciseData.setMark((10 + userExerciseData.getMark()) / 2);
				try {
					DaoFactory.getInstance().getUserExerciseDataDao().updateUserExerciseData(userExerciseData);
				} catch (EmptyResultsQueryException | InsertDataBaseException e1) {
				}
				
			}
			quit();
		});
	}

	/**
	 * Initialize.
	 *
	 * @param arg0 the arg 0
	 * @param arg1 the arg 1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		createThumbDown();
		createThumbUp();
	}

	/**
	 * Save and quit.
	 */
	public void quit() {
		Stage stage = (Stage) thumbDown.getScene().getWindow();
		stage.close();

	}
}
