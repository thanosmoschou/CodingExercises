/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: first revision exercise. Contains university and students
 */

package rev1;

import java.util.ArrayList;

public class Course 
{
	private String name;
	private int ects;
	private ArrayList<Student> enrolled = new ArrayList<>();
	
	public Course(String name, int ects) 
	{
		this.name = name;
		this.ects = ects;
	}

	public void addStudent(Student aStudent)
	{
		enrolled.add(aStudent);
		System.out.println("Student added successfully");
	}
	
	public void printInfo()
	{
		System.out.println("Course Name: " + name + " ECTS: " + ects);
		System.out.println("------");
	}
	
	public String getName() 
	{
		return name;
	}

	public int getEcts() 
	{
		return ects;
	}
	
}
