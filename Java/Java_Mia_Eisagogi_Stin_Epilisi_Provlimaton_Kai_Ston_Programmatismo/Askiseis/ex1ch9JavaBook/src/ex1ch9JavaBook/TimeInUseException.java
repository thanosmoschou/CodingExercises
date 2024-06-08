/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: Learning to handle exceptions
 */

package ex1ch9JavaBook;

public class TimeInUseException extends Exception
{
	public TimeInUseException()
	{
		super("This time is unavailable.");
	}
	
	
	public TimeInUseException(String aMessage)
	{
		super(aMessage);
	}
}
