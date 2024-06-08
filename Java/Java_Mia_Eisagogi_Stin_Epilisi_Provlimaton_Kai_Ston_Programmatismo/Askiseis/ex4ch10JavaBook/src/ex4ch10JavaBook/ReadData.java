/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: files handling
 */

package ex4ch10JavaBook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadData 
{
	private PrintWriter file = null;
	private String filename = "data.txt";
	
	public void readDataFromUser()
	{
		boolean contin = true;
		Scanner in = new Scanner(System.in);
		String[] data;
		String decision;
		double cost = 0, totalCost = 0, price = 0;
		int amount = 0;
		
		try
		{
			file = new PrintWriter(new FileOutputStream(filename, true));
			System.out.println("For every product please enter the data with the following format:" + "\n" + "name price amount/n" 
			+ "for example: chocolates 1.8 5");
			
			//when a user only inserts a double value the compiler want , between numbers and not a .
			//Compiler accepts . only when we insert double values at coding time and not at running
			//At this point user inserts multiple values and i need to convert string values to numbers
			//As a result i want him to insert . and not , otherwise parse methods will throw an exception
			
			while(contin)
			{
				data = in.nextLine().split(" ");
				
				price = Double.parseDouble(data[1]);
				amount = Integer.parseInt(data[2]);
				cost = price * amount;
				totalCost += cost;
				
				//write user input to the file including cost and simultaneously print values to the console
				for(String s : data)
				{
					System.out.print(s + " ");
					file.print(s);
					file.print(" ");
				}
				
				System.out.println(cost);
				file.print("Total Cost: ");
				file.println(cost);
				
				System.out.println("Continue Y/N ? ");
				decision = in.nextLine();
				
				if(decision.equalsIgnoreCase("N"))
					contin = false;	
			}
			
			file.print("Total cost: ");
			file.println(totalCost);
			
			System.out.println("Total cost: " + totalCost);	
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem with file.");
			System.exit(1);
		}
		
		file.close();
	}
}
