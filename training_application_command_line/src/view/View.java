/**
 * 
 */
package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class View.
 *
 * @author cytech
 */
public class View {

	/** The controller. */
	Controller controller;

	/** The input. */
	Scanner input;

	/**
	 * Instantiates a new view.
	 *
	 * @param controller the controller
	 */
	public View(Controller controller) {
		this.controller = controller;
		this.input = new Scanner(System.in);
	}

	/**
	 * Ask exercise.
	 *
	 * @param nbExercise the nb exercise
	 * @return the int
	 */
	public int askExercise(int nbExercise) {
		Integer choice = -1;
		while (choice < 1 || choice > nbExercise + 1) {
			System.out.print("Votre choix : ");
			choice = this.inputInteger();
		}

		return choice;
	}

	/**
	 * Ask exercise change.
	 *
	 * @return the int
	 */
	public int askExerciseChange() {
		System.out.println("1. Enlever l'exercise de cet entraînement");
		System.out.println("2. Enlever l'exercise de tous les entraînements");
		System.out.println("3. Retour");

		Integer choice = 0;

		while (choice < 1 || choice > 3) {
			System.out.print("Votre choix : ");
			choice = this.inputInteger();
		}

		return choice;
	}

	/**
	 * Ask exercise data choice.
	 *
	 * @return the int
	 */
	public int askExerciseDataChoice() {
		System.out.println("1. Changer la note");
		System.out.println("2. Changer le RM");
		System.out.println("3. Retour");

		Integer choice = 0;

		while (choice < 1 || choice > 3) {
			System.out.print("Votre choix : ");
			choice = this.inputInteger();
		}

		return choice;
	}

	/**
	 * Ask exercise to change.
	 *
	 * @param exerciseNames the exercise names
	 * @return the int
	 */
	public int askExerciseToChange(List<String> exerciseNames) {
		for (int i = 1; i <= exerciseNames.size(); i++) {
			System.out.println(i + ". " + exerciseNames.get(i - 1));
		}
		int returnChoice = (exerciseNames.size() + 1);
		System.out.println(returnChoice + ". Retour (Validation des changements)");
		Integer choice = 0;

		while (choice < 1 || choice > returnChoice) {
			System.out.print("Votre choix : ");
			choice = this.inputInteger();
		}

		return choice;
	}

	/**
	 * Ask lifted weight.
	 *
	 * @return the double
	 */
	public Double askLiftedWeight() {
		System.out.print("Charge réussie : ");
		return this.inputDouble();
	}

	/**
	 * Ask mark.
	 *
	 * @return the integer
	 */
	public Integer askMark() {
		System.out.println("Comment ça s'est passer ?");
		System.out.println("1. Pas bien");
		System.out.println("2. Bien");
		System.out.println("3. Très bien");

		Integer choice = 0;
		while (choice < 1 || choice > 3) {
			System.out.print("Votre choix : ");
			choice = this.inputInteger();
		}
		return choice;
	}

	/**
	 * Ask new mark exercise data.
	 *
	 * @return the double
	 */
	public Double askNewMarkExerciseData() {
		System.out.println("Note entre 0 et 10");

		Double choice = -1.0;

		while (choice < 0 || choice > 10) {
			System.out.print("Votre choix : ");
			choice = this.inputDouble();
		}

		return choice;
	}

	/**
	 * Ask new weight exercise data.
	 *
	 * @return the double
	 */
	public Double askNewWeightExerciseData() {
		System.out.println("Pods supérieur à 0");

		Double choice = -1.0;

		while (choice < 0) {
			System.out.print("Votre choix : ");
			choice = this.inputDouble();
		}

		return choice;
	}

	/**
	 * Ask repetitions made.
	 *
	 * @return the integer
	 */
	public Integer askRepetitionsMade() {
		System.out.print("Répétitions réussies : ");
		return this.inputInteger();
	}

