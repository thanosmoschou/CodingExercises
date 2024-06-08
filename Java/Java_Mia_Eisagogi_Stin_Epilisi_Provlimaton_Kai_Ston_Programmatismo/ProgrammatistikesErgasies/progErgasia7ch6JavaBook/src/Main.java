/*
 *Author: Thanos Moschou
 *Date: 11/2022
 *Description: temperature convertion 
 * 
 */


public class Main 
{

	public static void main(String[] args)
	{
		Temperature t1 = new Temperature();
		Temperature t2 = new Temperature('C');
		Temperature t3 = new Temperature(212);
		Temperature t4 = new Temperature(32, 'F');
		
		
		System.out.println("T1 temperature is celcius: " + t1.getCelcius());
		System.out.println("T1 temperature is farenheit: " + t1.getFarenheit());
		
		t1.setBothTemperatureAndMode(0, 'C');
		t2.setTemperature(-40);
		t2.setMode('C');
		t3.setMode('F');
		t4.setBothTemperatureAndMode(20, 'C');
		
		System.out.println("Are 0 degrees Celcius equal to 32 degrees Farenheit? " + t1.isEqual(32, 'F'));
		System.out.println(t2.getCelcius() + " " + t2.getFarenheit());
		System.out.println("Are -40 degrees Celcius equal to -40 degrees Farenheit? " + t2.isEqual(-40, 'F'));
		System.out.println("Are 100 degrees Celcius equal to 212 degrees Farenheit? " + t3.isEqual(100, 'C'));

		t3.setBothTemperatureAndMode(101, 'C');
		System.out.println("Are 101 degrees Celcius greater than 212 degrees Farenheit? " + t3.isGreaterThan(212, 'F'));
		
		t3.setTemperature(98);
		System.out.println("Are 98 degrees Celcius less than 212 degrees Farenheit? " + t3.isLessThan(98, 'F'));

	
	
	}

}
