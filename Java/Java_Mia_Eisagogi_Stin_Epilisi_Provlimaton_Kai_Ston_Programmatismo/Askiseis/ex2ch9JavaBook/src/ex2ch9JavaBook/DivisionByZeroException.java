/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: Understanding exceptions
 */

package ex2ch9JavaBook;

public class DivisionByZeroException extends Exception 
{
	public DivisionByZeroException()
	{
		super("You cannot have 0 as a divisor.");
	}
	
	
	public DivisionByZeroException(String aMessage)
	{
		super(aMessage);
	}
}
