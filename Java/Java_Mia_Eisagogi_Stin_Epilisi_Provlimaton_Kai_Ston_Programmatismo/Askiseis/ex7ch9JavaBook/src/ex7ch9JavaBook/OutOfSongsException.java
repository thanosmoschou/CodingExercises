/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: understanding exceptions
 */

package ex7ch9JavaBook;

public class OutOfSongsException extends Exception
{
	public OutOfSongsException()
	{
		super("You reached the limit of songs with this card.");
	}
	
	
	public OutOfSongsException(String aMessage)
	{
		super(aMessage);
	}
}
