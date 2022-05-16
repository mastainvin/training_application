package debug;

import model.objects.Exercice;
import model.objects.Serie;
import model.objects.Structure;
import model.objects.Training;
import model.objects.TrainingComponent;

public class Debug {
	/**
	 * Prints training.
	 */
	public static void printTraining(Structure structure) {
		int indexExercice = 1;

		for (Training t : structure.getTrainingsList()) {
			System.out.println("Entraînement n°" + t.getLayout() + " de la semaine");
			int trainingComponentNb = 1;
			for (TrainingComponent tc : t.getTrainingComponentList()) {
				System.out.println("    Mouvement n°" + trainingComponentNb);
				for (Exercice e : tc.getExercicesList()) {
					System.out.println("    " + indexExercice + ". " + e.getName());
					indexExercice++;
				}
				for (Serie s : tc.getSeriesList()) {
					System.out.println(
							"        " + s.getExpectedRepetitions() + " répétitions " + s.getExpectedWeight() + "kg");
				}
				trainingComponentNb++;
			}
		}
	}
}
