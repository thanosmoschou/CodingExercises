/*
Author: Thanos Moschou
Date: 10/2022
Description: Java exercises
*/

package ex8ch2Java;

public class Main
{
	public static void main(String[] args)
	{
		Flight newFlight = new Flight();
		
		newFlight.readData();
		newFlight.findIfAcceptableTimeDifference();
		newFlight.printData();
	}
}
