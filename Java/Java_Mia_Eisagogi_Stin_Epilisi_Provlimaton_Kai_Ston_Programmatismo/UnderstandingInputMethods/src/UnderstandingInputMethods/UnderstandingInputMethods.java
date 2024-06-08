/*
 * this is a test class to understand the java input
 */

package UnderstandingInputMethods;

import java.util.Scanner;

public class UnderstandingInputMethods {

	public static void main(String[] args) {
		String word;
		char cha;
		int i;
		double d;
		Scanner k = new Scanner(System.in);
		
		System.out.println("Enter an integer number: ");
		i = k.nextInt();
		System.out.println(i);
		
		//nextDouble does not care about previous \n characters in the stream or spaces, it wants to read a double value.
		//After reading a double value it leaves the \n or the space in the stream so i have to be careful after that.
		//If i read numbers like int double etc i do not have problem because nextInt, nextDouble do not care
		//about previous \n or spaces. But when i want to read a word or a whole line i have to be careful because
		//next will read a word until it will find a space but it will leave the space in the stream(or the \n). Note that
		//next does not care about previous spaces so i do not have any problem. This behavior is similar to nextInt.
		//But when i use nextLine i read the remaining input until i found \n. Note that it will consume the \n but
		//it will not include it to the string value
		
		System.out.println("Enter a decimal number: ");
		d = k.nextDouble();
		System.out.println(d);
		
		System.out.println("Enter a word: ");
		word = k.next();
		System.out.println(word);
		
		//now because there is a \n char from the previous word input this will not read anything...but if previously i added a nextLine
		//it would consume the \n and i would be able to read a new word
		System.out.println("Enter a word: ");
		word = k.nextLine();
		System.out.println(word);
		
		System.out.println("Enter a word: ");
		word = k.next();
		System.out.println(word);
		
		System.out.println("Enter a word: ");
		word = k.next();
		System.out.println(word);
		
		System.out.println("Enter a char:");
		cha = k.next().charAt(0); //this return a word and charAt returns the character at a certain position
		System.out.println(cha);

	}

}
