package grammateia;

public class Student 
{
	private String name;
	private String id;
	private Course myCourse;
	
	public Student(String aName, String anId)
	{
		name = aName;
		id = anId;
		myCourse = null;
	}
	
	public Student(String aName)
	{
		name = aName;
		id = "99999";
		myCourse = null;
	}

	public String getName() 
	{
		return name;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setMyCourse(Course aCourse)
	{
		myCourse = aCourse;
	}
	
	public void printInfo()
	{
		System.out.println("==============");

		if(myCourse != null)
			System.out.println("Student\'s name: " + name + "\n" + "ID: " + id + "\n" + "Course enrolled in: " + myCourse.getName());
		else
			System.out.println("Student\'s name: " + name + "\n" + "ID: " + id + "\n" + "Not enrolled in a course");

	}
}
