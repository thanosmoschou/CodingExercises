/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: exception exercises
 */

package ex5ch10JavaBook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;

public class LapTimer 
{
	private boolean running;
	private long startTime;
	private long lapStart;
	private long totalTime;
	private int lapsCompleted;
	private int lapsInRace;
	private String name;
	
	private PrintWriter file = null;
	
	public LapTimer(int someLaps, String aPerson, String aFilename)
	{
		this.lapsInRace = someLaps;
		this.lapStart = 0;
		this.running = false;
		this.lapsCompleted = 0;
		this.name = aPerson;
		
		try
		{
			this.file = new PrintWriter(new FileOutputStream(aFilename, true));
			this.file.print("Name: ");
			this.file.println(aPerson);
			
			System.out.println("Name is written successfully");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("This file cannot be opened.");
			System.exit(1);
		}
		
		file.close();
	}
	
	
	public void start()
	{
		try
		{
			if(!running)
			{
				running = true;
				startTime = Calendar.getInstance().getTimeInMillis();	
				lapStart = startTime;
			}
			else
				throw new AlreadyStartedException();
		}
		catch(AlreadyStartedException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	public void markLap()
	{
		long tempLap = lapStart; //current value of lapStart so the beginning time of this lap
		
		try
		{
			if(!running)
				throw new FirstLapNotCompletedException();
			
			lapsCompleted++;
			lapStart = Calendar.getInstance().getTimeInMillis(); //the end of the lap
			totalTime += (lapStart - tempLap);
			
			if(lapsCompleted == lapsInRace)
				throw new EndOfTheRaceException();
					
		}
		catch(FirstLapNotCompletedException e)
		{
			System.out.println(e.getMessage());
		}
		catch(EndOfTheRaceException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	public void writeTotalTimeToFile(String aFilename)
	{
		double total = getTotalTime();
		
		//i connected this file to a stream in the constructor but i closed the stream so i have to create a new one
		try
		{
			this.file = new PrintWriter(new FileOutputStream(aFilename, true));
			this.file.print("Time: ");
			this.file.println(total);
			
			System.out.println("Total time is written successfully.");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem with file.");
			System.exit(1);
		}
		
		file.close();
		
	}
	
	public long getLapTime()
	{
		try
		{
			if(startTime == lapStart) //the 1st lap is in progress
				throw new FirstLapNotCompletedException();			
		}
		catch(FirstLapNotCompletedException e)
		{
			System.out.println(e.getMessage());
		}
		
		return lapStart;
	}
	
	
	public long getTotalTime()
	{
		try
		{
			if(totalTime == 0)
				throw new FirstLapNotCompletedException();
		}
		catch(FirstLapNotCompletedException e)
		{
			System.out.println(e.getMessage());
		}
		
		return totalTime;
	}
	
	
	public int getLapsRemaining()
	{
		return lapsInRace - lapsCompleted;
	}
}
