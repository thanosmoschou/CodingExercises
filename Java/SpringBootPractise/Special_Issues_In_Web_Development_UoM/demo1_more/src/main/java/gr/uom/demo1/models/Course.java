package gr.uom.demo1.models;

public class Course {
	
	private String name;
	private String professor;
	private int semester;
	
	
	public Course(String name, String professor, int semester) {
		super();
		this.name = name;
		this.professor = professor;
		this.semester = semester;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
}
