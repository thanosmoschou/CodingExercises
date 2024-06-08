/*
Author: Thanos Moschou
Date: 10/2022
Description: Java exercises
*/

package ex5ch1Java;

public class Main
{
	public static void main(String[] args)
	{
		Employee thanos = new Employee();
		
		thanos.readData();
		thanos.calculate();
		thanos.printData();
		System.out.println("Oromisthio: " + thanos.getPayForHour());
	}
}
