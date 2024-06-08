/*
 * Author: Thanos Moschou
 * Date: 12/2022
 * Description: exception exercises
 */

package ex5ch10JavaBook;

public class Main 
{

	public static void main(String[] args)
	{
		LapTimer l = new LapTimer(10, "Kostas", "fileTimes.txt");
		
		System.out.println("Laps remaining: " + l.getLapsRemaining());
		l.markLap();
		l.start();
		
		int ctr = 0;
		while(ctr < 10)
		{
			l.markLap();
			System.out.println("Laps remaining: " + l.getLapsRemaining());
			System.out.println("Last lap time: " + l.getLapTime());
			System.out.println("Total race time: " + l.getTotalTime());
			ctr++;
		}
		
		l.markLap();
		l.writeTotalTimeToFile("fileTimes.txt");
		
	}

}
