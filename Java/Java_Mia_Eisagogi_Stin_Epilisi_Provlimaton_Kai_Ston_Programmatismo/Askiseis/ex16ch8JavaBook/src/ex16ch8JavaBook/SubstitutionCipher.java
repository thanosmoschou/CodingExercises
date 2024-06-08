/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: Understanding interfaces
 * 
 */

package ex16ch8JavaBook;

public class SubstitutionCipher implements MessageEncoder
{
	private int shift;
	
	public SubstitutionCipher(int shift)
	{
		this.shift = shift;
	}
	
	
	public String encode(String plainText)
	{
		String encrypted = "";
		
		for(int i = 0; i < plainText.length(); i++)
		{
			encrypted += convert(plainText.charAt(i));
		}
		
		return encrypted;
	}
	
	
	private char convert(char aChar)
	{
		if(aChar == ' ')
			return ' ';
		return (char) ((int) aChar + shift); //convert aChar to ascii value, then add the shift and finally convert the total value to char
	}
}
