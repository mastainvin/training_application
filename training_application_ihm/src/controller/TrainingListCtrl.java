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
import model.objects.Structure;
import model.objects.Training;
import model.objects.User;

@SuppressWarnings("deprecation")
public class TrainingListCtrl implements Observer, ChangeListener<String>{
	private User user;
	private ListView<String> trainingList;
	private Training selectedTraining;
	
	public TrainingListCtrl(User user, ListView<String> trainingList, Training selectedTraining) {
		this.user = user;
		this.trainingList = trainingList;
		this.selectedTraining = selectedTraining;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		List<String> trainingListName = new ArrayList<>();
		for(Training training : user.getStructure().getTrainingsList()) {
			trainingListName.add(training.getName());
		}
		ObservableList<String> names = FXCollections.observableArrayList(trainingListName);
		
		trainingList.getItems().clear();
		trainingList.getItems().addAll(names);
		
		trainingList.getSelectionModel().select(0);
		selectedTraining.copy(user.getStructure().getTrainingsList().get(0));
	}

	@Override
	public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
		int index = trainingList.getSelectionModel().getSelectedIndex();
		if(index > 0) {
			selectedTraining.copy(user.getStructure().getTrainingsList().get(index));	
		} else {
			selectedTraining.copy(user.getStructure().getTrainingsList().get(0));	
		}
	}

}
