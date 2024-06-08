/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: file handling exercises with java
 */

package ex13ch10JavaBook;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class StoreSignal 
{

	public static void main(String[] args) 
	{
		String inputFileName = "input.txt";
		String outputFileName = "output.dat";
		
		Scanner reader = null;
		File input = new File(inputFileName);
		
		if(input.canRead())
		{
			try
			{
				reader = new Scanner(input);	
				ObjectOutputStream writer = null;
				
				try
				{
					writer = new ObjectOutputStream(new FileOutputStream(outputFileName));
					
					int value, difference, temp;
					
					temp = reader.nextInt();
					difference = temp;	
					
					while(reader.hasNextInt())
					{
						value = reader.nextInt();
						
						if(value < 0)
							break;
						else
						{
							difference = (temp - value);
							writer.writeInt(difference);
							temp = value;
						}
					}
					
					System.out.println("Successful write in file: " + outputFileName);
					writer.close();
					
					//only to check the output on the file					
					try
					{
						ObjectInputStream read = new ObjectInputStream(new FileInputStream("output.dat"));
						
						try
						{
							while(true)
							{
								System.out.println(read.readInt());
							}
							
						}
						catch(EOFException e)
						{
							System.out.println(e.getMessage());
						}
						
						read.close();
					}
					catch(FileNotFoundException e)
					{
						System.out.println(e.getMessage());
					}
					catch(IOException e)
					{
						System.out.println(e.getMessage());
					}
					
				}
				catch(FileNotFoundException e)
				{
					System.out.println(e.getMessage());
				}
				catch(IOException e)
				{
					System.out.println(e.getMessage());
				}
			}
			catch(FileNotFoundException e)
			{
				System.out.println(e.getMessage());
				System.exit(1);
			}
			
			reader.close();	
		}
	}
}
