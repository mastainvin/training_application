package controller;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.text.Text;
import model.objects.Exercice;

@SuppressWarnings("deprecation")
public class ExerciceDetailsCtrl implements Observer {
	private Exercice selectedExercice;
	private Text exerciceDescriptionText;
	
	public ExerciceDetailsCtrl(Exercice selectedExercice, Text exerciceDescriptionText) {
		this.selectedExercice = selectedExercice;
		this.exerciceDescriptionText = exerciceDescriptionText;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		exerciceDescriptionText.setText(selectedExercice.getDescription());
	}

}
