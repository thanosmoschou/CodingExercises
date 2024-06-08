/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: Understanding inheritance
 */

public class SchoolKid 
{
	private String name;
	private int age;
	private String teacherName;
	private String salute;
	
	
	public SchoolKid(String aName, int anAge, String aTeacherName, String aSalute)
	{
		name = aName;
		age = anAge;
		teacherName = aTeacherName;
		salute = aSalute;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public String getSalute() {
		return salute;
	}


	public void setSalute(String salute) {
		this.salute = salute;
	}
	
	
	
}
