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

//This test will test the Calculator class
class CalculatorTest 
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
	
	
	//A unit test is a method that you label with @Test annotation
	@Test
	void threePlusThreeEqualsSix() 
	{
		var calc = new Calculator();
		assertEquals(6, calc.addNumbers(3, 3)); //You will use that often
		
		//assertNotEquals(6, calc.addNumbers(3, 3)); this will fail
		//assertNotEquals(4, calc.addNumbers(3, 3)); this will pass
	}
	
	
	@Test
	void sevenPlusSevenEqualsFourteen()
	{
		var calc = new Calculator();
		
		//you can either call assertEquals or assertNotEquals or any other assert method that suits your needs.
		assertEquals(14, calc.addNumbers(7, 7));
		assertNotEquals(13, calc.addNumbers(7, 7)); //only for showing purposes of assertNotEquals
	}
	
	
	@Test
	void twoMinusOneEqualsOne()
	{
		var calc = new Calculator();
		assertEquals(1, calc.subtractNumbers(2, 1));
	}
	
	
	@Test
	void tenMinusTenEqualsZero()
	{
		var calc = new Calculator();
		assertEquals(0, calc.subtractNumbers(10, 10));
		assertNotEquals(1, calc.subtractNumbers(10, 10));
	}
	

}
