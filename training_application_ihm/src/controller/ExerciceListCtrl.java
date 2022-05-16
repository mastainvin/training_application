package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.objects.Exercice;
import model.objects.Training;
import model.objects.TrainingComponent;

public class ExerciceListCtrl implements Observer, ChangeListener<String> {
	private Training selectedTraining;
    private ListView<String> exerciceList;
    private Exercice selectedExercice;
    
    public ExerciceListCtrl(Training selectedTraining, ListView<String>exerciceList, Exercice selectedExercice) {
    	this.selectedTraining = selectedTraining;
    	this.exerciceList = exerciceList;
    	this.selectedExercice = selectedExercice;
    	
    }
	@Override
	public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		int index = exerciceList.getSelectionModel().getSelectedIndex();
		
		if(index > 0) {
			selectedExercice.copy(this.selectedTraining.getTrainingComponentList().get(index).getChosenExercice());
		} else {
			selectedExercice.copy(this.selectedTraining.getTrainingComponentList().get(0).getChosenExercice());
		}
		
	}

	@Override
	public void update(Observable o, Object arg) {
		List<String> exerciceListname = new ArrayList<>();
		for(TrainingComponent trainingComponent : selectedTraining.getTrainingComponentList()) {
				exerciceListname.add(trainingComponent.getChosenExercice().getName());
		}	
		ObservableList<String> names = FXCollections.observableArrayList(exerciceListname);
		
		exerciceList.getItems().clear();
		exerciceList.getItems().addAll(names);
		
		exerciceList.getSelectionModel().select(0);
		selectedExercice.copy(selectedTraining.getTrainingComponentList().get(0).getChosenExercice());
	}

}
