/**
 * 
 */
package controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.objects.Disponibility;
import model.objects.Equipment;
import model.objects.Exercice;
import model.objects.Goal;
import model.objects.Morphology;
import model.objects.Serie;
import model.objects.Structure;
import model.objects.Training;
import model.objects.TrainingComponent;
import model.objects.User;
import model.objects.UserExerciceData;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;
import utils.DateGroup;
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 *
 * @author cytech
 */
public class Controller {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.getView().connectionMenu();
	}

	/** The dao factory. */
	DaoFactory daoFactory;

	/** The user. */
	User user;

	/** The view. */
	View view;

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		daoFactory = DaoFactory.getInstance();
		view = new View(this);
	}

	/**
	 * Change disponibilities event.
	 *
	 * @param disponibilities the disponibilities
	 */
	public void changeDisponibilitiesEvent(Integer[] disponibilities) {
		try {
			List<Disponibility> userDisponibilities = this.getDaoFactory().getCanTrainOnDao()
					.getDisponibilities(this.getUser().getIdUser());
			for (Disponibility d : userDisponibilities) {
				try {
					this.getDaoFactory().getCanTrainOnDao().deleteCompatibleDisponibility(user.getIdUser(),
							d.getIdDisponibility());
				} catch (SQLIntegrityConstraintViolationException e) {
				}
			}
		} catch (EmptyResultsQueryException e) {
		}

		for (int i = 1; i <= disponibilities.length; i++) {
			try {
				Integer duration = 0;
				switch (disponibilities[i - 1]) {
				case 1:
					duration = Disponibility.Duration.SHORT.getTimeInSeconds();
					break;
				case 2:
					duration = Disponibility.Duration.MEDIUM.getTimeInSeconds();
					break;
				case 3:
					duration = Disponibility.Duration.LONG.getTimeInSeconds();
					break;
				}
				Integer id_disponibility = this.getDaoFactory().getDisponibilityDao().getDisponibility(duration, i)
						.getIdDisponibility();
				this.getDaoFactory().getCanTrainOnDao().addCompatibleDisponibility(this.getUser().getIdUser(),
						id_disponibility);
			} catch (SQLIntegrityConstraintViolationException | EmptyResultsQueryException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Change equipment.
	 */
	public void changeEquipment() {
		List<Equipment> equipments;
		try {
			equipments = this.getDaoFactory().getEquipmentDao().getAllEquipment();
			String[] equipmentsNames = new String[equipments.size()];
			for (int i = 0; i < equipments.size(); i++) {
				equipmentsNames[i] = equipments.get(i).getName();
			}
			this.getView().equipmentChoice(equipmentsNames);
		} catch (EmptyResultsQueryException e) {
			this.getView().printError("Aucun équipement disponible");
		}
	}

	/**
	 * Change equipment event.
	 *
	 * @param equipmentsIndex the equipments index
	 * @param equipments      the equipments
	 */
	public void changeEquipmentEvent(List<Integer> equipmentsIndex, String[] equipments) {
		List<Equipment> userEquipments;
		try {
			userEquipments = this.getDaoFactory().getHasEquipmentDao().getEquipments(this.getUser().getIdUser());
			for (Equipment equipment : userEquipments) {
				try {
					this.getDaoFactory().getHasEquipmentDao().deleteCompatibleEquipment(this.getUser().getIdUser(),
							equipment.getIdEquipment());
				} catch (SQLIntegrityConstraintViolationException e) {
				}
			}

		} catch (EmptyResultsQueryException e) {
		}

		for (Integer equipmentIndex : equipmentsIndex) {
			Integer id_equipment;
			try {
				id_equipment = this.getDaoFactory().getEquipmentDao().getEquipmentByName(equipments[equipmentIndex])
						.getIdEquipment();
				this.getDaoFactory().getHasEquipmentDao().addCompatibleEquipment(this.getUser().getIdUser(),
						id_equipment);
			} catch (SQLIntegrityConstraintViolationException | EmptyResultsQueryException e) {
			}
		}
	}

	/**
	 * Change goal.
	 */
	public void changeGoal() {
		List<Goal> goals;
		try {
			goals = this.getDaoFactory().getGoalDao().getAllGoal();
			String[] goalsNames = new String[goals.size()];
			for (int i = 0; i < goals.size(); i++) {
				goalsNames[i] = goals.get(i).getName();
			}
			this.getView().goalChoice(goalsNames);
		} catch (EmptyResultsQueryException e) {
			this.getView().printError("Aucun objectif disponible");
		}
	}

	/**
	 * Change goal event.
	 *
	 * @param goal_index the goal index
	 * @param goals      the goals
	 */
	public void changeGoalEvent(Integer goal_index, String[] goals) {
		Goal goal;
		try {
			goal = this.getDaoFactory().getGoalDao().getGoalByName(goals[goal_index]);
			this.getUser().setIdGoal(goal.getIdGoal());
			this.getDaoFactory().getUserDao().updateUser(this.getUser());
			this.getView().printMsg("Objectif mis à jour !\n");
		} catch (EmptyResultsQueryException | ArrayIndexOutOfBoundsException | InsertDataBaseException e) {
			this.getView().printError("Erreur choix de l'objectif");
			this.getView().goalChoice(goals);
		}

	}

	/**
	 * Change morphology.
	 */
	public void changeMorphology() {
		List<Morphology> morphologies;
		try {
			morphologies = this.getDaoFactory().getMorphologyDao().getAllMorphology();
			String[] morphologiesNames = new String[morphologies.size()];
			for (int i = 0; i < morphologies.size(); i++) {
				morphologiesNames[i] = morphologies.get(i).getName();
			}
			this.getView().MorphologyChoice(morphologiesNames);
		} catch (EmptyResultsQueryException e) {
			this.getView().printError("Aucunes morphologies disponibles");
		}
	}

	/**
	 * Change morphology event.
	 *
	 * @param choice            the choice
	 * @param morphologiesNames the morphologies names
	 */
	public void changeMorphologyEvent(Integer choice, String[] morphologiesNames) {

		try {
			this.getUser().setIdMorphology(this.getDaoFactory().getMorphologyDao()
					.getMorphologyByName(morphologiesNames[choice]).getIdMorphology());
			this.getDaoFactory().getUserDao().updateUser(this.getUser());
			this.getView().printMsg("Morphologie mise à jour !\n");
		} catch (EmptyResultsQueryException | ArrayIndexOutOfBoundsException | InsertDataBaseException e) {
			this.getView().printError("Erreur choix de la morphology");
			this.getView().MorphologyChoice(morphologiesNames);
		}
	}

	/**
	 * Creates the account.
	 *
	 * @param username the username
	 * @param email    the email
	 * @param password the password
	 */
	public void createAccount(String username, String email, String password) {
		User user = new User();
		user.setPseudonym(username);
		user.setPasswordEncrypted(password);
		user.setEmail(email);
		try {
			user.setIdRole(this.getDaoFactory().getRoleDao().getRoleByName("user").getIdRole());
		} catch (EmptyResultsQueryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setUser(user);
		try {
			this.getDaoFactory().getUserDao().addUser(user);
			this.setUser(this.getDaoFactory().getUserDao().getUserByPseudonym(username));

			this.getView().printMsg("Compte créé :) \n");

			this.changeMorphology();
			this.changeGoal();
			this.changeEquipment();
			this.getView().DisponibilityChoice();

			this.getUser().createOrUpdateTraining(daoFactory);
			user.setStructure(this.getUser().getTrainingSuperSet(
					this.getDaoFactory().getSerieDao().getNextTrainingsSerie(this.getUser()), daoFactory));

			this.getView().mainMenu();
		} catch (InsertDataBaseException | EmptyResultsQueryException e) {
			e.printStackTrace();
			this.getView().printError("Email ou Pseudonyme déjà pris");
			this.getView().createAccount();
		}
	}

	/**
	 * Gets the dao factory.
	 *
	 * @return the daoFactory
	 */
	public DaoFactory getDaoFactory() {
		return daoFactory;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	public View getView() {
		return view;
	}

	/**
	 * Login.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public void login(String username, String password) {
		try {
			this.setUser(getDaoFactory().getUserDao().authentificate(username, password));

			try {
				this.getUser().setStructure(this.getUser().getTraining(
						this.getDaoFactory().getSerieDao().getNextTrainingsSerie(this.getUser()), daoFactory));
			} catch (EmptyResultsQueryException | InsertDataBaseException e1) {
				try {
					this.getUser().createOrUpdateTraining(daoFactory);
					this.getUser().setStructure(this.getUser().getTraining(
							this.getDaoFactory().getSerieDao().getNextTrainingsSerie(this.getUser()), daoFactory));
				} catch (EmptyResultsQueryException | InsertDataBaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			this.getView().mainMenu();
		} catch (EmptyResultsQueryException e2) {
			this.getView().printError("Pseudonyme ou mot de passe erroné !");
			this.getView().login();
		}

	}

	/**
	 * Make serie event.
	 *
	 * @param weight      the weight
	 * @param repetitions the repetitions
	 */
	public void makeSerieEvent(Integer weight, Integer repetitions) {

	}

	/**
	 * Prints the all current training.
	 */
	public void printAllCurrentTraining() {
		Structure structure;

		try {
			structure = this.getUser().getTrainingSuperSet(
					this.getDaoFactory().getSerieDao().getNextTrainingsSerie(this.getUser()), daoFactory);
			List<String> exerciceNames = new ArrayList<>();
			structure.getExercices().forEach((exercice) -> exerciceNames.add(exercice.getName()));
			this.printTraining(structure);
			int choiceExerciceToChange = this.getView().askExerciceToChange(exerciceNames);
			if (choiceExerciceToChange <= exerciceNames.size()) {
				int choiceExerciceChange = this.getView().askExerciceChange();
				String chosenExercice = exerciceNames.get(choiceExerciceToChange - 1);
				Exercice exerciceToRemove = null;
				if (choiceExerciceChange == 1) {
					for (Training t : this.getUser().getStructure().getTrainingsList()) {
						for (TrainingComponent tc : t.getTrainingComponentList()) {
							if (tc.getChosenExercice().getName().equals(chosenExercice)) {
								exerciceToRemove = tc.getChosenExercice();
								tc.getExercicesList().remove(exerciceToRemove);
								tc.setChosenExercice(null);
								this.getUser().createOrUpdateTraining(daoFactory);
							}
						}
					}
				} else if (choiceExerciceChange == 2) {
					for (Training t : this.getUser().getStructure().getTrainingsList()) {
						for (TrainingComponent tc : t.getTrainingComponentList()) {
							if (tc.getChosenExercice().getName().equals(chosenExercice)) {
								exerciceToRemove = tc.getChosenExercice();
								tc.getExercicesList().remove(exerciceToRemove);
								tc.setChosenExercice(null);
								this.getUser().createOrUpdateTraining(daoFactory);
							}
						}
					}

					exerciceToRemove.getUserExerciceDatas().setMark(0.0);
					this.getDaoFactory().getUserExerciceDataDao()
							.updateUserExerciceData(exerciceToRemove.getUserExerciceDatas());
				}
				this.printAllCurrentTraining();
			} else {
				return;
			}
		} catch (EmptyResultsQueryException | InsertDataBaseException e1) {
			this.getView().printError("Aucun entraînements de prévus");
		}

	}

	/**
	 * Prints training.
	 */
	public void printTraining(Structure structure) {
		int indexExercice = 1;

		for (Training t : structure.getTrainingsList()) {
			this.getView().printMsg("Entraînement n°" + t.getLayout() + " de la semaine");
			int trainingComponentNb = 1;
			for (TrainingComponent tc : t.getTrainingComponentList()) {
				this.getView().printMsg("    Mouvement n°" + trainingComponentNb);
				for (Exercice e : tc.getExercicesList()) {
					this.getView().printMsg("    " + indexExercice + ". " + e.getName());
					indexExercice++;
				}
				for (Serie s : tc.getSeriesList()) {
					this.getView().printMsg(
							"        " + s.getExpectedRepetitions() + " répétitions " + s.getExpectedWeight() + "kg");
				}
				trainingComponentNb++;
			}
		}
	}

	/**
	 * Reset training.
	 */
	public void resetTraining() {

		this.getDaoFactory().getSerieDao().deleteAllWeekSeries(this.getUser());
		try {
			this.getDaoFactory().getSerieDao().finishAllUserSeries(this.getUser());
		} catch (EmptyResultsQueryException e) {

		}
		this.getUser().setStructure(null);
	}

	/**
	 * See exercice list.
	 *
	 * @param exerciceList the exercice list
	 */
	private void seeExerciceList(List<Exercice> exerciceList) {

		this.getView().printMsg("Exercices");

		int i = 1;
		for (Exercice exercice : exerciceList) {
			this.getView().printExercice(i, exercice.getName(), exercice.getUserExerciceDatas().getMark(),
					exercice.getUserExerciceDatas().getWeight());
			i++;
		}
		Integer returnIndex = exerciceList.size() + 1;
		this.getView().printMsg(String.format("%3d. Retour", returnIndex));

		int choiceExercice = this.getView().askExercice(exerciceList.size());

		if (choiceExercice == returnIndex) {
			this.getView().mainMenu();
			return;
		}

		Exercice exercice = exerciceList.get(choiceExercice - 1);

		int choice = this.getView().exerciceMenu();
		switch (choice) {
		case 1:
			int exerciceDataChoice = this.getView().askExerciceDataChoice();
			switch (exerciceDataChoice) {
			case 1:
				exercice.getUserExerciceDatas().setMark(this.getView().askNewMarkExerciceData());
				break;
			case 2:
				exercice.getUserExerciceDatas().setWeight(this.getView().askNewWeightExerciceData());
				break;
			default:
				break;
			}
			try {
				this.getDaoFactory().getUserExerciceDataDao().updateUserExerciceData(exercice.getUserExerciceDatas());
			} catch (EmptyResultsQueryException e) {
			} catch (InsertDataBaseException e) {
			}
			break;
		case 2:
			try {

				List<Serie> previousTrainings = this.getDaoFactory().getSerieDao().getPreviousBestSeries(this.getUser(),
						exercice);
				for (Serie s : previousTrainings) {
					Double rm = this.getUser().getRm(s.getRepetitions(), s.getWeight());
					this.getView().printPreviousBestExercice(s.getDate(), s.getRepetitions(), s.getWeight(), rm);

				}
			} catch (EmptyResultsQueryException | InsertDataBaseException e) {
				this.getView().printError("Vous n'avez jamais fait cet exercice");
			}

			break;
		default:
			return;
		}
		seeExerciceList(exerciceList);
	}

	/**
	 * See exercices list event.
	 */
	public void seeExercicesListEvent() {
		List<Exercice> exerciceList;
		try {
			exerciceList = this.getDaoFactory().getExerciceDao().getAllExercice();
			for (Exercice exercice : exerciceList) {
				this.getDaoFactory().getUserExerciceDataDao().getExerciceUserExerciceData(exercice, this.getUser());
			}

			seeExerciceList(exerciceList);
		} catch (EmptyResultsQueryException e) {
			this.getView().printError("Aucunes données utilisateurs enregistrées");
		}
	}

	/**
	 * See next training.
	 */
	public void seeNextTraining() {
		try {
			this.getView().printMsg("Vos prochains entraînements");
			try {
				this.printAllCurrentTraining();
			} catch (NullPointerException e) {
				this.getUser().setStructure(this.getUser().getTraining(
						this.getDaoFactory().getSerieDao().getNextTrainingsSerie(this.getUser()), daoFactory));
				this.printAllCurrentTraining();
			}
			this.getView().mainMenu();
		} catch (EmptyResultsQueryException | InsertDataBaseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets the dao factory.
	 *
	 * @param daoFactory the daoFactory to set
	 */
	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Sets the view.
	 *
	 * @param view the view to set
	 */
	public void setView(View view) {
		this.view = view;
	}

	/**
	 * Train.
	 */
	public void train() {

		Training todayTraining;
		try {
			Structure structure = this.getUser().getTrainingSuperSet(
					this.getDaoFactory().getSerieDao().getNextTrainingsSerie(this.getUser()), daoFactory);
			todayTraining = structure.getTrainingsList().get(0);
		} catch (NullPointerException | EmptyResultsQueryException | InsertDataBaseException e) {
			try {
				this.getUser().setStructure(this.getUser().getTraining(
						this.getDaoFactory().getSerieDao().getNextTrainingsSerie(this.getUser()), daoFactory));

			} catch (EmptyResultsQueryException | InsertDataBaseException e1) {
			}
			todayTraining = this.getUser().getStructure().getTrainingsList().get(0);
		}

		this.getView().printMsg("Entraînement du jour !");
		int i = 1;
		for (TrainingComponent tc : todayTraining.getTrainingComponentList()) {
			this.getView().printMsg("Exercice n°" + i);
			int k = 0;
			int exerciceListLength = tc.getExercicesList().size();

			Double[] bestRM = new Double[exerciceListLength];
			for (int y = 0; y < exerciceListLength; y++) {
				bestRM[y] = tc.getExercicesList().get(y % exerciceListLength).getUserExerciceDatas().getWeight();
			}

			for (Serie s : tc.getSeriesList()) {
				int exerciceIndex = k % exerciceListLength;
				this.getView().printSerie(tc.getExercicesList().get(exerciceIndex).getName(), s.getExpectedWeight(),
						s.getExpectedRepetitions());
				s.setWeight(this.getView().askLiftedWeight());
				s.setRepetitions(this.getView().askRepetitionsMade());

				try {
					this.getDaoFactory().getSerieDao().updateSerie(s);
				} catch (EmptyResultsQueryException | InsertDataBaseException e) {
				}

				Double rm = this.getUser().getRm(s.getRepetitions(), s.getWeight());
				if (rm > bestRM[exerciceIndex]) {
					bestRM[exerciceIndex] = rm;
				}

				s.setDate(java.time.LocalDate.now().toString());

				try {
					this.getDaoFactory().getSerieDao().updateSerie(s);
				} catch (EmptyResultsQueryException | InsertDataBaseException e) {
					e.printStackTrace();
				}
				k++;
			}

			Integer mark = this.getView().askMark();

			for (int y = 0; y < exerciceListLength; y++) {
				try {
					UserExerciceData ued = tc.getExercicesList().get(y % exerciceListLength).getUserExerciceDatas();
					switch (mark) {
					case 1:
						ued.setMark((ued.getMark()) / 2);
						break;
					case 2:
						ued.setMark((5 + ued.getMark()) / 2);
						break;
					case 3:
						ued.setMark((10 + ued.getMark()) / 2);
						break;
					}
					ued.setWeight(bestRM[y % exerciceListLength]);
					this.getDaoFactory().getUserExerciceDataDao().updateUserExerciceData(ued);
				} catch (EmptyResultsQueryException | InsertDataBaseException e) {
					e.printStackTrace();
				}
			}

			i++;
		}
		this.getUser().getStructure().getTrainingsList().remove(0);
		if (this.getUser().getStructure().getTrainingsList().size() == 0) {
			try {
				this.getDaoFactory().getSerieDao().finishAllUserSeries(this.getUser());
				this.getUser().setStructure(null);
				this.getUser().createOrUpdateTraining(daoFactory);
				this.getUser().setStructure(this.getUser().getTraining(
						this.getDaoFactory().getSerieDao().getNextTrainingsSerie(this.getUser()), daoFactory));
			} catch (EmptyResultsQueryException | InsertDataBaseException e) {
			}
		}
		this.getView().mainMenu();
	}

	/**
	 * Training history.
	 */
	public void trainingHistory() {

		try {
			DateGroup dateGroup = new DateGroup();
			List<String> allUserDates = this.getDaoFactory().getSerieDao().getAllDateTraining(this.getUser());
			for (String date : allUserDates) {
				dateGroup.addDate(date);
			}
			Integer year = this.getView().trainingHistoryYearChoice(dateGroup.getDate_list().keySet());
			Integer month = this.getView().trainingHistoryMonthChoice(dateGroup.getDate_list().get(year).keySet());
			Integer day = this.getView()
					.traininghistoryDayChoice(dateGroup.getDate_list().get(year).get(month).keySet());
			trainingHistoryShowTraining(dateGroup.getDate_list().get(year).get(month).get(day));
			this.getView().mainMenu();
		} catch (EmptyResultsQueryException | InsertDataBaseException e) {
			this.getView().printError("Aucun entraînements fait");
			this.getView().mainMenu();
		}

	}

	/**
	 * Training history show training.
	 *
	 * @param date the date
	 */
	public void trainingHistoryShowTraining(String date) {
		List<Serie> series;
		try {
			this.getView().printMsg("Entrainement du " + date);
			series = this.getDaoFactory().getSerieDao().getWithDateSerie(this.getUser(), date);
			Structure structure = this.getUser().getTrainingSuperSet(series, daoFactory);
			this.printTraining(structure);
		} catch (EmptyResultsQueryException | InsertDataBaseException e1) {
			this.getView().printError("Aucun entraînement à la date " + date);
		}
	}

	/**
	 * Update training.
	 */
	public void updateTraining() {
		try {
			this.getUser().createOrUpdateTraining(daoFactory);
			this.getUser().setStructure(this.getUser().getTraining(
					this.getDaoFactory().getSerieDao().getNextTrainingsSerie(this.getUser()), daoFactory));
		} catch (EmptyResultsQueryException | InsertDataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
