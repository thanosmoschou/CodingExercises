/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: Understanding exceptions in java
 */

package ex3ch9JavaBook;

public class InvalidMinuteException extends Exception
{
	public InvalidMinuteException()
	{
		super("Only range 0-59 is accepted");
	}
	
	
	public InvalidMinuteException(String aMessage)
	{
		super(aMessage);
	}
}
