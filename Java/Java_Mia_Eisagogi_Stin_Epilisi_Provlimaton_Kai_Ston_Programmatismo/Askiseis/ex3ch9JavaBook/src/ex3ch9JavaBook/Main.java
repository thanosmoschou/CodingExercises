/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: Understanding exceptions in java
 */

//problem while reading...check it
package ex3ch9JavaBook;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int hour, minutes;
		String dayTime; //am or pm
		//String format;
		
		try
		{
			System.out.println("Please enter an hour with the following format: hour : min pm or am (for example 12:23 pm ");
			
			hour = in.nextInt();
			in.next().charAt(0); //take the : next reads a word until a space is found but does not read the space...this happens also for spaces before the word or after it
			minutes = in.nextInt();
			dayTime = in.nextLine().strip(); //strip removes spaces before and after the word
			
			if(dayTime.equalsIgnoreCase("pm"))
			{
				if(hour < 12 || hour > 23)
					throw new InvalidHourException("Invalid hour for pm...Only hours within range 12-23 are accepted");
			}
			else if(dayTime.equalsIgnoreCase("am"))
			{
				if(hour < 0 || hour > 12)
					throw new InvalidHourException("Invalid hour for am...Only hours within range 0-12 are accepted");	
			}
			else if(!dayTime.equalsIgnoreCase("pm") && !dayTime.equalsIgnoreCase("am")) //we do not have neither pm nor am
				throw new InvalidAmOrPmTimeFormatException("Invalid time format...only pm or am are accepted");
			
			if(minutes < 0 || minutes > 59)
				throw new InvalidMinuteException("Invalid minute data...only range 0-59 is accepted.");	
			
			System.out.println("This time data is valid!"); //we will go to that point only if there is no exception
		}
		catch(InvalidMinuteException e)
		{
			System.out.println(e.getMessage());
		}
		catch(InvalidAmOrPmTimeFormatException e)
		{
			System.out.println(e.getMessage());
		}
		catch(InvalidHourException e)
		{
			System.out.println(e.getMessage());
		}

	}

}
