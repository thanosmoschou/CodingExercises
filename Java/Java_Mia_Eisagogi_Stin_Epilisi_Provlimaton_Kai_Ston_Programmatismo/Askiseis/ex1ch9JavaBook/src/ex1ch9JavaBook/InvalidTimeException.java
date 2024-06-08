/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: Learning to handle exceptions
 */

package ex1ch9JavaBook;

public class InvalidTimeException extends Exception
{
	public InvalidTimeException()
	{
		super("This time is invalid");
	}
	
	
	public InvalidTimeException(String aMessage)
	{
		super(aMessage);
	}
}
