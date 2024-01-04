package model;

public class Program {
	
	//Attributes
	private String programName;
	private String category;
	private String universityName;
	private String gradeRange;
	private String coopAvailable;
	private String prerequisites;
	
	//Constructor method
	public Program(String programName, String category, String universityName, String gradeRange, String coopAvailable,
			String prerequisites) {
		
		super();
		this.programName = programName;
		this.category = category;
		this.universityName = universityName;
		this.gradeRange = gradeRange;
		this.coopAvailable = coopAvailable;
		this.prerequisites = prerequisites;
	}
	
	//Getters and setters
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getGradeRange() {
		return gradeRange;
	}
	public void setGradeRange(String gradeRange) {
		this.gradeRange = gradeRange;
	}
	public String getCoopAvailable() {
		return coopAvailable;
	}
	public void setCoopAvailable(String coopAvailable) {
		this.coopAvailable = coopAvailable;
	}
	public String getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}

	@Override
	public String toString() {
		return  "Program Name: " + programName + "<br>Category: " + category + "<br>University: " + universityName
				+ "<br>Grade Range: " + gradeRange + "<br>Co-op: " + coopAvailable + "<br>Prerequisites: " + prerequisites;
	}
	
}
