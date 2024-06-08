/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: second revision exercise. Contains university and students
 */

package rev2;

import java.util.ArrayList;

public class Main 
{

	public static void main(String[] args) 
	{
		Course c1 = new Course("Java", 5);
		Course c2 = new Course("Python", 5);
		Course c3 = new Course("C", 5);
		Course c4 = new Course("C++", 5);
				
		ArrayList<Course> courses = new ArrayList<>();
		
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		courses.add(c4);
		
		new MyFrame(courses);
		
	}

}
