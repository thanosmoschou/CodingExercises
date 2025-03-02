/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: java revision exercise
 */

package rev5;

import java.util.ArrayList;

public class ClassRoom 
{
	private String name;
	private int capacity;
	private ArrayList<Course> courses = new ArrayList<>();
	
	public ClassRoom(String name, int capacity) 
	{
		this.name = name;
		this.capacity = capacity;
	}

	
	public void addCourse(Course aCourse)
	{
		courses.add(aCourse);
		System.out.println("Course: " + aCourse.getName() + " is now in class: " + name);
	}
	
	
	public void printInfo()
	{
		System.out.println("Class Details: ");
		System.out.println("Name/Location: " + name);
		System.out.println("Capacity: " + capacity);
		System.out.println("Courses that are on this classroom: ");
		for(Course c : courses)
			System.out.println(c.getName());
		System.out.println("--------");
	}
	
	
	public String getName()
	{
		return name;
	}

	
	public int getCapacity() 
	{
		return capacity;
	}
	
	
	//to delete the course if the classroom is changed
	public ArrayList<Course> getCourseList()
	{
		return courses;
	}
	
	
}
