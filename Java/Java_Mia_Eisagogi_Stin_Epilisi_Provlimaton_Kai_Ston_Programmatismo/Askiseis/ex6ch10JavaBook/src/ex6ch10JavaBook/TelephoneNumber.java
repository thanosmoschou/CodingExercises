/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: java file handling
 */

package ex6ch10JavaBook;

public class TelephoneNumber
{
	private int areaCode;
	private int exchangeCode;
	private int number;
	
	public TelephoneNumber(String aString) throws InvalidFormatException
	{
		if(aString.length() != 12 && aString.length() != 8)
			throw new InvalidFormatException();
		
		if(aString.length() == 12)
		{
			areaCode = Integer.parseInt(aString.substring(0, 3));
			exchangeCode = Integer.parseInt(aString.substring(4, 7));
			number = Integer.parseInt(aString.substring(8));	
		}
		else
		{
			areaCode = 0; //this value is missing from the given number so it is format xxx-xxxx
			exchangeCode = Integer.parseInt(aString.substring(0, 3));
			number = Integer.parseInt(aString.substring(4));
		}
	}
	
	
	public String toString()
	{
		if(areaCode == 0)
			return (Integer.toString(exchangeCode) + "-" + Integer.toString(number));
		
		return (Integer.toString(areaCode) + "-" + Integer.toString(exchangeCode) + "-" + Integer.toString(number));
	}
}
