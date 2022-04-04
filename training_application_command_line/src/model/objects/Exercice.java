/**
 * 
 */
package model.objects;



/** Represents a training exercice
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
public class Exercice {
	private String name;
	private String description;
	private UserExerciceData userExerciceDatas;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UserExerciceData getUserExerciceDatas() {
		return userExerciceDatas;
	}
	public void setUserExerciceDatas(UserExerciceData userExerciceDatas) {
		this.userExerciceDatas = userExerciceDatas;
	}

}
