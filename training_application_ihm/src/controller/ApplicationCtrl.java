/*
 * 
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.dao.DaoFactory;
import model.objects.Disponibility;
import model.objects.Exercise;
import model.objects.Serie;
import model.objects.Structure;
import model.objects.Training;
import model.objects.TrainingComponent;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;
import utils.DateGroup;


/**
 * The main scene of the application.
 * <br>
 * Split in 3 panels :
 * <ul>
 * <li><h6>Planning</h6> which contains the list of week's trainings. We can modify our training program
 * by modificate the number of hours we want to train. Or by remove an exercise from all the training if we doesn't want him
 * in our training.</li>
 * <li><h6>Historic</h6> with a tree view that may let us chose the training we want to see the series that we did.</li>
 * <li><h6>Exercises Data</h6> for every exercise each user can put a mark and the RM on him. We also display the progress
 * of the user. </li>
 * </li>
 * <br>
 * Every method ctrl in the class work like this :
 * <ol>
 * 	<li>Initialize the view object with the data</li>
 * 	<li>Create a controller associate to the view object</li>
 * </ol>
 * <br>
 * The actions methods are used to valid a modification in the database (like remove an exercise).
 * 
 * <br>
 * Here is the list of the action controller use in this class :
 * <ul>
 * 	<li>ChangeMarkCtrl.java</li>
 * 	<li>ExerciseDataListCtrl.java</li>
 * 	<li>ExerciseDetailsCtrl.java</li>
 * 	<li>ExerciseListCtrl.java</li>
 * 	<li>PreviousExerciseListCtrl.java</li>
 * 	<li>PreviousTrainingTreeCtrl.java</li>
 * 	<li>TrainingComponentListCtrl.java</li>
 * 	<li>TrainingDetailsCtrl.java</li>
 * 	<li>TrainingListCtrl.java</li>
 * </ul>
 * @author Vincent Mastain
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class ApplicationCtrl implements Initializable {

	/** The date group. */
	private DateGroup dateGroup;

	/** The date X chart. */
	@FXML
	private CategoryAxis dateXChart;

	/** The exercise description history. */
	@FXML
	private Text exerciseDescriptionHistory;

	/** The exercise description text. */
	@FXML
	private Text exerciseDescriptionText;

	/** The exercise evolution. */
	@FXML
	private LineChart<String, Double> exerciseEvolution;

	/** The exercise list. */
	@FXML
	private ListView<String> exerciseList;

	/** The exercise list list. */
	@FXML
	private ListView<String> exerciseListList;

	/** The exercises in training. */
	private List<Exercise> exercisesInTraining;

	/** The first disponibility choice box. */
	@FXML
	private ChoiceBox<String> firstDisponibilityChoiceBox;

	/** The force update training button. */
	@FXML
	private Button forceUpdateTrainingButton;

	/** The mark input. */
	@FXML
	private TextField markInput;

	/** The previous exercise selected. */
	private Exercise previousExerciseSelected;

	/** The previous training selected. */
	private Training previousTrainingSelected;

	/** The previous training tree. */
	@FXML
	private TreeView<String> previousTrainingTree;

	/** The replace exercise button. */
	@FXML
	private Button replaceExerciseButton;

	/** The replace in every training exercise button. */
	@FXML
	private Button replaceInEveryTrainingExerciseButton;

	/** The rm input. */
	@FXML
	private TextField rmInput;

	/** The rm Y chart. */
	@FXML
	private NumberAxis rmYChart;

	/** The second disponibility choice box. */
	@FXML
	private ChoiceBox<String> secondDisponibilityChoiceBox;

	/** The selected exercise. */
	private Exercise selectedExercise;

	/** The selected exercise data. */
	private Exercise selectedExerciseData;

	/** The selected training. */
	private Training selectedTraining;

	/** The selected training component. */
	private TrainingComponent selectedTrainingComponent;

	/** The serie list. */
	@FXML
	private ListView<String> serieList;

	/** The serie list history. */
	@FXML
	private ListView<String> serieListHistory;

	/** The start training button. */
	@FXML
	private Button startTrainingButton;

	/** The structure without superset. */
	private Structure structureWithoutSuperset;

	/** The training component list. */
	@FXML
	private ListView<String> trainingComponentList;

	/** The training description history text. */
	@FXML
	private Text trainingDescriptionHistoryText;

	/** The training description text. */
	@FXML
	private Text trainingDescriptionText;

	/** Tue label use to inform the modification / error of the training */
	@FXML
	private Label trainingModificationLabel;
	
	/** The training duration history text. */
	@FXML
	private Text trainingDurationHistoryText;

	/** The training duration text. */
	@FXML
	private Text trainingDurationText;

	/** The training list. */
	@FXML
	private ListView<String> trainingList;

	/** The user. */
	private User user;

	/** The valid disponibilities. */
	@FXML
	private Button validDisponibilities;

	/** The valid exercise data. */
	@FXML
	private Button validExerciseData;

	/**
	 * Instantiates a new application ctrl.
	 *
	 * @param user the user
	 */
	public ApplicationCtrl(User user) {
		super();
		this.user = user;
		this.selectedTraining = new Training();
		this.selectedTraining.copy(user.getStructure().getTrainingsList().get(0));

		this.selectedTrainingComponent = new TrainingComponent();
		this.selectedTrainingComponent
				.copy(user.getStructure().getTrainingsList().get(0).getTrainingComponentList().get(0));

		this.dateGroup = new DateGroup();
		List<String> allUserDates;
		try {
			allUserDates = DaoFactory.getInstance().getSerieDao().getAllDateTraining(user);
			for (String date : allUserDates) {
				dateGroup.addDate(date);
			}
		} catch (EmptyResultsQueryException | InsertDataBaseException e) {
		}

		previousTrainingSelected = new Training();
		previousExerciseSelected = new Exercise();

		exercisesInTraining = new ArrayList<>();

		selectedExercise = new Exercise();

		try {
			structureWithoutSuperset = user.getTraining(
					DaoFactory.getInstance().getSerieDao().getNextTrainingsSerie(user), DaoFactory.getInstance());
		} catch (EmptyResultsQueryException | InsertDataBaseException e) {
		}

		selectedExerciseData = new Exercise();
	}

	/**
	 * Initialize.
	 *
	 * @param arg0 the arg 0
	 * @param arg1 the arg 1
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		createTrainingList();
		createTrainingComponentList();
		createSerieList();
		createExerciseList();
		removeExerciseButtons();
		createFirstTrainingChoiceBox();
		createSecondTrainingChoiceBox();
		changeDisponibilitiesButton();
		createForceUpdateTrainingButton();
		createStartTrainingButton();

		createTrainingHistoryTree();
		createPreviousExerciseList();

		createExerciseDataList();
		createValidDataButton();
	}

	/**
	 * Change disponibilities button.
	 */
	public void changeDisponibilitiesButton() {
		validDisponibilities.setOnAction(e -> {
			int firstChoice = firstDisponibilityChoiceBox.getSelectionModel().getSelectedIndex();
			int secondChoice = secondDisponibilityChoiceBox.getSelectionModel().getSelectedIndex();

			if (firstChoice >= 0 && secondChoice >= 0) {

				int firstDuration = 0;
				int secondDuration = 0;
				if (firstChoice == 0) {
					firstDuration = Disponibility.Duration.MEDIUM.getTimeInSeconds();
				} else {
					firstDuration = Disponibility.Duration.LONG.getTimeInSeconds();
				}

				if (secondChoice == 0) {
					secondDuration = Disponibility.Duration.MEDIUM.getTimeInSeconds();
				} else {
					secondDuration = Disponibility.Duration.LONG.getTimeInSeconds();
				}

				try {
					List<Disponibility> userDisponibilities = DaoFactory.getInstance().getCanTrainOnDao()
							.getDisponibilities(user.getIdUser());

					for (Training t : user.getStructure().getTrainingsList()) {
						if ((t.getLayout() == 1 && firstDuration != t.getDuration())
								|| (t.getLayout() == 2 && secondDuration != t.getDuration())) {
							for (TrainingComponent tc : t.getTrainingComponentList()) {
								for (Serie s : tc.getSeriesList()) {
									try {
										DaoFactory.getInstance().getSerieDao().deleteSerie(s, tc, t, user);
									} catch (EmptyResultsQueryException | InsertDataBaseException e1) {
									}
								}
							}
						}
						for (Disponibility d : userDisponibilities) {
							try {
								DaoFactory.getInstance().getCanTrainOnDao()
										.deleteCompatibleDisponibility(user.getIdUser(), d.getIdDisponibility());

							} catch (SQLIntegrityConstraintViolationException e1) {
							}
						}

					}
				} catch (EmptyResultsQueryException e1) {
				}

				try {

					Integer id_disponibility1 = DaoFactory.getInstance().getDisponibilityDao()
							.getDisponibility(firstDuration, 1).getIdDisponibility();
					DaoFactory.getInstance().getCanTrainOnDao().addCompatibleDisponibility(user.getIdUser(),
							id_disponibility1);

					Integer id_disponibility2 = DaoFactory.getInstance().getDisponibilityDao()
							.getDisponibility(secondDuration, 2).getIdDisponibility();
					DaoFactory.getInstance().getCanTrainOnDao().addCompatibleDisponibility(user.getIdUser(),
							id_disponibility2);

				} catch (EmptyResultsQueryException e1) {
				} catch (SQLIntegrityConstraintViolationException e1) {
				}

				resetTraining();
				updateTraining();
			}
		});
	}

	/**
	 * Creates the exercise data list.
	 */
	public void createExerciseDataList() {
		List<String> exerciseName = new ArrayList<>();
		try {
			List<Exercise> exerciseList = DaoFactory.getInstance().getExerciseDao().getAllExercise();
			for (Exercise exercise : exerciseList) {
				exerciseName.add(exercise.getName());
			}
			ObservableList<String> names = FXCollections.observableArrayList(exerciseName);

			exerciseListList.getItems().addAll(names);
			selectedExerciseData = exerciseList.get(0);
			DaoFactory.getInstance().getUserExerciseDataDao().getExerciseUserExerciseData(selectedExerciseData, user);

			ExerciseDataListCtrl exerciseDataListCtrl = new ExerciseDataListCtrl(selectedExerciseData, exerciseListList,
					exerciseList, user, markInput, rmInput, exerciseEvolution);
			exerciseListList.getSelectionModel().selectedItemProperty().addListener(exerciseDataListCtrl);
		} catch (EmptyResultsQueryException e) {
		}
	}

	/**
	 * Creates the first training choice box.
	 */
	public void createFirstTrainingChoiceBox() {
		try {
			Disponibility disponibility1 = DaoFactory.getInstance().getDisponibilityDao().getDisponibility(90, 1);
			Disponibility disponibility2 = DaoFactory.getInstance().getDisponibilityDao().getDisponibility(120, 1);

			ObservableList<String> names = FXCollections.observableArrayList(disponibility1.toString(),
					disponibility2.toString());

			firstDisponibilityChoiceBox.getItems().addAll(names);
		} catch (EmptyResultsQueryException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates the force update training button.
	 */
	public void createForceUpdateTrainingButton() {
		forceUpdateTrainingButton.setOnAction(e -> {
			try {
				DaoFactory.getInstance().getSerieDao().finishAllUserSeries(user);
			} catch (EmptyResultsQueryException e1) {

			}
			resetTraining();
		});
	}

	/**
	 * Creates the previous exercise list.
	 */
	public void createPreviousExerciseList() {
		PreviousExerciseListCtrl previousExerciseListCtrl = new PreviousExerciseListCtrl(this.previousTrainingSelected,
				serieListHistory, previousExerciseSelected);
		this.previousTrainingSelected.addObserver(previousExerciseListCtrl);
	}

	/**
	 * Creates the second training choice box.
	 */
	public void createSecondTrainingChoiceBox() {
		try {
			Disponibility disponibility1 = DaoFactory.getInstance().getDisponibilityDao().getDisponibility(90, 2);
			Disponibility disponibility2 = DaoFactory.getInstance().getDisponibilityDao().getDisponibility(120, 2);

			ObservableList<String> names = FXCollections.observableArrayList(disponibility1.toString(),
					disponibility2.toString());

			secondDisponibilityChoiceBox.getItems().addAll(names);
		} catch (EmptyResultsQueryException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates the start training button.
	 */
	public void createStartTrainingButton() {
		startTrainingButton.setOnAction(e -> {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/training.fxml"));

			TrainingCtrl trainingCtrl = new TrainingCtrl(user, structureWithoutSuperset, dateGroup);
			loader.setController(trainingCtrl);

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
			newWindow.initOwner(((Node) e.getSource()).getScene().getWindow());

			newWindow.setTitle("Entrainement");
			newWindow.setScene(applicationView);
			newWindow.show();
		});
	}

	/**
	 * training history page.
	 */

	public void createTrainingHistoryTree() {

		TreeItem<String> root = new TreeItem<>();
		root.setExpanded(true);

		for (Integer year : dateGroup.getDate_list().keySet()) {
			TreeItem<String> yearItem = new TreeItem<>(year.toString());

			for (Integer month : dateGroup.getDate_list().get(year).keySet()) {
				TreeItem<String> monthItem = new TreeItem<>(utils.Utils.getMonthName(month));
				for (Integer day : dateGroup.getDate_list().get(year).get(month).keySet()) {
					TreeItem<String> dayItem = new TreeItem<>(day.toString());
					monthItem.getChildren().add(dayItem);
				}
				yearItem.getChildren().add(monthItem);
			}
			root.getChildren().add(yearItem);
		}

		previousTrainingTree.setRoot(root);
		previousTrainingTree.setShowRoot(false);

		PreviousTrainingTreeCtrl previousTrainingTreeCtrl = new PreviousTrainingTreeCtrl(user, previousTrainingSelected,
				previousTrainingTree, dateGroup);
		dateGroup.addObserver(previousTrainingTreeCtrl);
		previousTrainingTree.getSelectionModel().selectedItemProperty().addListener(previousTrainingTreeCtrl);

	}

	/**
	 * training managing page.
	 */
	public void createTrainingList() {

		List<String> trainingListName = new ArrayList<>();
		for (Training training : user.getStructure().getTrainingsList()) {
			trainingListName.add(training.getName());
		}
		ObservableList<String> names = FXCollections.observableArrayList(trainingListName);

		trainingList.getItems().addAll(names);
		trainingList.getSelectionModel().select(0);

		// Add the controller of the training list
		TrainingListCtrl trainingListCtrl = new TrainingListCtrl(user, trainingList, selectedTraining);
		this.user.addObserver(trainingListCtrl);
		trainingList.getSelectionModel().selectedItemProperty().addListener(trainingListCtrl);
	}

	/**
	 * Creates the valid data button.
	 */
	public void createValidDataButton() {
		validExerciseData.setOnAction(e -> {
			if (utils.Utils.isNumeric(rmInput.getText()) && utils.Utils.isNumeric(markInput.getText())) {
				Double rm = Double.parseDouble(rmInput.getText());
				Double mark = Double.parseDouble(markInput.getText());
				if (rm >= 0 && rm <= 500 && mark >= 0 && mark <= 10) {
					selectedExerciseData.getUserExerciseDatas().setMark(mark);
					selectedExerciseData.getUserExerciseDatas().setWeight(rm);
					try {
						DaoFactory.getInstance().getUserExerciseDataDao()
								.updateUserExerciseData(selectedExerciseData.getUserExerciseDatas());
					} catch (EmptyResultsQueryException | InsertDataBaseException e1) {
						e1.printStackTrace();
					}
				}

			}

		});
	}



	/**
	 * Reset training.
	 */
	public void resetTraining() {

		DaoFactory.getInstance().getSerieDao().deleteAllWeekSeries(user);

		user.setStructure(null);
		structureWithoutSuperset = null;
		updateTraining();
	}

	/**
	 * Update training.
	 */
	public void updateTraining() {

		User userTemp = new User();
		userTemp.copy(user);
		userTemp.setStructure(structureWithoutSuperset);

		try {
			userTemp.createOrUpdateTraining(DaoFactory.getInstance());
			userTemp.setStructure(user.getTrainingSuperSet(
					DaoFactory.getInstance().getSerieDao().getNextTrainingsSerie(user), DaoFactory.getInstance()));
			structureWithoutSuperset = user.getTraining(
					DaoFactory.getInstance().getSerieDao().getNextTrainingsSerie(user), DaoFactory.getInstance());
			user.copy(userTemp);
		} catch (EmptyResultsQueryException | InsertDataBaseException e1) {
			trainingModificationLabel.setText("Erreur de modificatoin d'entraînement");
		}

	}



	/**
	 * Creates the exercise list.
	 */
	private void createExerciseList() {
		List<String> exerciseListName = new ArrayList<>();
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

		exerciseList.getItems().addAll(names);
		exerciseList.getSelectionModel().select(0);

		selectedExercise.copy(exercisesInTraining.get(0));

		ExerciseListCtrl exerciseListCtrl = new ExerciseListCtrl(selectedTraining, exerciseList, selectedExercise,
				exercisesInTraining);
		this.selectedTraining.addObserver(exerciseListCtrl);
		exerciseList.getSelectionModel().selectedItemProperty().addListener(exerciseListCtrl);
	}

	/**
	 * Creates the serie list.
	 */
	private void createSerieList() {
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

		serieList.getItems().addAll(names);
		SerieListCtrl serieListCtrl = new SerieListCtrl(selectedTrainingComponent, serieList);
		selectedTrainingComponent.addObserver(serieListCtrl);
		// exerciseDescriptionText.setText(this.selectedTrainingComponent.toString());

	}


	/**
	 * Creates the training component list.
	 */
	private void createTrainingComponentList() {
		List<String> trainingComponentNamesList = new ArrayList<>();
		for (TrainingComponent trainingComponent : selectedTraining.getTrainingComponentList()) {
			String exercises = "";
			for (Exercise exercise : trainingComponent.getExercisesList()) {
				exercises += exercise.getName() + " ";
			}
			trainingComponentNamesList.add(exercises);

		}
		ObservableList<String> names = FXCollections.observableArrayList(trainingComponentNamesList);

		trainingComponentList.getItems().addAll(names);
		trainingComponentList.getSelectionModel().select(0);

		TrainingComponentListCtrl exerciseListCtrl = new TrainingComponentListCtrl(this.selectedTraining,
				trainingComponentList, selectedTrainingComponent);
		this.selectedTraining.addObserver(exerciseListCtrl);
		trainingComponentList.getSelectionModel().selectedItemProperty().addListener(exerciseListCtrl);
	}

	/**
	 * Removes the exercise buttons.
	 */
	private void removeExerciseButtons() {
		replaceExerciseButton.setOnAction(e -> {
			User userTemp = user;
			for (Training training : structureWithoutSuperset.getTrainingsList()) {
				if (training.equals(selectedTraining)) {
					for (TrainingComponent tc : training.getTrainingComponentList()) {
						if (tc.getChosenExercise().equals(selectedExercise)) {
							Exercise exerciseToRemove = selectedExercise;
							userTemp.setStructure(structureWithoutSuperset);
							tc.getExercisesList().remove(exerciseToRemove);
							tc.setChosenExercise(null);

							break;
						}
					}
				}
			}
			try {
				trainingModificationLabel.setText("Programme en cours de création");
				userTemp.createOrUpdateTraining(DaoFactory.getInstance());
				userTemp.setStructure(user.getTrainingSuperSet(
						DaoFactory.getInstance().getSerieDao().getNextTrainingsSerie(user), DaoFactory.getInstance()));
				structureWithoutSuperset = user.getTraining(
						DaoFactory.getInstance().getSerieDao().getNextTrainingsSerie(user), DaoFactory.getInstance());
				trainingModificationLabel.setText("");
			} catch (EmptyResultsQueryException | InsertDataBaseException e1) {
				trainingModificationLabel.setText("Erreur de modificatoin d'entraînement");
			}

			user.copy(userTemp);
		});

		replaceInEveryTrainingExerciseButton.setOnAction(e -> {
			
			User userTemp = user;
			Exercise exerciseToRemove = null;
			for (Training training : structureWithoutSuperset.getTrainingsList()) {
				if (training.equals(selectedTraining)) {
					for (TrainingComponent tc : training.getTrainingComponentList()) {
						if (tc.getChosenExercise().equals(selectedExercise)) {
							exerciseToRemove = selectedExercise;
							userTemp.setStructure(structureWithoutSuperset);
							tc.getExercisesList().remove(exerciseToRemove);
							tc.setChosenExercise(null);

							break;
						}
					}
				}
			}
			try {
				exerciseToRemove.getUserExerciseDatas().setMark(0.25);
				try {
					DaoFactory.getInstance().getUserExerciseDataDao()
							.updateUserExerciseData(exerciseToRemove.getUserExerciseDatas());
				} catch (EmptyResultsQueryException | InsertDataBaseException e1) {
					e1.printStackTrace();
				}
				
				trainingModificationLabel.setText("Programme en cours de création");
				userTemp.createOrUpdateTraining(DaoFactory.getInstance());
				userTemp.setStructure(user.getTrainingSuperSet(
						DaoFactory.getInstance().getSerieDao().getNextTrainingsSerie(user), DaoFactory.getInstance()));
				structureWithoutSuperset = user.getTraining(
						DaoFactory.getInstance().getSerieDao().getNextTrainingsSerie(user), DaoFactory.getInstance());
				trainingModificationLabel.setText("");
			} catch (EmptyResultsQueryException | InsertDataBaseException e1) {
				trainingModificationLabel.setText("Erreur de modificatoin d'entraînement");
			}

			user.copy(userTemp);
		});

	}

}
