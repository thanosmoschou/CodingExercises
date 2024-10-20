/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: java revision exercise
 */

package rev5;

import java.util.ArrayList;

public class Course 
{
	private String name;
	private ArrayList<Student> enrolledStud = new ArrayList<>();
	private ClassRoom myClass;
	
	public Course(String name, ClassRoom aClass) 
	{
		this.name = name;
		this.myClass = aClass;
		this.myClass.addCourse(this);
	}

	
	public void enrollStudent(Student aStud)
	{
		if(enrolledStud.size() < myClass.getCapacity())
		{
			enrolledStud.add(aStud);
			aStud.addCourse(this);
			System.out.println("Student enrolled successfully");
		}
		else
			System.out.println("The class is full.");
	}
	
	
	public void printAllStudents()
	{
		for(Student s : enrolledStud)
			s.printInfo();
	}
	
	
	public void printClassRoom()
	{
		myClass.printInfo();
	}
	
	
	public String getName() 
	{
		return name;
	}

	
	public ClassRoom getClassRoom()
	{
		return myClass;
	}
	
	
	public ArrayList<Student> getEnrolledStud() 
	{
		return enrolledStud;
	}

	
	public void setClassRoom(ClassRoom aNewClass)
	{
		ArrayList<Course> c = myClass.getCourseList();
		c.remove(this); //remove this course from the previous classroom course list
		
		myClass = aNewClass;
		myClass.addCourse(this);
	}
	
}
