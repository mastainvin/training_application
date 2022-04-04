package model.objects;

/** Represents a serie during a trainig for one exercice
 * 
 * @author Vincent Mastain
 * @version 1.0
 */
public class Serie {
	private String date;
	private Integer weight;
	private Integer repetitions;
	private Integer rpe;
	private Integer expected_repetitions;
	private Integer expected_weight;
	private Integer layout;
	private Boolean inActualWeek;
	
	public String getDate() {
		return this.date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public Integer getWeight() {
		return this.weight;
	}
	
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	public Integer getRepetitions() {
		return this.repetitions;
	}
	
	public void setRepetitions(Integer repetitions) {
		this.repetitions = repetitions;
	}
	
	public Integer getRpe() {
		return this.rpe;
	}
	
	public void setRpe(Integer rpe) {
		this.rpe = rpe;
	}
	
	public Integer getExpectedRepetitions() {
		return this.expected_repetitions;
	}
	public void setExpectedRepetitions(Integer expected_repetitions) {
		this.expected_repetitions = expected_repetitions;
	}
	public Integer getExpectedWeight() {
		return expected_weight;
	}

	public void setExpectedWeight(Integer expected_weight) {
		this.expected_weight = expected_weight;
	}

	public Integer getLayout() {
		return layout;
	}

	public void setLayout(Integer layout) {
		this.layout = layout;
	}

	public Boolean getInActualWeek() {
		return inActualWeek;
	}

	public void setInActualWeek(Boolean inActualWeek) {
		this.inActualWeek = inActualWeek;
	}



	
	// TODO add toString and equals
}
