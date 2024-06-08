/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: first revision exercise. Contains university and students
 */

package rev1;

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
	
	public void addCourse(Course aCourse)
	{
		courses.add(aCourse);
		aCourse.addStudent(this);
		System.out.println("Course is added successfully!");
	}
	
	public void printInfo()
	{
		System.out.println("Student Name: " + name + " ID: " + id);
		System.out.println("***Course Details***");
		for(Course c : courses)
			c.printInfo();
	}
	
	public String getName() 
	{
		return name;
	}

	public String getId() 
	{
		return id;
	}

	public ArrayList<Course> getCourses() 
	{
		return courses;
	}
	
}
