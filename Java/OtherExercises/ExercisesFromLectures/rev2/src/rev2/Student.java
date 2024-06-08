/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: second revision exercise. Contains university and students
 */

package rev2;

import java.util.ArrayList;
import java.util.Random;

public class Student 
{
	private String name;
	private String id;
	private ArrayList<Course> courses = new ArrayList<>();
	
	public Student(String name, Course enrolledCourse) 
	{
		this.name = name;
		this.id = createID();
		addCourse(enrolledCourse);
	}
	
	private String createID()
	{
		Random rand = new Random();
		String[] letters = {"a", "b", "c", "d", "e", "f", "1", "2", "3", "0"};
		String id = "";
		
		for(int i = 0; i < 5; i++)
			id += letters[rand.nextInt(0, letters.length)];
		
		return id;	
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
