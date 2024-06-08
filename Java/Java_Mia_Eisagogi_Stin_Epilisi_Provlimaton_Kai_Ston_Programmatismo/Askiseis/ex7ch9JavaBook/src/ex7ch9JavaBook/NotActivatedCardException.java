/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: understanding exceptions
 */

package ex7ch9JavaBook;

public class NotActivatedCardException extends Exception
{
	public NotActivatedCardException()
	{
		super("This card is not activated. Proceed with the activation.");
	}
	
	
	public NotActivatedCardException(String aMessage)
	{
		super(aMessage);
	}
}
