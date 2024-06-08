/*
 *Author: Thanos Moschou
 *Date: 11/2022
 *Description: temperature convertion 
 * 
 */


public class Temperature
{
	private double myTemperature;
	private char mode;
	
	public Temperature()
	{
		myTemperature = 0; //start with celcius
		mode = 'C';
	}
	
	
	public Temperature(double aTemperature)
	{
		myTemperature = aTemperature;
		mode = 'C';
	}
	
	
	public Temperature(char aMode)
	{
		myTemperature = 0;
		mode = aMode;
	}
	
	
	public Temperature(double aTemperature, char aMode)
	{
		myTemperature = aTemperature;
		mode = aMode;
	}
	
	
	public double getCelcius()
	{
		if(mode == 'C')
			return myTemperature;
		else
			return 5 * (myTemperature - 32) / 9; //myTemperature is on Farenheit
	}
	
	
	public double getFarenheit()
	{
		if(mode == 'F')
			return myTemperature;
		else
			return 9 * (myTemperature / 5) + 32; //myTemperature is on Farenheit
	}
	
	
	public void setTemperature(double aTemperature)
	{
		myTemperature = aTemperature;
	}
	
	
	public void setMode(char aMode)
	{
		if(aMode == 'C' || aMode == 'F')
			mode = aMode;
		else
			System.out.println("Invalid mode");
	}
	
	
	public void setBothTemperatureAndMode(double aTemperature, char aMode)
	{
		
		if(aMode == 'C' || aMode == 'F')
		{
			myTemperature = aTemperature;
			mode = aMode;
		}
		else
			System.out.println("Invalid mode");
	}
	
	
	//in order to make the compare aMode must be opposite of mode...for example
	//if mode equals to C aMode must be equal to F or the opposite one
	
	public boolean isEqual(double aTemperature, char aMode)
	{
		double temp;
		
		if(aMode != mode)
		{
			if(mode == 'C') //aTemperature is on Farenheit...convert to Celcius
				temp = 5 * (aTemperature - 32) / 9; 
			else
				temp = 9 * (aTemperature / 5) + 32;
			
			return temp == myTemperature;
		}
		else
			System.out.println("Invalid input...temperatures must be in different mode");
		
		return false;
	}
	
	
	//check if myTemperature is greater than argument
	public boolean isGreaterThan(double aTemperature, char aMode)
	{
		double temp;
		
		if(aMode != mode)
		{
			if(mode == 'C') //aTemperature is on Farenheit...convert to Celcius
				temp = 5 * (aTemperature - 32) / 9; 
			else
				temp = 9 * (aTemperature / 5) + 32;
			
			return temp < myTemperature;
		}
		else
			System.out.println("Invalid input...temperatures must be in different mode");
		
		return false;
	}
	
	
	public boolean isLessThan(double aTemperature, char aMode)
	{
		double temp;
		
		if(aMode != mode)
		{
			if(mode == 'C') //aTemperature is on Farenheit...convert to Celcius
				temp = 5 * (aTemperature - 32) / 9; 
			else
				temp = 9 * (aTemperature / 5) + 32;
			
			return temp > myTemperature;
		}
		else
			System.out.println("Invalid input...temperatures must be in different mode");
		
		return false;
	}
}
