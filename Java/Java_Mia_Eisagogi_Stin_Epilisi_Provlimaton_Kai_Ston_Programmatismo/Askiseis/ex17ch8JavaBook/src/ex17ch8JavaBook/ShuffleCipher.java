/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: inheritance exercises
 */

package ex17ch8JavaBook;

public class ShuffleCipher implements MessageEncoder
{
	private int mixTimes;
	
	public ShuffleCipher(int n)
	{
		this.mixTimes = n;
	}
	
	
	public String encode(String plainText)
	{
		//for the mix we split the text to the middle and then we take alternative a letter from each part
		String encrypted = "";
		String tempText = plainText;
		
		//we mix the word many times. We split and then we split again the already split word and so on
		for(int i = 0; i < mixTimes; i++)
		{	
			encrypted = "";
			//split the word to 2 pieces
			String first = tempText.substring(0, tempText.length() / 2 + 1); //this will return the substring from position 0 to length/2
			String second = tempText.substring(tempText.length() / 2 + 1); //this is the remaining string
			
			System.out.println("First part: " + first + "\n" + "Second part: " + second);
			
			//take letters from the separated words...i will take alternative one from each word every time
			int ctr = 0;
			
			//this is the mix procedure
			while(true)
			{
				if(ctr >= first.length() && ctr >= second.length()) //we do not have other letters to put to the word
					break;
				
				if(ctr < first.length()) //the first word is still available with letters remaining
					encrypted += first.charAt(ctr);
				
				if(ctr < second.length())
					encrypted += second.charAt(ctr);
				
				ctr++;
			}
			
			System.out.println("Mixed word try no" + (i + 1) + ": " + encrypted);
			tempText = encrypted; //pass the encrypted word to tempText in order to split it again
		}
		
		return encrypted;
	}
	
	
	
}
