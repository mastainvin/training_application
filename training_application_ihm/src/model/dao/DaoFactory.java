/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.dao.join.BiomecanicFunctionUseLimbDao;
import model.dao.join.BiomecanicFunctionUseLimbDaoImpl;
import model.dao.join.CanTrainOnDao;
import model.dao.join.CanTrainOnDaoImpl;
import model.dao.join.CompatibleBiomecanicFunctionDao;
import model.dao.join.CompatibleBiomecanicFunctionDaoImpl;
import model.dao.join.CompatibleDisponibilityDao;
import model.dao.join.CompatibleDisponibilityDaoImpl;
import model.dao.join.CompatibleEquipmentDao;
import model.dao.join.CompatibleEquipmentDaoImpl;
import model.dao.join.CompatibleMorphDao;
import model.dao.join.CompatibleMorphDaoImpl;
import model.dao.join.ExerciceTypingDao;
import model.dao.join.ExerciceTypingDaoImpl;
import model.dao.join.HasEquipmentDao;
import model.dao.join.HasEquipmentDaoImpl;
import model.dao.join.UseBiomecanicFunctionDao;
import model.dao.join.UseBiomecanicFunctionDaoImpl;
import model.dao.join.UseLimbDao;
import model.dao.join.UseLimbDaoImpl;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Dao objects.
 *
 * @author Vincent Mastain
 */
public class DaoFactory {

	/**
	 * Gets the single instance of DaoFactory.
	 *
	 * @return single instance of DaoFactory
	 */
	public static DaoFactory singleton;
	public static DaoFactory getInstance() {
		if(singleton == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {

			}

			DaoFactory instance = new DaoFactory("jdbc:mysql://localhost:3306/Training_application", "java_application",
					"9n2%v2PzNpg[AMn3eH=)g,A5{76X%2");
			
			singleton = instance;
			return singleton;
		}
		return singleton;
		
	}

	/** The password. */
	private String password;

	/** The url. */
	private String url;

	/** The username. */
	private String username;

	/**
	 * Instantiates a new dao factory.
	 *
	 * @param url      the url
	 * @param username the username
	 * @param password the password
	 */
	DaoFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	/**
	 * Gets the biomecanic function dao.
	 *
	 * @return the biomecanic function dao
	 */
	public BiomecanicFunctionDao getBiomecanicFunctionDao() {
		return BiomecanicFunctionDaoImpl.instance(this);
	}

	/**
	 * Gets the biomecanic function list dao.
	 *
	 * @return the biomecanic function list dao
	 */
	public BiomecanicFunctionListDao getBiomecanicFunctionListDao() {
		return BiomecanicFunctionListDaoImpl.instance(this);
	}

	/**
	 * Gets the biomecanic function use limb dao.
	 *
	 * @return the biomecanic function use limb dao
	 */
	public BiomecanicFunctionUseLimbDao getBiomecanicFunctionUseLimbDao() {
		return BiomecanicFunctionUseLimbDaoImpl.instance(this);
	}

	/**
	 * Gets the body limb dao.
	 *
	 * @return the body limb dao
	 */
	public BodyLimbDao getBodyLimbDao() {
		return BodyLimbDaoImpl.instance(this);
	}

	/**
	 * Gets the can train on dao.
	 *
	 * @return the can train on dao
	 */
	public CanTrainOnDao getCanTrainOnDao() {
		return CanTrainOnDaoImpl.instance(this);
	}

	/**
	 * Gets the compatible biomecanic function dao.
	 *
	 * @return the compatible biomecanic function dao
	 */
	public CompatibleBiomecanicFunctionDao getCompatibleBiomecanicFunctionDao() {
		return CompatibleBiomecanicFunctionDaoImpl.instance(this);
	}

	/**
	 * Gets the compatible disponibility dao.
	 *
	 * @return the compatible disponibility dao
	 */
	public CompatibleDisponibilityDao getCompatibleDisponibilityDao() {
		return CompatibleDisponibilityDaoImpl.instance(this);
	}

	/**
	 * Gets the compatible equipment dao.
	 *
	 * @return the compatible equipment dao
	 */
	public CompatibleEquipmentDao getCompatibleEquipmentDao() {
		return CompatibleEquipmentDaoImpl.instance(this);
	}

