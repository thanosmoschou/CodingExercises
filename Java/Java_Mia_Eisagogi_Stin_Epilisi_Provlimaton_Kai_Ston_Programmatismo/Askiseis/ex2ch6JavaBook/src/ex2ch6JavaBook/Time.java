/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: check time validity
 */

package ex2ch6JavaBook;

public class Time 
{

	private int hour;
	private int minutes;
	
	public Time()
	{
		hour = 0;
		minutes = 0;
	}
	
	
	private boolean isValid(int anHour, int someMinutes)
	{
		return (anHour >= 0 && anHour < 24) && (someMinutes >= 0 && someMinutes <= 59);
	}
	
	
	public void setTime(int anHour, int someMinutes)
	{
		if(isValid(anHour, someMinutes))
		{
			hour = anHour;
			minutes = someMinutes;
		}
		else
			System.out.println("Invalid data...");
	}
	
	
	public void setTime(int anHour, int someMinutes, boolean isAm)
	{
		if(anHour >= 1 && anHour <= 12 && someMinutes >= 0 && someMinutes <= 59)
		{
			minutes = someMinutes;
			if(isAm)
			{
				hour = anHour;
			}
			else //isAm is false which means that time is 24->00 
			{	
				if(hour == 12) 
					hour = 0;
				else
					hour = anHour + 12;
			}
		}
		else
			System.out.println("Hour must be in range 1-12");
	}
	
	
	public int getMinutes()
	{
		return minutes;
	}
	
	
	public int getHour()
	{
		return hour;
	}
}
