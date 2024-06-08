/*
Author: Thanos Moschou
Date: 10/2022
Description: Java exercises
*/

package ex5ch1Java;

import java.util.Scanner;

public class Employee 
{
	private int hoursOfWork;
	private long payForHour;
	private double insurance, fullProfit, kratiseis, cleanProfit;
	
	public Employee()
	{
		hoursOfWork = 0;
		payForHour = 0;
		insurance = 0;
		fullProfit = 0;
		kratiseis = 0;
		cleanProfit = 0;
	}
	
	public void readData()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Dwse tis ores ergasias sou: ");
		hoursOfWork = keyboard.nextInt();
		
		System.out.println("Dwse to oromisthio sou: ");
		payForHour = keyboard.nextLong();
		
		System.out.println("Dwse to pososto ton kratiseon sou: ");
		insurance = keyboard.nextDouble();
	}
	
	public void calculate()
	{
		cleanProfit = hoursOfWork * payForHour;
		kratiseis = cleanProfit * insurance;
		fullProfit = cleanProfit + kratiseis;
	}
	
	public void printData()
	{
		System.out.println("Akatharistes apodoxes: " + fullProfit);
		System.out.println("Krathseis: " + kratiseis);
		System.out.println("Kathares apodoxes: " + cleanProfit);
	}
	
	//getters
	public int getHoursOfWork()
	{
		return hoursOfWork;
	}
	
	public long getPayForHour()
	{
		return payForHour;
	}
	
	//Code all the getters...
	//Code the setters if you want
}
