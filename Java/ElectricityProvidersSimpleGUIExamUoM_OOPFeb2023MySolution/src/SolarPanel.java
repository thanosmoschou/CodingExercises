/*
 * Author: Thanos Moschou
 * Date: 02/2023
 * Description: Exams
 */


public class SolarPanel 
{
	private String brand;
	private double yearConsumption;
	
	
	public SolarPanel(String brand, double yearConsumption) 
	{
		this.brand = brand;
		this.yearConsumption = yearConsumption;
	}


	public String getBrand() 
	{
		return brand;
	}


	public double getYearConsumption() 
	{
		return yearConsumption;
	}
	
}
