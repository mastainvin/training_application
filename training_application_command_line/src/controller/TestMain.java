/**
 * 
 */
package controller;



import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.dao.BiomecanicFunctionDao;
import model.dao.BiomecanicFunctionListDao;
import model.dao.BodyLimbDao;
import model.dao.DaoFactory;
import model.dao.DisponibilityDao;
import model.dao.ExerciceDao;
import model.dao.ExerciceTypeDao;
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
import model.dao.UserExerciceDataDao;
import model.dao.join.CanTrainOnDao;
import model.dao.join.CompatibleDisponibilityDao;
import model.objects.BiomecanicFunction;
import model.objects.BiomecanicFunctionList;
import model.objects.BodyLimb;
import model.objects.Disponibility;
import model.objects.Exercice;
import model.objects.ExerciceType;
import model.objects.Goal;
import model.objects.GoalNbRep;
import model.objects.GoalNbSerie;
import model.objects.GoalWeight;
import model.objects.HungarianAlgorithm;
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

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws UserInsertException the user insert exception
	 * @throws NotFindInArrayException the not find in array exception
	 * @throws InsertDataBaseException the insert data base exception
	 * @throws UserPseudonymTakenException the user pseudonym taken exception
	 * @throws UserEmailTakenException the user email taken exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public static void main(String[] args) throws  UserInsertException, NotFindInArrayException, InsertDataBaseException, UserPseudonymTakenException, UserEmailTakenException, SQLIntegrityConstraintViolationException, EmptyResultsQueryException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		UserDao uDao = daoFactory.getUserDao();
		StructureDao dDao = daoFactory.getStructureDao();
		TrainingDao tDao = daoFactory.getTrainingDao();
		TrainingComponentDao tcDao = daoFactory.getTrainingComponentDao();
		BiomecanicFunctionDao bfDao = daoFactory.getBiomecanicFunctionDao();
		ExerciceDao eDao = daoFactory.getExerciceDao();
		UserExerciceDataDao uedDao = daoFactory.getUserExerciceDataDao();
		TrainingMethodDao tmDao = daoFactory.getTrainingMethodDao();
		GoalDao gDao = daoFactory.getGoalDao();
		MorphologyDao mDao = daoFactory.getMorphologyDao();
		CanTrainOnDao ctoDao = daoFactory.getCanTrainOnDao();
		
		User u = uDao.authentificate("vincent", "password");
		dDao.getUserStructure(u);
		tDao.getStructureTrainingList(u.getStructure());
		
		System.out.println(u);
		
		System.out.println(gDao.getGoalById(u.getIdGoal()));
		System.out.println(mDao.getMorphologyById(u.getIdMorphology()));
		
		for(Disponibility d : ctoDao.getDisponibilities(u.getIdUser())) {
			System.out.println(d);
		}
		
		
		System.out.println("Number of exercice done = " + uedDao.getNbDoneExerciceUser(u) + "\n");
		
		System.out.println(u.getStructure());
		
		for(Training t : u.getStructure().getTrainingsList()) {
			System.out.println("    " + t);
			tcDao.getTrainingTrainingComponentList(t);
			
			for(TrainingComponent tc : t.getTrainingComponentList()) {
				System.out.println("        " + tc);
				bfDao.getTrainingComponentBiomecanicFunctionList(tc);
				System.out.println("            BiomecanicFunctions asked");
				for(BiomecanicFunction bf : tc.getBiomecanicFunctionList()) {
					System.out.println("                " + bf);
				}
				
				eDao.getTrainingComponentExerciceList(tc, u);
				System.out.println("            Exercices potencials");
				for(Exercice e : tc.getExercicesList()) {
					try {
						System.out.println("                " + e);
						bfDao.getExerciceBiomecanicFunctionList(e);
						System.out.println("                    BiomecanicFunctions used");
						for(BiomecanicFunction bf : e.getBiomecanicFunctionList()) {
							System.out.println("                        " + bf);
						}
						uedDao.getExerciceUserExerciceData(e, u);
						System.out.println("                    User Data");
	                    System.out.println("                        " + e.getUserExerciceDatas());
					} catch(EmptyResultsQueryException err) {
						
					}
					
				}
				tmDao.getTrainingComponentTrainingMethod(tc);
				System.out.println("            Training method");
				System.out.println("                        " + tc.getTrainingMethod());
			}
		}
		
		
		List<Exercice> eL = eDao.getAllExercice();
		int elLength = eL.size();
		int[][] tab = new int[elLength][elLength];
		int i = 0;
		for(Exercice e : eL) {
			int j = 0;
			for(Training t: u.getStructure().getTrainingsList()) {
				for(TrainingComponent tc : t.getTrainingComponentList()) {
					int note = 0;
					int nb_done = 0;
					List<BiomecanicFunction> mf_list_e = null;
					List<BiomecanicFunction> mf_list_tc = tc.getBiomecanicFunctionList();
					
					for(Exercice e2 : tc.getExercicesList()) {
						if (e2.equals(e)) {
							note = e2.getUserExerciceDatas().getMark();
							nb_done = e2.getUserExerciceDatas().getNbDone();
							mf_list_e = e2.getBiomecanicFunctionList();
							List<BiomecanicFunction> joinList = new ArrayList<BiomecanicFunction>(mf_list_e);
					        joinList.addAll(mf_list_tc);
					        Set<BiomecanicFunction> joinSet = new HashSet<>(joinList);
					        
					        int card_e = mf_list_e.size();
					        int card_tc = mf_list_tc.size();
					        int card_e_tc = joinSet.size();
					        
					        int value = (int) Math.floor(100 * note * (uedDao.getNbDoneExerciceUser(u) + 1) * (((card_e + card_tc)  * 1.0 / card_e_tc )  - 1) / (nb_done + 1));
					        tab[i][j] = value;
					       
					        break;
						}
					}
					j++;
					
				}
			}
			while(j<elLength) {
				tab[i][j] = 0;

				j++;
			}

			i++;
		} 
		
		int max = 0;
		for( i = 0; i<elLength ; i++) {
			for(int j = 0; j<elLength ; j++) {
				if(max < tab[i][j]) {
					max = tab[i][j];
				}
			}
		}
		for( i = 0; i<elLength ; i++) {
			for(int j = 0; j<elLength ; j++) {
					tab[i][j] = max - tab[i][j];
				
			}
		}
		
		for( i = 0; i<elLength ; i++) {
			for(int j = 0; j<elLength ; j++) {
				System.out.print(tab[i][j] + " ");
			}
			System.out.println("");
		}
		
		HungarianAlgorithm ha = new HungarianAlgorithm(tab);
		
		int[][] assignment = ha.findOptimalAssignment();
		
		for(i = 0 ; i < elLength ; i++) {
			for(int j =0; j<2; j++) {
				System.out.print(assignment[i][j] + " ");
			}
			System.out.println("");
		}
		i = 0;
		for(Training t: u.getStructure().getTrainingsList()) {
			for(TrainingComponent tc : t.getTrainingComponentList()) {
				List<Exercice> exercice = new ArrayList<>();
				exercice.add(eL.get(assignment[i][1]));
				tc.setExercicesList(exercice);
				i++;
			}
		}
			
		System.out.println("\n\n\n\n Best structure");
		for(Training t : u.getStructure().getTrainingsList()) {
			System.out.println("    " + t);
			;
			
			for(TrainingComponent tc : t.getTrainingComponentList()) {
			
				
				for(Exercice e : tc.getExercicesList()) {
					System.out.println("            " + e + " " + uedDao.getUserExerciceData(u, e));
//						uedDao.getExerciceUserExerciceData(e, u);
//	                    System.out.println("                    " + e.getUserExerciceDatas());
					
				}
//				tmDao.getTrainingComponentTrainingMethod(tc);
//				System.out.println("                   " + tc.getTrainingMethod());
			}
		}
		
		
	}
}
