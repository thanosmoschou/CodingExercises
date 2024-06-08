/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: inheritance exercises
 */


package ex17ch8JavaBook;

public class Main 
{

	public static void main(String[] args) 
	{
		ShuffleCipher t1 = new ShuffleCipher(2);
		String text = "abcdefghi";
		
		System.out.println("Original message: abcdefghi\nMixed Message: " + t1.encode(text));
	}

}
