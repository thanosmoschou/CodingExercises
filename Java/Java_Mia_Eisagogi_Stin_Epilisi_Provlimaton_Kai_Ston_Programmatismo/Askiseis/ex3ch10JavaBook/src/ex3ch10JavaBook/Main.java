/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: file handling with java
 */

package ex3ch10JavaBook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		String decision;
		
		//assume that user only gives the words: new or append
		System.out.println("Please decide new/append: ");
		decision = keyboard.nextLine();
		
		writeToTheFile(decision);
	}
	
	
	public static void writeToTheFile(String decision)
	{
		PrintWriter name = null;
		Scanner keyboard = new Scanner(System.in);
		String filename;
		
		if(decision.equalsIgnoreCase("new"))
		{
			filename = "newFile.txt";
			
			try
			{
				name = new PrintWriter(filename);
				
				System.out.println("Enter anything you want to put inside file " + filename + ": ");
				String[] words = keyboard.nextLine().split(" ");
				
				for(String s : words)
				{
					name.println(s);
				}
				
				System.out.println("File is written successfully");
			}
			catch(FileNotFoundException e)
			{
				System.out.println("The file " + filename + "cannot be created.");
				System.exit(1);
			}
		}
		else if(decision.equalsIgnoreCase("append"))
		{
			filename = "appendFile.txt";
			
			try
			{
				name = new PrintWriter(new FileOutputStream(filename, true)); //append to the file...use the FileOutputStream when you have binary data.
				
				System.out.println("Enter anything you want to put inside file " + filename + ": ");
				String[] words = keyboard.nextLine().split(" ");
				
				for(String s : words)
				{
					name.println(s);
				}
				
				System.out.println("File is written successfully");
			}
			catch(FileNotFoundException e)
			{
				System.out.println("The file " + filename + "cannot be created.");
				System.exit(1);

			}
		}
		else
		{
			System.out.println("Invalid word");
			System.exit(1);
		}
		
		
		name.close();
	}

}
