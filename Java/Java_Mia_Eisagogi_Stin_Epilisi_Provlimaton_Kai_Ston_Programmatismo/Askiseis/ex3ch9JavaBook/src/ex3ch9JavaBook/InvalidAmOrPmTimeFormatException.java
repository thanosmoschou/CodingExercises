/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: Understanding exceptions in java
 */

package ex3ch9JavaBook;

public class InvalidAmOrPmTimeFormatException extends Exception
{
	public InvalidAmOrPmTimeFormatException()
	{
		super("Only pm or am are accepted");
	}
	
	
	public InvalidAmOrPmTimeFormatException(String aMessage)
	{
		super(aMessage);
	}
}
