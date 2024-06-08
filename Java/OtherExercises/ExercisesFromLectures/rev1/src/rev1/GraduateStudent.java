/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: first revision exercise. Contains university and students
 */

package rev1;

public class GraduateStudent extends Student
{
	private String supervisorName;
	
	public GraduateStudent(String aName, String anID, String aSupervisorName)
	{
		super(aName, anID);
		this.supervisorName = aSupervisorName;
	}
	
	public void printInfo()
	{
		System.out.println("Student Name: " + this.getName() + " ID: " + this.getId() + " Supervisor: " + supervisorName);
		System.out.println("***Course Details***");
		for(Course c : this.getCourses())
			c.printInfo();
	}

	public String getSupervisorName()
	{
		return supervisorName;
	}
	
}
