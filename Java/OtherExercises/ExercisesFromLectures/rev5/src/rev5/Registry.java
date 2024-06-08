/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: java revision exercise
 */

package rev5;

import java.util.ArrayList;

public class Registry 
{
	private String name;
	private ArrayList<Course> courses = new ArrayList<>();
	
	public Registry(String aName)
	{
		name = aName;
	}
	
	
	public void addCourse(Course aCourse)
	{
		courses.add(aCourse);
		System.out.println("Course is successfully added to the registry");
	}
	
	
	public void printCoursesInfo()
	{
		System.out.println("Courses Info:");
		for(Course c : courses)
		{
			System.out.println("Name: " + c.getName());
			c.printClassRoom();
			c.printAllStudents();
		}
	}
}
