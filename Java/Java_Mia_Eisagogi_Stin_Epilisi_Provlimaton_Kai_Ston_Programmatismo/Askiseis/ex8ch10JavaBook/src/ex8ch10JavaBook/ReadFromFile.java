/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: file handling with java
 */

package ex8ch10JavaBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
				PrintWriter output = null;
				
				try
				{
					output = new PrintWriter("output.txt");
					
					for(String s : dataFromText)
						output.println(s);
					
					System.out.println("File is written successfully");
					
				}
				catch(FileNotFoundException e)
				{
					System.out.println("Problem with the new file");
				}
				
				if(output != null)
					output.close();
				
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Problem with this file.");
			}
		}
	}
}