	/**
	 * Change training menu.
	 */
	private void changeTrainingMenu() {
		System.out.println("1. Changer mon objectif");
		System.out.println("2. Changer ma morphologie");
		System.out.println("3. Changer mes équipements disponibles");
		System.out.println("4. Changer mes disponibilités");
		System.out.println("5. Reset le training");
		System.out.println("6. Retour");

		Integer choice = 0;

		while (choice < 1 || choice > 6) {
			System.out.print("Votre choix : ");
			choice = this.inputInteger();
		}
		switch (choice) {
		case 1:
			this.getController().changeGoal();
			this.changeTrainingMenu();
			break;
		case 2:
			this.getController().changeMorphology();
			this.changeTrainingMenu();
			break;
		case 3:
			this.getController().changeEquipment();
			this.changeTrainingMenu();
			break;
		case 4:
			this.DisponibilityChoice();
			this.changeTrainingMenu();
			break;
		case 5:
			this.getController().resetTraining();
			this.changeTrainingMenu();
			break;
		default:
			this.getController().updateTraining();
			this.mainMenu();
		}

	}

	/**
	 * Connection menu.
	 */
	public void connectionMenu() {
		System.out.println("1. Créer un compte");
		System.out.println("2. Se connecter");

		Integer choice = 0;

		while (choice < 1 || choice > 2) {
			System.out.print("Votre choix : ");
			choice = this.inputInteger();
		}

		switch (choice) {
		case 1:
			this.createAccount();
			break;
		case 2:
			this.login();
			break;
		default:
			System.out.println("Erreur");
			this.connectionMenu();
		}
	}

	/**
	 * Creates the account.
	 */
	public void createAccount() {
		String username;
		String email;
		String password;
		String repeatPassword;
		System.out.println("Création de votre compte");
		System.out.print("Pseudonyme : ");
		username = this.getInput().next();
		System.out.print("Email : ");
		email = this.getInput().next();
		System.out.print("Mot de passe : ");
		password = this.getInput().next();
		System.out.print("Répétez le mot de passe : ");
		repeatPassword = this.getInput().next();

		while (!password.equals(repeatPassword)) {
			System.out.println("Mots de passe différents");
			System.out.print("Mot de passe : ");
			password = this.getInput().next();
			System.out.print("Répétez le mot de passe : ");
			repeatPassword = this.getInput().next();
		}
		this.getController().createAccount(username, email, password);
	}

	/**
	 * Disponibility choice.
	 */
	public void DisponibilityChoice() {
		System.out.println("Choix de vos disponibilités");
		System.out.println("Nombre de journées disponibles (entre 2 et 6) : ");
		Integer nbDay = -1;
		while (nbDay < 2 || nbDay > 6) {
			System.out.print("Votre choix : ");
			nbDay = this.inputInteger();
		}

		Integer[] disponibilities = new Integer[nbDay];
		for (int i = 1; i <= nbDay; i++) {
			System.out.println("Temps disponible pour la " + i + "eme journée");
			System.out.println("1. 1h");
			System.out.println("2. 1h30");
			System.out.println("3. 2h");
			Integer choice = -1;

			while (choice < 1 || choice > 3) {
				System.out.print("Votre choix : ");
				choice = this.inputInteger();
			}
			disponibilities[i - 1] = choice;
		}

		this.getController().changeDisponibilitiesEvent(disponibilities);
	}

