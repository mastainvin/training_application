package model.objects;

// TODO: Auto-generated Javadoc
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
import model.dao.ExerciceDao;
import model.dao.MorphologyDao;
import model.dao.SerieDao;
import model.dao.SerieRepartitionDao;
import model.dao.TrainingComponentDao;
import model.dao.TrainingDao;
import model.dao.TrainingMethodDao;
import model.dao.UserExerciceDataDao;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;

/**
 * Represents a user.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class User extends Observable{

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
	}
	/**
	 * Creates the or update training.
	 *
	 * @param daoFactory the dao factory
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws InsertDataBaseException    the insert data base exception
	 */
	public void createOrUpdateTraining(DaoFactory daoFactory) throws EmptyResultsQueryException, InsertDataBaseException {

		TrainingDao tDao = daoFactory.getTrainingDao();
		TrainingComponentDao tcDao = daoFactory.getTrainingComponentDao();
		BiomecanicFunctionDao bfDao = daoFactory.getBiomecanicFunctionDao();
		ExerciceDao eDao = daoFactory.getExerciceDao();
		UserExerciceDataDao uedDao = daoFactory.getUserExerciceDataDao();
		TrainingMethodDao tmDao = daoFactory.getTrainingMethodDao();
		MorphologyDao mDao = daoFactory.getMorphologyDao();
		SerieRepartitionDao srDao = daoFactory.getSerieRepartitionDao();
		SerieDao sDao = daoFactory.getSerieDao();

		sDao.deleteNotDoneUserSerie(this);

		List<Exercice> eL = new ArrayList<>();

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

				bfDao.getTrainingComponentBiomecanicFunctionList(tc);
				if (utils.Utils.isEmptyOrNull(tc.getExercicesList())) {
					eDao.getTrainingComponentExerciceList(tc, this);
				}
				
				// get every exercices
				for (Exercice e : tc.getExercicesList()) {
					
					// get exercice data and if they don't exist we create them
					try {
						uedDao.getExerciceUserExerciceData(e, this);
					} catch (EmptyResultsQueryException err) {
						UserExerciceData ued = new UserExerciceData();
						ued.setIdExercice(e.getIdExercice());
						ued.setIdUser(this.getIdUser());
						ued.setMark(5.0);
						ued.setNbDone(0);
						ued.setWeight(0.0);
						uedDao.addUserExerciceData(ued);
						e.setUserExerciceDatas(ued);
					} finally {
						mDao.getExerciceMorphology(e);
						bfDao.getExerciceBiomecanicFunctionList(e);
						if (!eL.contains(e))
							eL.add(e);
					}
				}
				tmDao.getTrainingComponentTrainingMethod(tc);
			}
		}

		// Removing the trainings that the user done
		List<List<BiomecanicFunction>> bfll = null;
		try {
			// Search biomecanic function that the user did
			bfll = bfDao.getBiomecanicFunctionDone(this);
			
			int nbTrainingToDelete = this.getStructure().getTrainingsList().size() - bfll.size();
			
			// for every biomecanic function list we find the 
			for (List<BiomecanicFunction> bfl : bfll) {
				if(nbTrainingToDelete > 0) {
					Double min = 9999.9;
					Training t_done = null;
					for (Training t : this.getStructure().getTrainingsList()) {
						Set<BiomecanicFunction> bf_training = new HashSet<>();
						for (TrainingComponent tc : t.getTrainingComponentList()) {
							bf_training.addAll(tc.getBiomecanicFunctionList());
						}

						Set<BiomecanicFunction> bf_training_done = new HashSet<>(bfl);
						bf_training_done.addAll(bf_training);

						Double cost = bf_training_done.size() * 1.0
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
			// If the user didn't trainings, we do nothing
		}

		Map<Exercice, Integer> mapEl = new HashMap<>();
		int elLength = eL.size();
		for (int i = 0; i < elLength; i++) {
			mapEl.put(eL.get(i), i);
		}

		int[][] tabExerciceTrainingComponent = new int[elLength][elLength];

		int k = 0;
		Morphology m_morph_u = mDao.getMorphologyById(this.getIdMorphology());
		Integer nbDoneExerciceUser = uedDao.getNbDoneExerciceUser(this);
		for (Training t : this.getStructure().getTrainingsList()) {
			for (TrainingComponent tc : t.getTrainingComponentList()) {
				Double note = 0.0;
				int nb_done = 0;
				List<BiomecanicFunction> mf_list_e = null;
				List<BiomecanicFunction> mf_list_tc = tc.getBiomecanicFunctionList();

				if (tc.getChosenExercice() == null) {
					for (Exercice e : tc.getExercicesList()) {

						note = e.getUserExerciceDatas().getMark();
						nb_done = e.getUserExerciceDatas().getNbDone();

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
								100 * note * (nbDoneExerciceUser + 1) * (((card_e + card_tc) * 1.0 / card_e_tc) - 1)
										* ((card_morph_e_u + 1) / (card_morph_e + card_morph_u - card_morph_e_u + 1))
										/ (nb_done + 1));
						tabExerciceTrainingComponent[mapEl.get(e)][k] = value;

					}
				} else {
					tabExerciceTrainingComponent[mapEl.get(tc.getChosenExercice())][k] = 999999;
				}

				k++;

			}

		}
		int i;
		while (k < elLength) {
			for (i = 0; i < elLength; i++) {
				tabExerciceTrainingComponent[i][k] = 0;
			}
			k++;
		}

		int max = 0;
		for (i = 0; i < elLength; i++) {
			for (int j = 0; j < elLength; j++) {
				if (max < tabExerciceTrainingComponent[i][j]) {
					max = tabExerciceTrainingComponent[i][j];
				}
			}
		}
		for (i = 0; i < elLength; i++) {
			for (int j = 0; j < elLength; j++) {
				tabExerciceTrainingComponent[i][j] = max - tabExerciceTrainingComponent[i][j];

			}
		}

		HungarianAlgorithm ha = new HungarianAlgorithm(tabExerciceTrainingComponent);

		int[][] assignment = ha.findOptimalAssignment();

		i = 0;
		for (Training t : this.getStructure().getTrainingsList()) {
			for (TrainingComponent tc : t.getTrainingComponentList()) {
				Exercice exercice = eL.get(assignment[i][1]);
				uedDao.getExerciceUserExerciceData(exercice, this);
				tc.setChosenExercice(exercice);
				i++;
			}
		}

		for (Training t : this.getStructure().getTrainingsList()) {
			Iterator<TrainingComponent> tcIterator = t.getTrainingComponentList().iterator();

			TrainingComponent tc = null;

			int index = 0;
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
				for (SerieRepartition sr : tm.getSerieRepartition()) {
					TrainingComponent trainingComponent = ct_super_set.get(it);
					Exercice e = trainingComponent.getChosenExercice();
					Serie serie = new Serie();
					serie.setExpectedRepetitions(sr.getNbRep());
					serie.setExpectedWeight(
							(int) Math.floor(sr.getWeight() * e.getUserExerciceDatas().getWeight() / 100));
					serie.setLayout(sr.getLayout());
					serie.setInActualWeek(true);
					serie.setRestDuration(sr.getRestDuration());

					serie.setIdComposeTrainingMethod(trainingComponent.getIdTrainingMethod());
					serie.setIdComposeTrainingTraining(trainingComponent.getIdTraining());
					serie.setIdComposeTrainingType(trainingComponent.getIdExerciceType());
					serie.setIdExercice(e.getIdExercice());
					serie.setIdUser(this.getIdUser());
					serie.setComposeTrainingLayout(trainingComponent.getLayout());

					sDao.addSerie(serie);

					it = (it + 1) % ct_super_set.size();

				}
			}
		}
		setChanged();
		notifyObservers();
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
	 * Gets the user training.
	 *
	 * @param series     the series
	 * @param user       the user
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
				}
			}

			if (!inTrainingComponentMap) {
				trainingComponent = daoFactory.getTrainingComponentDao().getTrainingComponent(training,
						serie.getComposeTrainingLayout());
				daoFactory.getBiomecanicFunctionDao().getTrainingComponentBiomecanicFunctionList(trainingComponent);
				daoFactory.getTrainingMethodDao().getTrainingComponentTrainingMethod(trainingComponent);
				trainingComponent.setSeriesList(new ArrayList<>());
				trainingComponent.getSeriesList().add(serie);
				daoFactory.getExerciceDao().getTrainingComponentExerciceList(trainingComponent, this);
				training.getTrainingComponentList().add(trainingComponent);
			}

			Exercice exerciceChose = daoFactory.getExerciceDao().getExerciceById(serie.getIdExercice());
			exerciceChose
					.setUserExerciceDatas(daoFactory.getUserExerciceDataDao().getUserExerciceData(this, exerciceChose));
			trainingComponent.setChosenExercice(exerciceChose);

			boolean inExerciceList = false;
			Exercice exercice = null;

			for (Exercice e : trainingComponent.getExercicesList()) {
				if (e.getIdExercice() == serie.getIdExercice()) {
					inExerciceList = true;
					exercice = e;
				}
			}

			if (!inExerciceList) {
				exercice = daoFactory.getExerciceDao().getExerciceById(serie.getIdExercice());
				exercice.setUserExerciceDatas(daoFactory.getUserExerciceDataDao().getUserExerciceData(this, exercice));
				trainingComponent.getExercicesList().add(exercice);
			}

		}
		return structure;
	}

	/**
	 * Gets the user training super set.
	 *
	 * @param series     the series
	 * @param user       the user
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
				trainingComponent.setExercicesList(new ArrayList<>());
				training.getTrainingComponentList().add(trainingComponent);
			}

			boolean inExerciceList = false;
			Exercice exercice = null;

			for (Exercice e : trainingComponent.getExercicesList()) {
				if (e.getIdExercice() == serie.getIdExercice()) {
					inExerciceList = true;
					exercice = e;
				}
			}

			if (!inExerciceList) {
				exercice = daoFactory.getExerciceDao().getExerciceById(serie.getIdExercice());
				exercice.setUserExerciceDatas(daoFactory.getUserExerciceDataDao().getUserExerciceData(this, exercice));
				trainingComponent.getExercicesList().add(exercice);
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