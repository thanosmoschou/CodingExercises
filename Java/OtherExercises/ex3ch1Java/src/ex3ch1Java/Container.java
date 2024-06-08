/*
Author: Thanos Moschou
Date: 10/2022
Description: Java exercises
*/

package ex3ch1Java;

import java.util.Scanner;

public class Container
{
	private int box1;
	private int box5;
	private int box20;
	private int box50;
	private int totalDevices;
	
	public Container()
	{
		box1 = 0;
		box5 = 0;
		box20 = 0;
		box50 = 0;
	}
	
	public void read()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter the total amount of devices: ");
		totalDevices = keyboard.nextInt();
	}
	
	public void findContainers()
	{
	    int temp;
		
		box50 = totalDevices / 50;
		temp = totalDevices % 50;
		box20 = temp / 20;
		temp %= 20;
		box5 = temp / 5;
		box1 = temp % 5;
	}
	
	public void showData()
	{
		System.out.println("Total boxes for " + totalDevices + "are: ");
		System.out.println("Box of 50: " + box50);
		System.out.println("Box of 20: " + box20);
		System.out.println("Box of 5: " + box5);
		System.out.println("Box of 1: " + box1);
	}
	
	public void setNewNumberOfDevices(int newNum)
	{
		totalDevices = newNum;
	}
	
	public int getDevices()
	{
		return totalDevices;
	}
	
	public int getBox1()
	{
		return box1;
	}
	
	public int getBox5()
	{
		return box5;
	}
	
	public int getBox20()
	{
		return box20;
	}
	
	public int getBox50()
	{
		return box50;
	}
}
