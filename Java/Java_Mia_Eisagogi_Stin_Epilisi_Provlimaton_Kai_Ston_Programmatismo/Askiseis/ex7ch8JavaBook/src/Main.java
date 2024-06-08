/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: Understanding inheritance
 */


public class Main 
{

	public static void main(String[] args) 
	{
		SchoolKid kid1 = new SchoolKid("George", 12, "Anna", "It\'s lights out and way we go");
		ExaggeratingKid kid2 = new ExaggeratingKid("Martha", 9, "John", "Let\'s goooo");
		
		System.out.println("Name: " + kid1.getName() + "\n" + "Age: " + kid1.getAge() + 
				"\n" + "Teacher\'s name: " + kid1.getTeacherName() + "\n" + "Salute: " + kid1.getSalute());
		
		System.out.println("==============");
		
		System.out.println("Name: " + kid2.getName() + "\n" + "Age: " + kid2.getAge() + 
				"\n" + "Teacher\'s name: " + kid2.getTeacherName() + "\n" + "Salute: " + kid2.getSalute());
	}

}
