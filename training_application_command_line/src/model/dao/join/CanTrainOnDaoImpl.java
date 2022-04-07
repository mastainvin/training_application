/**
 * 
 */
package model.dao.join;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dao.DaoFactory;
import model.objects.Disponibility;
import model.objects.User;
import model.objects.exceptions.EmptyResultsQueryException;

// TODO: Auto-generated Javadoc
/**
 * The Class CanTrainOnDaoImpl.
 *
 * @author cytech
 */
public class CanTrainOnDaoImpl extends JoinDao<User, Disponibility> implements CanTrainOnDao {

	/** The singleton. */
	static private CanTrainOnDaoImpl singleton = null;
	
	/**
	 * Instance.
	 *
	 * @param daoFactory the dao factory
	 * @return the can train on dao impl
	 */
	public static CanTrainOnDaoImpl instance(DaoFactory daoFactory) {
		if(singleton == null) {
			singleton = new CanTrainOnDaoImpl(daoFactory);
		}
		return singleton;
	}
	
	/**
	 * Instantiates a new can train on dao impl.
	 *
	 * @param daoFactory the dao factory
	 */
	private CanTrainOnDaoImpl(DaoFactory daoFactory) {
		super(daoFactory);
		this.setADbName("User");
		this.setBDbName("Disponibility");
		this.setAIdLabel("id_user");
		this.setBIdLabel("id_disponibility");
		this.setDbName("CanTrainOn");
	}

	/**
	 * Gets the disponbilities.
	 *
	 * @param id_user the id user
	 * @return the disponbilities
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<Disponibility> getDisponibilities(Integer id_user) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getBList(id_user);
		List<Disponibility> disponibilities = new ArrayList<>();
		
		for(Map<String, String> value : values) {
			Disponibility d = BObjectConstructor(value);
			disponibilities.add(d);
		}
		return disponibilities;
	}

	/**
	 * Gets the users.
	 *
	 * @param id_disponibility the id disponibility
	 * @return the users
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	@Override
	public List<User> getUsers(Integer id_disponibility) throws EmptyResultsQueryException {
		List<Map<String, String>> values = this.getAList(id_disponibility);
		List<User> users = new ArrayList<>();
		
		for(Map<String, String> value : values) {
			User s = AObjectConstructor(value);
			users.add(s);
		}
		return users;
	}

	/**
	 * Adds the compatible disponibility.
	 *
	 * @param id_user the id user
	 * @param id_disponibility the id disponibility
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	@Override
	public void addCompatibleDisponibility(Integer id_user, Integer id_disponibility) throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.add(id_user, id_disponibility);
	}

	/**
	 * Delete compatible disponibility.
	 *
	 * @param id_user the id user
	 * @param id_disponibility the id disponibility
	 * @throws EmptyResultsQueryException the empty results query exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint violation exception
	 */
	@Override
	public void deleteCompatibleDisponibility(Integer id_user, Integer id_disponibility) throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		this.delete(id_user, id_disponibility);
	}

	/**
	 * A object constructor.
	 *
	 * @param valuesMap the values map
	 * @return the user
	 */
	@Override
	User AObjectConstructor(Map<String, String> valuesMap) {
		User user = new User();
		user.setPseudonym(valuesMap.get("pseudonym"));
		user.setPassword(valuesMap.get("password"));
		user.setEmail(valuesMap.get("email"));
		user.setSize(Integer.parseInt(valuesMap.get("size")));
		user.setWeight(Integer.parseInt(valuesMap.get("weight")));
		user.setGender(valuesMap.get("gender"));
		user.setBodyFat(Integer.parseInt(valuesMap.get("body_fat")));
		user.setMuscleMass(Integer.parseInt(valuesMap.get("muscle_mass")));
		user.setIdUser(Integer.parseInt(valuesMap.get("id_user")));
		
		try {
			user.setIdRole(Integer.parseInt(valuesMap.get("id_role")));
		} catch (NumberFormatException e) {
		}
		
		try {
			user.setIdMorphology(Integer.parseInt(valuesMap.get("id_morphology")));
		} catch (NumberFormatException e) {
		}

		try {
			user.setIdGoal(Integer.parseInt(valuesMap.get("id_goal")));
		} catch (NumberFormatException e) {
		}
		return user;
	}

	/**
	 * B object constructor.
	 *
	 * @param valuesMap the values map
	 * @return the disponibility
	 */
	@Override
	Disponibility BObjectConstructor(Map<String, String> valuesMap) {
		Disponibility disponibility = new Disponibility();
		disponibility.setDuration(Integer.parseInt(valuesMap.get("duration")));
		disponibility.setLayout(Integer.parseInt(valuesMap.get("layout")));
		disponibility.setIdDisponibility(Integer.parseInt(valuesMap.get("id_disponibility")));
		
		return disponibility;
	}

	/**
	 * Sets the map from result set A.
	 *
	 * @param results the results
	 * @return the map
	 * @throws SQLException the SQL exception
	 */
	@Override
	Map<String, String> setMapFromResultSetA(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("pseudonym", results.getString("pseudonym"));
		valuesMap.put("password", results.getString("password"));
		valuesMap.put("email", results.getString("email"));
		valuesMap.put("size", results.getString("size"));
		valuesMap.put("weight", results.getString("weight"));
		valuesMap.put("gender", results.getString("gender"));
		valuesMap.put("body_fat", results.getString("body_fat"));
		valuesMap.put("muscle_mass", results.getString("muscle_mass"));
		valuesMap.put("id_role", results.getString("id_role"));
		valuesMap.put("id_morphology", results.getString("id_morphology"));
		valuesMap.put("id_goal", results.getString("id_goal"));
		valuesMap.put("id_user", results.getString("id_user"));
		return valuesMap;
	}

	/**
	 * Sets the map from result set B.
	 *
	 * @param results the results
	 * @return the map
	 * @throws SQLException the SQL exception
	 */
	@Override
	Map<String, String> setMapFromResultSetB(ResultSet results) throws SQLException {
		Map<String, String> valuesMap = new HashMap<>();
		valuesMap.put("duration", results.getString("duration"));
		valuesMap.put("layout", results.getString("layout"));
		valuesMap.put("id_disponibility", results.getString("id_disponibility"));
		return valuesMap;
	}

}
