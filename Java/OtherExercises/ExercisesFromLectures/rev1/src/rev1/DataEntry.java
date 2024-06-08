/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: first revision exercise. Contains university and students
 */

package rev1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DataEntry 
{
	public static void readData(ArrayList<Student> stud, ArrayList<Course> cour)
	{
		Random rand = new Random();
		
		int decision;
		String cont;
		String aName, anID;
		Scanner in = new Scanner(System.in);
		Student enrollStud = null;
		
		while(true)
		{
			System.out.println("Enter 1 for Student and 2 for Graduate Student: ");
			decision = in.nextInt(); //assume that he gives correct data..no validity check for now
			in.nextLine();
			
			System.out.println("Enter student\'s name: ");
			aName = in.nextLine();
			
			System.out.println("Enter student\'s id: ");
			anID = in.nextLine();
			
			if(decision == 1)
			{
				enrollStud = new Student(aName, anID);
				stud.add(enrollStud);
			}
			else if(decision == 2)
			{
				String aSupervisorName;
				
				System.out.println("Enter supervisor\'s name: ");
				aSupervisorName = in.nextLine();
				
				enrollStud = new GraduateStudent(aName, anID, aSupervisorName);
				stud.add(enrollStud);	
			}
						
			//courses are assigned to students with random format.
			enrollStud.addCourse(cour.get(rand.nextInt(0, cour.size())));

			System.out.println("Continue Y/N ? ");
			cont = in.nextLine();
			
			if(cont.equalsIgnoreCase("N"))
				break;
			
		}
	}
}
