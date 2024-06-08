/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: exception exercises
 */

package ex13ch9JavaBook;

public class EndOfTheRaceException extends Exception
{
	public EndOfTheRaceException()
	{
		super("This race is ended");
	}
	
	
	public EndOfTheRaceException(String aMessage)
	{
		super(aMessage);
	}
}
