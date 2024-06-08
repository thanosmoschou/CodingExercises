/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: first revision exercise. Contains university and students
 */

package rev1;

import java.util.ArrayList;

public class Main 
{

	public static void main(String[] args) 
	{
		Course c1 = new Course("Java", 5);
		Course c2 = new Course("Python", 5);
		Course c3 = new Course("C", 5);
		Course c4 = new Course("C++", 5);
		
		Student s1 = new Student("John", "dafdsfs");
		Student s2 = new GraduateStudent("alex", "dafdsfs", "markos");
		Student s3 = new Student("kostas", "dafdsfs");
		Student s4 = new GraduateStudent("thanos", "dafdsfs", "hlias");
		
		s1.addCourse(c1);
		s1.addCourse(c4);
		s2.addCourse(c4);
		s3.addCourse(c3);
		s4.addCourse(c2);
		
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<Course> courses = new ArrayList<>();
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		courses.add(c4);
		
		//DataEntry d = new DataEntry();
		
		DataEntry.readData(students, courses);
		
		for(Student s : students)
			s.printInfo();
		
	}

}
