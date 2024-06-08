/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: understanding exceptions
 */

package ex7ch9JavaBook;

public class AlreadyActivatedException extends Exception
{
	public AlreadyActivatedException()
	{
		super("This card is already activated. Enjoy your songs!");
	}
	
	
	public AlreadyActivatedException(String aMessage)
	{
		super(aMessage);
	}
}
