/*
Author: Thanos Moschou
Date: 10/2022
Description: Java exercises
*/

package ex3ch1Java;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Container cont = new Container();
		
		cont.read();
		cont.findContainers();
		cont.showData();
		
		/*
		System.out.println("Total boxes for " + cont.getDevices() + "are: ");
		System.out.println("Box of 50: " + cont.getBox50());
		System.out.println("Box of 20: " + cont.getBox20());
		System.out.println("Box of 5: " + cont.getBox5());
		System.out.println("Box of 1: " + cont.getBox1());
		*/
		
		Scanner keyb = new Scanner(System.in);
		
		System.out.println("Please enter the new amount of devices: ");
		cont.setNewNumberOfDevices(keyb.nextInt());
		cont.findContainers();
		cont.showData();
		
		System.out.println("Test the getter\nBox of 20: " + cont.getBox20());
	}
}
