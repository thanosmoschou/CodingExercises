/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: java revision exercise
 */

package rev5;

import java.util.ArrayList;

public class Student 
{
	private String name;
	private String id;
	private ArrayList<Course> courses = new ArrayList<>();
	
	public Student(String name, String id) 
	{
		this.name = name;
		this.id = id;
	}
	
	
	public void printInfo()
	{
		System.out.println("Student details: ");
		System.out.println("Name: " + name);
		System.out.println("ID: " + id);
		System.out.println("Courses enrolled in: ");
		for(Course c : courses)
			System.out.println(c.getName());
		System.out.println("----------");
	}
	
	
	public void addCourse(Course aCourse) //assume that this method is only called inside the enrollStudent method of Course class
	{
		courses.add(aCourse);
	}
	
	
	public String getName() 
	{
		return name;
	}

	
	public String getId() 
	{
		return id;
	}
	
}
