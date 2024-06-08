/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: exception handling exercises
 */

package ex10ch9JavaBook;

public class NegativeCounterException extends Exception
{
	public NegativeCounterException()
	{
		super("This action is prohibited because there is no one in the room");
	}
	
	
	public NegativeCounterException(String aMessage)
	{
		super(aMessage);
	}
}
