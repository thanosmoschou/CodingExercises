package grammateia;

public class ClassRoom 
{
	private String location;
	private int capacity;
	private Course courseTaught;
	
	public ClassRoom(String aLocation, int aCapacity)
	{
		location = aLocation;
		capacity = aCapacity;
		courseTaught = null;
	}
	
	public ClassRoom(int aCapacity)
	{
		location = "Unknown location";
		capacity = aCapacity;
		courseTaught = null;
	}

	public String getLocation() 
	{
		return location;
	}

	public int getCapacity() 
	{
		return capacity;
	}
	
	public void setCourseTaught(Course aCourse)
	{
		courseTaught = aCourse;
	}
	
	public void printClassRoomInfo()
	{
		System.out.println("Classroom location: " + location + "\n" + "Classroom capacity: " + capacity);

		if(courseTaught != null)
			System.out.println("Course that is taught in this classroom: " + courseTaught.getName());
		else
			System.out.println("No course in this classroom");

	}
	
}
