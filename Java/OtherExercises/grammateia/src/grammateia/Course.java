package grammateia;
import java.util.ArrayList;

public class Course 
{
	private String name;
	private ArrayList<Student> enrolledStudents = new ArrayList<Student>();
	private ClassRoom myClassRoom;
	
	public Course(String aName, ClassRoom aClassRoom)
	{
		name = aName;
		aClassRoom.setCourseTaught(this);
		myClassRoom = aClassRoom;
	}

	public String getName() 
	{
		return name;
	}
	
	public void addStudent(Student aStudent)
	{
		if(enrolledStudents.size() < myClassRoom.getCapacity())
		{
			enrolledStudents.add(aStudent);
			aStudent.setMyCourse(this);
		}
		else
			System.out.println("Full classroom capacity");
	}
	
	public void printListOfStudents()
	{
		if(enrolledStudents.size() > 0)
		{
			for(Student stud: enrolledStudents)
				stud.printInfo();
		}
		else
			System.out.println("Sorry this course is still empty.");
	}
	
	public void changeClassRoom(ClassRoom aClassRoom)
	{
		aClassRoom.setCourseTaught(this);
		myClassRoom = aClassRoom;
	}
	
	public void printDetailsOfThisCourseClassRoom()
	{
		myClassRoom.printClassRoomInfo();
	}
	
}
