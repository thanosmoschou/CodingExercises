/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: exception exercises
 */

package ex13ch9JavaBook;

public class AlreadyStartedException extends Exception
{
	public AlreadyStartedException()
	{
		super("This race already started.");
	}
	
	
	public AlreadyStartedException(String aMessage)
	{
		super(aMessage);
	}
}
