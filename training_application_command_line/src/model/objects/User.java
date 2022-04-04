package model.objects;

import static utils.Encrypt.*;
/** Represents a user
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
public class User {
	private String pseudonym;
	private String password;
	private String email;
	private Integer size;
	private Integer weight;
	private String gender;
	private Integer body_fat;
	private Integer muscle_mass;
	private Morphology morphology;
	private Role role;
	private Goal goal;
	
	public User() {
		this.size = 0;
		this.weight = 0;
		this.gender = "0";
		this.body_fat = 0;
		this.muscle_mass = 0;
	}
	
	public String getPseudonym() {
		return this.pseudonym;
	}
	
	public void setPseudonym(String pseudonym) {
		this.pseudonym = pseudonym;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPasswordEncrypted(String password) {
		this.password = encrypt(password);
	}
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSize() {
		return this.size;
	}
	
	public void setSize(Integer size) {
		this.size = size;
	}
	
	public Integer getWeight() {
		return this.weight;
	}
	
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Integer getBodyFat() {
		return this.body_fat;
	}
	
	public void setBodyFat(Integer body_fat) {
		this.body_fat = body_fat;
	}
	
	public Integer getMuscleMass() {
		return this.muscle_mass;
	}
	
	public void setMuscleMass(Integer muscle_mass) {
		this.muscle_mass = muscle_mass;
	}
	

	@Override
	public String toString() {
		return this.getPseudonym();
	}
	
	@Override
	public boolean equals (Object o) {
		if (o instanceof User) {
			User u = (User) o;
			return this.getPseudonym().equals(u.getPseudonym()) && this.getPassword().equals(u.getPassword());
		}
		return false;
	}

	public Morphology getMorphology() {
		return morphology;
	}

	public void setMorphology(Morphology morphology) {
		this.morphology = morphology;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}
	
}