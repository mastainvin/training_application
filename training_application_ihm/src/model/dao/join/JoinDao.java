/**
 *
 */
package model.dao.join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Map;

import model.dao.DaoFactory;
import model.objects.exceptions.EmptyResultsQueryException;


/**
 * The Class JoinDao.
 *
 * @author Vincent Mastain
 * @param <A> the first table in the database.
 * @param <B> the second table in the database.
 * @version 1.0
 */
public abstract class JoinDao<A, B> {

	/** The A db name. */
	private String A_db_name;

	/** The A id label. */
	private String A_id_label;

	/** The B db name. */
	private String B_db_name;

	/** The B id label. */
	private String B_id_label;

	/** The dao factory. */
	private DaoFactory daoFactory;

	/** The db name. */
	private String db_name;

	/**
	 * Instantiates a new join dao.
	 *
	 * @param daoFactory the dao factory
	 */
	public JoinDao(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	/**
	 * Adds the.
	 *
	 * @param A_id the a id
	 * @param B_id the b id
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	public void add(Integer A_id, Integer B_id)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			String sqlRequest;
			sqlRequest = "INSERT INTO " + this.getDbName() + "(" + this.getAIdLabel() + "," + this.getBIdLabel()
					+ ") VALUES ('" + A_id + "','" + B_id + "');";
			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} // SQLIntegrityConstraintViolationException
	}

	/**
	 * Delete.
	 *
	 * @param A_id the a id
	 * @param B_id the b id
	 * @throws EmptyResultsQueryException               the empty results query
	 *                                                  exception
	 * @throws SQLIntegrityConstraintViolationException the SQL integrity constraint
	 *                                                  violation exception
	 */
	public void delete(Integer A_id, Integer B_id)
			throws EmptyResultsQueryException, SQLIntegrityConstraintViolationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			String sqlRequest;
			sqlRequest = "DELETE FROM " + this.getDbName() + " WHERE " + this.getAIdLabel() + " = " + A_id + " AND "
					+ this.getBIdLabel() + " = " + B_id + ";";
			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the a db name.
	 *
	 * @return the a_db_name
	 */
	public String getADbName() {
		return A_db_name;
	}

	/**
	 * Gets the a id label.
	 *
	 * @return the a_id_label
	 */
	public String getAIdLabel() {
		return A_id_label;
	}

	/**
	 * Gets the a list.
	 *
	 * @param B_id the b id
	 * @return the a list
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public ArrayList<Map<String, String>> getAList(Integer B_id) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;
		ArrayList<Map<String, String>> resultsArray = new ArrayList<>();

		try {
			String sqlRequest;
			sqlRequest = "SELECT x.* FROM " + this.A_db_name + " x, " + this.db_name + " y WHERE " + this.B_id_label
					+ " = " + B_id + " AND x." + this.A_id_label + " = y." + this.A_id_label + ";";
			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			results = preparedStatement.executeQuery();

			boolean empty = true;

			while (results.next()) {
				resultsArray.add(this.setMapFromResultSetA(results));
				empty = false;
			}

			if (empty) {
				throw new EmptyResultsQueryException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultsArray;
	}

	/**
	 * Gets the b db name.
	 *
	 * @return the b_db_name
	 */
	public String getBDbName() {
		return B_db_name;
	}

	/**
	 * Gets the b id label.
	 *
	 * @return the b_id_label
	 */
	public String getBIdLabel() {
		return B_id_label;
	}

	/**
	 * Gets the b list.
	 *
	 * @param A_id the a id
	 * @return the b list
	 * @throws EmptyResultsQueryException the empty results query exception
	 */
	public ArrayList<Map<String, String>> getBList(Integer A_id) throws EmptyResultsQueryException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet results = null;
		ArrayList<Map<String, String>> resultsArray = new ArrayList<>();

		try {
			String sqlRequest;
			sqlRequest = "SELECT x.* FROM " + this.B_db_name + " x , " + this.db_name + " y  WHERE " + this.A_id_label
					+ " = " + A_id + " AND x." + this.B_id_label + " = y." + this.B_id_label + ";";
			connection = this.getDaoFactory().getConnection();
			preparedStatement = connection.prepareStatement(sqlRequest);
			results = preparedStatement.executeQuery();

			boolean empty = true;

			while (results.next()) {
				resultsArray.add(this.setMapFromResultSetB(results));
				empty = false;
			}

			if (empty) {
				throw new EmptyResultsQueryException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultsArray;
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
	 * Gets the db name.
	 *
	 * @return the db_name
	 */
	public String getDbName() {
		return db_name;
	}

	/**
	 * Sets the a db name.
	 *
	 * @param a_db_name the a_db_name to set
	 */
	public void setADbName(String a_db_name) {
		A_db_name = a_db_name;
	}

	/**
	 * Sets the a id label.
	 *
	 * @param a_id_label the a_id_label to set
	 */
	public void setAIdLabel(String a_id_label) {
		A_id_label = a_id_label;
	}

	/**
	 * Sets the b db name.
	 *
	 * @param b_db_name the b_db_name to set
	 */
	public void setBDbName(String b_db_name) {
		B_db_name = b_db_name;
	}

	/**
	 * Sets the b id label.
	 *
	 * @param b_id_label the b_id_label to set
	 */
	public void setBIdLabel(String b_id_label) {
		B_id_label = b_id_label;
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
	 * Sets the db name.
	 *
	 * @param db_name the db_name to set
	 */
	public void setDbName(String db_name) {
		this.db_name = db_name;
	}

	/**
	 * A object constructor.
	 *
	 * @param valuesMap the values map
	 * @return the a
	 */
	abstract A AObjectConstructor(Map<String, String> valuesMap);

	/**
	 * B object constructor.
	 *
	 * @param valuesMap the values map
	 * @return the b
	 */
	abstract B BObjectConstructor(Map<String, String> valuesMap);

	/**
	 * Sets the map from result set A.
	 *
	 * @param results the results
	 * @return the map
	 * @throws SQLException the SQL exception
	 */
	abstract Map<String, String> setMapFromResultSetA(ResultSet results) throws SQLException;

	/**
	 * Sets the map from result set B.
	 *
	 * @param results the results
	 * @return the map
	 * @throws SQLException the SQL exception
	 */
	abstract Map<String, String> setMapFromResultSetB(ResultSet results) throws SQLException;

}
