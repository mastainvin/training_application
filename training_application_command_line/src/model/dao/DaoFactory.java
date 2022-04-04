/**
 * 
 */
package model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Vincent Mastain
 *
 */
public class DaoFactory {
    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        DaoFactory instance = new DaoFactory(
                "jdbc:mysql://localhost:3306/Training_application", "java_application", "9n2%v2PzNpg[AMn3eH=)g,A5{76X%2");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Récupération des instances DAO
    public UserDao getUserDao() {
        return UserDaoImpl.instance(this);
    }
    
    public RoleDao getRoleDao() {
    	return RoleDaoImpl.instance(this);
    }
    
    public MorphologyDao getMorphologyDao() {
    	return MorphologyDaoImpl.instance(this);
    }
    
    public GoalDao getGoalDao() {
    	return GoalDaoImpl.instance(this);
    }
    
    public BodyLimbDao getBodyLimbDao() {
    	return BodyLimbDaoImpl.instance(this);
    }
    
    public GoalNbSerieDao getGoalNbSerieDao() {
    	return GoalNbSerieDaoImpl.instance(this);
    }
    
    public GoalNbRepDao getGoalNbRepDao() {
    	return GoalNbRepDaoImpl.instance(this);
    }
    
    public GoalWeightDao getGoalWeightDao() {
    	return GoalWeightDaoImpl.instance(this);
    }
    
    public DisponibilityDao getDisponibilityDao() {
    	return DisponibilityDaoImpl.instance(this);
    }
    
    public StructureDao getStructureDao() {
    	return StructureDaoImpl.instance(this);
    }
    
    public TrainingTypeDao getTrainingTypeDao() {
    	return TrainingTypeDaoImpl.instance(this);
    }
    
    public TrainingDao getTrainingDao() {
    	return TrainingDaoImpl.instance(this);
    }
    
    public TrainingMethodDao getTrainingMethodDao() {
    	return TrainingMethodDaoImpl.instance(this);
    }
    public ExerciceDao getExerciceDao() {
    	return ExerciceDaoImpl.instance(this);
    }
    
    public UserExerciceDataDao getUserExerciceDataDao() {
    	return UserExerciceDataDaoImpl.instance(this);
    }
    
    public ExerciceTypeDao getExerciceTypeDao() {
    	return ExerciceTypeDaoImpl.instance(this);
    }
    
    public TrainingComponentDao getTrainingComponentDao() {
    	return TrainingComponentDaoImpl.instance(this);
    }

}