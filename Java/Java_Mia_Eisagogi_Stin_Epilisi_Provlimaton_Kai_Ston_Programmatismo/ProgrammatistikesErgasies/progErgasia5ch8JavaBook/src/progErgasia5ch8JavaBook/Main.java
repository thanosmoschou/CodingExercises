/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: inheritance
 */


package progErgasia5ch8JavaBook;

public class Main 
{

	public static void main(String[] args) 
	{
		SubstitutionCipher sub1 = new SubstitutionCipher(3);
		String enc, dec, text;
		
		text = "abc";
		enc = sub1.encode(text);
		dec = sub1.decode(enc);
		
		System.out.println("Text 1: " + text + "\nEncrypted: " + enc + "\nDecrypted: " + dec);
		
		ShuffleCipher shuf1 = new ShuffleCipher(2);
		
		text = "abcdefghi";
		enc = shuf1.encode(text);
		dec = shuf1.decode(enc);
		
		System.out.println("Text 2: " + text + "\nEncrypted: " + enc + "\nDecrypted: " + dec);
	}

}
