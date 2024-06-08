/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: exception exercises
 */

package ex13ch9JavaBook;

public class FirstLapNotCompletedException extends Exception
{
	public FirstLapNotCompletedException()
	{
		super("The first lap is not completed yet");
	}
	
	
	public FirstLapNotCompletedException(String aMessage)
	{
		super(aMessage);
	}
}
