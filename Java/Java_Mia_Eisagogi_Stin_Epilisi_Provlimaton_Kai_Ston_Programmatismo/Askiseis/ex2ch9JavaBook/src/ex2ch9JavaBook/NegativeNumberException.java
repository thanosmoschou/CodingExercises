/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: Understanding exceptions
 */

package ex2ch9JavaBook;

public class NegativeNumberException extends Exception
{
	public NegativeNumberException()
	{
		super("You cannot have negative numbers to modulo operation");
	}
	
	
	public NegativeNumberException(String aMessage)
	{
		super(aMessage);
	}

}
