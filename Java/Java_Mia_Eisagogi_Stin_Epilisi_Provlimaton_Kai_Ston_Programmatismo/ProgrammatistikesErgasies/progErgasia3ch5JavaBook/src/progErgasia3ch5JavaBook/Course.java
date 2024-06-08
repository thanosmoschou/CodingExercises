/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: we read grades and we make a diagram on the screen
 */

package progErgasia3ch5JavaBook;

import java.util.Scanner;

public class Course 
{
	public static final int DIMENSION = 5;
	
	private char[] myGradeScale = new char[DIMENSION];
	private int[] myTotalGrades = new int[DIMENSION];
	private int totalGrades;
	
	
	public Course()
	{
		for(int i = 0; i < DIMENSION; i++)
		{
			if(i < 4)
			{
				myGradeScale[i] = (char)((int)'A' + i);
			}
			else
				myGradeScale[i] = 'F';
			
			myTotalGrades[i] = 0;
		}
		
		totalGrades = 0;
	}
	
	
	public void readData()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the amount of every grade (Scale A,B,C,D,F): ");
		for(int i = 0; i < DIMENSION; i++)
		{
			System.out.print(myGradeScale[i] + ": ");
			myTotalGrades[i] = in.nextInt();
			totalGrades += myTotalGrades[i];
		}
	}
	
	
	public void setAmountViaGrade(char aGrade, int anAmount)
	{
		int oldTotal = 0; //save the previous amount of that grade in order to update the total grades value with the difference of new amount minus old amount
		
		switch(aGrade)
		{
			case 'A':
				oldTotal = myTotalGrades[0];
				myTotalGrades[0] = anAmount;
				break;
			case 'B':
				oldTotal = myTotalGrades[1];
				myTotalGrades[1] = anAmount;
				break;
			case 'C':
				oldTotal = myTotalGrades[2];
				myTotalGrades[2] = anAmount;
				break;
			case 'D':
				oldTotal = myTotalGrades[3];
				myTotalGrades[3] = anAmount;
				break;
			case 'F':
				oldTotal = myTotalGrades[4];
				myTotalGrades[4] = anAmount;
				break;
			default:
				System.out.println("Invalid grade...");
		}
		
		totalGrades += (Math.abs(anAmount - oldTotal));
	}
	
	
	public int getAmountOfStudentsWithThisGrade(char aGrade)
	{
		int totalAmount = 0;
		
		switch(aGrade)
		{
			case 'A':
				totalAmount = myTotalGrades[0];
				break;
			case 'B':
				totalAmount = myTotalGrades[1];
				break;
			case 'C':
				totalAmount = myTotalGrades[2];
				break;
			case 'D':
				totalAmount = myTotalGrades[3];
				break;
			case 'F':
				totalAmount = myTotalGrades[4];
				break;
			default:
				System.out.println("Invalid grade...");
		}
		
		return totalAmount;
	}
	
	
	public int getTotalStudents()
	{
		return totalGrades;
	}
	
	
	public void printDiagram()
	{
		int counter = 0;
		//print the 10 20 ... above the stars symbols...each star counts as 2% so every 5 stars it should be a number above them
		for(int i = 0; i <= 100; i+= 2)
		{
			if(i % 10 == 0)
				System.out.print(counter * 2);
			
			if(counter % 5 == 0)
				System.out.print("   ");
			
			counter++;
		}
		System.out.println("\n");
		
		for(int i = 0; i <= 50; i++)
			System.out.print('*');
		System.out.println("");
		
		counter = 0;
		for(int gr: myTotalGrades)
		{
			double percentage = (gr / (double) totalGrades) * 100; //find percentage of each grade
			int countStars = (int) Math.floor((percentage / 2)); //i know that each star counts as 2% so i divide my whole percentage with 2 and i find the stars to print
			
			System.out.print('*'); //0% has already a *
			for(int i = 1; i <= countStars; i++)
				System.out.print('*');
			System.out.println(" " + myGradeScale[counter]);
			
			counter++;
		}
		
	}
}
