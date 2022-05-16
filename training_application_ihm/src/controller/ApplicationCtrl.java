package controller;

import java.net.URL;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.text.Text;
import model.dao.DaoFactory;
import model.objects.Disponibility;
import model.objects.Exercice;
import model.objects.Structure;
import model.objects.Training;
import model.objects.TrainingComponent;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

@SuppressWarnings("deprecation")
public class ApplicationCtrl implements Initializable{
	private User user;
	private Training selectedTraining;
	private Exercice selectedExercice;

    @FXML
    private Text exerciceDescriptionText;

    @FXML
    private Button replaceExerciceButton;

    @FXML
    private Button replaceInEveryTrainingExerciceButton;

    @FXML
    private Text exerciceDescriptionHistory;

    @FXML
    private LineChart<?, ?> exerciceEvolution;

    @FXML
    private ListView<String> exerciceList;

    @FXML
    private ListView<?> exerciceListHistory;

    @FXML
    private ListView<?> exerciceListList;

    @FXML
    private ChoiceBox<String> firstDisponibilityChoiceBox;

    @FXML
    private Button forceUpdateTrainingButton;
    
    @FXML
    private TextField markInput;

    @FXML
    private TreeView<?> previousTrainingTree;

    @FXML
    private TextField rmInput;

    @FXML
    private ChoiceBox<String> secondDisponibilityChoiceBox;

    @FXML
    private Button startTrainingButton;

    @FXML
    private Text trainingDescriptionHistoryText;

    @FXML
    private Text trainingDescriptionText;

    @FXML
    private Text trainingDurationHistoryText;

    @FXML
    private Text trainingDurationText;

    @FXML
    private ListView<String> trainingList;

    @FXML
    private Button validDisponibilities;

    @FXML
    private Button validExerciceData;
    
    @FXML
    private Label trainingModificationLabel;
    

