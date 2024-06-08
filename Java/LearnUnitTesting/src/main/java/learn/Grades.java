/*
 * Author: Thanos Moschou
 * Description: This is a small Java program that helped me learn more about Unit Testing
 * Last Modification Date: 16/12/2023
 * 
 * Unit testing: A type of software testing where one individual piece of code(unit) is being tested
 * by itself. Unit test isolates one single piece of code and verifies that that piece is working correctly.
 * In Java a unit is a class or a method inside a class. So unit test is code that hits that individual method
 * that you want to test and verify that it's doing exactly what it should do.
 */


package learn;

public class Grades 
{
	public char letterGrade(int percent) throws IllegalArgumentException
	{
		if(percent < 0)
			throw new IllegalArgumentException("Grade must be greater than 0");
		else if(percent < 50)
			return 'F';
		else if(percent < 60)
			return 'D';
		else if(percent < 70)
			return 'C';
		else if(percent < 90)
			return 'B';
		else 
			return 'A';
	}
}
