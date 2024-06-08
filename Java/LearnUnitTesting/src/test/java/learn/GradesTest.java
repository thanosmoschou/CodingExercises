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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


//This will only tests the Grades class
class GradesTest 
{
	
	//MAKE SURE YOU TEST ALL THE EDGE CASES
	
	/*
	 * Make sure that every Unit test that you write, is testing only one scenario.
	 * In JUnit 5 the test methods do not need to be public and they do not need to return anything.
	 * The name of the test method can be whatever you want but it should be something descriptive 
	 * of the exact the scenario being tested and what the result should be.
	 * 
	 * When our code isn't doing the right thing, at least one unit test should fail.
	 * Make sure you write multiple unit tests to check if the code is doing everything
	 * that is supposed to.
	 * 
	 * Make sure that each scenario is tested in its own test method. You should never combine
	 * multiple scenarios into one single test method.
	 * 
	 * The goal is to hit 100% coverage so all the test methods hit all the lines of the tested code.
	 */

	@Test
	void illegalArgumentWillCauseException()
	{
		var calc = new Grades();
		
		//With .class I will get the Class object that refers to IllegalArgumentException class
		//assertThrows needs a Class object and the executable piece of code that will
		//raise an exception. So I will provide a lambda function
		assertThrows(IllegalArgumentException.class, 
				() -> {
					calc.letterGrade(-1);
				});
	}
	
	
	@Test
	void zeroIsF()
	{
		var calc = new Grades();
		assertEquals('F', calc.letterGrade(0));
	}
	
	
	@Test
	void oneIsF()
	{
		var calc = new Grades();
		assertEquals('F', calc.letterGrade(1));
	}
	
	
	@Test
	void fourtyIsF()
	{
		var calc = new Grades();
		assertEquals('F', calc.letterGrade(40));
	}
	
	
	@Test
	void fourtyNineIsF()
	{
		var calc = new Grades();
		assertEquals('F', calc.letterGrade(49));
	}
	
	
	@Test
	void fiftyIsD()
	{
		var calc = new Grades();
		assertEquals('D', calc.letterGrade(50));
	}
	
	
	@Test
	void fiftyOneIsD()
	{
		var calc = new Grades();
		assertEquals('D', calc.letterGrade(51));
	}
	
	
	@Test
	void fiftyNineIsD()
	{
		var calc = new Grades();
		assertEquals('D', calc.letterGrade(59));
	}
	
	
	@Test
	void sixtyIsC()
	{
		var calc = new Grades();
		assertEquals('C', calc.letterGrade(60));
	}
	
	
	@Test
	void sixtyNineIsC()
	{
		var calc = new Grades();
		assertEquals('C', calc.letterGrade(69));
	}
	
	
	@Test
	void seventyIsB()
	{
		var calc = new Grades();
		assertEquals('B', calc.letterGrade(70));
	}
	
	
	@Test
	void eightyNineIsB()
	{
		var calc = new Grades();
		assertEquals('B', calc.letterGrade(89));
	}

	
	@Test
	void ninetyIsA()
	{
		var calc = new Grades();
		assertEquals('A', calc.letterGrade(90));
	}
}
