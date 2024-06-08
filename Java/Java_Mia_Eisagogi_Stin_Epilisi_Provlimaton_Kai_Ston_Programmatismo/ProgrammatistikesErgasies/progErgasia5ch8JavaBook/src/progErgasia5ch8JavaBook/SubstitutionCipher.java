/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: Understanding interfaces
 * 
 */

package progErgasia5ch8JavaBook;

public class SubstitutionCipher implements MessageEncoder, MessageDecoder
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
			encrypted += convert(plainText.charAt(i), 0);
		}
		
		return encrypted;
	}
	
	
	public String decode(String cipherText)
	{
		String encrypted = "";
		
		for(int i = 0; i < cipherText.length(); i++)
		{
			encrypted += convert(cipherText.charAt(i), 1);
		}
		
		return encrypted;
	}
	
	
	private char convert(char aChar, int mode) //mode = 0 for encyption and 1 for decryption
	{
		if(aChar == ' ')
			return ' ';
		
		if(mode == 0)
			return (char) ((int) aChar + shift); //convert aChar to ascii value, then add the shift and finally convert the total value to char
		
		return (char) ((int) aChar - shift); //convert aChar to ascii value, then add the shift and finally convert the total value to char
	}
}


