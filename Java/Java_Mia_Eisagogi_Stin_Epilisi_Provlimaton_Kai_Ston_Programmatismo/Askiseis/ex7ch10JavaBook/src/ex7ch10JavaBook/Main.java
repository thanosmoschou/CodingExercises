/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: file handling in java
 */

package ex7ch10JavaBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		String text = "input.txt";
		File filename = new File(text);
		Scanner file = null;
		ArrayList<ContactInfo> people = new ArrayList<>();
		
		if(filename.canRead())
		{
			try
			{
				file = new Scanner(filename);
				
				ContactInfo person = null;
				String data;
				
				while(file.hasNextLine())
				{
					try
					{	
						data = file.nextLine();
						person = new ContactInfo(data);
						System.out.println("-------\n" + person.toString());
						people.add(person); //person.addThisPersonToArrayList(people);
					}
					catch(InvalidFormatException e)
					{
						System.out.println(e.getMessage());
					}
				}
				
				System.out.println("File does not contain any more data...\n");
				
				boolean stop = false;
				while(true)
				{
					int selection;
					Scanner in = new Scanner(System.in);
					
					System.out.println("Please select one of the following:");
					System.out.println("1. Add a person to the arraylist");
					System.out.println("2. Remove a person from the arraylist");
					System.out.println("3. Change a person\'s data");
					System.out.println("4. Print people\'s data");
					System.out.println("5. Exit");
					
					//validity check
					while(true)
					{
						selection = in.nextInt();
						
						if(selection < 1 || selection > 5)
							System.out.println("Invalid Data");
						else
							break;
					}
					
					in.nextLine(); //clear the stream
					
					String newPersonData = null;
					
					switch(selection)
					{
						case 1:	
							//assume that user gives correct format
							ContactInfo newPerson = null;
			
							System.out.println("Enter data: ");
							newPersonData = in.nextLine();
							
							try
							{
								newPerson = new ContactInfo(newPersonData);
								System.out.println("-------\n" + person.toString());
								newPerson.addThisPersonToArrayList(people);
							}
							catch(InvalidFormatException e)
							{
								System.out.println(e.getMessage());
							}
							
							break;
						case 2:
							System.out.println("Enter person\'s name you want to delete: ");
							newPersonData = in.nextLine();
							
							ContactInfo.removeThisPersonToArrayList(people, newPersonData);
							break;
						case 3:
							//change with set anything.
							System.out.println("Enter the name of the person you want to change his credentials: ");
							newPersonData = in.nextLine();
							
							ContactInfo.changeInfo(newPersonData, people);							
							break;
						case 4:
							for(ContactInfo c : people)
								System.out.println(c.toString());
							break;
						default:
							
							PrintWriter writeData = null;
							
							try
							{
								writeData = new PrintWriter("Output.txt");
								
								for(ContactInfo c : people)
									writeData.println(c.toString());
								
								System.out.println("File is written successfully");
								
							}
							catch(FileNotFoundException e)
							{
								System.out.println(e.getMessage());
							}
							
							if(writeData != null)
								writeData.close();
							
							stop = true;
					}
					
					//exit the while
					if(stop)
						break;
				}	
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Problem with file: " + filename.getName());
			}
			
		}
		else
			System.out.println("You cannot read file: " + filename.getName());
		
		
		if(file != null)
			file.close();

	}

}
