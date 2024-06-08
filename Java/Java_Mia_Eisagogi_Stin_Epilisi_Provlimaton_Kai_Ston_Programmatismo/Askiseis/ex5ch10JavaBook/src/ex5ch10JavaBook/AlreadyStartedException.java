/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: exception exercises
 */

package ex5ch10JavaBook;

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
