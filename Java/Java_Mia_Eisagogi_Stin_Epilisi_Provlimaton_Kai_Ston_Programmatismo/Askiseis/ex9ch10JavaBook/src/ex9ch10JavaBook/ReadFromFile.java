/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: file handling with java
 */

/*
 * USEFUL NOTE
 * 
 * In previous programs of chapter 10 you made the following implementation
 * 
 * try
 * {
 * 		open the stream
 * 		write the code of the program
 * }
 * catch
 * {
 * 		handle the exceptions
 * }
 * 
 * file.close()
 * 
 * ------------------------------------------
 * The previous implementation IS NOT wrong. But you should try in the next exercises to do the following
 * just to be as similar as the implementation of the book. In the try block we should write the code that 
 * throws an exception and after the try catch block we should write the remaining code just to make the
 * try catch block simpler. Try to not have nested try catch blocks because this makes the code harder to understand
 * 
 * try
 * {
 *		open the stream
 * }
 * catch
 * {
 * 		handle the exception
 * }
 * 
 * write all the code for the program
 * file.close
 */


package ex9ch10JavaBook;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromFile 
{
	public static void main(String[] args)
	{
		String text = "input.txt";
		File fileName = new File(text);
		Scanner file = null;
		ArrayList<String> dataFromText = new ArrayList<String>(); //store the data after deleting the first word of every line
		
		if(fileName.canRead())
		{
			try
			{
				file = new Scanner(fileName);
				String line, convertedLine;
				String[] words;
				
				while(file.hasNextLine())
				{
					convertedLine = "";
					line = file.nextLine();
					words = line.split(" ");
					
					//delete the first word of every line
					for(int i = 1; i < words.length; i++)
						convertedLine = convertedLine + " " + words[i];
					
					dataFromText.add(convertedLine); 
				}
				
				System.out.println("File is read successfully");
				
				//File newFile = new File("output.txt");
				ObjectOutputStream output = null;
				
				try
				{
					output = new ObjectOutputStream(new FileOutputStream("output.dat"));
					
					for(String s : dataFromText)
						output.writeUTF(s);
					
					System.out.println("File is written successfully");
					
					output.close();
					
					ObjectInputStream inputFromBinary = null;
					
					try
					{
						inputFromBinary = new ObjectInputStream(new FileInputStream("output.dat"));
						
						while(true)
							System.out.println(inputFromBinary.readUTF());				
					}
					catch(EOFException e)
					{
						
					}
					catch(IOException e)
					{
						System.out.println("Error");
					}
					
					inputFromBinary.close();
					
				}
				catch(FileNotFoundException e)
				{
					System.out.println("Problem with the new file");
				}
				catch(IOException e)
				{
					System.out.println("Problem with input/output of this file");
				}
				
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Problem with this file.");
			}
		}
	}
}
