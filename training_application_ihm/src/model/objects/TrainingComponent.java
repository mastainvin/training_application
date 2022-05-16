package model.objects;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * Represents an element in a training (exercice + training method).
 *
 * @author Vincent Mastain
 * @version 1.0
 */
public class TrainingComponent implements Comparable<TrainingComponent> {

	/** The biomecanic function list. */
	private List<BiomecanicFunction> biomecanic_function_list;

	/** The chosen exercice. */
	private Exercice chosenExercice;

	/** The exercices list. */
	private List<Exercice> exercicesList;

	/** The id biomecanic function list. */
	private Integer id_biomecanic_function_list;

	/** The id exercice type. */
	private Integer id_exercice_type;

	/** The id training. */
	private Integer id_training;

	/** The id training method. */
	private Integer id_training_method;

	/** The is super set. */
	private Boolean is_super_set;

	/** The layout. */
	private Integer layout;

	/** The series list. */
	private List<Serie> seriesList;

	/** The training method. */
	private TrainingMethod trainingMethod;

	/**
	 * Instantiates a new training component.
	 */
	public TrainingComponent() {
		layout = 0;
		is_super_set = false;

	}

	/**
	 * Compare to.
	 *
	 * @param o the o
	 * @return the int
	 */
	@Override
	public int compareTo(TrainingComponent o) {
		TrainingComponent t = o;
		if (this.getLayout().equals(t.getLayout())) {
			return 0;
		} else if (this.getLayout() > t.getLayout()) {
			return 1;
		}
		return -1;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainingComponent other = (TrainingComponent) obj;
		if (id_biomecanic_function_list == null) {
			if (other.id_biomecanic_function_list != null)
				return false;
		} else if (!id_biomecanic_function_list.equals(other.id_biomecanic_function_list) && is_super_set == false)
			return false;
		if (id_exercice_type == null) {
			if (other.id_exercice_type != null)
				return false;
		} else if (!id_exercice_type.equals(other.id_exercice_type) && is_super_set == false)
			return false;
		if (id_training == null) {
			if (other.id_training != null)
				return false;
		} else if (!id_training.equals(other.id_training))
			return false;
		if (id_training_method == null) {
			if (other.id_training_method != null)
				return false;
		} else if (!id_training_method.equals(other.id_training_method))
			return false;
		if (is_super_set == null) {
			if (other.is_super_set != null)
				return false;
		} else if (!is_super_set.equals(other.is_super_set) || Math.abs(layout - other.getLayout()) > 1)
			return false;

		return true;
	}

	/**
	 * Gets the biomecanic function list.
	 *
	 * @return the biomecanic_function_list
	 */
	public List<BiomecanicFunction> getBiomecanicFunctionList() {
		return biomecanic_function_list;
	}

	/**
	 * Gets the chosen exercice.
	 *
	 * @return the chosenExercice
	 */
	public Exercice getChosenExercice() {
		return chosenExercice;
	}

	/**
	 * Gets the exercices list.
	 *
	 * @return the exercices list
	 */
	public List<Exercice> getExercicesList() {
		return exercicesList;
	}

	/**
	 * Gets the id biomecanic function list.
	 *
	 * @return the id_biomecanic_function_list
	 */
	public Integer getIdBiomecanicFunctionList() {
		return id_biomecanic_function_list;
	}

	/**
	 * Gets the id exercice type.
	 *
	 * @return the id_exercice_type
	 */
	public Integer getIdExerciceType() {
		return id_exercice_type;
	}

	/**
	 * Gets the id training.
	 *
	 * @return the id_training
	 */
	public Integer getIdTraining() {
		return id_training;
	}

	/**
	 * Gets the id training method.
	 *
	 * @return the id_training_method
	 */
	public Integer getIdTrainingMethod() {
		return id_training_method;
	}

	/**
	 * Gets the checks if is super set.
	 *
	 * @return the checks if is super set
	 */
	public Boolean getIsSuperSet() {
		return this.is_super_set;
	}

	/**
	 * Gets the layout.
	 *
	 * @return the layout
	 */
	public Integer getLayout() {
		return this.layout;
	}

	/**
	 * Gets the series list.
	 *
	 * @return the series list
	 */
	public List<Serie> getSeriesList() {
		return seriesList;
	}

	/**
	 * Gets the training method.
	 *
	 * @return the trainingMethod
	 */
	public TrainingMethod getTrainingMethod() {
		return trainingMethod;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_biomecanic_function_list == null) ? 0 : id_biomecanic_function_list.hashCode());
		result = prime * result + ((id_exercice_type == null) ? 0 : id_exercice_type.hashCode());
		result = prime * result + ((id_training == null) ? 0 : id_training.hashCode());
		result = prime * result + ((id_training_method == null) ? 0 : id_training_method.hashCode());
		result = prime * result + ((is_super_set == null) ? 0 : is_super_set.hashCode());
		result = prime * result + ((layout == null) ? 0 : layout.hashCode());
		return result;
	}

	/**
	 * Sets the biomecanic function list.
	 *
	 * @param biomecanic_function_list the biomecanic_function_list to set
	 */
	public void setBiomecanicFunctionList(List<BiomecanicFunction> biomecanic_function_list) {
		this.biomecanic_function_list = biomecanic_function_list;
	}

	/**
	 * Sets the chosen exercice.
	 *
	 * @param chosenExercice the chosenExercice to set
	 */
	public void setChosenExercice(Exercice chosenExercice) {
		this.chosenExercice = chosenExercice;
	}

	/**
	 * Sets the exercices list.
	 *
	 * @param exercicesList the new exercices list
	 */
	public void setExercicesList(List<Exercice> exercicesList) {
		this.exercicesList = exercicesList;
	}

	/**
	 * Sets the id biomecanic function list.
	 *
	 * @param id_biomecanic_function_list the id_biomecanic_function_list to set
	 */
	public void setIdBiomecanicFunctionList(Integer id_biomecanic_function_list) {
		this.id_biomecanic_function_list = id_biomecanic_function_list;
	}

	/**
	 * Sets the id exercice type.
	 *
	 * @param id_exercice_type the id_exercice_type to set
	 */
	public void setIdExerciceType(Integer id_exercice_type) {
		this.id_exercice_type = id_exercice_type;
	}

	/**
	 * Sets the id training.
	 *
	 * @param id_training the id_training to set
	 */
	public void setIdTraining(Integer id_training) {
		this.id_training = id_training;
	}

	/**
	 * Sets the id training method.
	 *
	 * @param id_training_method the id_training_method to set
	 */
	public void setIdTrainingMethod(Integer id_training_method) {
		this.id_training_method = id_training_method;
	}

	/**
	 * Sets the checks if is super set.
	 *
	 * @param is_super_set the new checks if is super set
	 */
	public void setIsSuperSet(Boolean is_super_set) {
		this.is_super_set = is_super_set;
	}

	/**
	 * Sets the layout.
	 *
	 * @param layout the new layout
	 */
	public void setLayout(Integer layout) {
		this.layout = layout;
	}

	/**
	 * Sets the series list.
	 *
	 * @param seriesList the new series list
	 */
	public void setSeriesList(List<Serie> seriesList) {
		this.seriesList = seriesList;
	}

	/**
	 * Sets the training method.
	 *
	 * @param trainingMethod the trainingMethod to set
	 */
	public void setTrainingMethod(TrainingMethod trainingMethod) {
		this.trainingMethod = trainingMethod;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "TrainingComponent [id_training=" + id_training + ", is_super_set=" + is_super_set + ", layout=" + layout
				+ "]";
	}

	// TODO add toString and equals when connection with training, exercice type,
	// method and serie
}
