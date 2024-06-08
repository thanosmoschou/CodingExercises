/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: Understanding interfaces
 * 
 */


package ex16ch8JavaBook;

public class Main 
{

	public static void main(String[] args) 
	{
		SubstitutionCipher t = new SubstitutionCipher(4);
		String message = "abc";
		
		System.out.println("Normal message: " + message + "\n"
		+ "Encrypted message: " + t.encode(message));

	}

}