	/**
	 * Gets the compatible morph dao.
	 *
	 * @return the compatible morph dao
	 */
	public CompatibleMorphDao getCompatibleMorphDao() {
		return CompatibleMorphDaoImpl.instance(this);
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws SQLException the SQL exception
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	/**
	 * Gets the disponibility dao.
	 *
	 * @return the disponibility dao
	 */
	public DisponibilityDao getDisponibilityDao() {
		return DisponibilityDaoImpl.instance(this);
	}

	/**
	 * Gets the equipment dao.
	 *
	 * @return the equipment dao
	 */
	public EquipmentDao getEquipmentDao() {
		return EquipmentDaoImpl.instance(this);
	}

	/**
	 * Gets the exercice dao.
	 *
	 * @return the exercice dao
	 */
	public ExerciceDao getExerciceDao() {
		return ExerciceDaoImpl.instance(this);
	}

	/**
	 * Gets the exercice type dao.
	 *
	 * @return the exercice type dao
	 */
	public ExerciceTypeDao getExerciceTypeDao() {
		return ExerciceTypeDaoImpl.instance(this);
	}

	/**
	 * Gets the exercice typing dao.
	 *
	 * @return the exercice typing dao
	 */
	public ExerciceTypingDao getExerciceTypingDao() {
		return ExerciceTypingDaoImpl.instance(this);
	}

	/**
	 * Gets the goal dao.
	 *
	 * @return the goal dao
	 */
	public GoalDao getGoalDao() {
		return GoalDaoImpl.instance(this);
	}

	/**
	 * Gets the goal nb rep dao.
	 *
	 * @return the goal nb rep dao
	 */
	public GoalNbRepDao getGoalNbRepDao() {
		return GoalNbRepDaoImpl.instance(this);
	}

	/**
	 * Gets the goal nb serie dao.
	 *
	 * @return the goal nb serie dao
	 */
	public GoalNbSerieDao getGoalNbSerieDao() {
		return GoalNbSerieDaoImpl.instance(this);
	}

	/**
	 * Gets the goal weight dao.
	 *
	 * @return the goal weight dao
	 */
	public GoalWeightDao getGoalWeightDao() {
		return GoalWeightDaoImpl.instance(this);
	}

	/**
	 * Gets the checks for equipment dao.
	 *
	 * @return the checks for equipment dao
	 */
	public HasEquipmentDao getHasEquipmentDao() {
		return HasEquipmentDaoImpl.instance(this);
	}

	/**
	 * Gets the morphology dao.
	 *
	 * @return the morphology dao
	 */
	public MorphologyDao getMorphologyDao() {
		return MorphologyDaoImpl.instance(this);
	}

	// Joins dao instance

	/**
	 * Gets the role dao.
	 *
	 * @return the role dao
	 */
	public RoleDao getRoleDao() {
		return RoleDaoImpl.instance(this);
	}

	/**
	 * Gets the serie dao. // Récupération des instances DAO
	 * 
	 * @return the serie dao
	 */
	public SerieDao getSerieDao() {
		return SerieDaoImpl.instance(this);
	}

	/**
	 * Gets the serie repartition dao.
	 *
	 * @return the serie repartition dao
	 */
	public SerieRepartitionDao getSerieRepartitionDao() {
		return SerieRepartitionDaoImpl.instance(this);
	}

	/**
	 * Gets the structure dao.
	 *
	 * @return the structure dao
	 */
	public StructureDao getStructureDao() {
		return StructureDaoImpl.instance(this);
	}

	/**
	 * Gets the training component dao.
	 *
	 * @return the training component dao
	 */
	public TrainingComponentDao getTrainingComponentDao() {
		return TrainingComponentDaoImpl.instance(this);
	}

	/**
	 * Gets the training dao.
	 *
	 * @return the training dao
	 */
	public TrainingDao getTrainingDao() {
		return TrainingDaoImpl.instance(this);
	}

	/**
	 * Gets the training method dao.
	 *
	 * @return the training method dao
	 */
	public TrainingMethodDao getTrainingMethodDao() {
		return TrainingMethodDaoImpl.instance(this);
	}

	/**
	 * Gets the training type dao.
	 *
	 * @return the training type dao
	 */
	public TrainingTypeDao getTrainingTypeDao() {
		return TrainingTypeDaoImpl.instance(this);
	}

	/**
	 * Gets the use biomecanic function dao.
	 *
	 * @return the use biomecanic function dao
	 */
	public UseBiomecanicFunctionDao getUseBiomecanicFunctionDao() {
		return UseBiomecanicFunctionDaoImpl.instance(this);
	}

	/**
	 * Gets the use limb dao.
	 *
	 * @return the use limb dao
	 */
	public UseLimbDao getUseLimbDao() {
		return UseLimbDaoImpl.instance(this);
	}

	/**
	 * Gets the user dao.
	 *
	 * @return the user dao
	 */

	public UserDao getUserDao() {
		return UserDaoImpl.instance(this);
	}

	/**
	 * Gets the user exercice data dao.
	 *
	 * @return the user exercice data dao
	 */
	public UserExerciceDataDao getUserExerciceDataDao() {
		return UserExerciceDataDaoImpl.instance(this);
	}

}