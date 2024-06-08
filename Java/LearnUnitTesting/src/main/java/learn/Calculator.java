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

public class Calculator 
{
	public int addNumbers(int num1, int num2)
	{
		return num1 + num2;
	}
	
	public int subtractNumbers(int num1, int num2)
	{
		return num1 - num2;
	}
}
