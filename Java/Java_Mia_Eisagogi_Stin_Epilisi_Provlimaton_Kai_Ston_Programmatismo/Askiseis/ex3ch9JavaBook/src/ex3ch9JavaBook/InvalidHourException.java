/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: Understanding exceptions in java
 */

package ex3ch9JavaBook;

public class InvalidHourException extends Exception 
{
	public InvalidHourException()
	{
		super("Invalid hour format");
	}
	
	
	public InvalidHourException(String aMessage)
	{
		super(aMessage);
	}
}
