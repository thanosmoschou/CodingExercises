/*
 * Author: Thanos Moschou
 * Date: 11/2022
 * Description: check time validity
 */


package ex2ch6JavaBook;

public class Main 
{

	public static void main(String[] args) 
	{
		Time myTime = new Time();
		boolean isAm = true;
		
		System.out.println("Hour: " + myTime.getHour() + " Minutes: " + myTime.getMinutes());
		myTime.setTime(13, 0);
		System.out.println("Hour: " + myTime.getHour() + " Minutes: " + myTime.getMinutes());
		myTime.setTime(24, 0);
		myTime.setTime(1, 60);
		myTime.setTime(-1, 0);
		myTime.setTime(23, -1);
		myTime.setTime(12, 10, isAm);
		System.out.println("Hour: " + myTime.getHour() + " Minutes: " + myTime.getMinutes());
		myTime.setTime(13, 0, isAm);
		myTime.setTime(1, 60, isAm);
		isAm = false;
		myTime.setTime(12, 10, isAm);
		System.out.println("Hour: " + myTime.getHour() + " Minutes: " + myTime.getMinutes());
		
		
	}

}
