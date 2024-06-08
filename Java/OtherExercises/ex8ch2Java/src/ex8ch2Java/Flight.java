/*
Author: Thanos Moschou
Date: 10/2022
Description: Java exercises
*/

package ex8ch2Java;

import java.util.Scanner;

public class Flight
{
	private int demandTime, realTime, acceptableMinuteDifference, differenceOfInputValues;
	private String messageForAcceptableDemandTime;
	
	public Flight()
	{
		demandTime = 0;
		realTime = 0;
		acceptableMinuteDifference = 0;
		differenceOfInputValues = 0;
		messageForAcceptableDemandTime = "";
	}
	
	public void readData()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Dose ton provlepomeno xrono: ");
		demandTime = keyboard.nextInt();
		
		//debug
		String charac;
		charac = keyboard.nextLine();
		
		System.out.println(charac);
		
		System.out.println("Dose ton pragmatiko xrono: ");
		realTime = keyboard.nextInt();
	}

	public void findIfAcceptableTimeDifference()
	{
		if(demandTime < 30)
			acceptableMinuteDifference = 1;
		else if(demandTime < 60)
			acceptableMinuteDifference = 2;
		else if(demandTime < 90)
			acceptableMinuteDifference = 3;
		else if(demandTime < 120)
			acceptableMinuteDifference = 4;
		else if(demandTime < 180)
			acceptableMinuteDifference = 6;
		else if(demandTime < 240)
			acceptableMinuteDifference = 8;
		else if(demandTime < 360)
			acceptableMinuteDifference = 13;
		else
			acceptableMinuteDifference = 17;
		
		differenceOfInputValues = demandTime - realTime;
		
		if(Math.abs(differenceOfInputValues) <= acceptableMinuteDifference)
			messageForAcceptableDemandTime = "GOOD";
		else
		{
			if(demandTime < realTime)
				messageForAcceptableDemandTime = "SMALL";
			
			if(demandTime > realTime)
				messageForAcceptableDemandTime = "BIG";
		}
	}
	
	public void printData()
	{
		System.out.println("Apodekti diafora: " + acceptableMinuteDifference);
		System.out.println("Diafora eisodou: " + differenceOfInputValues);
		System.out.println(messageForAcceptableDemandTime);
	}

	//put setters and getters if you want...
}
