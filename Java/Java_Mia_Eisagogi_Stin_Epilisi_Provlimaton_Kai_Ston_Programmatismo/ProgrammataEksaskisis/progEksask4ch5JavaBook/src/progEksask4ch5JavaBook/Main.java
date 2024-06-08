/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: simulate a rating engine for movies
 */

package progEksask4ch5JavaBook;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Trivia question1 = new Trivia("What is the capital of Greece? ", "Athens");
		Trivia question2 = new Trivia("What color is the sky? ", "Blue");
		Scanner in = new Scanner(System.in);
		
		System.out.print(question1.getQuestion());
		if(question1.checkIfIsCorrect(in.nextLine()))
			System.out.println("Correct!");
		else
			System.out.println("Not correct...\nThe answer was: " + question1.getCorrectAnswer());
		
		System.out.print(question2.getQuestion());
		if(question2.checkIfIsCorrect(in.nextLine()))
			System.out.println("Correct!");
		else
			System.out.println("Not correct...\nThe answer was: " + question2.getCorrectAnswer());
		
		question2.setQuestion("How many sides does a square have? ", "4");
		System.out.print(question2.getQuestion());
		if(question2.checkIfIsCorrect(in.nextLine()))
			System.out.println("Correct!");
		else
			System.out.println("Not correct...\nThe answer was: " + question2.getCorrectAnswer());
		
	}

}