	/**
	 * Equipment choice.
	 *
	 * @param equipmentsNames the equipments names
	 */
	public void equipmentChoice(String[] equipmentsNames) {
		Map<String, Boolean> choices = new HashMap<>();

		for (String eName : equipmentsNames) {
			choices.put(eName, false);
		}
		Boolean finish = false;
		List<Integer> equipmentsIndex = new ArrayList<>();
		while (!finish) {
			System.out.println("Choix de vos équipements");
			int i = 1;
			System.out.println("0. Fin des choix");
			for (String choice_name : equipmentsNames) {
				System.out.println(i + ". " + (choices.get(choice_name) ? "✓" : "x") + " " + choice_name);
				i++;
			}
			Integer choice = -1;
			while (choice < 0 || choice > i) {
				System.out.print("Votre choix : ");
				choice = this.inputInteger();
			}

			if (choice == 0) {
				finish = true;
			} else {
				try {
					choices.put(equipmentsNames[choice - 1], !choices.get(equipmentsNames[choice - 1]));
					if (choices.get(equipmentsNames[choice - 1])) {
						equipmentsIndex.add(choice - 1);
					} else {
						equipmentsIndex.remove(choice - 1);
					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}

			}
		}
		this.getController().changeEquipmentEvent(equipmentsIndex, equipmentsNames);

	}

	/**
	 * Exercise menu.
	 *
	 * @return the int
	 */
	public int exerciseMenu() {
		System.out.println("1. Changer les informations");
		System.out.println("2. Voir votre évolution");
		System.out.println("3. Retour");
		Integer choice = 0;

		while (choice < 1 || choice > 3) {
			System.out.print("Votre choix : ");
			choice = this.inputInteger();
		}

		return choice;
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	public Controller getController() {
		return controller;
	}

	/**
	 * Gets the input.
	 *
	 * @return the input
	 */
	public Scanner getInput() {
		return input;
	}

	/**
	 * Goal choice.
	 *
	 * @param goals the goals
	 */
	public void goalChoice(String[] goals) {
		System.out.println("Choix de votre objectif");
		Integer goal = 0;
		for (int i = 1; i <= goals.length; i++) {
			System.out.println(i + ". " + goals[i - 1]);
		}
		while (goal < 1 || goal > goals.length) {
			System.out.print("Votre choix : ");
			goal = this.inputInteger();
		}

		this.getController().changeGoalEvent(goal - 1, goals);
	}

	/**
	 * Input double.
	 *
	 * @return the double
	 */
	public Double inputDouble() {
		try {
			return Double.parseDouble(this.getInput().next());
		} catch (NumberFormatException e) {
			this.printError("Valeur incorrecte");
			System.out.print("Nouvelle valeur : ");
			return this.inputDouble();
		}
	}

	/**
	 * Input integer.
	 *
	 * @return the integer
	 */
	public Integer inputInteger() {
		try {
			return Integer.parseInt(this.getInput().next());
		} catch (NumberFormatException e) {
			this.printError("Valeur incorrecte");
			System.out.print("Nouvelle valeur : ");
			return this.inputInteger();
		}

	}

	/**
	 * Login.
	 */
	public void login() {
		String username;
		String password;
		System.out.println("Authentification");
		System.out.print("Pseudonyme : ");
		username = this.getInput().next();
		System.out.print("Mot de passe : ");
		password = this.getInput().next();

		this.getController().login(username, password);
	}

	/**
	 * Main menu.
	 */
	public void mainMenu() {
		System.out.println("Bienvenue !");
		System.out.println("Que voulez-vous faire ?");
		System.out.println("1. M'entrainer");
		System.out.println("2. Voir mes prochains entraînements");
		System.out.println("3. Modifier mon entraînement");
		System.out.println("4. Historique des entraînements");
		System.out.println("5. Liste des exercises");
		System.out.println("6. Quitter");
		Integer choice = 0;
		while (choice < 1 || choice > 6) {
			System.out.print("Votre choix : ");
			choice = this.inputInteger();
		}
		switch (choice) {
		case 1:
			this.getController().train();
			break;
		case 2:
			this.getController().seeNextTraining();
			break;
		case 3:
			this.changeTrainingMenu();
			break;
		case 4:
			this.getController().trainingHistory();
			break;
		case 5:
			this.getController().seeExercisesListEvent();
			break;
		default:
			System.out.println("a+ :)");
			return;
		}
	}

	/**
	 * Morphology choice.
	 *
	 * @param morphologiesNames the morphologies names
	 */
	public void MorphologyChoice(String[] morphologiesNames) {
		System.out.println("Choix de votre morphologie");
		Integer morphologie = 0;
		for (int i = 1; i <= morphologiesNames.length; i++) {
			System.out.println(i + ". " + morphologiesNames[i - 1]);
		}

		while (morphologie < 1 || morphologie > morphologiesNames.length) {
			System.out.print("Votre choix : ");
			morphologie = this.inputInteger();
		}

		this.getController().changeMorphologyEvent(morphologie - 1, morphologiesNames);

	}

	/**
	 * Prints the error.
	 *
	 * @param msg the msg
	 */
	public void printError(String msg) {
		System.out.println("ERREUR " + msg);
	}

	/**
	 * Prints the exercise.
	 *
	 * @param i      the i
	 * @param name   the name
	 * @param mark   the mark
	 * @param weight the weight
	 */
	public void printExercise(int i, String name, Double mark, Double weight) {
		System.out.printf("%3d. %30s    note : %2f    weight : %5f \n", i, name, mark, weight);
	}

	/**
	 * Prints the msg.
	 *
	 * @param msg the msg
	 */
	public void printMsg(String msg) {
		System.out.println(msg);
	}

	/**
	 * Prints the previous best exercise.
	 *
	 * @param date        the date
	 * @param repetitions the repetitions
	 * @param weight      the weight
	 * @param rm          the rm
	 */
	public void printPreviousBestExercise(String date, Integer repetitions, Double weight, Double rm) {
		System.out.println(date + " - " + repetitions + " répétitions " + weight + " kg, rm => " + rm);
	}

	/**
	 * Prints the serie.
	 *
	 * @param exerciseName the exercise name
	 * @param weight       the weight
	 * @param repetitions  the repetitions
	 */
	public void printSerie(String exerciseName, Integer weight, Integer repetitions) {
		System.out.println("Vous devez faire : " + exerciseName);
		System.out.println(repetitions + " répétitions");
		if (weight == 0) {
			System.out.println("Pas de poids enregistrés");
		} else {
			System.out.println(weight + " kg");
		}
	}

	/**
	 * Prompt data.
	 *
	 * @param data the data
	 */
	public void promptData(Map<String, String> data) {

		for (Entry<String, String> entry : data.entrySet()) {
			System.out.println(entry.getKey() + " : ");
			entry.setValue(System.console().readLine());
		}
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller the controller to set
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * Sets the input.
	 *
	 * @param input the input to set
	 */
	public void setInput(Scanner input) {
		this.input = input;
	}

	/**
	 * Traininghistory day choice.
	 *
	 * @param days the days
	 * @return the integer
	 */
	public Integer traininghistoryDayChoice(Set<Integer> days) {
		for (Integer day : days) {
			System.out.println(day);
		}

		Integer choice = -1;
		while (!days.contains(choice)) {
			System.out.print("jour : ");
			choice = this.inputInteger();
		}

		return choice;
	}

	/**
	 * Training history month choice.
	 *
	 * @param months the months
	 * @return the integer
	 */
	public Integer trainingHistoryMonthChoice(Set<Integer> months) {
		for (Integer month : months) {
			System.out.println(month);
		}

		Integer choice = -1;
		while (!months.contains(choice)) {
			System.out.print("mois : ");
			choice = this.inputInteger();
		}

		return choice;
	}

	/**
	 * Training history year choice.
	 *
	 * @param years the years
	 * @return the integer
	 */
	public Integer trainingHistoryYearChoice(Set<Integer> years) {
		for (Integer year : years) {
			System.out.println(year);
		}

		Integer choice = -1;
		while (!years.contains(choice)) {
			System.out.print("année : ");
			choice = this.inputInteger();
		}

		return choice;
	}
}
