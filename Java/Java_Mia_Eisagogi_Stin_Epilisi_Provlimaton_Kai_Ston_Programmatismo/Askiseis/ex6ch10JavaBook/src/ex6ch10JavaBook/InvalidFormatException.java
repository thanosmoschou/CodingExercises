/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: java file handling
 */

package ex6ch10JavaBook;

public class InvalidFormatException extends Exception
{
	public InvalidFormatException()
	{
		super("This format is invalid...Only formats such as xxx-xxx-xxxx or xxx-xxxx are accepted");
	}
	
	public InvalidFormatException(String aString)
	{
		super(aString);
	}
}
