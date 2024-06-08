/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: Learning to handle exceptions
 */

package ex1ch9JavaBook;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		final int DIMENSIONS = 6;
		String[] availableTimes = new String[DIMENSIONS];
		int ctr = 0;
		Scanner keyboard = new Scanner(System.in);
		String selection;
		
		while(ctr < availableTimes.length)
		{
			try
			{
				System.out.println("Please enter a time within range 1 to 6 for your meeting: ");
				selection = keyboard.nextLine();	
				
				//put this check first because i do not want to have an out of range index to search in my table
				//i want to take an in range index and then search if the position is taken
				if(Integer.parseInt(selection) > 6 || Integer.parseInt(selection) < 1)
					throw new InvalidTimeException();
				
				//take the selection(assume it is a number but with string format) and because
				//this is in range 1-6 but my positions in the table start from 0 so 
				//for this 6 position table the indexes go from 0 to 5 i subtract 1 every time
				//if this position has a null value means that it is empty
				if(availableTimes[Integer.parseInt(selection) - 1] != null)
					throw new TimeInUseException();
				
				availableTimes[Integer.parseInt(selection) - 1] = selection;
				ctr++;
			}
			catch(TimeInUseException e)
			{
				System.out.println(e.getMessage());
			}
			catch(InvalidTimeException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
