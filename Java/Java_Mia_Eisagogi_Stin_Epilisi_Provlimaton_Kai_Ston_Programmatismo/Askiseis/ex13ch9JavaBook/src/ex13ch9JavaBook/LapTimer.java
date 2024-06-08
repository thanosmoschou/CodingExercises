/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: exception exercises
 */

package ex13ch9JavaBook;

import java.util.Calendar;

public class LapTimer 
{
	private boolean running;
	private long startTime;
	private long lapStart;
	private long totalTime;
	private int lapsCompleted;
	private int lapsInRace;
	
	
	public LapTimer(int someLaps)
	{
		this.lapsInRace = someLaps;
		this.lapStart = 0;
		this.running = false;
		this.lapsCompleted = 0;
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
