package debug;

import model.objects.Exercise;
import model.objects.Serie;
import model.objects.Structure;
import model.objects.Training;
import model.objects.TrainingComponent;


/**
 *  static methods uses to debug the application
 *  m
 */
public class Debug {

	/**
	 * Prints trainings of a structure.
	 *
	 * @param structure the structure
	 */
	public static void printTraining(Structure structure) {
		int indexExercise = 1;

		for (Training t : structure.getTrainingsList()) {
			System.out.println("Training n°" + t.getLayout() + " of the week");
			int trainingComponentNb = 1;
			for (TrainingComponent tc : t.getTrainingComponentList()) {
				System.out.println("    Exercise n°" + trainingComponentNb);
				for (Exercise e : tc.getExercisesList()) {
					System.out.println("    " + indexExercise + ". " + e.getName());
					indexExercise++;
				}
				for (Serie s : tc.getSeriesList()) {
					System.out.println(
							"        " + s.getExpectedRepetitions() + " reps " + s.getExpectedWeight() + "kg");
				}
				trainingComponentNb++;
			}
		}
	}
}
