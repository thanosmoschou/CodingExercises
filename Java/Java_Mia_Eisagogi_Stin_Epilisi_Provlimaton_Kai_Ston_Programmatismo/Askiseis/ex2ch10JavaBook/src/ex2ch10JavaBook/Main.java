/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: file handling with java
 */

package ex2ch10JavaBook;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		PrintWriter file = null;
		String[] words = "Gettysburg Address".split(" ");
		String title;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter the name of the file you wanna write.");
		title = keyboard.nextLine();
		
		try
		{
			file = new PrintWriter(title);
			for(String s : words)
			{
				file.println(s);
			}
			
			System.out.println("File is written successfully."); //inform the user that writing is over...do not be a silent program
		}
		catch(FileNotFoundException e) 
		{
			//this exception works only if there is a folder with the same name so the file cannot
			//be created...otherwise if there is not a file already or a folder with the same name
			//it will be created with the given name in the try block
			System.out.println("This file does not exist.");
			System.exit(1);
		}
		
		file.close();
	}
}
