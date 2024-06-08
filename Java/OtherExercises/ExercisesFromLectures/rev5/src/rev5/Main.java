/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: java revision exercise
 */

package rev5;

public class Main 
{

	public static void main(String[] args) 
	{
		ClassRoom cl1 = new ClassRoom("a2" , 3);
		ClassRoom cl2 = new ClassRoom("area51", 5);
		
		Course cour1 = new Course("Java", cl1);
		Course cour2 = new Course("python", cl2);
		Course cour3 = new Course("Maths", cl1);
		
		Registry r = new Registry("ics");
		
		r.addCourse(cour1);
		r.addCourse(cour2);
		r.addCourse(cour3);
		
		Student s1 = new Student("john", "sfaa");
		Student s2 = new Student("alex", "faf");
		Student s3 = new Student("maria", "sffdsgsaa");
		Student s4 = new Student("katerina", "fdsgsg");
		Student s5 = new Student("thanos", "hdhdh");
		Student s6 = new Student("eleni", "hddgb");

		cour1.enrollStudent(s1);
		cour1.enrollStudent(s6);
		cour1.enrollStudent(s5);
		cour1.enrollStudent(s3);
		cour2.enrollStudent(s6);
		cour2.enrollStudent(s2);
		
		cour1.printAllStudents();
		cour1.printClassRoom();
		
		cour1.setClassRoom(cl2);
		
		cl1.printInfo();
		cl2.printInfo();


	}

}
