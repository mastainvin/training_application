package model.objects;

import static utils.Encrypt.*;
// TODO: Auto-generated Javadoc

/**
 *  Represents a user.
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class User {
	
	/** The pseudonym. */
	private String pseudonym;
	
	/** The password. */
	private String password;
	
	/** The email. */
	private String email;
	
	/** The size. */
	private Integer size;
	
	/** The weight. */
	private Integer weight;
	
	/** The gender. */
	private String gender;
	
	/** The body fat. */
	private Integer body_fat;
	
	/** The muscle mass. */
	private Integer muscle_mass;
	
	/** The id role. */
	private Integer id_role;
	
	/** The id morphology. */
	private Integer id_morphology;
	
	/** The id goal. */
	private Integer id_goal;
	
	/** The id user. */
	private Integer id_user;
	
	private Structure structure;
	
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
	 * Gets the pseudonym.
	 *
	 * @return the pseudonym
	 */
	public String getPseudonym() {
		return this.pseudonym;
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
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
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
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
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
	 * Gets the size.
	 *
	 * @return the size
	 */
	public Integer getSize() {
		return this.size;
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
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public Integer getWeight() {
		return this.weight;
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
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return this.gender;
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
	 * Gets the body fat.
	 *
	 * @return the body fat
	 */
	public Integer getBodyFat() {
		return this.body_fat;
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
	 * Gets the muscle mass.
	 *
	 * @return the muscle mass
	 */
	public Integer getMuscleMass() {
		return this.muscle_mass;
	}
	
	/**
	 * Sets the muscle mass.
	 *
	 * @param muscle_mass the new muscle mass
	 */
	public void setMuscleMass(Integer muscle_mass) {
		this.muscle_mass = muscle_mass;
	}
	


	@Override
	public String toString() {
		return "User [pseudonym=" + pseudonym + ", email=" + email + ", size=" + size + ", weight=" + weight
				+ ", gender=" + gender + ", body_fat=" + body_fat + ", muscle_mass=" + muscle_mass + "]";
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals (Object o) {
		if (o instanceof User) {
			User u = (User) o;
			return this.getPseudonym().equals(u.getPseudonym()) && this.getPassword().equals(u.getPassword());
		}
		return false;
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
	 * Sets the id role.
	 *
	 * @param id_role the id_role to set
	 */
	public void setIdRole(Integer id_role) {
		this.id_role = id_role;
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
	 * Sets the id morphology.
	 *
	 * @param id_morphology the id_morphology to set
	 */
	public void setIdMorphology(Integer id_morphology) {
		this.id_morphology = id_morphology;
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
	 * Sets the id goal.
	 *
	 * @param id_goal the id_goal to set
	 */
	public void setIdGoal(Integer id_goal) {
		this.id_goal = id_goal;
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
	 * Sets the id user.
	 *
	 * @param id_user the id_user to set
	 */
	public void setIdUser(Integer id_user) {
		this.id_user = id_user;
	}

	/**
	 * @return the structure
	 */
	public Structure getStructure() {
		return structure;
	}

	/**
	 * @param structure the structure to set
	 */
	public void setStructure(Structure structure) {
		this.structure = structure;
	}
	
}