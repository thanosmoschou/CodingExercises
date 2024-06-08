package grammateia;
import java.util.ArrayList;

public class Registry 
{
	private String name;
	private ArrayList<Course> courses = new ArrayList<Course>();
	
	public Registry(String aName)
	{
		name = aName;
	}
	
	public void addCourse(Course aCourse)
	{
		courses.add(aCourse);
	}
	
	public void printAllCoursesInfo()
	{
		System.out.println("Registry Name: " + name);
		
		for(Course cour: courses)
		{
			System.out.println("Course name: " + cour.getName());
			cour.printDetailsOfThisCourseClassRoom();
			cour.printListOfStudents();
		}
	}
}
