/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: java file exercises
 */

package ex10ch10JavaBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * USEFUL TIP: While it is not wrong to have nested try catch blocks it is not a good solution because
 * that makes the code difficult to debug. Make simpler code by adding try catch one after the other.
 */

public class Main 
{
	public static void main(String[] args)
	{
		String nameOfTheInputFile = "input.txt";
		String nameOfTheOutputFile = "output.txt";
		
		File inputFile = new File(nameOfTheInputFile);
		
		if(inputFile.canRead())
		{
			Scanner readFile = null;
			String inputData = "";
			
			try
			{
				readFile = new Scanner(inputFile);
				
				while(readFile.hasNextLine())
				{
					inputData += (readFile.nextLine() + "\n");
				}
				
				System.out.println("Successful input from file " + nameOfTheInputFile);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File: " + nameOfTheInputFile + " is missing.");
				System.exit(1);
			}
			
			readFile.close();

			File outputFile = new File(nameOfTheOutputFile);
			
			if(outputFile.exists())
			{
				System.out.println("File: " + nameOfTheOutputFile + " already exists");
				System.out.println("Available Options: ");
				System.out.println("1. Overwrite this file");
				System.out.println("2. Create a new file");
				System.out.println("3. Terminate the program");
				
				Scanner in = new Scanner(System.in);
				int decision;
				
				//validity check
				do
				{
					System.out.println("Enter your decision: ");
					decision = in.nextInt();
					
					if(decision != 1 && decision != 2 && decision != 3)
						System.out.println("Invalid selection.");
					in.nextLine();
					
				}
				while(decision != 1 && decision != 2 && decision != 3);
				
				if(decision == 1)
				{
					PrintWriter writer = null;
					
					try
					{
						writer = new PrintWriter(nameOfTheOutputFile);
						
						writer.print(inputData);
						System.out.println("Successful overwrite to the file " + nameOfTheOutputFile);
						
					}
					catch(FileNotFoundException e)
					{
						System.out.println("Problem with file: " + nameOfTheOutputFile);
						System.exit(1);
					}
					
					writer.close();
					
				}
				else if(decision == 2)
				{
					String otherFileName;
					PrintWriter writer = null;
					
					System.out.println("Please enter the name of the new file: ");
					otherFileName = in.nextLine();
					
					try
					{
						writer = new PrintWriter(otherFileName);
						
						writer.print(inputData);
						System.out.println("Successful write to file " + otherFileName);
						
					}
					catch(FileNotFoundException e)
					{
						System.out.println("Problem with file: " + otherFileName);
						System.exit(1);
					}
					
					writer.close();
					
				}
				else
				{
					System.out.println("The program will be terminated");
					System.exit(0);
				}
			}
			else
			{
				System.out.println("File " + outputFile + " not exists.");
				System.exit(0);
			}
			
		}
		else
		{
			System.out.println("File: " + nameOfTheInputFile + " cannnot be read.");
			System.exit(1);
		}
		
	}
}
