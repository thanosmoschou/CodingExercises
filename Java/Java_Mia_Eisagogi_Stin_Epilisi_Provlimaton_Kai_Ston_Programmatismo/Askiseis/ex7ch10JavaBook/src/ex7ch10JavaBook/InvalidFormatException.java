/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: file handling in java
 */

package ex7ch10JavaBook;

public class InvalidFormatException extends Exception
{
	public InvalidFormatException()
	{
		super("Invalid data format.");
	}
	
	public InvalidFormatException(String aMessage)
	{
		super(aMessage);
	}
}
