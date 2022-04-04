/**
 * 
 */
package controller;



import java.util.List;

import model.dao.BodyLimbDao;
import model.dao.DaoFactory;
import model.dao.DisponibilityDao;
import model.dao.ExerciceDao;
import model.dao.GoalDao;
import model.dao.GoalNbRepDao;
import model.dao.GoalNbSerieDao;
import model.dao.GoalWeightDao;
import model.dao.MorphologyDao;
import model.dao.RoleDao;
import model.dao.SerieDao;
import model.dao.StructureDao;
import model.dao.TrainingComponentDao;
import model.dao.TrainingDao;
import model.dao.TrainingMethodDao;
import model.dao.TrainingTypeDao;
import model.dao.UserDao;
import model.objects.BodyLimb;
import model.objects.Disponibility;
import model.objects.Exercice;
import model.objects.Goal;
import model.objects.GoalNbRep;
import model.objects.GoalNbSerie;
import model.objects.GoalWeight;
import model.objects.Morphology;
import model.objects.Role;
import model.objects.Serie;
import model.objects.Structure;
import model.objects.Training;
import model.objects.TrainingComponent;
import model.objects.TrainingComponentList;
import model.objects.TrainingMethod;
import model.objects.TrainingType;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;
import model.objects.exceptions.InsertDataBaseException;
import model.objects.exceptions.NotFindInArrayException;
import model.objects.exceptions.UserEmailTakenException;
import model.objects.exceptions.UserInsertException;
import model.objects.exceptions.UserPseudonymTakenException;

/**
 * @author Vincent Mastain
 * @version 1.0
 */
public class TestMain {

	public static void main(String[] args) throws EmptyResultsQueryException, UserInsertException, NotFindInArrayException, InsertDataBaseException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		TrainingDao trainingDao = daoFactory.getTrainingDao();
		TrainingComponentDao tcDao = daoFactory.getTrainingComponentDao();
		UserDao userDao = daoFactory.getUserDao();
		ExerciceDao exerciceDao = daoFactory.getExerciceDao();
		SerieDao serieDao = daoFactory.getSerieDao();
		
		Training t = trainingDao.getFirstTraining();
		List<TrainingComponent> tcs = tcDao.getTrainingsComponentsListFromTraining(t);
		TrainingComponent tc = TrainingComponentList.getElementByLayout(tcs, 2);
		
		User user = userDao.getFirstUser();
		
		Serie serie = new Serie();
		serie.setExpectedRepetitions(13);
		serie.setExpectedWeight(15);
		serie.setInActualWeek(false);
		serie.setLayout(1);
		serie.setRepetitions(189308);
		serie.setRpe(12);	
		serie.setWeight(15);
		
		Exercice exercice = exerciceDao.getFirstExercice();
		
		tc.getExercicesList().add(exercice);
		
		serieDao.addSerie(serie, tc, user, t);
		
		
	}
}
