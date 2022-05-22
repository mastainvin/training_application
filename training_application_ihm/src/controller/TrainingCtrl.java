/*
 * 
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.dao.DaoFactory;
import model.objects.Exercise;
import model.objects.Serie;
import model.objects.Structure;
import model.objects.Training;
import model.objects.TrainingComponent;
import model.objects.User;
import model.objects.UserExerciseData;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;
import utils.DateGroup;

/**
 * The training scene
 * <br>
 * The scene make a loop around every training component and for earch serie in them he show the weight 
 * and the number of repetition the user have to make. When a component he finish he ask to the user if he likes 
 * to make the exercise or not (The exercise mark will be impacted).
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
public class TrainingCtrl implements Initializable {

	/** The exercise name. */
	@FXML
	private Label exerciseName;

	/** The repetition input. */
	@FXML
	private TextField repetitionInput;

	/** The serie in training. */
	private Serie serieInTraining;

	/** The today training. */
	private Training todayTraining;

	/** The serie index. */
	private Integer trainingComponentIndex, serieIndex;

	/** The user. */
	private User user;

	/** The valid button. */
	@FXML
	private Button validButton;

	/** The weight input. */
	@FXML
	private TextField weightInput;

	/** The best rms. */
	private double[] bestRms;
	
	/** The date group. */
	private DateGroup dateGroup;
	
	/**
	 * Instantiates a new training ctrl.
	 *
	 * @param user the user
	 * @param structureWithoutSuperset the structure without superset
	 * @param dateGroup the date group
	 */
	public TrainingCtrl(User user, Structure structureWithoutSuperset, DateGroup dateGroup) {
		super();
		this.user = user;
		todayTraining = user.getStructure().getTrainingsList().get(0);
		serieInTraining = todayTraining.getTrainingComponentList().get(0).getSeriesList().get(0);
		trainingComponentIndex = 0;
		serieIndex = 0;
		bestRms = new double[10];
		this.dateGroup = dateGroup;
	}

	/**
	 * Ask mark.
	 * Open a new scene with the thumbs buttons (good or bad).
	 */
	public void askMark() {
		TrainingComponent trainingComponent = todayTraining.getTrainingComponentList().get(trainingComponentIndex);
		List<Exercise> exerciseTrained = trainingComponent.getExercisesList();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/changeMark.fxml"));

		ChangeMarkCtrl changeMarkCtrl = new ChangeMarkCtrl(exerciseTrained);
		loader.setController(changeMarkCtrl);

		Scene applicationView = null;
		try {
			applicationView = loader.load();
		} catch (IOException e1) {
		}
		// New window (Stage)
		Stage newWindow = new Stage();

		// Specifies the modality for new window.
		newWindow.initModality(Modality.WINDOW_MODAL);

		// Specifies the owner Window (parent) for new window
		newWindow.initOwner(validButton.getScene().getWindow());

		newWindow.setTitle("C'était bien ?");
		newWindow.setScene(applicationView);
		newWindow.showAndWait();

	}
	

	/*
	 * Change the actual exercise RM
	 */
	public void changeRm() {
		TrainingComponent trainingComponent = todayTraining.getTrainingComponentList().get(trainingComponentIndex);
		for(Exercise exercise :trainingComponent.getExercisesList()) {
			UserExerciseData exerciseData = exercise.getUserExerciseDatas();
			try {
				exerciseData.setNbDone(exerciseData.getNbDone() + 1);
				DaoFactory.getInstance().getUserExerciseDataDao().updateUserExerciseData(exerciseData);
			} catch (EmptyResultsQueryException | InsertDataBaseException e) {
			}
		}
		
	}
	/**
	 * Creates the serie ctrl.
	 */
	@SuppressWarnings("deprecation")
	public void createSerieCtrl() {
		repetitionInput.setText(serieInTraining.getExpectedRepetitions().toString());
		weightInput.setText(serieInTraining.getExpectedWeight().toString());
		serieInTraining.setWeight(serieInTraining.getExpectedWeight() * 1.0);
		serieInTraining.setRepetitions(serieInTraining.getExpectedRepetitions());

		Exercise exercise;
		try {
			exercise = DaoFactory.getInstance().getExerciseDao().getExerciseById(serieInTraining.getIdExercise());
			exerciseName.setText(exercise.getName() + " (1) " + "Repos : " + serieInTraining.getRestDuration() + " sec");
		} catch (EmptyResultsQueryException e) {
		}

		SerieInputCtrl serieInputCtrl = new SerieInputCtrl(serieInTraining, weightInput, repetitionInput, validButton);
		serieInTraining.addObserver(serieInputCtrl);
		weightInput.textProperty().addListener(serieInputCtrl);
		repetitionInput.textProperty().addListener(serieInputCtrl);

		SerieLabelCtrl serieLabelCtrl = new SerieLabelCtrl(serieInTraining, exerciseName);
		serieInTraining.addObserver(serieLabelCtrl);
	}

	/**
	 * Creates the valid button.
	 */
	public void createValidButton() {
		validButton.setOnAction(e -> {
			String date = java.time.LocalDate.now().toString();
			serieInTraining.setDate(date);
			TrainingComponent trainingComponent = todayTraining.getTrainingComponentList().get(trainingComponentIndex);
			try {
				DaoFactory.getInstance().getSerieDao().updateSerie(serieInTraining);
			} catch (EmptyResultsQueryException | InsertDataBaseException e1) {
			}
			
			// If we are still in the same component
			if (serieIndex + 1 < todayTraining.getTrainingComponentList().get(trainingComponentIndex).getSeriesList()
					.size()) {
				serieIndex++;
				Double newRM = user.getRm(serieInTraining.getRepetitions(), serieInTraining.getWeight());
				Exercise exercise = null;
				for(Exercise e1 : trainingComponent.getExercisesList()) {
					if(serieInTraining.getIdExercise() == e1.getIdExercise()) {
						exercise = e1;
					}
				}
				if(newRM > exercise.getUserExerciseDatas().getWeight()) {
					 exercise.getUserExerciseDatas().setWeight(newRM);
				}
			// If we change the component but it's not the last one.
			} else if (trainingComponentIndex + 1 < todayTraining.getTrainingComponentList().size()) {
				askMark();
				changeRm();
				serieIndex = 0;
				trainingComponentIndex++;
				for(int i = 0; i<bestRms.length ; i++) {
					bestRms[i] = 0;
				}
			} else { // If it's the last one.
				askMark();
				changeRm();
				User usertmp = user;
				usertmp.getStructure().getTrainingsList().remove(0);
				if (usertmp.getStructure().getTrainingsList().size() == 0) {
					try {
						DaoFactory.getInstance().getSerieDao().finishAllUserSeries(user);
						usertmp.setStructure(null);
						usertmp.createOrUpdateTraining(DaoFactory.getInstance());
						usertmp.setStructure(usertmp.getTrainingSuperSet(
								DaoFactory.getInstance().getSerieDao().getNextTrainingsSerie(usertmp),
								DaoFactory.getInstance()));
						usertmp.getTraining(
								DaoFactory.getInstance().getSerieDao().getNextTrainingsSerie(usertmp),
								DaoFactory.getInstance());
					} catch (EmptyResultsQueryException | InsertDataBaseException e1) {
					}
				}
				user.copy(usertmp);
				dateGroup.addDate(date);
				Stage stage = (Stage) validButton.getScene().getWindow();
				stage.close();
			}
			serieInTraining.copy(todayTraining.getTrainingComponentList().get(trainingComponentIndex).getSeriesList()
					.get(serieIndex));
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
		createSerieCtrl();
		createValidButton();

	}

}
