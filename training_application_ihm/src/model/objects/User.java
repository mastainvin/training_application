package model.objects;

import static utils.Encrypt.encrypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

import model.dao.BiomecanicFunctionDao;
import model.dao.DaoFactory;
import model.dao.ExerciseDao;
import model.dao.MorphologyDao;
import model.dao.SerieDao;
import model.dao.SerieRepartitionDao;
import model.dao.TrainingComponentDao;
import model.dao.TrainingDao;
import model.dao.TrainingMethodDao;
import model.dao.UserExerciseDataDao;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

/**
 * Represents a user in the database, he can create is own training and 
 * transform a list of series into a training.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class User extends Observable {

	/** The body fat. */
	private Integer body_fat;

	/** The email. */
	private String email;

	/** The gender. */
	private String gender;

	/** The id goal. */
	private Integer id_goal;

	/** The id morphology. */
	private Integer id_morphology;

	/** The id role. */
	private Integer id_role;

	/** The id user. */
	private Integer id_user;

	/** The muscle mass. */
	private Integer muscle_mass;

	/** The password. */
	private String password;

	/** The pseudonym. */
	private String pseudonym;

	/** The size. */
	private Integer size;

	/** The structure. */
	private Structure structure;

	/** The weight. */
	private Integer weight;

	/** Define the state for the observers. */
	public static final Integer USER_CHANGED = 0;
	/**
	 * Instantiates a new user.
	 */
	public User() {
		this.size = 0;
		this.weight = 0;
		this.gender = "0";
		this.body_fat = 0;
		this.muscle_mass = 0;
	}

	/**
	 * Copy a user to this user.
	 *
	 * @param user to copy
	 */
	public void copy(User user) {
		weight = user.getWeight();
		structure = user.getStructure();
		size = user.getSize();
		pseudonym = user.getPseudonym();
		password = user.getPassword();
		muscle_mass = user.getMuscleMass();
		id_user = user.getIdUser();
		id_role = user.getIdRole();
		id_morphology = user.getIdMorphology();
		id_goal = user.getIdGoal();
		gender = user.getGender();
		email = user.getEmail();
		body_fat = user.getBodyFat();
		this.setChanged();
		this.notifyObservers();

	}

	/**
	 *
	 * Create or update the training.
	 * <ul>
	 * 	<li>1) First we fill (if it's not already the case) the structure of the training.</li>
	 * 	<li>2) Then, we remove the training that the user had already done.</li>
	 * 	<li>3) We put a mark on every exercises at every place in the structure.</li>
	 * 	<li>4) We compute the hungarian algorithm it will find the best we the attribute for every exercises a place in the structure.</li>
	 * 	<li>5) Construction of every series and saving in the database.
	 * </ul>
	 * <br>
	 * The hungarian algorithm solves an assignment problem : <a href="https://en.wikipedia.org/wiki/Hungarian_algorithm">Wikipedia</a>
	 * <br>
	 *  For the case the some exercises are in superset : for the moment we considerate that we can only put two exercises in a
	 *  super set. For that two training components with is_super_set = true will merge together.
	 *  
	 * @param daoFactory the dao factory
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	public void createOrUpdateTraining(DaoFactory daoFactory)
			throws EmptyResultsQueryException, InsertDataBaseException {

		TrainingDao tDao = daoFactory.getTrainingDao();
		TrainingComponentDao tcDao = daoFactory.getTrainingComponentDao();
		BiomecanicFunctionDao bfDao = daoFactory.getBiomecanicFunctionDao();
		ExerciseDao eDao = daoFactory.getExerciseDao();
		UserExerciseDataDao uedDao = daoFactory.getUserExerciseDataDao();
		TrainingMethodDao tmDao = daoFactory.getTrainingMethodDao();
		MorphologyDao mDao = daoFactory.getMorphologyDao();
		SerieRepartitionDao srDao = daoFactory.getSerieRepartitionDao();
		SerieDao sDao = daoFactory.getSerieDao();

		/*
		 * 1) : we construct the user structure
		 * if we can't find the data in the user we try to find it in from the database
		 */
		sDao.deleteNotDoneUserSerie(this);

		List<Exercise> eL = new ArrayList<>();

		List<UserExerciseData> userExercisesData = new ArrayList<>();

		// get user's structure if he doesn't exist
		if (this.getStructure() == null) {
			tDao.getUserStructure(this);
		}

		// get all user's trainings if they doesn't exist
		for (Training t : this.getStructure().getTrainingsList()) {

			if (utils.Utils.isEmptyOrNull(t.getTrainingComponentList())) {
				tcDao.getTrainingTrainingComponentList(t);
			}
			// get all training's components
			for (TrainingComponent tc : t.getTrainingComponentList()) {

				if (utils.Utils.isEmptyOrNull(tc.getBiomecanicFunctionList())) {
					bfDao.getTrainingComponentBiomecanicFunctionList(tc);
				}

				if (utils.Utils.isEmptyOrNull(tc.getExercisesList())) {
					eDao.getTrainingComponentExerciseList(tc, this);
				}

				for (Exercise e : tc.getExercisesList()) {
					// get exercise data and if they don't exist we create them
					boolean exerciseInList = false;
					for (Exercise eInEl : eL) {
						if (eInEl.equals(e)) {
							e.setUserExerciseDatas(eInEl.getUserExerciseDatas());
							e.setMorphologiesList(eInEl.getMorphologiesList());
							e.setBiomecanicFunctionList(eInEl.getBiomecanicFunctionList());
							exerciseInList = true;
						}
					}

					if (!exerciseInList) {
							try {
								uedDao.getExerciseUserExerciseData(e, this);
							} catch (EmptyResultsQueryException err) {
								UserExerciseData ued = new UserExerciseData();

								ued.setIdUser(this.getIdUser());
								ued.setMark(5.0);
								ued.setNbDone(0);
								ued.setWeight(0.0);
								ued.setIdExercise(e.getIdExercise());

								userExercisesData.add(ued);

								e.setUserExerciseDatas(ued);
						}
						mDao.getExerciseMorphology(e);
						bfDao.getExerciseBiomecanicFunctionList(e);
						eL.add(e);

					}

				}

				tmDao.getTrainingComponentTrainingMethod(tc);

			}
		}

		if (!utils.Utils.isEmptyOrNull(userExercisesData)) {
			uedDao.addUserExerciseData(userExercisesData);
		}

		/*
		 * 2) : Removing the trainings that the user done
		 */
		List<List<BiomecanicFunction>> bfll = null;
		try {
			// Search biomecanic function that the user did
			bfll = bfDao.getBiomecanicFunctionDone(this);

			int nbTrainingToDelete = this.getStructure().getTrainingsList().size() - bfll.size();
			// for every biomecanic function list we find the training which correspond 
			// to the list of biomecanic function that the user has done
			for (List<BiomecanicFunction> bfl : bfll) {
				if (nbTrainingToDelete > 0) {
					Double min = 9999.9;
					Training t_done = null;
					for (Training t : this.getStructure().getTrainingsList()) {
						Set<BiomecanicFunction> bf_training = new HashSet<>();
						for (TrainingComponent tc : t.getTrainingComponentList()) {
							bf_training.addAll(tc.getBiomecanicFunctionList());
						}

						Set<BiomecanicFunction> bf_training_done = new HashSet<>(bfl);
						bf_training_done.addAll(bf_training);

						// The cost is how much the list of morphology worked is far of the training that
						// the user has to do in the training tested
						double cost = bf_training_done.size() * 1.0
								/ (bf_training.size() + bfl.size() - bf_training_done.size());
						if (cost < min) {
							min = cost;
							t_done = t;
						}
					}
					this.getStructure().getTrainingsList().remove(t_done);
					nbTrainingToDelete--;
				}

			}
		} catch (EmptyResultsQueryException e) {
			// If the user didn't trained, we do nothing
		}


		// mapEl correspond to a list of exercise with the same index every time will have to use them
		Map<Exercise, Integer> mapEl = new HashMap<>();
		int elLength = eL.size();
		for (int i = 0; i < elLength; i++) {
			mapEl.put(eL.get(i), i);
		}

		/*
		 * 3) We put a mark on every exercise for every place in the sructure
		 */
		int[][] tabExerciseTrainingComponent = new int[elLength][elLength];
		int k = 0;
		Morphology m_morph_u = mDao.getMorphologyById(this.getIdMorphology());
		Integer nbDoneExerciseUser = uedDao.getNbDoneExerciseUser(this);
		for (Training t : this.getStructure().getTrainingsList()) {
			for (TrainingComponent tc : t.getTrainingComponentList()) {
				Double note = 0.0;
				int nb_done = 0;
				List<BiomecanicFunction> mf_list_e = null;
				List<BiomecanicFunction> mf_list_tc = tc.getBiomecanicFunctionList();

				if (tc.getChosenExercise() == null) {
					for (Exercise e : tc.getExercisesList()) {

						note = e.getUserExerciseDatas().getMark();
						nb_done = e.getUserExerciseDatas().getNbDone();

						mf_list_e = e.getBiomecanicFunctionList();
						Set<BiomecanicFunction> joinSet = new HashSet<>(mf_list_e);
						joinSet.addAll(mf_list_tc);

						int card_e = mf_list_e.size();
						int card_tc = mf_list_tc.size();
						int card_e_tc = joinSet.size();

						Set<Morphology> morphsSet = new HashSet<>(e.getMorphologiesList());

						int card_morph_u = 1;
						int card_morph_e = e.getMorphologiesList().size();
						int card_morph_e_u;
						if (morphsSet.contains(m_morph_u)) {
							card_morph_e_u = card_morph_e;
						}
						{
							card_morph_e_u = card_morph_e + 1;
						}

						int value = (int) Math.floor(
								100 * note * (nbDoneExerciseUser + 1) * (((card_e + card_tc) * 1.0 / card_e_tc) - 1)
										* ((card_morph_e_u + 1) / (card_morph_e + card_morph_u - card_morph_e_u + 1))
										/ (nb_done + 1));
						tabExerciseTrainingComponent[mapEl.get(e)][k] = value;

					}
				} else {
					tabExerciseTrainingComponent[mapEl.get(tc.getChosenExercise())][k] = 999999;
				}

				k++;

			}

		}

		/*
		 * 4) We use the hungarian algorithm to find the result
		 * The hungarian algorithm consist in solving an assignation problem
		 */
		
		// We fill the rest of the box with 0
		int i;
		while (k < elLength) {
			for (i = 0; i < elLength; i++) {
				tabExerciseTrainingComponent[i][k] = 0;
			}
			k++;
		}

		// We find the max of the tab
		int max = 0;
		for (i = 0; i < elLength; i++) {
			for (int j = 0; j < elLength; j++) {
				if (max < tabExerciseTrainingComponent[i][j]) {
					max = tabExerciseTrainingComponent[i][j];
				}
			}
		}
		
		// For every box we compute the max - the box value
		// Here we want to make a min problem because the hungarian algorithm work with min value
		for (i = 0; i < elLength; i++) {
			for (int j = 0; j < elLength; j++) {
				tabExerciseTrainingComponent[i][j] = max - tabExerciseTrainingComponent[i][j];

			}
		}

		// We execute the algorithm
		HungarianAlgorithm ha = new HungarianAlgorithm(tabExerciseTrainingComponent);
		int[][] assignment = ha.findOptimalAssignment();

		/*
		 * 5) We construct the series the user will have to do with the result of the algorithm.
		 */
		
		// First we chose the exercise from the result of the algorithm.
		i = 0;
		for (Training t : this.getStructure().getTrainingsList()) {
			for (TrainingComponent tc : t.getTrainingComponentList()) {
				Exercise exercise = eL.get(assignment[i][1]);
				uedDao.getExerciseUserExerciseData(exercise, this);
				tc.setChosenExercise(exercise);
				i++;
			}
		}

		// Then we build our series
		List<Serie> seriesToAdd = new ArrayList<>();
		for (Training t : this.getStructure().getTrainingsList()) {
			/*
			 * For every component we construct the series 
			 * and if it's a super set. 
			 */
			Iterator<TrainingComponent> tcIterator = t.getTrainingComponentList().iterator();

			TrainingComponent tc = null;

			int index = 0;
			
			// if the component is the second component 
			boolean is_last_super_set = false;
			
			while (tcIterator.hasNext()) {	
				
				
				if (!is_last_super_set) {
					tc = tcIterator.next();
					index++;
				}

				List<TrainingComponent> ct_super_set = new ArrayList<>();
				int previous_layout = tc.getLayout();
				do {
					ct_super_set.add(tc);
					if (tcIterator.hasNext() && tc.getIsSuperSet()) {
						TrainingComponent tc2 = t.getTrainingComponentList().get(index);
						
						// If the super set component are following there self in the training
						// So the next component is the last super set.
						if (tc2.getIsSuperSet() && Math.abs(previous_layout - tc2.getLayout()) == 1) {
							tc = tcIterator.next();
							index++;

							is_last_super_set = true;

						} else {
							is_last_super_set = false;
						}

					} else {
						is_last_super_set = false;
					}
				} while (tcIterator.hasNext() && is_last_super_set);

				TrainingMethod tm = tc.getTrainingMethod();
				srDao.getSerieReparitionFromTrainingMethod(tm);

				int it = 0;
				
				// We construct every serie from the repartition from the database.
				for (SerieRepartition sr : tm.getSerieRepartition()) {
					TrainingComponent trainingComponent = ct_super_set.get(it);
					Exercise e = trainingComponent.getChosenExercise();
					Serie serie = new Serie();
					serie.setExpectedRepetitions(sr.getNbRep());
					serie.setExpectedWeight(
							(int) Math.floor(sr.getWeight() * e.getUserExerciseDatas().getWeight() / 100));
					serie.setLayout(sr.getLayout());
					serie.setInActualWeek(true);
					serie.setRestDuration(sr.getRestDuration());

					serie.setIdComposeTrainingMethod(trainingComponent.getIdTrainingMethod());
					serie.setIdComposeTrainingTraining(trainingComponent.getIdTraining());
					serie.setIdComposeTrainingType(trainingComponent.getIdExerciseType());
					serie.setIdExercise(e.getIdExercise());
					serie.setIdUser(this.getIdUser());
					serie.setComposeTrainingLayout(trainingComponent.getLayout());

					seriesToAdd.add(serie);
					it = (it + 1) % ct_super_set.size();

				}
			}
		}
		sDao.addSerie(seriesToAdd);

	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof User) {
			User u = (User) o;
			return this.getPseudonym().equals(u.getPseudonym()) && this.getPassword().equals(u.getPassword());
		}
		return false;
	}

	/**
	 * Gets the body fat.
	 *
	 * @return the body fat
	 */
	public Integer getBodyFat() {
		return this.body_fat;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return this.gender;
	}

	/**
	 * Gets the id goal.
	 *
	 * @return the id_goal
	 */
	public Integer getIdGoal() {
		return id_goal;
	}

	/**
	 * Gets the id morphology.
	 *
	 * @return the id_morphology
	 */
	public Integer getIdMorphology() {
		return id_morphology;
	}

	/**
	 * Gets the id role.
	 *
	 * @return the id_role
	 */
	public Integer getIdRole() {
		return id_role;
	}

	/**
	 * Gets the id user.
	 *
	 * @return the id_user
	 */
	public Integer getIdUser() {
		return id_user;
	}

	/**
	 * Gets the muscle mass.
	 *
	 * @return the muscle mass
	 */
	public Integer getMuscleMass() {
		return this.muscle_mass;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Gets the pseudonym.
	 *
	 * @return the pseudonym
	 */
	public String getPseudonym() {
		return this.pseudonym;
	}

	/**
	 * Compute rm.
	 *
	 * @param repetitions the repetitions
	 * @param weight      the weight
	 * @return the double
	 */
	public Double getRm(Integer repetitions, Double weight) {
		return weight * (1 + (repetitions * 1.0 / 30));
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public Integer getSize() {
		return this.size;
	}

	/**
	 * Gets the structure.
	 *
	 * @return the structure
	 */
	public Structure getStructure() {
		return structure;
	}

	/**
	 * Get the user's training without the concept of superset. 
	 *
	 * @param series     the series
	 * @param daoFactory the dao factory
	 * @return the user training
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	public Structure getTraining(List<Serie> series, DaoFactory daoFactory)
			throws EmptyResultsQueryException, InsertDataBaseException {
		Structure structure = new Structure();
		structure.setTrainingsList(new ArrayList<>());

		for (Serie serie : series) {

			// We fill the trainingMap with every training if it's not already contained in.
			boolean inTrainingMap = false;
			Training training = null;
			for (Training t : structure.getTrainingsList()) {
				if (t.getIdTraining() == serie.getIdComposeTrainingTraining()) {
					inTrainingMap = true;
					training = t;
				}
			}
			if (!inTrainingMap) {
				training = daoFactory.getTrainingDao().getTrainingById(serie.getIdComposeTrainingTraining());
				training.setTrainingComponentList(new ArrayList<>());
				structure.getTrainingsList().add(training);
			}

			// Same for the component
			boolean inTrainingComponentMap = false;
			TrainingComponent trainingComponent = null;

			for (TrainingComponent tc : training.getTrainingComponentList()) {
				if (tc.getLayout() == serie.getComposeTrainingLayout()) {
					inTrainingComponentMap = true;
					trainingComponent = tc;
					trainingComponent.getSeriesList().add(serie);
				}
			}

			
			if (!inTrainingComponentMap) {
				trainingComponent = daoFactory.getTrainingComponentDao().getTrainingComponent(training,
						serie.getComposeTrainingLayout());
				daoFactory.getBiomecanicFunctionDao().getTrainingComponentBiomecanicFunctionList(trainingComponent);
				daoFactory.getTrainingMethodDao().getTrainingComponentTrainingMethod(trainingComponent);
				trainingComponent.setSeriesList(new ArrayList<>());
				
				// We add the serie inside the component.
				trainingComponent.getSeriesList().add(serie);
				if(utils.Utils.isEmptyOrNull(trainingComponent.getExercisesList()))
					daoFactory.getExerciseDao().getTrainingComponentExerciseList(trainingComponent, this);
				training.getTrainingComponentList().add(trainingComponent);
			}

			Exercise exerciseChosen = daoFactory.getExerciseDao().getExerciseById(serie.getIdExercise());
			exerciseChosen
					.setUserExerciseDatas(daoFactory.getUserExerciseDataDao().getUserExerciseData(this, exerciseChosen));
			trainingComponent.setChosenExercise(exerciseChosen);

			boolean inExerciseList = false;
			Exercise exercise = null;

			for (Exercise e : trainingComponent.getExercisesList()) {
				if (e.getIdExercise() == serie.getIdExercise()) {
					inExerciseList = true;
					exercise = e;
				}
			}

			if (!inExerciseList) {
				exercise = daoFactory.getExerciseDao().getExerciseById(serie.getIdExercise());
				exercise.setUserExerciseDatas(daoFactory.getUserExerciseDataDao().getUserExerciseData(this, exercise));
				trainingComponent.getExercisesList().add(exercise);
			}

		}
		return structure;
	}

	/**
	 * Get the user's training with the concept of superset. 
	 * The method is the same that getTraining but we don't create another training component
	 * if the series are super set.
	 * @param series     the series
	 * @param daoFactory the dao factory
	 * @return the user training super set
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	public Structure getTrainingSuperSet(List<Serie> series, DaoFactory daoFactory)
			throws EmptyResultsQueryException, InsertDataBaseException {
		Structure structure = new Structure();
		structure.setTrainingsList(new ArrayList<>());

		for (Serie serie : series) {

			boolean inTrainingMap = false;
			Training training = null;
			for (Training t : structure.getTrainingsList()) {
				if (t.getIdTraining() == serie.getIdComposeTrainingTraining()) {
					inTrainingMap = true;
					training = t;
				}
			}
			if (!inTrainingMap) {
				training = daoFactory.getTrainingDao().getTrainingById(serie.getIdComposeTrainingTraining());
				training.setTrainingComponentList(new ArrayList<>());
				structure.getTrainingsList().add(training);
			}

			boolean inTrainingComponentMap = false;
			TrainingComponent trainingComponent = null;

			for (TrainingComponent tc : training.getTrainingComponentList()) {
				if (tc.getLayout() == serie.getComposeTrainingLayout()) {
					inTrainingComponentMap = true;
					trainingComponent = tc;
					trainingComponent.getSeriesList().add(serie);
				} else if (tc.getIsSuperSet() && Math.abs(tc.getLayout() - serie.getComposeTrainingLayout()) <= 1) {
					// If the training components are super set and following in the training. We say that the serie among to 
					// the training component of the first exercice.
					TrainingComponent tc2 = daoFactory.getTrainingComponentDao().getTrainingComponent(training,
							serie.getComposeTrainingLayout());
					if (tc2.getIsSuperSet()) {
						inTrainingComponentMap = true;
						trainingComponent = tc;
						trainingComponent.getSeriesList().add(serie);
					}
				}
			}

			if (!inTrainingComponentMap) {
				trainingComponent = daoFactory.getTrainingComponentDao().getTrainingComponent(training,
						serie.getComposeTrainingLayout());
				daoFactory.getBiomecanicFunctionDao().getTrainingComponentBiomecanicFunctionList(trainingComponent);
				daoFactory.getTrainingMethodDao().getTrainingComponentTrainingMethod(trainingComponent);
				trainingComponent.setSeriesList(new ArrayList<>());
				trainingComponent.getSeriesList().add(serie);
				trainingComponent.setExercisesList(new ArrayList<>());
				training.getTrainingComponentList().add(trainingComponent);
			}

			boolean inExerciseList = false;
			Exercise exercise = null;

			for (Exercise e : trainingComponent.getExercisesList()) {
				if (e.getIdExercise() == serie.getIdExercise()) {
					inExerciseList = true;
					exercise = e;
				}
			}

			if (!inExerciseList) {
				exercise = daoFactory.getExerciseDao().getExerciseById(serie.getIdExercise());
				exercise.setUserExerciseDatas(daoFactory.getUserExerciseDataDao().getUserExerciseData(this, exercise));
				trainingComponent.getExercisesList().add(exercise);
			}

		}
		return structure;

	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public Integer getWeight() {
		return this.weight;
	}

	/**
	 * Sets the body fat.
	 *
	 * @param body_fat the new body fat
	 */
	public void setBodyFat(Integer body_fat) {
		this.body_fat = body_fat;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Sets the id goal.
	 *
	 * @param id_goal the id_goal to set
	 */
	public void setIdGoal(Integer id_goal) {
		this.id_goal = id_goal;
	}

	/**
	 * Sets the id morphology.
	 *
	 * @param id_morphology the id_morphology to set
	 */
	public void setIdMorphology(Integer id_morphology) {
		this.id_morphology = id_morphology;
	}

	/**
	 * Sets the id role.
	 *
	 * @param id_role the id_role to set
	 */
	public void setIdRole(Integer id_role) {
		this.id_role = id_role;
	}

	/**
	 * Sets the id user.
	 *
	 * @param id_user the id_user to set
	 */
	public void setIdUser(Integer id_user) {
		this.id_user = id_user;
	}

	/**
	 * Sets the muscle mass.
	 *
	 * @param muscle_mass the new muscle mass
	 */
	public void setMuscleMass(Integer muscle_mass) {
		this.muscle_mass = muscle_mass;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Sets the password encrypted.
	 *
	 * @param password the new password encrypted
	 */
	public void setPasswordEncrypted(String password) {
		this.password = encrypt(password);
	}

	/**
	 * Sets the pseudonym.
	 *
	 * @param pseudonym the new pseudonym
	 */
	public void setPseudonym(String pseudonym) {
		this.pseudonym = pseudonym;
	}

	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * Sets the structure.
	 *
	 * @param structure the structure to set
	 */
	public void setStructure(Structure structure) {
		this.structure = structure;

	}

	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "User [pseudonym=" + pseudonym + ", email=" + email + ", size=" + size + ", weight=" + weight
				+ ", gender=" + gender + ", body_fat=" + body_fat + ", muscle_mass=" + muscle_mass + "]";
	}

}