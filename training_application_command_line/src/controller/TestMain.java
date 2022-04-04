/**
 * 
 */
package controller;



import java.util.List;

import model.dao.BodyLimbDao;
import model.dao.DaoFactory;
import model.dao.DisponibilityDao;
import model.dao.GoalDao;
import model.dao.GoalNbRepDao;
import model.dao.GoalNbSerieDao;
import model.dao.GoalWeightDao;
import model.dao.MorphologyDao;
import model.dao.RoleDao;
import model.dao.StructureDao;
import model.dao.TrainingDao;
import model.dao.TrainingMethodDao;
import model.dao.TrainingTypeDao;
import model.dao.UserDao;
import model.objects.BodyLimb;
import model.objects.Disponibility;
import model.objects.Goal;
import model.objects.GoalNbRep;
import model.objects.GoalNbSerie;
import model.objects.GoalWeight;
import model.objects.Morphology;
import model.objects.Role;
import model.objects.Structure;
import model.objects.Training;
import model.objects.TrainingMethod;
import model.objects.TrainingType;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.UserEmailTakenException;
import model.objects.exceptions.UserInsertException;
import model.objects.exceptions.UserPseudonymTakenException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public class TestMain {

	public static void main(String[] args) throws EmptyResultsQueryException, UserInsertException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		TrainingMethodDao trainingMethodDao = daoFactory.getTrainingMethodDao();
		
		TrainingMethod tm = new TrainingMethod();
		tm.setName("test");
		trainingMethodDao.deleteTrainingMethod(tm);
	
	}
}
