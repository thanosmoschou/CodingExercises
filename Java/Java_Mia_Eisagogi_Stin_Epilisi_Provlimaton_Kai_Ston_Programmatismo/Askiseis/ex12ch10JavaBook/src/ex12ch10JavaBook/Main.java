/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: binary file handling exercises with java
 */

package ex12ch10JavaBook;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class Main 
{

	public static void main(String[] args) 
	{
		/*
		 * The exercise assumes that i read from a binary file first. So i have to create it. We
		 * read either int or double values, but we don't know the sequence of those values.
		 * At the beginning of the file it has a string in UTF format that is something like the following
		 * "iidd" that means i have to read 4 values 2 integers and then two doubles. I take the sequence 
		 * from the string. Let's create the binary first and then read the input from it. After taking
		 * the input from the binary we create a text file where we add the numbers one in each line
		 */

		String inputFileName = "input.dat";
		ObjectOutputStream writer = null;
		String pattern = "ididdi";
		
		try
		{
			writer = new ObjectOutputStream(new FileOutputStream(inputFileName));
			
			Random rand = new Random();
			
			//write the pattern string first
			writer.writeUTF(pattern);
			
			for(int i = 0; i < pattern.length(); i++)
			{
				if(pattern.charAt(i) == 'i')
					writer.writeInt(rand.nextInt());
				else
					writer.writeDouble(rand.nextDouble());
			}
			
			System.out.println("Successful write to the binary file: " + inputFileName);
			
			writer.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		
		//now let's read from the binary and create a text file simultaneously 
		ObjectInputStream reader = null;
		String outputFileName = "output.txt";
		
		try
		{
			reader = new ObjectInputStream(new FileInputStream(inputFileName));
			
			PrintWriter writerToTextFile = null;
			
			try
			{
				writerToTextFile = new PrintWriter(outputFileName);
			}
			catch(FileNotFoundException e)
			{
				System.out.println(e.getMessage());
				System.exit(1);
			}
			
			String takenPattern = reader.readUTF();
			
			for(int i = 0; i < takenPattern.length(); i++)
			{
				if(takenPattern.charAt(i) == 'i')
					writerToTextFile.println(reader.readInt());
				else
					writerToTextFile.println(reader.readDouble());	
			}
			
			System.out.println("Successful write to the text file: " + outputFileName);
			
			writerToTextFile.close();
			reader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		catch(EOFException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}		
	}
}