	public ApplicationCtrl(User user) {
		super();
		this.user = user;
		this.selectedTraining = new Training();
		this.selectedTraining.copy(user.getStructure().getTrainingsList().get(0));
		
		this.selectedExercice = new Exercice();
		this.selectedExercice.copy(user.getStructure().getTrainingsList().get(0).getTrainingComponentList().get(0).getChosenExercice());
	}
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		createTrainingList();
		createExerciceList();
		createTrainingDetails();
		createExerciceDetails();
		removeExerciceButtons();
		createFirstTrainingChoiceBox();
		createSecondTrainingChoiceBox();
		changeDisponibilitiesButton();
		resetTraining();
	}

	public void createTrainingList() {
		
		List<String> trainingListName = new ArrayList<>();
		for(Training training : user.getStructure().getTrainingsList()) {
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

	private void createExerciceList() {
		List<String> exerciceListname = new ArrayList<>();
		for(TrainingComponent trainingComponent : selectedTraining.getTrainingComponentList()) {
				exerciceListname.add(trainingComponent.getChosenExercice().getName());
		}	
		ObservableList<String> names = FXCollections.observableArrayList(exerciceListname);
		
		exerciceList.getItems().addAll(names);
		exerciceList.getSelectionModel().select(0);
		
		ExerciceListCtrl exerciceListCtrl = new ExerciceListCtrl(this.selectedTraining, exerciceList, selectedExercice);
		this.selectedTraining.addObserver(exerciceListCtrl);
		exerciceList.getSelectionModel().selectedItemProperty().addListener(exerciceListCtrl);
	}
	
	private void createTrainingDetails() {
		trainingDescriptionText.setText(selectedTraining.getDescription());
		trainingDurationText.setText(selectedTraining.getDuration().toString());
		
		TrainingDetailsCtrl trainingDetailsCtrl = new TrainingDetailsCtrl(selectedTraining, trainingDescriptionText, trainingDurationText);
		this.selectedTraining.addObserver(trainingDetailsCtrl);
	}
	
	private void createExerciceDetails() {
		exerciceDescriptionText.setText(this.selectedExercice.getDescription());
		
		ExerciceDetailsCtrl exerciceDetailsCtrl = new ExerciceDetailsCtrl(selectedExercice, exerciceDescriptionText);
		this.selectedExercice.addObserver(exerciceDetailsCtrl);
	}
	
	private void removeExerciceButtons() {
		replaceExerciceButton.setOnAction(e -> {
			for (TrainingComponent tc : selectedTraining.getTrainingComponentList()) {
				if (tc.getChosenExercice().equals(selectedExercice)) {
					Exercice exerciceToRemove = tc.getChosenExercice();
					tc.getExercicesList().remove(exerciceToRemove);
					tc.setChosenExercice(null);
					try {
						trainingModificationLabel.setText("Programme en cours de création");
						user.createOrUpdateTraining(DaoFactory.getInstance());
						trainingModificationLabel.setText("");
					} catch (EmptyResultsQueryException | InsertDataBaseException e1) {
						trainingModificationLabel.setText("Erreur de modificatoin d'entraînement");
					}
				}
			}
		});
		
		replaceInEveryTrainingExerciceButton.setOnAction(e -> {
			Exercice exerciceToRemove = null;
			for (TrainingComponent tc : selectedTraining.getTrainingComponentList()) {
				if (tc.getChosenExercice().equals(selectedExercice)) {
					exerciceToRemove = tc.getChosenExercice();
					tc.getExercicesList().remove(exerciceToRemove);
					tc.setChosenExercice(null);
					try {
						trainingModificationLabel.setText("Programme en cours de création");
						user.createOrUpdateTraining(DaoFactory.getInstance());
						trainingModificationLabel.setText("");
					} catch (EmptyResultsQueryException | InsertDataBaseException e1) {
						trainingModificationLabel.setText("Erreur de modificatoin d'entraînement");
					}
				}
			}
			exerciceToRemove.getUserExerciceDatas().setMark(0.0);
			try {
				DaoFactory.getInstance().getUserExerciceDataDao().updateUserExerciceData(exerciceToRemove.getUserExerciceDatas());
			} catch (EmptyResultsQueryException | InsertDataBaseException e1) {
				e1.printStackTrace();
			}
		});
		
	}
	
	public void createFirstTrainingChoiceBox() {
		try {
			Disponibility disponibility1 = DaoFactory.getInstance().getDisponibilityDao().getDisponibility(90, 1);
			Disponibility disponibility2 = DaoFactory.getInstance().getDisponibilityDao().getDisponibility(120, 1);
			
			ObservableList<String> names = FXCollections.observableArrayList(disponibility1.toString(), disponibility2.toString());
			
			firstDisponibilityChoiceBox.getItems().addAll(names);
		} catch (EmptyResultsQueryException e) {
			e.printStackTrace();
		}	
	}
	
	public void createSecondTrainingChoiceBox() {
		try {
			Disponibility disponibility1 = DaoFactory.getInstance().getDisponibilityDao().getDisponibility(90, 2);
			Disponibility disponibility2 = DaoFactory.getInstance().getDisponibilityDao().getDisponibility(120, 2);
			
			ObservableList<String> names = FXCollections.observableArrayList(disponibility1.toString(), disponibility2.toString());
			
			secondDisponibilityChoiceBox.getItems().addAll(names);
		} catch (EmptyResultsQueryException e) {
			e.printStackTrace();
		}	
	}
	
	public void changeDisponibilitiesButton() {
		validDisponibilities.setOnAction(e -> {
			int firstChoice = firstDisponibilityChoiceBox.getSelectionModel().getSelectedIndex();
			int secondChoice = secondDisponibilityChoiceBox.getSelectionModel().getSelectedIndex();
			
			if(firstChoice >= 0 && secondChoice >= 0) {
				int firstDuration = 0;
				int secondDuration = 0;
				if(firstChoice == 0) {
					firstDuration = Disponibility.Duration.MEDIUM.getTimeInSeconds();
				} else {
					firstDuration = Disponibility.Duration.LONG.getTimeInSeconds();
				}
				
				if(secondChoice == 0) {
					secondDuration = Disponibility.Duration.MEDIUM.getTimeInSeconds();
				} else {
					secondDuration = Disponibility.Duration.LONG.getTimeInSeconds();
				}
				
				
				try {
					
					List<Integer> trainingToRemoveList = new ArrayList<>();
					
					int i = 0;
					for(Training training : user.getStructure().getTrainingsList()) {
						if(training.getLayout() == 1 && training.getDuration() != firstDuration) {
							try {
								Disponibility d = DaoFactory.getInstance().getDisponibilityDao().getDisponibility(training.getDuration(), 1);
								DaoFactory.getInstance().getCanTrainOnDao().deleteCompatibleDisponibility(user.getIdUser(), d.getIdDisponibility());
										
								trainingToRemoveList.add(i);
								
								int idFirstDisponibility = DaoFactory.getInstance().getDisponibilityDao().getDisponibility(firstDuration, 1).getIdDisponibility();
								DaoFactory.getInstance().getCanTrainOnDao().addCompatibleDisponibility(user.getIdUser(),idFirstDisponibility);
								
							} catch (SQLIntegrityConstraintViolationException e1) {
							}
						}
						
						if(training.getLayout() == 2 && training.getDuration() != secondDuration) {
							try {
								Disponibility d = DaoFactory.getInstance().getDisponibilityDao().getDisponibility(training.getDuration(), 2);
								DaoFactory.getInstance().getCanTrainOnDao().deleteCompatibleDisponibility(user.getIdUser(), d.getIdDisponibility());
								
								trainingToRemoveList.add(i);
								
								int idSecondDisponibility = DaoFactory.getInstance().getDisponibilityDao().getDisponibility(secondDuration, 2).getIdDisponibility();
								DaoFactory.getInstance().getCanTrainOnDao().addCompatibleDisponibility(user.getIdUser(),idSecondDisponibility);
								
							} catch (SQLIntegrityConstraintViolationException e1) {
							}
						}
						i++;
					}
					for(int j : trainingToRemoveList) {
						user.getStructure().getTrainingsList().remove(user.getStructure().getTrainingsList().get(j));
					}
				} catch (EmptyResultsQueryException e1) {
				}
				
				resetTraining();
				updateTraining();
			}
		});
	}
	
	public void createForceUpdateTrainingButton() {
		forceUpdateTrainingButton.setOnAction(e -> {
			resetTraining();
			updateTraining();
		});
	}
	
	
	
	
	
	
	
	
	/**
	 * All usefull method used in all the controller
	 */
	
	
	/**
	 * Update training.
	 */
	public void updateTraining() {
		try {
			user.createOrUpdateTraining(DaoFactory.getInstance());
			user.setStructure(user.getTraining(
					DaoFactory.getInstance().getSerieDao().getNextTrainingsSerie(user), DaoFactory.getInstance()));
		} catch (EmptyResultsQueryException | InsertDataBaseException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Reset training.
	 */
	public void resetTraining() {

		DaoFactory.getInstance().getSerieDao().deleteAllWeekSeries(user);
		try {
			DaoFactory.getInstance().getSerieDao().finishAllUserSeries(user);
		} catch (EmptyResultsQueryException e) {

		}
		user.setStructure(null);
	}
	
}
