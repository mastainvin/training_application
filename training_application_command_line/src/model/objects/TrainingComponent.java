package model.objects;

import java.util.List;

/** Represents an element in a training (exercice + training method)
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
public class TrainingComponent {
	private Integer layout;
	private Boolean is_super_set;
	private ExerciceType exerciceType;
	private TrainingMethod trainingMethod;
	private List<Serie> seriesList;
	private List<Exercice> exercicesList;
	
	public Integer getLayout() {
		return this.layout;
	}
	
	public void setLayout(Integer layout) {
		this.layout = layout;
	}
	
	public Boolean getIsSuperSet() {
		return this.is_super_set;
	}
	
	public void setIsSuperSet(Boolean is_super_set) {
		this.is_super_set = is_super_set;
	}

	public TrainingMethod getTrainingMethod() {
		return trainingMethod;
	}

	public void setTrainingMethod(TrainingMethod trainingMethod) {
		this.trainingMethod = trainingMethod;
	}

	public List<Serie> getSeriesList() {
		return seriesList;
	}

	public void setSeriesList(List<Serie> seriesList) {
		this.seriesList = seriesList;
	}



	public List<Exercice> getExercicesList() {
		return exercicesList;
	}

	public void setExercicesList(List<Exercice> exercicesList) {
		this.exercicesList = exercicesList;
	}

	public ExerciceType getExerciceType() {
		return exerciceType;
	}

	public void setExerciceType(ExerciceType exerciceType) {
		this.exerciceType = exerciceType;
	}


	
	// TODO add toString and equals when connection with training, exercice type, method and serie
}
