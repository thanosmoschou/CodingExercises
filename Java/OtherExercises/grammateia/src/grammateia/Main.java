package grammateia;

public class Main 
{

	public static void main(String[] args) 
	{
		Student s1 = new Student("Babis", "12345");
		Student s2 = new Student("Sakis");
		
		ClassRoom clas1 = new ClassRoom("1st Floor", 10);
		ClassRoom clas2 = new ClassRoom(20);
		
		Course c1 = new Course("Java", clas1);
		Course c2 = new Course("Python", clas2);
		
		s1.printInfo();
		s2.printInfo();
		
		System.out.println("\nCLASSROOM DETAILS:\n");
		clas1.printClassRoomInfo();
		clas2.printClassRoomInfo();
		System.out.println("==========================");
		
		c1.addStudent(s1);
		c1.addStudent(s2);
				
		c1.printListOfStudents();
		c2.printListOfStudents();
		
		System.out.println("==========================");

		c1.printDetailsOfThisCourseClassRoom();
		c2.printDetailsOfThisCourseClassRoom();
		
		c1.changeClassRoom(clas2);
		
		System.out.println("==========================");

		c1.printDetailsOfThisCourseClassRoom();
		c2.printDetailsOfThisCourseClassRoom();
		
		Registry r1 = new Registry("Efarmosmeni pliroforiki");
		
		r1.addCourse(c1);
		r1.addCourse(c2);
		
		r1.printAllCoursesInfo();
		
	}

}
