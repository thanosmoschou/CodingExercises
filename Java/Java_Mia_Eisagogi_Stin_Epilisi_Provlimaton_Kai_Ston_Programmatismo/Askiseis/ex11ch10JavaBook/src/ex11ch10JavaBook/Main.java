/*
 * Author: Thanos Moschou
 * Date: 01/2023
 * Description: file handling exercises in java
 */

package ex11ch10JavaBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		String fileName = "input.txt";
		File myFile = new File(fileName);
		
		if(myFile.canRead())
		{
			Scanner in = null;
			ArrayList<String> input = new ArrayList<>();
			
			try
			{
				in = new Scanner(myFile);
				
				while(in.hasNext())
					input.add(in.next());
				
				System.out.println("Successful input from file: " + fileName);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("There is a problem with file: " + fileName);
				System.exit(1);
			}
			
			in.close();
			
			int ctr = 1;
			PrintWriter writer = null;
			String outputFileName = "output.txt";
			
			try
			{
				writer = new PrintWriter(outputFileName);
				
				for(String s : input)
				{
					if(ctr % 2 == 0)
						writer.println(s); //if the ctr is even i add the username and i go to the next line
					else
						writer.print(s + " "); //if the ctr is odd i have to put the name. Add a space also
					
					ctr++;
				}
				
				System.out.println("Successful write to file: " + outputFileName);
				
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Problem with file: " + outputFileName);
				System.exit(1);
			}
			
			writer.close();
			
		}

	}

}
