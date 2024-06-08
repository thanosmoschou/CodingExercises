/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: java file handling
 */

package ex6ch10JavaBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		File filename = new File("inputData.txt");
		TelephoneNumber[] table = new TelephoneNumber[30];
		
		if(filename.canRead())
		{
			Scanner file = null;
			
			try 
			{
				file = new Scanner(filename); 
				String data;
				int ctr = 0;
				
				//traverse the file make sure the table is not full
				while(file.hasNextLine() && ctr < table.length)
				{
					try
					{
						data = file.nextLine();
						
						//try to create object with the given number
						TelephoneNumber t1 = new TelephoneNumber(data);
						System.out.println("Number: " + t1.toString()); //or t1...everytime toString is called by default
								
						String decision;
						Scanner in = new Scanner(System.in);
						
						//PLEASE NOTE:
						//ask to insert the object to the table if the table is not full...there is a problem
						//when i delete things i do not decrease ctr...i do not do it because i leave empty
						//spaces between numbers so it is pointless...i have to search to the first empty space
						//to put the number...i should use data structures instead
						if(ctr < table.length)
						{
							System.out.println("Add this number to the table Y/N? ");
							decision = in.nextLine();
							
							if(decision.equalsIgnoreCase("Y"))
							{
								table[ctr] = t1;
								ctr++;	
							}
						}
						
						
						//ask if he wants to delete a number from the table
						System.out.println("Delete a number from the table Y/N? ");
						decision = in.nextLine();
						
						if(decision.equalsIgnoreCase("Y"))
						{
							int place;
							
							//validity check
							while(true)
							{
								System.out.println("Please enter the place(for example if you want the 1st number to be deleted enter 1): ");
								place = in.nextInt();
								
								if(place > table.length || place <= 0)
									System.out.println("This index is out of table range...enter index again.");
								else
									break;		
							}
							
							place--;
							
							if(table[place] != null)
							{
								System.out.println("Successful delete of " + table[place]);
								table[place] = null;
							}
							else
								System.out.println("Invalid place...this place does not contain any number");
							
							//PLEASE NOTE:
							//note at this point that when i put null in a position(that means i delete a number from
							//the table) i should decrease the ctr. But i leave empty spaces between numbers. I do not want to make
							//things more complicated...i could use data structures to fix that
						}
						
					}
					catch(InvalidFormatException e)
					{
						System.out.println(e.getMessage());
					}
				}
				
				//it maybe not because i left empty spaces between numbers. I could use ArrayList to not have spaces between
				if(ctr >= table.length)
					System.out.println("Table is full");
				
				
				//Create a new file to write all the edited data
				String write = "Output.txt";
				PrintWriter writeFile = null;
				
				try
				{
					writeFile = new PrintWriter(write);
					
					System.out.println("Elements of the table are: ");
					for(TelephoneNumber t : table)
					{
						if(t != null)
						{
							System.out.println(t);
							writeFile.println(t.toString());
						}
					}
					
					System.out.println("Successful writing to file " + write);
					
				}
				catch(FileNotFoundException e)
				{
					System.out.println("Problem while creating file" + write);
				}
				
				if(writeFile != null)
					writeFile.close();
				
			} 
			catch (FileNotFoundException e1) 
			{
				System.out.println("Problem with file " + filename.getName());
			}
			
			if(file != null)
				file.close();
		}
		else
			System.out.println("You cannot read file " + filename.getName());			
	}

}
