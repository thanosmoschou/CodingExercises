/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: file handling exercises with java
 */

package progEksask5ch10JavaBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		String fileName = "input.txt";
		File myFile = new File(fileName);
		
		if(myFile.canRead())
		{
			Scanner reader = null;
			
			try
			{
				reader = new Scanner(myFile);
				
				int maxValue = reader.nextInt();
				int current;
				
				while(reader.hasNextInt())
				{
					current = reader.nextInt();
					if(current > maxValue)
						maxValue = current;
				}
				
				System.out.println("Successful read of the file: " + fileName);
				System.out.println("Max value in this file: " + maxValue);
				
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
